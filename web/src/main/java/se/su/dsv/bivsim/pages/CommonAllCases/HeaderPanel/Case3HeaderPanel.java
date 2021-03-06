package se.su.dsv.bivsim.pages.CommonAllCases.HeaderPanel;


import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;
import se.su.dsv.childcasesim.pages.Case3.Case3Common.BaseClasses.InfoCase3Page;
import se.su.dsv.childcasesim.pages.Case3.Case3Common.HomeCase3Labs;
import se.su.dsv.childcasesim.pages.Case3.Case3Common.HomeCase3Page;
import se.su.dsv.childcasesim.pages.Case3.Case3Common.HomeCase3Pagephysical;
import se.su.dsv.childcasesim.pages.CommonAllCases.General.ChooseCase;
import se.su.dsv.childcasesim.pages.CommonAllCases.assessment.AssessmentReferalPage;
import se.su.dsv.childcasesim.pages.CommonAllCases.feedbacksection.CategoryFeedBackPage;
import se.su.dsv.childcasesim.pages.CommonAllCases.screeninginstruments.InstrumentListPage;

/**
 * Created by kib on 11/16/15.
 */
public class Case3HeaderPanel extends Panel {
    public Case3HeaderPanel(String id){
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
