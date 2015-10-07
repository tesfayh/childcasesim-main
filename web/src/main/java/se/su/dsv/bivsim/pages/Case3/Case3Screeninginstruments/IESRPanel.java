package se.su.dsv.bivsim.pages.Case3.Case3Screeninginstruments;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.html.WebMarkupContainer;
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
import se.su.dsv.bivsim.pages.Case3.Case3Common.BaseClasses.InstrumentCase3ListPage;

import java.util.*;

public class IESRPanel extends Panel {

    ;
    private static final long serialVersionUID = 1L;
    long i1 = 0;

    int k1 = 0;



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

    public HashMap<Long, Integer> answersGroup1;


    private HashMap<PTSDEntity, RadioGroup<Integer>> questionsGroup1;


    public Integer[] radiovalue1 = new Integer[22];


    public HashMap<Long, Integer> getAnswersGroup1() {
        return answersGroup1;
    }



    public IESRPanel(String id) {
        super(id);

        final WebMarkupContainer wmc = new WebMarkupContainer("wmc");
        wmc.setOutputMarkupId(true);
        getSession().setAttribute("IESRtotal", 0);
        questionsGroup1 = new HashMap<PTSDEntity, RadioGroup<Integer>>();
        answersGroup1 = new HashMap<Long, Integer>();




        Form<?> form = new Form<Void>("form") {
            @Override
            public void onSubmit() {
                getSession().setAttribute("IESRtotal", 0);
                getSession().setAttribute("POSInstrument", (Integer) getSession().getAttribute("POSInstrument") + 1);

                Set<Map.Entry<PTSDEntity, RadioGroup<Integer>>> set = questionsGroup1.entrySet();
                for (Map.Entry<PTSDEntity, RadioGroup<Integer>> entry : set) {
                    if (entry.getValue().getModelObject() != null) {
                        getSession().setAttribute("IESRtotal", (Integer) getSession().getAttribute("IESRtotal") + entry.getValue().getModelObject()-1);
                        answersGroup1.put(++i1, entry.getValue().getModelObject());
                        getSession().setAttribute("IESRanswer1", answersGroup1);
                        if (k1 >= 21)
                            k1 = 0;

                        radiovalue1[k1++] = entry.getValue().getModelObject();


                    }


                    getSession().setAttribute("IESRradiovalue1", radiovalue1);

                    // loop for storing user log.
                    /*if (entry.getValue().getModelObject() != null) {\
                        String groups;
                        if (entry.getValue().getModelObject() == 1)
                            groups = "Daily";
                        else if (entry.getValue().getModelObject() == 2)
                            groups = "Several times a week";
                        else if (entry.getValue().getModelObject() == 3)
                            groups = "Several times a month";
                        else
                            groups = "Several times a year";

                        report2 = report2 + "Q:" + entry.getKey().toString() +
                                "..Ans:" + groups + "#";


                    }
*/

                }







                wmc.replace(new Label("total", "IESR total score:" + getSession().getAttribute("IESRtotal")));


            }
        };
        add(form);
        form.add(wmc);
        wmc.add(new Label("total", "IESR total score: 0"));

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

                RadioGroup<Integer> group = new RadioGroup<Integer>("radioGroup1", model0);
                group.add(new Radio<Integer>("radio1", model1));
                group.add(new Radio<Integer>("radio2", model2));
                group.add(new Radio<Integer>("radio3", model3));
                group.add(new Radio<Integer>("radio4", model4));
                group.add(new Radio<Integer>("radio5", model5));
                item.add(group);
                questionsGroup1.put(item.getModelObject(), group);
            }
        };
        form.add(persons1);

        Link tillbaka = new AjaxFallbackLink("tillbaka") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                setResponsePage(InstrumentCase3ListPage.class);

            }


        };
        wmc.add(tillbaka);


    }
}
