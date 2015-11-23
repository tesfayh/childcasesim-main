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

public class MADRSFeedbackPanel extends Panel {


    int i1 = 0;
    int j1 = 0;
    int k1 = 0;
    int k2 = 0;
    int k3 = 0;
    int k4 = 0;
    int k5 = 0;
    int k6 = 0;
    int k7 = 0;
    int k8 = 0;

    int k9 = 0;



    int m1 = 0;
    int Ak = 0;
    int Am = 0;

    private int[] exradiovalue1 = {13};
    private int[] exradiovalue2 = {13};
    private int[] exradiovalue3 = {13};
    private int[] exradiovalue4 = {13};
    private int[] exradiovalue5 = {13};
    private int[] exradiovalue6 = {13};
    private int[] exradiovalue7 = {13};
    private int[] exradiovalue8 = {13};
    private int[] exradiovalue9 = {13};


    public Integer[] MADRSradiovalue1 = new Integer[13];
    public Integer[] MADRSradiovalue2 = new Integer[13];
    public Integer[] MADRSradiovalue3 = new Integer[13];
    public Integer[] MADRSradiovalue4 = new Integer[13];
    public Integer[] MADRSradiovalue5 = new Integer[13];
    public Integer[] MADRSradiovalue6 = new Integer[13];
    public Integer[] MADRSradiovalue7 = new Integer[13];
    public Integer[] MADRSradiovalue8 = new Integer[13];
    public Integer[] MADRSradiovalue9 = new Integer[13];
    public Integer[] MADRS = new Integer[13];


    public HashMap<Long, Integer> tempoanswers1;
    public HashMap<Long, Integer> tempoanswers2;
    public HashMap<Long, Integer> tempoanswers3;
    public HashMap<Long, Integer> tempoanswers4;
    public HashMap<Long, Integer> tempoanswers5;
    public HashMap<Long, Integer> tempoanswers6;
    public HashMap<Long, Integer> tempoanswers7;
    public HashMap<Long, Integer> tempoanswers8;
    public HashMap<Long, Integer> tempoanswers9;
    public HashMap<Long, Integer> tempo;


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

    int[] expertAnswers = new int[]{4,4,3,1,2,4,3,3,2};
    int expertOpinion = 0;


