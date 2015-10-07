package se.su.dsv.bivsim.data.Case.dao.jpa;

import org.springframework.orm.jpa.JpaCallback;
import org.springframework.transaction.annotation.Transactional;
import se.su.dsv.bivsim.data.Case.dao.interfaces.HtqEntityDao;
import se.su.dsv.bivsim.data.Case.dataobjects.HtqEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;


public class HtqEntityDaoJPAImp extends AbstractDaoJPAImpl<HtqEntity> implements HtqEntityDao {

    public HtqEntityDaoJPAImp() {
        super(HtqEntity.class);
    }

    @Transactional
    public List<HtqEntity> findAll() {
        return getJpaTemplate().execute(new JpaCallback<List<HtqEntity>>() {
            public List<HtqEntity> doInJpa(EntityManager em) throws PersistenceException {
                TypedQuery<HtqEntity> query = em.createQuery("select e from HtqEntity e", HtqEntity.class);
                return query.getResultList();
            }
        });
    }

    @Transactional
    public List<HtqEntity> findAllWithoutParent() {
        List<HtqEntity> es = getJpaTemplate().execute(new JpaCallback<List<HtqEntity>>() {
            public List<HtqEntity> doInJpa(EntityManager em) throws PersistenceException {
                TypedQuery<HtqEntity> query = em.createQuery("select e from HtqEntity e", HtqEntity.class);
                return query.getResultList();
            }
        });

        List<HtqEntity> returnEs = new ArrayList<HtqEntity>();
        for (HtqEntity e : es) {
            returnEs.add(e);
        }

        return returnEs;
    }

    @Transactional
    public int countAll() {
        return getJpaTemplate().execute(new JpaCallback<Integer>() {

            public Integer doInJpa(EntityManager em) throws PersistenceException {
                TypedQuery<Long> query = em.createQuery("select count (e) from HtqEntity e", Long.class);
                return (query.getSingleResult()).intValue();
            }
        });

    }

    @Transactional
    public List<HtqEntity> findAllByGroupId(final Integer groupId) {
        return getJpaTemplate().execute(new JpaCallback<List<HtqEntity>>() {
                                            @Override
                                            public List<HtqEntity> doInJpa(EntityManager em) throws PersistenceException {
                                                TypedQuery<HtqEntity> query = em.createQuery("select e from HtqEntity e where e.groupId=:groupId", HtqEntity.class);
                                                query.setParameter("groupId", groupId);
                                                return query.getResultList();
                                            }
                                        }

        );

    }
}
