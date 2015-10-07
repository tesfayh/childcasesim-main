package se.su.dsv.bivsim.pages.Case2.Case2feedbacksection;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import se.su.dsv.bivsim.pages.Case2.Case2feedbacksection.BaseClasses.BaseFeedbackPageCase2;

/**
 * Created with IntelliJ IDEA.
 * User: kebede
 * Date: 28/06/13
 * Time: 11:10
 * To change this template use File | Settings | File Templates.
 */
public class VirtualAdviserFeedBackPage2 extends BaseFeedbackPageCase2 {
    public VirtualAdviserFeedBackPage2() {

        VirtualAdviserFeedBackPage1 v = new VirtualAdviserFeedBackPage1();



        String Funktion = "";
        if ((Integer) getSession().getAttribute("exFunktionsnivå") != null) {

            if ((Integer) getSession().getAttribute("exFunktionsnivå") >= 2)
                Funktion = Funktion + v.adviser_feedback_selected[4] + " ";
            if ((Integer) getSession().getAttribute("exFunktionsnivå") < 1)
                Funktion = Funktion + v.adviser_feedback_selected[15] + " ";
        }

        if ((Integer) getSession().getAttribute("exBarn") != null) {
            if ((Integer) getSession().getAttribute("exBarn") >= 5)
                Funktion = Funktion + v.adviser_feedback_selected[5] + " ";
            if ((Integer) getSession().getAttribute("exBarn") < 3)
                Funktion = Funktion + v.adviser_feedback_selected[16] + " ";
        }
        add(new Label("Funktion", Funktion));

        String Motivation = "";
        if ((Integer) getSession().getAttribute("exMotivation") != null) {

            if ((Integer) getSession().getAttribute("exMotivation") >= 0)
                Motivation = Motivation + v.adviser_feedback_selected[6] + " ";
            if ((Integer) getSession().getAttribute("exMotivation") < 0)
                Motivation = Motivation + v.adviser_feedback_selected[17] + " ";
        }
        add(new Label("Motivation", Motivation));


        String Antalfrågor = "";
        if ((Integer) getSession().getAttribute("Antalfrågor") != null) {

            if ((Integer) getSession().getAttribute("Antalfrågor") < 45)
                Antalfrågor = Antalfrågor + v.adviser_feedback_selected[7] + " ";
            if ((Integer) getSession().getAttribute("Antalfrågor") > 45)
                Antalfrågor = Antalfrågor + v.adviser_feedback_selected[18] + " ";
        }
        add(new Label("Antalfrågor", Antalfrågor));


        Link tillbaka = new AjaxFallbackLink("tillbaka") {
            @Override
            public void onClick(AjaxRequestTarget target) {

                setResponsePage(VirtualAdviserFeedBackPage1.class);
            }
        };
        this.add(tillbaka);


        Link next = new AjaxFallbackLink("next") {
            @Override
            public void onClick(AjaxRequestTarget target) {

                setResponsePage(VirtualAdviserFeedBackPage3.class);
            }
        };
        this.add(next);

    }
}
