package se.su.dsv.bivsim.pages.CommonAllCases.Edit;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.upload.FileUpload;
import org.apache.wicket.markup.html.form.upload.FileUploadField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import se.su.dsv.childcasesim.pages.CommonAllCases.Edit.BaseClasses.CommonEditingPage;

import java.io.File;

public class EditHomemessagePage extends CommonEditingPage {
    public EditHomemessagePage() {
        final FileUploadField fileUploadField = new FileUploadField("upload");
        final FeedbackPanel feed = new FeedbackPanel("feed");
        feed.setOutputMarkupId(true);
        add(feed);
        Form form = new Form("form") {
            @Override
            public void onSubmit() {

                final FileUpload uploadedFile = fileUploadField.getFileUpload();
                if (uploadedFile != null) {
                    File newFile = new File("/var/childcasesim/Videoclips/" + "RichardMollica.flv");

                    if (newFile.exists())
                        newFile.delete();
                    try {
                        newFile.createNewFile();
                        uploadedFile.writeTo(newFile);
                        info("Uploaded sucessfully");

                    } catch (Exception e) {

                        throw new IllegalStateException("Error", e);
                    }
                }
            }
        };
        add(form);
        form.add(fileUploadField);


    }
}
