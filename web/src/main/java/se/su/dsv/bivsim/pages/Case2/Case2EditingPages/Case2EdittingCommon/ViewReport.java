package se.su.dsv.bivsim.pages.Case2.Case2EditingPages.Case2EdittingCommon;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigator;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.ListDataProvider;
import org.apache.wicket.spring.injection.annot.SpringBean;
import se.su.dsv.bivsim.data.Case.dao.interfaces.ReportEntityDao;
import se.su.dsv.bivsim.data.Case.dataobjects.ReportEntity;
import se.su.dsv.bivsim.pages.Case2.Case2EditingPages.Case2EdittingCommon.BaseClasses.EditingMainPage2;

import java.util.List;

public class ViewReport extends EditingMainPage2 {
    @SpringBean
    ReportEntityDao reportEntityDao;

    public ViewReport() {

        List<ReportEntity> list = reportEntityDao.findAllByGroupId(1);
        final DataView dataView = new DataView("simple", new ListDataProvider(
                list)) {
            public void populateItem(final Item item) {
                final ReportEntity report = (ReportEntity) item.getModelObject();

                item.add(new Label("name", report.getName()));
                item.add(new Label("comment", report.getComment()));
                Link link = new Link("link") {
                    @Override
                    public void onClick() {
                        ReportEntity tobedeleted = reportEntityDao.load(((ReportEntity) item.getModelObject()).getReportId());
                        reportEntityDao.delete(tobedeleted);
                        setResponsePage(ViewReport.class);

                    }
                };
                item.add(link);

            }

        };
        dataView.setItemsPerPage(1);

        add(dataView);

        add(new PagingNavigator("navigator", dataView));

    }

}
