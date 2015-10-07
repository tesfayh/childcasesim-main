package se.su.dsv.bivsim.pages.Case1.EditingPages.Common;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.FormComponent;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import se.su.dsv.bivsim.data.Case.dao.interfaces.ReportEntityDao;
import se.su.dsv.bivsim.data.Case.dataobjects.ReportEntity;
import se.su.dsv.bivsim.pages.Case1.EditingPages.Common.BaseClasses.EditingMainPage1;

public class ReportChange extends EditingMainPage1 {
    private String name;
    private String comment;
    @SpringBean
    ReportEntityDao reportEntityDao;

    public ReportChange() {
        FeedbackPanel feed = new FeedbackPanel("feed");
        feed.setOutputMarkupId(true);
        add(feed);
        final FormComponent name = new TextArea("name", new PropertyModel(this, "name")).setRequired(true);
        final FormComponent comment = new TextArea("comment", new PropertyModel(this, "comment")).setRequired(true);

        Form<?> form = new Form("form") {
            @Override
            public void onSubmit() {
                ReportEntity entity = new ReportEntity();
                entity.setGroupId(1);
                entity.setName(name.getModelObject().toString());
                entity.setComment(comment.getModelObject().toString());
                reportEntityDao.save(entity);

                info(" Comment submitted");
            }
        };
        add(form);
        form.add(name);
        form.add(comment);
        Link link = new Link("link") {
            @Override
            public void onClick() {
                this.setResponsePage(ViewReport.class);
            }

        };
        add(link);
    }
}
