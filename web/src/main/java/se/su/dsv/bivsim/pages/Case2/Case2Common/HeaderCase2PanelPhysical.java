package se.su.dsv.bivsim.pages.Case2.Case2Common;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;
import se.su.dsv.bivsim.pages.Case2.Case2Common.BaseClasses.BaseCase2Pagephysical;
import se.su.dsv.bivsim.pages.Case2.Case2Physicalexa.PhysicalExamTreePanel;

public class HeaderCase2PanelPhysical extends Panel {


    public HeaderCase2PanelPhysical(String id) {
        super(id);

        Link Inspection = new AjaxFallbackLink("Inspection") {
            @Override
            public void onClick(AjaxRequestTarget target) {
                ((BaseCase2Pagephysical) getPage()).getContentW().replace(new PhysicalExamTreePanel("mainNavigation2", 1));
                target.add(((BaseCase2Pagephysical) getPage()).getContentW());
            }

// it was 10

              /*  wmc.replace(new InterviewTreePanel("test"));
                target.add(wmc);

                getSession().setAttribute("Interview_examExpanded", true);

                if (getSession().getAttribute("Physical_examExpanded") != null) {
                    wmc2.replace(new EmptyPanel("test2"));
                    target.add(wmc2);
                }
                if (getSession().getAttribute("labsImaging_examExpanded") != null) {
                    wmc3.replace(new EmptyPanel("test3"));
                    target.add(wmc3);
                }
                if (getSession().getAttribute("screeing_examExpanded") != null) {
                    wmc4.replace(new EmptyPanel("test4"));
                    target.add(wmc4);
                    wmc5.replace(new EmptyPanel("test5"));
                    target.add(wmc5);
                }  }*/


        };
        this.add(Inspection);

        Link Palpation = new AjaxFallbackLink("Palpation") {

            @Override
            public void onClick(AjaxRequestTarget target) {


                ((BaseCase2Pagephysical) getPage()).getContentW().replace(new PhysicalExamTreePanel("mainNavigation2", 2));
                target.add(((BaseCase2Pagephysical) getPage()).getContentW());

                // it was 40

             /*   wmc2.replace(new PhysicalExamTreePanel("test2"));
                target.add(wmc2);
                getSession().setAttribute("Physical_examExpanded", true);

                if (getSession().getAttribute("Interview_examExpanded") != null) {
                    wmc.replace(new EmptyPanel("test"));
                    target.add(wmc);
                }
                if (getSession().getAttribute("labsImaging_examExpanded") != null) {
                    wmc3.replace(new EmptyPanel("test3"));
                    target.add(wmc3);
                }
                if (getSession().getAttribute("screeing_examExpanded") != null) {
                    wmc4.replace(new EmptyPanel("test4"));
                    target.add(wmc4);
                    wmc5.replace(new EmptyPanel("test5"));
                    target.add(wmc5);
                }


                */
            }

        };
        this.add(Palpation);

        Link Auscultation = new AjaxFallbackLink("Auscultation") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                ((BaseCase2Pagephysical) getPage()).getContentW().replace(new PhysicalExamTreePanel("mainNavigation2", 3));
                target.add(((BaseCase2Pagephysical) getPage()).getContentW());









             /*   wmc3.replace(new ImagingTreePanel("test3"));
                target.add(wmc3);
                getSession().setAttribute("labsImaging_examExpanded", true);


                if (getSession().getAttribute("Interview_examExpanded") != null) {
                    wmc.replace(new EmptyPanel("test"));
                    target.add(wmc);
                }
                if (getSession().getAttribute("Physical_examExpanded") != null) {
                    wmc2.replace(new EmptyPanel("test2"));
                    target.add(wmc2);
                }
                if (getSession().getAttribute("screeing_examExpanded") != null) {
                    wmc4.replace(new EmptyPanel("test4"));
                    target.add(wmc4);
                    wmc5.replace(new EmptyPanel("test5"));
                    target.add(wmc5);
                }

                */

            }
        };
        this.add(Auscultation);

        Link Psykstatus = new AjaxFallbackLink("Psykstatus") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                ((BaseCase2Pagephysical) getPage()).getContentW().replace(new PhysicalExamTreePanel("mainNavigation2", 4));
                target.add(((BaseCase2Pagephysical) getPage()).getContentW());
            }
        };
        this.add(Psykstatus);

        Link Övrigt = new AjaxFallbackLink("Övrigt") {

            @Override
            public void onClick(AjaxRequestTarget target) {
                ((BaseCase2Pagephysical) getPage()).getContentW().replace(new PhysicalExamTreePanel("mainNavigation2", 5));
                target.add(((BaseCase2Pagephysical) getPage()).getContentW());

            }
        };
        this.add(Övrigt);
/*
/*
        Link assessment = new AjaxFallbackLink("Assessment") {
            @Override
            public void onClick(AjaxRequestTarget target) {
            //    this.setResponsePage(new AssessmentMainPage());

            }
        };
        this.add(assessment); */
    }
}