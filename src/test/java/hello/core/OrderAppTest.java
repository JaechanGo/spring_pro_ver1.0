package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.*;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Or;

import static org.junit.jupiter.api.Assertions.*;

class OrderAppTest {

    AppConfig appConfig = new AppConfig();
    MemberService memberService = appConfig.memberService();
    OrderService orderService = appConfig.orderService();

    MemberRepository memberRepository = new MemoryMemberRepository();
    DiscountPolicy discountPolicy = new FixDiscountPolicy();
    
    
    @Test
    void Order(){
        Member member = new Member(1L,"kim", Grade.VIP);
        memberService.join(member);
        Member byId = memberRepository.findById(1L);

        Order order = orderService.CreateOrder(member.getId(), "ice", 20000);
        int price = order.calculatePrice();
        System.out.println("price = " + price);


    }

}