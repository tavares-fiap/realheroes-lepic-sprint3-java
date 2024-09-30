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
 * @author sapat
 */
@Entity
@Table(name = "resident", catalog = "REALHEROES", schema = "")
@NamedQueries({
    @NamedQuery(name = "Resident.findAll", query = "SELECT r FROM Resident r"),
    @NamedQuery(name = "Resident.findByCpf", query = "SELECT r FROM Resident r WHERE r.cpf = :cpf"),
    @NamedQuery(name = "Resident.findByName", query = "SELECT r FROM Resident r WHERE r.name = :name"),
    @NamedQuery(name = "Resident.findByEmail", query = "SELECT r FROM Resident r WHERE r.email = :email"),
    @NamedQuery(name = "Resident.findByAddress", query = "SELECT r FROM Resident r WHERE r.address = :address"),
    @NamedQuery(name = "Resident.findByPassword", query = "SELECT r FROM Resident r WHERE r.password = :password"),
    @NamedQuery(name = "Resident.findByCpfTutor", query = "SELECT r FROM Resident r WHERE r.cpfTutor = :cpfTutor")})
public class Resident implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cpf")
    private String cpf;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "address")
    private String address;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @Column(name = "cpf_tutor")
    private String cpfTutor;

    public Resident() {
    }

    public Resident(String cpf) {
        this.cpf = cpf;
    }

    public Resident(String cpf, String name, String password, String cpfTutor) {
        this.cpf = cpf;
        this.name = name;
        this.password = password;
        this.cpfTutor = cpfTutor;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        String oldCpf = this.cpf;
        this.cpf = cpf;
        changeSupport.firePropertyChange("cpf", oldCpf, cpf);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        changeSupport.firePropertyChange("name", oldName, name);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        String oldEmail = this.email;
        this.email = email;
        changeSupport.firePropertyChange("email", oldEmail, email);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        String oldAddress = this.address;
        this.address = address;
        changeSupport.firePropertyChange("address", oldAddress, address);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        String oldPassword = this.password;
        this.password = password;
        changeSupport.firePropertyChange("password", oldPassword, password);
    }

    public String getCpfTutor() {
        return cpfTutor;
    }

    public void setCpfTutor(String cpfTutor) {
        String oldCpfTutor = this.cpfTutor;
        this.cpfTutor = cpfTutor;
        changeSupport.firePropertyChange("cpfTutor", oldCpfTutor, cpfTutor);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cpf != null ? cpf.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Resident)) {
            return false;
        }
        Resident other = (Resident) object;
        if ((this.cpf == null && other.cpf != null) || (this.cpf != null && !this.cpf.equals(other.cpf))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "View.Resident[ cpf=" + cpf + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
