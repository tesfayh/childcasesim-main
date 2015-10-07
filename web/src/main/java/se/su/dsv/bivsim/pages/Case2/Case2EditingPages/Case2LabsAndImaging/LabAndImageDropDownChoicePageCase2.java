package se.su.dsv.bivsim.pages.Case2.Case2EditingPages.Case2LabsAndImaging;

import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.PropertyModel;
import se.su.dsv.bivsim.pages.Case2.Case2EditingPages.Case2EdittingCommon.BaseClasses.EditingMainPage2;

import java.util.Arrays;
import java.util.List;

public class LabAndImageDropDownChoicePageCase2 extends EditingMainPage2 {

    private static final List<String> EDIT_TYPES = Arrays.asList(new String[]{"Skapa lab", "Redigera lab"});
    private String selected = "Skapa lab";
    private static final List<String> EDIT_categories = Arrays.asList(new String[]{"Klin Kemi", "Mikrobiologi", "Fysiologi", "Bild/Rtg"});
    private String selected2 = "Klin Kemi";
    int index;

    public LabAndImageDropDownChoicePageCase2() {
        DropDownChoice<String> EditLists = new DropDownChoice<String>("EditTpes", new PropertyModel<String>(this, "selected"), EDIT_TYPES);
        DropDownChoice<String> EditLists2 = new DropDownChoice<String>("EditTpes2", new PropertyModel<String>(this, "selected2"), EDIT_categories);

        Form<?> form = new Form<Void>("Edit") {
            @Override
            protected void onSubmit() {
                if(selected2.equals("Klin Kemi"))
                    index=5;
                if(selected2.equals("Mikrobiologi"))
                    index=6;
                if(selected2.equals("Fysiologi"))
                    index=7;
                if(selected2.equals("Bild/Rtg"))
                    index=8;
               /* if (selected.equals("Create Sub-Imaging"))
                    setResponsePage(CreateNewLabAndImagePageCase1.class);*/
                if (selected.equals("Skapa lab"))
                    setResponsePage(new CreateSubLabAndImagePageCase2(index));
                else
                    setResponsePage(new LabAndImageTreePageCase2(index));
            }
        };
        add(form);
        form.add(EditLists);
        form.add(EditLists2);
    }
}

