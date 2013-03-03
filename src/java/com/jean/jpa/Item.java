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
import javax.persistence.ManyToMany;
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
@Table(name = "ITEM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Item.findAll", query = "SELECT i FROM Item i"),
    @NamedQuery(name = "Item.findByItemId", query = "SELECT i FROM Item i WHERE i.itemId = :itemId"),
    @NamedQuery(name = "Item.findByItemNumero", query = "SELECT i FROM Item i WHERE i.itemNumero = :itemNumero"),
    @NamedQuery(name = "Item.findByItemShortDesc", query = "SELECT i FROM Item i WHERE i.itemShortDesc = :itemShortDesc"),
    @NamedQuery(name = "Item.findByItemLongDesc", query = "SELECT i FROM Item i WHERE i.itemLongDesc = :itemLongDesc")})
public class Item implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ITEM_ID")
    private Integer itemId;
    @Size(max = 10)
    @Column(name = "ITEM_NUMERO")
    private String itemNumero;
    @Size(max = 100)
    @Column(name = "ITEM_SHORT_DESC")
    private String itemShortDesc;
    @Size(max = 500)
    @Column(name = "ITEM_LONG_DESC")
    private String itemLongDesc;
    @ManyToMany(mappedBy = "itemCollection")
    private Collection<AlumnoOrder> alumnoOrderCollection;

    public Item() {
    }

    public Item(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getItemNumero() {
        return itemNumero;
    }

    public void setItemNumero(String itemNumero) {
        this.itemNumero = itemNumero;
    }

    public String getItemShortDesc() {
        return itemShortDesc;
    }

    public void setItemShortDesc(String itemShortDesc) {
        this.itemShortDesc = itemShortDesc;
    }

    public String getItemLongDesc() {
        return itemLongDesc;
    }

    public void setItemLongDesc(String itemLongDesc) {
        this.itemLongDesc = itemLongDesc;
    }

    @XmlTransient
    public Collection<AlumnoOrder> getAlumnoOrderCollection() {
        return alumnoOrderCollection;
    }

    public void setAlumnoOrderCollection(Collection<AlumnoOrder> alumnoOrderCollection) {
        this.alumnoOrderCollection = alumnoOrderCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemId != null ? itemId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Item)) {
            return false;
        }
        Item other = (Item) object;
        if ((this.itemId == null && other.itemId != null) || (this.itemId != null && !this.itemId.equals(other.itemId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jean.jpa.Item[ itemId=" + itemId + " ]";
    }
    
}
