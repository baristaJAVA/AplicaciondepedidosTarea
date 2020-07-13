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
@Table(name = "catalogo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Catalogo.findAll", query = "SELECT c FROM Catalogo c")
    , @NamedQuery(name = "Catalogo.findByIDcatalogo", query = "SELECT c FROM Catalogo c WHERE c.iDcatalogo = :iDcatalogo")
    , @NamedQuery(name = "Catalogo.findByIDTienda", query = "SELECT c FROM Catalogo c WHERE c.iDTienda = :iDTienda")
    , @NamedQuery(name = "Catalogo.findByHoraCatalogo", query = "SELECT c FROM Catalogo c WHERE c.horaCatalogo = :horaCatalogo")
    , @NamedQuery(name = "Catalogo.findByFechaCatalogo", query = "SELECT c FROM Catalogo c WHERE c.fechaCatalogo = :fechaCatalogo")
    , @NamedQuery(name = "Catalogo.findByEstadoCatalogo", query = "SELECT c FROM Catalogo c WHERE c.estadoCatalogo = :estadoCatalogo")})
public class Catalogo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDcatalogo")
    private String iDcatalogo;
    @Column(name = "IDTienda")
    private String iDTienda;
    @Column(name = "horaCatalogo")
    @Temporal(TemporalType.TIME)
    private Date horaCatalogo;
    @Column(name = "fechaCatalogo")
    @Temporal(TemporalType.DATE)
    private Date fechaCatalogo;
    @Column(name = "estadoCatalogo")
    private Boolean estadoCatalogo;

    public Catalogo() {
    }

    public Catalogo(String iDcatalogo) {
        this.iDcatalogo = iDcatalogo;
    }

    public String getIDcatalogo() {
        return iDcatalogo;
    }

    public void setIDcatalogo(String iDcatalogo) {
        this.iDcatalogo = iDcatalogo;
    }

    public String getIDTienda() {
        return iDTienda;
    }

    public void setIDTienda(String iDTienda) {
        this.iDTienda = iDTienda;
    }

    public Date getHoraCatalogo() {
        return horaCatalogo;
    }

    public void setHoraCatalogo(Date horaCatalogo) {
        this.horaCatalogo = horaCatalogo;
    }

    public Date getFechaCatalogo() {
        return fechaCatalogo;
    }

    public void setFechaCatalogo(Date fechaCatalogo) {
        this.fechaCatalogo = fechaCatalogo;
    }

    public Boolean getEstadoCatalogo() {
        return estadoCatalogo;
    }

    public void setEstadoCatalogo(Boolean estadoCatalogo) {
        this.estadoCatalogo = estadoCatalogo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDcatalogo != null ? iDcatalogo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Catalogo)) {
            return false;
        }
        Catalogo other = (Catalogo) object;
        if ((this.iDcatalogo == null && other.iDcatalogo != null) || (this.iDcatalogo != null && !this.iDcatalogo.equals(other.iDcatalogo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Catalogo[ iDcatalogo=" + iDcatalogo + " ]";
    }

}
