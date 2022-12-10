/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lambarese.go.id.desalambarese.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author LENOVO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_villagers")
public class Villagers {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, name = "villagers_code", length = 16)
  private String code;

  @Column(nullable = false, name = "villagers_name")
  private String name;
  
  @Column(nullable = false, name = "villagers_gender")
  private String gender;
  
  @Column(nullable = false, name = "villagers_address")
  private String address;
  
  @Column(nullable = false, name = "villagers_religion")
  private String religion;

  @Column(nullable = false, name = "villagers_maritalstatus")
  private String maritalstatus;

  @Column(nullable = false, name = "villagers_profession")
  private String profession;

  
  @ManyToOne
  private Hamlet hamlet;
}

