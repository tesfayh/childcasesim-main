package se.su.dsv.bivsim.pages.Case3.Case3Common.BaseClasses;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import se.su.dsv.bivsim.pages.Case3.Case3Common.*;
import se.su.dsv.bivsim.pages.Case3.Case3assessment.AssessmentReferalCase3Page;
import se.su.dsv.bivsim.pages.Case3.Case3feedbacksection.CategoryFeedBackPage;
import se.su.dsv.bivsim.pages.CommonAllCases.ChooseCase;
import se.su.dsv.bivsim.pages.CommonAllCases.Edit.BaseClasses.CommonEditingPage;
import se.su.dsv.bivsim.pages.CommonAllCases.SignOut;

/**
 * Created by kib on 12/1/14.
 */
public class InfoCase3Page extends WebPage {
    WebMarkupContainer downloadContainer;

    public InfoCase3Page() {

        downloadContainer = new WebMarkupContainer("Questions");
        downloadContainer.setOutputMarkupId(true);
        add(downloadContainer);
        downloadContainer.add(new AhmedTextPanel("mainNavigation2"));

        Link signOut = new AjaxFallbackLink("signOut") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                setResponsePage(SignOut.class);

            }


        };
        add(signOut);
        signOut.add(new Label("username", getSession().getAttribute("username").toString()));

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

                setResponsePage(HomeCase3Page.class);

            }


        };
        add(mainpage);

        Link info = new AjaxFallbackLink("info") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                setResponsePage(InfoCase3Page.class);

            }


        };
        add(info);
        Link exam = new AjaxFallbackLink("exam") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                setResponsePage(HomeCase3Pagephysical.class);

            }


        };
        add(exam);

        Link instrument = new AjaxFallbackLink("instrument") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                setResponsePage(InstrumentCase3ListPage.class);

            }


        };
        add(instrument);
        Link lab = new AjaxFallbackLink("lab") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                setResponsePage(HomeCase3Labs.class);

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

                setResponsePage(AssessmentReferalCase3Page.class);

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

                downloadContainer.replace(new JournalPanel("mainNavigation2"));
                target.add(downloadContainer);


            }


        };
        add(Journal);

        Link Lagar = new AjaxFallbackLink("Lagar") {

            @Override
            public void onClick(AjaxRequestTarget target) {
                downloadContainer.replace(new FaktaPanel("mainNavigation2"));
                target.add(downloadContainer);


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
