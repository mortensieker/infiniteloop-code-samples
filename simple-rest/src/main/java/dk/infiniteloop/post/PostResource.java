/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.infiniteloop.post;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author sieker
 */
@Path("posts")
public class PostResource {

    @GET
    public JsonObject get() {
        return Json.createObjectBuilder().add("simple", "rest").build();
    }
}
