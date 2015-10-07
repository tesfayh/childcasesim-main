package se.su.dsv.bivsim.pages.Case2.Case2EditingPages.Case2Editphyiscalexam;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.extensions.markup.html.repeater.tree.DefaultNestedTree;
import org.apache.wicket.model.IModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import se.su.dsv.bivsim.data.Case.dao.interfaces.PhysicalExamEntityDao;
import se.su.dsv.bivsim.data.Case.dataobjects.PhysicalExamEntity;
import se.su.dsv.bivsim.pages.Case2.Case2Interview.AbstractTreePanel;

public abstract class SelectParentTreePanel extends AbstractTreePanel {

    @SpringBean
    PhysicalExamEntityDao physicalExamEntityDao;


    private static final long serialVersionUID = 1L;

    public SelectParentTreePanel(String id, int index) {
        super(id);

        add(new DefaultNestedTree<PhysicalExamEntity>("tree", new PhysicalExamEntityProvider(physicalExamEntityDao, index)) {
            @Override
            public Component newContentComponent(String id, final IModel<PhysicalExamEntity> model) {
                if (getProvider().hasChildren(model.getObject()))

                    return new PhysicalExamEntityFolder(id, this, model) {

                        @Override
                        public void clicked(AjaxRequestTarget target) {

                            pressed(model.getObject(), target);

                        }

                    };
                return new SimplePanel(id, model) {
                    @Override
                    public void clicked(AjaxRequestTarget target) {

                        pressed(model.getObject(), target);

                    }
                };
            }
        });
    }

    public abstract void pressed(PhysicalExamEntity entity, AjaxRequestTarget target);
}