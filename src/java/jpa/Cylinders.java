/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author umeshn
 */
@Entity
@Table(name = "cylinders")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cylinders.findAll", query = "SELECT c FROM Cylinders c")
    , @NamedQuery(name = "Cylinders.findByCylinderId", query = "SELECT c FROM Cylinders c WHERE c.cylinderId = :cylinderId")
    , @NamedQuery(name = "Cylinders.findByCapacity", query = "SELECT c FROM Cylinders c WHERE c.capacity = :capacity")
    , @NamedQuery(name = "Cylinders.findByCylinderNumber", query = "SELECT c FROM Cylinders c WHERE c.cylinderNumber = :cylinderNumber")
    , @NamedQuery(name = "Cylinders.findByFree", query = "SELECT c FROM Cylinders c WHERE c.free = :free")
    , @NamedQuery(name = "Cylinders.findByInvoiceDate", query = "SELECT c FROM Cylinders c WHERE c.invoiceDate = :invoiceDate")
    , @NamedQuery(name = "Cylinders.findByInvoiceNumber", query = "SELECT c FROM Cylinders c WHERE c.invoiceNumber = :invoiceNumber")
    , @NamedQuery(name = "Cylinders.findByLastTestDate", query = "SELECT c FROM Cylinders c WHERE c.lastTestDate = :lastTestDate")
    , @NamedQuery(name = "Cylinders.findByManufacturer", query = "SELECT c FROM Cylinders c WHERE c.manufacturer = :manufacturer")
    , @NamedQuery(name = "Cylinders.findByOwnerName", query = "SELECT c FROM Cylinders c WHERE c.ownerName = :ownerName")
    , @NamedQuery(name = "Cylinders.findByRemarks", query = "SELECT c FROM Cylinders c WHERE c.remarks = :remarks")
    , @NamedQuery(name = "Cylinders.findByStatus", query = "SELECT c FROM Cylinders c WHERE c.status = :status")})
public class Cylinders implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id @GeneratedValue
    @Basic(optional = false)
    @NotNull
    @Column(name = "cylinder_id")
    private Long cylinderId;
    @Column(name = "capacity")
    private BigInteger capacity;
    @Size(max = 255)
    @Column(name = "cylinder_number")
    private String cylinderNumber;
    @Column(name = "free")
    private Boolean free;
    @Column(name = "invoice_date")
    @Temporal(TemporalType.DATE)
    private Date invoiceDate;
    @Size(max = 255)
    @Column(name = "invoice_number")
    private String invoiceNumber;
    @Column(name = "last_test_date")
    @Temporal(TemporalType.DATE)
    private Date lastTestDate;
    @Size(max = 255)
    @Column(name = "manufacturer")
    private String manufacturer;
    @Size(max = 255)
    @Column(name = "owner_name")
    private String ownerName;
    @Size(max = 255)
    @Column(name = "remarks")
    private String remarks;
    @Column(name = "status")
    private Character status;
    @OneToMany(mappedBy = "cylinderId")
    private Collection<CylinderTransaction> cylinderTransactionCollection;
    @JoinColumn(name = "gas_type_id", referencedColumnName = "gas_type_id")
    @ManyToOne
    private GasInfo gasTypeId;

    public Cylinders() {
    }

    public Cylinders(Long cylinderId) {
        this.cylinderId = cylinderId;
    }

    public Long getCylinderId() {
        return cylinderId;
    }

    public void setCylinderId(Long cylinderId) {
        this.cylinderId = cylinderId;
    }

    public BigInteger getCapacity() {
        return capacity;
    }

    public void setCapacity(BigInteger capacity) {
        this.capacity = capacity;
    }

    public String getCylinderNumber() {
        return cylinderNumber;
    }

    public void setCylinderNumber(String cylinderNumber) {
        this.cylinderNumber = cylinderNumber;
    }

    public Boolean getFree() {
        return free;
    }

    public void setFree(Boolean free) {
        this.free = free;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public Date getLastTestDate() {
        return lastTestDate;
    }

    public void setLastTestDate(Date lastTestDate) {
        this.lastTestDate = lastTestDate;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<CylinderTransaction> getCylinderTransactionCollection() {
        return cylinderTransactionCollection;
    }

    public void setCylinderTransactionCollection(Collection<CylinderTransaction> cylinderTransactionCollection) {
        this.cylinderTransactionCollection = cylinderTransactionCollection;
    }

    public GasInfo getGasTypeId() {
        return gasTypeId;
    }

    public void setGasTypeId(GasInfo gasTypeId) {
        this.gasTypeId = gasTypeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cylinderId != null ? cylinderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cylinders)) {
            return false;
        }
        Cylinders other = (Cylinders) object;
        if ((this.cylinderId == null && other.cylinderId != null) || (this.cylinderId != null && !this.cylinderId.equals(other.cylinderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.Cylinders[ cylinderId=" + cylinderId + " ]";
    }
    
}
