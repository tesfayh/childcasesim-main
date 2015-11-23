package se.su.dsv.bivsim.pages.Case1.CommonCase1.BaseClasses;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.ajax.markup.html.form.AjaxSubmitLink;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.EmptyPanel;
import org.apache.wicket.model.Model;
import se.su.dsv.childcasesim.pages.Case1.CommonCase1.*;
import se.su.dsv.childcasesim.pages.CommonAllCases.assessment.AssessmentReferalPage;
import se.su.dsv.childcasesim.pages.CommonAllCases.feedbacksection.CategoryFeedBackPage;
import se.su.dsv.childcasesim.pages.Case1.interview.InterviewTreePanel;
import se.su.dsv.childcasesim.pages.Case1.interview.SearchInterveiwTreePanel;
import se.su.dsv.childcasesim.pages.CommonAllCases.screeninginstruments.InstrumentListPage;
import se.su.dsv.childcasesim.pages.CommonAllCases.General.ChooseCase;
import se.su.dsv.childcasesim.pages.CommonAllCases.General.SignOut;

public class BasePage extends WebPage {
//
//    WebMarkupContainer pictureContainer1;
//    public WebMarkupContainer getContentWmc() {
//
//        return pictureContainer1;
//    }



    WebMarkupContainer SearchContainer1;
    WebMarkupContainer MainNavigationContainer;
    WebMarkupContainer VideoContainer;

//left menu

    WebMarkupContainer QuestionContainer1;
    WebMarkupContainer QuestionContainer2;
    WebMarkupContainer QuestionContainer3;
    WebMarkupContainer QuestionContainer4;
    WebMarkupContainer QuestionContainer5;
    WebMarkupContainer QuestionContainer6;
    WebMarkupContainer QuestionContainer7;
    WebMarkupContainer QuestionContainer8;






    public WebMarkupContainer getContentSearch() {

        return SearchContainer1;
    }


    public WebMarkupContainer getContentMainNavigation() {

        return MainNavigationContainer;
    }

    public WebMarkupContainer getContentVideoContainer() {

        return VideoContainer;
    }



