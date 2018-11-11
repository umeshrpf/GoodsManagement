/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.Customers;
import jpa.Customers_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import jpa.PriceConfiguration;
import jpa.CylinderTransaction;
import jpa.Deposits;

/**
 *
 * @author umeshn
 */
@Stateless
public class CustomersFacade extends AbstractFacade<Customers> {

    @PersistenceContext(unitName = "AppPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CustomersFacade() {
        super(Customers.class);
    }

    public boolean isPriceConfigurationCollectionEmpty(Customers entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Customers> customers = cq.from(Customers.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(customers, entity), cb.isNotEmpty(customers.get(Customers_.priceConfigurationCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<PriceConfiguration> findPriceConfigurationCollection(Customers entity) {
        Customers mergedEntity = this.getMergedEntity(entity);
        Collection<PriceConfiguration> priceConfigurationCollection = mergedEntity.getPriceConfigurationCollection();
        priceConfigurationCollection.size();
        return priceConfigurationCollection;
    }

    public boolean isCylinderTransactionCollectionEmpty(Customers entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Customers> customers = cq.from(Customers.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(customers, entity), cb.isNotEmpty(customers.get(Customers_.cylinderTransactionCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<CylinderTransaction> findCylinderTransactionCollection(Customers entity) {
        Customers mergedEntity = this.getMergedEntity(entity);
        Collection<CylinderTransaction> cylinderTransactionCollection = mergedEntity.getCylinderTransactionCollection();
        cylinderTransactionCollection.size();
        return cylinderTransactionCollection;
    }

    public boolean isDepositsCollectionEmpty(Customers entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Customers> customers = cq.from(Customers.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(customers, entity), cb.isNotEmpty(customers.get(Customers_.depositsCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<Deposits> findDepositsCollection(Customers entity) {
        Customers mergedEntity = this.getMergedEntity(entity);
        Collection<Deposits> depositsCollection = mergedEntity.getDepositsCollection();
        depositsCollection.size();
        return depositsCollection;
    }
    
}
