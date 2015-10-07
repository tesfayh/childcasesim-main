package se.su.dsv.bivsim.pages.Case1.feedbacksection.BaseClasses;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import se.su.dsv.bivsim.pages.Case1.CommonCase1.*;
import se.su.dsv.bivsim.pages.Case1.CommonCase1.BaseClasses.InfoPage;
import se.su.dsv.bivsim.pages.Case1.CommonCase1.BaseClasses.InstrumentListPage;
import se.su.dsv.bivsim.pages.Case1.assessment.AssessmentReferalPage;
import se.su.dsv.bivsim.pages.Case1.feedbacksection.CategoryFeedBackPage;
import se.su.dsv.bivsim.pages.CommonAllCases.*;

/**
 * Created by kib on 2/15/15.
 */
public class BaseFeedbackPage extends WebPage {
    public BaseFeedbackPage() {


        Link signOut = new AjaxFallbackLink("signOut") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                setResponsePage(SignOut.class);

            }


        };
        add(signOut);
        signOut.add(new Label("username", getSession().getAttribute("username").toString()));

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

                setResponsePage(HomePage.class);

            }


        };
        add(mainpage);

        Link info = new AjaxFallbackLink("info") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                setResponsePage(InfoPage.class);

            }


        };
        add(info);
        Link exam = new AjaxFallbackLink("exam") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                setResponsePage(HomePagephysical.class);

            }


        };
        add(exam);
        Link instrument = new AjaxFallbackLink("instrument") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                setResponsePage(InstrumentListPage.class);

            }
        };
        add(instrument);

        Link lab = new AjaxFallbackLink("lab") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                setResponsePage(HomeLabs.class);

            }

        };
        add(lab);

        Link Bedömning = new AjaxFallbackLink("Bedömning") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                setResponsePage(AssessmentReferalPage.class);

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




    }
}
