package com.example.CRUD_project.jpaProject01_1.service.lmpl;

import com.example.CRUD_project.jpaProject01_1.repository.Member_1Repository;
import com.example.CRUD_project.jpaProject01_1.DTO.Member_1DTO;
import com.example.CRUD_project.jpaProject01_1.domain.Member_1;
import com.example.CRUD_project.jpaProject01_1.service.Member_1Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class Member_1_1Servicelmpl implements Member_1Service {

    private final Member_1Repository memberRepository;

    @Override
    public ResponseEntity save(Member_1DTO memberDTO){
        try {
            Member_1 member = Member_1.builder()
                    .memberId(memberDTO.getMember_1Id())
                    .memberPassword(memberDTO.getMember_1Password())
                    .memberName(memberDTO.getMember_1Name())
                    .build();
            memberRepository.save(member);
            return new ResponseEntity("success", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity("fail", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public List<Member_1> findAll() {
        return memberRepository.findAll();
    }

    @Override
    public Optional<Member_1> findById(Long id) {
        return memberRepository.findById(id);
    }

    @Override
    public ResponseEntity update(Long id, Member_1DTO memberDTO) {
        try {
            Optional<Member_1> member_1Find = memberRepository.findById(id);
            Member_1 member_1 = member_1Find.orElseGet(null);
            member_1.update(memberDTO);
            return new ResponseEntity("success", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity("fail", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity delete(Long id) {
        try {
            memberRepository.deleteById(id);
            return new ResponseEntity("success", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity("fail", HttpStatus.BAD_REQUEST);
        }
    }
}
