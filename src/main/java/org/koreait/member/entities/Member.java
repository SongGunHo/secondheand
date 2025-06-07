package org.koreait.member.entities;

import lombok.Data;
import org.koreait.globle.entities.BaseEntity;
import org.koreait.member.Authority;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@Table("/MEMBER")
public class Member extends BaseEntity {
    private String email;
    private String password;
    private String mobile;
    private String name;
    private Authority authority = Authority.MEMBER;
    @Column("/termsAgree")
    private boolean termsAgree;
    private boolean locked;
    private LocalDateTime expired;
    @Column("/credentialChangedAt")
    private LocalDateTime credentialChangedAt;




}
