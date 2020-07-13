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
@Table(name = "crearua")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Crearua.findAll", query = "SELECT c FROM Crearua c")
    , @NamedQuery(name = "Crearua.findByIDcreacionUA", query = "SELECT c FROM Crearua c WHERE c.iDcreacionUA = :iDcreacionUA")
    , @NamedQuery(name = "Crearua.findByIDususarioLocal", query = "SELECT c FROM Crearua c WHERE c.iDususarioLocal = :iDususarioLocal")
    , @NamedQuery(name = "Crearua.findByIDusuarioAyuda", query = "SELECT c FROM Crearua c WHERE c.iDusuarioAyuda = :iDusuarioAyuda")
    , @NamedQuery(name = "Crearua.findByHoraCracionUA", query = "SELECT c FROM Crearua c WHERE c.horaCracionUA = :horaCracionUA")
    , @NamedQuery(name = "Crearua.findByFechaCreacionUA", query = "SELECT c FROM Crearua c WHERE c.fechaCreacionUA = :fechaCreacionUA")
    , @NamedQuery(name = "Crearua.findByEstadoCreacionUA", query = "SELECT c FROM Crearua c WHERE c.estadoCreacionUA = :estadoCreacionUA")})
public class Crearua implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDcreacionUA")
    private String iDcreacionUA;
    @Column(name = "IDususarioLocal")
    private String iDususarioLocal;
    @Column(name = "IDusuarioAyuda")
    private String iDusuarioAyuda;
    @Column(name = "horaCracionUA")
    @Temporal(TemporalType.TIME)
    private Date horaCracionUA;
    @Column(name = "fechaCreacionUA")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacionUA;
    @Column(name = "estadoCreacionUA")
    private Boolean estadoCreacionUA;

    public Crearua() {
    }

    public Crearua(String iDcreacionUA) {
        this.iDcreacionUA = iDcreacionUA;
    }

    public String getIDcreacionUA() {
        return iDcreacionUA;
    }

    public void setIDcreacionUA(String iDcreacionUA) {
        this.iDcreacionUA = iDcreacionUA;
    }

    public String getIDususarioLocal() {
        return iDususarioLocal;
    }

    public void setIDususarioLocal(String iDususarioLocal) {
        this.iDususarioLocal = iDususarioLocal;
    }

    public String getIDusuarioAyuda() {
        return iDusuarioAyuda;
    }

    public void setIDusuarioAyuda(String iDusuarioAyuda) {
        this.iDusuarioAyuda = iDusuarioAyuda;
    }

    public Date getHoraCracionUA() {
        return horaCracionUA;
    }

    public void setHoraCracionUA(Date horaCracionUA) {
        this.horaCracionUA = horaCracionUA;
    }

    public Date getFechaCreacionUA() {
        return fechaCreacionUA;
    }

    public void setFechaCreacionUA(Date fechaCreacionUA) {
        this.fechaCreacionUA = fechaCreacionUA;
    }

    public Boolean getEstadoCreacionUA() {
        return estadoCreacionUA;
    }

    public void setEstadoCreacionUA(Boolean estadoCreacionUA) {
        this.estadoCreacionUA = estadoCreacionUA;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDcreacionUA != null ? iDcreacionUA.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Crearua)) {
            return false;
        }
        Crearua other = (Crearua) object;
        if ((this.iDcreacionUA == null && other.iDcreacionUA != null) || (this.iDcreacionUA != null && !this.iDcreacionUA.equals(other.iDcreacionUA))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Crearua[ iDcreacionUA=" + iDcreacionUA + " ]";
    }
    
}
