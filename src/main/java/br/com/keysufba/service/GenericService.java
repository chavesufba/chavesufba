package br.com.keysufba.service;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;

public interface GenericService<T> {

  /**
   * Finds all the items matching the {@link Entity} type
   * 
   * @return {@link Collection} of {@link Entity}
   */
  Collection<T> findAll();

  /**
   * Find the item matching with the {@link Id} of the {@link Entity}
   * 
   * @param id - Attribute {@link Id} of the {@link Entity}
   * @return Instance of the {@link Entity}
   */
  T findById(Integer id);

  /**
   * Persists an instance of the {@link Entity}
   * 
   * @param t - Instance of the {@link Entity}
   * @return Instance of the {@link Entity} persisted
   */
  T create(T t);

  /**
   * Remove an instance of the {@link Entity}
   * 
   * @param t - Instance of the {@link Entity}
   * @return Attribute {@link Id} of the {@link Entity} removed
   */
  Integer delete(T t);

  /**
   * Update an instance of the {@link Entity}
   * 
   * @param t - Instance of the {@link Entity}
   * @return Instance of the {@link Entity} updated
   */
  T update(T t);

}
