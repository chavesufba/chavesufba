package br.com.keysufba.service;

import java.util.List;

import br.com.keysufba.entity.Pavilion;
import br.com.keysufba.repository.PavilionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("pavilionService")
public class PavilionService implements GenericService<Pavilion> {

  @Autowired
  private PavilionRepository pavilionRepository;

  @Override
  public List<Pavilion> findAll() {
    return pavilionRepository.findAll();
  }

  @Override
  public Pavilion findById(Integer id) {
    return pavilionRepository.findOne(id);
  }

  @Override
  public Pavilion create(Pavilion p) {
    pavilionRepository.save(p);
    return p;
  }

  @Override
  public Integer delete(Integer id) {
    pavilionRepository.delete(id);
    return id;
  }

  @Override
  public Pavilion update(Pavilion p) {
    final Pavilion foundPavilion = findById(p.getId());
    if (foundPavilion == null) {
      return null;
    }

    pavilionRepository.save(p);
    return p;
  }

}
