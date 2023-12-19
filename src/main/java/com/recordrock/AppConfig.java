package com.recordrock;

import com.recordrock.discount.DiscountPolicy;
import com.recordrock.discount.FixDiscountPolicy;
import com.recordrock.discount.RateDiscountPolicy;
import com.recordrock.member.MemberService;
import com.recordrock.member.MemberServiceImpl;
import com.recordrock.member.MemoryMemberRepository;
import com.recordrock.order.OrderService;
import com.recordrock.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public static MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }
}
