package se.su.dsv.bivsim.data.Case.dao.jpa;

import org.springframework.orm.jpa.JpaCallback;
import org.springframework.transaction.annotation.Transactional;
import se.su.dsv.bivsim.data.Case.dao.interfaces.ImagingEntityDao;
import se.su.dsv.bivsim.data.Case.dataobjects.ImagingEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class ImagingEntityDaoJPAImp extends AbstractDaoJPAImpl<ImagingEntity> implements ImagingEntityDao {


    public ImagingEntityDaoJPAImp() {
        super(ImagingEntity.class);
    }

    @Transactional
    public List<ImagingEntity> findAll() {
        return getJpaTemplate().execute(new JpaCallback<List<ImagingEntity>>() {
            public List<ImagingEntity> doInJpa(EntityManager em) throws PersistenceException {
                TypedQuery<ImagingEntity> query = em.createQuery("select e from ImagingEntity e where picId IS NOT NULL ", ImagingEntity.class);
                return query.getResultList();
            }
        });
    }

    @Transactional
    public List<ImagingEntity> findAllWithoutParent() {
        List<ImagingEntity> es = getJpaTemplate().execute(new JpaCallback<List<ImagingEntity>>() {
            public List<ImagingEntity> doInJpa(EntityManager em) throws PersistenceException {
                TypedQuery<ImagingEntity> query = em.createQuery("select e from ImagingEntity e", ImagingEntity.class);
                return query.getResultList();
            }
        });

        List<ImagingEntity> returnEs = new ArrayList<ImagingEntity>();
        for (ImagingEntity e : es) {
            if (e.getParent() == null)
                returnEs.add(e);
        }


        return returnEs;
    }

    @Transactional
    public int countAll() {
        return getJpaTemplate().execute(new JpaCallback<Integer>() {

            public Integer doInJpa(EntityManager em) throws PersistenceException {
                TypedQuery<Long> query = em.createQuery("select count (e) from ImagingEntity e", Long.class);
                return (query.getSingleResult()).intValue();
            }
        });

    }

    @Transactional
    public List<ImagingEntity> findAllByGroupId(final Integer groupId) {

        return getJpaTemplate().execute(new JpaCallback<List<ImagingEntity>>() {
                                            @Override
                                            public List<ImagingEntity> doInJpa(EntityManager em) throws PersistenceException {
                                                TypedQuery<ImagingEntity> query = em.createQuery("select e from ImagingEntity e where e.groupId =:groupId", ImagingEntity.class);
                                                query.setParameter("groupId", groupId);
                                                return query.getResultList();
                                            }
                                        }

        );

    }

    @Transactional
    public List<ImagingEntity> findAllEntityWithOutParents(final Integer cate_Id) {

        List<ImagingEntity> es = getJpaTemplate().execute(new JpaCallback<List<ImagingEntity>>() {
            @Override
            public List<ImagingEntity> doInJpa(EntityManager em) throws PersistenceException {
                TypedQuery<ImagingEntity> query = em.createQuery("select e from ImagingEntity e where e.cate_ID=:cate_Id", ImagingEntity.class);
                query.setParameter("cate_Id", cate_Id);
                return query.getResultList();

            }
        });
        List<ImagingEntity> returnEs = new ArrayList<ImagingEntity>();
        for (ImagingEntity e : es) {
            if (e.getParent() == null)
                returnEs.add(e);
        }

        return returnEs;


    }
}
