package se.su.dsv.bivsim.pages.CommonAllCases.General;

/**
 * Created with IntelliJ IDEA.
 * User: kebede
 * Date: 14/05/13
 * Time: 14:45
 * To change this template use File | Settings | File Templates.
 */

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.image.Image;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.request.resource.ResourceReference;


public class PicturePanel extends Panel {

    public PicturePanel(String id, String content, String picId, ResourceReference imagesResourceReference ) {
        super(id);
/*
        ResourceReference imagesResourceReference = new ImageResourceReference();
*/
        PageParameters imageParameters = new PageParameters();
        String imageName = picId + ".png";
        imageParameters.set("name", imageName);
        CharSequence urlForImage = urlFor(imagesResourceReference, imageParameters);
        add(new Image("picture", imagesResourceReference, imageParameters));


        add(new Label("content", content));


    }
}
