package se.su.dsv.bivsim.pages.Case2.Case2feedbacksection;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.html.link.Link;
import se.su.dsv.bivsim.pages.Case2.Case2feedbacksection.BaseClasses.BaseFeedbackPageCase2;

/**
 * Created by kib on 1/3/15.
 */
public class CategoryInterviewFeedbakPage extends BaseFeedbackPageCase2 {
    public CategoryInterviewFeedbakPage() {


        Link tillbaka = new AjaxFallbackLink("tillbaka") {
            @Override
            public void onClick(AjaxRequestTarget target) {

                setResponsePage(CategoryFeedBackPage.class);
            }
        };
        this.add(tillbaka);

        Link patienten = new AjaxFallbackLink("patienten") {
            @Override
            public void onClick(AjaxRequestTarget target) {

                setResponsePage(VirtualPatientFeedBackPage.class);
            }
        };
        this.add(patienten);


        Link experten = new AjaxFallbackLink("experten") {
            @Override
            public void onClick(AjaxRequestTarget target) {

                setResponsePage(VirtualAdviserFeedBackPage1.class);
            }
        };
        this.add(experten);


    }


}