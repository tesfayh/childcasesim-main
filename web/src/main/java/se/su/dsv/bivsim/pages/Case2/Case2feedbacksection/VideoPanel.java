package se.su.dsv.bivsim.pages.Case2.Case2feedbacksection;

import org.apache.wicket.markup.html.link.ExternalLink;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.request.resource.ResourceReference;
import se.su.dsv.bivsim.pages.Case2.Case2Common.VideoResourceReference2;

public class VideoPanel extends Panel {
    public VideoPanel(String id, String video) {
        super(id);
        ResourceReference videoResourceReference = new VideoResourceReference2();
        PageParameters videoParameters = new PageParameters();
        String imageName = video + ".flv";
        videoParameters.set("name", imageName);
        CharSequence urlForVideo = urlFor(videoResourceReference, videoParameters);
        add(new ExternalLink("videoplayer", urlForVideo.toString()));
    }
}
