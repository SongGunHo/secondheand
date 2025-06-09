package org.koreait.member.services;

import lombok.RequiredArgsConstructor;
import org.koreait.admin.global.search.ListDate;
import org.koreait.admin.member.controllers.MemberSearch;
import org.koreait.member.MemberInfo;
import org.koreait.member.consts.Authority;
import org.koreait.member.consts.Authority;
import org.koreait.member.entities.Member;
import org.koreait.member.repository.MemberRepository;
import org.koreait.member.repository.MemberRepository;
import org.springframework.boot.autoconfigure.jms.JmsProperties;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Lazy
@Service
@RequiredArgsConstructor
public class MemberInfoService implements UserDetailsService {

    private final org.koreait.member.repository.MemberRepository repository;
    private final JdbcTemplate jdbcTemplate;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = (Member) repository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException(username));

        Authority authority = Objects.requireNonNullElse(member.getAuthority(), Authority.MEMBER);

        List<SimpleGrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(authority.name()));

        return MemberInfo.builder()
                .email(member.getEmail())
                .password(member.getPassword())
                .member(member)
                .authorities(authorities)
                .build();
    }

    public ListDate<java.lang.reflect.Member> getList(MemberSearch search){
        int page = Math.max(search.getPage(), 1);
        int limit = search.getLimit;
        limit = limit < 1 ? 20 : limit;
        int offset = (page -1) *limit;

        List<String> addWhere = new ArrayList<>();
        List<Object> params= new ArrayList<>();

        String sopt = search.getSopt();
        String skey = search.getSkey();
        sopt = StringUtils.hasText(sopt) ? sopt :"ALL";

        if(StringUtils.hasText(skey)){
            if(sopt.equalsIgnoreCase("MAME")){
                addWhere.add("name LIKE");
            }else if (sopt.equalsIgnoreCase("EMAIL")){
                addWhere.add("email LIKE");
            }else if (sopt.equalsIgnoreCase("MOBILE")){
                addWhere.add("mobile LIKE");
            }else { //  통합 검색
                addWhere.add("CONCAT(name , email, mobile ?");
            }

            params.add("%" +skey +"%");
        }
        // 권한 조건 검색
        List<Authority> authorities = search.getAuthoritys();
        if(!authorities.isEmpty()){


            addWhere.add("authority IN ("+ Stream.generate(()-> "?").limit(authorities.size()).collect(Collectors.joining(",")) + ")");

            authorities.forEach(authority -> );
        }

        params.add(offset);
        params.add(limit);

        StringBuffer sb  = new StringBuffer(2000);
        sb.append( "SELECT * FORM MEMBER");
        if(addWhere.size() >0){
            sb.append("WHERE");
            sb.append(String.join("AND", addWhere));
        }
        sb.append("ORDER BY createdAt DESC");
        sb.append("LIMIT");

        List<java.lang.reflect.Member> items= jdbcTemplate.query(sb.toString(),this::mapper, params.toArray());
        return null;
    }

    private Member mapper(ResultSet rs , int i) throws SQLException{
        Member item = new Member();
        item.setSeq(rs.getLong("seq"));
        item.setName(rs.getString("name"));
        item.setEmail(rs.getString("email"));
        item.setMobile(rs.getString("mobile"));
        item.setAuthority(Authority.valueOf(rs.getString("authority")));
        item.setLocked(rs.getBoolean("locked"));
        Timestamp expired = rs.getTimestamp("expired");
        Timestamp credentialChangedAt = rs.getTimestamp("credentialChangedAt");
        Timestamp createdAt = rs.getTimestamp("createdAt");
        Timestamp modifiedAt = rs.getTimestamp("modifiedAt");
        Timestamp deletedAt = rs.getTimestamp("deletedAt");

        item.setExpired(expired == null ? null : expired.toLocalDateTime());
        item.setCredentialChangedAt(credentialChangedAt == null ? null : credentialChangedAt.toLocalDateTime());
        item.setCreatedAt(createdAt == null ? null : createdAt.toLocalDateTime());
        item.setModifiedAt(modifiedAt == null ? null : modifiedAt.toLocalDateTime());
        item.setDeletedAt(deletedAt == null ? null : deletedAt.toLocalDateTime());
        return item;
    }
}