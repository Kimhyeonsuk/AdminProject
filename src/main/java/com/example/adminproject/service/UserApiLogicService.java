package com.example.adminproject.service;

import com.example.adminproject.ifs.CrudInterface;
import com.example.adminproject.model.entity.User;
import com.example.adminproject.model.network.Header;
import com.example.adminproject.model.network.request.UserApiRequest;
import com.example.adminproject.model.network.response.UserApiResponse;
import com.example.adminproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserApiLogicService implements CrudInterface<UserApiRequest, UserApiResponse> {

    @Autowired
    private UserRepository userRepository;

    //1.request data를 가져옴
    //2. user 생성
    //3. 생성된 데이터 -> userApiResponse return
    @Override
    public Header<UserApiResponse> create(Header<UserApiRequest> request) {
        //1.reqeust data 가져온다
        UserApiRequest userApiRequest=request.getData();

        //2. User 생성
        User user=User.builder()
                .account(userApiRequest.getAccount())
                .password(userApiRequest.getPassword())
                .status("REGISTERED")
                .phoneNumber(userApiRequest.getPhoneNumber())
                .email(userApiRequest.getEmail())
                .registeredAt(LocalDateTime.now())
                .build();
        User newUser=userRepository.save(user);

        //3. 생성된 데이터 -> userApiResponse return
        return response(newUser);
    }

    @Override
    public Header<UserApiResponse> read(Long id) {
        // id 로 reposiroty를 통해서 getOne, getById를 통해서 데이터 얻음
        Optional<User> optional=userRepository.findById(id);

        //위 아래 합쳐서 나온 코드
       /* return userRepository.findById(id)
                .map(user->response(user))//map 다른 return 형태로 바꿔준다
                .orElseGet(()->Header.ERROR(" 데이터 없음"));//user가 없다면 header에 error을 넘기면서 data return*/
        
        
        //user -> userApiResponse return
        return optional
                .map(user->response(user))//map 다른 return 형태로 바꿔준다
                .orElseGet(()->Header.ERROR(" 데이터 없음"));//user가 없다면 header에 error을 넘기면서 data return

    }

    @Override
    public Header<UserApiResponse> update(Header<UserApiRequest> request) {
       //1.data
        UserApiRequest userApiRequest=request.getData();
        //2. id-> user 데이터를 찾고
        Optional<User> optional=userRepository.findById(userApiRequest.getId());

        return optional.map(user->{
            //3. data -> update
            // id
            user.setAccount(userApiRequest.getAccount())
                    .setStatus(userApiRequest.getPassword())
                    .setPhoneNumber(userApiRequest.getPhoneNumber())
                    .setEmail(userApiRequest.getEmail())
                    .setRegisteredAt(userApiRequest.getRegisteredAt())
                    .setUnregisteredAt(userApiRequest.getUnregisteredAt());

            return user;
        })
        .map(user->userRepository.save(user))       //update -> newUser
        .map(user->response(user))                  //userApiResponse
        .orElseGet(()->Header.ERROR("데이터 없음"));
    }

    @Override
    public Header delete(Long id) {
        //1. id -> repository -> user
        Optional <User> optional=userRepository.findById(id);

        //2. repository  -> delete
        return optional.map(user->{
            userRepository.delete(user);
            return Header.OK();
        }).orElseGet(()->Header.ERROR("데이터 없음"));
        //3. response return
    }

    private Header<UserApiResponse> response(User user){
        //user 객체로 userapiResponse로 만들어서 리턴해 준다

        UserApiResponse userApiResponse=UserApiResponse.builder()
                .id(user.getId())
                .account(user.getAccount())
                .password(user.getPassword())//todo 암호화, 길이
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .status(user.getStatus())
                .registeredAt(user.getRegisteredAt())
                .unregisteredAt(user.getUnregisteredAt())
                .build();

        // Header + data return

        return Header.OK(userApiResponse);
    }
}
