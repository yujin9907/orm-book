package com.example.springjpabook.step7.join_table;

import org.hibernate.procedure.spi.ParameterRegistrationImplementor;

import javax.persistence.*;

// 일대일 조인 테이블 매핑
public class OneoneJoinTableEntity {
}

@Entity
class OneoneParent{
    @Id
    @GeneratedValue
    @Column(name = "parent_id")
    private Long id;
    private String name;

    @OneToOne
    @JoinTable(name = "child",
            joinColumns = @JoinColumn(name = "parent_id"),
            inverseJoinColumns = @JoinColumn(name = "child_id")
    )
    private OneoneChild child;
}

@Entity
class OneoneChild{
    @Id
    @GeneratedValue
    @Column(name = "child_id")
    private Long id;
    private String name;
}
