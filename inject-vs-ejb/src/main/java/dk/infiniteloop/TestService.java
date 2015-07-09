/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.infiniteloop;

import dk.infiniteloop.qualifiers.DatabaseOne;
import dk.infiniteloop.qualifiers.DatabaseTwo;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author sieker
 */
@Stateless
public class TestService {
    
    @Inject
    @DatabaseOne
    private MyDatabase dbOne;
    
    @Inject
    @DatabaseTwo
    private MyDatabase dbTwo;
    
}
