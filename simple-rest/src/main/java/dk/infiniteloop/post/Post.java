/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.infiniteloop.post;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sieker
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@NamedQuery(name = "allPosts", query = "SELECT p FROM Post p")
public class Post {
    
    @Id
    @GeneratedValue
    public long id;
    
    @NotNull
    public String name;

    public long getId() {
        return id;
    }
    
    
}
