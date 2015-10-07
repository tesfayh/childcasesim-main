package se.su.dsv.bivsim.pages.Case1.EditingPages.LabsAndImaging;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import se.su.dsv.bivsim.data.Case.dataobjects.ImagingEntity;


public abstract class SimplePanel extends Panel {
    public SimplePanel(String id, final IModel<ImagingEntity> model) {
        super(id);
        AjaxLink<ImagingEntity> link = new AjaxLink<ImagingEntity>("link", model) {
            @Override
            public void onClick(AjaxRequestTarget target) {
                clicked(target);
            }
        };
        link.add(new Label("name", model.getObject().getName()));
        add(link);

    }


    public abstract void clicked(AjaxRequestTarget target);
}
