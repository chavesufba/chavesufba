package br.com.keysufba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.keysufba.entity.Department;
import br.com.keysufba.repository.DepartmentRepository;

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
    public Department create(Department d) {
        departmentRepository.save(d);
        return d;
    }

    @Override
    public Integer delete(Integer id) {
        departmentRepository.delete(id);
        return id;
    }

    @Override
    public Department update(Department d) {
        final Department foundDepartment = findById(d.getId());
        if (foundDepartment == null) {
            return null;
        }
        departmentRepository.save(d);
        return d;
    }

}
