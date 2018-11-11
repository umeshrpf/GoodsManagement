/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author umeshn
 */
@Entity
@Table(name = "deposits")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Deposits.findAll", query = "SELECT d FROM Deposits d")
    , @NamedQuery(name = "Deposits.findByDepositId", query = "SELECT d FROM Deposits d WHERE d.depositId = :depositId")
    , @NamedQuery(name = "Deposits.findByAmount", query = "SELECT d FROM Deposits d WHERE d.amount = :amount")
    , @NamedQuery(name = "Deposits.findByChequeDate", query = "SELECT d FROM Deposits d WHERE d.chequeDate = :chequeDate")
    , @NamedQuery(name = "Deposits.findByChequeNumber", query = "SELECT d FROM Deposits d WHERE d.chequeNumber = :chequeNumber")
    , @NamedQuery(name = "Deposits.findByDepositDate", query = "SELECT d FROM Deposits d WHERE d.depositDate = :depositDate")
    , @NamedQuery(name = "Deposits.findByStatus", query = "SELECT d FROM Deposits d WHERE d.status = :status")})
public class Deposits implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id @GeneratedValue
    @Basic(optional = false)
    @NotNull
    @Column(name = "deposit_id")
    private Long depositId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "amount")
    private Double amount;
    @Column(name = "cheque_date")
    @Temporal(TemporalType.DATE)
    private Date chequeDate;
    @Size(max = 255)
    @Column(name = "cheque_number")
    private String chequeNumber;
    @Column(name = "deposit_date")
    @Temporal(TemporalType.DATE)
    private Date depositDate;
    @Column(name = "status")
    private Character status;
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    @ManyToOne
    private Customers customerId;

    public Deposits() {
    }

    public Deposits(Long depositId) {
        this.depositId = depositId;
    }

    public Long getDepositId() {
        return depositId;
    }

    public void setDepositId(Long depositId) {
        this.depositId = depositId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getChequeDate() {
        return chequeDate;
    }

    public void setChequeDate(Date chequeDate) {
        this.chequeDate = chequeDate;
    }

    public String getChequeNumber() {
        return chequeNumber;
    }

    public void setChequeNumber(String chequeNumber) {
        this.chequeNumber = chequeNumber;
    }

    public Date getDepositDate() {
        return depositDate;
    }

    public void setDepositDate(Date depositDate) {
        this.depositDate = depositDate;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public Customers getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customers customerId) {
        this.customerId = customerId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (depositId != null ? depositId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Deposits)) {
            return false;
        }
        Deposits other = (Deposits) object;
        if ((this.depositId == null && other.depositId != null) || (this.depositId != null && !this.depositId.equals(other.depositId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.Deposits[ depositId=" + depositId + " ]";
    }
    
}
