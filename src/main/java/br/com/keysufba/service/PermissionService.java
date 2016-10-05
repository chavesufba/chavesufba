package br.com.keysufba.service;

import java.util.List;

import br.com.keysufba.entity.Permission;
import br.com.keysufba.repository.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("permissionService")
public class PermissionService implements GenericService<Permission>{

  @Autowired
  private PermissionRepository permissionRepository;

  @Override
  public List<Permission> findAll() {
    return permissionRepository.findAll();
  }

  @Override
  public Permission findById(Integer id) {
    return permissionRepository.findOne(id);
  }

  @Override
  public Permission create(Permission permission) {
    return permissionRepository.save(permission);
  }

  @Override
  public Integer delete(Integer id) {
    permissionRepository.delete(id);
    return id;
  }

  @Override
  public Permission update(Permission permission) {
    final Permission foundPermission = findById(permission.getId());
    if(foundPermission == null){
      return null;
    }

    permissionRepository.save(permission);
    return permission;
  }

}
