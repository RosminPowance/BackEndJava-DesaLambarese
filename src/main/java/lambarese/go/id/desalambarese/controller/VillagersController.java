/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lambarese.go.id.desalambarese.controller;

import java.util.List;
import lambarese.go.id.desalambarese.model.Villagers;
import lambarese.go.id.desalambarese.service.VillagersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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
@RequestMapping("/villagers")
public class VillagersController {

    private VillagersService villagersService;

    @Autowired
    public VillagersController(VillagersService villagersService) {
        this.villagersService = villagersService;
    }

    @GetMapping
    public List<Villagers> getAll() {
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getAuthorities()                );
        return villagersService.getAll();
    }

    @GetMapping("/{id}")
    public Villagers getById(@PathVariable Long id) {
        return villagersService.getById(id);
    }

    @PostMapping
    public Villagers create(@RequestBody Villagers villagers) {
        return villagersService.create(villagers);
    }
    
    @PutMapping("/{id}")
    public Villagers update(@PathVariable Long id, @RequestBody Villagers villagers) {
        return villagersService.update(id, villagers);
    }

    @DeleteMapping("/{id}")
    public Villagers delete(@PathVariable Long id) {
        return villagersService.delete(id);
    }
}
