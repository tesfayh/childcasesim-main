package se.su.dsv.bivsim.pages.Case1.CommonCase1;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.EmptyPanel;
import org.apache.wicket.markup.html.panel.Panel;
import se.su.dsv.bivsim.pages.Case1.CommonCase1.BaseClasses.BaseLabsPage;
import se.su.dsv.bivsim.pages.Case1.imaging.ImagingTreePanel;

public class HeaderPanelLabs extends Panel {


    public HeaderPanelLabs(String id) {
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

        Link KlinKemi = new AjaxFallbackLink("KlinKemi") {
            @Override
            public void onClick(AjaxRequestTarget target) {
                ((BaseLabsPage) getPage()).getContentW().replace(new ImagingTreePanel("mainNavigation2", 1));
                target.add(((BaseLabsPage) getPage()).getContentW());
            }



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
        this.add(KlinKemi);

        Link Mikrobiologi = new AjaxFallbackLink("Mikrobiologi") {

            @Override
            public void onClick(AjaxRequestTarget target) {


                ((BaseLabsPage) getPage()).getContentW().replace(new ImagingTreePanel("mainNavigation2", 2));
                target.add(((BaseLabsPage) getPage()).getContentW());

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
        this.add(Mikrobiologi);

        Link Fysiologi = new AjaxFallbackLink("Fysiologi") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                ((BaseLabsPage) getPage()).getContentW().replace(new ImagingTreePanel("mainNavigation2", 3));
                target.add(((BaseLabsPage) getPage()).getContentW());









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
        this.add(Fysiologi);

        Link Rtg = new AjaxFallbackLink("Bild/Rtg") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                ((BaseLabsPage) getPage()).getContentW().replace(new ImagingTreePanel("mainNavigation2", 4));
                target.add(((BaseLabsPage) getPage()).getContentW());

              /*
                wmc4.replace(new ScreeningLinksPanel("test4"));
                target.add(wmc4);

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

                */
            }
        };
        this.add(Rtg);
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