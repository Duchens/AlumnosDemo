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
@Table(name = "DIRECCION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Direccion.findAll", query = "SELECT d FROM Direccion d"),
    @NamedQuery(name = "Direccion.findByDireccionId", query = "SELECT d FROM Direccion d WHERE d.direccionId = :direccionId"),
    @NamedQuery(name = "Direccion.findByDirecLinea1", query = "SELECT d FROM Direccion d WHERE d.direcLinea1 = :direcLinea1"),
    @NamedQuery(name = "Direccion.findByDirecLinea2", query = "SELECT d FROM Direccion d WHERE d.direcLinea2 = :direcLinea2"),
    @NamedQuery(name = "Direccion.findByCiudad", query = "SELECT d FROM Direccion d WHERE d.ciudad = :ciudad"),
    @NamedQuery(name = "Direccion.findByCp", query = "SELECT d FROM Direccion d WHERE d.cp = :cp")})
public class Direccion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "DIRECCION_ID")
    private Integer direccionId;
    @Size(max = 100)
    @Column(name = "DIREC_LINEA_1")
    private String direcLinea1;
    @Size(max = 100)
    @Column(name = "DIREC_LINEA_2")
    private String direcLinea2;
    @Size(max = 100)
    @Column(name = "CIUDAD")
    private String ciudad;
    @Size(max = 5)
    @Column(name = "CP")
    private String cp;
    @JoinColumn(name = "ES_PROV_ID", referencedColumnName = "ES_PROV_ID")
    @ManyToOne
    private EsProv esProvId;
    @JoinColumn(name = "DIRECCION_TYPE_ID", referencedColumnName = "DIRECCION_TYPE_ID")
    @ManyToOne
    private DireccionType direccionTypeId;
    @JoinColumn(name = "ALUMNO_ID", referencedColumnName = "ALUMNO_ID")
    @ManyToOne
    private Alumno alumnoId;

    public Direccion() {
    }

    public Direccion(Integer direccionId) {
        this.direccionId = direccionId;
    }

    public Integer getDireccionId() {
        return direccionId;
    }

    public void setDireccionId(Integer direccionId) {
        this.direccionId = direccionId;
    }

    public String getDirecLinea1() {
        return direcLinea1;
    }

    public void setDirecLinea1(String direcLinea1) {
        this.direcLinea1 = direcLinea1;
    }

    public String getDirecLinea2() {
        return direcLinea2;
    }

    public void setDirecLinea2(String direcLinea2) {
        this.direcLinea2 = direcLinea2;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public EsProv getEsProvId() {
        return esProvId;
    }

    public void setEsProvId(EsProv esProvId) {
        this.esProvId = esProvId;
    }

    public DireccionType getDireccionTypeId() {
        return direccionTypeId;
    }

    public void setDireccionTypeId(DireccionType direccionTypeId) {
        this.direccionTypeId = direccionTypeId;
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
        hash += (direccionId != null ? direccionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Direccion)) {
            return false;
        }
        Direccion other = (Direccion) object;
        if ((this.direccionId == null && other.direccionId != null) || (this.direccionId != null && !this.direccionId.equals(other.direccionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jean.jpa.Direccion[ direccionId=" + direccionId + " ]";
    }
    
}
