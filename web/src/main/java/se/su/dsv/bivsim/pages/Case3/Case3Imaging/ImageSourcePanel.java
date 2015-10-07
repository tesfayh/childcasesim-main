package se.su.dsv.bivsim.pages.Case3.Case3Imaging;

import org.apache.wicket.markup.html.image.Image;
import org.apache.wicket.request.resource.ContextRelativeResource;
import se.su.dsv.bivsim.pages.Case3.Case3Interview.ContentPanel;

/**
 * Created with IntelliJ IDEA.
 * User: kebede
 * Date: 14/05/13
 * Time: 16:52
 * To change this template use File | Settings | File Templates.
 */
public class ImageSourcePanel extends ContentPanel {

    public ImageSourcePanel(String id, String content, String imagingId) {
        super(id, content);

        add(new Image("image", new ContextRelativeResource("/PicturesCase1/" + imagingId + ".png")));


    }
}