package se.su.dsv.bivsim.data.Case.dao.jpa;

import org.springframework.orm.jpa.JpaCallback;
import org.springframework.transaction.annotation.Transactional;
import se.su.dsv.bivsim.data.Case.dao.interfaces.FollowUpEntityDoa;
import se.su.dsv.bivsim.data.Case.dataobjects.FollowUpEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: kebede
 * Date: 04/10/13
 * Time: 09:41
 * To change this template use File | Settings | File Templates.
 */
public class FollowUpEntityDoaJPAImpl extends AbstractDaoJPAImpl<FollowUpEntity> implements FollowUpEntityDoa {

    public FollowUpEntityDoaJPAImpl() {
        super(FollowUpEntity.class);
    }


    @Transactional
    public List<FollowUpEntity> findAll() {
        return getJpaTemplate().execute(new JpaCallback<List<FollowUpEntity>>() {
            public List<FollowUpEntity> doInJpa(EntityManager em) throws PersistenceException {
                TypedQuery<FollowUpEntity> query = em.createQuery("select e from FollowUpEntity e", FollowUpEntity.class);
                return query.getResultList();
            }
        });
    }

    @Transactional
    public List<FollowUpEntity> findAllWithoutParent() {
        List<FollowUpEntity> es = getJpaTemplate().execute(new JpaCallback<List<FollowUpEntity>>() {
            public List<FollowUpEntity> doInJpa(EntityManager em) throws PersistenceException {
                TypedQuery<FollowUpEntity> query = em.createQuery("select e from FollowUpEntity e", FollowUpEntity.class);
                return query.getResultList();
            }
        });

        List<FollowUpEntity> returnEs = new ArrayList<FollowUpEntity>();
        for (FollowUpEntity e : es) {
            returnEs.add(e);
        }

        return returnEs;
    }

    @Transactional
    public int countAll() {
        return getJpaTemplate().execute(new JpaCallback<Integer>() {

            public Integer doInJpa(EntityManager em) throws PersistenceException {
                TypedQuery<Long> query = em.createQuery("select count (e) from FollowUpEntity e", Long.class);
                return (query.getSingleResult()).intValue();
            }
        });

    }

    @Transactional
    public List<FollowUpEntity> findAllByGroupId(final Integer groupId) {
        return getJpaTemplate().execute(new JpaCallback<List<FollowUpEntity>>() {
            public List<FollowUpEntity> doInJpa(EntityManager em) throws PersistenceException {
                TypedQuery<FollowUpEntity> query = em.createQuery("select e from FollowUpEntity e where e.groupId=:groupId", FollowUpEntity.class);
                query.setParameter("groupId", groupId);
                return query.getResultList();

            }
        });

    }

    @Transactional
    public FollowUpEntity findObject(final long id) {
        return getJpaTemplate().execute(new JpaCallback<FollowUpEntity>() {

            public FollowUpEntity doInJpa(EntityManager em) throws PersistenceException {
                FollowUpEntity v = em.find(FollowUpEntity.class, id);
                return v;


            }
        });

    }
}
