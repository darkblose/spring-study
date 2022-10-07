package com.golfzonaca.springintroduction;

import com.golfzonaca.springintroduction.aop.TimeTraceAop;
import com.golfzonaca.springintroduction.repository.*;
import com.golfzonaca.springintroduction.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 자바 코드로 직접 스프링 빈 등록하기

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    @Autowired // 생략 가능
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

//    @Bean
//    public TimeTraceAop tImeTraceAop() {
//        return new TimeTraceAop();
//    }

}
