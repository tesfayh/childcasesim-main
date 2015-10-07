package se.su.dsv.bivsim.pages.Case1.screeninginstruments;

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
import se.su.dsv.bivsim.pages.Case1.CommonCase1.BaseClasses.InstrumentListPage;

import java.util.*;

public class DUDITPanel extends Panel {

    private static final long serialVersionUID = 1L;
    long i1 = 0;
    long i2 = 0;
    long i3 = 0;
    long i4 = 0;
    long i5 = 0;

    int k1 = 0;
    int k2 = 0;
    int k3 = 0;
    int k4 = 0;
    int k5 = 0;


    String[] questionArrays =
            new String[]{"Hur ofta använder du andra\n" +
                    "droger än alkohol?",
                    "Använder du fler än en drog\n" +
                            "vid ett och samma tillfälle? ",
                    "Hur många gånger tar du droger under\n" +
                            "en typisk dag då du använder droger?  ",
                    "Hur ofta blir du kraftigt påverkad\n" +
                            "av droger?",
                    "Har du under senaste året upplevt\n" +
                            "att din längtan efter droger varit så\n" +
                            "stark att du inte kunnat stå emot? ",
                    "Har det hänt att du under senaste\n" +
                            "året inte kunnat sluta ta droger sedan\n" +
                            "du börjat?",
                    "Hur ofta under senaste året har\n" +
                            "du tagit droger och\n" +
                            "sedan låtit bli att\n" +
                            "göra något som du borde ha gjort? ",
                    "Hur ofta under senaste året har du\n" +
                            "behövt ta någon drog på morgonen\n" +
                            "efter stort drogintag dagen innan? ",
                    " Hur ofta under senaste året har du\n" +
                            "haft skuldkänslor eller dåligt samvete\n" +
                            "på grund av att du använt droger? ",
                    " Har du eller någon annan blivit skadad\n" +
                            "(psykiskt eller fysiskt) på grund av att\n" +
                            "du använt droger? ",
                    "  Har en släkting eller vän, en läkare\n" +
                            "eller sjuksköterska, eller någon annan\n" +
                            "oroat sig över att du använder droger\n" +
                            "eller sagt till dig att du bör sluta med droger? "
            };
    List listQuestions = Arrays.asList(questionArrays);

    public HashMap<Long, Integer> answersGroup1;
    public HashMap<Long, Integer> answersGroup2;
    public HashMap<Long, Integer> answersGroup3;
    public HashMap<Long, Integer> answersGroup4;
    public HashMap<Long, Integer> answersGroup5;

    private HashMap<PTSDEntity, RadioGroup<Integer>> questionsGroup1;
    private HashMap<PTSDEntity, RadioGroup<Integer>> questionsGroup2;
    private HashMap<PTSDEntity, RadioGroup<Integer>> questionsGroup3;
    private HashMap<PTSDEntity, RadioGroup<Integer>> questionsGroup4;
    private HashMap<PTSDEntity, RadioGroup<Integer>> questionsGroup5;


    public Integer[] radiovalue1 = new Integer[13];
    public Integer[] radiovalue2 = new Integer[13];
    public Integer[] radiovalue3 = new Integer[13];
    public Integer[] radiovalue4 = new Integer[13];
    public Integer[] radiovalue5 = new Integer[13];


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


    public DUDITPanel(String id) {
        super(id);

        final WebMarkupContainer wmc = new WebMarkupContainer("wmc");
        wmc.setOutputMarkupId(true);
        getSession().setAttribute("DUDITtotal", 0);
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

        Form<?> form = new Form<Void>("form") {
            @Override
            public void onSubmit() {
                getSession().setAttribute("DUDITtotal", 0);
                Set<Map.Entry<PTSDEntity, RadioGroup<Integer>>> set = questionsGroup1.entrySet();
                for (Map.Entry<PTSDEntity, RadioGroup<Integer>> entry : set) {
                    if (entry.getValue().getModelObject() != null) {
                        getSession().setAttribute("DUDITtotal", (Integer) getSession().getAttribute("DUDITtotal") + entry.getValue().getModelObject()-1);
                        answersGroup1.put(++i1, entry.getValue().getModelObject());
                        getSession().setAttribute("DUDITanswer1", answersGroup1);
                        if (k1 >= 1)
                            k1 = 0;

                        radiovalue1[k1++] = entry.getValue().getModelObject();


                    }


                    getSession().setAttribute("DUDITradiovalue1", radiovalue1);

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
                        getSession().setAttribute("DUDITtotal", (Integer) getSession().getAttribute("DUDITtotal") + entry.getValue().getModelObject()-1);
                        answersGroup2.put(++i2, entry.getValue().getModelObject());
                        getSession().setAttribute("DUDITanswer2", answersGroup2);
                        if (k2 >= 1)
                            k2 = 0;

                        radiovalue2[k2++] = entry.getValue().getModelObject();

                    }

                    getSession().setAttribute("DUDITradiovalue2", radiovalue2);

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
                        getSession().setAttribute("DUDITtotal", (Integer) getSession().getAttribute("DUDITtotal") + entry.getValue().getModelObject()-1);
                        answersGroup4.put(++i3, entry.getValue().getModelObject());
                        getSession().setAttribute("DUDITanswer3", answersGroup3);
                        if (k3 >= 1)
                            k3 = 0;

                        radiovalue3[k3++] = entry.getValue().getModelObject();

                    }
                    getSession().setAttribute("DUDITradiovalue3", radiovalue3);

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
                        int  tempvalue=0;
                        if(entry.getValue().getModelObject()==1)
                            tempvalue=0;
                        if(entry.getValue().getModelObject()==2)
                            tempvalue=2;
                        if(entry.getValue().getModelObject()==3)
                            tempvalue=4;
                        getSession().setAttribute("DUDITtotal", (Integer) getSession().getAttribute("DUDITtotal") + tempvalue);
                        answersGroup4.put(++i4, entry.getValue().getModelObject());
                        getSession().setAttribute("DUDITanswer4", answersGroup4);
                        if (k4 >= 8)
                            k4 = 0;

                        radiovalue4[k4++] = entry.getValue().getModelObject();

/*
                        System.out.println(radiovalue3[--k4]);
*/


                    }


                    getSession().setAttribute("DUDITradiovalue4", radiovalue4);

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
                        getSession().setAttribute("DUDITtotal", (Integer) getSession().getAttribute("DUDITtotal") + entry.getValue().getModelObject());
                        answersGroup5.put(++i5, entry.getValue().getModelObject());
                        getSession().setAttribute("DUDITanswer5", answersGroup5);
                        if (k5 >= 2)
                            k5 = 0;

                        radiovalue5[k5++] = entry.getValue().getModelObject();

                    }
                    getSession().setAttribute("DUDITradiovalue5", radiovalue5);

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


