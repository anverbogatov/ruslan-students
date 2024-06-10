package com.example.students.persistance;

import com.example.students.api.StudentDto;
import com.example.students.persistance.entities.StudentEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Component
public class StudentsStorage {

    @PersistenceContext
    private EntityManager entityManager;

    private Map<Integer, StudentDto> students = new HashMap<>();

    public void putStudent(StudentDto studentDto) {
        students.put(studentDto.studentId(), studentDto);
    }

    public boolean containsStudent(Integer studentId) {
        return students.containsKey(studentId);
    }

    public boolean removeStudent(Integer studentId) {
        if (students.containsKey(studentId)) {
            students.remove(studentId);
            return true;
        } else {
            return false;
        }
    }

    public StudentDto getStudent(Integer studentId) {
        return students.getOrDefault(studentId, null);
    }

    @Transactional
    public StudentEntity createStudent(String name) {
        var entity = new StudentEntity(); // NEW (TRANSIENT)

        entityManager.persist(entity); // -> MANAGED

        entityManager.remove(entity); // -> REMOVED

        entityManager.merge(entity); // DETACHED -> MANAGED

        return entity;
    }
}
