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
@Table(name = "usuariolocal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuariolocal.findAll", query = "SELECT u FROM Usuariolocal u")
    , @NamedQuery(name = "Usuariolocal.findByIDusuarioLocal", query = "SELECT u FROM Usuariolocal u WHERE u.iDusuarioLocal = :iDusuarioLocal")
    , @NamedQuery(name = "Usuariolocal.findByNombreUL", query = "SELECT u FROM Usuariolocal u WHERE u.nombreUL = :nombreUL")
    , @NamedQuery(name = "Usuariolocal.findByPasswordUL", query = "SELECT u FROM Usuariolocal u WHERE u.passwordUL = :passwordUL")
    , @NamedQuery(name = "Usuariolocal.findByHoraUL", query = "SELECT u FROM Usuariolocal u WHERE u.horaUL = :horaUL")
    , @NamedQuery(name = "Usuariolocal.findByFechaUL", query = "SELECT u FROM Usuariolocal u WHERE u.fechaUL = :fechaUL")
    , @NamedQuery(name = "Usuariolocal.findByEstadoUL", query = "SELECT u FROM Usuariolocal u WHERE u.estadoUL = :estadoUL")})
public class Usuariolocal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDusuarioLocal")
    private String iDusuarioLocal;
    @Column(name = "nombreUL")
    private String nombreUL;
    @Column(name = "passwordUL")
    private String passwordUL;
    @Column(name = "horaUL")
    @Temporal(TemporalType.TIME)
    private Date horaUL;
    @Column(name = "fechaUL")
    @Temporal(TemporalType.DATE)
    private Date fechaUL;
    @Column(name = "estadoUL")
    private Boolean estadoUL;

    public Usuariolocal() {
    }

    public Usuariolocal(String iDusuarioLocal) {
        this.iDusuarioLocal = iDusuarioLocal;
    }

    public String getIDusuarioLocal() {
        return iDusuarioLocal;
    }

    public void setIDusuarioLocal(String iDusuarioLocal) {
        this.iDusuarioLocal = iDusuarioLocal;
    }

    public String getNombreUL() {
        return nombreUL;
    }

    public void setNombreUL(String nombreUL) {
        this.nombreUL = nombreUL;
    }

    public String getPasswordUL() {
        return passwordUL;
    }

    public void setPasswordUL(String passwordUL) {
        this.passwordUL = passwordUL;
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
        hash += (iDusuarioLocal != null ? iDusuarioLocal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuariolocal)) {
            return false;
        }
        Usuariolocal other = (Usuariolocal) object;
        if ((this.iDusuarioLocal == null && other.iDusuarioLocal != null) || (this.iDusuarioLocal != null && !this.iDusuarioLocal.equals(other.iDusuarioLocal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Usuariolocal[ iDusuarioLocal=" + iDusuarioLocal + " ]";
    }
    
}
