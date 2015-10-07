package se.su.dsv.bivsim.pages.Case3.Case3assessment;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import se.su.dsv.bivsim.pages.Case3.Case3assessment.BaseClasses.BaseAssesmentPageCase3;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by kib on 1/3/15.
 */
public class AssessmentPreiliminaryPageCase3 extends BaseAssesmentPageCase3 {
    public Date date;
    private String selected = "Fysisk hälsa";
    private static final List<String> countries = Arrays.asList(new String[]{
            "Fysisk hälsa", "Psykisk hälsa", "Social situation"});

    public AssessmentPreiliminaryPageCase3() {

        DropDownChoice<String> listsocial = new DropDownChoice<String>(
                "Profession", new PropertyModel<String>(this, "selected"), countries);
        final TextArea Bedömning = new TextArea("Bedömning", new Model(""));
        final TextArea Åtgärd = new TextArea("Åtgärd", new Model(""));


        final Form<?> form = new Form("Preliminär") {
            @Override
            public void onSubmit() {
                if(Bedömning.getModelObject()!=null || Åtgärd.getModelObject()!=null ) {
                if (selected.equals("Fysisk hälsa")) {
                    getSession().setAttribute("urFysBED", Bedömning.getModelObject().toString());
                    getSession().setAttribute("urFysATG", Åtgärd.getModelObject().toString());

                } else if (selected.equals("Psykisk hälsa")) {
                    getSession().setAttribute("urFsyBED", Bedömning.getModelObject().toString());
                    getSession().setAttribute("urFsyATG", Åtgärd.getModelObject().toString());

                } else {
                    getSession().setAttribute("urSocialBED", Bedömning.getModelObject().toString());
                    getSession().setAttribute("urSocialATG", Åtgärd.getModelObject().toString());

                }


                }
                getSession().setAttribute("Bedömning", selected);

                //System.out.println(getSession().getAttribute("urFysBED"));
                setResponsePage(AssessmentPreiliminaryPageCase3.class);
            }
        };
        this.add(form);
        form.add(listsocial);
        form.add(Bedömning);
        form.add(Åtgärd);


        Link tillbaka = new AjaxFallbackLink("tillbaka") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                setResponsePage(AssessmentReferalCase3Page.class);

            }


        };
        form.add(tillbaka);


    }
}
