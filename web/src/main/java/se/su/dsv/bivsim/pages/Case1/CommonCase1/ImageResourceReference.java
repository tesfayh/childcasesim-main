package se.su.dsv.bivsim.pages.Case1.CommonCase1;

import java.io.*;

import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.request.resource.DynamicImageResource;
import org.apache.wicket.request.resource.IResource;
import org.apache.wicket.request.resource.ResourceReference;
import org.apache.wicket.util.string.StringValue;

public class ImageResourceReference extends ResourceReference {

    public ImageResourceReference() {

        super(ImageResourceReference.class, "imagesDemo");
    }

    @Override
    public IResource getResource() {

        return new ImageResource();
    }


    private static class ImageResource extends DynamicImageResource {

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
                File file = new File("/var/bivsim/PicturesCase1/" + label);
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
            return that instanceof ImageResource;
        }
    }
}

