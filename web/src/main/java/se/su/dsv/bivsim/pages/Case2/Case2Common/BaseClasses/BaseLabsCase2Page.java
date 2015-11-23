package se.su.dsv.bivsim.pages.Case2.Case2Common.BaseClasses;

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
import se.su.dsv.childcasesim.pages.Case2.Case2Common.*;
import se.su.dsv.childcasesim.pages.CommonAllCases.General.ChooseCase;
import se.su.dsv.childcasesim.pages.CommonAllCases.General.SignOut;
import se.su.dsv.childcasesim.pages.CommonAllCases.assessment.AssessmentReferalPage;
import se.su.dsv.childcasesim.pages.CommonAllCases.feedbacksection.CategoryFeedBackPage;
import se.su.dsv.childcasesim.pages.CommonAllCases.screeninginstruments.InstrumentListPage;

/**
 * Created by kib on 12/31/14.
 */
public class BaseLabsCase2Page extends WebPage {
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

    public BaseLabsCase2Page() {

        SearchContainer1=new WebMarkupContainer("SearchContainer1");
        SearchContainer1.setOutputMarkupId(true);
        add(SearchContainer1);
        SearchContainer1.add(new EmptyPanel("subSearch"));

        MainNavigationContainer=new WebMarkupContainer("MainNavigationContainer");
        MainNavigationContainer.setOutputMarkupId(true);
        add(MainNavigationContainer);
        MainNavigationContainer.add(new HeaderCase2PanelLabs("mainNavigation"));


        Link signOut = new AjaxFallbackLink("signOut") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                setResponsePage(SignOut.class);

            }


        };
        add(signOut);
        add(new Label("username", "Inloggad:" + getSession().getAttribute("username").toString()));


        final TextField searchtxt = new TextField("searchtxt", new Model(""));

        AjaxSubmitLink addLink = new AjaxSubmitLink("link") {

            protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
                if (searchtxt.getModel().getObject() != null) {
                   /* SearchContainer1.replace(new SearchInterveiwTreePanel("subSearch", searchtxt.getModel().getObject().toString()));
                    target.add(SearchContainer1);
*/
                    // to collapse all navigation menus when the Search button is clicked.
                    ((BaseLabsCase2Page) getPage()).getContentMainNavigation().replace(new HeaderCase2PanelLabs("mainNavigation"));
                    target.add(((BaseLabsCase2Page) getPage()).getContentMainNavigation());


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

                setResponsePage(HomeCase2Pagephysical.class);

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
