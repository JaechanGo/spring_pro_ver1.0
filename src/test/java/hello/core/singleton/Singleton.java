package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Singleton {

    @Test
    @DisplayName("No Spring")
    void pureContainer(){
        AppConfig appConfig = new AppConfig();
        MemberService memberService1 = appConfig.memberService();

        System.out.println("memberService = " + memberService1);
        MemberService memberService2 = appConfig.memberService();
        System.out.println("memberService2 = " + memberService2);
        Assertions.assertThat(memberService1).isNotEqualTo(memberService2);
    }

    public static void main(String[] args) {
        SingletonService singletonService = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();
        Assertions.assertThat(singletonService).isEqualTo(singletonService2);

    }
}
