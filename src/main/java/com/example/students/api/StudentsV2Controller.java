package com.example.students.api;

import com.example.students.domain.StudentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Управление студентами")
@RestController
@RequestMapping(path = "/api/v2/students")
public class StudentsV2Controller {

    private StudentService studentService;

    public StudentsV2Controller(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/{id}")
    public StudentDto getStudent(@PathVariable Integer id) {
        return studentService.getStudent(id);
    }

    @PostMapping
    public void postStudent(@RequestBody StudentDto student) {
        studentService.addStudent(student);
    }

    @PutMapping
    public void putStudent(@RequestBody StudentDto student) {
        studentService.updateStudent(student);
    }

    @DeleteMapping("/{id}")
    public boolean deleteStudent(@PathVariable Integer id) {
        return studentService.deleteStudent(id);
    }
}
