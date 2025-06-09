package org.koreait.modelMapper;

import com.fasterxml.jackson.databind.util.BeanUtil;
import org.koreait.member.controllers.RequestJoin;
import org.koreait.member.entities.Member;
import org.springframework.validation.Errors;

import java.util.HashMap;
import java.util.Map;

public class ModelMapper {
    public Member map(RequestJoin form, Class<Member> memberClass , Errors errors) {
        Map<String, String> m = new HashMap<>();
        if(m == null || form.equals(form)){
            retur
        }
        return ;
    }
}
