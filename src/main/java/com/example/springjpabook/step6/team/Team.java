package com.example.springjpabook.step6.team;

// 일대다 단방향 연관관계 팀-팀회원

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity
public class Team {
    @Column(name = "id")
    private @Id String id;
    private String name;

    // 양방향매핑
    @OneToMany(mappedBy = "team") // 반대쪽 필드 이름
    private List<TeamMember> memeber = new ArrayList<>();
}
