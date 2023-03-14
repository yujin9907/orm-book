package com.example.springjpabook.member;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "member")
public class Member {
    @Id @Column(name = "id")
    private String id;
    private String username;
    private Integer age;
}
