/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import java.io.Serializable;
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
@Table(name = "gas_info")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GasInfo.findAll", query = "SELECT g FROM GasInfo g")
    , @NamedQuery(name = "GasInfo.findByGasTypeId", query = "SELECT g FROM GasInfo g WHERE g.gasTypeId = :gasTypeId")
    , @NamedQuery(name = "GasInfo.findByGasType", query = "SELECT g FROM GasInfo g WHERE g.gasType = :gasType")})
public class GasInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id @GeneratedValue
    @Basic(optional = false)
    @NotNull
    @Column(name = "gas_type_id")
    private Long gasTypeId;
    @Size(max = 100)
    @Column(name = "gas_type")
    private String gasType;
    @OneToMany(mappedBy = "gasTypeId")
    private Collection<PriceConfiguration> priceConfigurationCollection;
    @OneToMany(mappedBy = "gasTypeId")
    private Collection<Cylinders> cylindersCollection;

    public GasInfo() {
    }

    public GasInfo(Long gasTypeId) {
        this.gasTypeId = gasTypeId;
    }

    public Long getGasTypeId() {
        return gasTypeId;
    }

    public void setGasTypeId(Long gasTypeId) {
        this.gasTypeId = gasTypeId;
    }

    public String getGasType() {
        return gasType;
    }

    public void setGasType(String gasType) {
        this.gasType = gasType;
    }

    @XmlTransient
    public Collection<PriceConfiguration> getPriceConfigurationCollection() {
        return priceConfigurationCollection;
    }

    public void setPriceConfigurationCollection(Collection<PriceConfiguration> priceConfigurationCollection) {
        this.priceConfigurationCollection = priceConfigurationCollection;
    }

    @XmlTransient
    public Collection<Cylinders> getCylindersCollection() {
        return cylindersCollection;
    }

    public void setCylindersCollection(Collection<Cylinders> cylindersCollection) {
        this.cylindersCollection = cylindersCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gasTypeId != null ? gasTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GasInfo)) {
            return false;
        }
        GasInfo other = (GasInfo) object;
        if ((this.gasTypeId == null && other.gasTypeId != null) || (this.gasTypeId != null && !this.gasTypeId.equals(other.gasTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.GasInfo[ gasTypeId=" + gasTypeId + " ]";
    }
    
}
