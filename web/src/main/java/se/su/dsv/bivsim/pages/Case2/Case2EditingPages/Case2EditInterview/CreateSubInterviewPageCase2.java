package se.su.dsv.bivsim.pages.Case2.Case2EditingPages.Case2EditInterview;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.FormComponent;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.form.upload.FileUpload;
import org.apache.wicket.markup.html.form.upload.FileUploadField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.apache.wicket.util.file.File;
import se.su.dsv.bivsim.data.Case.dao.interfaces.InterviewEntityDao;
import se.su.dsv.bivsim.data.Case.dataobjects.InterviewEntity;
import se.su.dsv.bivsim.pages.Case2.Case2EditingPages.Case2EdittingCommon.BaseClasses.EditingMainPage2;

import java.text.SimpleDateFormat;
import java.util.Date;


public class CreateSubInterviewPageCase2 extends EditingMainPage2 {

    @SpringBean
    InterviewEntityDao interviewEntityDao;

    public InterviewEntity selectedParent;

    ModalWindow parentSelection;
    String ParentStringName;
    private String Questions;
    private String Answer;
    private String feedbackInput;
    private int trustValue;
    private FileUploadField fileUploadField;
    private String subdateName;

    public CreateSubInterviewPageCase2(int index, String type) {

        final FeedbackPanel feed = new FeedbackPanel("feed");
        feed.setOutputMarkupId(true);
        add(feed);
        Form form = new InterviewQuestionCreationForm("form");
        final WebMarkupContainer wmc = new WebMarkupContainer("wmc");
        wmc.setOutputMarkupId(true);
        final FormComponent<String> parentName = new TextArea<String>("parentName", new Model<String>(ParentStringName)).setRequired(true);
        final FormComponent<String> Questions = new TextArea<String>("Questions", new PropertyModel<String>(this, "Questions")).setRequired(true);
        final FormComponent<String> Answer = new TextArea<String>("Answer", new PropertyModel<String>(this, "Answer")).setRequired(true);
        final TextArea<String> feedbackInput = new TextArea<String>("feedbackInput", new PropertyModel<String>(this, "feedbackInput"));
/*
        final TextArea<Integer> trustValue = new TextArea<Integer>("trustValue", new PropertyModel<Integer>(this, "trustValue"));
*/
        fileUploadField = (FileUploadField) new FileUploadField("fileUpload");

        wmc.add(parentName);
        add(form);
        form.add(wmc);
        form.add(Questions);
        form.add(Answer);
        form.add(feedbackInput);
/*
        form.add(trustValue);
*/
        form.setMultiPart(true);
        form.add(fileUploadField);

        parentSelection = new ModalWindow("parentSelection");
        parentSelection.setContent(new SelectInterviewEntityParentPanel("content", index, type) {
            @Override
            public void okay() {
                CreateSubInterviewPageCase2.this.selectedParent = this.getSelectedParent();

                wmc.replace(new TextField<String>("parentName", new Model<String>(selectedParent.getName())));

            }
        });
        add(parentSelection);
    }


    private class InterviewQuestionCreationForm extends Form {
        public InterviewQuestionCreationForm(String id) {
            super(id);


            add(new AjaxLink("selectParent") {
                @Override
                public void onClick(AjaxRequestTarget target) {
                    target.prependJavaScript("Wicket.Window.unloadConfirmation = false;");
                    parentSelection.show(target);
                }
            });
        }

        @Override
        public void onSubmit() {

            InterviewEntity interviewEntity = new InterviewEntity();
            final FileUpload uploadedFile = fileUploadField.getFileUpload();
            if (uploadedFile != null) {                    //home/kebede/Desktop/childcasesim/web/src/main/webapp

                Date date = new Date();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
                subdateName = dateFormat.format(date);

                if (uploadedFile.getClientFileName().contains("flv")) {
                    File newFile = new File("/var/childcasesim/Videoclips/" + uploadedFile.getClientFileName().replaceAll(".flv", "") + subdateName + ".flv");
                    if (newFile.exists())
                        newFile.delete();
                    try {
                        newFile.createNewFile();
                        uploadedFile.writeTo(newFile);

                    } catch (Exception e) {

                        throw new IllegalStateException("Error", e);
                    }

                } else {

                    File newFile = new File("/var/childcasesim/Videoclips/" + uploadedFile.getClientFileName().replaceAll(".png", "") + "pic" + subdateName + ".png");
                    if (newFile.exists())
                        newFile.delete();
                    try {
                        newFile.createNewFile();
                        uploadedFile.writeTo(newFile);

                    } catch (Exception e) {

                        throw new IllegalStateException("Error", e);
                    }


                }

            }
            interviewEntity.setParent(selectedParent);
            interviewEntity.setName(Questions);
            interviewEntity.setPatientAnswer(Answer);
            interviewEntity.setFeedbackInput(feedbackInput);
/*
            interviewEntity.setTrustValue(trustValue);
*/

            if (uploadedFile != null && uploadedFile.getClientFileName().contains(".flv"))
                interviewEntity.setClipId(uploadedFile.getClientFileName().replaceAll(".flv", "") + subdateName);
            else if (uploadedFile != null && uploadedFile.getClientFileName().contains(".png"))
                interviewEntity.setClipId(uploadedFile.getClientFileName().replaceAll(".png", "") + "pic" + subdateName);

            interviewEntityDao.save(interviewEntity);
            info("You have created a new sub-interview successfully");
            ParentStringName = null;
            Questions = null;
            Answer = null;
            feedbackInput = null;
        }
    }
}
