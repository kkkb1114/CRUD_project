package com.example.CRUD_project.service.Impl;

import com.example.CRUD_project.DTO.MemberDTO;
import com.example.CRUD_project.repository.MemberRepository;
import com.example.CRUD_project.domain.Member;
import com.example.CRUD_project.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public ResponseEntity save(MemberDTO memberDTO) {
        try {
            Member member = Member.builder()
                    .userName(memberDTO.getUserName())
                    .userPassword(memberDTO.getUserPassword())
                    .userGender(memberDTO.getUserGender())
                    .build();
            memberRepository.save(member);
            return new ResponseEntity("success", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity("fail", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public List<MemberDTO> findAll(){
        List<Member> memberList = memberRepository.findAll();
        List<MemberDTO> memberDTOList = new ArrayList<>();
        for (Member member : memberList){
            MemberDTO memberDTO = MemberDTO.builder()
                    .id(member.getId())
                    .userName(member.getUserName())
                    .userPassword(member.getUserPassword())
                    .userGender(member.getUserGender())
                    .build();

            memberDTOList.add(memberDTO);
        }
        return memberDTOList;
    }

    @Override
    public ResponseEntity deleteById(Long _id){
        try {
            memberRepository.deleteById(_id);
            return new ResponseEntity("success", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity("fail", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity update(Long _id, MemberDTO memberDTO){
        try {
            Optional<Member> member = memberRepository.findById(_id);
            Member memberEntity = member.orElseGet(null);
            memberEntity.update(memberDTO);
            return new ResponseEntity("success", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity("fail", HttpStatus.BAD_REQUEST);
        }
    }
}
