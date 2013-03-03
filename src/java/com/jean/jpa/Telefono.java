/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jean.jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jean
 */
@Entity
@Table(name = "TELEFONO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Telefono.findAll", query = "SELECT t FROM Telefono t"),
    @NamedQuery(name = "Telefono.findByTelefonoId", query = "SELECT t FROM Telefono t WHERE t.telefonoId = :telefonoId"),
    @NamedQuery(name = "Telefono.findByTelefonoNumero", query = "SELECT t FROM Telefono t WHERE t.telefonoNumero = :telefonoNumero")})
public class Telefono implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TELEFONO_ID")
    private Integer telefonoId;
    @Size(max = 12)
    @Column(name = "TELEFONO_NUMERO")
    private String telefonoNumero;
    @JoinColumn(name = "TELEFONO_TYPE_ID", referencedColumnName = "TELEFONO_TYPE_ID")
    @ManyToOne
    private TelefonoType telefonoTypeId;
    @JoinColumn(name = "ALUMNO_ID", referencedColumnName = "ALUMNO_ID")
    @ManyToOne
    private Alumno alumnoId;

    public Telefono() {
    }

    public Telefono(Integer telefonoId) {
        this.telefonoId = telefonoId;
    }

    public Integer getTelefonoId() {
        return telefonoId;
    }

    public void setTelefonoId(Integer telefonoId) {
        this.telefonoId = telefonoId;
    }

    public String getTelefonoNumero() {
        return telefonoNumero;
    }

    public void setTelefonoNumero(String telefonoNumero) {
        this.telefonoNumero = telefonoNumero;
    }

    public TelefonoType getTelefonoTypeId() {
        return telefonoTypeId;
    }

    public void setTelefonoTypeId(TelefonoType telefonoTypeId) {
        this.telefonoTypeId = telefonoTypeId;
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
        hash += (telefonoId != null ? telefonoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Telefono)) {
            return false;
        }
        Telefono other = (Telefono) object;
        if ((this.telefonoId == null && other.telefonoId != null) || (this.telefonoId != null && !this.telefonoId.equals(other.telefonoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jean.jpa.Telefono[ telefonoId=" + telefonoId + " ]";
    }
    
}
