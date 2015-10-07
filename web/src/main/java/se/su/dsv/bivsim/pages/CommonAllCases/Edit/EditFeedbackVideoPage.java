package se.su.dsv.bivsim.pages.CommonAllCases.Edit;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.upload.FileUpload;
import org.apache.wicket.markup.html.form.upload.FileUploadField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import se.su.dsv.bivsim.pages.CommonAllCases.Edit.BaseClasses.CommonEditingPage;

public class EditFeedbackVideoPage extends CommonEditingPage {
    public EditFeedbackVideoPage() {
        final FileUploadField fileUploadField = new FileUploadField("upload");
        final FeedbackPanel feed = new FeedbackPanel("feed");
        feed.setOutputMarkupId(true);
        add(feed);
        Form form = new Form("form") {
            @Override
            public void onSubmit() {

                final FileUpload uploadedFile = fileUploadField.getFileUpload();
                if (uploadedFile != null) {
                    org.apache.wicket.util.file.File newFile = new org.apache.wicket.util.file.File("/var/childcasesim/Videoclips/" + "Fedback.flv");
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
