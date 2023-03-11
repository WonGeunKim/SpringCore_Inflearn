package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName() {

        MemberService memberService = ac.getBean("memberService", MemberService.class);

//        System.out.println("memberService = " + memberService);
//        System.out.println("memberService.getClass() = " + memberService.getClass());

        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);

    }

    @Test
    @DisplayName("이름 없이 타입으로만 조회")
    void findBeanByType() {

        MemberService memberService = ac.getBean(MemberService.class);

        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);

    }


    // 구현에 의존
    // => 좋은 것은 아님 - 유연성이 떨어짐
    // 역할에 의존해야 하기 때문에
    @Test
    @DisplayName("구체 타입으로 조회")
    void findBeanByName2() {

        MemberService memberService = ac.getBean("memberService", MemberServiceImpl.class);


        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);

    }


    // 실패 테스트
    @Test
    @DisplayName("빈 이름으로 조회x")
    void findBeanByNameX() {
//         ac.getBean("xxxx", MemberService.class);
//        MemberService xxxx = ac.getBean("xxxx", MemberService.class);

        assertThrows(NoSuchBeanDefinitionException.class, () -> ac.getBean("xxxx", MemberService.class));

    }
    
}
