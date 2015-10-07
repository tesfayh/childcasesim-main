package se.su.dsv.bivsim.data.Case.dao.interfaces;

import se.su.dsv.bivsim.data.Case.dataobjects.InterviewCase2Entity;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: kebede
 * Date: 03/09/13
 * Time: 11:34
 * To change this template use File | Settings | File Templates.
 */
public interface InterviewCase2EntityDao extends Dao<InterviewCase2Entity> {

    public List<InterviewCase2Entity> findAllEntityWithOutParents(Integer groupId);

}
