package br.com.keysufba.service;

import java.util.List;

import br.com.keysufba.entity.UserType;
import br.com.keysufba.repository.UserTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userTypeService")
public class UserTypeService implements GenericService<UserType>{

	@Autowired
	private UserTypeRepository userTypeRepository;
	
	@Override
	public List<UserType> findAll() {
		return userTypeRepository.findAll();
	}

	@Override
	public UserType findById(Integer id) {
		return userTypeRepository.findOne(id);
	}

	@Override
	public UserType create(UserType t) {
		return userTypeRepository.save(t);
	}

	@Override
	public Integer delete(Integer id) {
		userTypeRepository.delete(id);
		return id;
	}

	@Override
	public UserType update(UserType t) {
		final UserType foundUserType = findById(t.getId());
		if(foundUserType == null){
			return null;
		}
		
		userTypeRepository.save(t);
		return t;
	}

}
