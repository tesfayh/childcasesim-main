package se.su.dsv.bivsim.pages.Case2.Case2EditingPages.Case2Editphyiscalexam;


import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.PropertyModel;
import se.su.dsv.bivsim.pages.Case2.Case2EditingPages.Case2EdittingCommon.BaseClasses.EditingMainPage2;

import java.util.Arrays;
import java.util.List;

public class PhysicalExamDropDownChoicePageCase2 extends EditingMainPage2 {

    private static final List<String> EDIT_TYPES = Arrays.asList(new String[]{"Skapa status", "Redigera status"});

    private String selected = "Skapa status";
    int index=0;


    public PhysicalExamDropDownChoicePageCase2() {
        DropDownChoice<String> EditLists = new DropDownChoice<String>("EditTpes", new PropertyModel<String>(this, "selected"), EDIT_TYPES);

        Form<?> form = new Form<Void>("Edit") {
            @Override
            protected void onSubmit() {

              /*  if (selected.equals("Create New Physical Exam"))
                    setResponsePage(CreateNewPhysicalExamPageCase1.class);*/
                if (selected.equals("Skapa status"))
                    setResponsePage(new CreateSubPhysicalExamPageCase2(2));
                else
                    setResponsePage(new PhysicalExamTreePageCase2(2));
            }
        };
        add(form);
        form.add(EditLists);

    }
}

