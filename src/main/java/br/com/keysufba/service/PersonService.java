package br.com.keysufba.service;

import java.util.List;

import br.com.keysufba.entity.Person;
import br.com.keysufba.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("personService")
public class PersonService implements GenericService<Person> {

  @Autowired
  private PersonRepository personRepository;

  @Override
  public List<Person> findAll() {
    return personRepository.findAll();
  }

  @Override
  public Person findById(final Integer id) {
    return personRepository.findOne(id);
  }

  @Override
  public Person create(Person i) {
    personRepository.save(i);
    return i;
  }

  @Override
  public Integer delete(Integer id) {
    personRepository.delete(id);
    return id;
  }

  @Override
  public Person update(Person p) {
    final Person foundPerson = findById(p.getId());
    if (foundPerson == null) {
      return null;
    }

    personRepository.save(p);
    return p;
  }
}
