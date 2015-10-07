package se.su.dsv.bivsim.pages.Case1.EditingPages.EditInterview;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;
import se.su.dsv.bivsim.data.Case.dataobjects.InterviewEntity;

public abstract class SelectInterviewEntityParentPanel extends Panel {
    InterviewEntity selectedParent = null;
    Label parentName;

    public SelectInterviewEntityParentPanel(String id, int index, String type) {
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
        form.add(new SelectParentTreePanel("selectParentTree", index, type) {
            @Override
            public void pressed(InterviewEntity entity, AjaxRequestTarget target) {
                selectedParent = entity;
                parentName.setDefaultModel(new Model<String>(entity.getName()));
                target.add(parentName);
            }
        });
    }

    public InterviewEntity getSelectedParent() {
        return selectedParent;
    }

    public abstract void okay();
}
