package se.su.dsv.bivsim.data.Case.dao.jpa;

import org.springframework.orm.jpa.JpaCallback;
import org.springframework.transaction.annotation.Transactional;
import se.su.dsv.bivsim.data.Case.dao.interfaces.Hscl25EntityDao;
import se.su.dsv.bivsim.data.Case.dataobjects.Hscl25Entity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class Hscl25EntityDaoJPAImp extends AbstractDaoJPAImpl<Hscl25Entity> implements Hscl25EntityDao {

    public Hscl25EntityDaoJPAImp() {
        super(Hscl25Entity.class);
    }

    @Transactional
    public List<Hscl25Entity> findAll() {
        return getJpaTemplate().execute(new JpaCallback<List<Hscl25Entity>>() {
            public List<Hscl25Entity> doInJpa(EntityManager em) throws PersistenceException {
                TypedQuery<Hscl25Entity> query = em.createQuery("select e from Hscl25Entity e", Hscl25Entity.class);
                return query.getResultList();
            }
        });
    }

    @Transactional
    public List<Hscl25Entity> findAllWithoutParent() {
        List<Hscl25Entity> es = getJpaTemplate().execute(new JpaCallback<List<Hscl25Entity>>() {
            public List<Hscl25Entity> doInJpa(EntityManager em) throws PersistenceException {
                TypedQuery<Hscl25Entity> query = em.createQuery("select e from Hscl25Entity e", Hscl25Entity.class);
                return query.getResultList();
            }
        });

        List<Hscl25Entity> returnEs = new ArrayList<Hscl25Entity>();
        for (Hscl25Entity e : es) {
            returnEs.add(e);
        }

        return returnEs;
    }

    @Transactional
    public int countAll() {
        return getJpaTemplate().execute(new JpaCallback<Integer>() {

            public Integer doInJpa(EntityManager em) throws PersistenceException {
                TypedQuery<Long> query = em.createQuery("select count (e) from Hscl25Entity e", Long.class);
                return (query.getSingleResult()).intValue();
            }
        });

    }

    @Transactional
    public List<Hscl25Entity> findAllByGroupId(final Integer groupId) {
        return getJpaTemplate().execute(new JpaCallback<List<Hscl25Entity>>() {
            public List<Hscl25Entity> doInJpa(EntityManager em) throws PersistenceException {
                TypedQuery<Hscl25Entity> query = em.createQuery("select e from Hscl25Entity e where e.groupId=:groupId", Hscl25Entity.class);
                query.setParameter("groupId", groupId);
                return query.getResultList();

            }
        });

    }

}
