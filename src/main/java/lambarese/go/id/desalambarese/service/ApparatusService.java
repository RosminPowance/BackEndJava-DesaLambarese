/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lambarese.go.id.desalambarese.service;

import java.util.ArrayList;
import java.util.List;
import lambarese.go.id.desalambarese.model.Apparatus;
import lambarese.go.id.desalambarese.model.Role;
import lambarese.go.id.desalambarese.repository.ApparatusRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author LENOVO
 */
@Service
@AllArgsConstructor
public class ApparatusService  {
    
    private ApparatusRepository apparatusRepository;
    private RoleService roleService;
    private PasswordEncoder passwordEncoder;
    
    public List<Apparatus> getAll(){
        return apparatusRepository.findAll();
    }
    
    public Apparatus getById(Long id){
        return apparatusRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Apparatus id not found"
                ));
    }
    
    public Apparatus create(Apparatus apparatus){
        // Set Role
        List<Role> roles = new ArrayList<>();
        roles.add(roleService.getById(1L));
        apparatus.getUser().setRoles(roles);
        
        // Set IsEnabled, IsAccountLocked
        apparatus.getUser().setIsAccountLocked(true);
        apparatus.getUser().setIsEnabled(Boolean.TRUE);
        
        // Set Password
        String password = apparatus.getUser().getPassword();
        apparatus.getUser().setPassword(passwordEncoder.encode(password));
        
        // Set Apparatus in User
        apparatus.getUser().setApparatus(apparatus);
        
        return apparatusRepository.save(apparatus);
    }
    
    public Apparatus update(Long id, Apparatus apparatus){
        getById(id);
        apparatus.setId(id);
        return apparatusRepository.save(apparatus);
    }
    
    public Apparatus delete(Long id){
        Apparatus apparatus = getById(id);
        apparatusRepository.delete(apparatus);
        return apparatus;
    }
}
