package se.su.dsv.bivsim.pages.Case2.Case2Physicalexa;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.extensions.markup.html.repeater.tree.DefaultNestedTree;
import org.apache.wicket.extensions.markup.html.repeater.tree.content.Folder;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import se.su.dsv.bivsim.data.Case.dao.interfaces.PhysicalExamEntityDao;
import se.su.dsv.bivsim.data.Case.dataobjects.PhysicalExamEntity;
import se.su.dsv.bivsim.pages.Case2.Case2Common.HomeCase2Pagephysical;
import se.su.dsv.bivsim.pages.Case2.Case2Interview.AbstractTreePanel;
import se.su.dsv.bivsim.pages.Case2.Case2Interview.ContentPanel;


public class PhysicalExamTreePanel extends AbstractTreePanel {
    @SpringBean
    private PhysicalExamEntityDao physicalExamEntityDao;


    private static final long serialVersionUID = 1L;

    public void setContent(Panel panel, AjaxRequestTarget target) {
        ((HomeCase2Pagephysical) getPage()).getContentWmc().replace(panel);
        target.add(((HomeCase2Pagephysical) getPage()).getContentWmc());
    }


    public PhysicalExamTreePanel(String id, final Integer groupID) {
        super(id);

        // getSession().setAttribute("Physical", 0);


       /* ListDataProvider< PhysicalExamEntity> listDataProvider = new ListDataProvider< PhysicalExamEntity>(physicalExamEntityDao.findAll());
        final DataView< PhysicalExamEntity> dataView = new DataView< PhysicalExamEntity>("rows", listDataProvider) {
            @Override
            protected void populateItem(Item< PhysicalExamEntity> item) {
                final  PhysicalExamEntity physicalExamEntity = item.getModelObject();

                AjaxFallbackLink< PhysicalExamEntity> link = new AjaxFallbackLink< PhysicalExamEntity>("link", item.getModel()) {
                    @Override
                    public void onClick(AjaxRequestTarget target) {
                        ContentPanel panel;
                        panel = new PicturePanel("content", physicalExamEntity.getDescription(), physicalExamEntity.getPicId());
                        setContent(panel, target);
                    }
                };
                link.add(new Label("name", physicalExamEntity.getName()));
                item.add(link);

            }


        };*/


        add(new DefaultNestedTree<PhysicalExamEntity>("tree", new PhysicalExamEntityProvider(physicalExamEntityDao, groupID)) {
            @Override
            public Component newContentComponent(String id, final IModel<PhysicalExamEntity> model) {
                if (getProvider().hasChildren(model.getObject()))

                    return new Folder<PhysicalExamEntity>(id, this, model) {


                    };


                return new PhysicalExamSimplePanel(id, model) {
                    @Override
                    public void clicked(AjaxRequestTarget target) {

                        getSession().setAttribute("exPhysical", (Integer) getSession().getAttribute("exPhysical") + 1);

                        ContentPanel panel = new PicturePanel("content", model.getObject().getDescription(), model.getObject().getPicId());
                        setContent(panel, target);
                        //getSession().setAttribute("Physical", getSession().getAttribute("Physical") + model.getObject().getName() + "#");


                    }
                };
            }
        });


    }


}