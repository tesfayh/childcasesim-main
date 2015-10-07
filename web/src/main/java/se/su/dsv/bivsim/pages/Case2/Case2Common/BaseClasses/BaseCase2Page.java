package se.su.dsv.bivsim.pages.Case2.Case2Common.BaseClasses;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.ajax.markup.html.form.AjaxSubmitLink;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.EmptyPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import se.su.dsv.bivsim.pages.Case2.Case2Common.*;
import se.su.dsv.bivsim.pages.Case2.Case2assessment.AssessmentReferalPageCase2;
import se.su.dsv.bivsim.pages.Case2.Case2feedbacksection.CategoryFeedBackPage;
import se.su.dsv.bivsim.pages.Case2.Case2Interview.SearchInterveiwTreePanel;
import se.su.dsv.bivsim.pages.CommonAllCases.ChooseCase;
import se.su.dsv.bivsim.pages.CommonAllCases.SignOut;

public class BaseCase2Page extends WebPage {
    WebMarkupContainer questions;

    public WebMarkupContainer getContentW() {

        return questions;
    }

    public BaseCase2Page() {
        this(null);
        questions = new WebMarkupContainer("Questions");
        questions.setOutputMarkupId(true);
        add(questions);
        questions.add(new EmptyPanel("mainNavigation2"));
        this.add(new HeaderCase2Panel("mainNavigation"));


        Link signOut = new AjaxFallbackLink("signOut") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                setResponsePage(SignOut.class);

            }


        };
        add(signOut);
        signOut.add(new Label("username", getSession().getAttribute("username").toString()));


        final TextField searchtxt = new TextField("searchtxt", new Model(""));

        /*Link search = new AjaxFallbackLink("search") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                System.out.println(searchtxt.getDefaultModelObjectAsString());
                ((BasePage) getPage()).getContentW().replace(new SearchInterveiwTreePanel("mainNavigation2", searchtxt.getModel().getObject().toString()));
                target.add(((BasePage) getPage()).getContentW());
            }




        };


*/


        AjaxSubmitLink addLink = new AjaxSubmitLink("link") {

            protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
                if (searchtxt.getModel().getObject() != null) {
                    ((BaseCase2Page) getPage()).getContentW().replace(new SearchInterveiwTreePanel("mainNavigation2", searchtxt.getModel().getObject().toString()));
                    target.add(((BaseCase2Page) getPage()).getContentW());
                }

            }
        };

        Form<?> form = new Form("searchForm") {
            @Override
            public void onSubmit() {


            }

        };
        add(form);
        form.add(searchtxt);
        form.add(addLink);
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
        Link instrument = new AjaxFallbackLink("instrument") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                setResponsePage(InstrumentCase2ListPage.class);

            }
        };
        add(instrument);

        Link lab = new AjaxFallbackLink("lab") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                setResponsePage(HomeCase2Labs.class);

            }

        };
        add(lab);

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


    }

    public BaseCase2Page(IModel model) {
        super(model);

    }

    @Override
    public void renderHead(IHeaderResponse response) {
       /* response.render(CssHeaderItem.forReference(new CssResourceReference(HomePage.class,
                "css4/uikit.gradient.min.css")));
        response.render(CssHeaderItem.forReference(new CssResourceReference(HomePage.class,
                "css4/hermes.css")));
        response.render(CssHeaderItem.forReference(new CssResourceReference(HomePage.class,
                "js4/uikit.min.js")));
*/

    }
}
