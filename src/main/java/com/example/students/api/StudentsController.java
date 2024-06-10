package com.example.students.api;

import com.example.students.domain.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Управление студентами")
@RestController
@RequestMapping(path = "/api/v1/students")
public class StudentsController {

    private StudentService studentService;

    public StudentsController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/{id}")
    @Operation(deprecated = true)
    public StudentDto getStudent(@PathVariable Integer id) {
        return studentService.getStudent(id);
    }

    @PostMapping
    @Operation(deprecated = true)
    public void postStudent(@RequestBody StudentDto student) {
        studentService.addStudent(student);
    }

    @PutMapping
    @Operation(deprecated = true)
    public void putStudent(@RequestBody StudentDto student) {
        studentService.updateStudent(student);
    }

    @DeleteMapping("/{id}")
    @Operation(deprecated = true)
    public boolean deleteStudent(@PathVariable Integer id) {
        return studentService.deleteStudent(id);
    }
}
