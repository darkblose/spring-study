package com.golfzonaca.springintroduction;

import com.golfzonaca.springintroduction.repository.JdbcMemberRepository;
import com.golfzonaca.springintroduction.repository.JdbcTemplateMemberRepository;
import com.golfzonaca.springintroduction.repository.MemberRepository;
import com.golfzonaca.springintroduction.repository.MemoryMemberRepository;
import com.golfzonaca.springintroduction.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import javax.xml.crypto.Data;

// 자바 코드로 직접 스프링 빈 등록하기

@Configuration
public class SpringConfig {

    /**
     * 방법 1
     *
     * @Autowired DataSource dataSource;
     */

    // 방법 2

    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    // 방법 2

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource);
        return new JdbcTemplateMemberRepository(dataSource);
    }
}
