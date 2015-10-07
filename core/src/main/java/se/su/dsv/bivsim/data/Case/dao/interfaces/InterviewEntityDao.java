package se.su.dsv.bivsim.data.Case.dao.interfaces;

import se.su.dsv.bivsim.data.Case.dataobjects.InterviewEntity;

import java.util.List;

public interface InterviewEntityDao extends Dao<InterviewEntity> {

    public List<InterviewEntity> findAllEntityWithOutParents(Integer groupId, String type);

    public List<InterviewEntity> findAllEntityByParentID(Integer groupId);
}
