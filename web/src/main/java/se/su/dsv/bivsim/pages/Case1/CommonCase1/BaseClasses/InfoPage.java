package se.su.dsv.bivsim.pages.Case1.CommonCase1.BaseClasses;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.EmptyPanel;
import se.su.dsv.childcasesim.pages.Case1.CommonCase1.*;
import se.su.dsv.childcasesim.pages.CommonAllCases.assessment.AssessmentReferalPage;
import se.su.dsv.childcasesim.pages.CommonAllCases.feedbacksection.CategoryFeedBackPage;
import se.su.dsv.childcasesim.pages.CommonAllCases.screeninginstruments.InstrumentListPage;
import se.su.dsv.childcasesim.pages.CommonAllCases.General.ChooseCase;
import se.su.dsv.childcasesim.pages.CommonAllCases.Edit.BaseClasses.CommonEditingPage;
import se.su.dsv.childcasesim.pages.CommonAllCases.General.SignOut;

/**
 * Created by kib on 12/1/14.
 */
public class InfoPage extends WebPage {
    WebMarkupContainer downloadContainer1;
    WebMarkupContainer downloadContainer2;


    public InfoPage() {

        downloadContainer1 = new WebMarkupContainer("Questions1");
        downloadContainer1.setOutputMarkupId(true);
        add(downloadContainer1);
        downloadContainer1.add(new EmptyPanel("mainNavigation1"));

        downloadContainer2 = new WebMarkupContainer("Questions2");
        downloadContainer2.setOutputMarkupId(true);
        add(downloadContainer2);
        downloadContainer2.add(new EmptyPanel("mainNavigation2"));
        add(new PaticnetPictuerPanel("content"));

        Link signOut = new AjaxFallbackLink("signOut") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                setResponsePage(SignOut.class);

            }


        };
        add(signOut);
        add(new Label("username", "Inloggad:" + getSession().getAttribute("username").toString()));

        //Variables  for patient feedback

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

      /*  Link assessmentReferal = new AjaxFallbackLink("Assreferal") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                setResponsePage(AssessmentReferalPage.class);

            }


        };
        add(assessmentReferal);*/
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


        Link Journal = new AjaxFallbackLink("Journal") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                downloadContainer1.replace(new JournalPanel("mainNavigation1"));
                target.add(downloadContainer1);


                //disabling
                downloadContainer2.replace(new EmptyPanel("mainNavigation2"));
                target.add(downloadContainer2);


            }


        };
        add(Journal);

        Link Lagar = new AjaxFallbackLink("Lagar") {

            @Override
            public void onClick(AjaxRequestTarget target) {
                downloadContainer2.replace(new FaktaPanel("mainNavigation2"));
                target.add(downloadContainer2);

                // diabling
                downloadContainer1.replace(new EmptyPanel("mainNavigation1"));
                target.add(downloadContainer1);


            }

        };
        add(Lagar);

        Link admin = new AjaxFallbackLink("admin") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                setResponsePage(CommonEditingPage.class);

            }


        };
        add(admin);

    }

}
