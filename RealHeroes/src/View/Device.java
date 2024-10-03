/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author labsfiap
 */
@Entity
@Table(name = "device", catalog = "realheroes", schema = "")
@NamedQueries({
    @NamedQuery(name = "Device.findAll", query = "SELECT d FROM Device d"),
    @NamedQuery(name = "Device.findByIDdevice", query = "SELECT d FROM Device d WHERE d.iDdevice = :iDdevice"),
    @NamedQuery(name = "Device.findByDescription", query = "SELECT d FROM Device d WHERE d.description = :description"),
    @NamedQuery(name = "Device.findByMarca", query = "SELECT d FROM Device d WHERE d.marca = :marca")})
public class Device implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDdevice")
    private Integer iDdevice;
    @Basic(optional = false)
    @Column(name = "Description")
    private String description;
    @Column(name = "Marca")
    private String marca;

    public Device() {
    }

    public Device(Integer iDdevice) {
        this.iDdevice = iDdevice;
    }

    public Device(Integer iDdevice, String description) {
        this.iDdevice = iDdevice;
        this.description = description;
    }

    public Integer getIDdevice() {
        return iDdevice;
    }

    public void setIDdevice(Integer iDdevice) {
        Integer oldIDdevice = this.iDdevice;
        this.iDdevice = iDdevice;
        changeSupport.firePropertyChange("IDdevice", oldIDdevice, iDdevice);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        String oldDescription = this.description;
        this.description = description;
        changeSupport.firePropertyChange("description", oldDescription, description);
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        String oldMarca = this.marca;
        this.marca = marca;
        changeSupport.firePropertyChange("marca", oldMarca, marca);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDdevice != null ? iDdevice.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Device)) {
            return false;
        }
        Device other = (Device) object;
        if ((this.iDdevice == null && other.iDdevice != null) || (this.iDdevice != null && !this.iDdevice.equals(other.iDdevice))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "View.Device[ iDdevice=" + iDdevice + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
