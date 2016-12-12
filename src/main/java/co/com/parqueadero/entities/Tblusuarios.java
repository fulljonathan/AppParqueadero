/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.parqueadero.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sala304
 */
@Entity
@Table(name = "tblusuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tblusuarios.findAll", query = "SELECT t FROM Tblusuarios t"),
    @NamedQuery(name = "Tblusuarios.findByUsuario", query = "SELECT t FROM Tblusuarios t WHERE t.usuario = :usuario"),
    @NamedQuery(name = "Tblusuarios.findByUsuarioClave", query = "SELECT t FROM Tblusuarios t WHERE t.usuario = :usuario AND t.clave = :clave"),
    @NamedQuery(name = "Tblusuarios.findByClave", query = "SELECT t FROM Tblusuarios t WHERE t.clave = :clave")})
public class Tblusuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "usuario")
    private String usuario;
    @Column(name = "clave")
    private String clave;

    public Tblusuarios() {
    }

    public Tblusuarios(String usuario) {
        this.usuario = usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuario != null ? usuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblusuarios)) {
            return false;
        }
        Tblusuarios other = (Tblusuarios) object;
        if ((this.usuario == null && other.usuario != null) || (this.usuario != null && !this.usuario.equals(other.usuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.parqueadero.entities.Tblusuarios[ usuario=" + usuario + " ]";
    }
    
}
