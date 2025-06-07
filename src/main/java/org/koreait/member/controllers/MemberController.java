package org.koreait.member.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.koreait.member.entities.Member;
import org.koreait.member.service.JoinService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

import static org.apache.coyote.http11.Constants.a;

@Controller
@RequestMapping("/member")
public class MemberController {


    private Member member;
    private JoinService service;




    @GetMapping("/join")
    public String join(){
        return "templment/member/join";
    }


    @GetMapping("/login")
    public String login(@ModelAttribute HttpServletRequest request, HttpSession session, RequestJoin form ){
        session.setAttribute("form", form);
        return "temoment/member/login";
    }


    @PostMapping("/loginPs")
    public String loginPs( Model model, @ModelAttribute RequestLogin form , Error erre, HttpSession session){

        List<Member> login = new ArrayList<>();
        if(login !=null && login.equals(join())){
            session.setAttribute("login",  login);
            return "rdirect:/member/login ";
        } else {
            return "/main/index";
        }

    }

    @GetMapping("/loginEr")
    public String LoginEr(){

    }










}
