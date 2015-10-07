package se.su.dsv.bivsim.pages.Case1.CommonCase1.BaseClasses;

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
import se.su.dsv.bivsim.pages.Case1.CommonCase1.HeaderPanel;
import se.su.dsv.bivsim.pages.Case1.CommonCase1.HomeLabs;
import se.su.dsv.bivsim.pages.Case1.CommonCase1.HomePage;
import se.su.dsv.bivsim.pages.Case1.CommonCase1.HomePagephysical;
import se.su.dsv.bivsim.pages.Case1.assessment.AssessmentReferalPage;
import se.su.dsv.bivsim.pages.Case1.feedbacksection.CategoryFeedBackPage;
import se.su.dsv.bivsim.pages.Case1.interview.SearchInterveiwTreePanel;
import se.su.dsv.bivsim.pages.CommonAllCases.*;

public class BasePage extends WebPage {
    WebMarkupContainer questions;
    WebMarkupContainer questions2;




    public WebMarkupContainer getContentW() {

        return questions;
    }

    public WebMarkupContainer getContentWChild() {

        return questions2;
    }

    public BasePage() {
        this(null);
        questions = new WebMarkupContainer("Questions");
        questions2 = new WebMarkupContainer("Questions2");

        questions.setOutputMarkupId(true);
        questions2.setOutputMarkupId(true);

        add(questions);
        add(questions2);

        questions.add(new EmptyPanel("mainNavigation2"));
        questions2.add(new EmptyPanel("mainNavigation3"));

        this.add(new HeaderPanel("mainNavigation"));


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
                    ((BasePage) getPage()).getContentW().replace(new SearchInterveiwTreePanel("mainNavigation2", searchtxt.getModel().getObject().toString()));
                    target.add(((BasePage) getPage()).getContentW());
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

    public BasePage(IModel model) {
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
