package br.com.keysufba.service;

import java.util.List;
import br.com.keysufba.entity.Student;
import br.com.keysufba.repository.StudentRepository;

public class StudentService implements GenericService<Student>{

	private StudentRepository studentRepository;
	
	@Override
	public List<Student> findAll() {
		return studentRepository.findAll();
	}

	@Override
	public Student findById(Integer id) {
		return studentRepository.findOne(id);
	}

	@Override
	public Student create(Student t) {
		return studentRepository.save(t);
	}

	@Override
	public Integer delete(Integer id) {
		studentRepository.delete(id);
		return id;
	}

	@Override
	public Student update(Student t) {
		final Student foundStudent = findById(t.getId());
		if(foundStudent == null){
			return null;
		}
		
		studentRepository.save(t);
		return t;
	}

}
