package se.su.dsv.bivsim.pages.Case3.Case3EditingPages.Case3EditInterview;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.extensions.markup.html.repeater.tree.AbstractTree;
import org.apache.wicket.extensions.markup.html.repeater.tree.content.Folder;
import org.apache.wicket.model.IModel;
import se.su.dsv.bivsim.data.Case.dataobjects.InterviewEntity;

public abstract class InterviewFolder extends Folder<InterviewEntity> {

    public InterviewFolder(String id, AbstractTree<InterviewEntity> tree, IModel<InterviewEntity> model) {
        super(id, tree, model);
    }

    @Override
    public void onClick(AjaxRequestTarget target) {
        super.onClick(target);

        clicked(target);
    }

    public abstract void clicked(AjaxRequestTarget target);

    @Override
    protected String getClosedStyleClass() {
        return super.getClosedStyleClass();

    }
}
