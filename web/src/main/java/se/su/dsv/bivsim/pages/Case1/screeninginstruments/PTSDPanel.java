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

public class PTSDPanel extends Panel {

    ;
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

    public HashMap<Long, Integer> answersGroup1;
    public HashMap<Long, Integer> answersGroup2;
    public HashMap<Long, Integer> answersGroup3;
    public HashMap<Long, Integer> answersGroup4;
    public HashMap<Long, Integer> answersGroup5;

    private HashMap<PTSDEntity, RadioGroup<Integer>> questionsGroup1;



    public Integer[] radiovalue1 = new Integer[18];

    public HashMap<Long, Integer> getAnswersGroup1() {
        return answersGroup1;
    }


    public PTSDPanel(String id) {
        super(id);

        final WebMarkupContainer wmc = new WebMarkupContainer("wmc");
        wmc.setOutputMarkupId(true);
        getSession().setAttribute("PTSDtotal", 0);
        questionsGroup1 = new HashMap<PTSDEntity, RadioGroup<Integer>>();
        answersGroup1 = new HashMap<Long, Integer>();



        Form<?> form = new Form<Void>("form") {
            @Override
            public void onSubmit() {
                getSession().setAttribute("PTSDtotal", 0);
                getSession().setAttribute("POSInstrument", (Integer) getSession().getAttribute("POSInstrument") + 1);

                Set<Map.Entry<PTSDEntity, RadioGroup<Integer>>> set = questionsGroup1.entrySet();
                for (Map.Entry<PTSDEntity, RadioGroup<Integer>> entry : set) {
                    if (entry.getValue().getModelObject() != null) {
                        getSession().setAttribute("PTSDtotal", (Integer) getSession().getAttribute("PTSDtotal") + entry.getValue().getModelObject());
                        answersGroup1.put(++i1, entry.getValue().getModelObject());
                        getSession().setAttribute("PTSDanswer1", answersGroup1);
                        if (k1 >= 17)
                            k1 = 0;

                        radiovalue1[k1++] = entry.getValue().getModelObject();


                    }


                    getSession().setAttribute("PTSDradiovalue1", radiovalue1);

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




                getSession().setAttribute("PTSDcreened", 1);


                wmc.replace(new Label("total", "PTSDtotal score:" + getSession().getAttribute("PTSDtotal")));


            }
        };
        add(form);
        form.add(wmc);
        wmc.add(new Label("total", "PTSD total score: 0"));
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

                setResponsePage(InstrumentListPage.class);

            }


        };
        wmc.add(tillbaka);
    }
}
