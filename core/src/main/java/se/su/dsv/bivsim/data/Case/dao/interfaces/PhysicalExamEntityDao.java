package se.su.dsv.bivsim.data.Case.dao.interfaces;

import se.su.dsv.bivsim.data.Case.dataobjects.PhysicalExamEntity;

import java.util.List;


public interface PhysicalExamEntityDao extends Dao<PhysicalExamEntity> {
    public List<PhysicalExamEntity> findAllEntityWithOutParents(Integer groupId);

    public List<PhysicalExamEntity> findAllByCateID(Integer cateID);


}
