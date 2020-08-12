package com.seokin.book.springboot.config.auth;

import com.seokin.book.springboot.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity//Spring Security 설정 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable()//h2-console화면 사용하기 위해 해당 옵션 disable
                .and()
                    .authorizeRequests()//URL별 권한 관리를 설정하는 옵션의 시작점
                    //antMatchers : 권한 관리 대상을 지정하는 옵션
                    .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**", "/profile").permitAll()
                    .antMatchers("/api/v1/**").hasRole(Role.USER.name())//USER권한을 가진 사람만 가능
                    .anyRequest().authenticated()//설정된 값 이외 나머지 URL들을 나타냄, authenticated()으로 인증된 사람에게만 허용
                .and()
                    .logout()
                        .logoutSuccessUrl("/")//로그아웃 기능에 대한 여러 설정의 진입점, 성공시 / 주소로 이동
                .and()
                    .oauth2Login()//OAuth2 로그인 기능에 대한 여러 설정의 진입점
                        .userInfoEndpoint()//로그인 성공 후 사용자 정보를 가져올 때의 설정들을 담당
                            .userService(customOAuth2UserService);//로그인 성공 시 후속 조치를 진행할 UserService 인터페이스의 구현체를 등록,
                                                                  //리소스 서버(구글)에서 사용자 정보를 가져온 상태에서 추가로 진행하고자 하는 기능 명시

    }
}