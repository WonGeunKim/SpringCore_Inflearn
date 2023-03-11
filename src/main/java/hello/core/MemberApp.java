package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {

//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
        // MemberServiceImpl 이 들어가있음

//        MemberService memberService = new MemberServiceImpl();

        // 스프링
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        // AppConfig에 있는 환경설정 정보를 가지고 @Bean 붙은걸 스프링 컨테이너에 넣어서 관리해줌

        // 스프링 컨테이너를 통해서 찾아옴
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        // (이름, 타입)

        Member member = new Member(1L, "memberA", Grade.VIP);

        memberService.join(member);


        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member);
        System.out.println("findMember = " + findMember);
        
    }


}
