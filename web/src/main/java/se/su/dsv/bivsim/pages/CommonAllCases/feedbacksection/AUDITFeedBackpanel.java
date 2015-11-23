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
import se.su.dsv.childcasesim.data.Case.dataobjects.PTSDEntity;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class AUDITFeedBackpanel extends Panel {


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

    private int[] exradiovalue1 = {13};
    private int[] exradiovalue2 = {13};
    private int[] exradiovalue3 = {13};
    private int[] exradiovalue4 = {13};
    private int[] exradiovalue5 = {13};


    public Integer[] AUDITradiovalue1 = new Integer[13];
    public Integer[] AUDITradiovalue2 = new Integer[13];
    public Integer[] AUDITradiovalue3 = new Integer[13];
    public Integer[] AUDITradiovalue4 = new Integer[13];
    public Integer[] AUDITradiovalue5 = new Integer[13];
    public Integer[] AUDIT = new Integer[13];


    public HashMap<Long, Integer> tempoanswers1;
    public HashMap<Long, Integer> tempoanswers2;
    public HashMap<Long, Integer> tempoanswers3;
    public HashMap<Long, Integer> tempoanswers4;
    public HashMap<Long, Integer> tempoanswers5;
    public HashMap<Long, Integer> tempo;


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

    int[] expertAnswers = new int[]{2, 3, 2, 2, 1, 1, 1, 1, 1, 1, 1};
    int expertOpinion = 0;

    List listExpertAnswers = Arrays.asList(expertAnswers);

    public AUDITFeedBackpanel(String id) {

        super(id);

        tempoanswers1 = (HashMap<Long, Integer>) getSession().getAttribute("AUDITnswer1");
        tempoanswers2 = (HashMap<Long, Integer>) getSession().getAttribute("AUDITanswer2");
        tempoanswers3 = (HashMap<Long, Integer>) getSession().getAttribute("AUDITanswer3");
        tempoanswers4 = (HashMap<Long, Integer>) getSession().getAttribute("AUDITanswer4");
        tempoanswers5 = (HashMap<Long, Integer>) getSession().getAttribute("AUDITanswer5");

        AUDITradiovalue1 = (Integer[]) getSession().getAttribute("AUDITradiovalue1");
        AUDITradiovalue2 = (Integer[]) getSession().getAttribute("AUDITradiovalue2");
        AUDITradiovalue3 = (Integer[]) getSession().getAttribute("AUDITradiovalue3");
        AUDITradiovalue4 = (Integer[]) getSession().getAttribute("AUDITradiovalue4");
        AUDITradiovalue5 = (Integer[]) getSession().getAttribute("AUDITradiovalue5");


        Form<?> form = new Form<Void>("form") {
            @Override
            public void onSubmit() {

            }
        };
        add(form);

        if (tempoanswers1 == null) {
            ListView<PTSDEntity> persons1 = new ListView<PTSDEntity>("interviews1", listQuestions.subList(0, 1)) {
                @Override
                protected void populateItem(ListItem<PTSDEntity> item) {


                    item.add(new Label("name1", item.getModel()));
                    Model model0 = new Model<Integer>(0);
                    Model model1 = new Model<Integer>(1);
                    Model model2 = new Model<Integer>(2);
                    Model model3 = new Model<Integer>(3);

                    RadioGroup<Integer> group1b = new RadioGroup<Integer>("radioGroup1", model0);
                    group1b.add(new Radio<Integer>("radio1", model1));
                    group1b.add(new Radio<Integer>("radio2", model2));
                    item.add(group1b);
                    RadioGroup<Integer> group2b = new RadioGroup<Integer>("exRadioGroup1", new Model<Integer>(expertAnswers[expertOpinion++]));
                    /*group.add(new Radio<Integer>("exradio2", model1));
                    group.add(new Radio<Integer>("exradio22", model2));
                    group.add(new Radio<Integer>("exradio32", model3));*/
                    group2b.add(new Radio<Integer>("exradio1", model1));
                    group2b.add(new Radio<Integer>("exradio2", model2));
                    item.add(group2b);
                }
            };
            form.add(persons1);
        } else {
            ListView<PTSDEntity> persons1 = new ListView<PTSDEntity>("interviews1", listQuestions.subList(0, 1)) {
                @Override
                protected void populateItem(ListItem<PTSDEntity> item) {

                    item.add(new Label("name1", item.getModel()));
                    Model model0 = new Model<Integer>(0);
                    Model model1 = new Model<Integer>(1);
                    Model model2 = new Model<Integer>(2);
                    Model model3 = new Model<Integer>(3);
                    RadioGroup<Integer> group1b = new RadioGroup<Integer>("radioGroup1", new Model<Integer>((AUDITradiovalue1[k1++])));
                    group1b.add(new Radio<Integer>("radio1", model1));
                    group1b.add(new Radio<Integer>("radio2", model2));

                    item.add(group1b);
                    RadioGroup<Integer> group2b = new RadioGroup<Integer>("exRadioGroup1", new Model<Integer>(expertAnswers[expertOpinion++]));
                    /*group.add(new Radio<Integer>("exradio2", model1));
                    group.add(new Radio<Integer>("exradio22", model2));
                    group.add(new Radio<Integer>("exradio32", model3));*/
                    group2b.add(new Radio<Integer>("exradio1", model1));
                    group2b.add(new Radio<Integer>("exradio2", model2));
                    item.add(group2b);
                }
            };
            form.add(persons1);
        }
        if (tempoanswers2 == null) {
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

                    RadioGroup<Integer> group2 = new RadioGroup<Integer>("exRadioGroup2", new Model<Integer>(expertAnswers[expertOpinion++]));
                    group2.add(new Radio<Integer>("exradio1", model1));
                    group2.add(new Radio<Integer>("exradio2", model2));
                    group2.add(new Radio<Integer>("exradio3", model3));
                    group2.add(new Radio<Integer>("exradio4", model4));
                    group2.add(new Radio<Integer>("exradio5", model4));


                    item.add(group2);
                }
            };
            form.add(persons2);

        } else {
            ListView<PTSDEntity> persons2 = new ListView<PTSDEntity>("interviews2", listQuestions.subList(1, 2)) {
                @Override
                protected void populateItem(final ListItem<PTSDEntity> item) {

                    item.add(new Label("name2", item.getModel()));
                    Model model0 = new Model<Integer>(0);
                    Model model1 = new Model<Integer>(1);
                    Model model2 = new Model<Integer>(2);
                    Model model3 = new Model<Integer>(3);
                    Model model4 = new Model<Integer>(4);
                    Model model5 = new Model<Integer>(5);


                    RadioGroup<Integer> group = new RadioGroup<Integer>("radioGroup2", new Model<Integer>(AUDITradiovalue1[k2++]));
                    group.add(new Radio<Integer>("radio1", model1));
                    group.add(new Radio<Integer>("radio2", model2));
                    group.add(new Radio<Integer>("radio3", model3));
                    group.add(new Radio<Integer>("radio4", model4));
                    group.add(new Radio<Integer>("radio5", model5));


                    item.add(group);
                    RadioGroup<Integer> group2 = new RadioGroup<Integer>("exRadioGroup2", new Model<Integer>(expertAnswers[expertOpinion++]));
                    group2.add(new Radio<Integer>("exradio1", model1));
                    group2.add(new Radio<Integer>("exradio2", model2));
                    group2.add(new Radio<Integer>("exradio3", model3));
                    group2.add(new Radio<Integer>("exradio4", model4));
                    group2.add(new Radio<Integer>("exradio5", model5));

                    item.add(group2);
                }
            };
            form.add(persons2);
        }

        if (tempoanswers3 == null) {
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

                    RadioGroup<Integer> group2 = new RadioGroup<Integer>("exradioGroup3", new Model<Integer>(expertAnswers[expertOpinion++]));
                    group2.add(new Radio<Integer>("exradio1", model1));
                    group2.add(new Radio<Integer>("exradio2", model2));
                    group2.add(new Radio<Integer>("exradio3", model3));
                    group2.add(new Radio<Integer>("exradio4", model4));
                    group2.add(new Radio<Integer>("exradio5", model4));


                    item.add(group2);
                }
            };
            form.add(persons3);

        } else {
            ListView<PTSDEntity> persons3 = new ListView<PTSDEntity>("interviews3", listQuestions.subList(2, 3)) {
                @Override
                protected void populateItem(final ListItem<PTSDEntity> item) {


                    item.add(new Label("name3", item.getModel()));
                    Model model0 = new Model<Integer>(0);
                    Model model1 = new Model<Integer>(1);
                    Model model2 = new Model<Integer>(2);
                    Model model3 = new Model<Integer>(3);
                    Model model4 = new Model<Integer>(4);
                    Model model5 = new Model<Integer>(5);


                    RadioGroup<Integer> group = new RadioGroup<Integer>("radioGroup3", new Model<Integer>(AUDITradiovalue3[k3++]));
                    group.add(new Radio<Integer>("radio1", model1));
                    group.add(new Radio<Integer>("radio2", model2));
                    group.add(new Radio<Integer>("radio3", model3));
                    group.add(new Radio<Integer>("radio4", model4));
                    group.add(new Radio<Integer>("radio5", model5));


                    item.add(group);
                    RadioGroup<Integer> group2 = new RadioGroup<Integer>("exradioGroup3", new Model<Integer>(expertAnswers[expertOpinion++]));
                    group2.add(new Radio<Integer>("exradio1", model1));
                    group2.add(new Radio<Integer>("exradio2", model2));
                    group2.add(new Radio<Integer>("exradio3", model3));
                    group2.add(new Radio<Integer>("exradio4", model4));
                    group2.add(new Radio<Integer>("exradio5", model5));

                    item.add(group2);
                }
            };
            form.add(persons3);
        }


        if (tempoanswers4 == null) {
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

                    RadioGroup<Integer> group2 = new RadioGroup<Integer>("exradioGroup4", new Model<Integer>(expertAnswers[expertOpinion++]));
                    group2.add(new Radio<Integer>("exradio1", model1));
                    group2.add(new Radio<Integer>("exradio2", model2));
                    group2.add(new Radio<Integer>("exradio3", model3));
                    group2.add(new Radio<Integer>("exradio4", model4));
                    group2.add(new Radio<Integer>("exradio5", model4));


                    item.add(group2);
                }
            };
            form.add(persons4);

        } else {
            ListView<PTSDEntity> persons4 = new ListView<PTSDEntity>("interviews4", listQuestions.subList(3, 9)) {
                @Override
                protected void populateItem(final ListItem<PTSDEntity> item) {


                    item.add(new Label("name4", item.getModel()));
                    Model model0 = new Model<Integer>(0);
                    Model model1 = new Model<Integer>(1);
                    Model model2 = new Model<Integer>(2);
                    Model model3 = new Model<Integer>(3);
                    Model model4 = new Model<Integer>(4);
                    Model model5 = new Model<Integer>(5);


                    RadioGroup<Integer> group = new RadioGroup<Integer>("radioGroup4", new Model<Integer>(AUDITradiovalue4[k4++]));
                    group.add(new Radio<Integer>("radio1", model1));
                    group.add(new Radio<Integer>("radio2", model2));
                    group.add(new Radio<Integer>("radio3", model3));
                    group.add(new Radio<Integer>("radio4", model4));
                    group.add(new Radio<Integer>("radio5", model5));


                    item.add(group);
                    RadioGroup<Integer> group2 = new RadioGroup<Integer>("exradioGroup4", new Model<Integer>(expertAnswers[expertOpinion++]));
                    group2.add(new Radio<Integer>("exradio1", model1));
                    group2.add(new Radio<Integer>("exradio2", model2));
                    group2.add(new Radio<Integer>("exradio3", model3));
                    group2.add(new Radio<Integer>("exradio4", model4));
                    group2.add(new Radio<Integer>("exradio5", model5));

                    item.add(group2);
                }
            };
            form.add(persons4);
        }

        if (tempoanswers5 == null) {
            ListView<PTSDEntity> persons5 = new ListView<PTSDEntity>("interviews5", listQuestions.subList(9, 11)) {
                @Override
                protected void populateItem(ListItem<PTSDEntity> item) {

                    item.add(new Label("name5", item.getModel()));
                    Model model0 = new Model<Integer>(0);
                    Model model1 = new Model<Integer>(1);
                    Model model2 = new Model<Integer>(2);
                    Model model3 = new Model<Integer>(3);
                    Model model4 = new Model<Integer>(4);
                    Model model5 = new Model<Integer>(5);


                    RadioGroup<Integer> group = new RadioGroup<Integer>("radioGroup5", model0);
                    group.add(new Radio<Integer>("radio1", model1));
                    group.add(new Radio<Integer>("radio2", model2));
                    group.add(new Radio<Integer>("radio3", model3));
                    ;

                    item.add(group);

                    RadioGroup<Integer> group2 = new RadioGroup<Integer>("exradioGroup5", new Model<Integer>(expertAnswers[expertOpinion++]));
                    group2.add(new Radio<Integer>("exradio1", model1));
                    group2.add(new Radio<Integer>("exradio2", model2));
                    group2.add(new Radio<Integer>("exradio3", model3));


                    item.add(group2);
                }
            };
            form.add(persons5);

        } else {
            ListView<PTSDEntity> persons5 = new ListView<PTSDEntity>("interviews5", listQuestions.subList(9, 11)) {
                @Override
                protected void populateItem(final ListItem<PTSDEntity> item) {


                    item.add(new Label("name5", item.getModel()));
                    Model model0 = new Model<Integer>(0);
                    Model model1 = new Model<Integer>(1);
                    Model model2 = new Model<Integer>(2);
                    Model model3 = new Model<Integer>(3);
                    Model model4 = new Model<Integer>(4);
                    Model model5 = new Model<Integer>(5);


                    RadioGroup<Integer> group = new RadioGroup<Integer>("radioGroup5", new Model<Integer>(AUDITradiovalue5[k5++]));
                    group.add(new Radio<Integer>("radio1", model1));
                    group.add(new Radio<Integer>("radio2", model2));
                    group.add(new Radio<Integer>("radio3", model3));


                    item.add(group);
                    RadioGroup<Integer> group2 = new RadioGroup<Integer>("exradioGroup5", new Model<Integer>(expertAnswers[expertOpinion++]));
                    group2.add(new Radio<Integer>("exradio1", model1));
                    group2.add(new Radio<Integer>("exradio2", model2));
                    group2.add(new Radio<Integer>("exradio3", model3));


                    item.add(group2);
                }
            };
            form.add(persons5);

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

