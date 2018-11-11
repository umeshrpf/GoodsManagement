/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author umeshn
 */
@Entity
@Table(name = "customers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Customers.findAll", query = "SELECT c FROM Customers c")
    , @NamedQuery(name = "Customers.findByCustomerId", query = "SELECT c FROM Customers c WHERE c.customerId = :customerId")
    , @NamedQuery(name = "Customers.findByContactNumber", query = "SELECT c FROM Customers c WHERE c.contactNumber = :contactNumber")
    , @NamedQuery(name = "Customers.findByContactPerson", query = "SELECT c FROM Customers c WHERE c.contactPerson = :contactPerson")
    , @NamedQuery(name = "Customers.findByCustomerAddress", query = "SELECT c FROM Customers c WHERE c.customerAddress = :customerAddress")
    , @NamedQuery(name = "Customers.findByDumbrage0To15", query = "SELECT c FROM Customers c WHERE c.dumbrage0To15 = :dumbrage0To15")
    , @NamedQuery(name = "Customers.findByDumbrage15To30", query = "SELECT c FROM Customers c WHERE c.dumbrage15To30 = :dumbrage15To30")
    , @NamedQuery(name = "Customers.findByDumbrage30To45", query = "SELECT c FROM Customers c WHERE c.dumbrage30To45 = :dumbrage30To45")
    , @NamedQuery(name = "Customers.findByDumbrage45To60", query = "SELECT c FROM Customers c WHERE c.dumbrage45To60 = :dumbrage45To60")
    , @NamedQuery(name = "Customers.findByDumbrageOver90", query = "SELECT c FROM Customers c WHERE c.dumbrageOver90 = :dumbrageOver90")
    , @NamedQuery(name = "Customers.findByFullName", query = "SELECT c FROM Customers c WHERE c.fullName = :fullName")
    , @NamedQuery(name = "Customers.findByGstNumber", query = "SELECT c FROM Customers c WHERE c.gstNumber = :gstNumber")
    , @NamedQuery(name = "Customers.findByShortName", query = "SELECT c FROM Customers c WHERE c.shortName = :shortName")
    , @NamedQuery(name = "Customers.findByStatus", query = "SELECT c FROM Customers c WHERE c.status = :status")})
public class Customers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id @GeneratedValue
    @Basic(optional = false)
    @NotNull
    @Column(name = "customer_id")
    private Long customerId;
    @Column(name = "contact_number")
    private BigInteger contactNumber;
    @Size(max = 255)
    @Column(name = "contact_person")
    private String contactPerson;
    @Size(max = 255)
    @Column(name = "customer_address")
    private String customerAddress;
    @Column(name = "dumbrage_0_to_15")
    private BigInteger dumbrage0To15;
    @Column(name = "dumbrage_15_to_30")
    private BigInteger dumbrage15To30;
    @Column(name = "dumbrage_30_to_45")
    private BigInteger dumbrage30To45;
    @Column(name = "dumbrage_45_to_60")
    private BigInteger dumbrage45To60;
    @Column(name = "dumbrage_over_90")
    private BigInteger dumbrageOver90;
    @Size(max = 255)
    @Column(name = "full_name")
    private String fullName;
    @Size(max = 255)
    @Column(name = "gst_number")
    private String gstNumber;
    @Size(max = 255)
    @Column(name = "short_name")
    private String shortName;
    @Column(name = "status")
    private Character status;
    @OneToMany(mappedBy = "customerId")
    private Collection<PriceConfiguration> priceConfigurationCollection;
    @OneToMany(mappedBy = "customerId")
    private Collection<CylinderTransaction> cylinderTransactionCollection;
    @OneToMany(mappedBy = "customerId")
    private Collection<Deposits> depositsCollection;

    public Customers() {
    }

    public Customers(Long customerId) {
        this.customerId = customerId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public BigInteger getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(BigInteger contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public BigInteger getDumbrage0To15() {
        return dumbrage0To15;
    }

    public void setDumbrage0To15(BigInteger dumbrage0To15) {
        this.dumbrage0To15 = dumbrage0To15;
    }

    public BigInteger getDumbrage15To30() {
        return dumbrage15To30;
    }

    public void setDumbrage15To30(BigInteger dumbrage15To30) {
        this.dumbrage15To30 = dumbrage15To30;
    }

    public BigInteger getDumbrage30To45() {
        return dumbrage30To45;
    }

    public void setDumbrage30To45(BigInteger dumbrage30To45) {
        this.dumbrage30To45 = dumbrage30To45;
    }

    public BigInteger getDumbrage45To60() {
        return dumbrage45To60;
    }

    public void setDumbrage45To60(BigInteger dumbrage45To60) {
        this.dumbrage45To60 = dumbrage45To60;
    }

    public BigInteger getDumbrageOver90() {
        return dumbrageOver90;
    }

    public void setDumbrageOver90(BigInteger dumbrageOver90) {
        this.dumbrageOver90 = dumbrageOver90;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGstNumber() {
        return gstNumber;
    }

    public void setGstNumber(String gstNumber) {
        this.gstNumber = gstNumber;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<PriceConfiguration> getPriceConfigurationCollection() {
        return priceConfigurationCollection;
    }

    public void setPriceConfigurationCollection(Collection<PriceConfiguration> priceConfigurationCollection) {
        this.priceConfigurationCollection = priceConfigurationCollection;
    }

    @XmlTransient
    public Collection<CylinderTransaction> getCylinderTransactionCollection() {
        return cylinderTransactionCollection;
    }

    public void setCylinderTransactionCollection(Collection<CylinderTransaction> cylinderTransactionCollection) {
        this.cylinderTransactionCollection = cylinderTransactionCollection;
    }

    @XmlTransient
    public Collection<Deposits> getDepositsCollection() {
        return depositsCollection;
    }

    public void setDepositsCollection(Collection<Deposits> depositsCollection) {
        this.depositsCollection = depositsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (customerId != null ? customerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customers)) {
            return false;
        }
        Customers other = (Customers) object;
        if ((this.customerId == null && other.customerId != null) || (this.customerId != null && !this.customerId.equals(other.customerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.Customers[ customerId=" + customerId + " ]";
    }
    
}
