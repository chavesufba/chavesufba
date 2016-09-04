package br.com.keysufba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.keysufba.entity.Institute;
import br.com.keysufba.repository.InstituteRepository;

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
    public Institute create(Institute i) {
        instituteRepository.save(i);
        return i;
    }

    @Override
    public Integer delete(Integer id) {
        instituteRepository.delete(id);
        return id;
    }

    @Override
    public Institute update(Institute i) {
        final Institute foundInstitute = findById(i.getId());
        if (foundInstitute == null) {
            return null;
        }
        instituteRepository.save(i);
        return i;
    }

}
