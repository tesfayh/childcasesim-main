package se.su.dsv.bivsim.pages.CommonAllCases.Edit;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import se.su.dsv.childcasesim.data.Case.dao.interfaces.AllCasesEntityDao;
import se.su.dsv.childcasesim.data.Case.dataobjects.AllCasesEntity;
import se.su.dsv.childcasesim.pages.CommonAllCases.Edit.BaseClasses.CommonEditingPage;

import java.util.List;

public class DeleteCase extends CommonEditingPage {

    @SpringBean
    AllCasesEntityDao allCasesEntityDao;
    private static final long serialVersionUID = 1L;

    public DeleteCase() {
        final FeedbackPanel feed = new FeedbackPanel("feed");
        feed.setOutputMarkupId(true);
        add(feed);

        List<AllCasesEntity> Objects = allCasesEntityDao.FindallNotFree();
        ListView<AllCasesEntity> admin = new ListView<AllCasesEntity>("List", Objects.subList(2, Objects.toArray().length)) {
            // 2 up to  array length...It is not safe to delete the already avialble cases 1 and case 2
            @Override
            protected void populateItem(final ListItem<AllCasesEntity> item) {
                item.add(new Label("name", item.getModelObject().getName()));
                item.setOutputMarkupId(true);

                Link<AllCasesEntity> link = new AjaxFallbackLink<AllCasesEntity>("link", item.getModel()) {

                    @Override
                    public void onClick(AjaxRequestTarget target) {
                        target.add(feed);
                        AllCasesEntity entity = allCasesEntityDao.load(item.getModelObject().getCaseId());
                        if (entity != null) {
                            entity.setName("Free");
                            allCasesEntityDao.save(entity);
                            target.add(item);
                            info("You have deleted a case successfully");
                            this.setResponsePage(DeleteCase.class);
                        }

                    }
                };
                link.setOutputMarkupId(true);
                item.add(link);


            }

            ;

        };
        add(admin);
    }
}