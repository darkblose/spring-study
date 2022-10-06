package com.golfzonaca.springintroduction;

import com.golfzonaca.springintroduction.repository.MemberRepository;
import com.golfzonaca.springintroduction.repository.MemoryMemberRepository;
import com.golfzonaca.springintroduction.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 자바 코드로 직접 스프링 빈 등록하기

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
