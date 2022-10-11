package com.golfzonaca.springcorebasic;

import com.golfzonaca.springcorebasic.discount.DiscountPolicy;
import com.golfzonaca.springcorebasic.discount.FixDiscountPolicy;
import com.golfzonaca.springcorebasic.discount.RateDiscountPolicy;
import com.golfzonaca.springcorebasic.member.MemberRepository;
import com.golfzonaca.springcorebasic.member.MemberService;
import com.golfzonaca.springcorebasic.member.MemberServiceImpl;
import com.golfzonaca.springcorebasic.member.MemoryMemberRepository;
import com.golfzonaca.springcorebasic.order.OrderService;
import com.golfzonaca.springcorebasic.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
