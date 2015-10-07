package se.su.dsv.bivsim.pages.Case3.Case3EditingPages.Case3LabsAndImaging;

import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.PropertyModel;
import se.su.dsv.bivsim.pages.Case3.Case3EditingPages.Case3EdittingCommon.BaseClasses.EditingMainPage3;

import java.util.Arrays;
import java.util.List;

public class LabAndImageDropDownChoicePageCase3 extends EditingMainPage3 {

    private static final List<String> EDIT_TYPES = Arrays.asList(new String[]{"Skapa lab", "Redigera lab"});
    private String selected = "Skapa lab";
    private static final List<String> EDIT_categories = Arrays.asList(new String[]{"Klin Kemi", "Mikrobiologi", "Fysiologi", "Bild/Rtg"});
    private String selected2 = "Klin Kemi";
    int index;

    public LabAndImageDropDownChoicePageCase3() {
        DropDownChoice<String> EditLists = new DropDownChoice<String>("EditTpes", new PropertyModel<String>(this, "selected"), EDIT_TYPES);
        DropDownChoice<String> EditLists2 = new DropDownChoice<String>("EditTpes2", new PropertyModel<String>(this, "selected2"), EDIT_categories);

        Form<?> form = new Form<Void>("Edit") {
            @Override
            protected void onSubmit() {
                if(selected2.equals("Klin Kemi"))
                    index=9;
                if(selected2.equals("Mikrobiologi"))
                    index=11;
                if(selected2.equals("Fysiologi"))
                    index=12;
                if(selected2.equals("Bild/Rtg"))
                    index=13;
               /* if (selected.equals("Create Sub-Imaging"))
                    setResponsePage(CreateNewLabAndImagePageCase1.class);*/
                if (selected.equals("Skapa lab"))
                    setResponsePage(new CreateSubLabAndImagePageCase3(index));
                else
                    setResponsePage(new LabAndImageTreePageCase3(index));
            }
        };
        add(form);
        form.add(EditLists);
        form.add(EditLists2);
    }
}

