package se.su.dsv.bivsim.data.Case.dao.jpa;

import org.springframework.orm.jpa.JpaCallback;
import org.springframework.transaction.annotation.Transactional;
import se.su.dsv.bivsim.data.Case.dao.interfaces.FeedbackEntityDao;
import se.su.dsv.bivsim.data.Case.dataobjects.FeedbackEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import java.util.List;


public class FeedbackEntityDaoJPAImp extends AbstractDaoJPAImpl<FeedbackEntity> implements FeedbackEntityDao {

    public FeedbackEntityDaoJPAImp() {
        super(FeedbackEntity.class);
    }

    @Transactional
    public List<FeedbackEntity> findAll() {
        return getJpaTemplate().execute(new JpaCallback<List<FeedbackEntity>>() {
            public List<FeedbackEntity> doInJpa(EntityManager em) throws PersistenceException {
                TypedQuery<FeedbackEntity> query = em.createQuery("select e from FeedbackEntity e", FeedbackEntity.class);
                return query.getResultList();
            }
        });
    }

    @Transactional
    public int countAll() {
        return getJpaTemplate().execute(new JpaCallback<Integer>() {

            public Integer doInJpa(EntityManager em) throws PersistenceException {
                TypedQuery<Long> query = em.createQuery("select count (e) from FeedbackEntity e", Long.class);
                return (query.getSingleResult()).intValue();
            }
        });

    }

    @Transactional
    public List<FeedbackEntity> findAllWithoutParent() {
        List<FeedbackEntity> es = getJpaTemplate().execute(new JpaCallback<List<FeedbackEntity>>() {
            public List<FeedbackEntity> doInJpa(EntityManager em) throws PersistenceException {
                TypedQuery<FeedbackEntity> query = em.createQuery("select e from FeedbackEntity e", FeedbackEntity.class);
                return query.getResultList();
            }
        });

        return es;
    }

    @Transactional
    public FeedbackEntity findObject(final long id) {
        return getJpaTemplate().execute(new JpaCallback<FeedbackEntity>() {

            public FeedbackEntity doInJpa(EntityManager em) throws PersistenceException {
                FeedbackEntity v = em.find(FeedbackEntity.class, id);
                return v;


            }
        });

    }

    @Transactional
    public List<FeedbackEntity> findAllByGroupId(final Integer groupId) {
        return getJpaTemplate().execute(new JpaCallback<List<FeedbackEntity>>() {
            public List<FeedbackEntity> doInJpa(EntityManager em) throws PersistenceException {
                TypedQuery<FeedbackEntity> query = em.createQuery("select e from FeedbackEntity e where e.groupId=:groupId", FeedbackEntity.class);
                query.setParameter("groupId", groupId);
                return query.getResultList();

            }
        });

    }



    @Transactional
    public List<FeedbackEntity> findAllByGroupIdAndPerson(final Integer groupId, final String person) {
        return getJpaTemplate().execute(new JpaCallback<List<FeedbackEntity>>() {
            public List<FeedbackEntity> doInJpa(EntityManager em) throws PersistenceException {
                TypedQuery<FeedbackEntity> query = em.createQuery("select e from FeedbackEntity e where e.groupId=:groupId", FeedbackEntity.class);
                query.setParameter("groupId", groupId);
                return query.getResultList();

            }
        });

    }




}



