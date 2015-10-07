package se.su.dsv.bivsim.pages.Case1.physicalexa;

/**
 * Created with IntelliJ IDEA.
 * User: kebede
 * Date: 12/05/13
 * Time: 19:03
 * To change this template use File | Settings | File Templates.
 */

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import se.su.dsv.bivsim.data.Case.dataobjects.PhysicalExamEntity;


public abstract class PhysicalExamSimplePanel extends Panel {


    public PhysicalExamSimplePanel(String id, final IModel<PhysicalExamEntity> model) {
        super(id);
        AjaxLink<PhysicalExamEntity> link = new AjaxLink<PhysicalExamEntity>("link", model) {
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
