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
@Table(name = "boleta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Boleta.findAll", query = "SELECT b FROM Boleta b")
    , @NamedQuery(name = "Boleta.findByIDboleta", query = "SELECT b FROM Boleta b WHERE b.iDboleta = :iDboleta")
    , @NamedQuery(name = "Boleta.findByIDpedido", query = "SELECT b FROM Boleta b WHERE b.iDpedido = :iDpedido")
    , @NamedQuery(name = "Boleta.findByIDusuarioAyuda", query = "SELECT b FROM Boleta b WHERE b.iDusuarioAyuda = :iDusuarioAyuda")
    , @NamedQuery(name = "Boleta.findByIDusuarioComprador", query = "SELECT b FROM Boleta b WHERE b.iDusuarioComprador = :iDusuarioComprador")
    , @NamedQuery(name = "Boleta.findByDescripcionBoleta", query = "SELECT b FROM Boleta b WHERE b.descripcionBoleta = :descripcionBoleta")
    , @NamedQuery(name = "Boleta.findByHoraBoleta", query = "SELECT b FROM Boleta b WHERE b.horaBoleta = :horaBoleta")
    , @NamedQuery(name = "Boleta.findByFechaBoleta", query = "SELECT b FROM Boleta b WHERE b.fechaBoleta = :fechaBoleta")
    , @NamedQuery(name = "Boleta.findByEstadoBoleta", query = "SELECT b FROM Boleta b WHERE b.estadoBoleta = :estadoBoleta")
    , @NamedQuery(name = "Boleta.findByPrecioBoleta", query = "SELECT b FROM Boleta b WHERE b.precioBoleta = :precioBoleta")
    , @NamedQuery(name = "Boleta.findByDireccionBoleta", query = "SELECT b FROM Boleta b WHERE b.direccionBoleta = :direccionBoleta")})
public class Boleta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDboleta")
    private String iDboleta;
    @Column(name = "IDpedido")
    private String iDpedido;
    @Column(name = "IDusuarioAyuda")
    private Integer iDusuarioAyuda;
    @Column(name = "IDusuarioComprador")
    private String iDusuarioComprador;
    @Column(name = "descripcionBoleta")
    private String descripcionBoleta;
    @Column(name = "horaBoleta")
    @Temporal(TemporalType.TIME)
    private Date horaBoleta;
    @Column(name = "fechaBoleta")
    @Temporal(TemporalType.DATE)
    private Date fechaBoleta;
    @Column(name = "estadoBoleta")
    private Boolean estadoBoleta;
    @Column(name = "precioBoleta")
    private Integer precioBoleta;
    @Column(name = "direccionBoleta")
    private String direccionBoleta;

    public Boleta() {
    }

    public Boleta(String iDboleta) {
        this.iDboleta = iDboleta;
    }

    public String getIDboleta() {
        return iDboleta;
    }

    public void setIDboleta(String iDboleta) {
        this.iDboleta = iDboleta;
    }

    public String getIDpedido() {
        return iDpedido;
    }

    public void setIDpedido(String iDpedido) {
        this.iDpedido = iDpedido;
    }

    public Integer getIDusuarioAyuda() {
        return iDusuarioAyuda;
    }

    public void setIDusuarioAyuda(Integer iDusuarioAyuda) {
        this.iDusuarioAyuda = iDusuarioAyuda;
    }

    public String getIDusuarioComprador() {
        return iDusuarioComprador;
    }

    public void setIDusuarioComprador(String iDusuarioComprador) {
        this.iDusuarioComprador = iDusuarioComprador;
    }

    public String getDescripcionBoleta() {
        return descripcionBoleta;
    }

    public void setDescripcionBoleta(String descripcionBoleta) {
        this.descripcionBoleta = descripcionBoleta;
    }

    public Date getHoraBoleta() {
        return horaBoleta;
    }

    public void setHoraBoleta(Date horaBoleta) {
        this.horaBoleta = horaBoleta;
    }

    public Date getFechaBoleta() {
        return fechaBoleta;
    }

    public void setFechaBoleta(Date fechaBoleta) {
        this.fechaBoleta = fechaBoleta;
    }

    public Boolean getEstadoBoleta() {
        return estadoBoleta;
    }

    public void setEstadoBoleta(Boolean estadoBoleta) {
        this.estadoBoleta = estadoBoleta;
    }

    public Integer getPrecioBoleta() {
        return precioBoleta;
    }

    public void setPrecioBoleta(Integer precioBoleta) {
        this.precioBoleta = precioBoleta;
    }

    public String getDireccionBoleta() {
        return direccionBoleta;
    }

    public void setDireccionBoleta(String direccionBoleta) {
        this.direccionBoleta = direccionBoleta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDboleta != null ? iDboleta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Boleta)) {
            return false;
        }
        Boleta other = (Boleta) object;
        if ((this.iDboleta == null && other.iDboleta != null) || (this.iDboleta != null && !this.iDboleta.equals(other.iDboleta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Boleta[ iDboleta=" + iDboleta + " ]";
    }
    
}
