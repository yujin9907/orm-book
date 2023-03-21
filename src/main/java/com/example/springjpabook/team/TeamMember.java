package com.example.springjpabook.team;

// 일대다 단방향 연관관계 팀-팀회원

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity
public class TeamMember {
    @Column(name = "id")
    private @Id String id;
    private String username;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;
}
