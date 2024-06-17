package com.example.students.domain.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "groups")
public class GroupEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String number;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    private List<StudentEntity> students;

    public void setStudents(List<StudentEntity> students) {
        this.students = students;
        students.forEach(student -> student.setGroup(this));
    }
}
