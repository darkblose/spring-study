package com.golfzonaca.springcorebasic;

import com.golfzonaca.springcorebasic.discount.DiscountPolicy;
import com.golfzonaca.springcorebasic.discount.FixDiscountPolicy;
import com.golfzonaca.springcorebasic.discount.RateDiscountPolicy;
import com.golfzonaca.springcorebasic.member.MemberRepository;
import com.golfzonaca.springcorebasic.member.MemberService;
import com.golfzonaca.springcorebasic.member.MemberServiceImpl;
import com.golfzonaca.springcorebasic.member.MemoryMemberRepository;
import com.golfzonaca.springcorebasic.order.OrderService;
import com.golfzonaca.springcorebasic.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    /**
     * @Bean memberService -> new MemoryMemberRepository()
     * @Bean orderService -> new MemoryMemberRepository()
     * 이 경우, 싱글톤이 깨질까? 유지될까?
     *  -> 같은 인스턴스가 조회된다.
     *  따라서, 모든 인스턴스가 공유되어 사용된다.
     *
     *  출력 예상
     *  call AppConfig.memberService
     *  call AppConfig.memberRepository
     *  call AppConfig.memberRepository
     *  call AppConfig.orderService
     *  call AppConfig.memberRepository
     *
     *  실제 출력
     *  call AppConfig.memberService
     *  call AppConfig.memberRepository
     *  call AppConfig.orderService
     *
     *  그렇다면, @Configuration 없이 @Bean만 선언하면 어떻게 될까?
     *  -> CGLIB로 조작되지 않은 AppConfig가 호출된다.
     *  -> 하지만, 싱글톤이 깨진다.
     *  -> 긱자 다른 인스턴스를 생성하여 사용한다.
     *  -> 스프링 컨테이너가 관리하지 않는, new MemberRepository()로 생성한 것과 동일한 결과가 발생한다.
     */

    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
