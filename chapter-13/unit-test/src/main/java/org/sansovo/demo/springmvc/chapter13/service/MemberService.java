package org.sansovo.demo.springmvc.chapter13.service;

import org.sansovo.demo.springmvc.chapter13.model.Member;

import java.util.List;

public interface MemberService {
    public void add(Member member);

    public List<Member> getMembers();

}