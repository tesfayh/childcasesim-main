package se.su.dsv.bivsim.pages.Case3.Case3Common.BaseClasses;

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
import se.su.dsv.bivsim.pages.Case3.Case3Common.HeaderCase3Panel;
import se.su.dsv.bivsim.pages.Case3.Case3Common.HomeCase3Labs;
import se.su.dsv.bivsim.pages.Case3.Case3Common.HomeCase3Page;
import se.su.dsv.bivsim.pages.Case3.Case3Common.HomeCase3Pagephysical;
import se.su.dsv.bivsim.pages.Case3.Case3Interview.SearchInterveiwTreePanel;
import se.su.dsv.bivsim.pages.Case3.Case3assessment.AssessmentReferalCase3Page;
import se.su.dsv.bivsim.pages.Case3.Case3feedbacksection.CategoryFeedBackPage;
import se.su.dsv.bivsim.pages.CommonAllCases.ChooseCase;
import se.su.dsv.bivsim.pages.CommonAllCases.SignOut;

public class BaseCase3Page extends WebPage {
    WebMarkupContainer questions;

    public WebMarkupContainer getContentW() {

        return questions;
    }

    public BaseCase3Page() {
        this(null);
        questions = new WebMarkupContainer("Questions");
        questions.setOutputMarkupId(true);
        add(questions);
        questions.add(new EmptyPanel("mainNavigation2"));
        this.add(new HeaderCase3Panel("mainNavigation"));


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
                    ((BaseCase3Page) getPage()).getContentW().replace(new SearchInterveiwTreePanel("mainNavigation2", searchtxt.getModel().getObject().toString()));
                    target.add(((BaseCase3Page) getPage()).getContentW());
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


    }

    public BaseCase3Page(IModel model) {
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
