package br.com.keysufba.service;

import java.util.List;

import br.com.keysufba.entity.Action;
import br.com.keysufba.repository.ActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("actionService")
public class ActionService implements GenericService<Action>{

  @Autowired
  private ActionRepository actionRepository;

  @Override
  public List<Action> findAll() {
    return actionRepository.findAll();
  }

  @Override
  public Action findById(Integer id) {
    return actionRepository.findOne(id);
  }

  @Override
  public Action create(Action action) {
    return actionRepository.save(action);
  }

  @Override
  public Integer delete(Integer id) {
    actionRepository.delete(id);
    return id;
  }

  @Override
  public Action update(Action action) {
    final Action foundAction = findById(action.getId());
    if(foundAction == null){
      return null;
    }

    actionRepository.save(action);
    return action;
  }

}
