package se.su.dsv.bivsim.pages.Case1.EditingPages.EditInterview;


import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.PropertyModel;
import se.su.dsv.bivsim.pages.Case1.EditingPages.Common.BaseClasses.EditingMainPage1;


import java.util.Arrays;
import java.util.List;

public class EditInterviewDropDownChoicePageCase1 extends EditingMainPage1 {

    private static final List<String> EDIT_TYPES = Arrays.asList(new String[]{"Skapa frågor", "Redigera frågor"});
    private static final List<String> EDIT_categories = Arrays.asList(new String[]{"Introduktion", "Aktuellt", "Tidigare sjd", "Socialt", "Hereditet", "Medicinering", "Allergier", "Levnadsvanor"});
    private String selected = "Skapa frågor";
    private String selected2 = "Introduktion";
    private int index = 0;




    public EditInterviewDropDownChoicePageCase1() {
        DropDownChoice<String> EditLists = new DropDownChoice<String>("EditTpes", new PropertyModel<String>(this, "selected"), EDIT_TYPES);
        DropDownChoice<String> EditLists2 = new DropDownChoice<String>("EditTpes2", new PropertyModel<String>(this, "selected2"), EDIT_categories);
        Form<?> form = new Form<Void>("Edit") {
            @Override
            protected void onSubmit() {
                if(selected2.equals("Introduktion"))
                index=1;
                if(selected2.equals("Aktuellt"))
                index=2;
                if(selected2.equals("Tidigare sjd"))
                    index=3;
                if(selected2.equals("Socialt"))
                    index=4;
                if(selected2.equals("Hereditet"))
                    index=5;
                if(selected2.equals("Medicinering"))
                    index=8;
                if(selected2.equals("Allergier"))
                    index=7;
                if(selected2.equals("Levnadsvanor"))
                    index=9;

               /* if (selected.equals("Create New Interview"))
                    setResponsePage(CreateNewInterviewPageCase1.class);*/
                if (selected.equals("Skapa frågor"))
                    setResponsePage(new CreateSubInterviewPageCase1(index, "m"));
                else
                    setResponsePage(new InterviewTreePageCase1(index, "m"));
            }
        };
        add(form);
        form.add(EditLists);
        form.add(EditLists2);

    }
}

