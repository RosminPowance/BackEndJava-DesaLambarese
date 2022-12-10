/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lambarese.go.id.desalambarese.controller;

import java.util.List;
import lambarese.go.id.desalambarese.model.Hamlet;
import lambarese.go.id.desalambarese.service.HamletService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/hamlet")
public class HamletController {

    private HamletService hamletService;

    @Autowired
    public HamletController(HamletService hamletService) {
        this.hamletService = hamletService;
    }

    @GetMapping
    public List<Hamlet> getAll() {
        return hamletService.getAll();
    }

    @GetMapping("/{id}")
    public Hamlet getById(@PathVariable Long id) {
        return hamletService.getById(id);
    }

    @PostMapping
    public Hamlet create(@RequestBody Hamlet hamlet) {
        return hamletService.create(hamlet);
    }
    
    @PutMapping("/{id}")
    public Hamlet update(@PathVariable Long id, @RequestBody Hamlet hamlet) {
        return hamletService.update(id, hamlet);
    }

    @DeleteMapping("/{id}")
    public Hamlet delete(@PathVariable Long id) {
        return hamletService.delete(id);
    }
}

