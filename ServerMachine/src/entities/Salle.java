/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;

/**
 *
 * @author Lachgar
 */
@Entity
@NamedQuery(name = "findAllSalle", query = "from Salle")
@NamedNativeQuery(name = "findAllSallesNative", query = "select * from Salle", resultClass = Salle.class)
public class Salle implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String code;
    
    public Salle() {
    }

    public Salle(String code) {
        this.code = code;
      
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

     

    @Override
    public String toString() {
        return "Salle{" + "id=" + id + ", code=" + code   + '}';
    }

}
