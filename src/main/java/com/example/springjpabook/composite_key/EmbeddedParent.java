package com.example.springjpabook.composite_key;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class EmbeddedParent {
    @EmbeddedId
    private ParentId id;
    private String name;
}
