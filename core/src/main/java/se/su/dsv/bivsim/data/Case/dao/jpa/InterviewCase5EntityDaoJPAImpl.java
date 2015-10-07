package se.su.dsv.bivsim.data.Case.dao.jpa;

import org.springframework.orm.jpa.JpaCallback;
import org.springframework.transaction.annotation.Transactional;
import se.su.dsv.bivsim.data.Case.dao.interfaces.InterviewCase5EntityDao;
import se.su.dsv.bivsim.data.Case.dataobjects.InterviewCase5Entity;

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
public class InterviewCase5EntityDaoJPAImpl extends AbstractDaoJPAImpl<InterviewCase5Entity> implements InterviewCase5EntityDao {
    public InterviewCase5EntityDaoJPAImpl() {

        super(InterviewCase5Entity.class);

    }

    @Transactional
    public List<InterviewCase5Entity> findAll() {
        return getJpaTemplate().execute(new JpaCallback<List<InterviewCase5Entity>>() {
            public List<InterviewCase5Entity> doInJpa(EntityManager em) throws PersistenceException {
                TypedQuery<InterviewCase5Entity> query = em.createQuery("select e from InterviewCase5Entity e", InterviewCase5Entity.class);
                return query.getResultList();
            }
        });
    }

    @Transactional
    public List<InterviewCase5Entity> findAllWithoutParent() {
        List<InterviewCase5Entity> es = getJpaTemplate().execute(new JpaCallback<List<InterviewCase5Entity>>() {
            public List<InterviewCase5Entity> doInJpa(EntityManager em) throws PersistenceException {
                Query query = em.createQuery("select e from InterviewCase5Entity e ");
                List<InterviewCase5Entity> results = query.getResultList();
                return results;
            }
        });

        List<InterviewCase5Entity> returnEs = new ArrayList<InterviewCase5Entity>();
        for (InterviewCase5Entity e : es) {
            if (e.getParent() == null)
                returnEs.add(e);
        }


        return returnEs;
    }

    @Transactional
    public int countAll() {
        return getJpaTemplate().execute(new JpaCallback<Integer>() {

            public Integer doInJpa(EntityManager em) throws PersistenceException {
                TypedQuery<Long> query = em.createQuery("select count (e) from InterviewCase5Entity e", Long.class);
                return (query.getSingleResult()).intValue();
            }
        });

    }

    @Transactional
    public List<InterviewCase5Entity> findAllByGroupId(final Integer groupId) {
        return getJpaTemplate().execute(new JpaCallback<List<InterviewCase5Entity>>() {
            public List<InterviewCase5Entity> doInJpa(EntityManager em) throws PersistenceException {
                TypedQuery<InterviewCase5Entity> query = em.createQuery("select e from InterviewCase5Entity e where e.groupId=:groupId", InterviewCase5Entity.class);
                query.setParameter("groupId", groupId);
                return query.getResultList();
            }
        });

    }


    @Transactional
    public List<InterviewCase5Entity> findAllEntityWithOutParents(final Integer groupId) {
        List<InterviewCase5Entity> es = getJpaTemplate().execute(new JpaCallback<List<InterviewCase5Entity>>() {
            public List<InterviewCase5Entity> doInJpa(EntityManager em) throws PersistenceException {
                Query query = em.createQuery("select e from InterviewCase5Entity e where e.groupId=:groupId ", InterviewCase5Entity.class);
                query.setParameter("groupId", groupId);
                List<InterviewCase5Entity> results = query.getResultList();
                return results;
            }
        });

        List<InterviewCase5Entity> returnEs = new ArrayList<InterviewCase5Entity>();
        for (InterviewCase5Entity e : es) {
            if (e.getParent() == null)
                returnEs.add(e);
        }


        return returnEs;

    }
}
