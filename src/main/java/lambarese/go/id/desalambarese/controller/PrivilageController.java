/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lambarese.go.id.desalambarese.controller;

import java.util.List;
import lambarese.go.id.desalambarese.model.Privilage;
import lambarese.go.id.desalambarese.model.Role;
import lambarese.go.id.desalambarese.service.PrivilageService;
import lambarese.go.id.desalambarese.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author LENOVO
 */
@RestController
@AllArgsConstructor
@RequestMapping("/privilage")
public class PrivilageController {
    
    private PrivilageService privilageService;
    
    @GetMapping
    public List<Privilage> getAll() {
        return privilageService.getAll();
    }

    @GetMapping("/{id}")
    public Privilage getById(@PathVariable Long id) {
      return privilageService.getById(id);
    }

    @PostMapping
    public Privilage create(@RequestBody Privilage privilage) {
        return privilageService.create(privilage);
    }

    @PutMapping("/{id}")
    public Privilage update(@PathVariable Long id, @RequestBody Privilage privilage) {
       return privilageService.update(id, privilage);
    }

    @DeleteMapping("/{id}")
    public Privilage delete(@PathVariable Long id) {
      return privilageService.delete(id);
    }
    
}

