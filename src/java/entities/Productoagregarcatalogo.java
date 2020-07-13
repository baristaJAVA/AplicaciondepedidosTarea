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
@Table(name = "productoagregarcatalogo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Productoagregarcatalogo.findAll", query = "SELECT p FROM Productoagregarcatalogo p")
    , @NamedQuery(name = "Productoagregarcatalogo.findByIDagregarPC", query = "SELECT p FROM Productoagregarcatalogo p WHERE p.iDagregarPC = :iDagregarPC")
    , @NamedQuery(name = "Productoagregarcatalogo.findByIDproducto", query = "SELECT p FROM Productoagregarcatalogo p WHERE p.iDproducto = :iDproducto")
    , @NamedQuery(name = "Productoagregarcatalogo.findByIDcatalogo", query = "SELECT p FROM Productoagregarcatalogo p WHERE p.iDcatalogo = :iDcatalogo")
    , @NamedQuery(name = "Productoagregarcatalogo.findByHoraAgregarPC", query = "SELECT p FROM Productoagregarcatalogo p WHERE p.horaAgregarPC = :horaAgregarPC")
    , @NamedQuery(name = "Productoagregarcatalogo.findByFechaAgregarPC", query = "SELECT p FROM Productoagregarcatalogo p WHERE p.fechaAgregarPC = :fechaAgregarPC")
    , @NamedQuery(name = "Productoagregarcatalogo.findByEstadoAgregarPC", query = "SELECT p FROM Productoagregarcatalogo p WHERE p.estadoAgregarPC = :estadoAgregarPC")
    , @NamedQuery(name = "Productoagregarcatalogo.findByCantidadAgregarPC", query = "SELECT p FROM Productoagregarcatalogo p WHERE p.cantidadAgregarPC = :cantidadAgregarPC")})
public class Productoagregarcatalogo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDagregarPC")
    private String iDagregarPC;
    @Column(name = "IDproducto")
    private String iDproducto;
    @Column(name = "IDcatalogo")
    private String iDcatalogo;
    @Column(name = "horaAgregarPC")
    @Temporal(TemporalType.TIME)
    private Date horaAgregarPC;
    @Column(name = "fechaAgregarPC")
    @Temporal(TemporalType.DATE)
    private Date fechaAgregarPC;
    @Column(name = "estadoAgregarPC")
    private Boolean estadoAgregarPC;
    @Column(name = "cantidadAgregarPC")
    private Integer cantidadAgregarPC;

    public Productoagregarcatalogo() {
    }

    public Productoagregarcatalogo(String iDagregarPC) {
        this.iDagregarPC = iDagregarPC;
    }

    public String getIDagregarPC() {
        return iDagregarPC;
    }

    public void setIDagregarPC(String iDagregarPC) {
        this.iDagregarPC = iDagregarPC;
    }

    public String getIDproducto() {
        return iDproducto;
    }

    public void setIDproducto(String iDproducto) {
        this.iDproducto = iDproducto;
    }

    public String getIDcatalogo() {
        return iDcatalogo;
    }

    public void setIDcatalogo(String iDcatalogo) {
        this.iDcatalogo = iDcatalogo;
    }

    public Date getHoraAgregarPC() {
        return horaAgregarPC;
    }

    public void setHoraAgregarPC(Date horaAgregarPC) {
        this.horaAgregarPC = horaAgregarPC;
    }

    public Date getFechaAgregarPC() {
        return fechaAgregarPC;
    }

    public void setFechaAgregarPC(Date fechaAgregarPC) {
        this.fechaAgregarPC = fechaAgregarPC;
    }

    public Boolean getEstadoAgregarPC() {
        return estadoAgregarPC;
    }

    public void setEstadoAgregarPC(Boolean estadoAgregarPC) {
        this.estadoAgregarPC = estadoAgregarPC;
    }

    public Integer getCantidadAgregarPC() {
        return cantidadAgregarPC;
    }

    public void setCantidadAgregarPC(Integer cantidadAgregarPC) {
        this.cantidadAgregarPC = cantidadAgregarPC;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDagregarPC != null ? iDagregarPC.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productoagregarcatalogo)) {
            return false;
        }
        Productoagregarcatalogo other = (Productoagregarcatalogo) object;
        if ((this.iDagregarPC == null && other.iDagregarPC != null) || (this.iDagregarPC != null && !this.iDagregarPC.equals(other.iDagregarPC))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Productoagregarcatalogo[ iDagregarPC=" + iDagregarPC + " ]";
    }
    
}
