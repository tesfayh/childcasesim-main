package se.su.dsv.bivsim.pages.CommonAllCases.Interv;

import org.apache.wicket.extensions.markup.html.repeater.tree.ITreeProvider;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import se.su.dsv.childcasesim.data.Case.dao.interfaces.InterviewEntityDao;
import se.su.dsv.childcasesim.data.Case.dataobjects.InterviewEntity;

import java.util.Iterator;

public class InterviewEntityProvider implements ITreeProvider<InterviewEntity> {

    private static final long serialVersionUID = 1L;
    int tempGroupID;

    @SpringBean
    private InterviewEntityDao interviewEntityDao;

    public InterviewEntityProvider(InterviewEntityDao interviewEntityDao, final Integer groupId) {
        this.interviewEntityDao = interviewEntityDao;
        tempGroupID = groupId;
    }

    @Override
    public void detach() {
    }

    @Override
    public Iterator<InterviewEntity> getRoots() {

        return interviewEntityDao.findAllEntityWithOutParents(tempGroupID).iterator();
    }

    @Override
    public boolean hasChildren(InterviewEntity interviewEntity) {

        return !interviewEntity.getInterviews().isEmpty();
    }

    @Override
    public Iterator<InterviewEntity> getChildren(final InterviewEntity interviewEntity) {
        return interviewEntity.getInterviews().iterator();
    }


    @Override
    public IModel<InterviewEntity> model(InterviewEntity interviewEntity) {
        return new interviewEntityModel(interviewEntity);

    }


    private class interviewEntityModel extends LoadableDetachableModel<InterviewEntity> {
        private static final long serialVersionUID = 1L;

        private final Long id;

        public interviewEntityModel(InterviewEntity interviewEntity) {
            super();

            id = interviewEntity.getId();
        }

        @Override
        protected InterviewEntity load() {
            return interviewEntityDao.load(id);
        }


        @Override
        public boolean equals(Object obj) {
            if (obj instanceof interviewEntityModel) {
                return ((interviewEntityModel) obj).id.equals(id);
            }
            return false;
        }


        @Override
        public int hashCode() {
            return id.hashCode();
        }
    }
}
