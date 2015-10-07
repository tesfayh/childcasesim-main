package se.su.dsv.bivsim.pages.Case2.Case2EditingPages.Case2Editphyiscalexam;

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
import se.su.dsv.bivsim.data.Case.dao.interfaces.PhysicalExamEntityDao;
import se.su.dsv.bivsim.data.Case.dataobjects.PhysicalExamEntity;

import java.io.File;
import java.io.IOException;

public class EditingexistingPhysicalExamPanel extends Panel {

    @SpringBean
    PhysicalExamEntityDao physicalExamEntityDao;
    private static int flag = 0;
    FileUploadField fileUploadField;


    public EditingexistingPhysicalExamPanel(String id, final PhysicalExamEntity entity) {
        super(id);
        final FeedbackPanel feed = new FeedbackPanel("feed");
        feed.setOutputMarkupId(true);
        add(feed);

        final FormComponent<String> name = new TextArea<String>("name", new Model<String>(entity.getName())).setRequired(true);
        final TextArea<String> Desc = new TextArea<String>("Desc", new Model<String>(entity.getDescription()));
        fileUploadField = new FileUploadField("fileUpload");


        Form<?> form = new Form<Void>("Form") {

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

                PhysicalExamEntity upateentity = physicalExamEntityDao.load(entity.getPhysicalExamId());
                upateentity.setName(name.getModelObject());
                upateentity.setDescription(Desc.getModelObject());
                if (uploadedfile != null)
                    upateentity.setPicId(uploadedfile.getClientFileName().replaceAll(".png", ""));
                physicalExamEntityDao.save(upateentity);

            }

        };
        add(form);
        form.setOutputMarkupId(true);
        form.add(name);
        form.add(Desc);
        form.add(fileUploadField);


        AjaxLink<String> aj = new AjaxLink<String>("delete") {
            @Override
            public void onClick(AjaxRequestTarget target) {
                target.add(feed);
                PhysicalExamEntity deleteobject = physicalExamEntityDao.load(entity.getPhysicalExamId());

                if (flag == 0) {
                    if (deleteobject.getPhysicalExamEntities().isEmpty()) {
                        physicalExamEntityDao.delete(deleteobject);
                        info("You have deleted the Physical exam successfully");
                        flag = 1;
                    } else {
                        info("To delete this Physical exam you are required to delete its children first");

                    }
                } else
                    info(" This Physical exam is already deleted");


            }

        };
        form.add(aj);

        AjaxLink<String> close = new AjaxLink<String>("close") {
            @Override
            public void onClick(AjaxRequestTarget target) {
                setResponsePage(PhysicalExamTreePageCase2.class);
                flag = 0;

            }
        };
        form.add(close);

    }
}
