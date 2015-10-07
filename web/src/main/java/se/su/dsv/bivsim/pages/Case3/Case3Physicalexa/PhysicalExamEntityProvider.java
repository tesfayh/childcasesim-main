package se.su.dsv.bivsim.pages.Case3.Case3Physicalexa;

import org.apache.wicket.extensions.markup.html.repeater.tree.ITreeProvider;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import se.su.dsv.bivsim.data.Case.dao.interfaces.PhysicalExamEntityDao;
import se.su.dsv.bivsim.data.Case.dataobjects.PhysicalExamEntity;

import java.util.Iterator;


public class PhysicalExamEntityProvider implements ITreeProvider<PhysicalExamEntity> {


    @SpringBean
    private PhysicalExamEntityDao physicalExamEntityDao;


    private static final long serialVersionUID = 1L;
    public int tempID;

    /*@SpringBean
    private InterviewEntityDao interviewEntityDao*/;

    public PhysicalExamEntityProvider(PhysicalExamEntityDao physicalExamEntityDao, final Integer groupID) {
        this.physicalExamEntityDao = physicalExamEntityDao;
        tempID = groupID;
    }

    @Override
    public void detach() {
    }

    @Override
    public Iterator<PhysicalExamEntity> getRoots() {

        return physicalExamEntityDao.findAllEntityWithOutParents(tempID).iterator();
    }

    @Override
    public boolean hasChildren(PhysicalExamEntity physicalExamEntity) {
      /*  return physicalExamEntity.getParent() == null ||*/
        return !physicalExamEntity.getPhysicalExamEntities().isEmpty();
    }

    @Override
    public Iterator<PhysicalExamEntity> getChildren(final PhysicalExamEntity physicalExamEntity) {
        return physicalExamEntity.getPhysicalExamEntities().iterator();
    }


    @Override
    public IModel<PhysicalExamEntity> model(PhysicalExamEntity physicalExamEntity) {
        return new physicalExamEntityModel(physicalExamEntity);

    }


    private class physicalExamEntityModel extends LoadableDetachableModel<PhysicalExamEntity> {
        private static final long serialVersionUID = 1L;

        private final Long id;

        public physicalExamEntityModel(PhysicalExamEntity physicalExamEntity) {
            super();

            id = physicalExamEntity.getPhysicalExamId();
        }

        @Override
        protected PhysicalExamEntity load() {
            return physicalExamEntityDao.load(id);
        }


        @Override
        public boolean equals(Object obj) {
            if (obj instanceof physicalExamEntityModel) {
                return ((physicalExamEntityModel) obj).id.equals(id);
            }
            return false;
        }


        @Override
        public int hashCode() {
            return id.hashCode();
        }
    }
}
