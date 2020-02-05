package ru.domodedovo.crud.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "task")
public class Task {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "due_date")
    @Temporal(TemporalType.DATE)
    private Date dueDate;

    @ManyToOne
    @JoinColumn(name="project_id", referencedColumnName="id")
    private Project project;

    @OneToOne
    @JoinColumn(name = "responsible_id", referencedColumnName = "id")
    private User responsible;

    public Task(String name, Date dueDate, Project project, User responsible) {
        this.name = name;
        this.dueDate = dueDate;
        this.project = project;
        this.responsible = responsible;
    }

    public Task() {
    }
}
