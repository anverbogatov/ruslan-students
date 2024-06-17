package com.example.students.api.dtos;

import java.util.List;

public record GroupDto(Long id, String number, List<StudentDto> students) {
}