    public BasePage() {


     /*   VideoContainer=new WebMarkupContainer("VideoContainer");
        VideoContainer.setOutputMarkupId(true);
        add(VideoContainer);
        VideoContainer.add(new VideoPanel("SubVideo", "1.1"));*/



        QuestionContainer1 = new WebMarkupContainer("QuestionContainer1");
        QuestionContainer2 = new WebMarkupContainer("QuestionContainer2");
        QuestionContainer3 = new WebMarkupContainer("QuestionContainer3");
        QuestionContainer4 = new WebMarkupContainer("QuestionContainer4");
        QuestionContainer5 = new WebMarkupContainer("QuestionContainer5");
        QuestionContainer6 = new WebMarkupContainer("QuestionContainer6");
        QuestionContainer7 = new WebMarkupContainer("QuestionContainer7");
        QuestionContainer8 = new WebMarkupContainer("QuestionContainer8");


        QuestionContainer1.setOutputMarkupId(true);
        QuestionContainer2.setOutputMarkupId(true);
        QuestionContainer3.setOutputMarkupId(true);
        QuestionContainer4.setOutputMarkupId(true);
        QuestionContainer5.setOutputMarkupId(true);
        QuestionContainer6.setOutputMarkupId(true);
        QuestionContainer7.setOutputMarkupId(true);
        QuestionContainer8.setOutputMarkupId(true);


        add(QuestionContainer1);
        add(QuestionContainer2);
        add(QuestionContainer3);
        add(QuestionContainer4);
        add(QuestionContainer5);
        add(QuestionContainer6);
        add(QuestionContainer7);
        add(QuestionContainer8);


        QuestionContainer1.add(new EmptyPanel("subQuestion1"));
        QuestionContainer2.add(new EmptyPanel("subQuestion2"));
        QuestionContainer3.add(new EmptyPanel("subQuestion3"));
        QuestionContainer4.add(new EmptyPanel("subQuestion4"));
        QuestionContainer5.add(new EmptyPanel("subQuestion5"));
        QuestionContainer6.add(new EmptyPanel("subQuestion6"));
        QuestionContainer7.add(new EmptyPanel("subQuestion7"));
        QuestionContainer8.add(new EmptyPanel("subQuestion8"));

        SearchContainer1=new WebMarkupContainer("SearchContainer1");
        SearchContainer1.setOutputMarkupId(true);
        add(SearchContainer1);
        SearchContainer1.add(new EmptyPanel("subSearch"));

/*

        MainNavigationContainer=new WebMarkupContainer("MainNavigationContainer");
        MainNavigationContainer.setOutputMarkupId(true);
        add(MainNavigationContainer);
        MainNavigationContainer.add(new HeaderPanel("mainNavigation"));
*/






/*
        this.add(new HeaderPanel("mainNavigation"));
*/

        Link signOut = new AjaxFallbackLink("signOut") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                setResponsePage(SignOut.class);

            }


        };
        add(signOut);
        add(new Label("username", "Inloggad:" + getSession().getAttribute("username").toString()));



        final TextField searchtxt = new TextField("searchtxt", new Model(""));

      /* Link search = new AjaxFallbackLink("search") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                ((BasePage) getPage()).getContentW().replace(new SearchInterveiwTreePanel("mainNavigation2", searchtxt.getModel().getObject().toString()));
                target.add(((BasePage) getPage()).getContentW());
            }




        };
*/

       AjaxSubmitLink addLink = new AjaxSubmitLink("link") {

            protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
                if (searchtxt.getModel().getObject() != null) {
                    SearchContainer1.replace(new SearchInterveiwTreePanel("subSearch", searchtxt.getModel().getObject().toString()));
                    target.add(SearchContainer1);

                    // to collapse all navigation menus when the Search button is clicked.
                    QuestionContainer1.replace(new EmptyPanel("subQuestion1"));
                    target.add((QuestionContainer1));
                    QuestionContainer2.replace(new EmptyPanel("subQuestion2"));
                    target.add((QuestionContainer2));
                    QuestionContainer3.replace(new EmptyPanel("subQuestion3"));
                    target.add((QuestionContainer3));
                    QuestionContainer4.replace(new EmptyPanel("subQuestion4"));
                    target.add((QuestionContainer4));
                    QuestionContainer5.replace(new EmptyPanel("subQuestion5"));
                    target.add((QuestionContainer5));
                    QuestionContainer6.replace(new EmptyPanel("subQuestion6"));
                    target.add((QuestionContainer6));
                    QuestionContainer7.replace(new EmptyPanel("subQuestion7"));
                    target.add((QuestionContainer7));
                    QuestionContainer8.replace(new EmptyPanel("subQuestion8"));
                    target.add((QuestionContainer8));

                }



            }
        };

        Form<?> form = new Form("searchForm") {
            @Override
            public void onSubmit() {


            }

        };
        add(form);
        searchtxt.add(addLink);
        form.add(searchtxt);
