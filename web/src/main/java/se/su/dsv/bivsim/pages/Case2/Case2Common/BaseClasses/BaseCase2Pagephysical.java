package se.su.dsv.bivsim.pages.Case2.Case2Common.BaseClasses;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.EmptyPanel;
import org.apache.wicket.model.IModel;
import se.su.dsv.bivsim.pages.Case2.Case2Common.*;
import se.su.dsv.bivsim.pages.Case2.Case2assessment.AssessmentReferalPageCase2;
import se.su.dsv.bivsim.pages.Case2.Case2feedbacksection.CategoryFeedBackPage;
import se.su.dsv.bivsim.pages.Case2.Case2Physicalexa.StatusNonTreePanel;
import se.su.dsv.bivsim.pages.CommonAllCases.ChooseCase;
import se.su.dsv.bivsim.pages.CommonAllCases.SignOut;

public class BaseCase2Pagephysical extends WebPage {
    WebMarkupContainer questions;

    public WebMarkupContainer getContentW() {

        return questions;
    }

    public BaseCase2Pagephysical() {
        this(null);
        questions = new WebMarkupContainer("Questions");
        questions.setOutputMarkupId(true);
        add(questions);
        questions.add(new EmptyPanel("mainNavigation2"));
        this.add(new StatusNonTreePanel("mainNavigation", 2));

        Link signOut = new AjaxFallbackLink("signOut") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                setResponsePage(SignOut.class);

            }


        };
        add(signOut);
        signOut.add(new Label("username", getSession().getAttribute("username").toString()));
        Form<?> form = new Form("searchForm") {
            @Override
            public void onSubmit() {

                System.out.println("search working well");
            }

        };
        add(form);
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

    }

    public BaseCase2Pagephysical(IModel model) {
        super(model);

    }

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
