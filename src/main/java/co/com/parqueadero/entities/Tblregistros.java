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
@Table(name = "tblregistros")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tblregistros.findAll", query = "SELECT t FROM Tblregistros t"),
    @NamedQuery(name = "Tblregistros.findByPlaca", query = "SELECT t FROM Tblregistros t WHERE t.placa = :placa"),
    @NamedQuery(name = "Tblregistros.findByNombres", query = "SELECT t FROM Tblregistros t WHERE t.nombres = :nombres"),
    @NamedQuery(name = "Tblregistros.findByCedula", query = "SELECT t FROM Tblregistros t WHERE t.cedula = :cedula"),
    @NamedQuery(name = "Tblregistros.findByContacto", query = "SELECT t FROM Tblregistros t WHERE t.contacto = :contacto"),
    @NamedQuery(name = "Tblregistros.findByBrillada", query = "SELECT t FROM Tblregistros t WHERE t.brillada = :brillada"),
    @NamedQuery(name = "Tblregistros.findByLavada", query = "SELECT t FROM Tblregistros t WHERE t.lavada = :lavada"),
    @NamedQuery(name = "Tblregistros.findByPolichada", query = "SELECT t FROM Tblregistros t WHERE t.polichada = :polichada")})
public class Tblregistros implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "placa")
    private String placa;
    @Column(name = "nombres")
    private String nombres;
    @Column(name = "cedula")
    private String cedula;
    @Column(name = "contacto")
    private String contacto;
    @Column(name = "brillada")
    private String brillada;
    @Column(name = "lavada")
    private String lavada;
    @Column(name = "polichada")
    private String polichada;

    public Tblregistros() {
    }

    public Tblregistros(String placa) {
        this.placa = placa;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getBrillada() {
        return brillada;
    }

    public void setBrillada(String brillada) {
        this.brillada = brillada;
    }

    public String getLavada() {
        return lavada;
    }

    public void setLavada(String lavada) {
        this.lavada = lavada;
    }

    public String getPolichada() {
        return polichada;
    }

    public void setPolichada(String polichada) {
        this.polichada = polichada;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (placa != null ? placa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblregistros)) {
            return false;
        }
        Tblregistros other = (Tblregistros) object;
        if ((this.placa == null && other.placa != null) || (this.placa != null && !this.placa.equals(other.placa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.parqueadero.entities.Tblregistros[ placa=" + placa + " ]";
    }
    
}
