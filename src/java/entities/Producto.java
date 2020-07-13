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
@Table(name = "producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p")
    , @NamedQuery(name = "Producto.findByIDproducto", query = "SELECT p FROM Producto p WHERE p.iDproducto = :iDproducto")
    , @NamedQuery(name = "Producto.findByDescripcionProd", query = "SELECT p FROM Producto p WHERE p.descripcionProd = :descripcionProd")
    , @NamedQuery(name = "Producto.findByHoraProd", query = "SELECT p FROM Producto p WHERE p.horaProd = :horaProd")
    , @NamedQuery(name = "Producto.findByFechaProd", query = "SELECT p FROM Producto p WHERE p.fechaProd = :fechaProd")
    , @NamedQuery(name = "Producto.findByEstadoProd", query = "SELECT p FROM Producto p WHERE p.estadoProd = :estadoProd")
    , @NamedQuery(name = "Producto.findByPrecioProd", query = "SELECT p FROM Producto p WHERE p.precioProd = :precioProd")
    , @NamedQuery(name = "Producto.findByStockProd", query = "SELECT p FROM Producto p WHERE p.stockProd = :stockProd")
    , @NamedQuery(name = "Producto.findByStockMinimoProd", query = "SELECT p FROM Producto p WHERE p.stockMinimoProd = :stockMinimoProd")})
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDproducto")
    private String iDproducto;
    @Column(name = "descripcionProd")
    private String descripcionProd;
    @Column(name = "horaProd")
    @Temporal(TemporalType.TIME)
    private Date horaProd;
    @Column(name = "fechaProd")
    @Temporal(TemporalType.DATE)
    private Date fechaProd;
    @Column(name = "estadoProd")
    private Boolean estadoProd;
    @Column(name = "precioProd")
    private Integer precioProd;
    @Column(name = "stockProd")
    private Integer stockProd;
    @Column(name = "stockMinimoProd")
    private Integer stockMinimoProd;

    public Producto() {
    }

    public Producto(String iDproducto) {
        this.iDproducto = iDproducto;
    }

    public String getIDproducto() {
        return iDproducto;
    }

    public void setIDproducto(String iDproducto) {
        this.iDproducto = iDproducto;
    }

    public String getDescripcionProd() {
        return descripcionProd;
    }

    public void setDescripcionProd(String descripcionProd) {
        this.descripcionProd = descripcionProd;
    }

    public Date getHoraProd() {
        return horaProd;
    }

    public void setHoraProd(Date horaProd) {
        this.horaProd = horaProd;
    }

    public Date getFechaProd() {
        return fechaProd;
    }

    public void setFechaProd(Date fechaProd) {
        this.fechaProd = fechaProd;
    }

    public Boolean getEstadoProd() {
        return estadoProd;
    }

    public void setEstadoProd(Boolean estadoProd) {
        this.estadoProd = estadoProd;
    }

    public Integer getPrecioProd() {
        return precioProd;
    }

    public void setPrecioProd(Integer precioProd) {
        this.precioProd = precioProd;
    }

    public Integer getStockProd() {
        return stockProd;
    }

    public void setStockProd(Integer stockProd) {
        this.stockProd = stockProd;
    }

    public Integer getStockMinimoProd() {
        return stockMinimoProd;
    }

    public void setStockMinimoProd(Integer stockMinimoProd) {
        this.stockMinimoProd = stockMinimoProd;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDproducto != null ? iDproducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.iDproducto == null && other.iDproducto != null) || (this.iDproducto != null && !this.iDproducto.equals(other.iDproducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Producto[ iDproducto=" + iDproducto + " ]";
    }
    
}
