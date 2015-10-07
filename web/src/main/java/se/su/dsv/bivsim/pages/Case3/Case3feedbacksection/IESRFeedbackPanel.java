package se.su.dsv.bivsim.pages.Case3.Case3feedbacksection;

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

public class IESRFeedbackPanel extends Panel {


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




    public Integer[] AUDITradiovalue1 = new Integer[22];


    public HashMap<Long, Integer> tempoanswers1;



    String[] questionArrays =
            new String[]{"1. Varje påminnelse väckte till liv känslor av detta",

                    "2. Jag hade svårt att sova ",

                    "3. Andra saker fick mig att tänka på detta ",

                    "4. Jag kände mig irriterad och arg",

                    "5. Jag undvek att låta mig bli upprörd när jag tänkte" +

                            " på eller blev påmind om detta",

                    "6. Jag tänkte på detta när jag inte ville det",

                    "7. Jag kände mig som om detta inte hade hänt mig" +

                            " eller som om det inte var verkligt",

                    "8. Jag höll mig borta från det som kunde påminna" +

                            " mig om detta",

                    " 9. Bilder om detta kom in i mitt huvud",

                    "10. Jag hoppade till och hade lätt för att reagera",

                    "11. Jag försökte att inte tänka på det",

                    "12. Jag var medveten om att jag fortfarande hade många" +

                            " känslor om detta, men jag tog inte itu med dem",

                    "13. Mina känslor för detta var på något sätt förlamade",

                    "14. Jag såg mig själv bete mig eller känna mig som om" +

                            " jag var tillbaka vid den tidpunkten",

                    "15. Jag hade svårt att somna",

                    "16. Jag hade starka känslovågor om detta",

                    "17. Jag försökte få bort detta från mitt minne",

                    "18. Jag hade svårt att koncentrera mig",

                    " 19. Påminnelser orsakade fysiologiska reaktioner hos" +

                            " mig som ex. svettning, andningssvårigheter, illa-" +

                            " mående eller hjärtklappning",

                    "20. Jag drömde om det",

                    "21. Jag kände att jag ville övervaka saker och ting och" +

                            " var i försvarsposition",

                    "22. Jag försökte att inte tala om det",
            };
    List listQuestions = Arrays.asList(questionArrays);

    int[] expertAnswers = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    int expertOpinion = 0;


    public IESRFeedbackPanel(String id) {

        super(id);

        tempoanswers1 = (HashMap<Long, Integer>) getSession().getAttribute("IESRanswer1");

        AUDITradiovalue1 = (Integer[]) getSession().getAttribute("IESRradiovalue1");



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

                setResponsePage(CategoryFeedbackInstrumentPage.class);

            }


        };
        form.add(tillbaka);


    }

}

