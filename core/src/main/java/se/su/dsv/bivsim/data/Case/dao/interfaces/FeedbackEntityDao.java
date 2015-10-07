package se.su.dsv.bivsim.data.Case.dao.interfaces;

import se.su.dsv.bivsim.data.Case.dataobjects.FeedbackEntity;

public interface FeedbackEntityDao extends Dao<FeedbackEntity> {
    public FeedbackEntity findObject(long id);
}
