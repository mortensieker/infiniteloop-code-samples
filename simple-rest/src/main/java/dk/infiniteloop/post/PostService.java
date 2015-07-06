/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.infiniteloop.post;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author sieker
 */
@Stateless
public class PostService {
    
    @PersistenceContext
    EntityManager em;
    
    public List<Post> getAll() {
        return em.createNamedQuery("allPosts", Post.class).getResultList();
    }
    
    public Post create(Post post) {
        return em.merge(post);
    }
    
    public Post get(long id) {
        return em.find(Post.class, id);
    }
    
    public void delete(long id) {
        Post post = get(id);
        em.remove(post);
    }
}
