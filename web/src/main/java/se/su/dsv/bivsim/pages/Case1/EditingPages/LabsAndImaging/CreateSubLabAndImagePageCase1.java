package se.su.dsv.bivsim.pages.Case1.EditingPages.LabsAndImaging;

import org.apache.wicket.markup.html.form.*;
import org.apache.wicket.markup.html.form.upload.FileUpload;
import org.apache.wicket.markup.html.form.upload.FileUploadField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import se.su.dsv.bivsim.data.Case.dao.interfaces.ImagingEntityDao;
import se.su.dsv.bivsim.data.Case.dataobjects.ImagingEntity;
import se.su.dsv.bivsim.pages.Case1.EditingPages.Common.BaseClasses.EditingMainPage1;


import java.io.File;
import java.util.Arrays;
import java.util.List;

public class CreateSubLabAndImagePageCase1 extends EditingMainPage1 {

    @SpringBean
    ImagingEntityDao imagingEntityDao;

    public ImagingEntity selectedParent;

/*
    ModalWindow parentSelection;
*/
    String ParentStringName;
    private String Questions;
    private String Desc;
    private String clipId;
    private FileUploadField fileUploadField;
    int index=0;
    private static final List<String> EDIT_categories = Arrays.asList(new String[]{"Klin Kemi", "Mikrobiologi", "Fysiologi", "Bild/Rtg"});
    private String selected2 = "Klin Kemi";

    public CreateSubLabAndImagePageCase1(int index) {
        final FeedbackPanel feed = new FeedbackPanel("feed");
        feed.setOutputMarkupId(true);
        add(feed);
        Form form = new InterviewQuestionCreationForm("form");
       /* final WebMarkupContainer wmc = new WebMarkupContainer("wmc");
        wmc.setOutputMarkupId(true);*/
/*
        final FormComponent<String> parentName = new TextArea<String>("parentName", new Model<String>(ParentStringName)).setRequired(true);
*/
        DropDownChoice<String> EditLists2 = new DropDownChoice<String>("EditTpes2", new PropertyModel<String>(this, "selected2"), EDIT_categories);

        final FormComponent<String> Questions = new TextArea<String>("Questions", new PropertyModel<String>(this, "Questions")).setRequired(true);
        final FormComponent<String> Desc = new TextArea<String>("Answer", new PropertyModel<String>(this, "Desc")).setRequired(true);
        fileUploadField = (FileUploadField) new FileUploadField("fileUpload").setRequired(true);


/*
        wmc.add(parentName);
*/
        add(form);
/*
        form.add(wmc);
*/
        form.add(Questions);
        form.add(Desc);
        form.add(fileUploadField);
        form.add(EditLists2);

        /*parentSelection = new ModalWindow("parentSelection");
        parentSelection.setContent(new SelectLabAndImageEntityParentPanel("content", index) {
            @Override
            public void okay() {
                CreateSubLabAndImagePageCase1.this.selectedParent = this.getSelectedParent();

                wmc.replace(new TextField<String>("parentName", new Model<String>(selectedParent.getName())));

            }
        });
        add(parentSelection);*/
    }


    private class InterviewQuestionCreationForm extends Form {
        public InterviewQuestionCreationForm(String id) {
            super(id);


           /* add(new AjaxLink("selectParent") {
                @Override
                public void onClick(AjaxRequestTarget target) {
                    target.prependJavaScript("Wicket.Window.unloadConfirmation = false;");
                    parentSelection.show(target);
                }
            });*/
        }

        @Override
        public void onSubmit() {

            if(selected2.equals("Klin Kemi"))
                index=10;
            if(selected2.equals("Mikrobiologi"))
                index=20;
            if(selected2.equals("Fysiologi"))
                index=30;
            if(selected2.equals("Bild/Rtg"))
                index=40;
            final FileUpload uploadField = fileUploadField.getFileUpload();

            if (uploadField != null) {
                File file = new File("/var/childcasesim/PicturesCase1/" + uploadField.getClientFileName());
                if (file.exists())
                    file.delete();
                try {
                    file.createNewFile();
                    uploadField.writeTo(file);
                } catch (Exception e) {
                    throw new IllegalStateException("Error", e);

                }

            }

            ImagingEntity interviewEntity = new ImagingEntity();
            interviewEntity.setParent(selectedParent);
            interviewEntity.setName(Questions);
            interviewEntity.setPicId(clipId);
            interviewEntity.setDescription(Desc);
            interviewEntity.setCate_ID(index);
            interviewEntity.setPicId(uploadField.getClientFileName().replace(".png", ""));

            imagingEntityDao.save(interviewEntity);
            info("You have created a new sub Imaging successfully");
/*
            ParentStringName = null;
*/
            Questions = null;
            Desc = null;
            clipId = null;


        }
    }
}
