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
@Table(name = "usuariocomprador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuariocomprador.findAll", query = "SELECT u FROM Usuariocomprador u")
    , @NamedQuery(name = "Usuariocomprador.findByIDusuarioComprador", query = "SELECT u FROM Usuariocomprador u WHERE u.iDusuarioComprador = :iDusuarioComprador")
    , @NamedQuery(name = "Usuariocomprador.findByNombreUC", query = "SELECT u FROM Usuariocomprador u WHERE u.nombreUC = :nombreUC")
    , @NamedQuery(name = "Usuariocomprador.findByPasswordUC", query = "SELECT u FROM Usuariocomprador u WHERE u.passwordUC = :passwordUC")})
public class Usuariocomprador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDusuarioComprador")
    private String iDusuarioComprador;
    @Column(name = "nombreUC")
    private String nombreUC;
    @Column(name = "passwordUC")
    private String passwordUC;

    public Usuariocomprador() {
    }

    public Usuariocomprador(String iDusuarioComprador) {
        this.iDusuarioComprador = iDusuarioComprador;
    }

    public String getIDusuarioComprador() {
        return iDusuarioComprador;
    }

    public void setIDusuarioComprador(String iDusuarioComprador) {
        this.iDusuarioComprador = iDusuarioComprador;
    }

    public String getNombreUC() {
        return nombreUC;
    }

    public void setNombreUC(String nombreUC) {
        this.nombreUC = nombreUC;
    }

    public String getPasswordUC() {
        return passwordUC;
    }

    public void setPasswordUC(String passwordUC) {
        this.passwordUC = passwordUC;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDusuarioComprador != null ? iDusuarioComprador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuariocomprador)) {
            return false;
        }
        Usuariocomprador other = (Usuariocomprador) object;
        if ((this.iDusuarioComprador == null && other.iDusuarioComprador != null) || (this.iDusuarioComprador != null && !this.iDusuarioComprador.equals(other.iDusuarioComprador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Usuariocomprador[ iDusuarioComprador=" + iDusuarioComprador + " ]";
    }
    
}
