package se.su.dsv.bivsim.pages.CommonAllCases.assessment;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.ajax.markup.html.form.AjaxSubmitLink;
import org.apache.wicket.markup.html.form.*;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.Model;
import se.su.dsv.childcasesim.pages.CommonAllCases.assessment.BaseClasses.BaseAssesmentPage;

import java.util.Date;

public class AssessmentPreiliminaryPage extends BaseAssesmentPage {
    public Date date;

    public AssessmentPreiliminaryPage() {

        Model model0 = new Model<Integer>(0);
        Model model1 = new Model<Integer>(1);
        Model model2 = new Model<Integer>(2);
        Model model3 = new Model<Integer>(3);
       final RadioGroup<Integer> group1 = new RadioGroup<Integer>("radioGroup1", model0);
        group1.add(new Radio<Integer>("check1", model1));
        group1.add(new Radio<Integer>("check2", model2));
        group1.add(new Radio<Integer>("check3", model3));
       /* DropDownChoice<String> listsocial = new DropDownChoice<String>(
                "Profession", new PropertyModel<String>(this, "selected"), countries);*/
        final TextArea Bedömning = new TextArea("Bedömning", new Model(""));
        final TextArea Åtgärd = new TextArea("Åtgärd", new Model(""));

        final Form<?> form = new Form("Preliminär") {
            @Override
            public void onSubmit() {
                if(group1.getModelObject()!=null){


                                    if (group1.getModelObject()==1) {

                                        if(Bedömning.getModelObject()!=null)
                                        getSession().setAttribute("urFysBED", Bedömning.getModelObject().toString());

                                        if(Åtgärd.getModelObject()!=null)
                                            getSession().setAttribute("urFysATG", Åtgärd.getModelObject().toString());

                                        getSession().setAttribute("Bedömning", "Fysisk hälsa");


                                    } else if (group1.getModelObject()==2) {
                                              if(Bedömning.getModelObject()!=null)
                                                getSession().setAttribute("urFsyBED", Bedömning.getModelObject().toString());
                                              if(Åtgärd.getModelObject()!=null)
                                                getSession().setAttribute("urFsyATG", Åtgärd.getModelObject().toString());
                                        getSession().setAttribute("Bedömning", "Psykisk hälsa");

                                    } else if(group1.getModelObject()==3) {
                                        if(Bedömning.getModelObject()!=null)
                                            getSession().setAttribute("urSocialBED", Bedömning.getModelObject().toString());
                                        if(Åtgärd.getModelObject()!=null)
                                            getSession().setAttribute("urSocialATG", Åtgärd.getModelObject().toString());
                                        getSession().setAttribute("Bedömning", "Social situation");


                                    }

                                    setResponsePage(AssessmentPreiliminaryPage.class);

                       }// big if close
                       else{
                                    getSession().setAttribute("Bedömning", "");
                                    setResponsePage(AssessmentPreiliminaryPage.class);
                            }

            }
        };
        add(form);
        form.add(Bedömning);
        form.add(Åtgärd);


        form.add(group1);

        form.add(new AjaxSubmitLink("save") {
            @Override
            protected void onSubmit(AjaxRequestTarget target, Form form) {

            }
        });
        Link tillbaka = new AjaxFallbackLink("tillbaka") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                setResponsePage(AssessmentReferalPage.class);

            }


        };
        form.add(tillbaka);


    }
}
