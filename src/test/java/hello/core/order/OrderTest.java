package hello.core.order;

import hello.core.AppConfig;
import hello.core.member.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {
    AppConfig appConfig = new AppConfig();
    MemberService memberService = appConfig.memberService();
    OrderService orderService = appConfig.orderService();

    @Test
    void createOrder(){
        Member member = new Member(1L,"kim", Grade.VIP);
        memberService.join(member);
        Order order = orderService.CreateOrder(member.getId(), "아으시", 40000);
        System.out.println("order = " + order);
        System.out.println("member = " + member);

        System.out.println("order = " + order.calculatePrice());

    }



}