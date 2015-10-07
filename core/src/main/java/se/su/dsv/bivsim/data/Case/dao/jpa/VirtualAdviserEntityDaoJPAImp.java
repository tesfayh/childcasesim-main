package se.su.dsv.bivsim.data.Case.dao.jpa;

import org.springframework.orm.jpa.JpaCallback;
import org.springframework.transaction.annotation.Transactional;
import se.su.dsv.bivsim.data.Case.dao.interfaces.VirtualAdviserEntityDao;
import se.su.dsv.bivsim.data.Case.dataobjects.VirtualAdviserEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import java.util.List;

public class VirtualAdviserEntityDaoJPAImp extends AbstractDaoJPAImpl<VirtualAdviserEntity> implements VirtualAdviserEntityDao {


    public VirtualAdviserEntityDaoJPAImp() {

        super(VirtualAdviserEntity.class);
    }

    @Transactional
    public List<VirtualAdviserEntity> findAll() {
        return getJpaTemplate().execute(new JpaCallback<List<VirtualAdviserEntity>>() {
            public List<VirtualAdviserEntity> doInJpa(EntityManager em) throws PersistenceException {
                TypedQuery<VirtualAdviserEntity> query = em.createQuery("select e from VirtualAdviserEntity e", VirtualAdviserEntity.class);
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
    public List<VirtualAdviserEntity> findAllWithoutParent() {
        List<VirtualAdviserEntity> es = getJpaTemplate().execute(new JpaCallback<List<VirtualAdviserEntity>>() {
            public List<VirtualAdviserEntity> doInJpa(EntityManager em) throws PersistenceException {
                TypedQuery<VirtualAdviserEntity> query = em.createQuery("select e from VirtualAdviserEntity e", VirtualAdviserEntity.class);
                return query.getResultList();
            }
        });


        return es;
    }

    @Transactional
    public void ChangeVirtualAdviser(final long id, final int feedbackvalue, final String feedbackdetail) {
        getJpaTemplate().execute(new JpaCallback<Integer>() {

            public Integer doInJpa(EntityManager em) throws PersistenceException {
                VirtualAdviserEntity v = em.find(VirtualAdviserEntity.class, id);
                if (v != null)
                    v.setFeedbackDetail(feedbackdetail);
                v.setFeedbackValue(feedbackvalue);
                return null;
            }
        });

    }

    @Transactional
    public List<VirtualAdviserEntity> findAllByGroupId(final Integer groupId) {

        return getJpaTemplate().execute(new JpaCallback<List<VirtualAdviserEntity>>() {
            @Override
            public List<VirtualAdviserEntity> doInJpa(EntityManager em) throws PersistenceException {
                TypedQuery<VirtualAdviserEntity> query = em.createQuery("select e from VirtualAdviserEntity  e where e.groupId=:groupId", VirtualAdviserEntity.class);
                query.setParameter("groupId", groupId);
                return query.getResultList();
            }
        });

    }


}
