package se.su.dsv.bivsim.pages.Case1.EditingPages.EditFeedBack;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;
import se.su.dsv.bivsim.data.Case.dao.interfaces.VirtualAdviserEntityDao;
import se.su.dsv.bivsim.data.Case.dataobjects.VirtualAdviserEntity;

public class VirtualAdviserEntityPanel extends Panel {
    @SpringBean
    VirtualAdviserEntityDao virtualAdviserEntityDao;

    public VirtualAdviserEntityPanel(String id, final IModel<VirtualAdviserEntity> model) {
        super(id, model);


        final TextArea<String> detail = new TextArea<String>("detail", new Model<String>(model.getObject().getFeedbackDetail()));

        final TextArea<Integer> value = new TextArea<Integer>("value", new Model<Integer>(model.getObject().getFeedbackValue()));

        final Form<?> form = new Form<Void>("form") {
            @Override
            public void onSubmit() {
                VirtualAdviserEntity ad = new VirtualAdviserEntity();
                ad.setFeedbackDetail(detail.getModelObject());
                virtualAdviserEntityDao.ChangeVirtualAdviser(model.getObject().getFeedbackId(), Integer.parseInt(value.getValue()), detail.getDefaultModelObjectAsString());

            }
        };
        add(form);
        form.add(new Label("group", model.getObject().getFeedbackGroup()));
        form.add(detail);
        form.add(value);

    }

}