/*
        form.add(addLink);
*/
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


        Link Interview = new AjaxFallbackLink("Introduction") {
            @Override
            public void onClick(AjaxRequestTarget target) {
                QuestionContainer1.replace(new InterviewTreePanel("subQuestion1", 1));
                target.add((QuestionContainer1));

                //Setting to empty panel
                QuestionContainer2.replace(new EmptyPanel("subQuestion2"));
                target.add((QuestionContainer2));
                QuestionContainer3.replace(new EmptyPanel("subQuestion3"));
                target.add((QuestionContainer3));
                QuestionContainer4.replace(new EmptyPanel("subQuestion4"));
                target.add((QuestionContainer4));
                QuestionContainer5.replace(new EmptyPanel("subQuestion5"));
                target.add((QuestionContainer5));
                QuestionContainer6.replace(new EmptyPanel("subQuestion6"));
                target.add((QuestionContainer6));
                QuestionContainer7.replace(new EmptyPanel("subQuestion7"));
                target.add((QuestionContainer7));
                QuestionContainer8.replace(new EmptyPanel("subQuestion8"));
                target.add((QuestionContainer8));

                //seting the search panel empty, incase it was full of search texts

                ((BasePage) getPage()).getContentSearch().replace(new EmptyPanel("subSearch"));
                target.add(((BasePage) getPage()).getContentSearch());

            }
        };
        this.add(Interview);

        Link physicalExam = new AjaxFallbackLink("Aktuellt") {

            @Override
            public void onClick(AjaxRequestTarget target) {


                QuestionContainer2.replace(new InterviewTreePanel("subQuestion2", 2));
                target.add((QuestionContainer2));

                //Setting to empty panel
                QuestionContainer1.replace(new EmptyPanel("subQuestion1"));
                target.add((QuestionContainer1));
                QuestionContainer3.replace(new EmptyPanel("subQuestion3"));
                target.add((QuestionContainer3));
                QuestionContainer4.replace(new EmptyPanel("subQuestion4"));
                target.add((QuestionContainer4));
                QuestionContainer5.replace(new EmptyPanel("subQuestion5"));
                target.add((QuestionContainer5));
                QuestionContainer6.replace(new EmptyPanel("subQuestion6"));
                target.add((QuestionContainer6));
                QuestionContainer7.replace(new EmptyPanel("subQuestion7"));
                target.add((QuestionContainer7));
                QuestionContainer8.replace(new EmptyPanel("subQuestion8"));
                target.add((QuestionContainer8));

                //seting the search panel empty, in-case it was full of search texts

                ((BasePage) getPage()).getContentSearch().replace(new EmptyPanel("subSearch"));
                target.add(((BasePage) getPage()).getContentSearch());

            }

        };
        this.add(physicalExam);

        Link labsImaging = new AjaxFallbackLink("Tidigare") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                QuestionContainer3.replace(new InterviewTreePanel("subQuestion3", 3));
                target.add((QuestionContainer3));

                // setting to empty panel
                QuestionContainer1.replace(new EmptyPanel("subQuestion1"));
                target.add((QuestionContainer1));
                QuestionContainer2.replace(new EmptyPanel("subQuestion2"));
                target.add((QuestionContainer2));
                QuestionContainer4.replace(new EmptyPanel("subQuestion4"));
                target.add((QuestionContainer4));
                QuestionContainer5.replace(new EmptyPanel("subQuestion5"));
                target.add((QuestionContainer5));
                QuestionContainer6.replace(new EmptyPanel("subQuestion6"));
                target.add((QuestionContainer6));
                QuestionContainer7.replace(new EmptyPanel("subQuestion7"));
                target.add((QuestionContainer7));
                QuestionContainer8.replace(new EmptyPanel("subQuestion8"));
                target.add((QuestionContainer8));

                //setting the search panel empty, in case it was full of search texts

                ((BasePage) getPage()).getContentSearch().replace(new EmptyPanel("subSearch"));
                target.add(((BasePage) getPage()).getContentSearch());


            }
        };
        this.add(labsImaging);

        Link screeingInstruments = new AjaxFallbackLink("Socialt") {

            @Override
            public void onClick(AjaxRequestTarget target) {
                QuestionContainer4.replace(new InterviewTreePanel("subQuestion4", 4));
                target.add((QuestionContainer4));

                // setting to empty panel
                QuestionContainer1.replace(new EmptyPanel("subQuestion1"));
                target.add((QuestionContainer1));
                QuestionContainer2.replace(new EmptyPanel("subQuestion2"));
                target.add((QuestionContainer2));
                QuestionContainer3.replace(new EmptyPanel("subQuestion3"));
                target.add((QuestionContainer3));
                QuestionContainer5.replace(new EmptyPanel("subQuestion5"));
                target.add((QuestionContainer5));
                QuestionContainer6.replace(new EmptyPanel("subQuestion6"));
                target.add((QuestionContainer6));
                QuestionContainer7.replace(new EmptyPanel("subQuestion7"));
                target.add((QuestionContainer7));
                QuestionContainer8.replace(new EmptyPanel("subQuestion8"));
                target.add((QuestionContainer8));

                //setting the search panel empty, in case it was full of search texts

                ((BasePage) getPage()).getContentSearch().replace(new EmptyPanel("subSearch"));
                target.add(((BasePage) getPage()).getContentSearch());

            }
        };
        this.add(screeingInstruments);

        Link Hereditet = new AjaxFallbackLink("Hereditet") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                QuestionContainer5.replace(new InterviewTreePanel("subQuestion5", 5));
                target.add((QuestionContainer5));
                // setting to empty panel
                QuestionContainer1.replace(new EmptyPanel("subQuestion1"));
                target.add((QuestionContainer1));
                QuestionContainer2.replace(new EmptyPanel("subQuestion2"));
                target.add((QuestionContainer2));
                QuestionContainer3.replace(new EmptyPanel("subQuestion3"));
                target.add((QuestionContainer3));
                QuestionContainer4.replace(new EmptyPanel("subQuestion4"));
                target.add((QuestionContainer4));
                QuestionContainer6.replace(new EmptyPanel("subQuestion6"));
                target.add((QuestionContainer6));
                QuestionContainer7.replace(new EmptyPanel("subQuestion7"));
                target.add((QuestionContainer7));
                QuestionContainer8.replace(new EmptyPanel("subQuestion8"));
                target.add((QuestionContainer8));

                //setting the search panel empty, in case it was full of search texts

                ((BasePage) getPage()).getContentSearch().replace(new EmptyPanel("subSearch"));
                target.add(((BasePage) getPage()).getContentSearch());


            }
        };
        this.add(Hereditet);
        Link Allergier = new AjaxFallbackLink("Allergier") {

            @Override
            public void onClick(AjaxRequestTarget target) {
                QuestionContainer6.replace(new InterviewTreePanel("subQuestion6", 6));
                target.add((QuestionContainer6));
                // setting to empty panel
                QuestionContainer1.replace(new EmptyPanel("subQuestion1"));
                target.add((QuestionContainer1));
                QuestionContainer2.replace(new EmptyPanel("subQuestion2"));
                target.add((QuestionContainer2));
                QuestionContainer3.replace(new EmptyPanel("subQuestion3"));
                target.add((QuestionContainer3));
                QuestionContainer4.replace(new EmptyPanel("subQuestion4"));
                target.add((QuestionContainer4));
                QuestionContainer5.replace(new EmptyPanel("subQuestion5"));
                target.add((QuestionContainer5));
                QuestionContainer7.replace(new EmptyPanel("subQuestion7"));
                target.add((QuestionContainer7));
                QuestionContainer8.replace(new EmptyPanel("subQuestion8"));
                target.add((QuestionContainer8));

                //setting the search panel empty, in case it was full of search texts

                ((BasePage) getPage()).getContentSearch().replace(new EmptyPanel("subSearch"));
                target.add(((BasePage) getPage()).getContentSearch());


            }
        };
        this.add(Allergier);

        Link Medicinering = new AjaxFallbackLink("Medicinering") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                QuestionContainer7.replace(new InterviewTreePanel("subQuestion7", 7));
                target.add((QuestionContainer7));

                // setting to empty panel
                QuestionContainer1.replace(new EmptyPanel("subQuestion1"));
                target.add((QuestionContainer1));
                QuestionContainer2.replace(new EmptyPanel("subQuestion2"));
                target.add((QuestionContainer2));
                QuestionContainer3.replace(new EmptyPanel("subQuestion3"));
                target.add((QuestionContainer3));
                QuestionContainer4.replace(new EmptyPanel("subQuestion4"));
                target.add((QuestionContainer4));
                QuestionContainer5.replace(new EmptyPanel("subQuestion5"));
                target.add((QuestionContainer5));
                QuestionContainer6.replace(new EmptyPanel("subQuestion6"));
                target.add((QuestionContainer6));
                QuestionContainer8.replace(new EmptyPanel("subQuestion8"));
                target.add((QuestionContainer8));

                //setting the search panel empty, in case it was full of search texts

                ((BasePage) getPage()).getContentSearch().replace(new EmptyPanel("subSearch"));
                target.add(((BasePage) getPage()).getContentSearch());

            }
        };
        this.add(Medicinering);

        Link Levnadsvanor = new AjaxFallbackLink("Levnadsvanor") {

            @Override
            public void onClick(AjaxRequestTarget target) {
                QuestionContainer8.replace(new InterviewTreePanel("subQuestion8", 8));
                target.add((QuestionContainer8));

                // setting to empty panel
                QuestionContainer1.replace(new EmptyPanel("subQuestion1"));
                target.add((QuestionContainer1));
                QuestionContainer2.replace(new EmptyPanel("subQuestion2"));
                target.add((QuestionContainer2));
                QuestionContainer3.replace(new EmptyPanel("subQuestion3"));
                target.add((QuestionContainer3));
                QuestionContainer4.replace(new EmptyPanel("subQuestion4"));
                target.add((QuestionContainer4));
                QuestionContainer5.replace(new EmptyPanel("subQuestion5"));
                target.add((QuestionContainer5));
                QuestionContainer6.replace(new EmptyPanel("subQuestion6"));
                target.add((QuestionContainer6));
                QuestionContainer7.replace(new EmptyPanel("subQuestion7"));
                target.add((QuestionContainer7));

                //setting the search panel empty, in case it was full of search texts

                ((BasePage) getPage()).getContentSearch().replace(new EmptyPanel("subSearch"));
                target.add(((BasePage) getPage()).getContentSearch());



            }
        };
        this.add(Levnadsvanor);

    }



}
