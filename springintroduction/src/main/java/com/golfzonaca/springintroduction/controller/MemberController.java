package com.golfzonaca.springintroduction.controller;

import com.golfzonaca.springintroduction.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired // 스프링 컨테이너(Bean)에 있는 MemberService 와 연결해주는 어노테이션. -> Dependency Injection
    public MemberController(MemberService memberService) { // DI : 생성자 주입
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    /*

     * DI : 필드 주입 - 도중에 변경할 수 없음
     @Autowired private MemberService memberService;

     * DI: setter 주입 - public으로 지속적인 노출되어있음
     @Autowired public void setMemberService(MemberService memberService) {
     this.memberService = memberService;
     }

     */
}
