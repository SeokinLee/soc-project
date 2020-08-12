/* 메인 클래스 */
package com.seokin.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
//스프링부트 자동설정, 스프링 Bean 읽기와 생성을 모두 자동으로 설정, 항상 프로젝트 최상단에 위치
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);//내장 WAS 실행
    }
}
