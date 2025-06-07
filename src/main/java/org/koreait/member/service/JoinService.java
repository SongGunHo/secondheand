package org.koreait.member.service;

import jakarta.servlet.http.HttpServletRequest;
import org.koreait.member.controllers.RequestJoin;
import org.koreait.member.entities.Member;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Lazy
@Service
public class JoinService {
        private  Member member;
        private HttpServletRequest request;
        private RequestJoin form;







}
