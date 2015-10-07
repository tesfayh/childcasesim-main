package se.su.dsv.bivsim.data.Case.dao.interfaces;


import se.su.dsv.bivsim.data.Case.dataobjects.VirtualAdviserEntity;

public interface VirtualAdviserEntityDao extends Dao<VirtualAdviserEntity> {
    public void ChangeVirtualAdviser(long id, int feedbackvalue, String feedbackdetail);
}
