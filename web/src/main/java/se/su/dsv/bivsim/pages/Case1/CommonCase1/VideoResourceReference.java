package se.su.dsv.bivsim.pages.Case1.CommonCase1;

import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.request.resource.DynamicImageResource;
import org.apache.wicket.request.resource.IResource;
import org.apache.wicket.request.resource.ResourceReference;
import org.apache.wicket.util.string.StringValue;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: kebede
 * Date: 10/10/13
 * Time: 10:27
 * To change this template use File | Settings | File Templates.
 */
public class VideoResourceReference extends ResourceReference {

    public VideoResourceReference() {

        super(VideoResourceReference.class, "VideoReference");
    }

    @Override
    public IResource getResource() {
        return new VideoResource();

    }

    private static class VideoResource extends DynamicImageResource {

        @Override
        protected byte[] getImageData(Attributes attributes) {

            PageParameters parameters = attributes.getParameters();
            StringValue name = parameters.get("name");

            byte[] imageBytes = null;

            if (!name.isEmpty()) {
                imageBytes = getImageAsBytes(name.toString());

            }
            return imageBytes;
        }


        private byte[] getImageAsBytes(String label) {
            try {
                File file = new File("/var/bivsim/Videoclips/" + label);
                FileInputStream inputStream = new FileInputStream(file);
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[4096];

                int len;
                while ((len = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, len);
                }

                return outputStream.toByteArray();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public boolean equals(Object that) {
            return that instanceof VideoResource;
        }
    }
}
