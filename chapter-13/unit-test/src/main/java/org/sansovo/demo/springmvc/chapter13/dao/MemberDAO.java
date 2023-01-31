package org.sansovo.demo.springmvc.chapter13.dao;

import org.sansovo.demo.springmvc.chapter13.model.Member;

import java.util.List;

public interface MemberDAO {
    void add(Member member);
    List<Member> getMembers();
}
