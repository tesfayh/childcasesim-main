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
import org.apache.wicket.spring.injection.annot.SpringBean;
import se.su.dsv.bivsim.data.Case.dao.interfaces.PTSDEntityDoa;
import se.su.dsv.bivsim.data.Case.dataobjects.PTSDEntity;
import se.su.dsv.bivsim.pages.Case3.Case3Common.BaseClasses.InstrumentCase3ListPage;

import java.util.*;

public class MADRSPanel extends Panel {

    @SpringBean
    PTSDEntityDoa pTSDEntityDoa;
    private static final long serialVersionUID = 1L;
    long i1 = 0;
    long i2 = 0;
    long i3 = 0;
    long i4 = 0;
    long i5 = 0;
    long i6 = 0;
    long i7 = 0;
    long i8 = 0;
    long i9 = 0;


    int k1 = 0;
    int k2 = 0;
    int k3 = 0;
    int k4 = 0;
    int k5 = 0;
    int k6 = 0;
    int k7 = 0;
    int k8 = 0;
    int k9 = 0;


    String[] questionArrays =
            new String[]{"1. Sinnestämning:  \n" +
                    "Här ber vi dig beskriva din sinnesstämning, om du\n" +
                    "känner dig ledsen, tungsint eller dyster till mods. Tänk\n" +
                    "efter hur du har känt dig de senaste tre dagarna, om\n" +
                    "du har skiftat i humöret eller om det varit i stort sett\n" +
                    "detsamma hela tiden, och försök särskilt komma ihåg\n" +
                    "om du har känt dig lättare till sinnes om det har hänt\n" +
                    "något positivt.",

                    "2. Oroskänslor: \n" +
                            "Här ber vi dig markera i vilken utsträckning du haft\n" +
                            "känslor av inre spänning, olust och ångest eller odefini\n" +
                            "-\n" +
                            "erad rädsla under de senaste tre dagarna. Tänk särskilt\n" +
                            "på hur intensiva känslorna varit, och om de kommit och\n" +
                            "gått eller funnits nästan hela tiden.",
                    "3. Sömn: \n" +
                            "Här ber vi dig beskriva hur bra du sover. Tänk efter\n" +
                            "hur länge du sovit och hur god sömnen varit under de\n" +
                            "senaste tre nätterna. Bedömningen skall avse hur du\n" +
                            "faktiskt sovit, oavsett om du tagit sömnmedel eller ej.\n" +
                            "Om du sover mer än vanligt, sätt din markering vid 0",
                    "4. Matlust: \n" +
                            "Här ber vi dig ta ställning till hur din aptit är, och tänka\n" +
                            "efter om den på något sätt skiljt sig från vad som är\n" +
                            "normalt för dig. Om du skulle ha bättre aptit än normalt,\n" +
                            "sätt din markering vid 0 ",
                    "5. Koncentrationsförmåga:\n" +
                            "Här ber vi dig ta ställning till din förmåga att hålla tan\n" +
                            "-\n" +
                            "karna samlade och koncentrera dig på olika aktiviteter.\n" +
                            "Tänk igenom hur du fungerar vid olika sysslor som krä\n" +
                            "-\n" +
                            "ver olika grad av koncentrationsförmåga, t ex läsning av\n" +
                            "komplicerad text, lätt tidningstext och TV-tittande",
                    "6. Initiativförmåga:\n" +
                            "Här ber vi dig försöka värdera din handlingskraft. Frågan\n" +
                            "gäller om du har lätt eller svårt för dig att komma igång\n" +
                            "med sådant du tycker du bör göra, och i vilken utsträck\n" +
                            "-\n" +
                            "ning du måste övervinna ett inre motstånd när du skall\n" +
                            "ta itu med något",
                    "7. Känslomässigt engagemang:\n" +
                            "Här ber vi dig ta ställning till hur du upplever ditt intresse\n" +
                            "för omvärlden och för andra människor, och för sådana\n" +
                            "aktiviteter som brukar bereda dig nöje och glädje.",
                    "8. Pessimism:\n" +
                            "Frågan gäller hur du ser på din egen framtid och hur du\n" +
                            "uppfattar ditt eget värde. Tänk efter i vilken utsträckning\n" +
                            "du ger självförebråelser, om du plågas av skuldkänslor,\n" +
                            "och om du oroat dig oftare än vanligt för t ex din eko\n" +
                            "-\n" +
                            "nomi eller din hälsa",
                    " 9. Livslust:\n" +
                            "Frågan gäller din livslust, och om du känt livsleda. Har\n" +
                            "du tankar på självmord, och i så fall, i vilken utsträckning\n" +
                            "upplever du detta som en verklig utväg? ",
                    " Hur ofta under det senaste året har Du druckit så att Du dagen efter inte kommit ihåg vad Du sagt eller gjort?",
                    " Har Du eller någon annan blivit skadad på grund av Ditt drickande?",
                    " Har en släkting eller vän, en läkare (eller någon annan inom sjukvården) oroat sig över Ditt drickande eller  antytt att Du borde minska på det? "
            };
    List listQuestions = Arrays.asList(questionArrays);

