package se.su.dsv.bivsim.pages.Case3.Case3EditingPages.Case3LabsAndImaging;

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
import se.su.dsv.bivsim.data.Case.dao.interfaces.ImagingEntityDao;
import se.su.dsv.bivsim.data.Case.dataobjects.ImagingEntity;

import java.io.File;
import java.io.IOException;

public class EditingexistingLabAndImagePanel3 extends Panel {


    @SpringBean
    ImagingEntityDao imagingEntityDao;
    private static int flag = 0;
    private FileUploadField fileUploadField;

    public EditingexistingLabAndImagePanel3(String id, final ImagingEntity entity) {
        super(id);
        final FeedbackPanel feed = new FeedbackPanel("feed");
        feed.setOutputMarkupId(true);
        add(feed);

        final FormComponent<String> name = new TextArea<String>("name", new Model<String>(entity.getName())).setRequired(true);
        final TextArea<String> Desc = new TextArea<String>("feedbackinput", new Model<String>(entity.getDescription()));
        fileUploadField = (FileUploadField) new FileUploadField("fileUpload");

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
                ImagingEntity upateentity = imagingEntityDao.load(entity.getImagingId());
                upateentity.setName(name.getModelObject());
                upateentity.setDescription(Desc.getModelObject());
                if (uploadedfile != null)
                    upateentity.setPicId(uploadedfile.getClientFileName().replaceAll(".png", ""));
                imagingEntityDao.save(upateentity);
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
                ImagingEntity deleteobject = imagingEntityDao.load(entity.getImagingId());

                if (flag == 0) {
                    if (deleteobject.getImagingEntities().isEmpty()) {
                        imagingEntityDao.delete(deleteobject);
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
                setResponsePage(LabAndImageTreePageCase3.class);
                flag = 0;

            }
        };
        form.add(close);

    }
}
