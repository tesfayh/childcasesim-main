package se.su.dsv.bivsim.pages.Case1.physicalexa;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.ListDataProvider;
import org.apache.wicket.spring.injection.annot.SpringBean;
import se.su.dsv.bivsim.data.Case.dao.interfaces.PhysicalExamEntityDao;
import se.su.dsv.bivsim.data.Case.dataobjects.PhysicalExamEntity;
import se.su.dsv.bivsim.pages.Case1.CommonCase1.HomePagephysical;
import se.su.dsv.bivsim.pages.Case1.interview.AbstractTreePanel;
import se.su.dsv.bivsim.pages.Case1.interview.ContentPanel;


public class StatusNonTreePanel extends AbstractTreePanel {
    @SpringBean
    private PhysicalExamEntityDao physicalExamEntityDao;


    private static final long serialVersionUID = 1L;

    public void setContent(Panel panel, AjaxRequestTarget target) {
        ((HomePagephysical) getPage()).getContentWmc().replace(panel);
        target.add(((HomePagephysical) getPage()).getContentWmc());
    }


    public StatusNonTreePanel(String id, Integer cate_ID) {
        super(id);

       // getSession().setAttribute("Physical", "");


        ListDataProvider<PhysicalExamEntity> listDataProvider = new ListDataProvider<PhysicalExamEntity>(physicalExamEntityDao.findAllByGroupId(cate_ID));
        final DataView<PhysicalExamEntity> dataView = new DataView<PhysicalExamEntity>("rows", listDataProvider) {
            @Override
            protected void populateItem(final Item<PhysicalExamEntity> item) {
                final PhysicalExamEntity physicalExamEntity = item.getModelObject();

                AjaxFallbackLink<PhysicalExamEntity> link = new AjaxFallbackLink<PhysicalExamEntity>("link", item.getModel()) {
                    @Override
                    public void onClick(AjaxRequestTarget target) {
                        ContentPanel panel;
                        panel = new PicturePanel("content", physicalExamEntity.getDescription(), physicalExamEntity.getPicId());
                        setContent(panel, target);
                        getSession().setAttribute("Physical", getSession().getAttribute("Physical") + item.getModelObject().getName() + "#");

                    }
                };
                link.add(new Label("name", physicalExamEntity.getName()));
                item.add(link);

            }


        };
        add(dataView);


/*
        add(new DefaultNestedTree<PhysicalExamEntity>("tree", new PhysicalExamEntityProvider(physicalExamEntityDao)) {
            @Override
            public Component newContentComponent(String id, final IModel<PhysicalExamEntity> model) {
                if (getProvider().hasChildren(model.getObject()))

                    return new Folder<PhysicalExamEntity>(id, this, model) {


                    };


                return new PhysicalExamSimplePanel(id, model) {
                    @Override
                    public void clicked(AjaxRequestTarget target) {

                        ContentPanel panel = new PicturePanel("content", model.getObject().getDescription(), model.getObject().getPicId());
                        setContent(panel, target);
                        getSession().setAttribute("Physical", getSession().getAttribute("Physical") + model.getObject().getName() + "#");


                    }
                };
            }
        });

        */


    }


}