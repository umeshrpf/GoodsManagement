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
import jpa.GasInfo;
import jpa.GasInfo_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import jpa.PriceConfiguration;
import jpa.Cylinders;

/**
 *
 * @author umeshn
 */
@Stateless
public class GasInfoFacade extends AbstractFacade<GasInfo> {

    @PersistenceContext(unitName = "AppPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GasInfoFacade() {
        super(GasInfo.class);
    }

    public boolean isPriceConfigurationCollectionEmpty(GasInfo entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<GasInfo> gasInfo = cq.from(GasInfo.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(gasInfo, entity), cb.isNotEmpty(gasInfo.get(GasInfo_.priceConfigurationCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<PriceConfiguration> findPriceConfigurationCollection(GasInfo entity) {
        GasInfo mergedEntity = this.getMergedEntity(entity);
        Collection<PriceConfiguration> priceConfigurationCollection = mergedEntity.getPriceConfigurationCollection();
        priceConfigurationCollection.size();
        return priceConfigurationCollection;
    }

    public boolean isCylindersCollectionEmpty(GasInfo entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<GasInfo> gasInfo = cq.from(GasInfo.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(gasInfo, entity), cb.isNotEmpty(gasInfo.get(GasInfo_.cylindersCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<Cylinders> findCylindersCollection(GasInfo entity) {
        GasInfo mergedEntity = this.getMergedEntity(entity);
        Collection<Cylinders> cylindersCollection = mergedEntity.getCylindersCollection();
        cylindersCollection.size();
        return cylindersCollection;
    }
    
}
