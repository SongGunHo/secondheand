package org.koreait.member.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.koreait.member.entities.Member;
import org.koreait.member.service.JoinService;
import org.koreait.member.service.LoginFailureHandler;
import org.koreait.member.service.LoginSuccessHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.naming.ldap.PagedResultsControl;
import java.util.ArrayList;
import java.util.List;



@Controller
@RequestMapping("/member")
public class MemberController {


    private Member member;
    private JoinService service;
    private LoginSuccessHandler successHandler;
    private LoginFailureHandler loginFailureHandler;




    @GetMapping("/join")
    public String join(){
        return "templment/member/join";
    }


    @GetMapping("/login")
    public String login(@ModelAttribute HttpServletRequest request, HttpSession session, RequestJoin form ){
        session.setAttribute("form", form);

        service.process(form);

        return "temoment/member/login";

    }


    @PostMapping("/loginPs")
    public String loginPs( Model model, @ModelAttribute RequestLogin form , Error erre, HttpSession session){

        List<Member> login = new ArrayList<>();
        if(login !=null && login.equals(join())){
            session.setAttribute("l", login);
            successHandler.onAuthenticationSuccess(form);
            return "rdirect:/member/login ";
        } else {
            return "/main/index";
        }

    }

    @GetMapping("/loginEr")
    public String LoginEr(@Valid RequestJoin form, BindingResult result, HttpSession session ){
        List<Member> m = new ArrayList<>();
        if(result.hasErrors()){
                loginFailureHandler.onAuthenticationFailure(m);
                return "message/errors.properties";
        }
        if(m.isEmpty()){
            session.setAttribute("s", s);
            return "main/index";
        }
        return null;

    }


    @GetMapping("/password")
    public String password(){
        successHandler.pa();
        return "templates/member/join";
    }














}
