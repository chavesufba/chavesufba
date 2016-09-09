package br.com.keysufba.config;

import java.util.ArrayList;
import java.util.List;

import br.com.keysufba.entity.Person;
import br.com.keysufba.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

  @Autowired
  private PersonService personService;

  @Transactional(readOnly = true)
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    List<Person> people = personService.findAll();
    for (Person person : people) {
      if (person.getLogin().equals(username)) {
        return new User(person.getLogin(), person.getPassword(), getGrantedAuthorities(person));
      }
    }
    throw new UsernameNotFoundException("Username not found");
  }

  private List<GrantedAuthority> getGrantedAuthorities(Person person) {
    List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
    authorities.add(new SimpleGrantedAuthority("ROLE_PERSON"));

    return authorities;
  }

}
