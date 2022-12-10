/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lambarese.go.id.desalambarese.service;

import java.util.List;
import lambarese.go.id.desalambarese.model.Villagers;
import lambarese.go.id.desalambarese.repository.VillagersRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author LENOVO
 */
@Service
@AllArgsConstructor
public class VillagersService {

    private VillagersRepository villagersRepository;

    public List<Villagers> getAll() {
        return villagersRepository.findAll();
    }

    public Villagers getById(Long id) {
        return villagersRepository
                .findById(id)
                .orElseThrow(()
                        -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Villagers not found")
                );
    }

    public Villagers create(Villagers villagers) {
        if (villagers.getId() != null) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "villagers already exists"
            );
        }
        if (villagersRepository.existsByName(villagers.getName())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Villagers name already exists");
        }
        return villagersRepository.save(villagers);
    }

    public Villagers update(Long id, Villagers villagers) {
        getById(id);
        villagers.setId(id);
        return villagersRepository.save(villagers);
    }

    public Villagers delete(Long id) {
        Villagers villagers = getById(id);
        villagersRepository.delete(villagers);
        return villagers;
    }
}
