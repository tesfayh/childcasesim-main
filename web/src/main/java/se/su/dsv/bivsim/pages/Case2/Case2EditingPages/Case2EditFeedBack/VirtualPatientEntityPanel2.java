package se.su.dsv.bivsim.pages.Case2.Case2EditingPages.Case2EditFeedBack;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.FormComponent;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;
import se.su.dsv.bivsim.data.Case.dao.interfaces.FeedbackEntityDao;
import se.su.dsv.bivsim.data.Case.dataobjects.FeedbackEntity;

public class VirtualPatientEntityPanel2 extends Panel {

    @SpringBean
    FeedbackEntityDao feedbackEntityDao;

    public VirtualPatientEntityPanel2(String id, final FeedbackEntity Obj, String caption) {
        super(id);

        final FormComponent<String> detail = new TextArea<String>("detail", new Model<String>(Obj.getFeedbackValue1())).setRequired(true);
        final FormComponent<String> detail2 = new TextArea<String>("detail2", new Model<String>(Obj.getPatientFeedback())).setRequired(true);

        final Form<?> form = new Form<Void>("form") {
            @Override
            public void onSubmit() {

                FeedbackEntity upateentity = feedbackEntityDao.load(Obj.getFeedbackId());
                upateentity.setFeedbackValue1(detail.getModelObject());
                upateentity.setPatientFeedback(detail2.getModelObject());

                feedbackEntityDao.save(upateentity);


            }
        };
        add(form);
        form.add(new Label("caption", caption));

        form.add(detail);
        form.add(detail2);



    }
}
