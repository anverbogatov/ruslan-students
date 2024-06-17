package com.example.students.api;

import com.example.students.api.dtos.GroupDto;
import com.example.students.application.ApplicationGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/groups")
public class GroupController {

    @Autowired
    private ApplicationGroupService groupService;

    @GetMapping
    public List<GroupDto> getAllGroups() {
        return groupService.getAllGroups();
    }

    @GetMapping("/{id}")
    public GroupDto getById(@PathVariable("id") Long id) {
        return groupService.getGroupById(id).get();
    }

    @PostMapping
    public GroupDto createGroup(@RequestBody GroupDto request) {
        return groupService.createGroup(request);
    }

    @PutMapping("/{id}")
    public GroupDto updateGroup(@PathVariable("id") Long id,
                                @RequestBody GroupDto request) {
        return groupService.updateGroup(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteGroup(@PathVariable("id") Long id) {
        groupService.deleteGroup(id);
    }
}
