package com.ohgiraffers.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/* 설명. 인터셉터를 사용하는 경우(목적)
*   : 로그인 체크, 권한 체크, 프로그램 실행 시간 계산 작업 로그 처리, 업로드 파일 처리, 로케일(지역) 설정 등
*   인터셉터는 같은 IoC Container에 존재하는 bean을 주입받을 수 있다.*/

@Configuration
public class StopwatchInterceptor implements HandlerInterceptor {

    /* 설명. 필터와 달리 인터셉터는 빈을 활용할 수 있다.(생성자 주입 활용) */
    /* 메모. final로 선언하는 이유 2가지
        1. 반드시 초기화하기 위해 명시적으로 표시
        2. 한번 입력된 값이 변경되지 않도록 하기 위함
     */
    private final MenuService MENUSERVICE;

    @Autowired
    public StopwatchInterceptor(MenuService MENUSERVICE){
        this.MENUSERVICE = MENUSERVICE;     // DI를 통해 new를 사용하지 않고 생성자 주입을 한 것
    }

    /* 설명. 반환되는 boolean형에 따라 핸들러 메소드의 실행 여부를 선택할 수 있으며 핸들러 메소드 이전 전처리 목적이다. */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /* 설명. 핸들러 인터셉터는 빈을 활용할 수 있다.(@Service 계층의 객체도 bean이다.) */
//        MENUSERVICE.method();
        System.out.println("preHandle 호출함...(핸들러 메소드 이전)");

        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);

        /* 설명. 반환형을 false로 하면 특정 조건에 의해 이후 핸들러 메소더가 실행되지 않게 할 수도 있다. */
//        return false;
        return true;
    }
    
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle 호출함...(핸들러 메소드 이후)");

        long startTIme = (long)request.getAttribute("startTime");
        long endTime = System.currentTimeMillis();

        request.removeAttribute("startTime");

        /* 설명. 핸들러 메소드가 동작하는데 걸린 시간을 ModelAndView에 전달, ViewResorver에서 해당 값을 활용할 수 있도록 함. */
        /* 메모. 핸들러가 반환한 값들은 전부 modelAndView로 넘어옴 */
        modelAndView.addObject("interval", endTime - startTIme);        // 동작 시간 = endTime - startTIme

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
