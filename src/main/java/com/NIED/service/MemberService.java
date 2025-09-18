package com.NIED.service;

import com.NIED.model.Member;
import java.util.List;
import java.util.Optional;

public interface MemberService {
    Member registerMember(Member member);
    Optional<Member> getMemberById(String id);
    List<Member> getAllMembers();
    Member updateMemberBalance(String id, double amount);
}