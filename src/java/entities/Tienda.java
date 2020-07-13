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
@Table(name = "tienda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tienda.findAll", query = "SELECT t FROM Tienda t")
    , @NamedQuery(name = "Tienda.findByIDtienda", query = "SELECT t FROM Tienda t WHERE t.iDtienda = :iDtienda")
    , @NamedQuery(name = "Tienda.findByIDusuarioLocal", query = "SELECT t FROM Tienda t WHERE t.iDusuarioLocal = :iDusuarioLocal")
    , @NamedQuery(name = "Tienda.findByNombreTienda", query = "SELECT t FROM Tienda t WHERE t.nombreTienda = :nombreTienda")
    , @NamedQuery(name = "Tienda.findByHoraUL", query = "SELECT t FROM Tienda t WHERE t.horaUL = :horaUL")
    , @NamedQuery(name = "Tienda.findByFechaUL", query = "SELECT t FROM Tienda t WHERE t.fechaUL = :fechaUL")
    , @NamedQuery(name = "Tienda.findByEstadoUL", query = "SELECT t FROM Tienda t WHERE t.estadoUL = :estadoUL")})
public class Tienda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDtienda")
    private String iDtienda;
    @Column(name = "IDusuarioLocal")
    private String iDusuarioLocal;
    @Column(name = "nombreTienda")
    private String nombreTienda;
    @Column(name = "horaUL")
    @Temporal(TemporalType.TIME)
    private Date horaUL;
    @Column(name = "fechaUL")
    @Temporal(TemporalType.DATE)
    private Date fechaUL;
    @Column(name = "estadoUL")
    private Boolean estadoUL;

    public Tienda() {
    }

    public Tienda(String iDtienda) {
        this.iDtienda = iDtienda;
    }

    public String getIDtienda() {
        return iDtienda;
    }

    public void setIDtienda(String iDtienda) {
        this.iDtienda = iDtienda;
    }

    public String getIDusuarioLocal() {
        return iDusuarioLocal;
    }

    public void setIDusuarioLocal(String iDusuarioLocal) {
        this.iDusuarioLocal = iDusuarioLocal;
    }

    public String getNombreTienda() {
        return nombreTienda;
    }

    public void setNombreTienda(String nombreTienda) {
        this.nombreTienda = nombreTienda;
    }

    public Date getHoraUL() {
        return horaUL;
    }

    public void setHoraUL(Date horaUL) {
        this.horaUL = horaUL;
    }

    public Date getFechaUL() {
        return fechaUL;
    }

    public void setFechaUL(Date fechaUL) {
        this.fechaUL = fechaUL;
    }

    public Boolean getEstadoUL() {
        return estadoUL;
    }

    public void setEstadoUL(Boolean estadoUL) {
        this.estadoUL = estadoUL;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDtienda != null ? iDtienda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tienda)) {
            return false;
        }
        Tienda other = (Tienda) object;
        if ((this.iDtienda == null && other.iDtienda != null) || (this.iDtienda != null && !this.iDtienda.equals(other.iDtienda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Tienda[ iDtienda=" + iDtienda + " ]";
    }
    
}
