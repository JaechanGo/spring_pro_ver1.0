package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class RateDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount = 10;


    @Override
    public int discount(Member member, int price) {
        if(Grade.VIP == member.getGrade()){
            discountFixAmount = price * discountFixAmount/100;
            return discountFixAmount;
        }else{
            return 0;
        }
    }
}
