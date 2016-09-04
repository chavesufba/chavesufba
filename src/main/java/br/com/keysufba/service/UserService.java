package br.com.keysufba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.keysufba.entity.User;
import br.com.keysufba.repository.UserRepository;

@Service("userService")
public class UserService implements GenericService<User> {

  @Autowired
  private UserRepository userRepository;
  
  @Override
  public List<User> findAll() {
    return userRepository.findAll();
  }

  @Override
  public User findById(Integer id) {
    return userRepository.findOne(id);
  }

  @Override
  public User create(User t) throws DataIntegrityViolationException {
	if(findById(t.getId()) != null){
		throw new DataIntegrityViolationException("User already exists");
	}
    return userRepository.save(t);
  }

  @Override
  public Integer delete(final Integer id) {
    userRepository.delete(id);
    return id;
  }

  @Override
  public User update(User t) throws DataIntegrityViolationException {
    if(findById(t.getId()) != null){
    	return userRepository.save(t);
    }
    throw new DataIntegrityViolationException("User not found");
  }

}
