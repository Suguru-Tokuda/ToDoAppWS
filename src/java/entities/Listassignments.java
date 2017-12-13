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
@Table(name = "LISTASSIGNMENTS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Listassignments.findAll", query = "SELECT l FROM Listassignments l"),
    @NamedQuery(name = "Listassignments.findById", query = "SELECT l FROM Listassignments l WHERE l.id = :id"),
    @NamedQuery(name = "Listassignments.findByUserid", query = "SELECT l FROM Listassignments l WHERE l.userid = :userid"),
    @NamedQuery(name = "Listassignments.findByTodolistid", query = "SELECT l FROM Listassignments l WHERE l.todolistid = :todolistid")})
public class Listassignments implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "USERID")
    private Integer userid;
    @Column(name = "TODOLISTID")
    private Integer todolistid;

    public Listassignments() {
    }

    public Listassignments(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
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
        if (!(object instanceof Listassignments)) {
            return false;
        }
        Listassignments other = (Listassignments) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Listassignments[ id=" + id + " ]";
    }
    
}
