package com.example.students.persistance.entities;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class StudentEntity {

    private Long id;

    private String name;

}
