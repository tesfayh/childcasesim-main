package se.su.dsv.bivsim.pages.CommonAllCases.feedbacksection;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;


/**
 * Created by kib on 3/9/15.
 */
public class Uppföljning extends Panel {
    public Uppföljning( String id) {
        super(id);

        if ((Integer) getSession().getAttribute("followupvalue") == 1)
            add(new Label("follow", "Du planerade ett uppföljningsbesök"));
        else
            add(new Label("follow", " Inget uppföljningsbesök planeras"));

        if (getSession().getAttribute("referralValue").equals("")) {
            add(new Label("referralValue", " Ingen remiss"));
        } else
            add(new Label("referralValue", "Du skickade en remiss till en " + getSession().getAttribute("referralValue")));

        add(new Label("follupfromdbline1", "Uppföljning rekommenderas"));
        add(new Label("follupfromdbline2", "Remiss rekommenderas ej"));

//        Link nextfeedbak = new AjaxFallbackLink("back") {
//
//            @Override
//            public void onClick(AjaxRequestTarget target) {
//
//                setResponsePage(CategoryFeedBackPage.class);
//
//            }
//        };
//        this.add(nextfeedbak);

    }
}
