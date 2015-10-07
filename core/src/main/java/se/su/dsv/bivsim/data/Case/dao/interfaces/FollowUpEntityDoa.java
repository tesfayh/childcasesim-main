package se.su.dsv.bivsim.data.Case.dao.interfaces;

import se.su.dsv.bivsim.data.Case.dataobjects.FollowUpEntity;

/**
 * Created with IntelliJ IDEA.
 * User: kebede
 * Date: 04/10/13
 * Time: 09:40
 * To change this template use File | Settings | File Templates.
 */
public interface FollowUpEntityDoa extends Dao<FollowUpEntity> {
    public FollowUpEntity findObject(long id);

}
