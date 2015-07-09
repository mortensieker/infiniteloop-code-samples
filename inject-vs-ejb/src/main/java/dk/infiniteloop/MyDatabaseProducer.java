/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.infiniteloop;

import dk.infiniteloop.qualifiers.DatabaseOne;
import dk.infiniteloop.qualifiers.DatabaseTwo;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author sieker
 */
public class MyDatabaseProducer {

    @Produces
    @DatabaseOne
    public MyDatabase createDatabaseOne() {
        return () -> "MyDatabaseOne";
    }
    
    @Produces
    @DatabaseTwo
    public MyDatabase createDatabaseTwo() {
        return () -> "MyDatabaseTwo";
    }
}
