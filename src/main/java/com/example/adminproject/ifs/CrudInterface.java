package com.example.adminproject.ifs;

import com.example.adminproject.model.network.Header;
import com.example.adminproject.model.network.request.UserApiRequest;
import com.example.adminproject.model.network.response.UserApiResponse;

public interface CrudInterface<Req,Res> {
    Header<Res> create(Header<Req> request);  //todo request object 추가

    Header<Res> read(Long id);

    Header<Res>  update(Header<Req> request);

    Header<Res>  delete(Long id);
}
