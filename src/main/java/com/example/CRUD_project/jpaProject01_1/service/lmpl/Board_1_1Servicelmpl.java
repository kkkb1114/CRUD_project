package com.example.CRUD_project.jpaProject01_1.service.lmpl;

import com.example.CRUD_project.CrudProjectApplication;
import com.example.CRUD_project.jpaProject01_1.DTO.Board_1DTO;
import com.example.CRUD_project.jpaProject01_1.domain.Board_1;
import com.example.CRUD_project.jpaProject01_1.domain.Member_1;
import com.example.CRUD_project.jpaProject01_1.repository.Board_1Repository;
import com.example.CRUD_project.jpaProject01_1.repository.Member_1Repository;
import com.example.CRUD_project.jpaProject01_1.service.Board_1_1Service;
import com.example.CRUD_project.tool.ToolManager;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class Board_1_1Servicelmpl implements Board_1_1Service {

    private final Board_1Repository board_1Repository;
    private final Member_1Repository member_1Repository;
    private final EntityManager entityManager;

    @Override
    public ResponseEntity save(Board_1DTO board_1DTO) {
        try {
            Optional<Member_1> member_1Optional = member_1Repository.findById(82L);
            Member_1 member_1 = member_1Optional.orElseGet(null);
            Board_1 board_1 = Board_1.builder()
                    .title(board_1DTO.getTitle())
                    .content(board_1DTO.getContent())
                    .member_1(member_1)
                    .build();
            board_1Repository.save(board_1);
            return new ResponseEntity("success", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity("fail", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity update(Long id, Board_1DTO board_1DTO) {
        try{
            Optional<Board_1> board_1_findById = board_1Repository.findById(id);
            Board_1 board_1 = board_1_findById.orElseGet(null);
            board_1.update(board_1DTO);
            return new ResponseEntity("success", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity("fail", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public List<Board_1> findAll() {
        return board_1Repository.findAll();
    }

    public Board_1 findById(Long id){
        Optional<Board_1> board_1Optional = board_1Repository.findById(id);
        Board_1 board_1 = board_1Optional.orElseGet(null);
        return board_1;
    }

    @Override
    public List<Board_1> findByIdSQL(Long memberId) {
        return board_1Repository.findByIdSQL();
    }

    @Override
    public ResponseEntity delete(Long id) {
        try {
            board_1Repository.deleteById(id);
            return new ResponseEntity("success", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity("fail", HttpStatus.BAD_REQUEST);
        }
    }
}
