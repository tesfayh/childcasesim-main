package se.su.dsv.bivsim.pages.Case2.Case2EditingPages.Case2EditInterview;


import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.PropertyModel;
import se.su.dsv.bivsim.pages.Case2.Case2EditingPages.Case2EdittingCommon.BaseClasses.EditingMainPage2;

import java.util.Arrays;
import java.util.List;

public class EditInterviewDropDownChoicePageCase2 extends EditingMainPage2 {

    private static final List<String> EDIT_TYPES = Arrays.asList(new String[]{"Skapa frågor", "Redigera frågor"});
    private static final List<String> EDIT_categories = Arrays.asList(new String[]{"Introduktion", "Aktuellt", "Tidigare sjd", "Socialt", "Hereditet", "Medicinering", "Allergier", "Levnadsvanor"});
    private String selected = "Skapa frågor";
    private String selected2 = "Introduktion";
    private int index = 0;




    public EditInterviewDropDownChoicePageCase2() {
        DropDownChoice<String> EditLists = new DropDownChoice<String>("EditTpes", new PropertyModel<String>(this, "selected"), EDIT_TYPES);
        DropDownChoice<String> EditLists2 = new DropDownChoice<String>("EditTpes2", new PropertyModel<String>(this, "selected2"), EDIT_categories);
        Form<?> form = new Form<Void>("Edit") {
            @Override
            protected void onSubmit() {
                if(selected2.equals("Introduktion"))
                index=10;
                if(selected2.equals("Aktuellt"))
                index=11;
                if(selected2.equals("Tidigare sjd"))
                    index=12;
                if(selected2.equals("Socialt"))
                    index=13;
                if(selected2.equals("Hereditet"))
                    index=14;
                if(selected2.equals("Medicinering"))
                    index=15;
                if(selected2.equals("Allergier"))
                    index=16;
                if(selected2.equals("Levnadsvanor"))
                    index=17;

               /* if (selected.equals("Create New Interview"))
                    setResponsePage(CreateNewInterviewPageCase1.class);*/
                if (selected.equals("Skapa frågor"))
                    setResponsePage(new CreateSubInterviewPageCase2(index, "m"));
                else
                    setResponsePage(new InterviewTreePageCase2(index, "m"));
            }
        };
        add(form);
        form.add(EditLists);
        form.add(EditLists2);

    }
}

