package se.su.dsv.bivsim.data.Case.dao.interfaces;

import se.su.dsv.bivsim.data.Case.dataobjects.PreExpertAssessmentEntity;

/**
 * Created with IntelliJ IDEA.
 * User: kebede
 * Date: 04/10/13
 * Time: 09:45
 * To change this template use File | Settings | File Templates.
 */
public interface PreExpertAssessmentEntityDoa extends Dao<PreExpertAssessmentEntity> {
    public PreExpertAssessmentEntity findObject(long id);
}
