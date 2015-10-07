package se.su.dsv.bivsim.pages.Case3.Case3EditingPages.Case3EditFeedBack;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.FormComponent;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;
import se.su.dsv.bivsim.data.Case.dao.interfaces.FeedbackEntityDao;
import se.su.dsv.bivsim.data.Case.dataobjects.FeedbackEntity;

public class VirtualPatientEntityPanel3 extends Panel {
    @SpringBean
    FeedbackEntityDao feedbackEntityDao;

    public VirtualPatientEntityPanel3(String id, final FeedbackEntity Obj, String caption1, String caption2, String caption3) {
        super(id);
        final FormComponent<String> detail = new TextArea<String>("detail", new Model<String>(Obj.getFeedbackValue1())).setRequired(true);
        final FormComponent<String> detail2 = new TextArea<String>("detail2", new Model<String>(Obj.getFeedbackValue2())).setRequired(true);
        final FormComponent<String> detail3 = new TextArea<String>("detail3", new Model<String>(Obj.getFeedbackValue3())).setRequired(true);
        final Form<?> form = new Form<Void>("form") {
            @Override
            public void onSubmit() {
                FeedbackEntity upateentity = feedbackEntityDao.load(Obj.getFeedbackId());
                upateentity.setFeedbackValue1(detail.getModelObject());
                upateentity.setFeedbackValue2(detail2.getModelObject());
                upateentity.setFeedbackValue3(detail3.getModelObject());
                feedbackEntityDao.save(upateentity);
            }
        };
        add(form);
        form.add(new Label("caption1", caption1));
        form.add(new Label("caption2", caption2));
        form.add(new Label("caption3", caption3));

        form.add(detail);
        form.add(detail2);
        form.add(detail3);


    }
}
