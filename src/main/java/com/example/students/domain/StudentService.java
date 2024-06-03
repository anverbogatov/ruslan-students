package com.example.students.domain;

import com.example.students.api.StudentDto;
import com.example.students.persistance.StudentsStorage;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private StudentsStorage studentsStorage;

    public StudentService(StudentsStorage studentsStorage) {
        this.studentsStorage = studentsStorage;
    }

    public void addStudent(StudentDto student) {
        studentsStorage.putStudent(student);
    }

    public void replaceStudent(StudentDto student) {
        if (studentsStorage.containsStudent(student.studentId())) {
            studentsStorage.putStudent(student);
        }
    }

    public StudentDto getStudent(Integer studentId) {
        return studentsStorage.getStudent(studentId);
    }

    public boolean deleteStudent(Integer studentId) {
        return studentsStorage.removeStudent(studentId);
    }
}
