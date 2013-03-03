/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jean.jpa;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jean
 */
@Entity
@Table(name = "ALUMNO_ORDER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AlumnoOrder.findAll", query = "SELECT a FROM AlumnoOrder a"),
    @NamedQuery(name = "AlumnoOrder.findByAlumnoOrderId", query = "SELECT a FROM AlumnoOrder a WHERE a.alumnoOrderId = :alumnoOrderId"),
    @NamedQuery(name = "AlumnoOrder.findByOrderNumero", query = "SELECT a FROM AlumnoOrder a WHERE a.orderNumero = :orderNumero"),
    @NamedQuery(name = "AlumnoOrder.findByOrderDescription", query = "SELECT a FROM AlumnoOrder a WHERE a.orderDescription = :orderDescription")})
public class AlumnoOrder implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ALUMNO_ORDER_ID")
    private Integer alumnoOrderId;
    @Size(max = 10)
    @Column(name = "ORDER_NUMERO")
    private String orderNumero;
    @Size(max = 200)
    @Column(name = "ORDER_DESCRIPTION")
    private String orderDescription;
    @JoinTable(name = "ORDER_ITEM", joinColumns = {
        @JoinColumn(name = "ALUMNO_ORDER_ID", referencedColumnName = "ALUMNO_ORDER_ID")}, inverseJoinColumns = {
        @JoinColumn(name = "ITEM_ID", referencedColumnName = "ITEM_ID")})
    @ManyToMany
    private Collection<Item> itemCollection;
    @JoinColumn(name = "ALUMNO_ID", referencedColumnName = "ALUMNO_ID")
    @ManyToOne
    private Alumno alumnoId;

    public AlumnoOrder() {
    }

    public AlumnoOrder(Integer alumnoOrderId) {
        this.alumnoOrderId = alumnoOrderId;
    }

    public Integer getAlumnoOrderId() {
        return alumnoOrderId;
    }

    public void setAlumnoOrderId(Integer alumnoOrderId) {
        this.alumnoOrderId = alumnoOrderId;
    }

    public String getOrderNumero() {
        return orderNumero;
    }

    public void setOrderNumero(String orderNumero) {
        this.orderNumero = orderNumero;
    }

    public String getOrderDescription() {
        return orderDescription;
    }

    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }

    @XmlTransient
    public Collection<Item> getItemCollection() {
        return itemCollection;
    }

    public void setItemCollection(Collection<Item> itemCollection) {
        this.itemCollection = itemCollection;
    }

    public Alumno getAlumnoId() {
        return alumnoId;
    }

    public void setAlumnoId(Alumno alumnoId) {
        this.alumnoId = alumnoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (alumnoOrderId != null ? alumnoOrderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AlumnoOrder)) {
            return false;
        }
        AlumnoOrder other = (AlumnoOrder) object;
        if ((this.alumnoOrderId == null && other.alumnoOrderId != null) || (this.alumnoOrderId != null && !this.alumnoOrderId.equals(other.alumnoOrderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jean.jpa.AlumnoOrder[ alumnoOrderId=" + alumnoOrderId + " ]";
    }
    
}
