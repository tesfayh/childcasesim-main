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

public class PTSDFeedbackPanel extends Panel {


    int k1 = 0;




    public Integer[] PTSDradiovalue1 = new Integer[40];



    public HashMap<Long, Integer> tempoanswers1;



    String[] questionArrays =
            new String[]{"1. Återkommande, besvärande minnen, tankar eller mentala\n" +
                    "\n" +
                    " bilder av den/de stressfyllda händelsen/rna?\n" +
                    "\n",
                    " 2. Återkommande, besvärande drömmar om den/de\n" +
                            "\n" +
                            " stressfyllda händelsen/rna?\n" +
                            "\n",
                    " 3. Att du plötsligt handlat eller känt som om den/de\n" +
                            "\n" +
                            " stressfyllda händelsen/rna hände igen (som om du gick\n" +
                            "\n" +
                            " igenom det på nytt)?\n" +
                            "\n" ,
                    " 4. Att du känt dig mycket upprörd när något\n" +
                            "\n" +
                            " påminde dig om den/de stressfyllda händelsen/rna?\n" +
                            "\n",
                    " 5. Haft fysiska reaktioner (t.ex. att hjärtat slår tungt,\n" +
                            "\n" +
                            " svårigheter att andas, svettning) när något påmint dig om\n" +
                            "\n" +
                            " den/de stressfyllda händelsen/rna?\n" +
                            "\n" ,
                    " 6. Undvikit att tänka på eller tala om den/de stressfyllda\n" +
                            "\n" +
                            " händelsen/rna eller undvikit känslor som är förknippade\n" +
                            "\n" +
                            " med händelsen/rna?\n" +
                            "\n" ,
                    " 7. Undvikit aktiviteter eller situationer för att de påmint dig\n" +
                            "\n" +
                            " om den/de stressfyllda händelsen/rna?\n" +
                            "\n" ,
                    " 8. Svårigheter att minnas viktiga delar av den/de stressfyllda\n" +
                            "\n" +
                            " händelsen/rna?\n" +
                            "\n" ,
                    " 9. Tappat intresset för aktiviteter som du brukade tycka om?\n" +
                            "\n",
                    " 10. Känslor av att vara distanserad eller avskärmad från\n" +
                            "\n" +
                            " andra människor?\n" +
                            "\n" ,
                    " 11. Känsla av att vara känslomässigt avtrubbad eller vara\n" +
                            "\n" +
                            " oförmögen att ha kärleksfulla känslor för de som står\n" +
                            "\n" +
                            " dig nära?\n" +
                            "\n",
                    " 12. En känsla av att din framtid på något sätt kommer att\n" +
                            "\n" +
                            " förkortas?\n" +
                            "\n",
                    " 13. Svårigheter att somna eller att sömnen störs av att du\n" +
                            "\n" +
                            " vaknar?\n" +
                            "\n" ,
                    " 14. Känt irritation eller haft utbrott av illska?\n" +
                            "\n" ,
                    " 15. Haft koncentrationssvårigheter?\n" +
                            "\n" ,
                    " 16. Varit hyperalert, vaksam eller på din vakt?\n" +
                            "\n" ,
                    " 17. Känt dig lättskrämd eller ryckt till för minsta sak?",

            };
    List listQuestions = Arrays.asList(questionArrays);

    int[] expertAnswers = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    int expertOpinion = 0;

    List listExpertAnswers = Arrays.asList(expertAnswers);

    public PTSDFeedbackPanel(String id) {

        super(id);

        tempoanswers1 = (HashMap<Long, Integer>) getSession().getAttribute("PTSDanswer1");

        PTSDradiovalue1 = (Integer[]) getSession().getAttribute("PTSDradiovalue1");


        Form<?> form = new Form<Void>("form") {
            @Override
            public void onSubmit() {

            }
        };
        add(form);

        if (tempoanswers1 == null) {
            ListView<PTSDEntity> persons1 = new ListView<PTSDEntity>("interviews1", listQuestions.subList(0, 17)) {
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
            ListView<PTSDEntity> persons1 = new ListView<PTSDEntity>("interviews1", listQuestions.subList(0, 17)) {
                @Override
                protected void populateItem(ListItem<PTSDEntity> item) {

                    item.add(new Label("name1", item.getModel()));
                    Model model0 = new Model<Integer>(0);
                    Model model1 = new Model<Integer>(1);
                    Model model2 = new Model<Integer>(2);
                    Model model3 = new Model<Integer>(3);
                    Model model4 = new Model<Integer>(4);
                    Model model5 = new Model<Integer>(5);
                    RadioGroup<Integer> group1b = new RadioGroup<Integer>("radioGroup1", new Model<Integer>((PTSDradiovalue1[k1++])));
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

                setResponsePage(CategoryFeedBackPage.class);

            }


        };
        add(tillbaka);


    }

}

