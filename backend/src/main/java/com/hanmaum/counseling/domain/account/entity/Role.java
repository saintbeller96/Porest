package com.hanmaum.counseling.domain.account.entity;

import lombok.Data;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    private String name;
}
