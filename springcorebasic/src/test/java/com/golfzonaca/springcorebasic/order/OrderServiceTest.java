package com.golfzonaca.springcorebasic.order;

import com.golfzonaca.springcorebasic.member.Grade;
import com.golfzonaca.springcorebasic.member.Member;
import com.golfzonaca.springcorebasic.member.MemberService;
import com.golfzonaca.springcorebasic.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class OrderServiceTest {

    private final MemberService memberService = new MemberServiceImpl();
    private final OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder() {

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(member.getId(), "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);


    }
}