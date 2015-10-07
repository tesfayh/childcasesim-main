package se.su.dsv.bivsim.data.Case.dao.jpa;

import org.springframework.orm.jpa.JpaCallback;
import org.springframework.transaction.annotation.Transactional;
import se.su.dsv.bivsim.data.Case.dao.interfaces.PhysicalExamEntityDao;
import se.su.dsv.bivsim.data.Case.dataobjects.PhysicalExamEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import javax.persistence.Query;

import java.util.List;

public class PhysicalExamEntityDaoJPAImp extends AbstractDaoJPAImpl<PhysicalExamEntity> implements PhysicalExamEntityDao {

    public PhysicalExamEntityDaoJPAImp() {

        super(PhysicalExamEntity.class);
    }

    @Transactional
    public List<PhysicalExamEntity> findAll() {
        return getJpaTemplate().execute(new JpaCallback<List<PhysicalExamEntity>>() {
            public List<PhysicalExamEntity> doInJpa(EntityManager em) throws PersistenceException {
                TypedQuery<PhysicalExamEntity> query = em.createQuery("select e from PhysicalExamEntity e where picId IS NOT NULL", PhysicalExamEntity.class);
                return query.getResultList();
            }
        });
    }

    @Transactional
    public List<PhysicalExamEntity> findAllWithoutParent() {
        List<PhysicalExamEntity> es = getJpaTemplate().execute(new JpaCallback<List<PhysicalExamEntity>>() {
            public List<PhysicalExamEntity> doInJpa(EntityManager em) throws PersistenceException {
                TypedQuery<PhysicalExamEntity> query = em.createQuery("select e from PhysicalExamEntity e", PhysicalExamEntity.class);
                return query.getResultList();
            }
        });

        List<PhysicalExamEntity> returnEs = new ArrayList<PhysicalExamEntity>();
        for (PhysicalExamEntity e : es) {
            if (e.getParent() == null)
                returnEs.add(e);
        }

        return returnEs;
    }

    @Transactional
    public int countAll() {
        return getJpaTemplate().execute(new JpaCallback<Integer>() {

            public Integer doInJpa(EntityManager em) throws PersistenceException {
                TypedQuery<Long> query = em.createQuery("select count (e) from PhysicalExamEntity e", Long.class);
                return (query.getSingleResult()).intValue();
            }
        });

    }

    @Transactional
    public List<PhysicalExamEntity> findAllByGroupId(final Integer groupId) {
        return getJpaTemplate().execute(new JpaCallback<List<PhysicalExamEntity>>() {
            @Override
            public List<PhysicalExamEntity> doInJpa(EntityManager em) throws PersistenceException {
                TypedQuery<PhysicalExamEntity> query = em.createQuery("select  e from PhysicalExamEntity e where e.groupId=:groupId", PhysicalExamEntity.class);
                query.setParameter("groupId", groupId);
                return query.getResultList();
            }
        });
    }


    @Transactional
    public List<PhysicalExamEntity> findAllByCateID(final Integer groupId) {
        return getJpaTemplate().execute(new JpaCallback<List<PhysicalExamEntity>>() {
            @Override
            public List<PhysicalExamEntity> doInJpa(EntityManager em) throws PersistenceException {
                TypedQuery<PhysicalExamEntity> query = em.createQuery("select  e from PhysicalExamEntity e where e.cate_ID=:groupId", PhysicalExamEntity.class);
                query.setParameter("groupId", groupId);
                return query.getResultList();
            }
        });
    }


    @Transactional
    public List<PhysicalExamEntity> findAllEntityWithOutParents(final Integer cate_ID) {
        List<PhysicalExamEntity> es = getJpaTemplate().execute(new JpaCallback<List<PhysicalExamEntity>>() {
            public List<PhysicalExamEntity> doInJpa(EntityManager em) throws PersistenceException {
                Query query = em.createQuery("select e from PhysicalExamEntity e where e.groupId=:cate_ID ", PhysicalExamEntity.class);
                query.setParameter("cate_ID", cate_ID);
                List<PhysicalExamEntity> results = query.getResultList();
                return results;
            }
        });

        List<PhysicalExamEntity> returnEs = new ArrayList<PhysicalExamEntity>();
        for (PhysicalExamEntity e : es) {
            if (e.getParent() == null)
                returnEs.add(e);
        }

        return returnEs;
    }
}
