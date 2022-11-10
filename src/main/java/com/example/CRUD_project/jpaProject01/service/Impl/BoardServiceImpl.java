package com.example.CRUD_project.jpaProject01.service.Impl;

import com.example.CRUD_project.jpaProject01.DTO.BoardDTO;
import com.example.CRUD_project.jpaProject01.domain.Board;
import com.example.CRUD_project.jpaProject01.repository.BoardRepository;
import com.example.CRUD_project.jpaProject01.service.BoardService;
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
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    @Override
    public ResponseEntity save(BoardDTO boardDTO) {
        try {
            Board board = Board.builder()
                    .title(boardDTO.getTitle())
                    .content(boardDTO.getContent())
                    .views(boardDTO.getViews())
                    .likes(boardDTO.getLikes())
                    .build();
            boardRepository.save(board);
            return new ResponseEntity("success", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity("fail", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public List<BoardDTO> findAll() {
        List<Board> boardList = boardRepository.findAll();
        List<BoardDTO> boardDTOList = new ArrayList<>();
        for (Board board : boardList){
            BoardDTO boardDTO = BoardDTO.builder()
                    .id(board.getId())
                    .title(board.getTitle())
                    .content(board.getContent())
                    .views(board.getViews())
                    .likes(board.getLikes())
                    .member(board.getMember())
                    .build();

            boardDTOList.add(boardDTO);
        }
        return boardDTOList;
    }

    @Override
    public ResponseEntity deleteById(Long id) {
        try {
            boardRepository.deleteById(id);
            return new ResponseEntity("success", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity("fail", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity update(Long id, BoardDTO boardDTO) {
        try {
            Optional<Board> board = boardRepository.findById(id);
            System.out.println("update_board: "+board.get().getMember().getUserName());
            Board boardEntity = board.orElseGet(null);
            boardEntity.update(boardDTO);
            return new ResponseEntity("success", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity("fail", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity modifyBoardData(Long id, BoardDTO boardDTO, String memberName){
        try {
            Optional<Board> boardOptional = boardRepository.findById(id);
            Board board = boardOptional.orElseGet(null);
            if (memberName.equals(board.getMember().getUserName())){
                boardDTO.setContent("수정_1");
                board.update(boardDTO);
                System.out.println("수정 완료");
            }else {
                System.out.println("작성자와 로그인한 계정의 이름이 일치하지 않습니다.");
            }
            return new ResponseEntity("success", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity("fail", HttpStatus.BAD_REQUEST);
        }
    }
}
