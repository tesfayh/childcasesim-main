package se.su.dsv.bivsim.pages.Case1.EditingPages.EditFeedBack;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import se.su.dsv.bivsim.data.Case.dao.interfaces.VirtualAdviserEntityDao;
import se.su.dsv.bivsim.data.Case.dataobjects.VirtualAdviserEntity;
import se.su.dsv.bivsim.pages.Case1.EditingPages.Common.BaseClasses.EditingMainPage1;

import java.util.List;

public class VirtualAdviserEntityEditingPageCase1 extends EditingMainPage1 {

    @SpringBean
    VirtualAdviserEntityDao virtualAdviserEntityDao;

    ListView<VirtualAdviserEntity> listView;

    ModalWindow modal;
    List<VirtualAdviserEntity> lists;

    public VirtualAdviserEntityEditingPageCase1() {
        modal = new ModalWindow("dialog");
        add(modal);
        lists = virtualAdviserEntityDao.findAllByGroupId(1);

        listView = new ListView<VirtualAdviserEntity>("list", new PropertyModel<List<VirtualAdviserEntity>>(this, "lists")) {

            private static final long serialVersionUID = 1L;

            @Override
            protected void populateItem(final ListItem<VirtualAdviserEntity> item) {
                item.setOutputMarkupId(true);
                VirtualAdviserEntity ad = item.getModelObject();
                item.add(new AjaxLink<String>("edit_link") {
                    @Override
                    public void onClick(AjaxRequestTarget target) {
                        target.prependJavaScript("Wicket.Window.unloadConfirmation = false;");
                        modal.setContent(new VirtualAdviserEntityPanel("content", item.getModel()));
                        modal.show(target);
                    }
                });
                item.add(new Label("feedback", item.getModelObject().getFeedbackGroup()));
                item.add(new Label("feedback2", item.getModelObject().getFeedbackValue()));

               /* item.add(new AjaxLink<String>("delete") {
                    @Override
                    public void onClick(AjaxRequestTarget target) {
                     virtualAdviserEntityDao.delete(item.getModelObject());
                     target.add(item);
                    }
                });*/

            }
        };
        listView.setOutputMarkupId(true);
        add(listView);
    }
}
