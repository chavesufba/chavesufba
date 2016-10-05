
package br.com.keysufba.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "PERMISSAO", schema = "SCHEMAA")
public class Permission {

  private Integer id;
  private UserType userType;
  private Action action;

  Permission() { // jpa only

  }

  public Permission(Integer id) {
    this.id = id;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "ID", unique = true, nullable = false)
  public Integer getId() {
    return id;
  }

  public void setId(final Integer id) {
    this.id = id;
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "TIPO_USUARIO_ID", nullable = false)
  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
  public UserType getUserType() {
    return userType;
  }

  public void setUserType(final UserType userType) {
    this.userType = userType;
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "ACAO_ID", nullable = false)
  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
  public Action getAction() {
    return action;
  }

  public void setAction(Action action) {
    this.action = action;
  }

}