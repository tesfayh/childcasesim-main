package se.su.dsv.bivsim.pages.Case1.feedbacksection;

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
import org.apache.wicket.spring.injection.annot.SpringBean;
import se.su.dsv.bivsim.data.Case.dao.interfaces.PTSDEntityDoa;
import se.su.dsv.bivsim.data.Case.dataobjects.PTSDEntity;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PHQ9FeedBackPanel extends Panel {

    @SpringBean
    PTSDEntityDoa ptsdEntityDoa;
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


    public Integer[] Ptsdradiovalue1 = new Integer[13];
    public Integer[] Ptsdradiovalue2 = new Integer[13];

    public HashMap<Long, Integer> tempoanswers1;
    public HashMap<Long, Integer> tempoanswers2;


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

    int[] expertAnswers = new int[]{4, 4, 2, 4, 3, 3, 2, 1, 1, 3};
    int expertOpinion = 0;

    List listExpertAnswers = Arrays.asList(expertAnswers);

    public PHQ9FeedBackPanel(String id) {

        super(id);

        tempoanswers1 = (HashMap<Long, Integer>) getSession().getAttribute("PHQ9answer1");
        tempoanswers2 = (HashMap<Long, Integer>) getSession().getAttribute("PHQ9answer2");


        Ptsdradiovalue1 = (Integer[]) getSession().getAttribute("PHQ9radiovalue1");
        Ptsdradiovalue2 = (Integer[]) getSession().getAttribute("PHQ9radiovalue2");


        Form<?> form = new Form<Void>("form") {
            @Override
            public void onSubmit() {

            }
        };
        add(form);

        if (tempoanswers1 == null) {
            ListView<PTSDEntity> persons1 = new ListView<PTSDEntity>("interviews1", listQuestions.subList(0, 9)) {
                @Override
                protected void populateItem(ListItem<PTSDEntity> item) {


                    item.add(new Label("name1", item.getModel()));
                    Model model0 = new Model<Integer>(0);
                    Model model1 = new Model<Integer>(1);
                    Model model2 = new Model<Integer>(2);
                    Model model3 = new Model<Integer>(3);
                    Model model4 = new Model<Integer>(4);


                    RadioGroup<Integer> group1b = new RadioGroup<Integer>("radioGroup1", model0);
                    group1b.add(new Radio<Integer>("radio1", model1));
                    group1b.add(new Radio<Integer>("radio2", model2));
                    group1b.add(new Radio<Integer>("radio3", model3));
                    group1b.add(new Radio<Integer>("radio4", model4));

                    item.add(group1b);
                    RadioGroup<Integer> group2b = new RadioGroup<Integer>("exRadioGroup1", new Model<Integer>(expertAnswers[expertOpinion++]));
                    /*group.add(new Radio<Integer>("exradio2", model1));
                    group.add(new Radio<Integer>("exradio22", model2));
                    group.add(new Radio<Integer>("exradio32", model3));*/
                    group2b.add(new Radio<Integer>("exradio1", model1));
                    group2b.add(new Radio<Integer>("exradio2", model2));
                    group2b.add(new Radio<Integer>("exradio3", model3));
                    group2b.add(new Radio<Integer>("exradio4", model4));

                    item.add(group2b);
                }
            };
            form.add(persons1);
        } else {
            ListView<PTSDEntity> persons1 = new ListView<PTSDEntity>("interviews1", listQuestions.subList(0, 9)) {
                @Override
                protected void populateItem(ListItem<PTSDEntity> item) {

                    item.add(new Label("name1", item.getModel()));
                    Model model0 = new Model<Integer>(0);
                    Model model1 = new Model<Integer>(1);
                    Model model2 = new Model<Integer>(2);
                    Model model3 = new Model<Integer>(3);
                    Model model4 = new Model<Integer>(4);

                    RadioGroup<Integer> group1b = new RadioGroup<Integer>("radioGroup1", new Model<Integer>((Ptsdradiovalue1[k1++])));
                    group1b.add(new Radio<Integer>("radio1", model1));
                    group1b.add(new Radio<Integer>("radio2", model2));
                    group1b.add(new Radio<Integer>("radio3", model3));
                    group1b.add(new Radio<Integer>("radio4", model4));


                    item.add(group1b);
                    RadioGroup<Integer> group2b = new RadioGroup<Integer>("exRadioGroup1", new Model<Integer>(expertAnswers[expertOpinion++]));
                    /*group.add(new Radio<Integer>("exradio2", model1));
                    group.add(new Radio<Integer>("exradio22", model2));
                    group.add(new Radio<Integer>("exradio32", model3));*/
                    group2b.add(new Radio<Integer>("exradio1", model1));
                    group2b.add(new Radio<Integer>("exradio2", model2));
                    group2b.add(new Radio<Integer>("exradio3", model3));
                    group2b.add(new Radio<Integer>("exradio4", model4));

                    item.add(group2b);
                }
            };
            form.add(persons1);
        }
        if (tempoanswers2 == null) {
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

                    RadioGroup<Integer> group2 = new RadioGroup<Integer>("exRadioGroup2", new Model<Integer>(expertAnswers[expertOpinion++]));
                    group2.add(new Radio<Integer>("exradio1", model1));
                    group2.add(new Radio<Integer>("exradio2", model2));
                    group2.add(new Radio<Integer>("exradio3", model3));
                    group2.add(new Radio<Integer>("exradio4", model4));


                    item.add(group2);
                }
            };
            form.add(persons2);

        } else {
            ListView<PTSDEntity> persons2 = new ListView<PTSDEntity>("interviews2", listQuestions.subList(9, 10)) {
                @Override
                protected void populateItem(final ListItem<PTSDEntity> item) {


                    item.add(new Label("name2", item.getModel()));
                    Model model0 = new Model<Integer>(0);
                    Model model1 = new Model<Integer>(1);
                    Model model2 = new Model<Integer>(2);
                    Model model3 = new Model<Integer>(3);
                    Model model4 = new Model<Integer>(4);


                    RadioGroup<Integer> group = new RadioGroup<Integer>("radioGroup2", new Model<Integer>(Ptsdradiovalue1[k2++]));
                    group.add(new Radio<Integer>("radio1", model1));
                    group.add(new Radio<Integer>("radio2", model2));
                    group.add(new Radio<Integer>("radio3", model3));
                    group.add(new Radio<Integer>("radio4", model4));


                    item.add(group);
                    RadioGroup<Integer> group2 = new RadioGroup<Integer>("exRadioGroup2", new Model<Integer>(expertAnswers[expertOpinion++]));
                    group2.add(new Radio<Integer>("exradio1", model1));
                    group2.add(new Radio<Integer>("exradio2", model2));
                    group2.add(new Radio<Integer>("exradio3", model3));
                    group2.add(new Radio<Integer>("exradio4", model4));

                    item.add(group2);
                }
            };
            form.add(persons2);
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

