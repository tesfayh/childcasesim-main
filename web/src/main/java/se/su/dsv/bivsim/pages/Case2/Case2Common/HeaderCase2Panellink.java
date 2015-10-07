package se.su.dsv.bivsim.pages.Case2.Case2Common;/*
package se.su.dsv.childcasesim.pages;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.EmptyPanel;
import org.apache.wicket.markup.html.panel.Panel;
import se.su.dsv.childcasesim.pages.ACase1.assessment.AssessmentMainPage;
import se.su.dsv.childcasesim.pages.ACase1.imaging.ImagingTreePanel;
import se.su.dsv.childcasesim.pages.ACase1.interview.InterviewTreePanel;
import se.su.dsv.childcasesim.pages.ACase1.physicalexa.PhysicalExamTreePanel;
import se.su.dsv.childcasesim.pages.ACase1.screeninginstruments.ScreeningLinksPanel;

public class HeaderPanellink extends Panel {

    public HeaderPanellink(String id) {
        super(id);
        final WebMarkupContainer wmc = new WebMarkupContainer("wmc");
        final WebMarkupContainer wmc2 = new WebMarkupContainer("wmc2");
        final WebMarkupContainer wmc4 = new WebMarkupContainer("wmc4");
        final WebMarkupContainer wmc3 = new WebMarkupContainer("wmc3");
        final WebMarkupContainer wmc5 = new WebMarkupContainer("wmc5");

        wmc.setOutputMarkupId(true);
        wmc2.setOutputMarkupId(true);
        wmc3.setOutputMarkupId(true);
        wmc4.setOutputMarkupId(true);
        wmc5.setOutputMarkupId(true);
        add(wmc);
        add(wmc2);
        add(wmc3);
        add(wmc4);
        add(wmc5);
        wmc.add(new EmptyPanel("test"));
        wmc2.add(new EmptyPanel("test2"));
        wmc3.add(new EmptyPanel("test3"));
        wmc4.add(new EmptyPanel("test4"));
        wmc5.add(new EmptyPanel("test5"));

        Link Interview = new AjaxFallbackLink("Interview") {
            @Override
            public void onClick(AjaxRequestTarget target) {


                wmc.replace(new InterviewTreePanel("test", 1));
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
                }

            }
        };
        this.add(Interview);

        Link physicalExam = new AjaxFallbackLink("Physical_exam") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                wmc2.replace(new PhysicalExamTreePanel("test2"));
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
            }

        };
        this.add(physicalExam);

        Link labsImaging = new AjaxFallbackLink("labsImaging") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                wmc3.replace(new ImagingTreePanel("test3"));
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
            }
        };
        this.add(labsImaging);

        Link screeingInstruments = new AjaxFallbackLink("screeing_Instruments") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                wmc4.replace(new ScreeningLinksPanel("test4"));
                target.add(wmc4);
              */
/*  wmc5.replace(new GoToAssessmentLinkPanel("test5"));
                target.add(wmc5);*//*

                getSession().setAttribute("screeing_examExpanded", true);

                if (getSession().getAttribute("Physical_examExpanded") != null) {
                    wmc2.replace(new EmptyPanel("test2"));
                    target.add(wmc2);
                }
                if (getSession().getAttribute("labsImaging_examExpanded") != null) {
                    wmc3.replace(new EmptyPanel("test3"));
                    target.add(wmc3);
                }
                if (getSession().getAttribute("Interview_examExpanded") != null) {
                    wmc.replace(new EmptyPanel("test"));
                    target.add(wmc);
                }
            }
        };
        this.add(screeingInstruments);

        Link assessment = new AjaxFallbackLink("Assessment") {
            @Override
            public void onClick(AjaxRequestTarget target) {
                this.setResponsePage(new AssessmentMainPage());

            }
        };
        this.add(assessment);
    }

}*/
