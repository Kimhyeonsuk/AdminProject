package com.example.adminproject.component;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class LoginUserAuditorAware implements AuditorAware<String> {//로그인한 사용자를 감시
    @Override
    public Optional<String> getCurrentAuditor() {//현재의 감시자는 createdby, updatedby가 일어날때 어떤 이름을 주겠다는함수
        return Optional.of("AdminServer");
    }
}
