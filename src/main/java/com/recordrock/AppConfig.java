package com.recordrock;

import com.recordrock.discount.DiscountPolicy;
import com.recordrock.discount.FixDiscountPolicy;
import com.recordrock.discount.RateDiscountPolicy;
import com.recordrock.member.MemberService;
import com.recordrock.member.MemberServiceImpl;
import com.recordrock.member.MemoryMemberRepository;
import com.recordrock.order.OrderService;
import com.recordrock.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    private static MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }
}
