package se.su.dsv.bivsim.data.Case.dao.jpa;

import org.springframework.orm.jpa.support.JpaDaoSupport;
import org.springframework.transaction.annotation.Transactional;
import se.su.dsv.bivsim.data.Case.dao.interfaces.Dao;
import se.su.dsv.bivsim.data.Case.dataobjects.DomainObject;

import java.io.Serializable;


public abstract class AbstractDaoJPAImpl<T extends DomainObject> extends JpaDaoSupport implements Dao<T> {

    private Class<T> domainClass;


    public AbstractDaoJPAImpl(Class<T> domainClass) {
        this.domainClass = domainClass;
    }

    @Transactional
    public void delete(T object) {
        getJpaTemplate().remove(object);
    }

    @Transactional
    public T load(Serializable id) {
        return (T) getJpaTemplate().find(domainClass, id);
    }

    @Transactional
    public T save(T object) {
        return getJpaTemplate().merge(object);
    }

}

