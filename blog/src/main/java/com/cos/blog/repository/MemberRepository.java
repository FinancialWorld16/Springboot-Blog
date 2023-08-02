package com.cos.blog.repository;

import com.cos.blog.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

//DAO
//자동으로 Bean 등록이 된다! (@Repository 생략 가능)
public interface MemberRepository extends JpaRepository<Member, Long> {

}
