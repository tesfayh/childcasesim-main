package se.su.dsv.bivsim.pages.Case1.EditingPages.Editphyiscalexam;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;
import se.su.dsv.bivsim.data.Case.dataobjects.PhysicalExamEntity;


public abstract class SelectPhysicalExamEntityParentPanel extends Panel {
    PhysicalExamEntity selectedParent = null;
    Label parentName;

    public SelectPhysicalExamEntityParentPanel(String id, int index) {
        super(id);

        final Form<?> form = new Form<Void>("form") {
            @Override
            public void onSubmit() {
                okay();
            }
        };
        add(form);
        parentName = new Label("selectedParent", "None selected");
        parentName.setOutputMarkupId(true);
        form.add(parentName);
        form.add(new SelectParentTreePanel("selectParentTree", index) {
            @Override
            public void pressed(PhysicalExamEntity entity, AjaxRequestTarget target) {
                selectedParent = entity;
                parentName.setDefaultModel(new Model<String>(entity.getName()));
                target.add(parentName);
            }
        });
    }

    public PhysicalExamEntity getSelectedParent() {
        return selectedParent;
    }

    public abstract void okay();
}
