package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 스프링으로 전환
@Configuration
public class AppConfig {

    // @Bean memberService -> new MemoryMemberRepository()
    // @Bean orderSerivece -> new MemoryMemberRepository()

    // 예상
    // call AppConfig.memberService
    // call AppConfig.memberRepository
    // call AppConfig.memberRepository
    // call AppConfig.orderService
    // call AppConfig.memberRepository

    // 실제
    // call AppConfig.memberService
    // call AppConfig.memberRepository
    // call AppConfig.orderService
    // =>  스프링이 싱글톤 보장


    // AppConfig는 애플리케이션의 실제 동작에 필요한 구현 객체를 생성한다
    // AppConfig는 생성한 객체 인스턴스의 참조(레퍼런스)를 생성자를 통해서 주입(연결)해준다


    // AppConfig 를 보면 역할과 구현 클래스가 한눈에 들어온다. 애플리케이션 전체 구성이 어떻게 되어있는지
    //빠르게 파악할 수 있다.

    // 생성자 주입

    // 스프링 컨테이너에 등록
    @Bean
    public MemberService memberService() {

       System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemoryMemberRepository memberRepository() {

        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {

        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
//        return null;
    }


    // 이제 할인 정책을 변경해도, 애플리케이션의 구성 역할을 담당하는 AppConfig만 변경하면 된다.

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }



}
