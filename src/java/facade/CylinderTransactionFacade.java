/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.CylinderTransaction;
import jpa.CylinderTransaction_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import jpa.Customers;
import jpa.Cylinders;

/**
 *
 * @author umeshn
 */
@Stateless
public class CylinderTransactionFacade extends AbstractFacade<CylinderTransaction> {

    @PersistenceContext(unitName = "AppPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CylinderTransactionFacade() {
        super(CylinderTransaction.class);
    }

    public boolean isCustomerIdEmpty(CylinderTransaction entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<CylinderTransaction> cylinderTransaction = cq.from(CylinderTransaction.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(cylinderTransaction, entity), cb.isNotNull(cylinderTransaction.get(CylinderTransaction_.customerId)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Customers findCustomerId(CylinderTransaction entity) {
        return this.getMergedEntity(entity).getCustomerId();
    }

    public boolean isCylinderIdEmpty(CylinderTransaction entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<CylinderTransaction> cylinderTransaction = cq.from(CylinderTransaction.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(cylinderTransaction, entity), cb.isNotNull(cylinderTransaction.get(CylinderTransaction_.cylinderId)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Cylinders findCylinderId(CylinderTransaction entity) {
        return this.getMergedEntity(entity).getCylinderId();
    }
    
}
