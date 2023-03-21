package com.example.springjpabook.abstract_mapping;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED) // 부모 클래스 어노테이션. 조인 전략.
@DiscriminatorColumn(name = "DTYPE") // 구분 컬럼(객체는 타입이 있기 때문에)
public abstract class Item {
    @Id @GeneratedValue
    @Column(name = "id")
    private Long id;
    private String name;
    private int price;
}

@Entity
@PrimaryKeyJoinColumn(name="album_id") // 자식 테이블의 기본키명을 변경할 수 있음
@DiscriminatorValue("A") // 자식테이블. 구분값 지정
class Album extends Item{
    private String artist;
}

@Entity
@DiscriminatorValue("M")
class Movie extends Item{
    private String director;
    private String actor;
}
