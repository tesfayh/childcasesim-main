package se.su.dsv.bivsim.pages.CommonAllCases.Setting;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.link.ResourceLink;
import org.apache.wicket.request.resource.ContentDisposition;
import org.apache.wicket.request.resource.ResourceStreamResource;
import org.apache.wicket.util.file.File;
import org.apache.wicket.util.resource.IResourceStream;
import org.apache.wicket.util.resource.ZipResourceStream;
import se.su.dsv.childcasesim.pages.CommonAllCases.General.ChooseCase;

/**
 * Created by kib on 9/22/15.
 */
public class DownLoadPage extends WebPage {
    public DownLoadPage(){
        Link tillbaka = new AjaxFallbackLink("tillbaka") {

            @Override
            public void onClick(AjaxRequestTarget target) {


                setResponsePage(ChooseCase.class);


            }


        };
         add(tillbaka);




        File file1 = new File("/var/childcasesim/Case1log/");
        file1.listFiles();
        IResourceStream resStream1 = new ZipResourceStream(file1);
        ResourceStreamResource resource1 = new ResourceStreamResource(resStream1);
        resource1.setFileName("Case-1log.zip");
        resource1.setContentDisposition(ContentDisposition.ATTACHMENT);
        ResourceLink link1 = new ResourceLink("link1", resource1);
        add(link1);


        File file2 = new File("/var/childcasesim/Case2log/");
        file2.listFiles();
        IResourceStream resStream2 = new ZipResourceStream(file2);
        ResourceStreamResource resource2 = new ResourceStreamResource(resStream2);
        resource2.setFileName("Case-2log.zip");
        resource2.setContentDisposition(ContentDisposition.ATTACHMENT);
        ResourceLink link2 = new ResourceLink("link2", resource2);
        add(link2);



        File file3 = new File("/var/childcasesim/Case3log/");
        file3.listFiles();
        IResourceStream resStream3 = new ZipResourceStream(file3);
        ResourceStreamResource resource3 = new ResourceStreamResource(resStream3);
        resource3.setFileName("Case-3log.zip");
        resource3.setContentDisposition(ContentDisposition.ATTACHMENT);
        ResourceLink link3 = new ResourceLink("link3", resource3);
        add(link3);

    }
}
