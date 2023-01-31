package org.sansovo.demo.springmvc.chapter13.fake;

import org.sansovo.demo.springmvc.chapter13.dao.MemberDAO;
import org.sansovo.demo.springmvc.chapter13.model.Member;

import java.util.ArrayList;
import java.util.List;

public class MemberDAOFake implements MemberDAO {
    private List<Member> members = new ArrayList<>();
        
    @Override
    public void add(Member member) {
        members.add(member);
    }

    @Override
    public List<Member> getMembers() {
        return members;
    }
}