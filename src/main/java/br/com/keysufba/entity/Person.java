
package br.com.keysufba.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.apache.commons.codec.digest.DigestUtils;


@Entity
@Table(name = "PESSOA", schema = "SCHEMAA")
public class Person {

  private Integer id;
  private String name;
  private String email;
  private String phone;
  private String photo;
  private String login;
  private String password;

  Person() { // jpa only

  }

  public Person(Integer id) {
    this.id = id;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "ID", unique = true, nullable = false)
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @Column(name = "NOME", length = 100, nullable = false)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Column(name = "EMAIL", length = 100, nullable = false)
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Column(name = "TELEFONE", length = 20)
  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  @Column(name = "FOTO", length = 250)
  public String getPhoto() {
    return photo;
  }

  public void setPhoto(String photo) {
    this.photo = photo;
  }

  @Column(name = "LOGIN", length = 50, nullable = false)
  public String getLogin() {
    return login;
  }

  public void setLogin(final String login) {
    this.login = login;
  }

  @Column(name = "SENHA", length = 100, nullable = false)
  public String getPassword() {
    return password;
  }

  public void setPassword(final String password) {
    this.password = password;
  }

  @PrePersist
  protected void onCreate() {
    password = DigestUtils.sha1Hex(password);
  }
}