    public MADRSFeedbackPanel(String id) {

        super(id);

        tempoanswers1 = (HashMap<Long, Integer>) getSession().getAttribute("MADRSanswer1");
        tempoanswers2 = (HashMap<Long, Integer>) getSession().getAttribute("MADRSanswer2");
        tempoanswers3 = (HashMap<Long, Integer>) getSession().getAttribute("MADRSanswer3");
        tempoanswers4 = (HashMap<Long, Integer>) getSession().getAttribute("MADRSanswer4");
        tempoanswers5 = (HashMap<Long, Integer>) getSession().getAttribute("MADRSanswer5");
        tempoanswers6 = (HashMap<Long, Integer>) getSession().getAttribute("MADRSanswer6");
        tempoanswers7 = (HashMap<Long, Integer>) getSession().getAttribute("MADRSanswer7");
        tempoanswers8 = (HashMap<Long, Integer>) getSession().getAttribute("MADRSanswer8");
        tempoanswers9 = (HashMap<Long, Integer>) getSession().getAttribute("MADRSanswer9");

        MADRSradiovalue1 = (Integer[]) getSession().getAttribute("MADRSradiovalue1");
        MADRSradiovalue2 = (Integer[]) getSession().getAttribute("MADRSradiovalue2");
        MADRSradiovalue3 = (Integer[]) getSession().getAttribute("MADRSradiovalue3");
        MADRSradiovalue4 = (Integer[]) getSession().getAttribute("MADRSradiovalue4");
        MADRSradiovalue5 = (Integer[]) getSession().getAttribute("MADRSradiovalue5");
        MADRSradiovalue6 = (Integer[]) getSession().getAttribute("MADRSradiovalue6");
        MADRSradiovalue7 = (Integer[]) getSession().getAttribute("MADRSradiovalue7");
        MADRSradiovalue8 = (Integer[]) getSession().getAttribute("MADRSradiovalue8");
        MADRSradiovalue9 = (Integer[]) getSession().getAttribute("MADRSradiovalue9");

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
                    Model model6 = new Model<Integer>(6);
                    Model model7 = new Model<Integer>(7);

                    RadioGroup<Integer> group1b = new RadioGroup<Integer>("radioGroup1", model0);
                    group1b.add(new Radio<Integer>("radio1", model1));
                    group1b.add(new Radio<Integer>("radio2", model2));
                    group1b.add(new Radio<Integer>("radio3", model3));
                    group1b.add(new Radio<Integer>("radio4", model4));
                    group1b.add(new Radio<Integer>("radio5", model5));
                    group1b.add(new Radio<Integer>("radio6", model6));
                    group1b.add(new Radio<Integer>("radio7", model7));

                    item.add(group1b);
                    RadioGroup<Integer> group2b = new RadioGroup<Integer>("exRadioGroup1", new Model<Integer>(expertAnswers[expertOpinion++]));

                    group2b.add(new Radio<Integer>("exradio1", model1));
                    group2b.add(new Radio<Integer>("exradio2", model2));
                    group2b.add(new Radio<Integer>("exradio3", model1));
                    group2b.add(new Radio<Integer>("exradio4", model2));
                    group2b.add(new Radio<Integer>("exradio5", model1));
                    group2b.add(new Radio<Integer>("exradio6", model2));
                    group2b.add(new Radio<Integer>("exradio7", model7));

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
                    Model model6 = new Model<Integer>(6);
                    Model model7 = new Model<Integer>(7);

                    RadioGroup<Integer> group1b = new RadioGroup<Integer>("radioGroup1", new Model<Integer>((MADRSradiovalue1[k1++])));
                    group1b.add(new Radio<Integer>("radio1", model1));
                    group1b.add(new Radio<Integer>("radio2", model2));
                    group1b.add(new Radio<Integer>("radio3", model3));
                    group1b.add(new Radio<Integer>("radio4", model4));
                    group1b.add(new Radio<Integer>("radio5", model5));
                    group1b.add(new Radio<Integer>("radio6", model6));
                    group1b.add(new Radio<Integer>("radio7", model7));

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
                    group2b.add(new Radio<Integer>("exradio6", model6));
                    group2b.add(new Radio<Integer>("exradio7", model7));

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
                    Model model6 = new Model<Integer>(6);
                    Model model7 = new Model<Integer>(7);

                    RadioGroup<Integer> group1b = new RadioGroup<Integer>("radioGroup2", model0);
                    group1b.add(new Radio<Integer>("radio1", model1));
                    group1b.add(new Radio<Integer>("radio2", model2));
                    group1b.add(new Radio<Integer>("radio3", model3));
                    group1b.add(new Radio<Integer>("radio4", model4));
                    group1b.add(new Radio<Integer>("radio5", model5));
                    group1b.add(new Radio<Integer>("radio6", model6));
                    group1b.add(new Radio<Integer>("radio7", model7));

                    item.add(group1b);
                    RadioGroup<Integer> group2b = new RadioGroup<Integer>("exRadioGroup2", new Model<Integer>(expertAnswers[expertOpinion++]));
                    /*group.add(new Radio<Integer>("exradio2", model1));
                    group.add(new Radio<Integer>("exradio22", model2));
                    group.add(new Radio<Integer>("exradio32", model3));*/
                    group2b.add(new Radio<Integer>("exradio1", model1));
                    group2b.add(new Radio<Integer>("exradio2", model2));
                    group2b.add(new Radio<Integer>("exradio3", model1));
                    group2b.add(new Radio<Integer>("exradio4", model2));
                    group2b.add(new Radio<Integer>("exradio5", model1));
                    group2b.add(new Radio<Integer>("exradio6", model2));
                    group2b.add(new Radio<Integer>("exradio7", model7));

                    item.add(group2b);
                }
            };
            form.add(persons2);
        } else {
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

                    RadioGroup<Integer> group1b = new RadioGroup<Integer>("radioGroup2", new Model<Integer>((MADRSradiovalue2[k2++])));
                    group1b.add(new Radio<Integer>("radio1", model1));
                    group1b.add(new Radio<Integer>("radio2", model2));
                    group1b.add(new Radio<Integer>("radio3", model3));
                    group1b.add(new Radio<Integer>("radio4", model4));
                    group1b.add(new Radio<Integer>("radio5", model5));
                    group1b.add(new Radio<Integer>("radio6", model6));
                    group1b.add(new Radio<Integer>("radio7", model7));

                    item.add(group1b);
                    RadioGroup<Integer> group2b = new RadioGroup<Integer>("exRadioGroup2", new Model<Integer>(expertAnswers[expertOpinion++]));
                    /*group.add(new Radio<Integer>("exradio2", model1));
                    group.add(new Radio<Integer>("exradio22", model2));
                    group.add(new Radio<Integer>("exradio32", model3));*/
                    group2b.add(new Radio<Integer>("exradio1", model1));
                    group2b.add(new Radio<Integer>("exradio2", model2));
                    group2b.add(new Radio<Integer>("exradio3", model3));
                    group2b.add(new Radio<Integer>("exradio4", model4));
                    group2b.add(new Radio<Integer>("exradio5", model5));
                    group2b.add(new Radio<Integer>("exradio6", model6));
                    group2b.add(new Radio<Integer>("exradio7", model7));

                    item.add(group2b);
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
                        Model model6 = new Model<Integer>(6);
                        Model model7 = new Model<Integer>(7);

                        RadioGroup<Integer> group1b = new RadioGroup<Integer>("radioGroup3", model0);
                        group1b.add(new Radio<Integer>("radio1", model1));
                        group1b.add(new Radio<Integer>("radio2", model2));
                        group1b.add(new Radio<Integer>("radio3", model3));
                        group1b.add(new Radio<Integer>("radio4", model4));
                        group1b.add(new Radio<Integer>("radio5", model5));
                        group1b.add(new Radio<Integer>("radio6", model6));
                        group1b.add(new Radio<Integer>("radio7", model7));

                        item.add(group1b);
                        RadioGroup<Integer> group2b = new RadioGroup<Integer>("exRadioGroup3", new Model<Integer>(expertAnswers[expertOpinion++]));
                    /*group.add(new Radio<Integer>("exradio2", model1));
                    group.add(new Radio<Integer>("exradio22", model2));
                    group.add(new Radio<Integer>("exradio32", model3));*/
                        group2b.add(new Radio<Integer>("exradio1", model1));
                        group2b.add(new Radio<Integer>("exradio2", model2));
                        group2b.add(new Radio<Integer>("exradio3", model1));
                        group2b.add(new Radio<Integer>("exradio4", model2));
                        group2b.add(new Radio<Integer>("exradio5", model1));
                        group2b.add(new Radio<Integer>("exradio6", model2));
                        group2b.add(new Radio<Integer>("exradio7", model7));

                        item.add(group2b);
                    }
                };
                form.add(persons3);
            } else {
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

                        RadioGroup<Integer> group1b = new RadioGroup<Integer>("radioGroup3", new Model<Integer>((MADRSradiovalue3[k3++])));
                        group1b.add(new Radio<Integer>("radio1", model1));
                        group1b.add(new Radio<Integer>("radio2", model2));
                        group1b.add(new Radio<Integer>("radio3", model3));
                        group1b.add(new Radio<Integer>("radio4", model4));
                        group1b.add(new Radio<Integer>("radio5", model5));
                        group1b.add(new Radio<Integer>("radio6", model6));
                        group1b.add(new Radio<Integer>("radio7", model7));

                        item.add(group1b);
                        RadioGroup<Integer> group2b = new RadioGroup<Integer>("exRadioGroup3", new Model<Integer>(expertAnswers[expertOpinion++]));
                    /*group.add(new Radio<Integer>("exradio2", model1));
                    group.add(new Radio<Integer>("exradio22", model2));
                    group.add(new Radio<Integer>("exradio32", model3));*/
                        group2b.add(new Radio<Integer>("exradio1", model1));
                        group2b.add(new Radio<Integer>("exradio2", model2));
                        group2b.add(new Radio<Integer>("exradio3", model3));
                        group2b.add(new Radio<Integer>("exradio4", model4));
                        group2b.add(new Radio<Integer>("exradio5", model5));
                        group2b.add(new Radio<Integer>("exradio6", model6));
                        group2b.add(new Radio<Integer>("exradio7", model7));

                        item.add(group2b);
                    }
                };
                form.add(persons3);


            }

                if (tempoanswers4 == null) {
                    ListView<PTSDEntity> persons4= new ListView<PTSDEntity>("interviews4", listQuestions.subList(3, 4)) {
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

                            RadioGroup<Integer> group1b = new RadioGroup<Integer>("radioGroup4", model0);
                            group1b.add(new Radio<Integer>("radio1", model1));
                            group1b.add(new Radio<Integer>("radio2", model2));
                            group1b.add(new Radio<Integer>("radio3", model3));
                            group1b.add(new Radio<Integer>("radio4", model4));
                            group1b.add(new Radio<Integer>("radio5", model5));
                            group1b.add(new Radio<Integer>("radio6", model6));
                            group1b.add(new Radio<Integer>("radio7", model7));

                            item.add(group1b);
                            RadioGroup<Integer> group2b = new RadioGroup<Integer>("exRadioGroup4", new Model<Integer>(expertAnswers[expertOpinion++]));
                    /*group.add(new Radio<Integer>("exradio2", model1));
                    group.add(new Radio<Integer>("exradio22", model2));
                    group.add(new Radio<Integer>("exradio32", model3));*/
                            group2b.add(new Radio<Integer>("exradio1", model1));
                            group2b.add(new Radio<Integer>("exradio2", model2));
                            group2b.add(new Radio<Integer>("exradio3", model1));
                            group2b.add(new Radio<Integer>("exradio4", model2));
                            group2b.add(new Radio<Integer>("exradio5", model1));
                            group2b.add(new Radio<Integer>("exradio6", model2));
                            group2b.add(new Radio<Integer>("exradio7", model7));

                            item.add(group2b);
                        }
                    };
                    form.add(persons4);
                } else {
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

                            RadioGroup<Integer> group1b = new RadioGroup<Integer>("radioGroup4", new Model<Integer>((MADRSradiovalue4[k4++])));
                            group1b.add(new Radio<Integer>("radio1", model1));
                            group1b.add(new Radio<Integer>("radio2", model2));
                            group1b.add(new Radio<Integer>("radio3", model3));
                            group1b.add(new Radio<Integer>("radio4", model4));
                            group1b.add(new Radio<Integer>("radio5", model5));
                            group1b.add(new Radio<Integer>("radio6", model6));
                            group1b.add(new Radio<Integer>("radio7", model7));

                            item.add(group1b);
                            RadioGroup<Integer> group2b = new RadioGroup<Integer>("exRadioGroup4", new Model<Integer>(expertAnswers[expertOpinion++]));
                    /*group.add(new Radio<Integer>("exradio2", model1));
                    group.add(new Radio<Integer>("exradio22", model2));
                    group.add(new Radio<Integer>("exradio32", model3));*/
                            group2b.add(new Radio<Integer>("exradio1", model1));
                            group2b.add(new Radio<Integer>("exradio2", model2));
                            group2b.add(new Radio<Integer>("exradio3", model3));
                            group2b.add(new Radio<Integer>("exradio4", model4));
                            group2b.add(new Radio<Integer>("exradio5", model5));
                            group2b.add(new Radio<Integer>("exradio6", model6));
                            group2b.add(new Radio<Integer>("exradio7", model7));

                            item.add(group2b);
                        }
                    };
                    form.add(persons4);
        }




        if (tempoanswers5 == null) {
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

                    RadioGroup<Integer> group1b = new RadioGroup<Integer>("radioGroup5", model0);
                    group1b.add(new Radio<Integer>("radio1", model1));
                    group1b.add(new Radio<Integer>("radio2", model2));
                    group1b.add(new Radio<Integer>("radio3", model3));
                    group1b.add(new Radio<Integer>("radio4", model4));
                    group1b.add(new Radio<Integer>("radio5", model5));
                    group1b.add(new Radio<Integer>("radio6", model6));
                    group1b.add(new Radio<Integer>("radio7", model7));

                    item.add(group1b);
                    RadioGroup<Integer> group2b = new RadioGroup<Integer>("exRadioGroup5", new Model<Integer>(expertAnswers[expertOpinion++]));
                    /*group.add(new Radio<Integer>("exradio2", model1));
                    group.add(new Radio<Integer>("exradio22", model2));
                    group.add(new Radio<Integer>("exradio32", model3));*/
                    group2b.add(new Radio<Integer>("exradio1", model1));
                    group2b.add(new Radio<Integer>("exradio2", model2));
                    group2b.add(new Radio<Integer>("exradio3", model1));
                    group2b.add(new Radio<Integer>("exradio4", model2));
                    group2b.add(new Radio<Integer>("exradio5", model1));
                    group2b.add(new Radio<Integer>("exradio6", model2));
                    group2b.add(new Radio<Integer>("exradio7", model7));

                    item.add(group2b);
                }
            };
            form.add(persons5);
        } else {
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

                    RadioGroup<Integer> group1b = new RadioGroup<Integer>("radioGroup5", new Model<Integer>((MADRSradiovalue5[k5++])));
                    group1b.add(new Radio<Integer>("radio1", model1));
                    group1b.add(new Radio<Integer>("radio2", model2));
                    group1b.add(new Radio<Integer>("radio3", model3));
                    group1b.add(new Radio<Integer>("radio4", model4));
                    group1b.add(new Radio<Integer>("radio5", model5));
                    group1b.add(new Radio<Integer>("radio6", model6));
                    group1b.add(new Radio<Integer>("radio7", model7));

                    item.add(group1b);
                    RadioGroup<Integer> group2b = new RadioGroup<Integer>("exRadioGroup5", new Model<Integer>(expertAnswers[expertOpinion++]));
                    /*group.add(new Radio<Integer>("exradio2", model1));
                    group.add(new Radio<Integer>("exradio22", model2));
                    group.add(new Radio<Integer>("exradio32", model3));*/
                    group2b.add(new Radio<Integer>("exradio1", model1));
                    group2b.add(new Radio<Integer>("exradio2", model2));
                    group2b.add(new Radio<Integer>("exradio3", model3));
                    group2b.add(new Radio<Integer>("exradio4", model4));
                    group2b.add(new Radio<Integer>("exradio5", model5));
                    group2b.add(new Radio<Integer>("exradio6", model6));
                    group2b.add(new Radio<Integer>("exradio7", model7));

                    item.add(group2b);
                }
            };
            form.add(persons5);


        }




        if (tempoanswers6 == null) {
            ListView<PTSDEntity> persons6= new ListView<PTSDEntity>("interviews6", listQuestions.subList(5, 6)) {
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

                    RadioGroup<Integer> group1b = new RadioGroup<Integer>("radioGroup6", model0);
                    group1b.add(new Radio<Integer>("radio1", model1));
                    group1b.add(new Radio<Integer>("radio2", model2));
                    group1b.add(new Radio<Integer>("radio3", model3));
                    group1b.add(new Radio<Integer>("radio4", model4));
                    group1b.add(new Radio<Integer>("radio5", model5));
                    group1b.add(new Radio<Integer>("radio6", model6));
                    group1b.add(new Radio<Integer>("radio7", model7));

                    item.add(group1b);
                    RadioGroup<Integer> group2b = new RadioGroup<Integer>("exRadioGroup6", new Model<Integer>(expertAnswers[expertOpinion++]));
                    /*group.add(new Radio<Integer>("exradio2", model1));
                    group.add(new Radio<Integer>("exradio22", model2));
                    group.add(new Radio<Integer>("exradio32", model3));*/
                    group2b.add(new Radio<Integer>("exradio1", model1));
                    group2b.add(new Radio<Integer>("exradio2", model2));
                    group2b.add(new Radio<Integer>("exradio3", model1));
                    group2b.add(new Radio<Integer>("exradio4", model2));
                    group2b.add(new Radio<Integer>("exradio5", model1));
                    group2b.add(new Radio<Integer>("exradio6", model2));
                    group2b.add(new Radio<Integer>("exradio7", model7));

                    item.add(group2b);
                }
            };
            form.add(persons6);
        } else {
            ListView<PTSDEntity> persons6= new ListView<PTSDEntity>("interviews6", listQuestions.subList(5, 6)) {
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

                    RadioGroup<Integer> group1b = new RadioGroup<Integer>("radioGroup6", new Model<Integer>((MADRSradiovalue6[k6++])));
                    group1b.add(new Radio<Integer>("radio1", model1));
                    group1b.add(new Radio<Integer>("radio2", model2));
                    group1b.add(new Radio<Integer>("radio3", model3));
                    group1b.add(new Radio<Integer>("radio4", model4));
                    group1b.add(new Radio<Integer>("radio5", model5));
                    group1b.add(new Radio<Integer>("radio6", model6));
                    group1b.add(new Radio<Integer>("radio7", model7));

                    item.add(group1b);
                    RadioGroup<Integer> group2b = new RadioGroup<Integer>("exRadioGroup6", new Model<Integer>(expertAnswers[expertOpinion++]));
                    /*group.add(new Radio<Integer>("exradio2", model1));
                    group.add(new Radio<Integer>("exradio22", model2));
                    group.add(new Radio<Integer>("exradio32", model3));*/
                    group2b.add(new Radio<Integer>("exradio1", model1));
                    group2b.add(new Radio<Integer>("exradio2", model2));
                    group2b.add(new Radio<Integer>("exradio3", model3));
                    group2b.add(new Radio<Integer>("exradio4", model4));
                    group2b.add(new Radio<Integer>("exradio5", model5));
                    group2b.add(new Radio<Integer>("exradio6", model6));
                    group2b.add(new Radio<Integer>("exradio7", model7));

                    item.add(group2b);
                }
            };
            form.add(persons6);


        }


        if (tempoanswers7 == null) {
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

                    RadioGroup<Integer> group1b = new RadioGroup<Integer>("radioGroup7", model0);
                    group1b.add(new Radio<Integer>("radio1", model1));
                    group1b.add(new Radio<Integer>("radio2", model2));
                    group1b.add(new Radio<Integer>("radio3", model3));
                    group1b.add(new Radio<Integer>("radio4", model4));
                    group1b.add(new Radio<Integer>("radio5", model5));
                    group1b.add(new Radio<Integer>("radio6", model6));
                    group1b.add(new Radio<Integer>("radio7", model7));

                    item.add(group1b);
                    RadioGroup<Integer> group2b = new RadioGroup<Integer>("exRadioGroup7", new Model<Integer>(expertAnswers[expertOpinion++]));
                    /*group.add(new Radio<Integer>("exradio2", model1));
                    group.add(new Radio<Integer>("exradio22", model2));
                    group.add(new Radio<Integer>("exradio32", model3));*/
                    group2b.add(new Radio<Integer>("exradio1", model1));
                    group2b.add(new Radio<Integer>("exradio2", model2));
                    group2b.add(new Radio<Integer>("exradio3", model1));
                    group2b.add(new Radio<Integer>("exradio4", model2));
                    group2b.add(new Radio<Integer>("exradio5", model1));
                    group2b.add(new Radio<Integer>("exradio6", model2));
                    group2b.add(new Radio<Integer>("exradio7", model7));

                    item.add(group2b);
                }
            };
            form.add(persons7);
        } else {
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

                    RadioGroup<Integer> group1b = new RadioGroup<Integer>("radioGroup7", new Model<Integer>((MADRSradiovalue7[k7++])));
                    group1b.add(new Radio<Integer>("radio1", model1));
                    group1b.add(new Radio<Integer>("radio2", model2));
                    group1b.add(new Radio<Integer>("radio3", model3));
                    group1b.add(new Radio<Integer>("radio4", model4));
                    group1b.add(new Radio<Integer>("radio5", model5));
                    group1b.add(new Radio<Integer>("radio6", model6));
                    group1b.add(new Radio<Integer>("radio7", model7));

                    item.add(group1b);
                    RadioGroup<Integer> group2b = new RadioGroup<Integer>("exRadioGroup7", new Model<Integer>(expertAnswers[expertOpinion++]));
                    /*group.add(new Radio<Integer>("exradio2", model1));
                    group.add(new Radio<Integer>("exradio22", model2));
                    group.add(new Radio<Integer>("exradio32", model3));*/
                    group2b.add(new Radio<Integer>("exradio1", model1));
                    group2b.add(new Radio<Integer>("exradio2", model2));
                    group2b.add(new Radio<Integer>("exradio3", model3));
                    group2b.add(new Radio<Integer>("exradio4", model4));
                    group2b.add(new Radio<Integer>("exradio5", model5));
                    group2b.add(new Radio<Integer>("exradio6", model6));
                    group2b.add(new Radio<Integer>("exradio7", model7));

                    item.add(group2b);
                }
            };
            form.add(persons7);


        }


        if (tempoanswers8 == null) {
            ListView<PTSDEntity> persons8= new ListView<PTSDEntity>("interviews8", listQuestions.subList(7, 8)) {
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

                    RadioGroup<Integer> group1b = new RadioGroup<Integer>("radioGroup8", model0);
                    group1b.add(new Radio<Integer>("radio1", model1));
                    group1b.add(new Radio<Integer>("radio2", model2));
                    group1b.add(new Radio<Integer>("radio3", model3));
                    group1b.add(new Radio<Integer>("radio4", model4));
                    group1b.add(new Radio<Integer>("radio5", model5));
                    group1b.add(new Radio<Integer>("radio6", model6));
                    group1b.add(new Radio<Integer>("radio7", model7));

                    item.add(group1b);
                    RadioGroup<Integer> group2b = new RadioGroup<Integer>("exRadioGroup8", new Model<Integer>(expertAnswers[expertOpinion++]));
                    /*group.add(new Radio<Integer>("exradio2", model1));
                    group.add(new Radio<Integer>("exradio22", model2));
                    group.add(new Radio<Integer>("exradio32", model3));*/
                    group2b.add(new Radio<Integer>("exradio1", model1));
                    group2b.add(new Radio<Integer>("exradio2", model2));
                    group2b.add(new Radio<Integer>("exradio3", model1));
                    group2b.add(new Radio<Integer>("exradio4", model2));
                    group2b.add(new Radio<Integer>("exradio5", model1));
                    group2b.add(new Radio<Integer>("exradio6", model2));
                    group2b.add(new Radio<Integer>("exradio7", model7));

                    item.add(group2b);
                }
            };
            form.add(persons8);
        } else {
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

                    RadioGroup<Integer> group1b = new RadioGroup<Integer>("radioGroup8", new Model<Integer>((MADRSradiovalue8[k8++])));
                    group1b.add(new Radio<Integer>("radio1", model1));
                    group1b.add(new Radio<Integer>("radio2", model2));
                    group1b.add(new Radio<Integer>("radio3", model3));
                    group1b.add(new Radio<Integer>("radio4", model4));
                    group1b.add(new Radio<Integer>("radio5", model5));
                    group1b.add(new Radio<Integer>("radio6", model6));
                    group1b.add(new Radio<Integer>("radio7", model7));

                    item.add(group1b);
                    RadioGroup<Integer> group2b = new RadioGroup<Integer>("exRadioGroup8", new Model<Integer>(expertAnswers[expertOpinion++]));
                    /*group.add(new Radio<Integer>("exradio2", model1));
                    group.add(new Radio<Integer>("exradio22", model2));
                    group.add(new Radio<Integer>("exradio32", model3));*/
                    group2b.add(new Radio<Integer>("exradio1", model1));
                    group2b.add(new Radio<Integer>("exradio2", model2));
                    group2b.add(new Radio<Integer>("exradio3", model3));
                    group2b.add(new Radio<Integer>("exradio4", model4));
                    group2b.add(new Radio<Integer>("exradio5", model5));
                    group2b.add(new Radio<Integer>("exradio6", model6));
                    group2b.add(new Radio<Integer>("exradio7", model7));

                    item.add(group2b);
                }
            };
            form.add(persons8);


        }


        if (tempoanswers9 == null) {
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

                    RadioGroup<Integer> group1b = new RadioGroup<Integer>("radioGroup9", model0);
                    group1b.add(new Radio<Integer>("radio1", model1));
                    group1b.add(new Radio<Integer>("radio2", model2));
                    group1b.add(new Radio<Integer>("radio3", model3));
                    group1b.add(new Radio<Integer>("radio4", model4));
                    group1b.add(new Radio<Integer>("radio5", model5));
                    group1b.add(new Radio<Integer>("radio6", model6));
                    group1b.add(new Radio<Integer>("radio7", model7));

                    item.add(group1b);
                    RadioGroup<Integer> group2b = new RadioGroup<Integer>("exRadioGroup9", new Model<Integer>(expertAnswers[expertOpinion++]));
                    /*group.add(new Radio<Integer>("exradio2", model1));
                    group.add(new Radio<Integer>("exradio22", model2));
                    group.add(new Radio<Integer>("exradio32", model3));*/
                    group2b.add(new Radio<Integer>("exradio1", model1));
                    group2b.add(new Radio<Integer>("exradio2", model2));
                    group2b.add(new Radio<Integer>("exradio3", model1));
                    group2b.add(new Radio<Integer>("exradio4", model2));
                    group2b.add(new Radio<Integer>("exradio5", model1));
                    group2b.add(new Radio<Integer>("exradio6", model2));
                    group2b.add(new Radio<Integer>("exradio7", model7));

                    item.add(group2b);
                }
            };
            form.add(persons9);
        } else {
            ListView<PTSDEntity> persons9 = new ListView<PTSDEntity>("interviews9", listQuestions.subList(8,9)) {
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

                    RadioGroup<Integer> group1b = new RadioGroup<Integer>("radioGroup9", new Model<Integer>((MADRSradiovalue9[k9++])));
                    group1b.add(new Radio<Integer>("radio1", model1));
                    group1b.add(new Radio<Integer>("radio2", model2));
                    group1b.add(new Radio<Integer>("radio3", model3));
                    group1b.add(new Radio<Integer>("radio4", model4));
                    group1b.add(new Radio<Integer>("radio5", model5));
                    group1b.add(new Radio<Integer>("radio6", model6));
                    group1b.add(new Radio<Integer>("radio7", model7));

                    item.add(group1b);
                    RadioGroup<Integer> group2b = new RadioGroup<Integer>("exRadioGroup9", new Model<Integer>(expertAnswers[expertOpinion++]));
                    /*group.add(new Radio<Integer>("exradio2", model1));
                    group.add(new Radio<Integer>("exradio22", model2));
                    group.add(new Radio<Integer>("exradio32", model3));*/
                    group2b.add(new Radio<Integer>("exradio1", model1));
                    group2b.add(new Radio<Integer>("exradio2", model2));
                    group2b.add(new Radio<Integer>("exradio3", model3));
                    group2b.add(new Radio<Integer>("exradio4", model4));
                    group2b.add(new Radio<Integer>("exradio5", model5));
                    group2b.add(new Radio<Integer>("exradio6", model6));
                    group2b.add(new Radio<Integer>("exradio7", model7));

                    item.add(group2b);
                }
            };
            form.add(persons9);


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
