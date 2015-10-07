package se.su.dsv.bivsim.pages.Case2.Case2Screeninginstruments;

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
import se.su.dsv.bivsim.pages.Case2.Case2Common.BaseClasses.InstrumentCase2ListPage;

import java.util.*;

public class AUDITPanel extends Panel {

    @SpringBean
    PTSDEntityDoa pTSDEntityDoa;
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
            new String[]{"Kön?",
                    "Hur ofta dricker Du alkohol?",
                    "Hur många ”glas” (se exempel) dricker Du en typisk dag då Du dricker alkohol? ",
                    "Hur ofta dricker Du sex sådana ”glas” eller mer vid samma tillfälle? ",
                    "Hur ofta under det senaste året har Du inte kunnat sluta dricka sedan Du börjat?",
                    "Hur ofta under det senaste året har Du låtit bli att göra något som Du borde för att Du drack?",
                    "Hur ofta under senaste året har Du behövt en ”drink” på morgonen efter mycket drickande dagen innan?",
                    " Hur ofta under det senaste året har Du haft skuldkänslor eller samvets-förebråelser på grund av Ditt drickande? ",
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


    public AUDITPanel(String id) {
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

        Form<?> form = new Form<Void>("form") {
            @Override
            public void onSubmit() {
                getSession().setAttribute("AUDITtotal", 0);
                getSession().setAttribute("POSInstrument", (Integer) getSession().getAttribute("POSInstrument") + 1);

                Set<Map.Entry<PTSDEntity, RadioGroup<Integer>>> set = questionsGroup1.entrySet();
                for (Map.Entry<PTSDEntity, RadioGroup<Integer>> entry : set) {
                    if (entry.getValue().getModelObject() != null) {
/*
                        getSession().setAttribute("AUDITtotal", (Integer) getSession().getAttribute("AUDITtotal") + entry.getValue().getModelObject());
                        / values are 0 for all. so no need to calculate total
*/
                        answersGroup1.put(++i1, entry.getValue().getModelObject());
                        System.out.println(entry.getValue().getModelObject());
                        getSession().setAttribute("AUDITanswer1", answersGroup1);
                        if (k1 >= 1)
                            k1 = 0;

                        radiovalue1[k1++] = entry.getValue().getModelObject();


                    }


                    getSession().setAttribute("AUDITradiovalue1", radiovalue1);

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
                        getSession().setAttribute("AUDITtotal", (Integer) getSession().getAttribute("AUDITtotal") + entry.getValue().getModelObject()-1);
                        // values are only 0, 1,2,3 and 4

                        answersGroup2.put(++i2, entry.getValue().getModelObject());
                        getSession().setAttribute("AUDITanswer2", answersGroup2);
                        if (k2 >= 1)
                            k2 = 0;

                        radiovalue2[k2++] = entry.getValue().getModelObject();

                    }

                    getSession().setAttribute("AUDITradiovalue2", radiovalue2);

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
                        getSession().setAttribute("AUDITtotal", (Integer) getSession().getAttribute("AUDITtotal") + entry.getValue().getModelObject()-1);
                        // values are only 0, 1,2,3 and 4
                        answersGroup4.put(++i3, entry.getValue().getModelObject());
                        getSession().setAttribute("AUDITanswer3", answersGroup3);
                        if (k3 >= 1)
                            k3 = 0;

                        radiovalue3[k3++] = entry.getValue().getModelObject();

                    }
                    getSession().setAttribute("AUDITradiovalue3", radiovalue3);

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
                        getSession().setAttribute("AUDITtotal", (Integer) getSession().getAttribute("AUDITtotal") + entry.getValue().getModelObject()-1);
                        // values are only 0, 1,2,3 and 4
                        answersGroup4.put(++i4, entry.getValue().getModelObject());
                        getSession().setAttribute("AUDITanswer4", answersGroup4);
                        if (k4 >= 8)
                            k4 = 0;

                        radiovalue4[k4++] = entry.getValue().getModelObject();

/*
                        System.out.println(radiovalue3[--k4]);
*/


                    }


                    getSession().setAttribute("AUDITradiovalue4", radiovalue4);

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

                        int  tempvalue=0;
                        if(entry.getValue().getModelObject()==1)
                            tempvalue=0;
                        else if(entry.getValue().getModelObject()==2)
                            tempvalue=2;
                        else if(entry.getValue().getModelObject()==3)
                            tempvalue=4;
                        getSession().setAttribute("AUDITtotal", (Integer) getSession().getAttribute("AUDITtotal") + tempvalue);
                        // values are only 0, 2 and 4
                        answersGroup5.put(++i5, entry.getValue().getModelObject());
                        getSession().setAttribute("AUDITanswer5", answersGroup5);
                        if (k5 >= 2)
                            k5 = 0;

                        radiovalue5[k5++] = entry.getValue().getModelObject();

                    }
                    getSession().setAttribute("AUDITradiovalue5", radiovalue5);

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


                getSession().setAttribute("Ptsdscreened", 1);


                wmc.replace(new Label("total", "AUDIT total score:" + getSession().getAttribute("AUDITtotal")));


            }
        };
        add(form);
        form.add(wmc);
        wmc.add(new Label("total", "AUDIT total score: 0"));

        ListView<PTSDEntity> persons1 = new ListView<PTSDEntity>("interviews1", listQuestions.subList(0, 1)) {
            @Override
            protected void populateItem(ListItem<PTSDEntity> item) {
                item.add(new Label("name1", item.getModel()));
                Model model0 = new Model<Integer>(0);
                Model model1 = new Model<Integer>(1);
                Model model2 = new Model<Integer>(2);
                Model model3 = new Model<Integer>(3);
                RadioGroup<Integer> group = new RadioGroup<Integer>("radioGroup1", model0);
                group.add(new Radio<Integer>("radio1", model1));
                group.add(new Radio<Integer>("radio2", model2));
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

        ListView<PTSDEntity> persons4 = new ListView<PTSDEntity>("interviews4", listQuestions.subList(3, 9)) {
            @Override
            protected void populateItem(ListItem<PTSDEntity> item) {

                item.add(new Label("name4", item.getModel()));
                Model model0 = new Model<Integer>(0);
                Model model1 = new Model<Integer>(1);
                Model model2 = new Model<Integer>(2);
                Model model3 = new Model<Integer>(3);
                Model model4 = new Model<Integer>(4);
                Model model5 = new Model<Integer>(5);
                RadioGroup<Integer> group = new RadioGroup<Integer>("radioGroup4", model0);
                group.add(new Radio<Integer>("radio1", model1));
                group.add(new Radio<Integer>("radio2", model2));
                group.add(new Radio<Integer>("radio3", model3));
                group.add(new Radio<Integer>("radio4", model4));
                group.add(new Radio<Integer>("radio5", model5));

                item.add(group);
                questionsGroup4.put(item.getModelObject(), group);


            }
        };
        form.add(persons4);

        ListView<PTSDEntity> persons5 = new ListView<PTSDEntity>("interviews5", listQuestions.subList(9, 11)) {
            @Override
            protected void populateItem(ListItem<PTSDEntity> item) {

                item.add(new Label("name5", item.getModel()));
                Model model0 = new Model<Integer>(0);
                Model model1 = new Model<Integer>(1);
                Model model2 = new Model<Integer>(2);
                Model model3 = new Model<Integer>(3);

                RadioGroup<Integer> group = new RadioGroup<Integer>("radioGroup5", model0);
                group.add(new Radio<Integer>("radio1", model1));
                group.add(new Radio<Integer>("radio2", model2));
                group.add(new Radio<Integer>("radio3", model3));


                item.add(group);
                questionsGroup5.put(item.getModelObject(), group);
            }
        };
        form.add(persons5);
        Link tillbaka = new AjaxFallbackLink("tillbaka") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                setResponsePage(InstrumentCase2ListPage.class);

            }


        };
        wmc.add(tillbaka);
    }
}
