package se.su.dsv.bivsim.pages.CommonAllCases.screeninginstruments;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import se.su.dsv.childcasesim.pages.CommonAllCases.HeaderPanel.Case1HeaderPanel;
import se.su.dsv.childcasesim.pages.CommonAllCases.HeaderPanel.Case2HeaderPanel;
import se.su.dsv.childcasesim.pages.CommonAllCases.HeaderPanel.Case3HeaderPanel;
import se.su.dsv.childcasesim.pages.CommonAllCases.General.SignOut;

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
        add(new Label("username", "Inloggad:" + getSession().getAttribute("username").toString()));


        pageParameters = new PageParameters();


        //Header panels

        if((Integer)getSession().getAttribute("case")==1){
            add(new Case1HeaderPanel("caseHeader"));
        }


        else if((Integer)getSession().getAttribute("case")==2){
            add(new Case2HeaderPanel("caseHeader"));

        }


        else if((Integer)getSession().getAttribute("case")==3){
            add(new Case3HeaderPanel("caseHeader"));

        }



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

                panelnumber = 10;
                pageParameters.set("A", panelnumber);
                setResponsePage(BaseInstrumentPage.class, pageParameters);
            }


        };
        add(Social);


    }


    public InstrumentListPage(IModel model) {
        super(model);

    }



}
