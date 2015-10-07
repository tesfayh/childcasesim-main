package se.su.dsv.bivsim.data.Case.dao.interfaces;

import se.su.dsv.bivsim.data.Case.dataobjects.DomainObject;

import java.io.Serializable;
import java.util.List;

public interface Dao<T extends DomainObject> {
    public void delete(T o);

    public T load(Serializable id);

    public T save(T o);

    public List<T> findAll();

    public List<T> findAllWithoutParent();

    public int countAll();

    public List<T> findAllByGroupId(Integer groupId);
}

