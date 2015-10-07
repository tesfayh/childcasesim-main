package se.su.dsv.bivsim.pages.Case1.CommonCase1.BaseClasses;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import se.su.dsv.bivsim.pages.Case1.CommonCase1.HomeLabs;
import se.su.dsv.bivsim.pages.Case1.CommonCase1.HomePage;
import se.su.dsv.bivsim.pages.Case1.assessment.AssessmentReferalPage;
import se.su.dsv.bivsim.pages.Case1.feedbacksection.CategoryFeedBackPage;
import se.su.dsv.bivsim.pages.Case1.screeninginstruments.SocialPanel;
import se.su.dsv.bivsim.pages.CommonAllCases.ChooseCase;
import se.su.dsv.bivsim.pages.CommonAllCases.SignOut;

/**
 * Created by kib on 12/1/14.
 */
public class InstrumentListPage extends WebPage {
    ModalWindow modal;
    int panelnumber;
    PageParameters pageParameters;

    public InstrumentListPage() {
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

                setResponsePage(HomePage.class);

            }


        };
        add(exam);
        Link lab = new AjaxFallbackLink("lab") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                setResponsePage(HomeLabs.class);

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



        // links for the main page

        Link PHQ9 = new AjaxFallbackLink("PHQ9") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                panelnumber = 2;
                pageParameters.set("A", panelnumber);
                setResponsePage(BaseInstrumentPage.class, pageParameters);
            }


        };
        add(PHQ9);


        Link IES = new AjaxFallbackLink("IES-R") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                panelnumber =3;
                pageParameters.set("A", panelnumber);
                setResponsePage(BaseInstrumentPage.class, pageParameters);

            }


        };
        add(IES);

        Link AUDIT = new AjaxFallbackLink("AUDIT") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                panelnumber = 4;
                pageParameters.set("A", panelnumber);
                setResponsePage(BaseInstrumentPage.class, pageParameters);
            }


        };
        add(AUDIT);

        Link PTSD = new AjaxFallbackLink("PTSD") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                panelnumber =9;
                pageParameters.set("A", panelnumber);
                setResponsePage(BaseInstrumentPage.class, pageParameters);
            }


        };
        add(PTSD);


        Link DUDIT = new AjaxFallbackLink("DUDIT") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                panelnumber = 6;
                pageParameters.set("A", panelnumber);
                setResponsePage(BaseInstrumentPage.class, pageParameters);

            }


        };
        add(DUDIT);

        Link MADRAS = new AjaxFallbackLink("MADRAS") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                panelnumber = 7;
                pageParameters.set("A", panelnumber);
                setResponsePage(BaseInstrumentPage.class, pageParameters);

            }


        };
        add(MADRAS);


        Link ASRS = new AjaxFallbackLink("ASRS") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                panelnumber = 8;
                pageParameters.set("A", panelnumber);
                setResponsePage(BaseInstrumentPage.class, pageParameters);

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


    public InstrumentListPage(IModel model) {
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
