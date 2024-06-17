package com.example.students.domain.services;

import com.example.students.domain.entities.GroupEntity;
import com.example.students.domain.entities.StudentEntity;
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
    public GroupEntity createGroup(String number, List<String> students) {
        var groupEntity = new GroupEntity();
        groupEntity.setNumber(number);

        var studentEntitites = students.stream()
                .map(studentName -> {
                    var studentEntity = new StudentEntity();
                    studentEntity.setName(studentName);
                    return studentEntity;
                }).toList();

        groupEntity.setStudents(studentEntitites);

        return groupRepository.save(groupEntity);
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
