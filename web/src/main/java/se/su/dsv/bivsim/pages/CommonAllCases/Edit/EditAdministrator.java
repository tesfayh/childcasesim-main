package se.su.dsv.bivsim.pages.CommonAllCases.Edit;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import se.su.dsv.bivsim.data.Case.dao.interfaces.AdminsEntityDao;
import se.su.dsv.bivsim.data.Case.dataobjects.AdminsEntity;
import se.su.dsv.bivsim.pages.CommonAllCases.Edit.BaseClasses.CommonEditingPage;

public class EditAdministrator extends CommonEditingPage {

    @SpringBean
    AdminsEntityDao adminsEntityDao;
    private static final long serialVersionUID = 1L;

    public EditAdministrator() {
        final FeedbackPanel feed = new FeedbackPanel("feed");
        feed.setOutputMarkupId(true);
        add(feed);
        ListView<AdminsEntity> admin = new ListView<AdminsEntity>("List", adminsEntityDao.findAll()) {
            @Override
            protected void populateItem(final ListItem<AdminsEntity> item) {
                item.add(new Label("email", item.getModelObject().getemail()));
                item.add(new Label("name", item.getModelObject().getName()));
                item.add(new Label("orgname", item.getModelObject().getorgName()));
                item.add(new Label("role", item.getModelObject().getrole()));



                item.setOutputMarkupId(true);


                Link<AdminsEntity> link = new AjaxFallbackLink<AdminsEntity>("link", item.getModel()) {

                    @Override
                    public void onClick(AjaxRequestTarget target) {
                        target.add(feed);
                        AdminsEntity entity = adminsEntityDao.load(item.getModelObject().getAminId());
                        if (entity != null) {
                            adminsEntityDao.delete(entity);
                            target.add(item);
/*
                            info("You have deleted an admin successfully");
*/
                            setResponsePage(EditAdministrator.class);
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
