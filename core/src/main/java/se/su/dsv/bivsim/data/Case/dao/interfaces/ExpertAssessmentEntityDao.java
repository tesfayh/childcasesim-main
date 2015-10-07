package se.su.dsv.bivsim.data.Case.dao.interfaces;

import se.su.dsv.bivsim.data.Case.dataobjects.ExpertAssessmentEntity;

/**
 * Created by kib on 3/12/15.
 */
public interface ExpertAssessmentEntityDao extends Dao<ExpertAssessmentEntity> {
    public ExpertAssessmentEntity findObject(long id);

}
