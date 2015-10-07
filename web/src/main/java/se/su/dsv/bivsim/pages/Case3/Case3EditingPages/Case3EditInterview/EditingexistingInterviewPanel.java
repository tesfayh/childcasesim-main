package se.su.dsv.bivsim.pages.Case3.Case3EditingPages.Case3EditInterview;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.FormComponent;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.form.upload.FileUpload;
import org.apache.wicket.markup.html.form.upload.FileUploadField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.apache.wicket.util.file.File;
import se.su.dsv.bivsim.data.Case.dao.interfaces.InterviewEntityDao;
import se.su.dsv.bivsim.data.Case.dataobjects.InterviewEntity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class EditingexistingInterviewPanel extends Panel {

    @SpringBean
    InterviewEntityDao interviewEntityDao;
    private static int flag = 0;
    private FileUploadField fileUploadField;
    private String subdateName;

    public EditingexistingInterviewPanel(String id, final InterviewEntity entity) {
        super(id);
        final FeedbackPanel feed = new FeedbackPanel("feed");
        feed.setOutputMarkupId(true);
        add(feed);

        final FormComponent<String> name = new TextArea<String>("name", new Model<String>(entity.getName())).setRequired(true);
        final TextArea<String> feedback = new TextArea<String>("feedbackinput", new Model<String>(entity.getFeedbackInput()));
        final TextArea<Integer> trustvalue;
        /*if (entity.getTrustValue() != null)
            trustvalue = (TextArea<Integer>) new TextArea<Integer>("trustvalue", new Model<Integer>(entity.getTrustValue())).setRequired(true);
        else
            trustvalue = new TextArea<Integer>("trustvalue", new Model<Integer>(0));*/
        final TextArea<String> answer = new TextArea<String>("answer", new Model<String>(entity.getPatientAnswer()));
        fileUploadField = (FileUploadField) new FileUploadField("fileUpload").setRequired(true);

        Form<?> form = new Form<Void>("Form") {

            @Override
            public void onSubmit() {
                final FileUpload uploadedFile = fileUploadField.getFileUpload();
                if (uploadedFile != null) {
                    Date date = new Date();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
                    subdateName = dateFormat.format(date);

                    if (uploadedFile.getClientFileName().contains(".flv")) {
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

                InterviewEntity upateentity = interviewEntityDao.load(entity.getId());
                upateentity.setName(name.getModelObject());
                upateentity.setPatientAnswer(answer.getModelObject());
                upateentity.setFeedbackInput(feedback.getModelObject());
/*
                upateentity.setTrustValue(Integer.parseInt(trustvalue.getValue()));
*/
                if (uploadedFile != null && uploadedFile.getClientFileName().contains(".flv"))
                    upateentity.setClipId(uploadedFile.getClientFileName().replaceAll(".flv", "") + subdateName);
                else if (uploadedFile != null && uploadedFile.getClientFileName().contains("png"))
                    upateentity.setClipId(uploadedFile.getClientFileName().replaceAll(".png", "") + "pic" + subdateName);

                interviewEntityDao.save(upateentity);
            }

        };
        add(form);
        form.setOutputMarkupId(true);

        form.add(name);
        form.add(feedback);
/*
        form.add(trustvalue);
*/
        form.add(answer);
        form.add(fileUploadField);


        AjaxLink<String> aj = new AjaxLink<String>("delete") {
            @Override
            public void onClick(AjaxRequestTarget target) {
                target.add(feed);
                InterviewEntity deleteobject = interviewEntityDao.load(entity.getId());

                if (flag == 0) {
                    if (deleteobject.getInterviews().isEmpty()) {
                        interviewEntityDao.delete(deleteobject);
                        info("You have deleted the interview successfully");
                        flag = 1;
                    } else {
                        info("To delete this interview you are required to delete its children first");

                    }
                } else
                    info(" This interview is already deleted");


            }

        };
        form.add(aj);

        AjaxLink<String> close = new AjaxLink<String>("close") {
            @Override
            public void onClick(AjaxRequestTarget target) {
/*
                setResponsePage(InterviewTreePageCase1.class);
*/
                flag = 0;

            }
        };
        form.add(close);

    }
}
