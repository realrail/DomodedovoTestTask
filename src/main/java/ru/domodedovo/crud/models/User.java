package ru.domodedovo.crud.models;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "USER")
public class User {
    @Id
    @Column(name = "Id", nullable = false)
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    public User(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public User() {}
}
