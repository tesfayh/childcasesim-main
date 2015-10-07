package se.su.dsv.bivsim.data.Case.dao.jpa;

import org.springframework.orm.jpa.JpaCallback;
import org.springframework.transaction.annotation.Transactional;
import se.su.dsv.bivsim.data.Case.dao.interfaces.AdminsEntityDao;
import se.su.dsv.bivsim.data.Case.dataobjects.AdminsEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import java.util.List;

public class AdminsEntityDaoJPAImpl extends AbstractDaoJPAImpl<AdminsEntity> implements AdminsEntityDao {

    public AdminsEntityDaoJPAImpl() {
        super(AdminsEntity.class);
    }

    @Transactional
    public List<AdminsEntity> findAll() {
        return getJpaTemplate().execute(new JpaCallback<List<AdminsEntity>>() {
            public List<AdminsEntity> doInJpa(EntityManager em) throws PersistenceException {
                TypedQuery<AdminsEntity> query = em.createQuery("select e from AdminsEntity e", AdminsEntity.class);
                return query.getResultList();
            }
        });
    }

    @Transactional
    public int countAll() {
        return getJpaTemplate().execute(new JpaCallback<Integer>() {

            public Integer doInJpa(EntityManager em) throws PersistenceException {
                TypedQuery<Long> query = em.createQuery("select count (e) from AdminsEntity e", Long.class);
                return (query.getSingleResult()).intValue();
            }
        });

    }

    @Transactional
    public List<AdminsEntity> findAllWithoutParent() {
        List<AdminsEntity> es = getJpaTemplate().execute(new JpaCallback<List<AdminsEntity>>() {
            public List<AdminsEntity> doInJpa(EntityManager em) throws PersistenceException {
                TypedQuery<AdminsEntity> query = em.createQuery("select e from AdminsEntity e", AdminsEntity.class);
                return query.getResultList();
            }
        });

        return es;


    }

    @Transactional
    public List<AdminsEntity> findAllByGroupId(final Integer groupId) {

        return getJpaTemplate().execute(new JpaCallback<List<AdminsEntity>>() {
            @Override
            public List<AdminsEntity> doInJpa(EntityManager em) throws PersistenceException {
                TypedQuery query = em.createQuery("select e from AdminsEntity e ", AdminsEntity.class);
                return query.getResultList();
            }
        });


    }
}
