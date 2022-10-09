package com.golfzonaca.springcorebasic.discount;

import com.golfzonaca.springcorebasic.member.Grade;
import com.golfzonaca.springcorebasic.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {

    private int discountFixAmout = 1000; // 1,000원 할인

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return discountFixAmout;
        } else {
            return 0;
        }
    }
}
