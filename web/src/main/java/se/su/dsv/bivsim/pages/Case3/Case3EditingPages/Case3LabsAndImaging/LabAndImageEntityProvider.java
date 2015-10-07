package se.su.dsv.bivsim.pages.Case3.Case3EditingPages.Case3LabsAndImaging;

import org.apache.wicket.extensions.markup.html.repeater.tree.ITreeProvider;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import se.su.dsv.bivsim.data.Case.dao.interfaces.ImagingEntityDao;
import se.su.dsv.bivsim.data.Case.dataobjects.ImagingEntity;

import java.util.Iterator;

public class LabAndImageEntityProvider implements ITreeProvider<ImagingEntity> {


    @SpringBean
    private ImagingEntityDao imagingEntityDao;


    private static final long serialVersionUID = 1L;
    int temp;


    public LabAndImageEntityProvider(ImagingEntityDao imagingEntityDao, int index) {

        this.imagingEntityDao = imagingEntityDao;
        temp=index;
    }

    @Override
    public void detach() {
    }

    @Override
    public Iterator<ImagingEntity> getRoots() {

        return imagingEntityDao.findAllEntityWithOutParents(temp).iterator();
    }

    @Override
    public boolean hasChildren(ImagingEntity imagingEntity) {
        return !imagingEntity.getImagingEntities().isEmpty();
    }

    @Override
    public Iterator<ImagingEntity> getChildren(final ImagingEntity imagingEntity) {
        return imagingEntity.getImagingEntities().iterator();
    }


    @Override
    public IModel<ImagingEntity> model(ImagingEntity imagingEntity) {
        return new imagingEntityModel(imagingEntity);

    }


    private class imagingEntityModel extends LoadableDetachableModel<ImagingEntity> {
        private static final long serialVersionUID = 1L;

        private final Long id;

        public imagingEntityModel(ImagingEntity imagingEntity) {
            super();

            id = imagingEntity.getImagingId();
        }

        @Override
        protected ImagingEntity load() {
            return imagingEntityDao.load(id);
        }


        @Override
        public boolean equals(Object obj) {
            if (obj instanceof imagingEntityModel) {
                return ((imagingEntityModel) obj).id.equals(id);
            }
            return false;
        }


        @Override
        public int hashCode() {
            return id.hashCode();
        }
    }
}
