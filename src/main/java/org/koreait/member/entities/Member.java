package org.koreait.member.entities;

import lombok.Data;
import org.koreait.globle.entities.BaseEntity;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("/MEMBER")
public class Member extends BaseEntity {
    private String email;
    private String password;
    private String mobile;
    private String name;
}
