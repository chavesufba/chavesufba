package br.com.keysufba.service;

import br.com.keysufba.entity.Institute;
import br.com.keysufba.repository.InstituteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;



/**
 * Created by ian on 04/09/16.
 */
@Service("instituteService")
public class InstituteService implements GenericService<Institute> {


    @Autowired
    private InstituteRepository instituteRepository;

    @Override
    public List<Institute> findAll() {
        return instituteRepository.findAll();
    }

    @Override
    public Institute findById(Integer id) {
        return instituteRepository.findOne(id);
    }

    @Override
    public Institute create(Institute t) throws DataIntegrityViolationException {
        if(findById(t.getId()) != null){
            throw new DataIntegrityViolationException("entity already exists");
        }
        return instituteRepository.save(t);
    }

    @Override
    public Integer delete(Institute t) {
        instituteRepository.delete(t);
        return null;
    }

    public Institute update(Institute t) throws DataIntegrityViolationException {
        if(findById(t.getId()) != null){
            return instituteRepository.save(t);
        }
        throw new DataIntegrityViolationException("entity not found");
    }
}
