package se.su.dsv.bivsim.pages.Case3.Case3EditingPages.Case3EditFeedBack;

import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;
import se.su.dsv.bivsim.data.Case.dao.interfaces.VirtualAdviserEntityDao;
import se.su.dsv.bivsim.data.Case.dataobjects.VirtualAdviserEntity;
import se.su.dsv.bivsim.pages.Case3.Case3EditingPages.Case3EdittingCommon.BaseClasses.EditingMainPage3;

public class PatientFeedbackEditingPageCase3 extends EditingMainPage3 {
    @SpringBean
    VirtualAdviserEntityDao virtualAdviserEntityDao;
    private TextField filed;

    public PatientFeedbackEditingPageCase3() {


        Form<VirtualAdviserEntity> addfeedbackform;
        addfeedbackform = new Form<VirtualAdviserEntity>("addfeedbackform", new CompoundPropertyModel<VirtualAdviserEntity>((IModel<VirtualAdviserEntity>) this));
        add(addfeedbackform);

        filed = new TextField("field", new Model(""));
        addfeedbackform.add(filed);
        addfeedbackform.add(new Button("button") {

            @Override
            public void onSubmit() {

            }

        });


    }

}
