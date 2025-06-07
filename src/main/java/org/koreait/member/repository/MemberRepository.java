package org.koreait.member.repository;

import lombok.extern.java.Log;
import org.springframework.data.repository.ListCrudRepository;

import java.lang.reflect.Member;
import java.util.Optional;

public interface MemberRepository extends ListCrudRepository<Member, Log> {



    Optional<Member>fineBhEmail(String email);














}
