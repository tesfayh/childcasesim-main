package se.su.dsv.bivsim.data.Case.dao.jpa;

import org.springframework.orm.jpa.JpaCallback;
import org.springframework.transaction.annotation.Transactional;
import se.su.dsv.bivsim.data.Case.dao.interfaces.InterviewCase4EntityDao;
import se.su.dsv.bivsim.data.Case.dataobjects.InterviewCase4Entity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: kebede
 * Date: 06/10/13
 * Time: 19:14
 * To change this template use File | Settings | File Templates.
 */
public class InterviewCase4EntityDaoJPAImpl extends AbstractDaoJPAImpl<InterviewCase4Entity> implements InterviewCase4EntityDao {
    public InterviewCase4EntityDaoJPAImpl() {

        super(InterviewCase4Entity.class);

    }

    @Transactional
    public List<InterviewCase4Entity> findAll() {
        return getJpaTemplate().execute(new JpaCallback<List<InterviewCase4Entity>>() {
            public List<InterviewCase4Entity> doInJpa(EntityManager em) throws PersistenceException {
                TypedQuery<InterviewCase4Entity> query = em.createQuery("select e from InterviewCase4Entity e", InterviewCase4Entity.class);
                return query.getResultList();
            }
        });
    }

    @Transactional
    public List<InterviewCase4Entity> findAllWithoutParent() {
        List<InterviewCase4Entity> es = getJpaTemplate().execute(new JpaCallback<List<InterviewCase4Entity>>() {
            public List<InterviewCase4Entity> doInJpa(EntityManager em) throws PersistenceException {
                Query query = em.createQuery("select e from InterviewCase4Entity e ");
                List<InterviewCase4Entity> results = query.getResultList();
                return results;
            }
        });

        List<InterviewCase4Entity> returnEs = new ArrayList<InterviewCase4Entity>();
        for (InterviewCase4Entity e : es) {
            if (e.getParent() == null)
                returnEs.add(e);
        }


        return returnEs;
    }

    @Transactional
    public int countAll() {
        return getJpaTemplate().execute(new JpaCallback<Integer>() {

            public Integer doInJpa(EntityManager em) throws PersistenceException {
                TypedQuery<Long> query = em.createQuery("select count (e) from InterviewCase4Entity e", Long.class);
                return (query.getSingleResult()).intValue();
            }
        });

    }

    @Transactional
    public List<InterviewCase4Entity> findAllByGroupId(final Integer groupId) {
        return getJpaTemplate().execute(new JpaCallback<List<InterviewCase4Entity>>() {
            public List<InterviewCase4Entity> doInJpa(EntityManager em) throws PersistenceException {
                TypedQuery<InterviewCase4Entity> query = em.createQuery("select e from InterviewCase4Entity e where e.groupId=:groupId", InterviewCase4Entity.class);
                query.setParameter("groupId", groupId);
                return query.getResultList();
            }
        });

    }


    @Transactional
    public List<InterviewCase4Entity> findAllEntityWithOutParents(final Integer groupId) {
        List<InterviewCase4Entity> es = getJpaTemplate().execute(new JpaCallback<List<InterviewCase4Entity>>() {
            public List<InterviewCase4Entity> doInJpa(EntityManager em) throws PersistenceException {
                Query query = em.createQuery("select e from InterviewCase4Entity e where e.groupId=:groupId ", InterviewCase4Entity.class);
                query.setParameter("groupId", groupId);
                List<InterviewCase4Entity> results = query.getResultList();
                return results;
            }
        });

        List<InterviewCase4Entity> returnEs = new ArrayList<InterviewCase4Entity>();
        for (InterviewCase4Entity e : es) {
            if (e.getParent() == null)
                returnEs.add(e);
        }


        return returnEs;

    }
}
