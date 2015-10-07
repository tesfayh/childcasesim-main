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

public class PHQ9Panel extends Panel {

    private static final long serialVersionUID = 1L;
    long i1 = 0;
    long i2 = 0;


    int k1 = 0;
    int k2 = 0;


    String[] questionArrays =
            new String[]{"Lite intresse eller glädje i att göra saker",
                    "Känt dig nedstämd, deprimerad\n" +
                            "eller känt att framtiden ser hopplös ut",
                    "Problem att somna eller att du\n" +
                            "vaknat i förtid, eller sovit för mycket",
                    "Känt dig trött eller energilös",
                    "Dålig aptit eller att du ätit för mycket",
                    "Dålig självkänsla - eller att du känt dig misslyckad eller att du svikit dig själv eller din familj",
                    "Svårigheter att koncentrera dig, till exempel\n" +
                            "när du läst tidningen eller sett på TV",
                    "Att du rört dig eller talat så långsamt att andra\n" +
                            "noterat det? Eller motsatsen – att du varit så \n" +
                            "nervös eller rastlös att du rört dig mer än vanligt.",
                    "Tankar att det skulle vara bättre om du var \n" +
                            "död eller att du skulle skada dig på något sätt",
                    "Om du kryssat för att du haft något av dessa problem, hur stora svårigheter har dessa problem förorsakat dig på arbetet, eller för att ta hand om sysslor hemma, eller i kontakten med andra människor?"
            };
    List listQuestions = Arrays.asList(questionArrays);


    public HashMap<Long, Integer> answersGroup1;
    public HashMap<Long, Integer> answersGroup2;

    private HashMap<PTSDEntity, RadioGroup<Integer>> questionsGroup1;
    private HashMap<PTSDEntity, RadioGroup<Integer>> questionsGroup2;


    public Integer[] radiovalue1 = new Integer[13];
    public Integer[] radiovalue2 = new Integer[13];


    private String report1 = "";
    private String report2 = "";

    public HashMap<Long, Integer> getAnswersGroup1() {
        return answersGroup1;
    }

    public HashMap<Long, Integer> getAnswersGroup2() {
        return answersGroup2;
    }


    public PHQ9Panel(String id) {
        super(id);
        getSession().setAttribute("Ptsdreport", "");
        getSession().setAttribute("Ptsdtotal", 0);
        questionsGroup1 = new HashMap<PTSDEntity, RadioGroup<Integer>>();
        answersGroup1 = new HashMap<Long, Integer>();


        questionsGroup2 = new HashMap<PTSDEntity, RadioGroup<Integer>>();
        answersGroup2 = new HashMap<Long, Integer>();

        final WebMarkupContainer wmc = new WebMarkupContainer("wmc");
        wmc.setOutputMarkupId(true);
        add(wmc);

        getSession().setAttribute("phq9total", 0);


        Form<?> form = new Form<Void>("form") {
            @Override
            public void onSubmit() {
                getSession().setAttribute("POSInstrument", (Integer) getSession().getAttribute("POSInstrument") + 1);
                getSession().setAttribute("phq9total", 0);
                Set<Map.Entry<PTSDEntity, RadioGroup<Integer>>> set = questionsGroup1.entrySet();
                for (Map.Entry<PTSDEntity, RadioGroup<Integer>> entry : set) {
                    if (entry.getValue().getModelObject() != null) {
                        answersGroup1.put(++i1, entry.getValue().getModelObject());
                        if (entry.getValue().getModelObject() != null)
                            getSession().setAttribute("phq9total", (Integer) getSession().getAttribute("phq9total") + entry.getValue().getModelObject()-1);
                        getSession().setAttribute("PHQ9answer1", answersGroup1);
                        if (k1 >= 9)
                            k1 = 0;

                        radiovalue1[k1++] = entry.getValue().getModelObject();
                    }
                    getSession().setAttribute("PHQ9radiovalue1", radiovalue1);

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
                Set<Map.Entry<PTSDEntity, RadioGroup<Integer>>> set2 = questionsGroup2.entrySet();
                for (Map.Entry<PTSDEntity, RadioGroup<Integer>> entry : set2) {
                    if (entry.getValue().getModelObject() != null) {
                        answersGroup2.put(++i2, entry.getValue().getModelObject());
                        getSession().setAttribute("PHQ9danswer2", answersGroup2);
                        if (k2 >= 1)
                            k2 = 0;

                        radiovalue2[k2++] = entry.getValue().getModelObject();

                    }

                    getSession().setAttribute("PHQ9radiovalue2", radiovalue2);

                    // loop for storing user log.
                   /* if (entry.getValue().getModelObject() != null) {
                        String groups;

                        if (entry.getValue().getModelObject() == 1)
                            groups = "No";
                        else
                            groups = "Yes";
                        report1 = report1 + "Q:" + entry.getKey().toString() +
                                "..Ans:" + groups + "#";


                    }
*/
                }


                getSession().setAttribute("PHQ9screened", 1);

                getSession().setAttribute("PHQ9dreport", report1 + report2);


                wmc.replace(new Label("total", "PHQ-9 total score:" + getSession().getAttribute("phq9total")));


            }
        };
        add(form);
        form.add(wmc);

        wmc.add(new Label("total", "PHQ-9 total score: 0"));

        ListView<PTSDEntity> persons1 = new ListView<PTSDEntity>("interviews1", listQuestions.subList(0, 9)) {
            @Override
            protected void populateItem(ListItem<PTSDEntity> item) {
                item.add(new Label("name1", item.getModel()));
                Model model0 = new Model<Integer>(0);
                Model model1 = new Model<Integer>(1);
                Model model2 = new Model<Integer>(2);
                Model model3 = new Model<Integer>(3);
                Model model4 = new Model<Integer>(4);

                RadioGroup<Integer> group = new RadioGroup<Integer>("radioGroup1", model0);
                group.add(new Radio<Integer>("radio1", model1));
                group.add(new Radio<Integer>("radio2", model2));
                group.add(new Radio<Integer>("radio3", model3));
                group.add(new Radio<Integer>("radio4", model4));

                item.add(group);
                questionsGroup1.put(item.getModelObject(), group);
            }
        };
        form.add(persons1);

        ListView<PTSDEntity> persons2 = new ListView<PTSDEntity>("interviews2", listQuestions.subList(9, 10)) {
            @Override
            protected void populateItem(ListItem<PTSDEntity> item) {

                item.add(new Label("name2", item.getModel()));
                Model model0 = new Model<Integer>(0);
                Model model1 = new Model<Integer>(1);
                Model model2 = new Model<Integer>(2);
                Model model3 = new Model<Integer>(3);
                Model model4 = new Model<Integer>(4);
                RadioGroup<Integer> group = new RadioGroup<Integer>("radioGroup2", model0);
                group.add(new Radio<Integer>("radio1", model1));
                group.add(new Radio<Integer>("radio2", model2));
                group.add(new Radio<Integer>("radio3", model3));
                group.add(new Radio<Integer>("radio4", model4));

                item.add(group);
                questionsGroup2.put(item.getModelObject(), group);
            }
        };
        form.add(persons2);


        Link tillbaka = new AjaxFallbackLink("tillbaka") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                setResponsePage(InstrumentCase3ListPage.class);

            }


        };
        wmc.add(tillbaka);

    }

}
