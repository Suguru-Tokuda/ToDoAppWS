/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.service;

import entities.Todolists;
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
@Path("entities.todolists")
public class TodolistsFacadeREST extends AbstractFacade<Todolists> {

    @PersistenceContext(unitName = "ToDoAppWSPU")
    private EntityManager em;

    public TodolistsFacadeREST() {
        super(Todolists.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(Todolists entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, Todolists entity) {
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
    public Todolists find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Todolists> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Todolists> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @GET
    @Path("getToDoListsByUserid/{userid}")
    @Produces({"application/xml", "application/json"})
    public List<Todolists> getToDoListsByUserid(@PathParam("userid") String userid) {
        Query q = em.createQuery("SELECT DISTINCT t FROM Todolists t JOIN Listassignments la ON t.id = la.todolistid JOIN Users u ON la.userid = u.id WHERE la.userid = " + userid);
        System.out.println(q.toString());
        return q.getResultList();
    }
    
    /**
     * SELECT t.* FROM
    itkstu.USERS u JOIN itkstu.LISTASSIGNMENTS la ON u.ID = la.USERID
    JOIN itkstu.TODOLISTS t ON la.TODOLISTID = t.id
    WHERE u.id = 1;

     */
    
    @GET
    @Path("getActiveToDoListsByUserid/{userid}")
    @Produces({"application/xml", "application/json"})
    public List<Todolists> getActiveToDoListsByUserid(@PathParam("userid") String userid) {
        Query q = em.createQuery("SELECT DISTINCT t FROM Todolists t JOIN Listassignments la ON t.id = la.todolistid JOIN Users u ON la.userid = u.id WHERE t.active = true AND la.userid = " + userid);
        return q.getResultList();
    }

    @GET
    @Path("getInactiveToDoListsByUserid/{userid}")
    @Produces({"application/xml", "application/json"})
    public List<Todolists> getInactiveToDoListsByUserid(@PathParam("userid") String userid) {
        Query q = em.createQuery("SELECT DISTINCT t FROM Todolists t JOIN Listassignments la ON t.id = la.todolistid JOIN Users u ON la.userid = u.id WHERE t.active = false AND la.userid = " + userid);
        return q.getResultList();
    }
    
    @GET
    @Path("getToDoListsOrderByIdDesc")
    @Produces({"application/xml", "application/json"})
    public List<Todolists> getToDoListsOrderByIdDec() {
        Query q = em.createQuery("SELECT t FROM Todolists t ORDER BY t.id DESC");
        return q.getResultList();
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
