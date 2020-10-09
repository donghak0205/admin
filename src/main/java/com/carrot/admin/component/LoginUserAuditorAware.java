package com.carrot.admin.component;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class LoginUserAuditorAware implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("DongDong"); //로그인자 아이디를 넣어준다.
    }
}
