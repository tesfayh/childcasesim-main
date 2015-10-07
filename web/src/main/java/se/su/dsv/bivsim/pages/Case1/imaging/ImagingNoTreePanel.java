package se.su.dsv.bivsim.pages.Case1.imaging;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigator;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.ListDataProvider;
import org.apache.wicket.spring.injection.annot.SpringBean;
import se.su.dsv.bivsim.data.Case.dao.interfaces.ImagingEntityDao;
import se.su.dsv.bivsim.data.Case.dataobjects.ImagingEntity;
import se.su.dsv.bivsim.pages.Case1.CommonCase1.HomeLabs;
import se.su.dsv.bivsim.pages.Case1.interview.AbstractTreePanel;
import se.su.dsv.bivsim.pages.Case1.interview.ContentPanel;
import se.su.dsv.bivsim.pages.Case1.physicalexa.PicturePanel;


public class ImagingNoTreePanel extends AbstractTreePanel {
    @SpringBean
    private ImagingEntityDao physicalExamEntityDao;


    private static final long serialVersionUID = 1L;

    public void setContent(Panel panel, AjaxRequestTarget target) {
        ((HomeLabs) getPage()).getContentWmc().replace(panel);
        target.add(((HomeLabs) getPage()).getContentWmc());
    }


    public ImagingNoTreePanel(String id, Integer cate_ID) {
        super(id);

        getSession().setAttribute("Physical", "");


        ListDataProvider<ImagingEntity> listDataProvider = new ListDataProvider<ImagingEntity>(physicalExamEntityDao.findAllByGroupId(cate_ID));
        final DataView<ImagingEntity> dataView = new DataView<ImagingEntity>("rows", listDataProvider) {
            @Override
            protected void populateItem(Item<ImagingEntity> item) {
                final ImagingEntity physicalExamEntity = item.getModelObject();

                AjaxFallbackLink<ImagingEntity> link = new AjaxFallbackLink<ImagingEntity>("link", item.getModel()) {
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


        };
        dataView.setItemsPerPage(100);
        add(dataView);
        add(new PagingNavigator("pagingNavigator", dataView));






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