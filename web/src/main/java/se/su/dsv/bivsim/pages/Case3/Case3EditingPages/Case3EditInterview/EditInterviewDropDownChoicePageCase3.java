package se.su.dsv.bivsim.pages.Case3.Case3EditingPages.Case3EditInterview;


import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.PropertyModel;
import se.su.dsv.bivsim.pages.Case3.Case3EditingPages.Case3EdittingCommon.BaseClasses.EditingMainPage3;

import java.util.Arrays;
import java.util.List;

public class EditInterviewDropDownChoicePageCase3 extends EditingMainPage3 {

    private static final List<String> EDIT_TYPES = Arrays.asList(new String[]{"Skapa frågor", "Redigera frågor"});
    private static final List<String> EDIT_categories = Arrays.asList(new String[]{"Introduktion", "Aktuellt", "Tidigare sjd", "Socialt", "Hereditet", "Medicinering", "Allergier", "Levnadsvanor"});
    private String selected = "Skapa frågor";
    private String selected2 = "Introduktion";
    private int index = 0;




    public EditInterviewDropDownChoicePageCase3() {
        DropDownChoice<String> EditLists = new DropDownChoice<String>("EditTpes", new PropertyModel<String>(this, "selected"), EDIT_TYPES);
        DropDownChoice<String> EditLists2 = new DropDownChoice<String>("EditTpes2", new PropertyModel<String>(this, "selected2"), EDIT_categories);
        Form<?> form = new Form<Void>("Edit") {
            @Override
            protected void onSubmit() {
                if(selected2.equals("Introduktion"))
                index=18;
                if(selected2.equals("Aktuellt"))
                index=19;
                if(selected2.equals("Tidigare sjd"))
                    index=20;
                if(selected2.equals("Socialt"))
                    index=21;
                if(selected2.equals("Hereditet"))
                    index=22;
                if(selected2.equals("Medicinering"))
                    index=23;
                if(selected2.equals("Allergier"))
                    index=24;
                if(selected2.equals("Levnadsvanor"))
                    index=25;

               /* if (selected.equals("Create New Interview"))
                    setResponsePage(CreateNewInterviewPageCase1.class);*/
                if (selected.equals("Skapa frågor"))
                    setResponsePage(new CreateSubInterviewPageCase3(index, "m"));
                else
                    setResponsePage(new InterviewTreePageCase3(index, "m"));
            }
        };
        add(form);
        form.add(EditLists);
        form.add(EditLists2);

    }
}

