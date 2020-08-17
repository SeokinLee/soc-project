/*package com.seokin.book.springboot.web;

import com.seokin.book.springboot.config.auth.SecurityConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)//SpringRunner(스프링실행자) 사용, 스프링부트와 JUnit 사이 연결자 역할
@WebMvcTest(controllers = HelloController.class, //스프링 Mvc 집중 테스트 어노테이션
        excludeFilters = {
                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = SecurityConfig.class)
        }
)
public class HelloControllerTest {
    @Autowired//스프링이 관리하는 Bean을 주입받음
    private MockMvc mvc;//웹 API를 테스트할 때 사용, 스프링 MVC테스트의 시작점, HTTP GET, POST 등에 대한 API 테스트

    @WithMockUser(roles="USER")
    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))//MockMvc를 통해 /hello 주소로 HTTP GET 요청, 여러 검증 기능 이어서 선언 가능(체이닝 지원)
                .andExpect(status().isOk())//200,404,500 등의 상태를 검증
                .andExpect(content().string(hello));//응답 본문의 내용 검증("hello"가 맞는지 검증)
    }

    @WithMockUser(roles="USER")
    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                get("/hello/dto")
                        .param("name", name)//API 테스트할 때 사용될 요청 파라미터를 설정, String만 허용
                        .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))//JSON 응답값을 필드별로 검증할 수 있는 메소드, $를 기준으로 필드명 명시
                .andExpect(jsonPath("$.amount", is(amount)));
    }
}*/