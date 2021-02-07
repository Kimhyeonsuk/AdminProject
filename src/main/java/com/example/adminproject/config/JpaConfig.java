package com.example.adminproject.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration//설정파일에 대한 내용
@EnableJpaAuditing//jpa에 대해 감시를 활성화 시키겠다
public class JpaConfig {

}
