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
@Table(name = "cylinder_transaction")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CylinderTransaction.findAll", query = "SELECT c FROM CylinderTransaction c")
    , @NamedQuery(name = "CylinderTransaction.findByTransactionId", query = "SELECT c FROM CylinderTransaction c WHERE c.transactionId = :transactionId")
    , @NamedQuery(name = "CylinderTransaction.findByLogOutInvoiceNo", query = "SELECT c FROM CylinderTransaction c WHERE c.logOutInvoiceNo = :logOutInvoiceNo")
    , @NamedQuery(name = "CylinderTransaction.findByLoginDate", query = "SELECT c FROM CylinderTransaction c WHERE c.loginDate = :loginDate")
    , @NamedQuery(name = "CylinderTransaction.findByLoginInvoiceNo", query = "SELECT c FROM CylinderTransaction c WHERE c.loginInvoiceNo = :loginInvoiceNo")
    , @NamedQuery(name = "CylinderTransaction.findByLogOutDate", query = "SELECT c FROM CylinderTransaction c WHERE c.logOutDate = :logOutDate")})
public class CylinderTransaction implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id @GeneratedValue
    @Basic(optional = false)
    @NotNull
    @Column(name = "transaction_id")
    private Long transactionId;
    @Size(max = 255)
    @Column(name = "log_out_invoice_no")
    private String logOutInvoiceNo;
    @Column(name = "login_date")
    @Temporal(TemporalType.DATE)
    private Date loginDate;
    @Size(max = 255)
    @Column(name = "login_invoice_no")
    private String loginInvoiceNo;
    @Column(name = "log_out_date")
    @Temporal(TemporalType.DATE)
    private Date logOutDate;
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    @ManyToOne
    private Customers customerId;
    @JoinColumn(name = "cylinder_id", referencedColumnName = "cylinder_id")
    @ManyToOne
    private Cylinders cylinderId;

    public CylinderTransaction() {
    }

    public CylinderTransaction(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public String getLogOutInvoiceNo() {
        return logOutInvoiceNo;
    }

    public void setLogOutInvoiceNo(String logOutInvoiceNo) {
        this.logOutInvoiceNo = logOutInvoiceNo;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    public String getLoginInvoiceNo() {
        return loginInvoiceNo;
    }

    public void setLoginInvoiceNo(String loginInvoiceNo) {
        this.loginInvoiceNo = loginInvoiceNo;
    }

    public Date getLogOutDate() {
        return logOutDate;
    }

    public void setLogOutDate(Date logOutDate) {
        this.logOutDate = logOutDate;
    }

    public Customers getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customers customerId) {
        this.customerId = customerId;
    }

    public Cylinders getCylinderId() {
        return cylinderId;
    }

    public void setCylinderId(Cylinders cylinderId) {
        this.cylinderId = cylinderId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (transactionId != null ? transactionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CylinderTransaction)) {
            return false;
        }
        CylinderTransaction other = (CylinderTransaction) object;
        if ((this.transactionId == null && other.transactionId != null) || (this.transactionId != null && !this.transactionId.equals(other.transactionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.CylinderTransaction[ transactionId=" + transactionId + " ]";
    }
    
}
