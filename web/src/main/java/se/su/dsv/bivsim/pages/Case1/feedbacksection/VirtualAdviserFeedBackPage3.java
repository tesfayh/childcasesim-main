package se.su.dsv.bivsim.pages.Case1.feedbacksection;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import se.su.dsv.bivsim.pages.Case1.feedbacksection.BaseClasses.BaseFeedbackPage;

public class VirtualAdviserFeedBackPage3 extends BaseFeedbackPage {
    public VirtualAdviserFeedBackPage3() {
        VirtualAdviserFeedBackPage1 v = new VirtualAdviserFeedBackPage1();


        String Fysiskundersökning = "";
        if ((Integer) getSession().getAttribute("exPhysical") != null) {

            if ((Integer) getSession().getAttribute("exPhysical") >= 2)
                Fysiskundersökning = Fysiskundersökning + v.adviser_feedback_selected[8] + " ";
            if ((Integer) getSession().getAttribute("exPhysical") < 1)
                Fysiskundersökning = Fysiskundersökning + v.adviser_feedback_selected[19] + " ";
        }

        add(new Label("Fysiskundersökning", Fysiskundersökning));

        String Lab = "";
        if ((Integer) getSession().getAttribute("exLab") != null) {
            if ((Integer) getSession().getAttribute("exLab") < 1)
                Lab = Lab + v.adviser_feedback_selected[9] + " ";
            if ((Integer) getSession().getAttribute("exLab") >= 1)
                Lab = Lab + v.adviser_feedback_selected[20] + " ";
        }
        add(new Label("Lab", Lab));

        System.out.println(Lab);


        String Instrument = "";
        if ((Integer) getSession().getAttribute("exInstrument") != null) {
            if ((Integer) getSession().getAttribute("exInstrument") >= 0)
                Instrument = Instrument + v.adviser_feedback_selected[10] + " ";
            if ((Integer) getSession().getAttribute("exInstrument") < 0)
                Instrument = Instrument + v.adviser_feedback_selected[21] + " ";
        }
        add(new Label("Instrument", Instrument));


        Link tillbaka = new AjaxFallbackLink("tillbaka") {
            @Override
            public void onClick(AjaxRequestTarget target) {

                setResponsePage(VirtualAdviserFeedBackPage2.class);
            }
        };
        this.add(tillbaka);

        Link tillbaka2 = new AjaxFallbackLink("tillbaka2") {
            @Override
            public void onClick(AjaxRequestTarget target) {

                ;
                setResponsePage(CategoryInterviewFeedbakPage.class);
            }
        };
        this.add(tillbaka2);


    }
}
