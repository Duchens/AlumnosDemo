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
@Table(name = "APP_USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AppUsuario.findAll", query = "SELECT a FROM AppUsuario a"),
    @NamedQuery(name = "AppUsuario.findByAppUsuarioId", query = "SELECT a FROM AppUsuario a WHERE a.appUsuarioId = :appUsuarioId"),
    @NamedQuery(name = "AppUsuario.findByUsuarioName", query = "SELECT a FROM AppUsuario a WHERE a.usuarioName = :usuarioName"),
    @NamedQuery(name = "AppUsuario.findByPassword", query = "SELECT a FROM AppUsuario a WHERE a.password = :password")})
public class AppUsuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "APP_USUARIO_ID")
    private Integer appUsuarioId;
    @Size(max = 10)
    @Column(name = "USUARIO_NAME")
    private String usuarioName;
    @Size(max = 15)
    @Column(name = "PASSWORD")
    private String password;
    @JoinTable(name = "APP_USUARIO_ROLE", joinColumns = {
        @JoinColumn(name = "APP_USUARIO_ID", referencedColumnName = "APP_USUARIO_ID")}, inverseJoinColumns = {
        @JoinColumn(name = "USUARIO_ROLE_ID", referencedColumnName = "ROLE_ID")})
    @ManyToMany
    private Collection<UsuarioRole> usuarioRoleCollection;

    public AppUsuario() {
    }

    public AppUsuario(Integer appUsuarioId) {
        this.appUsuarioId = appUsuarioId;
    }

    public Integer getAppUsuarioId() {
        return appUsuarioId;
    }

    public void setAppUsuarioId(Integer appUsuarioId) {
        this.appUsuarioId = appUsuarioId;
    }

    public String getUsuarioName() {
        return usuarioName;
    }

    public void setUsuarioName(String usuarioName) {
        this.usuarioName = usuarioName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @XmlTransient
    public Collection<UsuarioRole> getUsuarioRoleCollection() {
        return usuarioRoleCollection;
    }

    public void setUsuarioRoleCollection(Collection<UsuarioRole> usuarioRoleCollection) {
        this.usuarioRoleCollection = usuarioRoleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (appUsuarioId != null ? appUsuarioId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AppUsuario)) {
            return false;
        }
        AppUsuario other = (AppUsuario) object;
        if ((this.appUsuarioId == null && other.appUsuarioId != null) || (this.appUsuarioId != null && !this.appUsuarioId.equals(other.appUsuarioId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jean.jpa.AppUsuario[ appUsuarioId=" + appUsuarioId + " ]";
    }
    
}
