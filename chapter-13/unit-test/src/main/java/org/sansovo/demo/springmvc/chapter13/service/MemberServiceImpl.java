package org.sansovo.demo.springmvc.chapter13.service;

import org.sansovo.demo.springmvc.chapter13.dao.MemberDAO;
import org.sansovo.demo.springmvc.chapter13.model.Member;

import java.util.List;

public class MemberServiceImpl implements MemberService {

    private MemberDAO memberDAO;

    public MemberServiceImpl()
    {}

    public MemberServiceImpl(MemberDAO memberDAOArg){
        this.memberDAO = memberDAOArg;
    }
    public void setMemberDAO(MemberDAO memberDAOArg) {
        this.memberDAO = memberDAOArg;
    }

    @Override
    public void add(Member member) {
        memberDAO.add(member);
    }

    @Override
    public List<Member> getMembers() {
        return memberDAO.getMembers();
    }

}