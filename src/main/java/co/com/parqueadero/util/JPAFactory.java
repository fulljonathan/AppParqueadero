/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.parqueadero.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author sala304
 */
public class JPAFactory {
    
    private static final EntityManagerFactory FACTORY;
    private static final String UP = "UP_Parking";
    
    static {
        FACTORY = Persistence.createEntityManagerFactory(UP);
    }

    public static EntityManagerFactory getFACTORY() {
        return FACTORY;
    }
            
}
