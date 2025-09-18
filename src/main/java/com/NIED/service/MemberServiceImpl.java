package com.NIED.service;

import com.NIED.model.Member;
import com.NIED.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public Member registerMember(Member member) {
        // Here you can add logic like validating phone number uniqueness
        return memberRepository.save(member);
    }

    @Override
    public Optional<Member> getMemberById(String id) {
        return memberRepository.findById(id);
    }

    @Override
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    @Override
    public Member updateMemberBalance(String id, double amount) {
        Optional<Member> memberOptional = memberRepository.findById(id);
        if (memberOptional.isPresent()) {
            Member member = memberOptional.get();
            member.setBalance(member.getBalance() + amount);
            return memberRepository.save(member);
        }
        return null; // Or throw an exception
    }
}