package hello.core.discount;

import hello.core.AppConfig;
import hello.core.member.*;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Or;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    AppConfig appConfig = new AppConfig();
    MemberService memberService = appConfig.memberService();
    OrderService orderService = appConfig.orderService();

    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("ViP는 10할인적용")
    void test(){
        Member member = new Member(1L,"kim", Grade.VIP);
        int discount = rateDiscountPolicy.discount(member, 20000);
        System.out.println("discount = " + discount);
        memberService.join(member);
        Order order = new Order(1L, "ice", 20000,discount);
        int price = order.calculatePrice();
        System.out.println("price = " + price);


    }

    @Test
    @DisplayName("ViP는 10할인적용2")
    void test2(){

        Member member = new Member(1L,"kim",Grade.VIP);
        memberService.join(member);;
        int discount = rateDiscountPolicy.discount(member, 12345);
        Order order = new Order(member.getId(),"Ice",12345,discount);
        System.out.println("order = " + order);
        int price = order.calculatePrice();
        System.out.println("order = " + price);



    }

}