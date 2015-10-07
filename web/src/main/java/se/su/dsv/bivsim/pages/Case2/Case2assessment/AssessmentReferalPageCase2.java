package se.su.dsv.bivsim.pages.Case2.Case2assessment;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.extensions.markup.html.form.DateTextField;
import org.apache.wicket.extensions.yui.calendar.DatePicker;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import se.su.dsv.bivsim.pages.Case2.Case2assessment.BaseClasses.BaseAssesmentPageCase2;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class AssessmentReferalPageCase2 extends BaseAssesmentPageCase2 {
    public Date date;
    private String selected = "Sjuksköterka";
    private static final List<String> countries = Arrays.asList(new String[]{
            "Psykiatriker", "Sjukgymnast", "Psykoterapeut", "Dietist", "Psykolog", "Arbetsterapeut", "Kurator", "Annan"});

    public AssessmentReferalPageCase2() {
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

                getSession().setAttribute("referral", selected);
                getSession().setAttribute("referralValue", "dksf"); //to change only the value from null to some value


            }


        };
        this.add(form);
        form.add(listprofesstions);
        form.add(Anledning);
        form.add(Diagnos);
        form.add(Historia);
        form.add(dateTextField);


        Link next = new AjaxFallbackLink("next") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                setResponsePage(AssessmentPreiliminaryPageCase2.class);

            }


        };
        form.add(next);

        Link tillbaka = new AjaxFallbackLink("tillbaka") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                setResponsePage(AssessmentReferalPageCase2.class);

            }


        };
        form.add(tillbaka);


    }
}
