package se.su.dsv.bivsim.pages.Case1.EditingPages.EditAssessment;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;
import se.su.dsv.bivsim.data.Case.dao.interfaces.FollowUpEntityDoa;
import se.su.dsv.bivsim.data.Case.dataobjects.FollowUpEntity;
import se.su.dsv.bivsim.pages.Case1.EditingPages.Common.BaseClasses.EditingMainPage1;

/**
 * Created with IntelliJ IDEA.
 * User: kebede
 * Date: 04/10/13
 * Time: 14:38
 * To change this template use File | Settings | File Templates.
 */
public class EditFollowUpPage extends EditingMainPage1 {

    @SpringBean
    FollowUpEntityDoa followUpEntityDoa;

    public EditFollowUpPage() {

        final FeedbackPanel feed = new FeedbackPanel("feed");
        feed.setOutputMarkupId(true);
        add(feed);

        final TextArea<String> ExpertOp1 = new TextArea<String>("ExpertOp1", new Model<String>(followUpEntityDoa.findObject(1).getExpertOpinion()));

        final TextArea<String> ExpertOp2 = new TextArea<String>("ExpertOp2", new Model<String>(followUpEntityDoa.findObject(2).getExpertOpinion()));

        final Form<?> form = new Form<Void>("Form") {
            @Override
            public void onSubmit() {
                FollowUpEntity entity1 = followUpEntityDoa.load((long) 1);
                FollowUpEntity entity2 = followUpEntityDoa.load((long) 2);
                entity1.setExpertOpinion(ExpertOp1.getModelObject());
                entity2.setExpertOpinion(ExpertOp2.getModelObject());
                followUpEntityDoa.save(entity1);
                followUpEntityDoa.save(entity2);
                info("You have updated the expert's Follow up recommendation sucessfuly");
            }
        };
        add(form);
        form.add(ExpertOp1);
        form.add(ExpertOp2);


    }
}
