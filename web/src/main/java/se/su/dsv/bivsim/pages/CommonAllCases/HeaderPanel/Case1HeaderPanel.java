package se.su.dsv.bivsim.pages.CommonAllCases.HeaderPanel;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;
import se.su.dsv.childcasesim.pages.Case1.CommonCase1.BaseClasses.InfoPage;
import se.su.dsv.childcasesim.pages.Case1.CommonCase1.HomeLabs;
import se.su.dsv.childcasesim.pages.Case1.CommonCase1.HomePage;
import se.su.dsv.childcasesim.pages.CommonAllCases.General.ChooseCase;
import se.su.dsv.childcasesim.pages.CommonAllCases.assessment.AssessmentReferalPage;
import se.su.dsv.childcasesim.pages.CommonAllCases.feedbacksection.CategoryFeedBackPage;
import se.su.dsv.childcasesim.pages.CommonAllCases.screeninginstruments.InstrumentListPage;

/**
 * Created by kib on 11/16/15.
 */
public class Case1HeaderPanel extends Panel {

    public Case1HeaderPanel(String id){
        super(id);



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
        }






}
