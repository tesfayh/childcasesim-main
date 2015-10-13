package se.su.dsv.bivsim.pages.Case1.CommonCase1;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.EmptyPanel;
import org.apache.wicket.markup.html.panel.Panel;
import se.su.dsv.bivsim.pages.Case1.CommonCase1.BaseClasses.BasePage;
import se.su.dsv.bivsim.pages.Case1.interview.ChildInterviewfTreePanel;
import se.su.dsv.bivsim.pages.Case1.interview.InterviewTreePanel;

public class HeaderPanel extends Panel {


    public HeaderPanel(String id) {
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

        Link Interview = new AjaxFallbackLink("Introduction") {
            @Override
            public void onClick(AjaxRequestTarget target) {
                ((BasePage) getPage()).getContentW().replace(new InterviewTreePanel("mainNavigation2", 1, "m"));
                target.add(((BasePage) getPage()).getContentW());
              ((BasePage) getPage()).getContentWChild().replace(new ChildInterviewfTreePanel("mainNavigation3", 9, "c"));
                target.add(((BasePage) getPage()).getContentWChild());
            }
        };
        this.add(Interview);

        Link physicalExam = new AjaxFallbackLink("Aktuellt") {

            @Override
            public void onClick(AjaxRequestTarget target) {


                ((BasePage) getPage()).getContentW().replace(new InterviewTreePanel("mainNavigation2", 2, "m"));
                target.add(((BasePage) getPage()).getContentW());
                ((BasePage) getPage()).getContentWChild().replace(new ChildInterviewfTreePanel("mainNavigation3", 10, "c"));
                target.add(((BasePage) getPage()).getContentWChild());

            }

        };
        this.add(physicalExam);

        Link Grundl = new AjaxFallbackLink("Grundl") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                ((BasePage) getPage()).getContentW().replace(new InterviewTreePanel("mainNavigation2", 3, "m"));
                target.add(((BasePage) getPage()).getContentW());
                ((BasePage) getPage()).getContentWChild().replace(new ChildInterviewfTreePanel("mainNavigation3", 11, "c"));
                target.add(((BasePage) getPage()).getContentWChild());


            }
        };
        this.add(Grundl);

        Link Utveckling = new AjaxFallbackLink("Utveckling") {

            @Override
            public void onClick(AjaxRequestTarget target) {
                ((BasePage) getPage()).getContentW().replace(new InterviewTreePanel("mainNavigation2", 4, "m"));
                target.add(((BasePage) getPage()).getContentW());
                ((BasePage) getPage()).getContentWChild().replace(new ChildInterviewfTreePanel("mainNavigation3", 12, "c"));
                target.add(((BasePage) getPage()).getContentWChild());


            }
        };
        this.add(Utveckling);

        Link Socialt = new AjaxFallbackLink("Socialt") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                ((BasePage) getPage()).getContentW().replace(new InterviewTreePanel("mainNavigation2", 5, "m"));
                target.add(((BasePage) getPage()).getContentW());
                ((BasePage) getPage()).getContentWChild().replace(new ChildInterviewfTreePanel("mainNavigation3", 13, "c"));
                target.add(((BasePage) getPage()).getContentWChild());

            }
        };
        this.add(Socialt);
        Link Hereditet = new AjaxFallbackLink("Hereditet") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                ((BasePage) getPage()).getContentW().replace(new InterviewTreePanel("mainNavigation2", 6, "m"));
                target.add(((BasePage) getPage()).getContentW());
                ((BasePage) getPage()).getContentWChild().replace(new ChildInterviewfTreePanel("mainNavigation3", 14, "c"));
                target.add(((BasePage) getPage()).getContentWChild());

            }
        };
        this.add(Hereditet);

        Link Systemkartläggning = new AjaxFallbackLink("Systemkartläggning") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                ((BasePage) getPage()).getContentW().replace(new InterviewTreePanel("mainNavigation2", 7, "m"));
                target.add(((BasePage) getPage()).getContentW());
                ((BasePage) getPage()).getContentWChild().replace(new ChildInterviewfTreePanel("mainNavigation3", 15, "c"));
                target.add(((BasePage) getPage()).getContentWChild());

            }
        };
        this.add(Systemkartläggning);

        Link Gemensamt = new AjaxFallbackLink("Gemensamt") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                ((BasePage) getPage()).getContentW().replace(new InterviewTreePanel("mainNavigation2", 8, "m"));
                target.add(((BasePage) getPage()).getContentW());
                ((BasePage) getPage()).getContentWChild().replace(new ChildInterviewfTreePanel("mainNavigation3", 15, "c"));
                target.add(((BasePage) getPage()).getContentWChild());

            }
        };
        this.add(Gemensamt);


/*

 */
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