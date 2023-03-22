package com.example.springjpabook.step6.composite_key;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable // embeddedId로 복합키 구현할 대 필요 (idclass 경우 필요 없음)
class ParentId implements Serializable {
    private String id1;
    private String id2;
}
