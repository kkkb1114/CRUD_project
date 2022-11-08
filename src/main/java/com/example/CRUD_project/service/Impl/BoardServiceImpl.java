package com.example.CRUD_project.service.Impl;

import com.example.CRUD_project.DTO.BoardDTO;
import com.example.CRUD_project.domain.Board;
import com.example.CRUD_project.repository.BoardRepository;
import com.example.CRUD_project.service.BoardService;
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
    public ResponseEntity deleteById(Long _id) {
        try {
            boardRepository.deleteById(_id);
            return new ResponseEntity("success", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity("fail", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity update(Long _id, BoardDTO boardDTO) {
        try {
            Optional<Board> board = boardRepository.findById(_id);
            System.out.println("update_board: "+board.get().getMember().getUserName());
            Board boardEntity = board.orElseGet(null);
            boardEntity.update(boardDTO);
            return new ResponseEntity("success", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity("fail", HttpStatus.BAD_REQUEST);
        }
    }
}
