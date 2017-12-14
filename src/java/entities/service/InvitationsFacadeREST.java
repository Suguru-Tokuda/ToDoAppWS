/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.service;

import entities.Invitations;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author it354f715
 */
@Stateless
@Path("entities.invitations")
public class InvitationsFacadeREST extends AbstractFacade<Invitations> {
    @PersistenceContext(unitName = "ToDoAppWSPU")
    private EntityManager em;

    public InvitationsFacadeREST() {
        super(Invitations.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(Invitations entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, Invitations entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Invitations find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Invitations> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Invitations> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }
    
    @GET
    @Path("getInvitationsByReceiveridAndToDoListId/{receiverId}/{todolistid}")
    @Produces({"application/xml", "application/json"})
    public List<Invitations> getInvitationsByReceiverId(@PathParam("receiverId") String receiverId, @PathParam("todolistid") String todolistid) {
        Query q = em.createQuery("SELECT DISTINCT i FROM Invitations i JOIN Users u ON i.receiverid = u.id WHERE i.receiverid = " + receiverId + " AND  i.todolistid = " + todolistid);
        return q.getResultList();
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
