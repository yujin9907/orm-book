package com.example.springjpabook.step6.composite_key;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class EmbeddedParent {
    @EmbeddedId
    private ParentId id;
    private String name;
}
