package hello.core;

import hello.core.member.*;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();
        
        Member member = new Member(1L,"kim",Grade.VIP);
        memberService.join(member);
        Order order = orderService.CreateOrder(member.getId(),"아이스",3000);
        System.out.println("Order = " + order);
        System.out.println("Order.calculatePrice() = " + order.calculatePrice());


    }
}
