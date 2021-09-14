package com.hanmaum.counseling.api.argumentresolver;

import com.hanmaum.counseling.security.CustomUserDetails;
import org.springframework.core.MethodParameter;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.util.Objects;

public class LoginUserIdArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        boolean hasLoginParam = parameter.hasParameterAnnotation(LoginUserId.class);
        boolean assignableFrom = Long.class.isAssignableFrom(parameter.getParameterType());

        return hasLoginParam && assignableFrom;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (Objects.isNull(auth)) {
            throw new AuthenticationCredentialsNotFoundException("현재 유효한 사용자가 없습니다!");
        }
        return ((CustomUserDetails)auth.getPrincipal()).getId();
    }
}
