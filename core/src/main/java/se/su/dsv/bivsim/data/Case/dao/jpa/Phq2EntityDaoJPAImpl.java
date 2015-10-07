package se.su.dsv.bivsim.data.Case.dao.jpa;

import org.springframework.orm.jpa.JpaCallback;
import org.springframework.transaction.annotation.Transactional;
import se.su.dsv.bivsim.data.Case.dao.interfaces.Phq2EntityDao;
import se.su.dsv.bivsim.data.Case.dataobjects.Phq2Entity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;


public class Phq2EntityDaoJPAImpl extends AbstractDaoJPAImpl<Phq2Entity> implements Phq2EntityDao {

    public Phq2EntityDaoJPAImpl() {
        super(Phq2Entity.class);
    }

    @Transactional
    public List<Phq2Entity> findAll() {
        return getJpaTemplate().execute(new JpaCallback<List<Phq2Entity>>() {
            public List<Phq2Entity> doInJpa(EntityManager em) throws PersistenceException {
                TypedQuery<Phq2Entity> query = em.createQuery("select e from Phq2Entity e", Phq2Entity.class);
                return query.getResultList();

            }
        });
    }

    @Transactional
    public List<Phq2Entity> findAllWithoutParent() {
        List<Phq2Entity> es = getJpaTemplate().execute(new JpaCallback<List<Phq2Entity>>() {
            public List<Phq2Entity> doInJpa(EntityManager em) throws PersistenceException {
                TypedQuery<Phq2Entity> query = em.createQuery("select e from Phq2Entity e", Phq2Entity.class);
                return query.getResultList();
            }
        });

        List<Phq2Entity> returnEs = new ArrayList<Phq2Entity>();
        for (Phq2Entity e : es) {
            returnEs.add(e);
        }


        return returnEs;
    }

    @Transactional
    public int countAll() {
        return getJpaTemplate().execute(new JpaCallback<Integer>() {

            public Integer doInJpa(EntityManager em) throws PersistenceException {
                TypedQuery<Long> query = em.createQuery("select count (e) from Phq2Entity e", Long.class);
                return (query.getSingleResult()).intValue();
            }
        });

    }

    @Transactional
    public List<Phq2Entity> findAllByGroupId(final Integer groupId) {
        return getJpaTemplate().execute(new JpaCallback<List<Phq2Entity>>() {
            public List<Phq2Entity> doInJpa(EntityManager em) throws PersistenceException {
                TypedQuery<Phq2Entity> query = em.createQuery("select e from Phq2Entity e where e.groupId=:groupId ", Phq2Entity.class);
                query.setParameter("groupId", groupId);
                return query.getResultList();

            }
        });

    }
}
