/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author umeshn
 */
@Entity
@Table(name = "price_configuration")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PriceConfiguration.findAll", query = "SELECT p FROM PriceConfiguration p")
    , @NamedQuery(name = "PriceConfiguration.findByPriceConfigId", query = "SELECT p FROM PriceConfiguration p WHERE p.priceConfigId = :priceConfigId")
    , @NamedQuery(name = "PriceConfiguration.findByPrice", query = "SELECT p FROM PriceConfiguration p WHERE p.price = :price")})
public class PriceConfiguration implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id @GeneratedValue
    @Basic(optional = false)
    @NotNull
    @Column(name = "price_config_id")
    private Long priceConfigId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "price")
    private Double price;
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    @ManyToOne
    private Customers customerId;
    @JoinColumn(name = "gas_type_id", referencedColumnName = "gas_type_id")
    @ManyToOne
    private GasInfo gasTypeId;

    public PriceConfiguration() {
    }

    public PriceConfiguration(Long priceConfigId) {
        this.priceConfigId = priceConfigId;
    }

    public Long getPriceConfigId() {
        return priceConfigId;
    }

    public void setPriceConfigId(Long priceConfigId) {
        this.priceConfigId = priceConfigId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Customers getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customers customerId) {
        this.customerId = customerId;
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
        hash += (priceConfigId != null ? priceConfigId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PriceConfiguration)) {
            return false;
        }
        PriceConfiguration other = (PriceConfiguration) object;
        if ((this.priceConfigId == null && other.priceConfigId != null) || (this.priceConfigId != null && !this.priceConfigId.equals(other.priceConfigId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.PriceConfiguration[ priceConfigId=" + priceConfigId + " ]";
    }
    
}
