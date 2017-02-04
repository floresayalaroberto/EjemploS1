/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aerolinea.entidad;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Alvaro
 */
@Entity
@Table(name = "aeropuerto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aeropuerto.findAll", query = "SELECT a FROM Aeropuerto a"),
    @NamedQuery(name = "Aeropuerto.findByIdaeropuerto", query = "SELECT a FROM Aeropuerto a WHERE a.idaeropuerto = :idaeropuerto"),
    @NamedQuery(name = "Aeropuerto.findByAeropuerto", query = "SELECT a FROM Aeropuerto a WHERE a.aeropuerto = :aeropuerto"),
    @NamedQuery(name = "Aeropuerto.findByCiudad", query = "SELECT a FROM Aeropuerto a WHERE a.ciudad = :ciudad")})
public class Aeropuerto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idaeropuerto")
    private Integer idaeropuerto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "aeropuerto")
    private String aeropuerto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ciudad")
    private String ciudad;
    @JoinColumn(name = "idpais", referencedColumnName = "idpais")
    @ManyToOne(optional = false)
    private Pais idpais;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idorigen")
    private List<Vuelo> vueloList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iddestino")
    private List<Vuelo> vueloList1;

    public Aeropuerto() {
    }

    public Aeropuerto(Integer idaeropuerto) {
        this.idaeropuerto = idaeropuerto;
    }

    public Aeropuerto(Integer idaeropuerto, String aeropuerto, String ciudad) {
        this.idaeropuerto = idaeropuerto;
        this.aeropuerto = aeropuerto;
        this.ciudad = ciudad;
    }

    public Integer getIdaeropuerto() {
        return idaeropuerto;
    }

    public void setIdaeropuerto(Integer idaeropuerto) {
        this.idaeropuerto = idaeropuerto;
    }

    public String getAeropuerto() {
        return aeropuerto;
    }

    public void setAeropuerto(String aeropuerto) {
        this.aeropuerto = aeropuerto;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Pais getIdpais() {
        return idpais;
    }

    public void setIdpais(Pais idpais) {
        this.idpais = idpais;
    }

    @XmlTransient
    public List<Vuelo> getVueloList() {
        return vueloList;
    }

    public void setVueloList(List<Vuelo> vueloList) {
        this.vueloList = vueloList;
    }

    @XmlTransient
    public List<Vuelo> getVueloList1() {
        return vueloList1;
    }

    public void setVueloList1(List<Vuelo> vueloList1) {
        this.vueloList1 = vueloList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idaeropuerto != null ? idaeropuerto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aeropuerto)) {
            return false;
        }
        Aeropuerto other = (Aeropuerto) object;
        if ((this.idaeropuerto == null && other.idaeropuerto != null) || (this.idaeropuerto != null && !this.idaeropuerto.equals(other.idaeropuerto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aerolinea.entidad.Aeropuerto[ idaeropuerto=" + idaeropuerto + " ]";
    }
    
}
