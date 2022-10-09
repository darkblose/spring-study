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

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
