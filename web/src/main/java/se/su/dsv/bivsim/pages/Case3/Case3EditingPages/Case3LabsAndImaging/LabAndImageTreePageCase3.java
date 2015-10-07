package se.su.dsv.bivsim.pages.Case3.Case3EditingPages.Case3LabsAndImaging;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.extensions.markup.html.repeater.tree.DefaultNestedTree;
import org.apache.wicket.model.IModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import se.su.dsv.bivsim.data.Case.dao.interfaces.ImagingEntityDao;
import se.su.dsv.bivsim.data.Case.dataobjects.ImagingEntity;

public class LabAndImageTreePageCase3 extends AbstractTreePage {
    @SpringBean
    private ImagingEntityDao imagingEntityDao;
    ModalWindow modal;

    private static final long serialVersionUID = 1L;

    /* public void setContent(Panel panel, AjaxRequestTarget target) {
         ((HomePage) getPage()).getContentWmc().replace(panel);
         target.add(((HomePage) getPage()).getContentWmc());
     }
 */
    public LabAndImageTreePageCase3(int index) {
        //  super(id);


        modal = new ModalWindow("dialog");
        add(modal);
        modal.setInitialWidth(800);
        modal.setInitialHeight(600);
        add(new DefaultNestedTree<ImagingEntity>("tree", new LabAndImageEntityProvider(imagingEntityDao, index)) {
            @Override
            public Component newContentComponent(String id, final IModel<ImagingEntity> model) {
                if (getProvider().hasChildren(model.getObject()))

                    return new LabAndImageEntityFolder(id, this, model) {

                        @Override
                        public void clicked(AjaxRequestTarget target) {
                            target.prependJavaScript("Wicket.Window.unloadConfirmation = false;");
                            modal.setContent(new EditingexistingLabAndImagePanel3("content", model.getObject()));
                            modal.show(target);

                        }

                    };
                return new SimplePanel(id, model) {
                    @Override
                    public void clicked(AjaxRequestTarget target) {
                        target.prependJavaScript("Wicket.Window.unloadConfirmation = false;");
                        modal.setContent(new EditingexistingLabAndImagePanel3("content", model.getObject()));
                        modal.show(target);
                    }
                };
            }
        });
    }
}