package se.su.dsv.bivsim.pages.Case3.Case3Common.BaseClasses;

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
import se.su.dsv.bivsim.pages.Case3.Case3Common.HeaderCase3PanelLabs;
import se.su.dsv.bivsim.pages.Case3.Case3Common.HomeCase3Labs;
import se.su.dsv.bivsim.pages.Case3.Case3Common.HomeCase3Page;
import se.su.dsv.bivsim.pages.Case3.Case3Common.HomeCase3Pagephysical;
import se.su.dsv.bivsim.pages.Case3.Case3assessment.AssessmentReferalCase3Page;
import se.su.dsv.bivsim.pages.Case3.Case3feedbacksection.CategoryFeedBackPage;
import se.su.dsv.bivsim.pages.CommonAllCases.ChooseCase;
import se.su.dsv.bivsim.pages.CommonAllCases.SignOut;

/**
 * Created by kib on 12/31/14.
 */
public class BaseLabsCase3Page extends WebPage {
    WebMarkupContainer questions;

    public WebMarkupContainer getContentW() {

        return questions;
    }

    public BaseLabsCase3Page() {
        this(null);
        questions = new WebMarkupContainer("Questions");
        questions.setOutputMarkupId(true);
        add(questions);
        questions.add(new EmptyPanel("mainNavigation2"));
        this.add(new HeaderCase3PanelLabs("mainNavigation"));

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

                setResponsePage(InstrumentCase3ListPage.class);

            }


        };
        add(instrument);

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

    public BaseLabsCase3Page(IModel model) {
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
