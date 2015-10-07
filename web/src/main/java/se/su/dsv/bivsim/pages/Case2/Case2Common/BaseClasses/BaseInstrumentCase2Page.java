package se.su.dsv.bivsim.pages.Case2.Case2Common.BaseClasses;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import se.su.dsv.bivsim.pages.Case2.Case2Common.HomeCase2Labs;
import se.su.dsv.bivsim.pages.Case2.Case2Common.HomeCase2Page;
import se.su.dsv.bivsim.pages.Case2.Case2assessment.AssessmentReferalPageCase2;
import se.su.dsv.bivsim.pages.Case2.Case2feedbacksection.CategoryFeedBackPage;
import se.su.dsv.bivsim.pages.Case2.Case2Screeninginstruments.*;
import se.su.dsv.bivsim.pages.CommonAllCases.ChooseCase;
import se.su.dsv.bivsim.pages.CommonAllCases.SignOut;

/**
 * Created by kib on 12/1/14.
 */
public class BaseInstrumentCase2Page extends WebPage {
    WebMarkupContainer instrument;

    public WebMarkupContainer getContentW() {

        return instrument;
    }

    int panelindex = 0;

    public BaseInstrumentCase2Page(final PageParameters parameters) {


        Link signOut = new AjaxFallbackLink("signOut") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                setResponsePage(SignOut.class);

            }


        };
        add(signOut);
        signOut.add(new Label("username", getSession().getAttribute("username").toString()));
        instrument = new WebMarkupContainer("instrumentmarkup");
        instrument.setOutputMarkupId(true);
        add(instrument);

        panelindex = parameters.get("A").toInt();


        if (panelindex == 2)
            instrument.add(new PHQ9Panel("instrument"));
        else if (panelindex == 3)
            instrument.add(new IESRPanel("instrument"));
        else if (panelindex == 4)
            instrument.add(new AUDITPanel("instrument"));
        else if (panelindex == 5)
            instrument.add(new PTSDPanel("instrument"));
        else if (panelindex == 6)
            instrument.add(new DUDITPanel("instrument"));
        else if (panelindex == 7)
            instrument.add(new MADRSPanel("instrument"));
        else if (panelindex == 8)
            instrument.add(new ASRSPanel("instrument"));
        else if(panelindex==9)
            instrument.add(new PTSDPanel("instrument"));


        Link Choose = new AjaxFallbackLink("choose") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                setResponsePage(ChooseCase.class);

            }


        };
        add(Choose);

        Link mainpage = new AjaxFallbackLink("mainpage") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                setResponsePage(HomeCase2Page.class);

            }


        };
        add(mainpage);

        Link info = new AjaxFallbackLink("info") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                setResponsePage(InfoCase2Page.class);

            }


        };
        add(info);
        Link exam = new AjaxFallbackLink("exam") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                setResponsePage(HomeCase2Page.class);

            }


        };
        add(exam);
        Link lab = new AjaxFallbackLink("lab") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                setResponsePage(HomeCase2Labs.class);

            }


        };
        add(lab);
        Link instrument = new AjaxFallbackLink("instrument") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                setResponsePage(InstrumentCase2ListPage.class);

            }


        };
        add(instrument);

        Link Bedömning = new AjaxFallbackLink("Bedömning") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                setResponsePage(AssessmentReferalPageCase2.class);

            }


        };
        add(Bedömning);

        Link Återkoppling = new AjaxFallbackLink("Återkoppling") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                setResponsePage(CategoryFeedBackPage.class);

            }


        };
        add(Återkoppling);


        // links for the main page


    }


   /* public BaseInstrumentPage(IModel model) {
        super(model);

    }*/

    @Override
    public void renderHead(IHeaderResponse response) {
        // response.render(CssHeaderItem.forReference(new CssResourceReference(HomePage.class,
        //  "css/bootstrap.css")));
        // response.render(CssHeaderItem.forReference(new CssResourceReference(HomePage.class,
        //   "css/bootstrap-responsive.css")));
        // response.render(CssHeaderItem.forReference(new CssResourceReference(HomePage.class,
        //   "css/style.css")));


    }


}
