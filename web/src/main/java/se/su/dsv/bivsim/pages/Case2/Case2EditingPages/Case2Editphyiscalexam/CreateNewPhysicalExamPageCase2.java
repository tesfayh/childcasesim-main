package se.su.dsv.bivsim.pages.Case2.Case2EditingPages.Case2Editphyiscalexam;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.FormComponent;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import se.su.dsv.bivsim.data.Case.dao.interfaces.PhysicalExamEntityDao;
import se.su.dsv.bivsim.data.Case.dataobjects.PhysicalExamEntity;
import se.su.dsv.bivsim.pages.Case2.Case2EditingPages.Case2EdittingCommon.BaseClasses.EditingMainPage2;


public class CreateNewPhysicalExamPageCase2 extends EditingMainPage2 {

    private String interviewName;

    @SpringBean
    PhysicalExamEntityDao physicalExamEntityDao;

    public CreateNewPhysicalExamPageCase2() {
        FeedbackPanel feed = new FeedbackPanel("feed");
        feed.setOutputMarkupId(true);
        add(feed);
        final FormComponent<String> InterviewName = new TextArea<String>("Question", new PropertyModel<String>(this, "interviewName")).setRequired(true);
        ;

        Form<?> form = new Form<Void>("createNew") {

            @Override
            public void onSubmit() {

                PhysicalExamEntity interviewEntity = new PhysicalExamEntity();
                interviewEntity.setName(interviewName);
                interviewEntity.setGroupId(1);
                physicalExamEntityDao.save(interviewEntity);
                info("You have created a new Physical Exam successfully");

                interviewName = null;

            }

        };
        add(form);
        form.add(InterviewName);

    }
}
