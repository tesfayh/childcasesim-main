package se.su.dsv.bivsim.data.Case.dao.jpa;

import org.springframework.orm.jpa.JpaCallback;
import org.springframework.transaction.annotation.Transactional;
import se.su.dsv.bivsim.data.Case.dao.interfaces.ReportEntityDao;
import se.su.dsv.bivsim.data.Case.dataobjects.ReportEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;


public class ReportEntityDaoJPAImpl extends AbstractDaoJPAImpl<ReportEntity> implements ReportEntityDao {

    public ReportEntityDaoJPAImpl() {
        super(ReportEntity.class);
    }

    @Transactional
    public List<ReportEntity> findAll() {
        return getJpaTemplate().execute(new JpaCallback<List<ReportEntity>>() {
            public List<ReportEntity> doInJpa(EntityManager em) throws PersistenceException {
                TypedQuery<ReportEntity> query = em.createQuery("select e from ReportEntity e", ReportEntity.class);
                return query.getResultList();
            }
        });
    }


    @Transactional
    public List<ReportEntity> findAllWithoutParent() {
        List<ReportEntity> es = getJpaTemplate().execute(new JpaCallback<List<ReportEntity>>() {
            public List<ReportEntity> doInJpa(EntityManager em) throws PersistenceException {
                TypedQuery<ReportEntity> query = em.createQuery("select e from ReportEntity e", ReportEntity.class);
                return query.getResultList();
            }
        });

        List<ReportEntity> returnEs = new ArrayList<ReportEntity>();
        for (ReportEntity e : es) {
            returnEs.add(e);
        }

        return returnEs;
    }

    @Transactional
    public int countAll() {
        return getJpaTemplate().execute(new JpaCallback<Integer>() {

            public Integer doInJpa(EntityManager em) throws PersistenceException {
                TypedQuery<Long> query = em.createQuery("select count (e) from ReportEntity e", Long.class);
                return (query.getSingleResult()).intValue();
            }
        });

    }

    @Transactional
    public List<ReportEntity> findAllByGroupId(final Integer groupId) {
        return getJpaTemplate().execute(new JpaCallback<List<ReportEntity>>() {
            public List<ReportEntity> doInJpa(EntityManager em) throws PersistenceException {
                TypedQuery<ReportEntity> query = em.createQuery("select e from ReportEntity e where e.groupId=:groupId", ReportEntity.class);
                query.setParameter("groupId", groupId);
                return query.getResultList();

            }
        });

    }

}

