package com.example.students.domain.services;

import com.example.students.domain.entities.GroupEntity;
import com.example.students.persistance.repositories.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class GroupService {

    @Autowired
    private GroupRepository groupRepository;

    public List<GroupEntity> getAllGroups() {
        return groupRepository.findAll();
    }

    public Optional<GroupEntity> getGroupById(Long id) {
        return groupRepository.findById(id);
    }

    @Transactional
    public GroupEntity createGroup(String number) {
        var entity = new GroupEntity();
        entity.setNumber(number);
        return groupRepository.save(entity);
    }

    @Transactional
    public GroupEntity updateGroup(Long id, String number) {
        var entity = groupRepository.findById(id).get();
        entity.setNumber(number);
        return entity;
    }

    @Transactional
    public void deleteGroup(Long id) {
        groupRepository.deleteById(id);
    }
}
