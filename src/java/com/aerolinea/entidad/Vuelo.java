/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aerolinea.entidad;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Alvaro
 */
@Entity
@Table(name = "vuelo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vuelo.findAll", query = "SELECT v FROM Vuelo v"),
    @NamedQuery(name = "Vuelo.findByIdvuelo", query = "SELECT v FROM Vuelo v WHERE v.idvuelo = :idvuelo"),
    @NamedQuery(name = "Vuelo.findByFecha", query = "SELECT v FROM Vuelo v WHERE v.fecha = :fecha"),
    @NamedQuery(name = "Vuelo.findByEstado", query = "SELECT v FROM Vuelo v WHERE v.estado = :estado"),
    @NamedQuery(name = "Vuelo.findByPrecio", query = "SELECT v FROM Vuelo v WHERE v.precio = :precio")})
public class Vuelo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idvuelo")
    private Integer idvuelo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Size(max = 13)
    @Column(name = "estado")
    private String estado;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precio")
    private BigDecimal precio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idvuelo")
    private List<Reservacion> reservacionList;
    @JoinColumn(name = "idavion", referencedColumnName = "idavion")
    @ManyToOne(optional = false)
    private Avion idavion;
    @JoinColumn(name = "idorigen", referencedColumnName = "idaeropuerto")
    @ManyToOne(optional = false)
    private Aeropuerto idorigen;
    @JoinColumn(name = "iddestino", referencedColumnName = "idaeropuerto")
    @ManyToOne(optional = false)
    private Aeropuerto iddestino;

    public Vuelo() {
    }

    public Vuelo(Integer idvuelo) {
        this.idvuelo = idvuelo;
    }

    public Vuelo(Integer idvuelo, Date fecha) {
        this.idvuelo = idvuelo;
        this.fecha = fecha;
    }

    public Integer getIdvuelo() {
        return idvuelo;
    }

    public void setIdvuelo(Integer idvuelo) {
        this.idvuelo = idvuelo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    @XmlTransient
    public List<Reservacion> getReservacionList() {
        return reservacionList;
    }

    public void setReservacionList(List<Reservacion> reservacionList) {
        this.reservacionList = reservacionList;
    }

    public Avion getIdavion() {
        return idavion;
    }

    public void setIdavion(Avion idavion) {
        this.idavion = idavion;
    }

    public Aeropuerto getIdorigen() {
        return idorigen;
    }

    public void setIdorigen(Aeropuerto idorigen) {
        this.idorigen = idorigen;
    }

    public Aeropuerto getIddestino() {
        return iddestino;
    }

    public void setIddestino(Aeropuerto iddestino) {
        this.iddestino = iddestino;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idvuelo != null ? idvuelo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vuelo)) {
            return false;
        }
        Vuelo other = (Vuelo) object;
        if ((this.idvuelo == null && other.idvuelo != null) || (this.idvuelo != null && !this.idvuelo.equals(other.idvuelo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aerolinea.entidad.Vuelo[ idvuelo=" + idvuelo + " ]";
    }
    
}
