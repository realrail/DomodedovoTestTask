package ru.domodedovo.crud.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "project")
public class Project {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "creation_date")
    @Temporal(TemporalType.DATE)
    private Date creationDate;

    public Project(String name, Date creationDate) {
        this.name = name;
        this.creationDate = creationDate;
    }

    public Project() {
    }
}
