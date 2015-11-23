package se.su.dsv.bivsim.pages.CommonAllCases.assessment;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.ajax.markup.html.form.AjaxSubmitLink;
import org.apache.wicket.extensions.markup.html.form.DateTextField;
import org.apache.wicket.extensions.yui.calendar.DatePicker;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import se.su.dsv.childcasesim.pages.CommonAllCases.assessment.BaseClasses.BaseAssesmentPage;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class AssessmentReferalPage extends BaseAssesmentPage {
    public Date date;
    private String selected = "välja";
    private static final List<String> countries = Arrays.asList(new String[]{
            "välja",  "Psykiatriker", "Sjukgymnast", "Psykoterapeut", "Dietist", "Psykolog", "Arbetsterapeut", "Kurator", "Annan"});

    public AssessmentReferalPage() {
        final DateTextField dateTextField = new DateTextField("dateTextField", new PropertyModel<Date>(this, "date"));
        DatePicker datePicker = new DatePicker();
        datePicker.setShowOnFieldClick(true);
        datePicker.setAutoHide(true);
        dateTextField.add(datePicker);

        DropDownChoice<String> listprofesstions = new DropDownChoice<String>(
                "Profession", new PropertyModel<String>(this, "selected"), countries);
        final TextArea Anledning = new TextArea("Anledning", new Model(""));
        final TextArea Diagnos = new TextArea("Diagnos", new Model(""));
        final TextArea Historia = new TextArea("Historia", new Model(""));


        final Form<?> form = new Form("professionForm") {
            @Override
            public void onSubmit() {

                if (date != null) {
                    getSession().setAttribute("followupvalue", 1);
                }

                if(!selected.equals("välja"))
                getSession().setAttribute("referralValue", selected);


                setResponsePage(AssessmentPreiliminaryPage.class);


            }


        };
        this.add(form);
        form.add(listprofesstions);
        form.add(Anledning);
        form.add(Diagnos);
        form.add(Historia);
        form.add(dateTextField);

        form.add(new AjaxSubmitLink("save") {
            @Override
            protected void onSubmit(AjaxRequestTarget target, Form form) {

            }
        });


        /*Link next = new AjaxFallbackLink("next") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                setResponsePage(AssessmentPreiliminaryPage.class);

            }


        };
        form.add(next);*/

        Link tillbaka = new AjaxFallbackLink("tillbaka") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                setResponsePage(AssessmentReferalPage.class);

            }


        };
        form.add(tillbaka);


    }
}
