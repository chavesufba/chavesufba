package br.com.keysufba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.keysufba.entity.Teacher;
import br.com.keysufba.repository.TeacherRepository;

@Service("teacherService")
public class TeacherService implements GenericService<Teacher> {

  @Autowired
  private TeacherRepository teacherRepository;
  
  @Override
  public List<Teacher> findAll() {
    return teacherRepository.findAll();
  }

  @Override
  public Teacher findById(Integer id) {
    return teacherRepository.findOne(id);
  }

  @Override
  public Teacher create(Teacher r) {
    teacherRepository.save(r);
    return r;
  }

  @Override
  public Integer delete(Integer id) {
    teacherRepository.delete(id);
    return id;
  }

  @Override
  public Teacher update(Teacher r) {
    final Teacher foundTeacher = findById(r.getId());
    if (foundTeacher == null) {
      return null;
    }

    teacherRepository.save(r);
    return r;
  }

}
