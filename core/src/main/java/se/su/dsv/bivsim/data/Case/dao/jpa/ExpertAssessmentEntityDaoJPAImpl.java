package se.su.dsv.bivsim.data.Case.dao.jpa;

import org.springframework.orm.jpa.JpaCallback;
import org.springframework.transaction.annotation.Transactional;
import se.su.dsv.bivsim.data.Case.dao.interfaces.ExpertAssessmentEntityDao;
import se.su.dsv.bivsim.data.Case.dataobjects.ExpertAssessmentEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;


public class ExpertAssessmentEntityDaoJPAImpl extends AbstractDaoJPAImpl<ExpertAssessmentEntity> implements ExpertAssessmentEntityDao {

    public ExpertAssessmentEntityDaoJPAImpl() {
        super(ExpertAssessmentEntity.class);
    }

    @Transactional
    public List<ExpertAssessmentEntity> findAll() {
        return getJpaTemplate().execute(new JpaCallback<List<ExpertAssessmentEntity>>() {
            public List<ExpertAssessmentEntity> doInJpa(EntityManager em) throws PersistenceException {
                TypedQuery<ExpertAssessmentEntity> query = em.createQuery("select e from InterviewEntity e", ExpertAssessmentEntity.class);
                return query.getResultList();
            }
        });
    }

    @Transactional
    public List<ExpertAssessmentEntity> findAllWithoutParent() {
        List<ExpertAssessmentEntity> es = getJpaTemplate().execute(new JpaCallback<List<ExpertAssessmentEntity>>() {
            public List<ExpertAssessmentEntity> doInJpa(EntityManager em) throws PersistenceException {
                Query query = em.createQuery("select e from InterviewEntity e ");
                List<ExpertAssessmentEntity> results = query.getResultList();
                return results;
            }
        });

        List<ExpertAssessmentEntity> returnEs = new ArrayList<ExpertAssessmentEntity>();
        for (ExpertAssessmentEntity e : es) {
          /*  if (e.getParent() == null)*/
            returnEs.add(e);
        }


        return returnEs;
    }

    @Transactional
    public int countAll() {
        return getJpaTemplate().execute(new JpaCallback<Integer>() {

            public Integer doInJpa(EntityManager em) throws PersistenceException {
                TypedQuery<Long> query = em.createQuery("select count (e) from InterviewEntity e", Long.class);
                return (query.getSingleResult()).intValue();
            }
        });

    }

    @Transactional
    public List<ExpertAssessmentEntity> findAllByGroupId(final Integer groupId) {
        return getJpaTemplate().execute(new JpaCallback<List<ExpertAssessmentEntity>>() {
            public List<ExpertAssessmentEntity> doInJpa(EntityManager em) throws PersistenceException {
                TypedQuery<ExpertAssessmentEntity> query = em.createQuery("select e from InterviewEntity e where e.groupId=:groupId", ExpertAssessmentEntity.class);
                query.setParameter("groupId", groupId);
                return query.getResultList();
            }
        });

    }


    @Transactional
    public List<ExpertAssessmentEntity> findAllEntityWithOutParents(final Integer groupId) {
        List<ExpertAssessmentEntity> es = getJpaTemplate().execute(new JpaCallback<List<ExpertAssessmentEntity>>() {
            public List<ExpertAssessmentEntity> doInJpa(EntityManager em) throws PersistenceException {
                Query query = em.createQuery("select e from InterviewEntity e where e.groupId=:groupId ", ExpertAssessmentEntity.class);
                query.setParameter("groupId", groupId);
                List<ExpertAssessmentEntity> results = query.getResultList();
                return results;
            }
        });

        return es;

    }

    @Transactional
    public List<ExpertAssessmentEntity> findAllEntityByParentID(final Integer groupId) {
        List<ExpertAssessmentEntity> es = getJpaTemplate().execute(new JpaCallback<List<ExpertAssessmentEntity>>() {
            public List<ExpertAssessmentEntity> doInJpa(EntityManager em) throws PersistenceException {
                Query query = em.createQuery("select e from ExpertAssessmentEntity e", ExpertAssessmentEntity.class);
                //   query.setParameter("groupId", groupId);
                List<ExpertAssessmentEntity> results = query.getResultList();
                return results;
            }
        });

       /* List<ExpertAssessmentEntity> returnEs = new ArrayList<ExpertAssessmentEntity>();
        for (ExpertAssessmentEntity e : es) {
            *//*if (e.getParent() == null)*//*
                returnEs.add(e);
        }*/


        return es;

    }


    @Transactional
    public ExpertAssessmentEntity findObject(final long id) {
        return getJpaTemplate().execute(new JpaCallback<ExpertAssessmentEntity>() {

            public ExpertAssessmentEntity doInJpa(EntityManager em) throws PersistenceException {
                ExpertAssessmentEntity v = em.find(ExpertAssessmentEntity.class, id);
                return v;


            }
        });

    }

}
