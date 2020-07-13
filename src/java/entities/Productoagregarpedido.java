/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author nacho
 */
@Entity
@Table(name = "productoagregarpedido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Productoagregarpedido.findAll", query = "SELECT p FROM Productoagregarpedido p")
    , @NamedQuery(name = "Productoagregarpedido.findByIDagregarPP", query = "SELECT p FROM Productoagregarpedido p WHERE p.iDagregarPP = :iDagregarPP")
    , @NamedQuery(name = "Productoagregarpedido.findByIDproducto", query = "SELECT p FROM Productoagregarpedido p WHERE p.iDproducto = :iDproducto")
    , @NamedQuery(name = "Productoagregarpedido.findByIDpedido", query = "SELECT p FROM Productoagregarpedido p WHERE p.iDpedido = :iDpedido")
    , @NamedQuery(name = "Productoagregarpedido.findByHoraAgregar", query = "SELECT p FROM Productoagregarpedido p WHERE p.horaAgregar = :horaAgregar")
    , @NamedQuery(name = "Productoagregarpedido.findByFechaAgregar", query = "SELECT p FROM Productoagregarpedido p WHERE p.fechaAgregar = :fechaAgregar")
    , @NamedQuery(name = "Productoagregarpedido.findByEstadoAgregar", query = "SELECT p FROM Productoagregarpedido p WHERE p.estadoAgregar = :estadoAgregar")
    , @NamedQuery(name = "Productoagregarpedido.findByCantidadAgregar", query = "SELECT p FROM Productoagregarpedido p WHERE p.cantidadAgregar = :cantidadAgregar")})
public class Productoagregarpedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDagregarPP")
    private String iDagregarPP;
    @Column(name = "IDproducto")
    private String iDproducto;
    @Column(name = "IDpedido")
    private String iDpedido;
    @Column(name = "horaAgregar")
    @Temporal(TemporalType.TIME)
    private Date horaAgregar;
    @Column(name = "fechaAgregar")
    @Temporal(TemporalType.DATE)
    private Date fechaAgregar;
    @Column(name = "estadoAgregar")
    private Boolean estadoAgregar;
    @Column(name = "cantidadAgregar")
    private Integer cantidadAgregar;

    public Productoagregarpedido() {
    }

    public Productoagregarpedido(String iDagregarPP) {
        this.iDagregarPP = iDagregarPP;
    }

    public String getIDagregarPP() {
        return iDagregarPP;
    }

    public void setIDagregarPP(String iDagregarPP) {
        this.iDagregarPP = iDagregarPP;
    }

    public String getIDproducto() {
        return iDproducto;
    }

    public void setIDproducto(String iDproducto) {
        this.iDproducto = iDproducto;
    }

    public String getIDpedido() {
        return iDpedido;
    }

    public void setIDpedido(String iDpedido) {
        this.iDpedido = iDpedido;
    }

    public Date getHoraAgregar() {
        return horaAgregar;
    }

    public void setHoraAgregar(Date horaAgregar) {
        this.horaAgregar = horaAgregar;
    }

    public Date getFechaAgregar() {
        return fechaAgregar;
    }

    public void setFechaAgregar(Date fechaAgregar) {
        this.fechaAgregar = fechaAgregar;
    }

    public Boolean getEstadoAgregar() {
        return estadoAgregar;
    }

    public void setEstadoAgregar(Boolean estadoAgregar) {
        this.estadoAgregar = estadoAgregar;
    }

    public Integer getCantidadAgregar() {
        return cantidadAgregar;
    }

    public void setCantidadAgregar(Integer cantidadAgregar) {
        this.cantidadAgregar = cantidadAgregar;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDagregarPP != null ? iDagregarPP.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productoagregarpedido)) {
            return false;
        }
        Productoagregarpedido other = (Productoagregarpedido) object;
        if ((this.iDagregarPP == null && other.iDagregarPP != null) || (this.iDagregarPP != null && !this.iDagregarPP.equals(other.iDagregarPP))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Productoagregarpedido[ iDagregarPP=" + iDagregarPP + " ]";
    }
    
}
