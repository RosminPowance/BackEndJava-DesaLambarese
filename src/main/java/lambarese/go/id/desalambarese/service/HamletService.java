/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lambarese.go.id.desalambarese.service;

import java.util.List;
import lambarese.go.id.desalambarese.model.Hamlet;
import lambarese.go.id.desalambarese.repository.HamletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author LENOVO
 */
@Service
public class HamletService {

    private HamletRepository hamletRepository;

    @Autowired
    public HamletService(HamletRepository hamletRepository) {
        this.hamletRepository = hamletRepository;
    }

    public List<Hamlet> getAll() {
        return hamletRepository.findAll();
    }

    public Hamlet getById(Long id) {
        return hamletRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Hamlet not found"));
    }

    public Hamlet create(Hamlet hamlet) {
        if (hamlet.getId() != null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Hamlet already exists");
        }
        if (hamletRepository.findByName(hamlet.getName()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Hamlet name already exists");
        }
        return hamletRepository.save(hamlet);
    }

    public Hamlet update(Long id, Hamlet hamlet) {
        getById(id);
        hamlet.setId(id);
        return hamletRepository.save(hamlet);
    }

    public Hamlet delete(Long id) {
        Hamlet hamlet = getById(id);
        hamletRepository.delete(hamlet);
        return hamlet;
    }

}
