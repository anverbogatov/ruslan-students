package com.example.students.persistance;

import com.example.students.api.StudentDto;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class StudentsStorage {

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
}
