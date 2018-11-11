/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.PriceConfiguration;
import jpa.PriceConfiguration_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import jpa.Customers;
import jpa.GasInfo;

/**
 *
 * @author umeshn
 */
@Stateless
public class PriceConfigurationFacade extends AbstractFacade<PriceConfiguration> {

    @PersistenceContext(unitName = "AppPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PriceConfigurationFacade() {
        super(PriceConfiguration.class);
    }

    public boolean isCustomerIdEmpty(PriceConfiguration entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<PriceConfiguration> priceConfiguration = cq.from(PriceConfiguration.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(priceConfiguration, entity), cb.isNotNull(priceConfiguration.get(PriceConfiguration_.customerId)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Customers findCustomerId(PriceConfiguration entity) {
        return this.getMergedEntity(entity).getCustomerId();
    }

    public boolean isGasTypeIdEmpty(PriceConfiguration entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<PriceConfiguration> priceConfiguration = cq.from(PriceConfiguration.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(priceConfiguration, entity), cb.isNotNull(priceConfiguration.get(PriceConfiguration_.gasTypeId)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public GasInfo findGasTypeId(PriceConfiguration entity) {
        return this.getMergedEntity(entity).getGasTypeId();
    }
    
}
