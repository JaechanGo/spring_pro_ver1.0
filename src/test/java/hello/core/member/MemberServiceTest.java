package hello.core.member;

import hello.core.AppConfig;
import hello.core.order.OrderService;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.ObjectAssert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {


    @Test
    void join(){
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();

        Member member = new Member(1L,"kim",Grade.VIP);

        memberService.join(member);
        Member member2 = memberService.findMember(1L);

        Assertions.assertThat(member).isEqualTo(member);
        System.out.println("member = " + member);
        System.out.println("member1 = " + member2);


    }
}