package se.su.dsv.bivsim.pages.Case3.Case3Interview;

/**
 * Created with IntelliJ IDEA.
 * User: kebede
 * Date: 14/05/13
 * Time: 14:45
 * To change this template use File | Settings | File Templates.
 */

import org.apache.wicket.markup.html.image.Image;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.request.resource.ResourceReference;
import se.su.dsv.bivsim.pages.Case3.Case3Common.VideoResourceReference3;

public class InterviewPicturePanel extends ContentPanel {

    public InterviewPicturePanel(String id, String content, String picId) {
        super(id, content);
        ResourceReference imagesResourceReference = new VideoResourceReference3();
        PageParameters imageParameters = new PageParameters();
        String imageName = picId + ".png";
        imageParameters.set("name", imageName);
        CharSequence urlForImage = urlFor(imagesResourceReference, imageParameters);
        add(new Image("picture", imagesResourceReference, imageParameters));
    }
}
