package se.su.dsv.bivsim.data.Case.dao.jpa;

import org.springframework.orm.jpa.JpaCallback;
import org.springframework.transaction.annotation.Transactional;
import se.su.dsv.bivsim.data.Case.dao.interfaces.GenHealthEntityDoa;

import se.su.dsv.bivsim.data.Case.dataobjects.GenHealthEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: kebede
 * Date: 02/10/13
 * Time: 11:57
 * To change this template use File | Settings | File Templates.
 */
public class GenHealthEntityDoaJPAImpl extends AbstractDaoJPAImpl<GenHealthEntity> implements GenHealthEntityDoa {
    public GenHealthEntityDoaJPAImpl() {
        super(GenHealthEntity.class);
    }

    @Transactional
    public List<GenHealthEntity> findAll() {
        return getJpaTemplate().execute(new JpaCallback<List<GenHealthEntity>>() {
            public List<GenHealthEntity> doInJpa(EntityManager em) throws PersistenceException {
                TypedQuery<GenHealthEntity> query = em.createQuery("select e from GenHealthEntity e", GenHealthEntity.class);
                return query.getResultList();
            }
        });
    }

    @Transactional
    public List<GenHealthEntity> findAllWithoutParent() {
        List<GenHealthEntity> es = getJpaTemplate().execute(new JpaCallback<List<GenHealthEntity>>() {
            public List<GenHealthEntity> doInJpa(EntityManager em) throws PersistenceException {
                TypedQuery<GenHealthEntity> query = em.createQuery("select e from GenHealthEntity e", GenHealthEntity.class);
                return query.getResultList();
            }
        });

        List<GenHealthEntity> returnEs = new ArrayList<GenHealthEntity>();
        for (GenHealthEntity e : es) {
            returnEs.add(e);
        }

        return returnEs;
    }

    @Transactional
    public int countAll() {
        return getJpaTemplate().execute(new JpaCallback<Integer>() {

            public Integer doInJpa(EntityManager em) throws PersistenceException {
                TypedQuery<Long> query = em.createQuery("select count (e) from GenHealthEntity e", Long.class);
                return (query.getSingleResult()).intValue();
            }
        });

    }

    @Transactional
    public List<GenHealthEntity> findAllByGroupId(final Integer groupId) {
        return getJpaTemplate().execute(new JpaCallback<List<GenHealthEntity>>() {
            public List<GenHealthEntity> doInJpa(EntityManager em) throws PersistenceException {
                TypedQuery<GenHealthEntity> query = em.createQuery("select e from GenHealthEntity e where e.groupId=:groupId", GenHealthEntity.class);
                query.setParameter("groupId", groupId);
                return query.getResultList();

            }
        });

    }


}

