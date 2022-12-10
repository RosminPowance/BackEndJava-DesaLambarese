/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lambarese.go.id.desalambarese.controller;

import java.util.List;
import lambarese.go.id.desalambarese.model.Apparatus;
import lambarese.go.id.desalambarese.service.ApparatusService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
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
@RequestMapping("/apparatus")
@AllArgsConstructor
public class ApparatusController {

    private ApparatusService apparatusService;

    @GetMapping
    public List<Apparatus> getAll() {
        return apparatusService.getAll();
    }

    @GetMapping("/{id}")
    public Apparatus getById(@PathVariable Long id) {
        return apparatusService.getById(id);
    }

    @PostMapping
    public Apparatus create(@RequestBody Apparatus apparatus) {
        return apparatusService.create(apparatus);
    }

    @PutMapping("/{id}")
    public Apparatus update(@PathVariable Long id, @RequestBody Apparatus apparatus) {
        return apparatusService.update(id, apparatus);
    }

    @DeleteMapping("/{id}")
    public Apparatus delete(@PathVariable Long id) {
        return apparatusService.delete(id);
    }

}
