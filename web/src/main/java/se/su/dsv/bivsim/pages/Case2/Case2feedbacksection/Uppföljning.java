package se.su.dsv.bivsim.pages.Case2.Case2feedbacksection;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import se.su.dsv.bivsim.pages.Case2.Case2feedbacksection.BaseClasses.BaseFeedbackPageCase2;

/**
 * Created by kib on 3/9/15.
 */
public class Uppföljning extends BaseFeedbackPageCase2 {
    public Uppföljning() {

        if ((Integer) getSession().getAttribute("followupvalue") == 1)
            add(new Label("follow", "Du planerat ett uppföljningsbesök."));
        else
            add(new Label("follow", " Inget uppföljningsbesök planeras"));

        if (getSession().getAttribute("referralValue") != null) {
            add(new Label("Referral", "Du skickade en remiss till en " + getSession().getAttribute("referral")));
        } else
            add(new Label("Referral", " Ingen remiss"));

        add(new Label("follupfromdbline1", "Uppföljning rekommenderas"));
        add(new Label("follupfromdbline2", "Remiss rekommenderas ej"));

        Link nextfeedbak = new AjaxFallbackLink("back") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                setResponsePage(CategoryFeedBackPage.class);

            }
        };
        this.add(nextfeedbak);

    }
}
