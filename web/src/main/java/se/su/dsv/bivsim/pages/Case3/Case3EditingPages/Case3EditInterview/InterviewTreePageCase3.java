package se.su.dsv.bivsim.pages.Case3.Case3EditingPages.Case3EditInterview;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.extensions.markup.html.repeater.tree.DefaultNestedTree;
import org.apache.wicket.model.IModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import se.su.dsv.bivsim.data.Case.dao.interfaces.InterviewEntityDao;
import se.su.dsv.bivsim.data.Case.dataobjects.InterviewEntity;
import se.su.dsv.bivsim.pages.Case3.Case3Interview.SimplePanel;


public class InterviewTreePageCase3 extends AbstractTreePage {

    @SpringBean
    InterviewEntityDao interviewEntityDao;

    ModalWindow modal;

    private static final long serialVersionUID = 1L;

    /* public void setContent(Panel panel, AjaxRequestTarget target) {
         ((HomePage) getPage()).getContentWmc().replace(panel);
         target.add(((HomePage) getPage()).getContentWmc());
     }
 */
    public InterviewTreePageCase3(int index, String type) {
        //  super(id);


        modal = new ModalWindow("dialog");
        add(modal);
        modal.setInitialWidth(800);
        modal.setInitialHeight(600);
        add(new DefaultNestedTree<InterviewEntity>("tree", new InterviewEntityProvider(interviewEntityDao, index, type)) {
            @Override
            public Component newContentComponent(String id, final IModel<InterviewEntity> model) {
                if (getProvider().hasChildren(model.getObject()))

                    return new InterviewFolder(id, this, model) {

                        @Override
                        public void clicked(AjaxRequestTarget target) {
                            target.prependJavaScript("Wicket.Window.unloadConfirmation = false;");
                            modal.setContent(new EditingexistingInterviewPanel("content", model.getObject()));
                            modal.show(target);

                        }

                    };
                return new SimplePanel(id, model) {
                    @Override
                    public void clicked(AjaxRequestTarget target) {
                        target.prependJavaScript("Wicket.Window.unloadConfirmation = false;");
                        modal.setContent(new EditingexistingInterviewPanel("content", model.getObject()));
                        modal.show(target);
                    }
                };
            }
        });
    }
}