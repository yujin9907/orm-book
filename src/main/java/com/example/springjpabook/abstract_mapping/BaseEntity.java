package com.example.springjpabook.abstract_mapping;

import javax.persistence.*;

@MappedSuperclass
public abstract class BaseEntity {
    @Id @GeneratedValue
    private long id;
    private String name;
}

@Entity
class childEntity extends BaseEntity{
    // id, name 상속
    private String email;
}

@Entity
class otherEntity extends BaseEntity{
    // id, name 상속
    private String age;
}
