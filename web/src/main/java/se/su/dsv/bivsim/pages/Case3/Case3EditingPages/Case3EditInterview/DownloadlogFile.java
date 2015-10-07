package se.su.dsv.bivsim.pages.Case3.Case3EditingPages.Case3EditInterview;

import org.apache.wicket.markup.html.link.ResourceLink;
import org.apache.wicket.request.resource.ContentDisposition;
import org.apache.wicket.request.resource.ResourceStreamResource;
import org.apache.wicket.util.file.File;
import org.apache.wicket.util.resource.IResourceStream;
import org.apache.wicket.util.resource.ZipResourceStream;
import se.su.dsv.bivsim.pages.Case3.Case3EditingPages.Case3EdittingCommon.BaseClasses.EditingMainPage3;


public class DownloadlogFile extends EditingMainPage3 {
    public DownloadlogFile() {
        File file = new File("/var/childcasesim/Case1log/");
        file.listFiles();
        IResourceStream resStream = new ZipResourceStream(file);
        ResourceStreamResource resource = new ResourceStreamResource(resStream);
        resource.setFileName("Case-1log.zip");
        resource.setContentDisposition(ContentDisposition.ATTACHMENT);
        ResourceLink link = new ResourceLink("link", resource);
        add(link);
    }
}
