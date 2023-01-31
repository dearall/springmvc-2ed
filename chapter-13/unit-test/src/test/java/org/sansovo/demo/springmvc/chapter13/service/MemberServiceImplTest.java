package org.sansovo.demo.springmvc.chapter13.service;

import org.sansovo.demo.springmvc.chapter13.dao.MemberDAO;
import org.sansovo.demo.springmvc.chapter13.fake.MemberDAOFake;
import org.sansovo.demo.springmvc.chapter13.model.Member;
import org.junit.Assert;
import org.junit.Test;

public class MemberServiceImplTest {

    @Test
    public void testAddMember() {
        MemberDAO memberDAO = new MemberDAOFake();

        MemberService memberService = new MemberServiceImpl(memberDAO);

        memberService.add(new Member(1, "John Diet"));
        memberService.add(new Member(2, "Jane Biteman"));

        Assert.assertEquals(2, memberService.getMembers().size());
    }
}
