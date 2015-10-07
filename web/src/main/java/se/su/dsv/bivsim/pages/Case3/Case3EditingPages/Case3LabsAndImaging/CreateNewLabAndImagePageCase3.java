package se.su.dsv.bivsim.pages.Case3.Case3EditingPages.Case3LabsAndImaging;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.FormComponent;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import se.su.dsv.bivsim.data.Case.dao.interfaces.ImagingEntityDao;
import se.su.dsv.bivsim.data.Case.dataobjects.ImagingEntity;
import se.su.dsv.bivsim.pages.Case3.Case3EditingPages.Case3EdittingCommon.BaseClasses.EditingMainPage3;

public class CreateNewLabAndImagePageCase3 extends EditingMainPage3 {

    private String interviewName;

    @SpringBean
    ImagingEntityDao imagingEntityDao;

    public CreateNewLabAndImagePageCase3() {
        FeedbackPanel feed = new FeedbackPanel("feed");
        feed.setOutputMarkupId(true);
        add(feed);
        final FormComponent<String> InterviewName = new TextArea<String>("Question", new PropertyModel<String>(this, "interviewName")).setRequired(true);
        ;

        Form<?> form = new Form<Void>("createNew") {

            @Override
            public void onSubmit() {

                ImagingEntity interviewEntity = new ImagingEntity();
                interviewEntity.setName(interviewName);
                interviewEntity.setGroupId(1);
                imagingEntityDao.save(interviewEntity);
                info("You have created a new imaging successfully");

                interviewName = null;

            }

        };
        add(form);
        form.add(InterviewName);

    }
}
