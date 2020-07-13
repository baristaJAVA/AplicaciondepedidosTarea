/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author nacho
 */
public class EntityMain {
    private static final EntityManagerFactory ent = Persistence.createEntityManagerFactory("");
    public EntityMain(){
    
    }
    public static EntityManagerFactory getInstance(){
        
        return ent;
    }
}
