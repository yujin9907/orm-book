package com.example.springjpabook.member;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import javax.persistence.EntityManager;

@Slf4j
@DataJpaTest
@ActiveProfiles("test")
public class MemberRepositoryTest {

    @Autowired private MemberRepository memberRepository;
    @Autowired private EntityManager em;

    @BeforeEach
    public void setUp() {
        Member member = Member.builder().id("test").username("yujin").age(7).roleType(RoleType.ADMIN).description("test description").build();
        memberRepository.save(member);

//        em.createQuery("CREATE SEQUENCE board_seq START WITH 1 INCREMENT BY 1;")
        // 테이블을 생성할 때 시퀀스를 생성한다. ddl을 em으로 사용할 수 없는듯함
    }
    
    @Test
    public void testSetUp() {
        log.debug("테스트 데이터 로딩 실행됨");

        //  ij : 테스트 케이스 실행하면, 디버깅 콘솔로 알아서 실행해줌(vs 처럼 뭐 설정 세팅 필요없음)
    }

}
