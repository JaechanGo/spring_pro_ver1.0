package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{
    MemberRepository memberRepository = new MemoryMemberRepository();
    DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order CreateOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(member.getId(),itemName,itemPrice,discountPrice);
    }
}