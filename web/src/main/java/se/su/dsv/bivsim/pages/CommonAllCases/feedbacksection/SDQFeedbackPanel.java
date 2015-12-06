package se.su.dsv.bivsim.pages.CommonAllCases.feedbacksection;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.Radio;
import org.apache.wicket.markup.html.form.RadioGroup;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;
import se.su.dsv.bivsim.data.Case.dataobjects.PTSDEntity;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SDQFeedbackPanel extends Panel {


    int i1 = 0;
    int j1 = 0;
    int k1 = 0;
    int k2 = 0;
    int k3 = 0;
    int k4 = 0;
    int k5 = 0;

    int m1 = 0;
    int Ak = 0;
    int Am = 0;




    public Integer[] AUDITradiovalue1 = new Integer[40];


    public HashMap<Long, Integer> tempoanswers1;



    String[] questionArrays =
            new String[]{"1. Omtänksam, tar hänsyn till andra människors känslor",
                    "2.  Rastlös, överaktiv, kan inte vara stilla länge",
                    "3. Klagar ofta över huvudvärk, ont i magen eller illamående",
                    "4. Delar gärna med sig till andra barn (t ex godis, leksaker, pennor)",
                    "5. Har ofta raseriutbrott eller häftigt humör",
                    "6. Ganska ensam, leker eller håller sig ofta för sig själv",
                    "7. Som regel lydig, följer vanligtvis vuxnas uppmaningar",
                    "8. Oroar sig över mycket, verkar ofta bekymrad",
                    "9. Hjälpsam om någon är ledsen, upprörd eller känner sig dålig",
                    "10. Svårt att sitta stilla, rör och vrider jämt på sig",
                    "11. Har minst en god vän (kamrat)",
                    "12. Slåss/bråkar ofta med andra barn eller mobbar dem",
                    "13. Ofta ledsen, nedstämd eller tårögd",
                    "14. Vanligtvis omtyckt av andra barn",
                    "15. Lättstörd, tappar lätt koncentrationen",
                    "16. Nervös eller klängig i nya situationer, blir lätt otrygg",
                    "17. Snäll mot yngre barn",
                    "18. Ljuger eller fuskar ofta",
                    "19. Blir retad eller mobbad av andra barn",
                    "20. Ställer ofta upp och hjälper andra (föräldrar, lärare, andra barn)",
                    "21. Tänker sig för innan han/hon gör olika saker",
                    "22. Stjäl hemma, i skolan eller på andra ställen",
                    "23. Kommer bättre överens med vuxna än med andra barn",
                    "24. Rädd för mycket, är lättskrämd",
                    "25. Fullföljer uppgifter, bra koncentrationsförmåga"
            };

    List listQuestions = Arrays.asList(questionArrays);

    int[] expertAnswers = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    int expertOpinion = 0;


    public SDQFeedbackPanel(String id) {

        super(id);

        tempoanswers1 = (HashMap<Long, Integer>) getSession().getAttribute("SDQRanswer1");

        AUDITradiovalue1 = (Integer[]) getSession().getAttribute("SDQRradiovalue1");



        Form<?> form = new Form<Void>("form") {
            @Override
            public void onSubmit() {

            }
        };
        add(form);

        if (tempoanswers1 == null) {
            ListView<PTSDEntity> persons1 = new ListView<PTSDEntity>("interviews1", listQuestions.subList(0, 22)) {
                @Override
                protected void populateItem(ListItem<PTSDEntity> item) {


                    item.add(new Label("name1", item.getModel()));
                    Model model0 = new Model<Integer>(0);
                    Model model1 = new Model<Integer>(1);
                    Model model2 = new Model<Integer>(2);
                    Model model3 = new Model<Integer>(3);
                    Model model4 = new Model<Integer>(4);
                    Model model5 = new Model<Integer>(5);

                    RadioGroup<Integer> group1b = new RadioGroup<Integer>("radioGroup1", model0);
                    group1b.add(new Radio<Integer>("radio1", model1));
                    group1b.add(new Radio<Integer>("radio2", model2));
                    group1b.add(new Radio<Integer>("radio3", model3));
                    group1b.add(new Radio<Integer>("radio4", model4));
                    group1b.add(new Radio<Integer>("radio5", model5));

                    item.add(group1b);
                    RadioGroup<Integer> group2b = new RadioGroup<Integer>("exRadioGroup1", new Model<Integer>(expertAnswers[expertOpinion++]));
                    /*group.add(new Radio<Integer>("exradio2", model1));
                    group.add(new Radio<Integer>("exradio22", model2));
                    group.add(new Radio<Integer>("exradio32", model3));*/
                    group2b.add(new Radio<Integer>("exradio1", model1));
                    group2b.add(new Radio<Integer>("exradio2", model2));
                    group2b.add(new Radio<Integer>("exradio3", model3));
                    group2b.add(new Radio<Integer>("exradio4", model4));
                    group2b.add(new Radio<Integer>("exradio5", model5));
                    item.add(group2b);
                }
            };
            form.add(persons1);
        } else {
            ListView<PTSDEntity> persons1 = new ListView<PTSDEntity>("interviews1", listQuestions.subList(0, 22)) {
                @Override
                protected void populateItem(ListItem<PTSDEntity> item) {

                    item.add(new Label("name1", item.getModel()));
                    Model model0 = new Model<Integer>(0);
                    Model model1 = new Model<Integer>(1);
                    Model model2 = new Model<Integer>(2);
                    Model model3 = new Model<Integer>(3);
                    Model model4 = new Model<Integer>(4);
                    Model model5 = new Model<Integer>(5);
                    RadioGroup<Integer> group1b = new RadioGroup<Integer>("radioGroup1", new Model<Integer>((AUDITradiovalue1[k1++])));
                    group1b.add(new Radio<Integer>("radio1", model1));
                    group1b.add(new Radio<Integer>("radio2", model2));
                    group1b.add(new Radio<Integer>("radio3", model3));
                    group1b.add(new Radio<Integer>("radio4", model4));
                    group1b.add(new Radio<Integer>("radio5", model5));


                    item.add(group1b);
                    RadioGroup<Integer> group2b = new RadioGroup<Integer>("exRadioGroup1", new Model<Integer>(expertAnswers[expertOpinion++]));
                    /*group.add(new Radio<Integer>("exradio2", model1));
                    group.add(new Radio<Integer>("exradio22", model2));
                    group.add(new Radio<Integer>("exradio32", model3));*/
                    group2b.add(new Radio<Integer>("exradio1", model1));
                    group2b.add(new Radio<Integer>("exradio2", model2));
                    group2b.add(new Radio<Integer>("exradio3", model3));
                    group2b.add(new Radio<Integer>("exradio4", model4));
                    group2b.add(new Radio<Integer>("exradio5", model5));
                    item.add(group2b);
                }
            };
            form.add(persons1);
        }


        Link tillbaka = new AjaxFallbackLink("tillbaka") {

            @Override
            public void onClick(AjaxRequestTarget target) {


                setResponsePage(CategoryFeedBackPage.class);


            }


        };
     add(tillbaka);


    }

}

