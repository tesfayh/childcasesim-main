package se.su.dsv.bivsim.pages.CommonAllCases.Edit;

import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import se.su.dsv.childcasesim.data.Case.dao.interfaces.AllCasesEntityDao;
import se.su.dsv.childcasesim.data.Case.dataobjects.AllCasesEntity;
import se.su.dsv.childcasesim.pages.Case1.EditingPages.Common.BaseClasses.EditingMainPage1;
import se.su.dsv.childcasesim.pages.Case2.Case2EditingPages.Case2EdittingCommon.BaseClasses.EditingMainPage2;
import se.su.dsv.childcasesim.pages.Case3.Case3EditingPages.Case3EdittingCommon.BaseClasses.EditingMainPage3;
import se.su.dsv.childcasesim.pages.CommonAllCases.Edit.BaseClasses.CommonEditingPage;

import java.util.List;

public class EditExisitingCases extends CommonEditingPage {

    private String selected = "Case1(Karin Nybesök)";
    private static final long serialVersionUID = 1L;
    @SpringBean
    private AllCasesEntityDao allCasesEntityDao;

    private static List<AllCasesEntity> Types;

    public EditExisitingCases() {


        Types = allCasesEntityDao.FindallNotFree();

        DropDownChoice<AllCasesEntity> cases = new DropDownChoice<AllCasesEntity>("cases", new PropertyModel<AllCasesEntity>(this, "selected"),
                Types);
        Form<?> form = new Form("CaseForm") {
            @Override
            public void onSubmit() {

                String Cases = "";
                for (AllCasesEntity caselist2 : Types)
                    if (caselist2.getName().equals(selected))
                        Cases = caselist2.getCases();

                if (Cases.equals("HomePage1"))
                    setResponsePage(EditingMainPage1.class);
                else if (Cases.contains("HomePage2"))
                    setResponsePage(EditingMainPage2.class);
                else if (Cases.contains("HomePage3"))
                    setResponsePage(EditingMainPage3.class);

            }
        };
        add(form);
        form.add(cases);

       /* Link Login = new AjaxFallbackLink("delete") {

            @Override
            public void onClick(AjaxRequestTarget target) {
                setResponsePage(DeleteCase.class);
            }

        };

        this.add(Login);*/

    }
}


