/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.infiniteloop.post;

import java.net.URI;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author sieker
 */
@Path("posts")
@Produces(MediaType.APPLICATION_JSON)
public class PostResource {
    
    @Inject
    PostService ps;
    
    @GET
    public List<Post> allPosts() {
        return ps.getAll();
    }
    
    @POST
    public Response create(Post post, @Context UriInfo info) {
        Post np = ps.create(post);
        URI uri = info.getAbsolutePathBuilder().path("/"+np.getId()).build();
        return Response.created(uri).build();
    }

    @GET
    @Path ("{id}")
    public Post get(@PathParam ("id") long id) {
        return ps.get(id);
    }
    
    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") long id) {
        ps.delete(id);
        return Response.status(Response.Status.OK).build();
    }
}
