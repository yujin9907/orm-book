package com.example.springjpabook.step4.member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class FirstJpa {

    public static void main(String[] args) {
        // jpa 기본

        // 엔티티매니저 팩토리 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(("jpabook"));
        // 엔티티매니저 생성
        EntityManager em = emf.createEntityManager();
        // 트랜잭션 시작
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            // logic(em);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }

    // 비즈니스 로직
    public void logic(EntityManager em) {
        Member member = Member.builder()
                .id("id1")
                .username("heo")
                .age(2)
                .build();

        em.persist(member); // 반영

        Member memberPS = em.find(Member.class, member.getId()); // 조회
        List<Member> memberListPS = em.createQuery("select m from Member m", Member.class).getResultList(); // jpql

        em.remove(member); // 삭제

    }
}
