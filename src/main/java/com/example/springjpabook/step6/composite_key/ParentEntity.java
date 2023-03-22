package com.example.springjpabook.step6.composite_key;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

// IdClass로 복합키를 매핑하는 방법

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@IdClass(ParentId.class)
public class ParentEntity {
    @Id
    @Column(name = "id1")
    private String id1;

    @Id
    @Column(name = "id2")
    private String id2;

    private String name;
}


@Entity
class ChildClass {
    @Id
    private String id;
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "id1", referencedColumnName = "id1"),
            @JoinColumn(name = "id2", referencedColumnName = "id2")
    })
    private ParentEntity parentEntity;
}
