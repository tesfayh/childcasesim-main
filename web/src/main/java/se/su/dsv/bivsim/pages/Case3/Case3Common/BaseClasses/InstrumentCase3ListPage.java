package se.su.dsv.bivsim.pages.Case3.Case3Common.BaseClasses;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import se.su.dsv.bivsim.pages.Case3.Case3Common.HomeCase3Labs;
import se.su.dsv.bivsim.pages.Case3.Case3Common.HomeCase3Page;
import se.su.dsv.bivsim.pages.Case3.Case3assessment.AssessmentReferalCase3Page;
import se.su.dsv.bivsim.pages.Case3.Case3Screeninginstruments.SocialPanel;
import se.su.dsv.bivsim.pages.Case3.Case3feedbacksection.CategoryFeedBackPage;
import se.su.dsv.bivsim.pages.CommonAllCases.ChooseCase;
import se.su.dsv.bivsim.pages.CommonAllCases.SignOut;

/**
 * Created by kib on 12/1/14.
 */
public class InstrumentCase3ListPage extends WebPage {
    ModalWindow modal;
    int panelnumber;
    PageParameters pageParameters;

    public InstrumentCase3ListPage() {
        modal = new ModalWindow("dialog");
        add(modal);
        modal.setInitialHeight(100);
        modal.setInitialWidth(200);
        Link signOut = new AjaxFallbackLink("signOut") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                setResponsePage(SignOut.class);

            }


        };
        add(signOut);
        signOut.add(new Label("username", getSession().getAttribute("username").toString()));
        pageParameters = new PageParameters();

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

                setResponsePage(HomeCase3Page.class);

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



        // links for the main page

        Link PHQ9 = new AjaxFallbackLink("PHQ9") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                panelnumber = 2;
                pageParameters.set("A", panelnumber);
                setResponsePage(BaseInstrumentCase3Page.class, pageParameters);
            }


        };
        add(PHQ9);


        Link IES = new AjaxFallbackLink("IES-R") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                panelnumber =3;
                pageParameters.set("A", panelnumber);
                setResponsePage(BaseInstrumentCase3Page.class, pageParameters);

            }


        };
        add(IES);

        Link AUDIT = new AjaxFallbackLink("AUDIT") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                panelnumber = 4;
                pageParameters.set("A", panelnumber);
                setResponsePage(BaseInstrumentCase3Page.class, pageParameters);
            }


        };
        add(AUDIT);

        Link PTSD = new AjaxFallbackLink("PTSD") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                panelnumber =9;
                pageParameters.set("A", panelnumber);
                setResponsePage(BaseInstrumentCase3Page.class, pageParameters);
            }


        };
        add(PTSD);


        Link DUDIT = new AjaxFallbackLink("DUDIT") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                panelnumber = 6;
                pageParameters.set("A", panelnumber);
                setResponsePage(BaseInstrumentCase3Page.class, pageParameters);

            }


        };
        add(DUDIT);

        Link MADRAS = new AjaxFallbackLink("MADRAS") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                panelnumber = 7;
                pageParameters.set("A", panelnumber);
                setResponsePage(BaseInstrumentCase3Page.class, pageParameters);

            }


        };
        add(MADRAS);


        Link ASRS = new AjaxFallbackLink("ASRS") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                panelnumber = 8;
                pageParameters.set("A", panelnumber);
                setResponsePage(BaseInstrumentCase3Page.class, pageParameters);

            }


        };
        add(ASRS);


        Link Social = new AjaxFallbackLink("Social") {

            @Override
            public void onClick(AjaxRequestTarget target) {
                target.prependJavaScript("Wicket.Window.unloadConfirmation = false;");
                modal.setContent(new SocialPanel("content"));
                modal.show(target);
            }


        };
        add(Social);


    }


    public InstrumentCase3ListPage(IModel model) {
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