    public HashMap<Long, Integer> answersGroup1;
    public HashMap<Long, Integer> answersGroup2;
    public HashMap<Long, Integer> answersGroup3;
    public HashMap<Long, Integer> answersGroup4;
    public HashMap<Long, Integer> answersGroup5;
    public HashMap<Long, Integer> answersGroup6;
    public HashMap<Long, Integer> answersGroup7;
    public HashMap<Long, Integer> answersGroup8;
    public HashMap<Long, Integer> answersGroup9;


    private HashMap<PTSDEntity, RadioGroup<Integer>> questionsGroup1;
    private HashMap<PTSDEntity, RadioGroup<Integer>> questionsGroup2;
    private HashMap<PTSDEntity, RadioGroup<Integer>> questionsGroup3;
    private HashMap<PTSDEntity, RadioGroup<Integer>> questionsGroup4;
    private HashMap<PTSDEntity, RadioGroup<Integer>> questionsGroup5;
    private HashMap<PTSDEntity, RadioGroup<Integer>> questionsGroup6;
    private HashMap<PTSDEntity, RadioGroup<Integer>> questionsGroup7;
    private HashMap<PTSDEntity, RadioGroup<Integer>> questionsGroup8;
    private HashMap<PTSDEntity, RadioGroup<Integer>> questionsGroup9;


    public Integer[] radiovalue1 = new Integer[13];
    public Integer[] radiovalue2 = new Integer[13];
    public Integer[] radiovalue3 = new Integer[13];
    public Integer[] radiovalue4 = new Integer[13];
    public Integer[] radiovalue5 = new Integer[13];
    public Integer[] radiovalue6 = new Integer[13];
    public Integer[] radiovalue7 = new Integer[13];
    public Integer[] radiovalue8 = new Integer[13];
    public Integer[] radiovalue9 = new Integer[13];


    private String report1 = "";
    private String report2 = "";

    public HashMap<Long, Integer> getAnswersGroup1() {
        return answersGroup1;
    }

    public HashMap<Long, Integer> getAnswersGroup2() {
        return answersGroup2;
    }

    public HashMap<Long, Integer> getAnswersGroup3() {
        return answersGroup3;
    }

    public HashMap<Long, Integer> getAnswersGroup4() {
        return answersGroup4;
    }

    public HashMap<Long, Integer> getAnswersGroup5() {
        return answersGroup5;
    }

    public HashMap<Long, Integer> getAnswersGroup6() {
        return answersGroup6;
    }

    public HashMap<Long, Integer> getAnswersGroup7() {
        return answersGroup5;
    }

    public HashMap<Long, Integer> getAnswersGroup8() {
        return answersGroup5;
    }

    public HashMap<Long, Integer> getAnswersGroup9() {
        return answersGroup5;
    }


