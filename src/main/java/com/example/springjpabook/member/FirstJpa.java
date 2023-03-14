package com.example.springjpabook.member;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FirstJpa {

    public static void main(String[] args) {
        // jpa 기본

        // 엔티티매니저 생성
        EntityManagerFactory em = Persistence.createEntityManagerFactory(("jpabook"));
    }
}
