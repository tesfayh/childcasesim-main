package se.su.dsv.bivsim.pages.Case3.Case3EditingPages.Case3EditAssessment;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;
import se.su.dsv.bivsim.data.Case.dao.interfaces.ExpertAssessmentEntityDao;
import se.su.dsv.bivsim.data.Case.dataobjects.ExpertAssessmentEntity;
import se.su.dsv.bivsim.pages.Case3.Case3EditingPages.Case3EdittingCommon.BaseClasses.EditingMainPage3;

public class EditPrelimninaryAsssmentpage extends EditingMainPage3 {


    @SpringBean
    ExpertAssessmentEntityDao expertAssessmentEntityDao;


    public EditPrelimninaryAsssmentpage() {
        final FeedbackPanel feed = new FeedbackPanel("feed");
        feed.setOutputMarkupId(true);
        add(feed);

        final TextArea<String> PysBedo = new TextArea<String>("PysBedo", new Model<String>(expertAssessmentEntityDao.findObject(1).getPysBedo()));

        final TextArea<String> PysAtg = new TextArea<String>("PysAtg", new Model<String>(expertAssessmentEntityDao.findObject(1).getPysAtg()));

        final TextArea<String> PsyBedo = new TextArea<String>("PsyBedo", new Model<String>(expertAssessmentEntityDao.findObject(1).getPsyBedo()));

        final TextArea<String> PsyAtg = new TextArea<String>("PsyAtg", new Model<String>(expertAssessmentEntityDao.findObject(1).getPsyAtg()));

        final TextArea<String> SocialBedo = new TextArea<String>("SocialBedo", new Model<String>(expertAssessmentEntityDao.findObject(1).getSocialBedo()));

        final TextArea<String> SocialAtg = new TextArea<String>("SocialAtg", new Model<String>(expertAssessmentEntityDao.findObject(1).getSocialAtg()));


        final Form<?> form = new Form<Void>("Form") {
            @Override
            public void onSubmit() {
                ExpertAssessmentEntity entity = expertAssessmentEntityDao.load((long) 1);
                entity.setPysBedo(PysBedo.getModelObject());
                entity.setPysAtg(PysAtg.getModelObject());
                entity.setPsyBedo(PsyBedo.getModelObject());
                entity.setPsyAtg(PsyAtg.getModelObject());
                entity.setSocialBedo(SocialBedo.getModelObject());
                entity.setSocialAtg(SocialAtg.getModelObject());
                expertAssessmentEntityDao.save(entity);
                info("You have updated the expert's assessment sucessfuly");

            }
        };
        add(form);
        form.add(PysBedo);
        form.add(PysAtg);
        form.add(PsyBedo);
        form.add(PsyAtg);
        form.add(SocialBedo);
        form.add(SocialAtg);
    }
}
