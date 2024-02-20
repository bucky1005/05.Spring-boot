package com.ohgiraffers.chap02requestmappinglecturesource;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class MethodMappingTestController {

    /* 설명. @RequestMapping 어노테이션의 method를 명시하지 않으면 value와 같은 주소로 들어오는 요청을 모두 해당 메소드에서 처리함
        method를 명시함으로써 Get요청의 방식만 처리하도록 설정
     */

    /* 설명. 핸들러(=Controller) 메소드
     *   어노테이션을 활용해서 요청 방식 및 경로에 따라 각각 메소드가 작성됨
     *   각 메소드는 하나의 서블릿의 개념과 유사함 */
//    @RequestMapping(value ="/menu/regist")      // GET 요청 뿐 아니라 다른 요청 방식도 처리됨
    @RequestMapping(value = "/menu/regist", method = RequestMethod.GET)  // method = requestMethod.get
    public String registMenu(Model model) {       // 응답할 페이지의 재료르 담는 객체이다
        System.out.println("/menu/regist 경로의 GET 요청 받아보기");

        /* 설명. 핸들러 메소드에서 반환하는 String 값은 templats에 있는 view(html 파일)의 이름이다. */
        model.addAttribute("message", "신규 메뉴 등록용 핸들러 메소드 호출");
        return "mappingResult";         // View Resolves에서 자동으로 해당 경로가 main/resources/templates/mappingResult.html로 인식하도록 함
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @RequestMapping("/menu/modify")
    public String getDeleteMenu(Model model) {
            model.addAttribute("messate","POST 방식의 메뉴 수정용 핸들러 메소드 호출됨");
        return "mappingTest";
    }
}
