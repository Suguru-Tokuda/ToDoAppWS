/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author it354f715
 */
@Entity
@Table(name = "INVITATIONS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Invitations.findAll", query = "SELECT i FROM Invitations i"),
    @NamedQuery(name = "Invitations.findById", query = "SELECT i FROM Invitations i WHERE i.id = :id"),
    @NamedQuery(name = "Invitations.findBySenderid", query = "SELECT i FROM Invitations i WHERE i.senderid = :senderid"),
    @NamedQuery(name = "Invitations.findByReceiverid", query = "SELECT i FROM Invitations i WHERE i.receiverid = :receiverid"),
    @NamedQuery(name = "Invitations.findByTodolistid", query = "SELECT i FROM Invitations i WHERE i.todolistid = :todolistid")})
public class Invitations implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "SENDERID")
    private Integer senderid;
    @Column(name = "RECEIVERID")
    private Integer receiverid;
    @Column(name = "TODOLISTID")
    private Integer todolistid;

    public Invitations() {
    }

    public Invitations(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSenderid() {
        return senderid;
    }

    public void setSenderid(Integer senderid) {
        this.senderid = senderid;
    }

    public Integer getReceiverid() {
        return receiverid;
    }

    public void setReceiverid(Integer receiverid) {
        this.receiverid = receiverid;
    }

    public Integer getTodolistid() {
        return todolistid;
    }

    public void setTodolistid(Integer todolistid) {
        this.todolistid = todolistid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Invitations)) {
            return false;
        }
        Invitations other = (Invitations) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Invitations[ id=" + id + " ]";
    }
    
}
