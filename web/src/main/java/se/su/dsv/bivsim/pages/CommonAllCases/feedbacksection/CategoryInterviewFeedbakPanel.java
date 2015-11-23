package se.su.dsv.bivsim.pages.CommonAllCases.feedbacksection;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.request.resource.ResourceReference;

public class CategoryInterviewFeedbakPanel extends Panel {
    public CategoryInterviewFeedbakPanel(String id, final Integer groupId, final ResourceReference videoResourceReference) {
        super(id);


        Link patienten = new AjaxFallbackLink("patienten") {
            @Override
            public void onClick(AjaxRequestTarget target) {

                ((CategoryFeedBackPage)getPage()).getContentWmc().replace(new VirtualPatientFeedBackPanel("subfeedback",groupId, videoResourceReference ));
                target.add(((CategoryFeedBackPage) getPage()).getContentWmc());

            }
        };
        this.add(patienten);


        Link experten = new AjaxFallbackLink("experten") {
            @Override
            public void onClick(AjaxRequestTarget target) {

                ((CategoryFeedBackPage)getPage()).getContentWmc().replace(new VirtualAdviserFeedBackPanel("subfeedback", groupId));
                target.add(((CategoryFeedBackPage) getPage()).getContentWmc());
            }
        };
        this.add(experten);


    }


}