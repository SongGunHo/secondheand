package org.koreait.globle.libs;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.koreait.member.Authority;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.lang.reflect.Member;

@Lazy
@Component
public class MemberUtils {






    public boolean isLogin(){
        return getMember() != null;
    }

    public Member getMember() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.getPrincipal() instanceof MemberInfo memberInfo) {
            return memberInfo.getMember();
        }

        return null;
    }


    public boolean isAdmin(){

        return isLogin() && getMember().getAuthority = Authority.ADMIM;
    }


}
