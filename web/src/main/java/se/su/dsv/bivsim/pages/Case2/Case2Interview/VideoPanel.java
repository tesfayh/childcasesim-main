package se.su.dsv.bivsim.pages.Case2.Case2Interview;

import org.apache.wicket.markup.html.link.ExternalLink;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.request.resource.ResourceReference;
import se.su.dsv.bivsim.pages.Case2.Case2Common.VideoResourceReference2;

/**
 * Created with IntelliJ IDEA.
 * User: kebede
 * Date: 13/05/13
 * Time: 22:24
 * To change this template use File | Settings | File Templates.
 */
public class VideoPanel extends ContentPanel {

    public VideoPanel(String id, String content, String videoId) {
        super(id, content);

        ResourceReference videoResourceReference = new VideoResourceReference2();
        PageParameters videoParameters = new PageParameters();
        String imageName = videoId + ".flv";
        videoParameters.set("name", imageName);

        CharSequence urlForVideo = urlFor(videoResourceReference, videoParameters);
        add(new ExternalLink("videoplayer", urlForVideo.toString()));


    }
}
