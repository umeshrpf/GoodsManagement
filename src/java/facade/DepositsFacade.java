/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.Deposits;
import jpa.Deposits_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import jpa.Customers;

/**
 *
 * @author umeshn
 */
@Stateless
public class DepositsFacade extends AbstractFacade<Deposits> {

    @PersistenceContext(unitName = "AppPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DepositsFacade() {
        super(Deposits.class);
    }

    public boolean isCustomerIdEmpty(Deposits entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Deposits> deposits = cq.from(Deposits.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(deposits, entity), cb.isNotNull(deposits.get(Deposits_.customerId)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Customers findCustomerId(Deposits entity) {
        return this.getMergedEntity(entity).getCustomerId();
    }
    
}
