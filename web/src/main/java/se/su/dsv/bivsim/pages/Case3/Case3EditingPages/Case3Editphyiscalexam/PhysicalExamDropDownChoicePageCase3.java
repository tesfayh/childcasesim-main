package se.su.dsv.bivsim.pages.Case3.Case3EditingPages.Case3Editphyiscalexam;


import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.PropertyModel;
import se.su.dsv.bivsim.pages.Case3.Case3EditingPages.Case3EdittingCommon.BaseClasses.EditingMainPage3;

import java.util.Arrays;
import java.util.List;

public class PhysicalExamDropDownChoicePageCase3 extends EditingMainPage3 {

    private static final List<String> EDIT_TYPES = Arrays.asList(new String[]{"Skapa status", "Redigera status"});

    private String selected = "Skapa status";
    int index=0;


    public PhysicalExamDropDownChoicePageCase3() {
        DropDownChoice<String> EditLists = new DropDownChoice<String>("EditTpes", new PropertyModel<String>(this, "selected"), EDIT_TYPES);

        Form<?> form = new Form<Void>("Edit") {
            @Override
            protected void onSubmit() {

              /*  if (selected.equals("Create New Physical Exam"))
                    setResponsePage(CreateNewPhysicalExamPageCase1.class);*/
                if (selected.equals("Skapa status"))
                    setResponsePage(new CreateSubPhysicalExamPageCase3(3));
                else
                    setResponsePage(new PhysicalExamTreePageCase3(3));
            }
        };
        add(form);
        form.add(EditLists);

    }
}

