package br.com.keysufba.service;

import java.util.List;

import br.com.keysufba.entity.Leasing;
import br.com.keysufba.repository.LeasingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("leasingService")
public class LeasingService implements GenericService<Leasing>{

  @Autowired
  private LeasingRepository leasingRepository;

  @Override
  public List<Leasing> findAll() {
    return leasingRepository.findAll();
  }

  @Override
  public Leasing findById(Integer id) {
    return leasingRepository.findOne(id);
  }

  @Override
  public Leasing create(Leasing leasing) {
    return leasingRepository.save(leasing);
  }

  @Override
  public Integer delete(Integer id) {
    leasingRepository.delete(id);
    return id;
  }

  @Override
  public Leasing update(Leasing leasing) {
    final Leasing foundLeasing = findById(leasing.getId());
    if(foundLeasing == null){
      return null;
    }

    leasingRepository.save(leasing);
    return leasing;
  }

}
