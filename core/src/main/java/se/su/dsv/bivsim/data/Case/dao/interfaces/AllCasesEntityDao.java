package se.su.dsv.bivsim.data.Case.dao.interfaces;

import se.su.dsv.bivsim.data.Case.dataobjects.AllCasesEntity;

import java.util.List;

public interface AllCasesEntityDao extends Dao<AllCasesEntity> {

    public List<AllCasesEntity> FindallNotFree();

}
