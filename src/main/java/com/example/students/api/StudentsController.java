package com.example.students.api;

import com.example.students.domain.StudentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/")
public class StudentsController {

    private StudentService studentService;

    public StudentsController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/{id}")
    @Tag(name = "GET-операция")
    public StudentDto getStudent(@PathVariable Integer id) {
        return studentService.getStudent(id);
    }

    @PostMapping
    @Tag(name = "POST-операция")
    public void postStudent(@RequestBody StudentDto student) {
        studentService.addStudent(student);
    }

    @PutMapping
    @Tag(name = "PUT-операция")
    public void putStudent(@RequestBody StudentDto student) {
        studentService.replaceStudent(student);
    }

    @DeleteMapping("/{id}")
    @Tag(name = "DELETE-операция")
    public boolean deleteStudent(@PathVariable Integer id) {
        return studentService.deleteStudent(id);
    }
}
