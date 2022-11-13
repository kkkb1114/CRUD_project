package com.example.CRUD_project.jpaProject02;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MEMBER")
public class Member {
    @Id
    @Column(name = "ID")
    private String id; // index값
    @Column(name = "NAME")
    private String userName; // 이름
    @Column(name = "AGE")
    private Integer age; // 나이

    // getter, setter
    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id = id;
    }
    public String getUserName(){
        return userName;
    }
    public void setUserName(String userName){
        this.userName = userName;
    }
    public Integer getAge(){
        return age;
    }
    public void setAge(Integer age){
        this.age = age;
    }
}
