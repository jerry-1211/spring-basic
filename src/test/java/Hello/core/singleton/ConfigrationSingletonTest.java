package Hello.core.singleton;

import Hello.core.AppConfig;
import Hello.core.member.MemberRepository;
import Hello.core.member.MemberServiceImpl;
import Hello.core.member.MemoryMemberRepository;
import Hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigrationSingletonTest {
    @Test
    void configurationTest(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);



        MemberRepository memberService1 = memberService.getMemberRepository();
        MemberRepository memberService2 = orderService.getMemberRepository();

        System.out.println("memberSerive -> memberRepository = " + memberService1);
        System.out.println("oderSerive -> memberRepository = " + memberService2);
        System.out.println("memberRepository = " + memberRepository);


        Assertions.assertThat(memberService1).isEqualTo(memberService2);

    }
}
