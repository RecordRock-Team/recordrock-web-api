package com.recordrock;

import com.recordrock.member.Grade;
import com.recordrock.member.Member;
import com.recordrock.member.MemberService;
import com.recordrock.member.MemberServiceImpl;
import com.recordrock.order.Order;
import com.recordrock.order.OrderService;
import com.recordrock.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();


        MemberService memberService = new MemberServiceImpl(null);
        OrderService orderService = new OrderServiceImpl(null, null);

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);

        memberService.join(member);

        Order orderA = orderService.createOrder(member.getId(), "itemA", 10000);
        System.out.println("orderA = " + orderA);
        System.out.println("orderA.calculatePrice() = " + orderA.calculatePrice());
    }
}
