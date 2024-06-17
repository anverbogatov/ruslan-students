package com.example.students.application;

import com.example.students.api.dtos.GroupDto;
import com.example.students.api.dtos.StudentDto;
import com.example.students.domain.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicationGroupService {

    @Autowired
    private GroupService groupService;

    public List<GroupDto> getAllGroups() {
        return groupService.getAllGroups().stream()
                .map(el -> new GroupDto(el.getId(), el.getNumber(), null))
                .toList();
    }

    public Optional<GroupDto> getGroupById(Long id) {
        return groupService.getGroupById(id)
                .map(el -> new GroupDto(el.getId(), el.getNumber(), null));
    }

    public GroupDto createGroup(GroupDto request) {
        var entity = groupService.createGroup(request.number(),
                request.students().stream().map(StudentDto::name).toList());
        return new GroupDto(entity.getId(), entity.getNumber(), null);
    }

    public GroupDto updateGroup(Long id, GroupDto request) {
        var entity = groupService.updateGroup(id, request.number());
        return new GroupDto(entity.getId(), entity.getNumber(), null);
    }

    public void deleteGroup(Long id) {
        groupService.deleteGroup(id);
    }
}
