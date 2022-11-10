package com.example.CRUD_project.jpaProject01.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDTO {
    private Long id;
    private String userName;
    private String userPassword;
    private String userGender;

    @Builder
    public MemberDTO(Long id, String userName, String userPassword, String userGender){
        this.id = id;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userGender = userGender;
    }

    /*@OneToMany(mappedBy = "board", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @Builder.Default
    private List<BoardDTO> boardDTOList = new ArrayList<>();

    public void addBoard(BoardDTO boardDTO){
        //boardDTO.setMemberDTO(this);
        boardDTOList.add(boardDTO);
    }*/
}
