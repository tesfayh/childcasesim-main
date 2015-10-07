package se.su.dsv.bivsim.data.Case.dao.jpa;

import org.springframework.orm.jpa.JpaCallback;
import org.springframework.transaction.annotation.Transactional;
import se.su.dsv.bivsim.data.Case.dao.interfaces.PTSDEntityDoa;
import se.su.dsv.bivsim.data.Case.dataobjects.PTSDEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: kebede
 * Date: 02/10/13
 * Time: 11:56
 * To change this template use File | Settings | File Templates.
 */
public class PTSDEntityDoaJPAImpl extends AbstractDaoJPAImpl<PTSDEntity> implements PTSDEntityDoa {
    public PTSDEntityDoaJPAImpl() {
        super(PTSDEntity.class);
    }

    @Transactional
    public List<PTSDEntity> findAll() {
        return getJpaTemplate().execute(new JpaCallback<List<PTSDEntity>>() {
            public List<PTSDEntity> doInJpa(EntityManager em) throws PersistenceException {
                TypedQuery<PTSDEntity> query = em.createQuery("select e from PTSDEntity e", PTSDEntity.class);
                return query.getResultList();
            }
        });
    }


    @Transactional
    public List<PTSDEntity> findAllWithoutParent() {
        List<PTSDEntity> es = getJpaTemplate().execute(new JpaCallback<List<PTSDEntity>>() {
            public List<PTSDEntity> doInJpa(EntityManager em) throws PersistenceException {
                TypedQuery<PTSDEntity> query = em.createQuery("select e from PTSDEntity e", PTSDEntity.class);
                return query.getResultList();
            }
        });

        List<PTSDEntity> returnEs = new ArrayList<PTSDEntity>();
        for (PTSDEntity e : es) {
            returnEs.add(e);
        }

        return returnEs;
    }

    @Transactional
    public int countAll() {
        return getJpaTemplate().execute(new JpaCallback<Integer>() {

            public Integer doInJpa(EntityManager em) throws PersistenceException {
                TypedQuery<Long> query = em.createQuery("select count (e) from PTSDEntity e", Long.class);
                return (query.getSingleResult()).intValue();
            }
        });

    }

    @Transactional
    public List<PTSDEntity> findAllByGroupId(final Integer groupId) {
        return getJpaTemplate().execute(new JpaCallback<List<PTSDEntity>>() {
            public List<PTSDEntity> doInJpa(EntityManager em) throws PersistenceException {
                TypedQuery<PTSDEntity> query = em.createQuery("select e from PTSDEntity e where e.groupId=:groupId", PTSDEntity.class);
                query.setParameter("groupId", groupId);
                return query.getResultList();

            }
        });

    }

}