                wmc.replace(new Label("total", "DUDIT total score:" + getSession().getAttribute("DUDITtotal")));
            }
        };
        add(form);
        form.add(wmc);
        wmc.add(new Label("total", "DUDIT total score: 0"));

        ListView<PTSDEntity> persons1 = new ListView<PTSDEntity>("interviews1", listQuestions.subList(0, 2)) {
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

        ListView<PTSDEntity> persons2 = new ListView<PTSDEntity>("interviews2", listQuestions.subList(2, 3)) {
            @Override
            protected void populateItem(ListItem<PTSDEntity> item) {

                item.add(new Label("name2", item.getModel()));
                Model model0 = new Model<Integer>(0);
                Model model1 = new Model<Integer>(1);
                Model model2 = new Model<Integer>(2);
                Model model3 = new Model<Integer>(3);
                Model model4 = new Model<Integer>(4);
                Model model5 = new Model<Integer>(5);
                RadioGroup<Integer> group = new RadioGroup<Integer>("radioGroup2", model0);
                group.add(new Radio<Integer>("radio1", model1));
                group.add(new Radio<Integer>("radio2", model2));
                group.add(new Radio<Integer>("radio3", model3));
                group.add(new Radio<Integer>("radio4", model4));
                group.add(new Radio<Integer>("radio5", model5));

                item.add(group);
                questionsGroup2.put(item.getModelObject(), group);
            }
        };
        form.add(persons2);


        ListView<PTSDEntity> persons3 = new ListView<PTSDEntity>("interviews3", listQuestions.subList(3, 9)) {
            @Override
            protected void populateItem(ListItem<PTSDEntity> item) {

                item.add(new Label("name3", item.getModel()));
                Model model0 = new Model<Integer>(0);
                Model model1 = new Model<Integer>(1);
                Model model2 = new Model<Integer>(2);
                Model model3 = new Model<Integer>(3);
                Model model4 = new Model<Integer>(4);
                Model model5 = new Model<Integer>(5);
                RadioGroup<Integer> group = new RadioGroup<Integer>("radioGroup3", model0);
                group.add(new Radio<Integer>("radio1", model1));
                group.add(new Radio<Integer>("radio2", model2));
                group.add(new Radio<Integer>("radio3", model3));
                group.add(new Radio<Integer>("radio4", model4));
                group.add(new Radio<Integer>("radio5", model5));

                item.add(group);
                questionsGroup3.put(item.getModelObject(), group);
            }
        };
        form.add(persons3);

        ListView<PTSDEntity> persons4 = new ListView<PTSDEntity>("interviews4", listQuestions.subList(9, 11)) {
            @Override
            protected void populateItem(ListItem<PTSDEntity> item) {

                item.add(new Label("name4", item.getModel()));
                Model model0 = new Model<Integer>(0);
                Model model1 = new Model<Integer>(1);
                Model model2 = new Model<Integer>(2);
                Model model3 = new Model<Integer>(3);
                ;
                RadioGroup<Integer> group = new RadioGroup<Integer>("radioGroup4", model0);
                group.add(new Radio<Integer>("radio1", model1));
                group.add(new Radio<Integer>("radio2", model2));
                group.add(new Radio<Integer>("radio3", model3));

                item.add(group);
                questionsGroup4.put(item.getModelObject(), group);


            }
        };
        form.add(persons4);
        Link tillbaka = new AjaxFallbackLink("tillbaka") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                setResponsePage(InstrumentListPage.class);

            }


        };
        wmc.add(tillbaka);


    }
}
