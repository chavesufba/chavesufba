package br.com.keysufba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.keysufba.entity.Technician;
import br.com.keysufba.repository.TechnicianRepository;

@Service("technicianService")
public class TechnicianService implements GenericService<Technician> {

  @Autowired
  private TechnicianRepository technicianRepository;

  @Override
  public List<Technician> findAll() {
    return technicianRepository.findAll();
  }

  @Override
  public Technician findById(final Integer id) {
    return technicianRepository.findOne(id);
  }

  @Override
  public Technician create(Technician i) {
    technicianRepository.save(i);
    return i;
  }

  @Override
  public Integer delete(Integer id) {
    technicianRepository.delete(id);
    return id;
  }

  @Override
  public Technician update(Technician c) {
    final Technician foundTechnician = findById(c.getId());
    if (foundTechnician == null) {
      return null;
    }

    technicianRepository.save(c);
    return c;
  }
}
