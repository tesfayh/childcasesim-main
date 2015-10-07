package se.su.dsv.bivsim.data.Case.dao.jpa;

import org.springframework.orm.jpa.JpaCallback;
import org.springframework.transaction.annotation.Transactional;
import se.su.dsv.bivsim.data.Case.dao.interfaces.AllCasesEntityDao;
import se.su.dsv.bivsim.data.Case.dataobjects.AllCasesEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import java.util.List;

public class AllCasesEntityDaoJPAImpl extends AbstractDaoJPAImpl<AllCasesEntity> implements AllCasesEntityDao {

    public AllCasesEntityDaoJPAImpl() {
        super(AllCasesEntity.class);
    }


    @Transactional
    public List<AllCasesEntity> findAll() {
        return getJpaTemplate().execute(new JpaCallback<List<AllCasesEntity>>() {
            public List<AllCasesEntity> doInJpa(EntityManager em) throws PersistenceException {
                TypedQuery<AllCasesEntity> query = em.createQuery("select e from AllCasesEntity e", AllCasesEntity.class);
                return query.getResultList();
            }
        });
    }

    @Transactional
    public int countAll() {
        return getJpaTemplate().execute(new JpaCallback<Integer>() {

            public Integer doInJpa(EntityManager em) throws PersistenceException {
                TypedQuery<Long> query = em.createQuery("select count (e) from AllCasesEntity e", Long.class);
                return (query.getSingleResult()).intValue();
            }
        });

    }

    @Transactional
    public List<AllCasesEntity> findAllWithoutParent() {
        List<AllCasesEntity> es = getJpaTemplate().execute(new JpaCallback<List<AllCasesEntity>>() {
            public List<AllCasesEntity> doInJpa(EntityManager em) throws PersistenceException {
                TypedQuery<AllCasesEntity> query = em.createQuery("select e from AllCasesEntity e", AllCasesEntity.class);
                return query.getResultList();
            }
        });

        return es;


    }

    @Transactional
    public List<AllCasesEntity> findAllByGroupId(final Integer groupId) {

        return getJpaTemplate().execute(new JpaCallback<List<AllCasesEntity>>() {
            @Override
            public List<AllCasesEntity> doInJpa(EntityManager em) throws PersistenceException {
                TypedQuery query = em.createQuery("select e from AllCasesEntity e ", AllCasesEntity.class);
                return query.getResultList();
            }
        });


    }

    @Transactional
    public List<AllCasesEntity> FindallNotFree() {

        return getJpaTemplate().execute(new JpaCallback<List<AllCasesEntity>>() {
            @Override
            public List<AllCasesEntity> doInJpa(EntityManager em) throws PersistenceException {
                TypedQuery<AllCasesEntity> query = em.createQuery("select e from AllCasesEntity  e where e.name!='Free' ", AllCasesEntity.class);
                // query.setParameter("groupId", groupId);
                return query.getResultList();
            }
        });

    }

}
