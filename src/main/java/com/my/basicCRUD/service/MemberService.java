package com.my.basicCRUD.service;

import com.my.basicCRUD.dto.MemberDto;
import com.my.basicCRUD.emtty.Member;
import com.my.basicCRUD.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberService {
    @Autowired
    MemberRepository memberRepository;

    public List<MemberDto> findAll() {
        List<Member> memberList = memberRepository.findAll();
        List<MemberDto> dtoList = new ArrayList<>();
//        entity class -> dto class변경
       return memberList.stream().map(MemberDto::fromEntity)
                .toList();
//        for (int i = 0; i < memberList.stream().count(); i++) {
//            MemberDto dto = new MemberDto();
//            dto.setId(memberList.get(i).getMemberId());
//            dto.setName(memberList.get(i).getName());
//            dto.setAge(memberList.get(i).getAge());
//            dto.setAddress(memberList.get(i).getAddress());
//            dtoList.add(dto);
//        }
//        return dtoList;
    }
}
