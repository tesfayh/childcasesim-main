package se.su.dsv.bivsim.pages.Case2.Case2EditingPages.Case2Editphyiscalexam;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.FormComponent;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.form.upload.FileUpload;
import org.apache.wicket.markup.html.form.upload.FileUploadField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import se.su.dsv.bivsim.data.Case.dao.interfaces.PhysicalExamEntityDao;
import se.su.dsv.bivsim.data.Case.dataobjects.PhysicalExamEntity;
import se.su.dsv.bivsim.pages.Case2.Case2EditingPages.Case2EdittingCommon.BaseClasses.EditingMainPage2;

import java.io.File;
import java.io.IOException;

public class CreateSubPhysicalExamPageCase2 extends EditingMainPage2 {

    @SpringBean
    PhysicalExamEntityDao physicalExamEntityDao;
    public PhysicalExamEntity selectedParent;
    int tempoIndex;

   /* ModalWindow parentSelection;
    String ParentStringName;*/
    private String Questions;
    private String Desc;
    private String clipId;
    FileUploadField fileUploadField;

    public CreateSubPhysicalExamPageCase2(int index) {
        tempoIndex=index;
        final FeedbackPanel feed = new FeedbackPanel("feed");
        feed.setOutputMarkupId(true);
        add(feed);
        Form form = new InterviewQuestionCreationForm("form");
       /* final WebMarkupContainer wmc = new WebMarkupContainer("wmc");
        wmc.setOutputMarkupId(true);*/

/*
        final FormComponent<String> parentName = new TextArea<String>("parentName", new Model<String>(ParentStringName)).setRequired(true);
*/
        final FormComponent<String> Questions = new TextArea<String>("Questions", new PropertyModel<String>(this, "Questions")).setRequired(true);
        final FormComponent<String> Desc = new TextArea<String>("Answer", new PropertyModel<String>(this, "Desc")).setRequired(true);
        fileUploadField = (FileUploadField) new FileUploadField("fileUpload").setRequired(true);

//        wmc.add(parentName);
        add(form);
/*
        form.add(wmc);
*/
        form.add(Questions);
        form.add(Desc);
        form.add(fileUploadField);

      /*  parentSelection = new ModalWindow("parentSelection");
        parentSelection.setContent(new SelectPhysicalExamEntityParentPanel("content") {
            @Override
            public void okay() {
                CreateSubPhysicalExamPageCase1.this.selectedParent = this.getSelectedParent();

                wmc.replace(new TextField<String>("parentName", new Model<String>(selectedParent.getName())));

            }
        });
        add(parentSelection);*/
    }


    private class InterviewQuestionCreationForm extends Form {
        public InterviewQuestionCreationForm(String id) {
            super(id);


//            add(new AjaxLink("selectParent") {
//                @Override
//                public void onClick(AjaxRequestTarget target) {
//                    /*target.prependJavaScript("Wicket.Window.unloadConfirmation = false;");
//                    parentSelection.show(target);*/
//                }
//            });
        }

        @Override
        public void onSubmit() {

            final FileUpload uploadedfile = fileUploadField.getFileUpload();
            if (uploadedfile != null) {

                File newfile = new File("/var/childcasesim/PicturesCase1/" + uploadedfile.getClientFileName());

                if (newfile.exists())
                    newfile.delete();

                try {
                    newfile.createNewFile();
                    uploadedfile.writeTo(newfile);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            PhysicalExamEntity Phsica = new PhysicalExamEntity();
/*
            Phsica.setParent(selectedParent);
*/
            Phsica.setName(Questions);
            Phsica.setPicId(uploadedfile.getClientFileName().replaceAll(".png", ""));
            Phsica.setDescription(Desc);
            Phsica.setGroupId(tempoIndex);
            physicalExamEntityDao.save(Phsica);
            info("Du har skapat en ny under fysisk");
/*
            ParentStringName = null;
*/
            Questions = null;
            Desc = null;
            clipId = null;


        }
    }
}
