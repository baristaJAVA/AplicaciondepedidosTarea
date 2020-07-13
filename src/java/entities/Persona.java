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
@Table(name = "persona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p")
    , @NamedQuery(name = "Persona.findByRutUsuario", query = "SELECT p FROM Persona p WHERE p.rutUsuario = :rutUsuario")
    , @NamedQuery(name = "Persona.findByIDusuarioLocal", query = "SELECT p FROM Persona p WHERE p.iDusuarioLocal = :iDusuarioLocal")
    , @NamedQuery(name = "Persona.findByIDusuarioComprador", query = "SELECT p FROM Persona p WHERE p.iDusuarioComprador = :iDusuarioComprador")
    , @NamedQuery(name = "Persona.findByNombreUsuario", query = "SELECT p FROM Persona p WHERE p.nombreUsuario = :nombreUsuario")
    , @NamedQuery(name = "Persona.findByApellidoPaternoUsuario", query = "SELECT p FROM Persona p WHERE p.apellidoPaternoUsuario = :apellidoPaternoUsuario")
    , @NamedQuery(name = "Persona.findByApellidoMaternoUsuario", query = "SELECT p FROM Persona p WHERE p.apellidoMaternoUsuario = :apellidoMaternoUsuario")
    , @NamedQuery(name = "Persona.findByLugarUsuario", query = "SELECT p FROM Persona p WHERE p.lugarUsuario = :lugarUsuario")
    , @NamedQuery(name = "Persona.findByTelefonoUsuario", query = "SELECT p FROM Persona p WHERE p.telefonoUsuario = :telefonoUsuario")
    , @NamedQuery(name = "Persona.findByFechaUsuario", query = "SELECT p FROM Persona p WHERE p.fechaUsuario = :fechaUsuario")
    , @NamedQuery(name = "Persona.findByHoraUsuario", query = "SELECT p FROM Persona p WHERE p.horaUsuario = :horaUsuario")
    , @NamedQuery(name = "Persona.findByEstadoUsuario", query = "SELECT p FROM Persona p WHERE p.estadoUsuario = :estadoUsuario")})
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "RutUsuario")
    private String rutUsuario;
    @Column(name = "IDusuarioLocal")
    private String iDusuarioLocal;
    @Column(name = "IDusuarioComprador")
    private String iDusuarioComprador;
    @Column(name = "nombreUsuario")
    private String nombreUsuario;
    @Column(name = "apellidoPaternoUsuario")
    private String apellidoPaternoUsuario;
    @Column(name = "apellidoMaternoUsuario")
    private String apellidoMaternoUsuario;
    @Column(name = "lugarUsuario")
    private String lugarUsuario;
    @Column(name = "telefonoUsuario")
    private String telefonoUsuario;
    @Column(name = "fechaUsuario")
    @Temporal(TemporalType.DATE)
    private Date fechaUsuario;
    @Column(name = "horaUsuario")
    @Temporal(TemporalType.TIME)
    private Date horaUsuario;
    @Column(name = "estadoUsuario")
    private Boolean estadoUsuario;

    public Persona() {
    }

    public Persona(String rutUsuario) {
        this.rutUsuario = rutUsuario;
    }

    public String getRutUsuario() {
        return rutUsuario;
    }

    public void setRutUsuario(String rutUsuario) {
        this.rutUsuario = rutUsuario;
    }

    public String getIDusuarioLocal() {
        return iDusuarioLocal;
    }

    public void setIDusuarioLocal(String iDusuarioLocal) {
        this.iDusuarioLocal = iDusuarioLocal;
    }

    public String getIDusuarioComprador() {
        return iDusuarioComprador;
    }

    public void setIDusuarioComprador(String iDusuarioComprador) {
        this.iDusuarioComprador = iDusuarioComprador;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidoPaternoUsuario() {
        return apellidoPaternoUsuario;
    }

    public void setApellidoPaternoUsuario(String apellidoPaternoUsuario) {
        this.apellidoPaternoUsuario = apellidoPaternoUsuario;
    }

    public String getApellidoMaternoUsuario() {
        return apellidoMaternoUsuario;
    }

    public void setApellidoMaternoUsuario(String apellidoMaternoUsuario) {
        this.apellidoMaternoUsuario = apellidoMaternoUsuario;
    }

    public String getLugarUsuario() {
        return lugarUsuario;
    }

    public void setLugarUsuario(String lugarUsuario) {
        this.lugarUsuario = lugarUsuario;
    }

    public String getTelefonoUsuario() {
        return telefonoUsuario;
    }

    public void setTelefonoUsuario(String telefonoUsuario) {
        this.telefonoUsuario = telefonoUsuario;
    }

    public Date getFechaUsuario() {
        return fechaUsuario;
    }

    public void setFechaUsuario(Date fechaUsuario) {
        this.fechaUsuario = fechaUsuario;
    }

    public Date getHoraUsuario() {
        return horaUsuario;
    }

    public void setHoraUsuario(Date horaUsuario) {
        this.horaUsuario = horaUsuario;
    }

    public Boolean getEstadoUsuario() {
        return estadoUsuario;
    }

    public void setEstadoUsuario(Boolean estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rutUsuario != null ? rutUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.rutUsuario == null && other.rutUsuario != null) || (this.rutUsuario != null && !this.rutUsuario.equals(other.rutUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Persona[ rutUsuario=" + rutUsuario + " ]";
    }
    
}
