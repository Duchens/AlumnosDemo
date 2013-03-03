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
@Table(name = "USUARIO_ROLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioRole.findAll", query = "SELECT u FROM UsuarioRole u"),
    @NamedQuery(name = "UsuarioRole.findByRoleId", query = "SELECT u FROM UsuarioRole u WHERE u.roleId = :roleId"),
    @NamedQuery(name = "UsuarioRole.findByRoleName", query = "SELECT u FROM UsuarioRole u WHERE u.roleName = :roleName")})
public class UsuarioRole implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ROLE_ID")
    private Integer roleId;
    @Size(max = 10)
    @Column(name = "ROLE_NAME")
    private String roleName;
    @ManyToMany(mappedBy = "usuarioRoleCollection")
    private Collection<AppUsuario> appUsuarioCollection;

    public UsuarioRole() {
    }

    public UsuarioRole(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @XmlTransient
    public Collection<AppUsuario> getAppUsuarioCollection() {
        return appUsuarioCollection;
    }

    public void setAppUsuarioCollection(Collection<AppUsuario> appUsuarioCollection) {
        this.appUsuarioCollection = appUsuarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roleId != null ? roleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioRole)) {
            return false;
        }
        UsuarioRole other = (UsuarioRole) object;
        if ((this.roleId == null && other.roleId != null) || (this.roleId != null && !this.roleId.equals(other.roleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jean.jpa.UsuarioRole[ roleId=" + roleId + " ]";
    }
    
}
