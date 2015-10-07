package se.su.dsv.bivsim.pages.Case3.Case3EditingPages.Case3Editphyiscalexam;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.extensions.markup.html.repeater.tree.DefaultNestedTree;
import org.apache.wicket.model.IModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import se.su.dsv.bivsim.data.Case.dao.interfaces.PhysicalExamEntityDao;
import se.su.dsv.bivsim.data.Case.dataobjects.PhysicalExamEntity;


public class PhysicalExamTreePageCase3 extends AbstractTreePage {

    @SpringBean
    PhysicalExamEntityDao physicalExamEntityDao;

    ModalWindow modal;

    private static final long serialVersionUID = 1L;

    /* public void setContent(Panel panel, AjaxRequestTarget target) {
         ((HomePage) getPage()).getContentWmc().replace(panel);
         target.add(((HomePage) getPage()).getContentWmc());
     }
 */
    public PhysicalExamTreePageCase3(int index) {
        //  super(id);


        modal = new ModalWindow("dialog");
        add(modal);
        modal.setInitialWidth(800);
        modal.setInitialHeight(600);
        add(new DefaultNestedTree<PhysicalExamEntity>("tree", new PhysicalExamEntityProvider(physicalExamEntityDao, index)) {
            @Override
            public Component newContentComponent(String id, final IModel<PhysicalExamEntity> model) {
                if (getProvider().hasChildren(model.getObject()))

                    return new PhysicalExamEntityFolder(id, this, model) {

                        @Override
                        public void clicked(AjaxRequestTarget target) {
                            target.prependJavaScript("Wicket.Window.unloadConfirmation = false;");
                            modal.setContent(new EditingexistingPhysicalExamPanel3("content", model.getObject()));
                            modal.show(target);

                        }

                    };
                return new SimplePanel(id, model) {
                    @Override
                    public void clicked(AjaxRequestTarget target) {
                        target.prependJavaScript("Wicket.Window.unloadConfirmation = false;");
                        modal.setContent(new EditingexistingPhysicalExamPanel3("content", model.getObject()));
                        modal.show(target);
                    }
                };
            }
        });
    }
}