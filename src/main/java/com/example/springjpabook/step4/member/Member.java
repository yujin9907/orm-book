package com.example.springjpabook.step4.member;

import lombok.*;

import javax.persistence.*;
import java.util.Date;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "member", uniqueConstraints = {@UniqueConstraint(name = "NAME_UNIQUE", columnNames = {"name"})})
public class Member {
    @Id @Column(name = "id")
    //@GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment 전략을 사용하며, 생성 후 id 조회가 가능하므로 id를 얻기 위해 생성+조회함
                                                        // 다만 auto increment를 사용하면, string type을 지정할 수 없음(자동증가값이기 때문에 숫자만 가능)
                                                        // 그래서 사용 안 함
    private String id;
    @Column(name = "name", nullable = false, length = 20)
    private String username;
    private Integer age;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate; // 이 Data가 대체 자바유틸이냐 sql이냐
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;
    @Lob
    private String description; // 문자의 길이 제한을 없애기 위함 clob 타입으로의 매핑을 위해
}

