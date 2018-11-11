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
import jpa.Cylinders;
import jpa.Cylinders_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import jpa.CylinderTransaction;
import jpa.GasInfo;

/**
 *
 * @author umeshn
 */
@Stateless
public class CylindersFacade extends AbstractFacade<Cylinders> {

    @PersistenceContext(unitName = "AppPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CylindersFacade() {
        super(Cylinders.class);
    }

    public boolean isCylinderTransactionCollectionEmpty(Cylinders entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Cylinders> cylinders = cq.from(Cylinders.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(cylinders, entity), cb.isNotEmpty(cylinders.get(Cylinders_.cylinderTransactionCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<CylinderTransaction> findCylinderTransactionCollection(Cylinders entity) {
        Cylinders mergedEntity = this.getMergedEntity(entity);
        Collection<CylinderTransaction> cylinderTransactionCollection = mergedEntity.getCylinderTransactionCollection();
        cylinderTransactionCollection.size();
        return cylinderTransactionCollection;
    }

    public boolean isGasTypeIdEmpty(Cylinders entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Cylinders> cylinders = cq.from(Cylinders.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(cylinders, entity), cb.isNotNull(cylinders.get(Cylinders_.gasTypeId)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public GasInfo findGasTypeId(Cylinders entity) {
        return this.getMergedEntity(entity).getGasTypeId();
    }
    
}
