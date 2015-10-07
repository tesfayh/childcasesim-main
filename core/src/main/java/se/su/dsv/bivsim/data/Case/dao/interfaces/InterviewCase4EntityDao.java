package se.su.dsv.bivsim.data.Case.dao.interfaces;

import se.su.dsv.bivsim.data.Case.dataobjects.InterviewCase4Entity;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: kebede
 * Date: 03/09/13
 * Time: 11:34
 * To change this template use File | Settings | File Templates.
 */
public interface InterviewCase4EntityDao extends Dao<InterviewCase4Entity> {

    public List<InterviewCase4Entity> findAllEntityWithOutParents(Integer groupId);

}
