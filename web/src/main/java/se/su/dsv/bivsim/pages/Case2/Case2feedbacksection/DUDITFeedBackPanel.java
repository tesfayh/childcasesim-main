package se.su.dsv.bivsim.pages.Case2.Case2feedbacksection;

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

public class DUDITFeedBackPanel extends Panel {


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


    public Integer[] DUDITradiovalue1 = new Integer[13];
    public Integer[] DUDITradiovalue2 = new Integer[13];
    public Integer[] DUDITradiovalue3 = new Integer[13];
    public Integer[] DUDITradiovalue4 = new Integer[13];
    public Integer[] DUDITradiovalue5 = new Integer[13];
    public Integer[] DUDIT = new Integer[13];


    public HashMap<Long, Integer> tempoanswers1;
    public HashMap<Long, Integer> tempoanswers2;
    public HashMap<Long, Integer> tempoanswers3;
    public HashMap<Long, Integer> tempoanswers4;
    public HashMap<Long, Integer> tempoanswers5;
    public HashMap<Long, Integer> tempo;


    String[] questionArrays =
            new String[]{"Hur ofta använder du andra\n" +
                    "droger än alkohol? ",
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
                            " sedan låtit bli att\n" +
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

    int[] expertAnswers = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    int expertOpinion = 0;

    public DUDITFeedBackPanel(String id) {

        super(id);

        tempoanswers1 = (HashMap<Long, Integer>) getSession().getAttribute("DUDITanswer1");
        tempoanswers2 = (HashMap<Long, Integer>) getSession().getAttribute("DUDITanswer2");
        tempoanswers3 = (HashMap<Long, Integer>) getSession().getAttribute("DUDITanswer3");
        tempoanswers4 = (HashMap<Long, Integer>) getSession().getAttribute("DUDITanswer4");
        tempoanswers5 = (HashMap<Long, Integer>) getSession().getAttribute("DUDITanswer5");

        DUDITradiovalue1 = (Integer[]) getSession().getAttribute("DUDITradiovalue1");
        DUDITradiovalue2 = (Integer[]) getSession().getAttribute("DUDITradiovalue2");
        DUDITradiovalue3 = (Integer[]) getSession().getAttribute("DUDITradiovalue3");
        DUDITradiovalue4 = (Integer[]) getSession().getAttribute("DUDITradiovalue4");
        DUDITradiovalue5 = (Integer[]) getSession().getAttribute("DUDITradiovalue5");


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
                    RadioGroup<Integer> group1b = new RadioGroup<Integer>("radioGroup1", new Model<Integer>((DUDITradiovalue1[k1++])));
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
                    ;
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


                    RadioGroup<Integer> group = new RadioGroup<Integer>("radioGroup2", new Model<Integer>(DUDITradiovalue1[k2++]));
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


                    RadioGroup<Integer> group = new RadioGroup<Integer>("radioGroup3", new Model<Integer>(DUDITradiovalue3[k3++]));
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
            ListView<PTSDEntity> persons4 = new ListView<PTSDEntity>("interviews4", listQuestions.subList(3, 10)) {
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
                    ;

                    item.add(group);

                    RadioGroup<Integer> group2 = new RadioGroup<Integer>("exradioGroup4", new Model<Integer>(expertAnswers[expertOpinion++]));
                    group2.add(new Radio<Integer>("exradio1", model1));
                    group2.add(new Radio<Integer>("exradio2", model2));
                    group2.add(new Radio<Integer>("exradio3", model3));

                    item.add(group2);
                }
            };
            form.add(persons4);

        } else {
            ListView<PTSDEntity> persons4 = new ListView<PTSDEntity>("interviews4", listQuestions.subList(3, 10)) {
                @Override
                protected void populateItem(final ListItem<PTSDEntity> item) {


                    item.add(new Label("name4", item.getModel()));
                    Model model0 = new Model<Integer>(0);
                    Model model1 = new Model<Integer>(1);
                    Model model2 = new Model<Integer>(2);
                    Model model3 = new Model<Integer>(3);
                    Model model4 = new Model<Integer>(4);
                    Model model5 = new Model<Integer>(5);


                    RadioGroup<Integer> group = new RadioGroup<Integer>("radioGroup4", new Model<Integer>(DUDITradiovalue4[k4++]));
                    group.add(new Radio<Integer>("radio1", model1));
                    group.add(new Radio<Integer>("radio2", model2));
                    group.add(new Radio<Integer>("radio3", model3));


                    item.add(group);
                    RadioGroup<Integer> group2 = new RadioGroup<Integer>("exradioGroup4", new Model<Integer>(expertAnswers[expertOpinion++]));
                    group2.add(new Radio<Integer>("exradio1", model1));
                    group2.add(new Radio<Integer>("exradio2", model2));
                    group2.add(new Radio<Integer>("exradio3", model3));
                    ;

                    item.add(group2);
                }
            };
            form.add(persons4);
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

