package se.su.dsv.bivsim.pages.Case3.Case3Common;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.EmptyPanel;
import org.apache.wicket.markup.html.panel.Panel;
import se.su.dsv.childcasesim.pages.Case3.Case3Common.BaseClasses.BaseLabsCase3Page;
import se.su.dsv.childcasesim.pages.Case3.Case3Imaging.ImagingTreePanel3;

public class HeaderCase3PanelLabs extends Panel {

    WebMarkupContainer QuestionContainer1;
    WebMarkupContainer QuestionContainer2;
    WebMarkupContainer QuestionContainer3;
    WebMarkupContainer QuestionContainer4;
    public HeaderCase3PanelLabs(String id) {
        super(id);
        QuestionContainer1 = new WebMarkupContainer("QuestionContainer1");
        QuestionContainer2 = new WebMarkupContainer("QuestionContainer2");
        QuestionContainer3 = new WebMarkupContainer("QuestionContainer3");
        QuestionContainer4 = new WebMarkupContainer("QuestionContainer4");



        QuestionContainer1.setOutputMarkupId(true);
        QuestionContainer2.setOutputMarkupId(true);
        QuestionContainer3.setOutputMarkupId(true);
        QuestionContainer4.setOutputMarkupId(true);

        add(QuestionContainer1);
        add(QuestionContainer2);
        add(QuestionContainer3);
        add(QuestionContainer4);


        QuestionContainer1.add(new EmptyPanel("subQuestion1"));
        QuestionContainer2.add(new EmptyPanel("subQuestion2"));
        QuestionContainer3.add(new EmptyPanel("subQuestion3"));
        QuestionContainer4.add(new EmptyPanel("subQuestion4"));

        Link Interview = new AjaxFallbackLink("KlinKemi") {
            @Override
            public void onClick(AjaxRequestTarget target) {
                QuestionContainer1.replace(new ImagingTreePanel3("subQuestion1", 9));
                target.add((QuestionContainer1));

                //Setting to empty panel
                QuestionContainer2.replace(new EmptyPanel("subQuestion2"));
                target.add((QuestionContainer2));
                QuestionContainer3.replace(new EmptyPanel("subQuestion3"));
                target.add((QuestionContainer3));
                QuestionContainer4.replace(new EmptyPanel("subQuestion4"));
                target.add((QuestionContainer4));



                //seting the search panel empty, incase it was full of search texts

                ((BaseLabsCase3Page) getPage()).getContentSearch().replace(new EmptyPanel("subSearch"));
                target.add(((BaseLabsCase3Page) getPage()).getContentSearch());

            }
        };
        this.add(Interview);

        Link physicalExam = new AjaxFallbackLink("Mikrobiologi") {

            @Override
            public void onClick(AjaxRequestTarget target) {


                QuestionContainer2.replace(new ImagingTreePanel3("subQuestion2", 10));
                target.add((QuestionContainer2));

                //Setting to empty panel
                QuestionContainer1.replace(new EmptyPanel("subQuestion1"));
                target.add((QuestionContainer1));
                QuestionContainer3.replace(new EmptyPanel("subQuestion3"));
                target.add((QuestionContainer3));
                QuestionContainer4.replace(new EmptyPanel("subQuestion4"));
                target.add((QuestionContainer4));


                //seting the search panel empty, in-case it was full of search texts

                ((BaseLabsCase3Page) getPage()).getContentSearch().replace(new EmptyPanel("subSearch"));
                target.add(((BaseLabsCase3Page) getPage()).getContentSearch());

            }

        };
        this.add(physicalExam);

        Link labsImaging = new AjaxFallbackLink("Fysiologi") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                QuestionContainer3.replace(new ImagingTreePanel3("subQuestion3",11));
                target.add((QuestionContainer3));

                // setting to empty panel
                QuestionContainer1.replace(new EmptyPanel("subQuestion1"));
                target.add((QuestionContainer1));
                QuestionContainer2.replace(new EmptyPanel("subQuestion2"));
                target.add((QuestionContainer2));
                QuestionContainer4.replace(new EmptyPanel("subQuestion4"));
                target.add((QuestionContainer4));


                //setting the search panel empty, in case it was full of search texts

                ((BaseLabsCase3Page) getPage()).getContentSearch().replace(new EmptyPanel("subSearch"));
                target.add(((BaseLabsCase3Page) getPage()).getContentSearch());


            }
        };
        this.add(labsImaging);

        Link screeingInstruments = new AjaxFallbackLink("Bild/Rtg") {

            @Override
            public void onClick(AjaxRequestTarget target) {
                QuestionContainer4.replace(new ImagingTreePanel3("subQuestion4",12 ));
                target.add((QuestionContainer4));

                // setting to empty panel
                QuestionContainer1.replace(new EmptyPanel("subQuestion1"));
                target.add((QuestionContainer1));
                QuestionContainer2.replace(new EmptyPanel("subQuestion2"));
                target.add((QuestionContainer2));
                QuestionContainer3.replace(new EmptyPanel("subQuestion3"));
                target.add((QuestionContainer3));


                //setting the search panel empty, in case it was full of search texts

                ((BaseLabsCase3Page) getPage()).getContentSearch().replace(new EmptyPanel("subSearch"));
                target.add(((BaseLabsCase3Page) getPage()).getContentSearch());

            }
        };
        this.add(screeingInstruments);
    }
}