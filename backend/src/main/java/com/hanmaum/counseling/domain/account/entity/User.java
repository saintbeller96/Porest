package com.hanmaum.counseling.domain.account.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(unique = true)
    private String email;

    @Column
    private String password;

    @Column
    private String nickname;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

}
