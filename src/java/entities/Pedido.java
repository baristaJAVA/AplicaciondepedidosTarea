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
@Table(name = "pedido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pedido.findAll", query = "SELECT p FROM Pedido p")
    , @NamedQuery(name = "Pedido.findByIDpedido", query = "SELECT p FROM Pedido p WHERE p.iDpedido = :iDpedido")
    , @NamedQuery(name = "Pedido.findByDescripcionPedido", query = "SELECT p FROM Pedido p WHERE p.descripcionPedido = :descripcionPedido")
    , @NamedQuery(name = "Pedido.findByHoraPedido", query = "SELECT p FROM Pedido p WHERE p.horaPedido = :horaPedido")
    , @NamedQuery(name = "Pedido.findByFechaPedido", query = "SELECT p FROM Pedido p WHERE p.fechaPedido = :fechaPedido")
    , @NamedQuery(name = "Pedido.findByEstadoPedido", query = "SELECT p FROM Pedido p WHERE p.estadoPedido = :estadoPedido")
    , @NamedQuery(name = "Pedido.findByPrecioPedido", query = "SELECT p FROM Pedido p WHERE p.precioPedido = :precioPedido")
    , @NamedQuery(name = "Pedido.findByDireccionPedido", query = "SELECT p FROM Pedido p WHERE p.direccionPedido = :direccionPedido")})
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDpedido")
    private String iDpedido;
    @Column(name = "descripcionPedido")
    private String descripcionPedido;
    @Column(name = "horaPedido")
    @Temporal(TemporalType.TIME)
    private Date horaPedido;
    @Column(name = "fechaPedido")
    @Temporal(TemporalType.DATE)
    private Date fechaPedido;
    @Column(name = "estadoPedido")
    private Boolean estadoPedido;
    @Column(name = "precioPedido")
    private Integer precioPedido;
    @Column(name = "direccionPedido")
    private String direccionPedido;

    public Pedido() {
    }

    public Pedido(String iDpedido) {
        this.iDpedido = iDpedido;
    }

    public String getIDpedido() {
        return iDpedido;
    }

    public void setIDpedido(String iDpedido) {
        this.iDpedido = iDpedido;
    }

    public String getDescripcionPedido() {
        return descripcionPedido;
    }

    public void setDescripcionPedido(String descripcionPedido) {
        this.descripcionPedido = descripcionPedido;
    }

    public Date getHoraPedido() {
        return horaPedido;
    }

    public void setHoraPedido(Date horaPedido) {
        this.horaPedido = horaPedido;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public Boolean getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(Boolean estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    public Integer getPrecioPedido() {
        return precioPedido;
    }

    public void setPrecioPedido(Integer precioPedido) {
        this.precioPedido = precioPedido;
    }

    public String getDireccionPedido() {
        return direccionPedido;
    }

    public void setDireccionPedido(String direccionPedido) {
        this.direccionPedido = direccionPedido;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDpedido != null ? iDpedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedido)) {
            return false;
        }
        Pedido other = (Pedido) object;
        if ((this.iDpedido == null && other.iDpedido != null) || (this.iDpedido != null && !this.iDpedido.equals(other.iDpedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Pedido[ iDpedido=" + iDpedido + " ]";
    }
    
}
