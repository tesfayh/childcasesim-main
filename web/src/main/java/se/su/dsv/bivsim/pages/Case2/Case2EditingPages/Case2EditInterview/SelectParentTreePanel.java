package se.su.dsv.bivsim.pages.Case2.Case2EditingPages.Case2EditInterview;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.extensions.markup.html.repeater.tree.DefaultNestedTree;
import org.apache.wicket.model.IModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import se.su.dsv.bivsim.data.Case.dao.interfaces.InterviewEntityDao;
import se.su.dsv.bivsim.data.Case.dataobjects.InterviewEntity;
import se.su.dsv.bivsim.pages.Case2.Case2Interview.AbstractTreePanel;
import se.su.dsv.bivsim.pages.Case2.Case2Interview.SimplePanel;

public abstract class SelectParentTreePanel extends AbstractTreePanel {

    @SpringBean
    InterviewEntityDao interviewEntityDao;


    private static final long serialVersionUID = 1L;

    public SelectParentTreePanel(String id, final Integer groupId, String type) {
        super(id);

        add(new DefaultNestedTree<InterviewEntity>("tree", new InterviewEntityProvider(interviewEntityDao, groupId, type)) {
            @Override
            public Component newContentComponent(String id, final IModel<InterviewEntity> model) {
                if (getProvider().hasChildren(model.getObject()))

                    return new InterviewFolder(id, this, model) {

                        @Override
                        public void clicked(AjaxRequestTarget target) {

                            pressed(model.getObject(), target);

                        }

                    };
                return new SimplePanel(id, model) {
                    @Override
                    public void clicked(AjaxRequestTarget target) {

                        pressed(model.getObject(), target);

                    }
                };
            }
        });
    }

    public abstract void pressed(InterviewEntity entity, AjaxRequestTarget target);
}