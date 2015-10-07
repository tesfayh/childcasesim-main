package se.su.dsv.bivsim.pages.Case2.Case2feedbacksection;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import se.su.dsv.bivsim.pages.Case2.Case2feedbacksection.BaseClasses.BaseFeedbackPageCase2;

/**
 * Created by kib on 12/1/14.
 */
public class CategoryFeedbackInstrumentPage extends BaseFeedbackPageCase2 {

    int panelnumber;
    PageParameters pageParameters;

    public CategoryFeedbackInstrumentPage() {

        pageParameters = new PageParameters();


        Link PHQ9 = new AjaxFallbackLink("PHQ9") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                panelnumber = 1;
                pageParameters.set("A", panelnumber);
                setResponsePage(FeedbackInstrumentPage.class, pageParameters);
            }


        };
        add(PHQ9);


        Link IES = new AjaxFallbackLink("IES-R") {

            @Override
            public void onClick(AjaxRequestTarget target) {

               panelnumber =5;
                pageParameters.set("A", panelnumber);
                setResponsePage(FeedbackInstrumentPage.class, pageParameters);

            }


        };
        add(IES);


        Link PTSD = new AjaxFallbackLink("PTSD") {

            @Override
            public void onClick(AjaxRequestTarget target) {

               panelnumber =8;
                pageParameters.set("A", panelnumber);
                setResponsePage(FeedbackInstrumentPage.class, pageParameters);
            }


        };
        add(PTSD);

        Link AUDIT = new AjaxFallbackLink("AUDIT") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                panelnumber = 2;
                pageParameters.set("A", panelnumber);
                setResponsePage(FeedbackInstrumentPage.class, pageParameters);
            }


        };
        add(AUDIT);

        Link DUDIT = new AjaxFallbackLink("DUDIT") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                panelnumber = 3;
                pageParameters.set("A", panelnumber);
                setResponsePage(FeedbackInstrumentPage.class, pageParameters);

            }


        };
        add(DUDIT);

        Link MADRAS = new AjaxFallbackLink("MADRAS") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                panelnumber =7;
                pageParameters.set("A", panelnumber);
                setResponsePage(FeedbackInstrumentPage.class, pageParameters);

            }


        };
        add(MADRAS);


        Link ASRS = new AjaxFallbackLink("ASRS") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                panelnumber = 4;
                pageParameters.set("A", panelnumber);
                setResponsePage(FeedbackInstrumentPage.class, pageParameters);

            }


        };
        add(ASRS);


        Link Social = new AjaxFallbackLink("Social") {

            @Override
            public void onClick(AjaxRequestTarget target) {


            }


        };
        add(Social);

        Link nextfeedbak = new AjaxFallbackLink("back") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                setResponsePage(CategoryFeedBackPage.class);

            }
        };
        this.add(nextfeedbak);


    }



}
