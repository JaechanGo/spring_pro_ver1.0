package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

class ApplicationContextSameBeanFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfigTest.class);

    @Test
    @DisplayName("타입 조회시 같은 빈의 경우 오류 발생")
    void findAllBean(){
        Assertions.assertThrows(NoUniqueBeanDefinitionException.class,()->ac.getBean(MemberRepository.class));

    }

    @Test
    @DisplayName("타입 둘 이상시 빈이름 지정")
    void findBeanName(){
        MemberRepository memberRepository = ac.getBean("memberRepository1",MemoryMemberRepository.class);
        org.assertj.core.api.Assertions.assertThat(memberRepository).isInstanceOf(MemberRepository.class);
//        Assertions.assertThrows(NoUniqueBeanDefinitionException.class,()->ac.getBean("memberRepository1",MemberRepository.class));
    }

    @Test
    @DisplayName("특정 타입을 모두 꺼내기")
    void findAllBeanBy(){
        Map<String, MemberRepository> beansOfType = ac.getBeansOfType(MemberRepository.class);
        for (String key : beansOfType.keySet()) {
            System.out.println("key= "+ key+ "    /     value=" +beansOfType.get(key));
        }
        System.out.println("beansOfType = " + beansOfType);
        org.assertj.core.api.Assertions.assertThat(beansOfType.size()).isEqualTo(2);
    }

    @Configuration
    static class AppConfigTest {

        @Bean
        public MemberRepository memberRepository1() {
            return new MemoryMemberRepository();
        }

        @Bean
        public MemberRepository memberRepository2() {
            return new MemoryMemberRepository();
        }
    }

}
