package br.com.keysufba.service;

import br.com.keysufba.entity.Department;
import br.com.keysufba.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;



/**
 * Created by ian on 04/09/16.
 */
@Service("departmentService")
public class DepartmentService implements GenericService<Department> {


    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    @Override
    public Department findById(Integer id) {
        return departmentRepository.findOne(id);
    }

    @Override
    public Department create(Department t) throws DataIntegrityViolationException {
        if(findById(t.getId()) != null){
            throw new DataIntegrityViolationException("entity already exists");
        }
        return departmentRepository.save(t);
    }

    @Override
    public Integer delete(Department t) {
        departmentRepository.delete(t);
        return null;
    }

    public Department update(Department t) throws DataIntegrityViolationException {
        if(findById(t.getId()) != null){
            return departmentRepository.save(t);
        }
        throw new DataIntegrityViolationException("entity not found");
    }
}
