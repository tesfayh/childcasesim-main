package se.su.dsv.bivsim.pages.Case3.Case3EditingPages.Case3LabsAndImaging;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.extensions.markup.html.repeater.tree.AbstractTree;
import org.apache.wicket.extensions.markup.html.repeater.tree.content.Folder;
import org.apache.wicket.model.IModel;
import se.su.dsv.bivsim.data.Case.dataobjects.ImagingEntity;

public abstract class LabAndImageEntityFolder extends Folder<ImagingEntity> {

    public LabAndImageEntityFolder(String id, AbstractTree<ImagingEntity> tree, IModel<ImagingEntity> model) {
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
