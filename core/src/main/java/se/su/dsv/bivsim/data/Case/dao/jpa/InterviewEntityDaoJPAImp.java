package se.su.dsv.bivsim.data.Case.dao.jpa;

import org.springframework.orm.jpa.JpaCallback;
import org.springframework.transaction.annotation.Transactional;
import se.su.dsv.bivsim.data.Case.dao.interfaces.InterviewEntityDao;
import se.su.dsv.bivsim.data.Case.dataobjects.InterviewEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;


public class InterviewEntityDaoJPAImp extends AbstractDaoJPAImpl<InterviewEntity> implements InterviewEntityDao {

    public InterviewEntityDaoJPAImp() {
        super(InterviewEntity.class);
    }

    @Transactional
    public List<InterviewEntity> findAll() {
        return getJpaTemplate().execute(new JpaCallback<List<InterviewEntity>>() {
            public List<InterviewEntity> doInJpa(EntityManager em) throws PersistenceException {
                TypedQuery<InterviewEntity> query = em.createQuery("select e from InterviewEntity e", InterviewEntity.class);
                return query.getResultList();
            }
        });
    }

    @Transactional
    public List<InterviewEntity> findAllWithoutParent() {
        List<InterviewEntity> es = getJpaTemplate().execute(new JpaCallback<List<InterviewEntity>>() {
            public List<InterviewEntity> doInJpa(EntityManager em) throws PersistenceException {
                Query query = em.createQuery("select e from InterviewEntity e ");
                List<InterviewEntity> results = query.getResultList();
                return results;
            }
        });

        List<InterviewEntity> returnEs = new ArrayList<InterviewEntity>();
        for (InterviewEntity e : es) {
            if (e.getParent() == null)
                returnEs.add(e);
        }


        return returnEs;
    }

    @Transactional
    public int countAll() {
        return getJpaTemplate().execute(new JpaCallback<Integer>() {

            public Integer doInJpa(EntityManager em) throws PersistenceException {
                TypedQuery<Long> query = em.createQuery("select count (e) from InterviewEntity e", Long.class);
                return (query.getSingleResult()).intValue();
            }
        });

    }

    @Transactional
    public List<InterviewEntity> findAllByGroupId(final Integer groupId) {
        return getJpaTemplate().execute(new JpaCallback<List<InterviewEntity>>() {
            public List<InterviewEntity> doInJpa(EntityManager em) throws PersistenceException {
                TypedQuery<InterviewEntity> query = em.createQuery("select e from InterviewEntity e where e.groupId=:groupId", InterviewEntity.class);
                query.setParameter("groupId", groupId);
                return query.getResultList();
            }
        });

    }


    @Transactional
    public List<InterviewEntity> findAllEntityWithOutParents(final Integer groupId, final String type) {
        List<InterviewEntity> es = getJpaTemplate().execute(new JpaCallback<List<InterviewEntity>>() {
            public List<InterviewEntity> doInJpa(EntityManager em) throws PersistenceException {
                Query query = em.createQuery("select e from InterviewEntity e where e.groupId=:groupId And e.person=:type", InterviewEntity.class);
                query.setParameter("groupId", groupId);
                query.setParameter("type", type);

                List<InterviewEntity> results = query.getResultList();
                return results;
            }
        });

        List<InterviewEntity> returnEs = new ArrayList<InterviewEntity>();
        for (InterviewEntity e : es) {
            if (e.getParent() == null)
                returnEs.add(e);
        }


        return returnEs;

    }

    @Transactional
    public List<InterviewEntity> findAllEntityByParentID(final Integer groupId) {
        List<InterviewEntity> es = getJpaTemplate().execute(new JpaCallback<List<InterviewEntity>>() {
            public List<InterviewEntity> doInJpa(EntityManager em) throws PersistenceException {
                Query query = em.createQuery("select e from InterviewEntity e where e.parent=:groupId ", InterviewEntity.class);
                query.setParameter("groupId", groupId);
                List<InterviewEntity> results = query.getResultList();
                return results;
            }
        });

        List<InterviewEntity> returnEs = new ArrayList<InterviewEntity>();
        for (InterviewEntity e : es) {
            if (e.getParent() == null)
                returnEs.add(e);
        }


        return returnEs;

    }

}
