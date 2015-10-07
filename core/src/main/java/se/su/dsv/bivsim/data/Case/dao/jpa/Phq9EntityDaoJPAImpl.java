package se.su.dsv.bivsim.data.Case.dao.jpa;

import org.springframework.orm.jpa.JpaCallback;
import org.springframework.transaction.annotation.Transactional;
import se.su.dsv.bivsim.data.Case.dao.interfaces.Phq9EntityDao;
import se.su.dsv.bivsim.data.Case.dataobjects.Phq9Entity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class Phq9EntityDaoJPAImpl extends AbstractDaoJPAImpl<Phq9Entity> implements Phq9EntityDao {

    public Phq9EntityDaoJPAImpl() {
        super(Phq9Entity.class);
    }

    @Transactional
    public List<Phq9Entity> findAll() {
        return getJpaTemplate().execute(new JpaCallback<List<Phq9Entity>>() {
            public List<Phq9Entity> doInJpa(EntityManager em) throws PersistenceException {
                TypedQuery<Phq9Entity> query = em.createQuery("select e from Phq9Entity e", Phq9Entity.class);
                return query.getResultList();
            }
        });
    }

    @Transactional
    public List<Phq9Entity> findAllWithoutParent() {
        List<Phq9Entity> es = getJpaTemplate().execute(new JpaCallback<List<Phq9Entity>>() {
            public List<Phq9Entity> doInJpa(EntityManager em) throws PersistenceException {
                TypedQuery<Phq9Entity> query = em.createQuery("select e from Phq9Entity e", Phq9Entity.class);
                return query.getResultList();
            }
        });

        List<Phq9Entity> returnEs = new ArrayList<Phq9Entity>();
        for (Phq9Entity e : es) {
            returnEs.add(e);
        }


        return returnEs;
    }

    @Transactional
    public int countAll() {
        return getJpaTemplate().execute(new JpaCallback<Integer>() {

            public Integer doInJpa(EntityManager em) throws PersistenceException {
                TypedQuery<Long> query = em.createQuery("select count (e) from Phq9Entity e ", Long.class);
                return (query.getSingleResult()).intValue();
            }
        });

    }

    @Transactional
    public List<Phq9Entity> findAllByGroupId(final Integer groupId) {
        return getJpaTemplate().execute(new JpaCallback<List<Phq9Entity>>() {
            public List<Phq9Entity> doInJpa(EntityManager em) throws PersistenceException {
                TypedQuery<Phq9Entity> query = em.createQuery("select e from Phq9Entity e where e.groupId=:groupId ", Phq9Entity.class);
                query.setParameter("groupId", groupId);
                return query.getResultList();

            }
        });

    }
}
