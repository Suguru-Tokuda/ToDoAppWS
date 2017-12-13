/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author it354f715
 */
@Entity
@Table(name = "TODOLISTS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Todolists.findAll", query = "SELECT t FROM Todolists t"),
    @NamedQuery(name = "Todolists.findById", query = "SELECT t FROM Todolists t WHERE t.id = :id"),
    @NamedQuery(name = "Todolists.findByActive", query = "SELECT t FROM Todolists t WHERE t.active = :active"),
    @NamedQuery(name = "Todolists.findByTodolistname", query = "SELECT t FROM Todolists t WHERE t.todolistname = :todolistname"),
    @NamedQuery(name = "Todolists.findByCreatedate", query = "SELECT t FROM Todolists t WHERE t.createdate = :createdate")})
public class Todolists implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACTIVE")
    private Boolean active;
    @Size(max = 255)
    @Column(name = "TODOLISTNAME")
    private String todolistname;
    @Column(name = "CREATEDATE")
    @Temporal(TemporalType.DATE)
    private Date createdate;

    public Todolists() {
    }

    public Todolists(Integer id) {
        this.id = id;
    }

    public Todolists(Integer id, Boolean active) {
        this.id = id;
        this.active = active;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getTodolistname() {
        return todolistname;
    }

    public void setTodolistname(String todolistname) {
        this.todolistname = todolistname;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
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
        if (!(object instanceof Todolists)) {
            return false;
        }
        Todolists other = (Todolists) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Todolists[ id=" + id + " ]";
    }
    
}
