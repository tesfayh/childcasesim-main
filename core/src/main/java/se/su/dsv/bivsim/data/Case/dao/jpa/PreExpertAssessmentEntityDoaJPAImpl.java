package se.su.dsv.bivsim.data.Case.dao.jpa;

import org.springframework.orm.jpa.JpaCallback;
import org.springframework.transaction.annotation.Transactional;
import se.su.dsv.bivsim.data.Case.dao.interfaces.PreExpertAssessmentEntityDoa;
import se.su.dsv.bivsim.data.Case.dataobjects.PreExpertAssessmentEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;


public class PreExpertAssessmentEntityDoaJPAImpl extends AbstractDaoJPAImpl<PreExpertAssessmentEntity> implements PreExpertAssessmentEntityDoa {
    public PreExpertAssessmentEntityDoaJPAImpl() {
        super(PreExpertAssessmentEntity.class);
    }


    @Transactional
    public List<PreExpertAssessmentEntity> findAll() {
        return getJpaTemplate().execute(new JpaCallback<List<PreExpertAssessmentEntity>>() {
            public List<PreExpertAssessmentEntity> doInJpa(EntityManager em) throws PersistenceException {
                TypedQuery<PreExpertAssessmentEntity> query = em.createQuery("select e from PreExpertAssessmentEntity e", PreExpertAssessmentEntity.class);
                return query.getResultList();

            }
        });
    }

    @Transactional
    public List<PreExpertAssessmentEntity> findAllWithoutParent() {
        List<PreExpertAssessmentEntity> es = getJpaTemplate().execute(new JpaCallback<List<PreExpertAssessmentEntity>>() {
            public List<PreExpertAssessmentEntity> doInJpa(EntityManager em) throws PersistenceException {
                TypedQuery<PreExpertAssessmentEntity> query = em.createQuery("select e from PreExpertAssessmentEntity e", PreExpertAssessmentEntity.class);
                return query.getResultList();
            }
        });

        List<PreExpertAssessmentEntity> returnEs = new ArrayList<PreExpertAssessmentEntity>();
        for (PreExpertAssessmentEntity e : es) {
            returnEs.add(e);
        }


        return returnEs;
    }

    @Transactional
    public int countAll() {
        return getJpaTemplate().execute(new JpaCallback<Integer>() {

            public Integer doInJpa(EntityManager em) throws PersistenceException {
                TypedQuery<Long> query = em.createQuery("select count (e) from PreExpertAssessmentEntity e", Long.class);
                return (query.getSingleResult()).intValue();
            }
        });

    }

    @Transactional
    public List<PreExpertAssessmentEntity> findAllByGroupId(final Integer groupId) {
        return getJpaTemplate().execute(new JpaCallback<List<PreExpertAssessmentEntity>>() {
            public List<PreExpertAssessmentEntity> doInJpa(EntityManager em) throws PersistenceException {
                TypedQuery<PreExpertAssessmentEntity> query = em.createQuery("select e from PreExpertAssessmentEntity e where e.groupId=:groupId ", PreExpertAssessmentEntity.class);
                query.setParameter("groupId", groupId);
                return query.getResultList();

            }
        });


    }

    @Transactional
    public PreExpertAssessmentEntity findObject(final long id) {
        return getJpaTemplate().execute(new JpaCallback<PreExpertAssessmentEntity>() {

            public PreExpertAssessmentEntity doInJpa(EntityManager em) throws PersistenceException {
                PreExpertAssessmentEntity v = em.find(PreExpertAssessmentEntity.class, id);
                return v;


            }
        });

    }
}
