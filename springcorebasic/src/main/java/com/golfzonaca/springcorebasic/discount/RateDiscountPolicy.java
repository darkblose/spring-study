package com.golfzonaca.springcorebasic.discount;

import com.golfzonaca.springcorebasic.member.Grade;
import com.golfzonaca.springcorebasic.member.Member;

public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        } else {
            return 0;
        }
    }
}