package se.su.dsv.bivsim.pages.CommonAllCases.General;

import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.ExternalLink;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.request.resource.PackageResourceReference;
import org.apache.wicket.request.resource.ResourceReference;

public class VideoChildFeedbackPanel extends ContentPanel {

    public VideoChildFeedbackPanel(String id, String content, String videoId, ResourceReference videoResourceReference) {
        super(id, content);

/*
        ResourceReference videoResourceReference = new VideoResourceReference();
*/
        PageParameters videoParameters = new PageParameters();
        String imageName = "child/" + videoId + ".flv";
        videoParameters.set("name", imageName);

        CharSequence urlForVideo = urlFor(videoResourceReference, videoParameters);
        add(new ExternalLink("videoplayer", urlForVideo.toString()));


        PackageResourceReference resourceReference =
                new PackageResourceReference(VideoChildFeedbackPanel.class, "flowplayer-3.2.16.swf");
        CharSequence url = getRequestCycle().urlFor(resourceReference, new PageParameters());
        add(new Label("script",
                        "$f('a.player', '" + url + "', {log: {level: 'warn'}});" +
                        "$f(0).play();").setEscapeModelStrings(false));
    }

    @Override
    public void renderHead(IHeaderResponse response) {
        super.renderHead(response);
        response.render(JavaScriptHeaderItem.forReference(new PackageResourceReference(VideoChildFeedbackPanel.class, "flowplayer-3.2.12.min.js")));
    }
}
