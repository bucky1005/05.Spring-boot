package com.ohgiraffers.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/* 설명. Interceptor 추가 및 static(정적) 리소스 호출 경로 등록 설정
    : 프론트 단에서 우리가 가지고 있는 static의 정적 메소드를 사용하고자 할 때 어떻게 사용할지 세팅하기 위한 목적 */
@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    private StopwatchInterceptor stopwatchInterceptor;

    /* 설명. 생성자 주입: 사용하고자 하는 인터셉트를 DI로 주입 받아와야 함 */
    @Autowired
    public WebConfiguration(StopwatchInterceptor stopwatchInterceptor) {
        this.stopwatchInterceptor = stopwatchInterceptor;
    }

    /* 설명. interceptor를 따로 여기서 등록해주어야 실제로 동작하는 interceptor가 된다. */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(stopwatchInterceptor)  // 사용하고자 하는 interceptor를 등록
                .excludePathPatterns("/css/**");       // excludePathPatterns을 등록해 준 경로의 요청은 인터셉터가 가로채지 않음.
                                                       // 즉, resource의 static 영역에 있는 css 디렉토리에 interceptor가 적용되지 않도록 함.

    }
}
