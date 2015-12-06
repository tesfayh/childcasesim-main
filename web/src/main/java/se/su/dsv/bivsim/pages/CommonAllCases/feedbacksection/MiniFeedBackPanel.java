package se.su.dsv.bivsim.pages.CommonAllCases.feedbacksection;

/**
 * Created by kib on 12/3/15.
 */

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.link.ResourceLink;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.request.resource.ContentDisposition;
import org.apache.wicket.request.resource.ResourceStreamResource;
import org.apache.wicket.util.file.File;
import org.apache.wicket.util.resource.FileResourceStream;
import org.apache.wicket.util.resource.IResourceStream;
import se.su.dsv.bivsim.pages.CommonAllCases.screeninginstruments.InstrumentListPage;


/**
 * Created by kib on 3/29/15.
 */
public class MiniFeedBackPanel extends Panel {
    public MiniFeedBackPanel(String id) {
        super(id);
        File file = new File("/var/bivsim/Info1/MINI_vers_6.pdf");
        file.listFiles();
        // IResourceStream resStream = new ZipResourceStream(file);
        IResourceStream resourceStream = new FileResourceStream(
                new File(file));
        ResourceStreamResource resource = new ResourceStreamResource(resourceStream);
        resource.setContentDisposition(ContentDisposition.ATTACHMENT);
        ResourceLink link = new ResourceLink("link", resource);
        add(link);

       /* File file2 = new File("/var/bivsim/Info1/barnkonventionen-i-sin-helhet.pdf");
        file2.listFiles();
        // IResourceStream resStream = new ZipResourceStream(file);
        IResourceStream resourceStream2 = new FileResourceStream(
                new File(file2));
        ResourceStreamResource resource2 = new ResourceStreamResource(resourceStream2);
        resource.setContentDisposition(ContentDisposition.ATTACHMENT);
        ResourceLink link2 = new ResourceLink("link2", resource2);
        add(link2);*/

        Link tillbaka = new AjaxFallbackLink("tillbaka") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                setResponsePage(InstrumentListPage.class);

            }


        };
        add(tillbaka);

    }
}


