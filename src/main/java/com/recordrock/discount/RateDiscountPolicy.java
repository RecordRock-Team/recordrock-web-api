package com.recordrock.discount;

import com.recordrock.member.Member;

public class RateDiscountPolicy implements DiscountPolicy{
    private int discountFixAmount = 1000; // 1000원 할인

    @Override
    public int discount(Member member, int price) {
        return 0;
    }
}
