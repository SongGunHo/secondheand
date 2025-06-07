package org.koreait.member.entities;

import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("/MEMBER")
public class Member {
    private String email;
    private String password;
    private String mobile;
    private String name;
}
