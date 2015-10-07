package se.su.dsv.bivsim.data.Case.dao.jpa;

import org.springframework.orm.jpa.JpaCallback;
import org.springframework.transaction.annotation.Transactional;
import se.su.dsv.bivsim.data.Case.dao.interfaces.HistoryEntityDao;
import se.su.dsv.bivsim.data.Case.dataobjects.HistoryEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;


public class HistoryEntityDaoJPAImpl extends AbstractDaoJPAImpl<HistoryEntity> implements HistoryEntityDao {

    public HistoryEntityDaoJPAImpl() {
        super(HistoryEntity.class);
    }


    @Transactional
    public List<HistoryEntity> findAll() {
        return getJpaTemplate().execute(new JpaCallback<List<HistoryEntity>>() {
            public List<HistoryEntity> doInJpa(EntityManager em) throws PersistenceException {
                TypedQuery<HistoryEntity> query = em.createQuery("select e from HistoryEntity e", HistoryEntity.class);
                return query.getResultList();
            }
        });
    }

    @Transactional
    public List<HistoryEntity> findAllWithoutParent() {
        List<HistoryEntity> es = getJpaTemplate().execute(new JpaCallback<List<HistoryEntity>>() {
            public List<HistoryEntity> doInJpa(EntityManager em) throws PersistenceException {
                TypedQuery<HistoryEntity> query = em.createQuery("select e from HistoryEntity e", HistoryEntity.class);
                return query.getResultList();
            }
        });

        List<HistoryEntity> returnEs = new ArrayList<HistoryEntity>();
        for (HistoryEntity e : es) {
            returnEs.add(e);
        }

        return returnEs;
    }

    @Transactional
    public int countAll() {
        return getJpaTemplate().execute(new JpaCallback<Integer>() {

            public Integer doInJpa(EntityManager em) throws PersistenceException {
                TypedQuery<Long> query = em.createQuery("select count (e) from HistoryEntity e", Long.class);
                return (query.getSingleResult()).intValue();
            }
        });

    }

    @Transactional
    public List<HistoryEntity> findAllByGroupId(final Integer groupId) {
        return getJpaTemplate().execute(new JpaCallback<List<HistoryEntity>>() {
            public List<HistoryEntity> doInJpa(EntityManager em) throws PersistenceException {
                TypedQuery<HistoryEntity> query = em.createQuery("select e from HistoryEntity e where e.groupId=:groupId", HistoryEntity.class);
                query.setParameter("groupId", groupId);
                return query.getResultList();

            }
        });

    }

}