    public MADRSPanel(String id) {
        super(id);

        final WebMarkupContainer wmc = new WebMarkupContainer("wmc");
        wmc.setOutputMarkupId(true);
        getSession().setAttribute("AUDITtotal", 0);
        questionsGroup1 = new HashMap<PTSDEntity, RadioGroup<Integer>>();
        answersGroup1 = new HashMap<Long, Integer>();


        questionsGroup2 = new HashMap<PTSDEntity, RadioGroup<Integer>>();
        answersGroup2 = new HashMap<Long, Integer>();

        questionsGroup3 = new HashMap<PTSDEntity, RadioGroup<Integer>>();
        answersGroup3 = new HashMap<Long, Integer>();

        questionsGroup4 = new HashMap<PTSDEntity, RadioGroup<Integer>>();
        answersGroup4 = new HashMap<Long, Integer>();


        questionsGroup5 = new HashMap<PTSDEntity, RadioGroup<Integer>>();
        answersGroup5 = new HashMap<Long, Integer>();

        questionsGroup6 = new HashMap<PTSDEntity, RadioGroup<Integer>>();
        answersGroup6 = new HashMap<Long, Integer>();


        questionsGroup7 = new HashMap<PTSDEntity, RadioGroup<Integer>>();
        answersGroup7 = new HashMap<Long, Integer>();


        questionsGroup8 = new HashMap<PTSDEntity, RadioGroup<Integer>>();
        answersGroup8 = new HashMap<Long, Integer>();


        questionsGroup9 = new HashMap<PTSDEntity, RadioGroup<Integer>>();
        answersGroup9 = new HashMap<Long, Integer>();


        Form<?> form = new Form<Void>("form") {
            @Override
            public void onSubmit() {
                getSession().setAttribute("MADRStotal", 0);
                getSession().setAttribute("POSInstrument", (Integer) getSession().getAttribute("POSInstrument") + 1);

                Set<Map.Entry<PTSDEntity, RadioGroup<Integer>>> set = questionsGroup1.entrySet();
                for (Map.Entry<PTSDEntity, RadioGroup<Integer>> entry : set) {
                    if (entry.getValue().getModelObject() != null) {
                        getSession().setAttribute("MADRStotal", (Integer) getSession().getAttribute("MADRStotal") + entry.getValue().getModelObject()-1);
                        answersGroup1.put(++i1, entry.getValue().getModelObject());
                        getSession().setAttribute("MADRSanswer1", answersGroup1);
                        if (k1 >= 1)
                            k1 = 0;

                        radiovalue1[k1++] = entry.getValue().getModelObject();


                    }


                    getSession().setAttribute("MADRSradiovalue1", radiovalue1);

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
                        getSession().setAttribute("MADRStotal", (Integer) getSession().getAttribute("MADRStotal") + entry.getValue().getModelObject()-1);
                        answersGroup2.put(++i2, entry.getValue().getModelObject());
                        getSession().setAttribute("MADRSanswer2", answersGroup2);
                        if (k2 >= 1)
                            k2 = 0;

                        radiovalue2[k2++] = entry.getValue().getModelObject();

                    }

                    getSession().setAttribute("MADRSradiovalue2", radiovalue2);

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

                Set<Map.Entry<PTSDEntity, RadioGroup<Integer>>> set3 = questionsGroup3.entrySet();
                for (Map.Entry<PTSDEntity, RadioGroup<Integer>> entry : set3) {
                    if (entry.getValue().getModelObject() != null) {
                        getSession().setAttribute("MADRStotal", (Integer) getSession().getAttribute("MADRStotal") + entry.getValue().getModelObject()-1);
                        answersGroup4.put(++i3, entry.getValue().getModelObject());
                        getSession().setAttribute("MADRSanswer3", answersGroup3);
                        if (k3 >= 1)
                            k3 = 0;

                        radiovalue3[k3++] = entry.getValue().getModelObject();

                    }
                    getSession().setAttribute("MADRSradiovalue3", radiovalue3);

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

                Set<Map.Entry<PTSDEntity, RadioGroup<Integer>>> set4 = questionsGroup4.entrySet();
                for (Map.Entry<PTSDEntity, RadioGroup<Integer>> entry : set4) {
                    if (entry.getValue().getModelObject() != null) {
                        getSession().setAttribute("MADRStotal", (Integer) getSession().getAttribute("MADRStotal") + entry.getValue().getModelObject()-1);
                        answersGroup4.put(++i4, entry.getValue().getModelObject());
                        getSession().setAttribute("MADRSanswer4", answersGroup4);
                        if (k4 >= 8)
                            k4 = 0;

                        radiovalue4[k4++] = entry.getValue().getModelObject();

/*
                        System.out.println(radiovalue3[--k4]);
*/


                    }


                    getSession().setAttribute("MADRSradiovalue4", radiovalue4);

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

                Set<Map.Entry<PTSDEntity, RadioGroup<Integer>>> set5 = questionsGroup5.entrySet();
                for (Map.Entry<PTSDEntity, RadioGroup<Integer>> entry : set5) {
                    if (entry.getValue().getModelObject() != null) {
                        getSession().setAttribute("MADRStotal", (Integer) getSession().getAttribute("MADRStotal") + entry.getValue().getModelObject()-1);
                        answersGroup5.put(++i5, entry.getValue().getModelObject());
                        getSession().setAttribute("MADRSanswer5", answersGroup5);
                        if (k5 >= 2)
                            k5 = 0;
                        radiovalue5[k5++] = entry.getValue().getModelObject();
                    }
                    getSession().setAttribute("MADRSradiovalue5", radiovalue5);
                }


                Set<Map.Entry<PTSDEntity, RadioGroup<Integer>>> set6 = questionsGroup6.entrySet();
                for (Map.Entry<PTSDEntity, RadioGroup<Integer>> entry : set6) {
                    if (entry.getValue().getModelObject() != null) {
                        getSession().setAttribute("MADRStotal", (Integer) getSession().getAttribute("MADRStotal") + entry.getValue().getModelObject()-1);
                        answersGroup5.put(++i6, entry.getValue().getModelObject());
                        getSession().setAttribute("MADRSanswer6", answersGroup6);
                        if (k6 >= 2)
                            k6 = 0;
                        radiovalue6[k6++] = entry.getValue().getModelObject();
                    }
                    getSession().setAttribute("MADRSradiovalue6", radiovalue6);
                }

                Set<Map.Entry<PTSDEntity, RadioGroup<Integer>>> set7 = questionsGroup7.entrySet();
                for (Map.Entry<PTSDEntity, RadioGroup<Integer>> entry : set7) {
                    if (entry.getValue().getModelObject() != null) {
                        getSession().setAttribute("MADRStotal", (Integer) getSession().getAttribute("MADRStotal") + entry.getValue().getModelObject()-1);
                        answersGroup7.put(++i7, entry.getValue().getModelObject());
                        getSession().setAttribute("MADRSanswer7", answersGroup7);
                        if (k7 >= 2)
                            k7 = 0;
                        radiovalue6[k7++] = entry.getValue().getModelObject();
                    }
                    getSession().setAttribute("MADRSradiovalue7", radiovalue7);
                }

                Set<Map.Entry<PTSDEntity, RadioGroup<Integer>>> set8 = questionsGroup8.entrySet();
                for (Map.Entry<PTSDEntity, RadioGroup<Integer>> entry : set8) {
                    if (entry.getValue().getModelObject() != null) {
                        getSession().setAttribute("MADRStotal", (Integer) getSession().getAttribute("MADRStotal") + entry.getValue().getModelObject()-1);
                        answersGroup8.put(++i8, entry.getValue().getModelObject());
                        getSession().setAttribute("MADRSanswer8", answersGroup8);
                        if (k8 >= 2)
                            k8 = 0;
                        radiovalue6[k8++] = entry.getValue().getModelObject();
                    }
                    getSession().setAttribute("MADRSradiovalue8", radiovalue8);
                }

                Set<Map.Entry<PTSDEntity, RadioGroup<Integer>>> set9 = questionsGroup9.entrySet();
                for (Map.Entry<PTSDEntity, RadioGroup<Integer>> entry : set9) {
                    if (entry.getValue().getModelObject() != null) {
                        getSession().setAttribute("MADRStotal", (Integer) getSession().getAttribute("MADRStotal") + entry.getValue().getModelObject()-1);
                        answersGroup9.put(++i9, entry.getValue().getModelObject());
                        getSession().setAttribute("MADRSanswer9", answersGroup9);
                        if (k9 >= 2)
                            k9 = 0;
                        radiovalue6[k9++] = entry.getValue().getModelObject();
                    }
                    getSession().setAttribute("MADRSradiovalue9", radiovalue9);
                }


                wmc.replace(new Label("total", "MADRStotal score:" + getSession().getAttribute("MADRStotal")));
            }
        };
        add(form);
        form.add(wmc);
        wmc.add(new Label("total", "MADRS total score: 0"));

        ListView<PTSDEntity> persons1 = new ListView<PTSDEntity>("interviews1", listQuestions.subList(0, 1)) {
            @Override
            protected void populateItem(ListItem<PTSDEntity> item) {
                item.add(new Label("name1", item.getModel()));
                Model model0 = new Model<Integer>(0);
                Model model1 = new Model<Integer>(1);
                Model model2 = new Model<Integer>(2);
                Model model3 = new Model<Integer>(3);
                Model model4 = new Model<Integer>(4);
                Model model5 = new Model<Integer>(5);
                Model model6 = new Model<Integer>(6);
                Model model7 = new Model<Integer>(7);

                RadioGroup<Integer> group = new RadioGroup<Integer>("radioGroup1", model0);
                group.add(new Radio<Integer>("radio1", model1));
                group.add(new Radio<Integer>("radio2", model2));
                group.add(new Radio<Integer>("radio3", model3));
                group.add(new Radio<Integer>("radio4", model4));
                group.add(new Radio<Integer>("radio5", model5));
                group.add(new Radio<Integer>("radio6", model6));
                group.add(new Radio<Integer>("radio7", model7));


                item.add(group);
                questionsGroup1.put(item.getModelObject(), group);
            }
        };
        form.add(persons1);

        ListView<PTSDEntity> persons2 = new ListView<PTSDEntity>("interviews2", listQuestions.subList(1, 2)) {
            @Override
            protected void populateItem(ListItem<PTSDEntity> item) {

                item.add(new Label("name2", item.getModel()));
                Model model0 = new Model<Integer>(0);
                Model model1 = new Model<Integer>(1);
                Model model2 = new Model<Integer>(2);
                Model model3 = new Model<Integer>(3);
                Model model4 = new Model<Integer>(4);
                Model model5 = new Model<Integer>(5);
                Model model6 = new Model<Integer>(6);
                Model model7 = new Model<Integer>(7);

                RadioGroup<Integer> group = new RadioGroup<Integer>("radioGroup2", model0);
                group.add(new Radio<Integer>("radio1", model1));
                group.add(new Radio<Integer>("radio2", model2));
                group.add(new Radio<Integer>("radio3", model3));
                group.add(new Radio<Integer>("radio4", model4));
                group.add(new Radio<Integer>("radio5", model5));
                group.add(new Radio<Integer>("radio6", model6));
                group.add(new Radio<Integer>("radio7", model7));

                item.add(group);
                questionsGroup2.put(item.getModelObject(), group);
            }
        };
        form.add(persons2);


        ListView<PTSDEntity> persons3 = new ListView<PTSDEntity>("interviews3", listQuestions.subList(2, 3)) {
            @Override
            protected void populateItem(ListItem<PTSDEntity> item) {

                item.add(new Label("name3", item.getModel()));
                Model model0 = new Model<Integer>(0);
                Model model1 = new Model<Integer>(1);
                Model model2 = new Model<Integer>(2);
                Model model3 = new Model<Integer>(3);
                Model model4 = new Model<Integer>(4);
                Model model5 = new Model<Integer>(5);
                Model model6 = new Model<Integer>(6);
                Model model7 = new Model<Integer>(7);

                RadioGroup<Integer> group = new RadioGroup<Integer>("radioGroup3", model0);
                group.add(new Radio<Integer>("radio1", model1));
                group.add(new Radio<Integer>("radio2", model2));
                group.add(new Radio<Integer>("radio3", model3));
                group.add(new Radio<Integer>("radio4", model4));
                group.add(new Radio<Integer>("radio5", model5));
                group.add(new Radio<Integer>("radio6", model6));
                group.add(new Radio<Integer>("radio7", model7));


                item.add(group);
                questionsGroup3.put(item.getModelObject(), group);
            }
        };
        form.add(persons3);

        ListView<PTSDEntity> persons4 = new ListView<PTSDEntity>("interviews4", listQuestions.subList(3, 4)) {
            @Override
            protected void populateItem(ListItem<PTSDEntity> item) {

                item.add(new Label("name4", item.getModel()));
                Model model0 = new Model<Integer>(0);
                Model model1 = new Model<Integer>(1);
                Model model2 = new Model<Integer>(2);
                Model model3 = new Model<Integer>(3);
                Model model4 = new Model<Integer>(4);
                Model model5 = new Model<Integer>(5);
                Model model6 = new Model<Integer>(6);
                Model model7 = new Model<Integer>(7);

                RadioGroup<Integer> group = new RadioGroup<Integer>("radioGroup4", model0);
                group.add(new Radio<Integer>("radio1", model1));
                group.add(new Radio<Integer>("radio2", model2));
                group.add(new Radio<Integer>("radio3", model3));
                group.add(new Radio<Integer>("radio4", model4));
                group.add(new Radio<Integer>("radio5", model5));
                group.add(new Radio<Integer>("radio6", model6));
                group.add(new Radio<Integer>("radio7", model7));
                item.add(group);
                questionsGroup4.put(item.getModelObject(), group);


            }
        };
        form.add(persons4);

        ListView<PTSDEntity> persons5 = new ListView<PTSDEntity>("interviews5", listQuestions.subList(4, 5)) {
            @Override
            protected void populateItem(ListItem<PTSDEntity> item) {

                item.add(new Label("name5", item.getModel()));
                Model model0 = new Model<Integer>(0);
                Model model1 = new Model<Integer>(1);
                Model model2 = new Model<Integer>(2);
                Model model3 = new Model<Integer>(3);
                Model model4 = new Model<Integer>(4);
                Model model5 = new Model<Integer>(5);
                Model model6 = new Model<Integer>(6);
                Model model7 = new Model<Integer>(7);


                RadioGroup<Integer> group = new RadioGroup<Integer>("radioGroup5", model0);
                group.add(new Radio<Integer>("radio1", model1));
                group.add(new Radio<Integer>("radio2", model2));
                group.add(new Radio<Integer>("radio3", model3));
                group.add(new Radio<Integer>("radio4", model4));
                group.add(new Radio<Integer>("radio5", model5));
                group.add(new Radio<Integer>("radio6", model6));
                group.add(new Radio<Integer>("radio7", model7));


                item.add(group);
                questionsGroup5.put(item.getModelObject(), group);
            }
        };
        form.add(persons5);


        ListView<PTSDEntity> persons6 = new ListView<PTSDEntity>("interviews6", listQuestions.subList(5, 6)) {
            @Override
            protected void populateItem(ListItem<PTSDEntity> item) {

                item.add(new Label("name6", item.getModel()));
                Model model0 = new Model<Integer>(0);
                Model model1 = new Model<Integer>(1);
                Model model2 = new Model<Integer>(2);
                Model model3 = new Model<Integer>(3);
                Model model4 = new Model<Integer>(4);
                Model model5 = new Model<Integer>(5);
                Model model6 = new Model<Integer>(6);
                Model model7 = new Model<Integer>(7);


                RadioGroup<Integer> group = new RadioGroup<Integer>("radioGroup6", model0);
                group.add(new Radio<Integer>("radio1", model1));
                group.add(new Radio<Integer>("radio2", model2));
                group.add(new Radio<Integer>("radio3", model3));
                group.add(new Radio<Integer>("radio4", model4));
                group.add(new Radio<Integer>("radio5", model5));
                group.add(new Radio<Integer>("radio6", model6));
                group.add(new Radio<Integer>("radio7", model7));


                item.add(group);
                questionsGroup6.put(item.getModelObject(), group);
            }
        };
        form.add(persons6);


        ListView<PTSDEntity> persons7 = new ListView<PTSDEntity>("interviews7", listQuestions.subList(6, 7)) {
            @Override
            protected void populateItem(ListItem<PTSDEntity> item) {

                item.add(new Label("name7", item.getModel()));
                Model model0 = new Model<Integer>(0);
                Model model1 = new Model<Integer>(1);
                Model model2 = new Model<Integer>(2);
                Model model3 = new Model<Integer>(3);
                Model model4 = new Model<Integer>(4);
                Model model5 = new Model<Integer>(5);
                Model model6 = new Model<Integer>(6);
                Model model7 = new Model<Integer>(7);


                RadioGroup<Integer> group = new RadioGroup<Integer>("radioGroup7", model0);
                group.add(new Radio<Integer>("radio1", model1));
                group.add(new Radio<Integer>("radio2", model2));
                group.add(new Radio<Integer>("radio3", model3));
                group.add(new Radio<Integer>("radio4", model4));
                group.add(new Radio<Integer>("radio5", model5));
                group.add(new Radio<Integer>("radio6", model6));
                group.add(new Radio<Integer>("radio7", model7));


                item.add(group);
                questionsGroup7.put(item.getModelObject(), group);
            }
        };
        form.add(persons7);


        ListView<PTSDEntity> persons8 = new ListView<PTSDEntity>("interviews8", listQuestions.subList(7, 8)) {
            @Override
            protected void populateItem(ListItem<PTSDEntity> item) {

                item.add(new Label("name8", item.getModel()));
                Model model0 = new Model<Integer>(0);
                Model model1 = new Model<Integer>(1);
                Model model2 = new Model<Integer>(2);
                Model model3 = new Model<Integer>(3);
                Model model4 = new Model<Integer>(4);
                Model model5 = new Model<Integer>(5);
                Model model6 = new Model<Integer>(6);
                Model model7 = new Model<Integer>(7);


                RadioGroup<Integer> group = new RadioGroup<Integer>("radioGroup8", model0);
                group.add(new Radio<Integer>("radio1", model1));
                group.add(new Radio<Integer>("radio2", model2));
                group.add(new Radio<Integer>("radio3", model3));
                group.add(new Radio<Integer>("radio4", model4));
                group.add(new Radio<Integer>("radio5", model5));
                group.add(new Radio<Integer>("radio6", model6));
                group.add(new Radio<Integer>("radio7", model7));


                item.add(group);
                questionsGroup8.put(item.getModelObject(), group);
            }
        };
        form.add(persons8);

        ListView<PTSDEntity> persons9 = new ListView<PTSDEntity>("interviews9", listQuestions.subList(8, 9)) {
            @Override
            protected void populateItem(ListItem<PTSDEntity> item) {

                item.add(new Label("name9", item.getModel()));
                Model model0 = new Model<Integer>(0);
                Model model1 = new Model<Integer>(1);
                Model model2 = new Model<Integer>(2);
                Model model3 = new Model<Integer>(3);
                Model model4 = new Model<Integer>(4);
                Model model5 = new Model<Integer>(5);
                Model model6 = new Model<Integer>(6);
                Model model7 = new Model<Integer>(7);

                RadioGroup<Integer> group = new RadioGroup<Integer>("radioGroup9", model0);
                group.add(new Radio<Integer>("radio1", model1));
                group.add(new Radio<Integer>("radio2", model2));
                group.add(new Radio<Integer>("radio3", model3));
                group.add(new Radio<Integer>("radio4", model4));
                group.add(new Radio<Integer>("radio5", model5));
                group.add(new Radio<Integer>("radio6", model6));
                group.add(new Radio<Integer>("radio7", model7));


                item.add(group);
                questionsGroup9.put(item.getModelObject(), group);
            }
        };
        form.add(persons9);
        Link tillbaka = new AjaxFallbackLink("tillbaka") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                setResponsePage(InstrumentCase3ListPage.class);

            }


        };
        wmc.add(tillbaka);
    }


}
