package se.su.dsv.bivsim.pages.CommonAllCases.General;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.image.Image;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.resource.PackageResourceReference;
import se.su.dsv.childcasesim.data.Case.dataobjects.InterviewEntity;

public abstract class InterviewSimplePanel extends Panel {
    public InterviewSimplePanel(String id, final IModel<InterviewEntity> model) {
        super(id);
        AjaxLink<InterviewEntity> link = new AjaxLink<InterviewEntity>("link", model) {
            @Override
            public void onClick(AjaxRequestTarget target) {
                clicked(target);
            }
        };
        link.add(new Label("name", model.getObject().getName()));
        add(link);

/*
        PackageResourceReference resourceReference =
                new PackageResourceReference(SimplePanel.class, "File.png");

        CharSequence urlForVideo = urlFor(resourceReference, new PageParameters());
        add(new ExternalLink("image", urlForVideo.toString()));*/


        add(new Image("image2", new PackageResourceReference(InterviewSimplePanel.class, "File.png")));

    }
    public abstract void clicked(AjaxRequestTarget target);
}
