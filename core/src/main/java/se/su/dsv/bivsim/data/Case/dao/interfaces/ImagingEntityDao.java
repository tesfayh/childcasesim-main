package se.su.dsv.bivsim.data.Case.dao.interfaces;

import se.su.dsv.bivsim.data.Case.dataobjects.ImagingEntity;

import java.util.List;


public interface ImagingEntityDao extends Dao<ImagingEntity> {
    public List<ImagingEntity> findAllEntityWithOutParents(Integer groupId);
}
