package org.koreait.admin.member.controllers;

import lombok.RequiredArgsConstructor;
import org.koreait.admin.golal.controllers.CommonController;
import org.koreait.global.search.ListDate;
import org.koreait.member.services.MemberInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Member;

@RequiredArgsConstructor
@Controller
@RequestMapping("/admin/member")
public class MemberController extends CommonController {
    private final MemberInfoService service;



    @Override
    public String mainCode() {
        return "member";
    }



    @GetMapping({"", "/list"})
    public String list(@ModelAttribute MemberSearch search, Model model){
        commonProcess("list", model);
        ListDate< Member> data = service.getList(search);
        model.addAttribute("items", data.getItems());
        model.addAttribute("pagination", data.getPagination());




        return "admin/member/list";
    }

    /**
     * 컨트롤러 공통처리
     *
     */


    private void commonProcess(String code, Model model){
        code = StringUtils.hasText(code) ? code :"list";
        String pageTitle ="";
        if(code.equals("list")){
            pageTitle ="회원 목록";

        }

        model.addAttribute("pageTitle", pageTitle);
        model.addAttribute("subCode", code);
    }
}
