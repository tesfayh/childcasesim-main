package se.su.dsv.bivsim.pages.CommonAllCases.General;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.image.Image;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.resource.PackageResourceReference;
import se.su.dsv.childcasesim.data.Case.dataobjects.ImagingEntity;


public abstract class ImagingSimplePanel extends Panel {
    public ImagingSimplePanel(String id, final IModel<ImagingEntity> model) {
        super(id);
        AjaxLink<ImagingEntity> link = new AjaxLink<ImagingEntity>("link", model) {
            @Override
            public void onClick(AjaxRequestTarget target) {
                clicked(target);
            }
        };
        link.add(new Label("name", model.getObject().getName()));
        add(link);


        add(new Image("image2", new PackageResourceReference(ImagingSimplePanel.class, "File.png")));


    }

    public abstract void clicked(AjaxRequestTarget target);
}
