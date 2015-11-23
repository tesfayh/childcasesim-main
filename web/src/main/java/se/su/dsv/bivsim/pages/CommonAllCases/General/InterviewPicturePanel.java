package se.su.dsv.bivsim.pages.CommonAllCases.General;


import org.apache.wicket.markup.html.image.Image;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.request.resource.ResourceReference;
import se.su.dsv.childcasesim.pages.CommonAllCases.General.ContentPanel;

public class InterviewPicturePanel extends ContentPanel {
    public InterviewPicturePanel(String id, String content, String picId, ResourceReference imagesResourceReference ) {
        super(id, content);
        PageParameters imageParameters = new PageParameters();
        String imageName = picId + ".png";
        imageParameters.set("name", imageName);
        CharSequence urlForImage = urlFor(imagesResourceReference, imageParameters);
        add(new Image("picture", imagesResourceReference, imageParameters));
    }
}
