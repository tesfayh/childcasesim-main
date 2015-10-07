package se.su.dsv.bivsim.pages.Case3.Case3feedbacksection;

import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import se.su.dsv.bivsim.pages.Case3.Case3feedbacksection.BaseClasses.BaseFeedbackPageCase3;


/**
 * Created by kib on 12/1/14.
 */
public class FeedbackInstrumentPage extends BaseFeedbackPageCase3 {

    WebMarkupContainer instrument;

    public WebMarkupContainer getContentW() {

        return instrument;
    }

    int panelindex = 0;

    public FeedbackInstrumentPage(final PageParameters parameters) {


        instrument = new WebMarkupContainer("instrumentmarkup");
        instrument.setOutputMarkupId(true);
        add(instrument);

        panelindex = parameters.get("A").toInt();
        if (panelindex == 1)
            instrument.add(new PHQ9FeedBackPanel("instrument"));
        else if (panelindex == 2)
            instrument.add(new AUDITFeedBackpanel("instrument"));
        else if (panelindex == 3)
            instrument.add(new DUDITFeedBackPanel("instrument"));
        else if (panelindex == 4)
            instrument.add(new ASRSFeedbackPanel("instrument"));
        else if (panelindex == 5)
            instrument.add(new IESRFeedbackPanel("instrument"));

        else if (panelindex == 7)
            instrument.add(new MADRSFeedbackPanel("instrument"));

        else if (panelindex == 8)
            instrument.add(new PTSDFeedbackPanel("instrument"));

    }
}