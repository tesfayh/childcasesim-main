package se.su.dsv.bivsim.data.Case.dao.jpa;

import org.springframework.orm.jpa.JpaCallback;
import org.springframework.transaction.annotation.Transactional;
import se.su.dsv.bivsim.data.Case.dao.interfaces.InterviewCase2EntityDao;
import se.su.dsv.bivsim.data.Case.dataobjects.InterviewCase2Entity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;


public class InterviewCase2EntityDaoJPAImpl extends AbstractDaoJPAImpl<InterviewCase2Entity> implements InterviewCase2EntityDao {

    public InterviewCase2EntityDaoJPAImpl() {

        super(InterviewCase2Entity.class);

    }

    @Transactional
    public List<InterviewCase2Entity> findAll() {
        return getJpaTemplate().execute(new JpaCallback<List<InterviewCase2Entity>>() {
            public List<InterviewCase2Entity> doInJpa(EntityManager em) throws PersistenceException {
                TypedQuery<InterviewCase2Entity> query = em.createQuery("select e from InterviewCase2Entity e", InterviewCase2Entity.class);
                return query.getResultList();
            }
        });
    }

    @Transactional
    public List<InterviewCase2Entity> findAllWithoutParent() {
        List<InterviewCase2Entity> es = getJpaTemplate().execute(new JpaCallback<List<InterviewCase2Entity>>() {
            public List<InterviewCase2Entity> doInJpa(EntityManager em) throws PersistenceException {
                Query query = em.createQuery("select e from InterviewCase2Entity e ");
                List<InterviewCase2Entity> results = query.getResultList();
                return results;
            }
        });

        List<InterviewCase2Entity> returnEs = new ArrayList<InterviewCase2Entity>();
        for (InterviewCase2Entity e : es) {
            if (e.getParent() == null)
                returnEs.add(e);
        }


        return returnEs;
    }

    @Transactional
    public int countAll() {
        return getJpaTemplate().execute(new JpaCallback<Integer>() {

            public Integer doInJpa(EntityManager em) throws PersistenceException {
                TypedQuery<Long> query = em.createQuery("select count (e) from InterviewCase2Entity e", Long.class);
                return (query.getSingleResult()).intValue();
            }
        });

    }

    @Transactional
    public List<InterviewCase2Entity> findAllByGroupId(final Integer groupId) {
        return getJpaTemplate().execute(new JpaCallback<List<InterviewCase2Entity>>() {
            public List<InterviewCase2Entity> doInJpa(EntityManager em) throws PersistenceException {
                TypedQuery<InterviewCase2Entity> query = em.createQuery("select e from InterviewCase2Entity e where e.groupId=:groupId", InterviewCase2Entity.class);
                query.setParameter("groupId", groupId);
                return query.getResultList();
            }
        });

    }


    @Transactional
    public List<InterviewCase2Entity> findAllEntityWithOutParents(final Integer groupId) {
        List<InterviewCase2Entity> es = getJpaTemplate().execute(new JpaCallback<List<InterviewCase2Entity>>() {
            public List<InterviewCase2Entity> doInJpa(EntityManager em) throws PersistenceException {
                Query query = em.createQuery("select e from InterviewCase2Entity e where e.groupId=:groupId ", InterviewCase2Entity.class);
                query.setParameter("groupId", groupId);
                List<InterviewCase2Entity> results = query.getResultList();
                return results;
            }
        });

        List<InterviewCase2Entity> returnEs = new ArrayList<InterviewCase2Entity>();
        for (InterviewCase2Entity e : es) {
            if (e.getParent() == null)
                returnEs.add(e);
        }


        return returnEs;

    }

}
