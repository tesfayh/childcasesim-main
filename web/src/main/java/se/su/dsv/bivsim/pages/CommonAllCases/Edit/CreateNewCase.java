package se.su.dsv.bivsim.pages.CommonAllCases.Edit;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import se.su.dsv.childcasesim.data.Case.dao.interfaces.AllCasesEntityDao;
import se.su.dsv.childcasesim.data.Case.dataobjects.AllCasesEntity;
import se.su.dsv.childcasesim.pages.CommonAllCases.Edit.BaseClasses.CommonEditingPage;

import java.util.List;

public class CreateNewCase extends CommonEditingPage {
    private String caseName;
    @SpringBean
    AllCasesEntityDao allCasesEntityDoa;
    String CasesToCreate;
    Boolean contains;
    private int i = 0;

    List<AllCasesEntity> casesEntity;

    public CreateNewCase() {

        casesEntity = allCasesEntityDoa.findAll();
        final TextArea<String> textAreaallcases = new TextArea<String>("CaseName", new PropertyModel<String>(this, "caseName"));

        Form<?> form = new Form("NewCaseForm") {

            @Override
            public void onSubmit() {

                int i = 0;
                for (AllCasesEntity cas : casesEntity) {
                    if (cas.getName().equals("Free")) {
                        AllCasesEntity entity = allCasesEntityDoa.load(cas.getCaseId());
                        entity.setName(caseName);
                        allCasesEntityDoa.save(entity);
                        i++;
                    }
                    if (i > 0)
                        break;
                }
                if (i == 0)
                    info("You have created maximum Cases");
                else
                    info("You have created a new case successful");
            }

        };
        add(form);

        form.add(textAreaallcases);
        FeedbackPanel feedback = new FeedbackPanel("feedback");
        form.add(feedback);

    }

}
