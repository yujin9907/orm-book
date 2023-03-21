package com.example.springjpabook.team;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import javax.persistence.EntityManager;
import java.util.List;

@Slf4j
@DataJpaTest
@ActiveProfiles("test")
public class TeamMemberRepositoryTest {

    @Autowired TeamRepository teamRepository;
    @Autowired TeamMembarRepository teamMembarRepository;
    @Autowired EntityManager em;

    @BeforeEach
    public void setUp() {
        // 팀 하나 저장
        Team team = Team.builder().id("team-id-1").name("my team").build();
        teamRepository.save(team);

        // 회원 추가
        TeamMember member = TeamMember.builder().id("member-id-1").username("허").team(team).build();
        TeamMember member2 = TeamMember.builder().id("member-id-2").username("유").team(team).build();
        teamMembarRepository.save(member);
        teamMembarRepository.save(member2);

    }

    @Test
    public void setUpTest() {
        // 디버그 로그 확인
        
        log.debug("실행됨");
        Team teamPS = teamRepository.findById("team-id-1").get();
        Team memberPS = teamMembarRepository.findById("member-id-1").get().getTeam();

        Assertions.assertEquals(teamPS, memberPS);
    }

    @Test
    public void buildQuery() {
        String jpql = "select m from TeamMember m join m.team t where t.name=:teamName";
        List<TeamMember> resultList = em.createQuery(jpql, TeamMember.class)
                .setParameter("teamName", "my team")
                .getResultList();
    }
}
