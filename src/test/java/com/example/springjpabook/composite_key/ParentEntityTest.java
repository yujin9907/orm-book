package com.example.springjpabook.composite_key;

import com.example.springjpabook.step6.composite_key.ParentEntity;
import com.example.springjpabook.step6.composite_key.ParentId;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import javax.persistence.EntityManager;

@Slf4j
@DataJpaTest
@ActiveProfiles("test")
public class ParentEntityTest {

    @Autowired
    private EntityManager em;

    @Test
    public <parentEntity> void 복합키idclass(){
        //G
        ParentEntity parentEntity = ParentEntity.builder()
                .id1("복합키1")
                .id2("복합키2")
                .name("복합키 id class 테스트")
                .build();

        // T
        em.persist(parentEntity);
        em.flush(); // 아니... 영속성에 등록하기 전에 식별자 클래스 생성한다고? 아니면 db에 인서트하기 전에 생성한다고...

        // D
        ParentId id = new ParentId("복합키1", "복합키2");
        ParentEntity ps = em.find(ParentEntity.class, id);
        log.debug("복합키 조회 : "+ps);
    }
}
