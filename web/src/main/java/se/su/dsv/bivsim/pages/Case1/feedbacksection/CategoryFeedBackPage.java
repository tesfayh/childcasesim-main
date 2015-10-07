package se.su.dsv.bivsim.pages.Case1.feedbacksection;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.html.link.Link;
import se.su.dsv.bivsim.pages.Case1.feedbacksection.BaseClasses.BaseFeedbackPage;
import se.su.dsv.bivsim.pages.CommonAllCases.ChooseCase;
import se.su.dsv.bivsim.pages.CommonAllCases.SaveLog.SaveLogCase;

/**
 * Created by kib on 3/4/15.
 */
public class CategoryFeedBackPage extends BaseFeedbackPage {

    public CategoryFeedBackPage() {


        Link nextfeedbak = new AjaxFallbackLink("Finish") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                setResponsePage(ChooseCase.class);

            }
        };
        this.add(nextfeedbak);
        Link interview = new AjaxFallbackLink("interview") {
            @Override
            public void onClick(AjaxRequestTarget target) {

                setResponsePage(CategoryInterviewFeedbakPage.class);
            }
        };
        this.add(interview);


        Link Instrument = new AjaxFallbackLink("Instrument") {
            @Override
            public void onClick(AjaxRequestTarget target) {

                setResponsePage(CategoryFeedbackInstrumentPage.class);
            }
        };
        this.add(Instrument);

        Link Uppföljning = new AjaxFallbackLink("Uppföljning") {
            @Override
            public void onClick(AjaxRequestTarget target) {

                setResponsePage(Uppföljning.class);
            }
        };
        this.add(Uppföljning);

        Link PreliminärBedömning = new AjaxFallbackLink("PreliminärBedömning") {
            @Override
            public void onClick(AjaxRequestTarget target) {

                setResponsePage(PreliminärBedömning.class);
            }
        };
        this.add(PreliminärBedömning);


        // save log module
        new SaveLogCase("Case1log");



    }
}
