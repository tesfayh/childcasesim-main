package se.su.dsv.bivsim.pages.Case2.Case2Imaging;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.extensions.markup.html.repeater.tree.DefaultNestedTree;
import org.apache.wicket.extensions.markup.html.repeater.tree.content.Folder;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import se.su.dsv.childcasesim.data.Case.dao.interfaces.ImagingEntityDao;
import se.su.dsv.childcasesim.data.Case.dataobjects.ImagingEntity;
import se.su.dsv.childcasesim.pages.Case2.Case2Common.HomeCase2Labs;
import se.su.dsv.childcasesim.pages.CommonAllCases.General.ImageResourceReference2;
import se.su.dsv.childcasesim.pages.CommonAllCases.Imaging.ImagingEntityProvider;
import se.su.dsv.childcasesim.pages.CommonAllCases.General.ImagingSimplePanel;
import se.su.dsv.childcasesim.pages.CommonAllCases.General.PicturePanel;


public class ImagingTreePanel2 extends Panel {
    @SpringBean
    private ImagingEntityDao imagingEntityDao;


    private static final long serialVersionUID = 1L;

    public void setContent(Panel panel, AjaxRequestTarget target) {
        ((HomeCase2Labs) getPage()).getContentWmc().replace(panel);
        target.add(((HomeCase2Labs) getPage()).getContentWmc());
    }


    public ImagingTreePanel2(String id, final Integer groupID) {
        super(id);
        getSession().setAttribute("Imaging", "");


        add(new DefaultNestedTree<ImagingEntity>("tree", new ImagingEntityProvider(imagingEntityDao, groupID)) {
            @Override
            public Component newContentComponent(String id, final IModel<ImagingEntity> model) {
                if (getProvider().hasChildren(model.getObject()))

                    return new Folder<ImagingEntity>(id, this, model) {

                    };
                return new ImagingSimplePanel(id, model) {
                    @Override
                    public void clicked(AjaxRequestTarget target) {

                        getSession().setAttribute("exLab", (Integer) getSession().getAttribute("exLab") + 1);

                        PicturePanel panel = new PicturePanel("content", model.getObject().getDescription(), model.getObject().getPicId(), new ImageResourceReference2());
                        setContent(panel, target);

                        if (model.getObject().getPicId() != null && model.getObject().getDescription() != null)
                            getSession().setAttribute("Imaging", getSession().getAttribute("Imaging") + model.getObject().getName() + "#");

                    }
                };
            }
        });


    }
}