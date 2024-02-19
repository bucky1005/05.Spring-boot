package com.ohgiraffers.autoconfiguration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Chap01AutoConfigurationLectureSourceApplication {

    /* 수업목표. 스프링부트의 설정 파일을 사용하고 이해할 수 있다. */
    /* 설명. 스프링부트는 설정 파일을 통해 대부분의 설정을 자동으로 할 수 있다. */
    public static void main(String[] args) {
        /* 메모. 아래 코드로 인해 발생하는 일들
            1. main이 실행됨과 동시에 Tomcat이 실행됨
            2. Servlet 컨테이너가 생성됨
            3. Spring 컨테이너가 생성됨 */

        SpringApplication.run(Chap01AutoConfigurationLectureSourceApplication.class, args);
    }

}
