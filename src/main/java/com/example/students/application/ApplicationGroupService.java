package com.example.students.application;

import com.example.students.api.dtos.GroupDto;
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
                .map(el -> new GroupDto(el.getId(), el.getNumber()))
                .toList();
    }

    public Optional<GroupDto> getGroupById(Long id) {
        return groupService.getGroupById(id)
                .map(el -> new GroupDto(el.getId(), el.getNumber()));
    }

    public GroupDto createGroup(GroupDto request) {
        var entity = groupService.createGroup(request.number());
        return new GroupDto(entity.getId(), entity.getNumber());
    }

    public GroupDto updateGroup(Long id, GroupDto request) {
        var entity = groupService.updateGroup(id, request.number());
        return new GroupDto(entity.getId(), entity.getNumber());
    }

    public void deleteGroup(Long id) {
        groupService.deleteGroup(id);
    }
}
