package se.su.dsv.bivsim.pages.Case1.imaging;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.extensions.markup.html.repeater.tree.DefaultNestedTree;
import org.apache.wicket.extensions.markup.html.repeater.tree.content.Folder;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import se.su.dsv.bivsim.data.Case.dao.interfaces.ImagingEntityDao;
import se.su.dsv.bivsim.data.Case.dataobjects.ImagingEntity;
import se.su.dsv.bivsim.pages.Case1.CommonCase1.HomeLabs;
import se.su.dsv.bivsim.pages.Case1.interview.AbstractTreePanel;
import se.su.dsv.bivsim.pages.Case1.interview.ContentPanel;
import se.su.dsv.bivsim.pages.Case1.physicalexa.PicturePanel;


public class ImagingTreePanel extends AbstractTreePanel {
    @SpringBean
    private ImagingEntityDao imagingEntityDao;


    private static final long serialVersionUID = 1L;

    public void setContent(Panel panel, AjaxRequestTarget target) {
        ((HomeLabs) getPage()).getContentWmc().replace(panel);
        target.add(((HomeLabs) getPage()).getContentWmc());
    }


    public ImagingTreePanel(String id, final Integer cate_ID) {
        super(id);

        add(new DefaultNestedTree<ImagingEntity>("tree", new ImagingEntityProvider(imagingEntityDao, cate_ID)) {
            @Override
            public Component newContentComponent(String id, final IModel<ImagingEntity> model) {
                if (getProvider().hasChildren(model.getObject()))

                    return new Folder<ImagingEntity>(id, this, model) {

                    };
                return new ImagingSimplePanel(id, model) {
                    @Override
                    public void clicked(AjaxRequestTarget target) {

                        getSession().setAttribute("exLab", (Integer) getSession().getAttribute("exLab") + 1);

                        ContentPanel panel = new PicturePanel("content", model.getObject().getDescription(), model.getObject().getPicId());
                        setContent(panel, target);

                        if (model.getObject().getPicId() != null && model.getObject().getDescription() != null)
                            getSession().setAttribute("Imaging", getSession().getAttribute("Imaging") + model.getObject().getName() + "#");

                    }
                };
            }
        });


    }
}