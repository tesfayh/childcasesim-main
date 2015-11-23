package se.su.dsv.bivsim.pages.Case3.Case3Common.BaseClasses;

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
import se.su.dsv.childcasesim.pages.Case3.Case3Common.HomeCase3Labs;
import se.su.dsv.childcasesim.pages.Case3.Case3Common.HomeCase3Page;
import se.su.dsv.childcasesim.pages.Case3.Case3Common.HomeCase3Pagephysical;
import se.su.dsv.childcasesim.pages.Case3.Case3Physicalexa.PhysicalExamTreePanel;
import se.su.dsv.childcasesim.pages.CommonAllCases.General.ChooseCase;
import se.su.dsv.childcasesim.pages.CommonAllCases.General.SignOut;
import se.su.dsv.childcasesim.pages.CommonAllCases.assessment.AssessmentReferalPage;
import se.su.dsv.childcasesim.pages.CommonAllCases.feedbacksection.CategoryFeedBackPage;
import se.su.dsv.childcasesim.pages.CommonAllCases.screeninginstruments.InstrumentListPage;

public class BaseCase3Pagephysical extends WebPage {
    WebMarkupContainer SearchContainer1;
    WebMarkupContainer MainNavigationContainer;
    WebMarkupContainer VideoContainer;




    public WebMarkupContainer getContentSearch() {

        return SearchContainer1;
    }


    public WebMarkupContainer getContentMainNavigation() {

        return MainNavigationContainer;
    }

    public WebMarkupContainer getContentVideoContainer() {

        return VideoContainer;
    }




    public BaseCase3Pagephysical() {
        SearchContainer1=new WebMarkupContainer("SearchContainer1");
        SearchContainer1.setOutputMarkupId(true);
        add(SearchContainer1);
        SearchContainer1.add(new EmptyPanel("subSearch"));


        MainNavigationContainer=new WebMarkupContainer("MainNavigationContainer");
        MainNavigationContainer.setOutputMarkupId(true);
        add(MainNavigationContainer);
        MainNavigationContainer.add(new PhysicalExamTreePanel("mainNavigation", 3));






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
                   /* SearchContainer1.replace(new SearchInterveiwTreePanel("subSearch", searchtxt.getModel().getObject().toString()));
                    target.add(SearchContainer1);
*/
                   /* // to collapse all navigation menus when the Search button is clicked.
                    ((BaseCase3Pagephysical) getPage()).getContentMainNavigation().replace(new HeaderCase3PanelPhysical("mainNavigation"));
                    target.add(((BaseCase3Pagephysical) getPage()).getContentMainNavigation());
*/

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

        Link lab = new AjaxFallbackLink("lab") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                setResponsePage(HomeCase3Labs.class);

            }


        };
        add(lab);

        Link instrument = new AjaxFallbackLink("instrument") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                setResponsePage(InstrumentListPage.class);

            }


        };
        add(instrument);

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
