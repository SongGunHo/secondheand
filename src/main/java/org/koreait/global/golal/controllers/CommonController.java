package org.koreait.global.golal.controllers;

import org.springframework.web.bind.annotation.ModelAttribute;

public abstract class CommonController {
    @ModelAttribute("mainCode")
    public abstract String mainCode();
}
