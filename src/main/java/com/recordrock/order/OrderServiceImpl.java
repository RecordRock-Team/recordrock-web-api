package com.recordrock.order;

import com.recordrock.discount.DiscountPolicy;
import com.recordrock.discount.FixDiscountPolicy;
import com.recordrock.member.Member;
import com.recordrock.member.MemberRepository;
import com.recordrock.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
