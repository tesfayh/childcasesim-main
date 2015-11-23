package se.su.dsv.bivsim.pages.Case1.CommonCase1;

import org.apache.wicket.markup.html.link.ResourceLink;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.request.resource.ContentDisposition;
import org.apache.wicket.request.resource.ResourceStreamResource;
import org.apache.wicket.util.file.File;
import org.apache.wicket.util.resource.FileResourceStream;
import org.apache.wicket.util.resource.IResourceStream;

/**
 * Created by kib on 3/29/15.
 */
public class JournalPanel extends Panel {
    public JournalPanel(String id) {
        super(id);
        File file = new File("/var/childcasesim/Info1/Tidigare.pdf");
        file.listFiles();
        // IResourceStream resStream = new ZipResourceStream(file);
        IResourceStream resourceStream = new FileResourceStream(
                new File(file));
        ResourceStreamResource resource = new ResourceStreamResource(resourceStream);
        resource.setContentDisposition(ContentDisposition.ATTACHMENT);
        ResourceLink link = new ResourceLink("link", resource);
        add(link);

        File file2 = new File("/var/childcasesim/Info1/Social nätverkskarta.pdf");
        file2.listFiles();
        // IResourceStream resStream = new ZipResourceStream(file);
        IResourceStream resourceStream2 = new FileResourceStream(
                new File(file2));
        ResourceStreamResource resource2 = new ResourceStreamResource(resourceStream2);
        resource.setContentDisposition(ContentDisposition.ATTACHMENT);
        ResourceLink link2 = new ResourceLink("link2", resource2);
        add(link2);
    }
}
