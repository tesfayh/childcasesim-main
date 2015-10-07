package se.su.dsv.bivsim.pages.Case3.Case3EditingPages.Case3Editphyiscalexam;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.extensions.markup.html.repeater.tree.AbstractTree;
import org.apache.wicket.extensions.markup.html.repeater.tree.content.Folder;
import org.apache.wicket.model.IModel;
import se.su.dsv.bivsim.data.Case.dataobjects.PhysicalExamEntity;

public abstract class PhysicalExamEntityFolder extends Folder<PhysicalExamEntity> {

    public PhysicalExamEntityFolder(String id, AbstractTree<PhysicalExamEntity> tree, IModel<PhysicalExamEntity> model) {
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
        if (getModelObject().getParent() == null) {
            return super.getClosedStyleClass();
        }
        return "my-closed-style";
    }
}
