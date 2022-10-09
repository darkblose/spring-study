package com.golfzonaca.springcorebasic;

import com.golfzonaca.springcorebasic.member.Grade;
import com.golfzonaca.springcorebasic.member.Member;
import com.golfzonaca.springcorebasic.member.MemberService;
import com.golfzonaca.springcorebasic.order.Order;
import com.golfzonaca.springcorebasic.order.OrderService;

public class OrderApp {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(member.getId(), "itemA", 20000);
        System.out.println("order : " + order);
        System.out.println("order : " + order.calculatePrice());
    }
}
