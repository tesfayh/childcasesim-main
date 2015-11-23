package se.su.dsv.bivsim.pages.CommonAllCases.feedbacksection;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.EmptyPanel;
import org.apache.wicket.request.resource.ResourceReference;
import se.su.dsv.childcasesim.pages.CommonAllCases.SaveLog.SaveLogCase2;
import se.su.dsv.childcasesim.pages.CommonAllCases.SaveLog.SaveLogCase3;
import se.su.dsv.childcasesim.pages.CommonAllCases.General.VideoResourceReference;
import se.su.dsv.childcasesim.pages.CommonAllCases.General.VideoResourceReference2;
import se.su.dsv.childcasesim.pages.CommonAllCases.General.VideoResourceReference3;
import se.su.dsv.childcasesim.pages.CommonAllCases.feedbacksection.BaseClasses.BaseFeedbackPage;
import se.su.dsv.childcasesim.pages.CommonAllCases.General.ChooseCase;
import se.su.dsv.childcasesim.pages.CommonAllCases.SaveLog.SaveLogCase;

/**
 * Created by kib on 3/4/15.
 */
public class CategoryFeedBackPage extends BaseFeedbackPage {
    WebMarkupContainer feedbackContainer1;
    WebMarkupContainer interviewMarkup;
    WebMarkupContainer instrument;
    ResourceReference videoResourceReference;




    public WebMarkupContainer getContentWmc() {

        return feedbackContainer1;
    }

    public CategoryFeedBackPage() {


        feedbackContainer1 = new WebMarkupContainer("feedbackContainer1");
        feedbackContainer1.setOutputMarkupId(true);
        add(feedbackContainer1);
        feedbackContainer1.add(new EmptyPanel("subfeedback"));


        interviewMarkup = new WebMarkupContainer("interviewMarkup");
        interviewMarkup.setOutputMarkupId(true);
        add(interviewMarkup);
        interviewMarkup.add(new EmptyPanel("anamnes"));


        instrument = new WebMarkupContainer("instrumentmarkup");
        instrument.setOutputMarkupId(true);
        add(instrument);

        if((Integer)getSession().getAttribute("feedbackInstrumentcollapse")==1)
            instrument.add(new CategoryFeedbackInstrumentPanel("instrument"));
        else
            instrument.add(new EmptyPanel("instrument"));

        getSession().setAttribute("feedbackInstrumentcollapse", 0); // for collapsing the instrument when we click tillbaka



/*
        add(new Uppföljning("upfoling"));
*/

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

               if((Integer)getSession().getAttribute("case")==1)
                   videoResourceReference=new VideoResourceReference();
               else if((Integer)getSession().getAttribute("case")==2)
                   videoResourceReference=new VideoResourceReference2();
               else if((Integer)getSession().getAttribute("case")==3)
                   videoResourceReference=new VideoResourceReference3();




                interviewMarkup.replace(new CategoryInterviewFeedbakPanel("anamnes", (Integer)getSession().getAttribute("case"), videoResourceReference ));
                target.add((interviewMarkup));

                // to collapse
                instrument.replace(new EmptyPanel("instrument"));
                target.add((instrument));}
        };
        this.add(interview);


        Link Instrument = new AjaxFallbackLink("Instrument") {
            @Override
            public void onClick(AjaxRequestTarget target) {

                instrument.replace(new CategoryFeedbackInstrumentPanel("instrument"));
                target.add((instrument));

                // to collapse
                interviewMarkup.replace(new EmptyPanel("anamnes"));
                target.add((interviewMarkup));

/*
                setResponsePage(CategoryFeedbackInstrumentPage.class);
*/
            }
        };
        this.add(Instrument);

        Link Uppföljning = new AjaxFallbackLink("Uppföljning") {
            @Override
            public void onClick(AjaxRequestTarget target) {
                feedbackContainer1.replace(new Uppföljning("subfeedback"));
                        target.add((feedbackContainer1));

                //to collapse the other links
                interviewMarkup.replace(new EmptyPanel("anamnes"));
                target.add((interviewMarkup));
                instrument.replace(new EmptyPanel("instrument"));
                target.add((instrument));
            }
        };
        this.add(Uppföljning);

        Link PreliminärBedömning = new AjaxFallbackLink("PreliminärBedömning") {
            @Override
            public void onClick(AjaxRequestTarget target) {
                feedbackContainer1.replace(new PreliminärBedömning("subfeedback", (Integer)getSession().getAttribute("case") ));
                target.add((feedbackContainer1));

                //to collapse the other links
                interviewMarkup.replace(new EmptyPanel("anamnes"));
                target.add((interviewMarkup));
                instrument.replace(new EmptyPanel("instrument"));
                target.add((instrument));


            }
        };
        this.add(PreliminärBedömning);


        // save log module


        if((Integer)getSession().getAttribute("case")==1){
            new SaveLogCase("Case1log");
        }


        else if((Integer)getSession().getAttribute("case")==2){
            new SaveLogCase2("Case2log");

        }


        else if((Integer)getSession().getAttribute("case")==3){
            new SaveLogCase3("Case3log");

        }




    }
}
