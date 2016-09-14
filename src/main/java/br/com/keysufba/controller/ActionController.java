package br.com.keysufba.controller;

import java.util.List;

import br.com.keysufba.entity.Action;
import br.com.keysufba.service.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/actions")
public class ActionController {

  @Autowired
  private ActionService actionService;

  @RequestMapping(method = RequestMethod.GET)
  public HttpEntity<List<Action>> getActions() {
    final List<Action> actions = actionService.findAll();
    return new ResponseEntity<>(actions, HttpStatus.OK);
  }

  @RequestMapping(path = "/{id}", method = RequestMethod.GET)
  public HttpEntity<Action> getAction(@PathVariable("id") Integer id) {
    if (id == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    final Action action = actionService.findById(id);
    if (action == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(action, HttpStatus.OK);
  }

  @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public HttpEntity<Action> createAction(@RequestBody Action action) {
    if (action == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    try {
      final Action createdAction = actionService.create(action);
      return new ResponseEntity<>(createdAction, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  @RequestMapping(path = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public HttpEntity<Action> updateAction(@PathVariable("id") Integer id, @RequestBody Action action) {
    if (id == null || action == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    try {
      action.setId(id);
      final Action updatedAction = actionService.update(action);
      if (updatedAction == null) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
      return new ResponseEntity<>(updatedAction, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  @RequestMapping(path = "/{id}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public HttpEntity<Action> deleteAction(@PathVariable("id") Integer id) {
    if (id == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    try {
      final Integer deletedId = actionService.delete(id);
      return new ResponseEntity<>(new Action(deletedId), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

}
