package hello.core;

import hello.core.member.*;

public class MemberApp {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();

        Member member = new Member(1L, "member1", Grade.VIP);
        memberService.join(member);

        Member find = memberService.findMember(1L);
        System.out.println("find = " + find.getName());



    }
}
