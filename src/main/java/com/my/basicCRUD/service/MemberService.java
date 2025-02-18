package com.my.basicCRUD.service;

import com.my.basicCRUD.dto.MemberDto;
import com.my.basicCRUD.emtty.Member;
import com.my.basicCRUD.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

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

    public void saveMember(MemberDto dto) {
//        dto->entity 변환
        Member member = MemberDto.fromDto(dto);
//        저장요청
        memberRepository.save(member);

    }

    public void deleteById(Long id) {
        memberRepository.deleteById(id);
    }

    public MemberDto findByID(Long id) {
        //id로db에서 검색하기
        Member member = memberRepository.findById(id).orElse(null);
//        dto로 변환
        if (!ObjectUtils.isEmpty(member)) {
            return MemberDto.fromEntity(member);
        } else {
            return null;
        }

    }

    public void updateMember(MemberDto dto) {
        //dto를 entity
        Member member = MemberDto.fromDto(dto);
        //수정처리
        //save():해당 Id가 존재하면 수정, 없으면 입력
                memberRepository.save(member);
    }
}
