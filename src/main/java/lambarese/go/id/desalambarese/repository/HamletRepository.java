/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lambarese.go.id.desalambarese.repository;

import java.util.Optional;
import lambarese.go.id.desalambarese.model.Hamlet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author LENOVO
 */
@Repository
public interface HamletRepository extends JpaRepository<Hamlet, Long>{
    Optional<Hamlet> findByName(String name);
//Select * FROM user WHERE name="?1"   
}

