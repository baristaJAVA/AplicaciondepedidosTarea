/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author nacho
 */
@Entity
@Table(name = "usuarioayuda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuarioayuda.findAll", query = "SELECT u FROM Usuarioayuda u")
    , @NamedQuery(name = "Usuarioayuda.findByIDRUTusuarioAyuda", query = "SELECT u FROM Usuarioayuda u WHERE u.iDRUTusuarioAyuda = :iDRUTusuarioAyuda")
    , @NamedQuery(name = "Usuarioayuda.findByNombreUA", query = "SELECT u FROM Usuarioayuda u WHERE u.nombreUA = :nombreUA")
    , @NamedQuery(name = "Usuarioayuda.findByApellidoPaternoUA", query = "SELECT u FROM Usuarioayuda u WHERE u.apellidoPaternoUA = :apellidoPaternoUA")
    , @NamedQuery(name = "Usuarioayuda.findByApellidoMaternoUA", query = "SELECT u FROM Usuarioayuda u WHERE u.apellidoMaternoUA = :apellidoMaternoUA")
    , @NamedQuery(name = "Usuarioayuda.findByTelefonoUA", query = "SELECT u FROM Usuarioayuda u WHERE u.telefonoUA = :telefonoUA")
    , @NamedQuery(name = "Usuarioayuda.findByDireccionUA", query = "SELECT u FROM Usuarioayuda u WHERE u.direccionUA = :direccionUA")})
public class Usuarioayuda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDRUTusuarioAyuda")
    private String iDRUTusuarioAyuda;
    @Column(name = "nombreUA")
    private String nombreUA;
    @Column(name = "apellidoPaternoUA")
    private String apellidoPaternoUA;
    @Column(name = "apellidoMaternoUA")
    private String apellidoMaternoUA;
    @Column(name = "telefonoUA")
    private String telefonoUA;
    @Column(name = "direccionUA")
    private String direccionUA;

    public Usuarioayuda() {
    }

    public Usuarioayuda(String iDRUTusuarioAyuda) {
        this.iDRUTusuarioAyuda = iDRUTusuarioAyuda;
    }

    public String getIDRUTusuarioAyuda() {
        return iDRUTusuarioAyuda;
    }

    public void setIDRUTusuarioAyuda(String iDRUTusuarioAyuda) {
        this.iDRUTusuarioAyuda = iDRUTusuarioAyuda;
    }

    public String getNombreUA() {
        return nombreUA;
    }

    public void setNombreUA(String nombreUA) {
        this.nombreUA = nombreUA;
    }

    public String getApellidoPaternoUA() {
        return apellidoPaternoUA;
    }

    public void setApellidoPaternoUA(String apellidoPaternoUA) {
        this.apellidoPaternoUA = apellidoPaternoUA;
    }

    public String getApellidoMaternoUA() {
        return apellidoMaternoUA;
    }

    public void setApellidoMaternoUA(String apellidoMaternoUA) {
        this.apellidoMaternoUA = apellidoMaternoUA;
    }

    public String getTelefonoUA() {
        return telefonoUA;
    }

    public void setTelefonoUA(String telefonoUA) {
        this.telefonoUA = telefonoUA;
    }

    public String getDireccionUA() {
        return direccionUA;
    }

    public void setDireccionUA(String direccionUA) {
        this.direccionUA = direccionUA;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDRUTusuarioAyuda != null ? iDRUTusuarioAyuda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarioayuda)) {
            return false;
        }
        Usuarioayuda other = (Usuarioayuda) object;
        if ((this.iDRUTusuarioAyuda == null && other.iDRUTusuarioAyuda != null) || (this.iDRUTusuarioAyuda != null && !this.iDRUTusuarioAyuda.equals(other.iDRUTusuarioAyuda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Usuarioayuda[ iDRUTusuarioAyuda=" + iDRUTusuarioAyuda + " ]";
    }
    
}
