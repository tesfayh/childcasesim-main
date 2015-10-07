package se.su.dsv.bivsim.pages.Case1.interview;

import org.apache.wicket.extensions.markup.html.repeater.tree.ITreeProvider;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import se.su.dsv.bivsim.data.Case.dao.interfaces.InterviewEntityDao;
import se.su.dsv.bivsim.data.Case.dataobjects.InterviewEntity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SearchInterviewProvider implements ITreeProvider<InterviewEntity> {

    private static final long serialVersionUID = 1L;
    String tempSearch;

    @SpringBean
    private InterviewEntityDao interviewEntityDao;

    public SearchInterviewProvider(InterviewEntityDao interviewEntityDao, final String search) {
        this.interviewEntityDao = interviewEntityDao;
        tempSearch = search;
    }

    @Override
    public void detach() {
    }

    @Override
    public Iterator<InterviewEntity> getRoots() {

        final List<InterviewEntity> newList = new ArrayList<InterviewEntity>();
        List<InterviewEntity> tempo = interviewEntityDao.findAll();
        for (InterviewEntity curr : tempo) {
            if (curr.getName()!=null && curr.getName().contains(tempSearch))
                newList.add(curr);
        }
        return newList.iterator();
        /*System.out.println(tempSearch);

        return interviewEntityDao.findAll().iterator();
*/
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
