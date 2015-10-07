package se.su.dsv.bivsim.data.Case.dao.jpa;

import org.springframework.orm.jpa.JpaCallback;
import org.springframework.transaction.annotation.Transactional;
import se.su.dsv.bivsim.data.Case.dao.interfaces.InterviewCase3EntityDao;
import se.su.dsv.bivsim.data.Case.dataobjects.InterviewCase3Entity;

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
public class InterviewCase3EntityDaoJPAImpl extends AbstractDaoJPAImpl<InterviewCase3Entity> implements InterviewCase3EntityDao {
    public InterviewCase3EntityDaoJPAImpl() {

        super(InterviewCase3Entity.class);

    }

    @Transactional
    public List<InterviewCase3Entity> findAll() {
        return getJpaTemplate().execute(new JpaCallback<List<InterviewCase3Entity>>() {
            public List<InterviewCase3Entity> doInJpa(EntityManager em) throws PersistenceException {
                TypedQuery<InterviewCase3Entity> query = em.createQuery("select e from InterviewCase3Entity e", InterviewCase3Entity.class);
                return query.getResultList();
            }
        });
    }

    @Transactional
    public List<InterviewCase3Entity> findAllWithoutParent() {
        List<InterviewCase3Entity> es = getJpaTemplate().execute(new JpaCallback<List<InterviewCase3Entity>>() {
            public List<InterviewCase3Entity> doInJpa(EntityManager em) throws PersistenceException {
                Query query = em.createQuery("select e from InterviewCase3Entity e ");
                List<InterviewCase3Entity> results = query.getResultList();
                return results;
            }
        });

        List<InterviewCase3Entity> returnEs = new ArrayList<InterviewCase3Entity>();
        for (InterviewCase3Entity e : es) {
            if (e.getParent() == null)
                returnEs.add(e);
        }


        return returnEs;
    }

    @Transactional
    public int countAll() {
        return getJpaTemplate().execute(new JpaCallback<Integer>() {

            public Integer doInJpa(EntityManager em) throws PersistenceException {
                TypedQuery<Long> query = em.createQuery("select count (e) from InterviewCase3Entity e", Long.class);
                return (query.getSingleResult()).intValue();
            }
        });

    }

    @Transactional
    public List<InterviewCase3Entity> findAllByGroupId(final Integer groupId) {
        return getJpaTemplate().execute(new JpaCallback<List<InterviewCase3Entity>>() {
            public List<InterviewCase3Entity> doInJpa(EntityManager em) throws PersistenceException {
                TypedQuery<InterviewCase3Entity> query = em.createQuery("select e from InterviewCase3Entity e where e.groupId=:groupId", InterviewCase3Entity.class);
                query.setParameter("groupId", groupId);
                return query.getResultList();
            }
        });

    }


    @Transactional
    public List<InterviewCase3Entity> findAllEntityWithOutParents(final Integer groupId) {
        List<InterviewCase3Entity> es = getJpaTemplate().execute(new JpaCallback<List<InterviewCase3Entity>>() {
            public List<InterviewCase3Entity> doInJpa(EntityManager em) throws PersistenceException {
                Query query = em.createQuery("select e from InterviewCase3Entity e where e.groupId=:groupId ", InterviewCase3Entity.class);
                query.setParameter("groupId", groupId);
                List<InterviewCase3Entity> results = query.getResultList();
                return results;
            }
        });

        List<InterviewCase3Entity> returnEs = new ArrayList<InterviewCase3Entity>();
        for (InterviewCase3Entity e : es) {
            if (e.getParent() == null)
                returnEs.add(e);
        }


        return returnEs;

    }
}
