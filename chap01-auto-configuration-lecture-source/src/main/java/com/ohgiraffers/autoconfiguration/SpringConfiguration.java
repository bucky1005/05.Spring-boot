package com.ohgiraffers.autoconfiguration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class SpringConfiguration {

    /* 메모. 설정 파일을 여러개로 관리하면 어떤 파일을 참조하여 값을 가져오는지 혼동이 올 수 있으므로 하나만 사용하는 것이 좋다. */
    /* 설명. yml(= yaml)의 장점
         1. 들여쓰기로 상위와 하위 카테고리 개념을 나눌 수 있다.
         2. 한글을 기본적으로 지원하여 인코딩 설정에 대한 번거로움이 없다.
         3. 주석을 # 하나만 다는걸로 통일하여 간단하다 */
    @Value("${test.value}")     // 외부 파일(properties, xml, yml 파일 등)의 값을 받아올 때 사용하는 어노테이션(캡슐화)
    public String value;

    @Value("${test.age}")
    public String age;

    @Value("${test.array}")
//    public List<String> list;
    public String[] arr;

    @Bean
    public Object propertyReadTest() {
        System.out.println("value = " + value);
        System.out.println("age = " + age);

        System.out.println("======== 설정에서 읽어들인 여러 값 처리 ========");
//        list.forEach(System.out::println);
        Arrays.stream(arr).forEach(System.out::println);

        return new Object();
    }
}
