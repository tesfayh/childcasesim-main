package se.su.dsv.bivsim.pages.CommonAllCases.screeninginstruments;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.ajax.markup.html.form.AjaxSubmitLink;
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

import java.util.*;

public class LitePanel extends Panel {

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
            new String[]{"1.\n" +
                    "Hur ofta har du svårigheter med att avsluta de sista detaljerna i en uppgift/ett\n" +
                    "projekt när de mer krävande momenten har avklarats?\n",
                    "2.\n" +
                            "Hur ofta har du svårigheter med att få ordning på saker och ting när du ska\n" +
                            "utföra en uppgift som kräver organisation?\n"
                    ,
                    "3.\n" +
                            "Hur ofta har du problem att komma ihåg avtalade möten, t ex läkarbesök,\n" +
                            "eller åtaganden?\n",
                    "4. \n" + "Hur ofta händer det att du undviker eller skjuter på att sätta igång med " +
                            "en uppgift som kräver mycket tankemöda",

                    "5.\n" +
                            "Hur ofta händer det att du sitter och plockar med något, eller skruvar på dig\n" +
                            "och rör händer eller fötter när du är tvungen att sitta en längre stund?\n",

                    "6.\n" +
                            "Hur ofta känner du dig överaktiv och tvungen att hålla igång, som om du\n" +
                            "gick på högvarv?\n",

                    "7.\n" +
                            "Hur ofta händer det att du gör slarvfel när du arbetar med en tråkig eller svår\n" +
                            "uppgift?\n",

                    "8.\n" +
                            "Hur ofta händer det att du har svårt att hålla kvar uppmärksamheten när du\n" +
                            "utför tråkigt eller monotont arbete?\n",

                    "9.\n" +
                            "Hur ofta händer det att du har svårt att koncentrera dig på vad folk säger,\n" +
                            "även när de pratar direkt till dig?\n",

                    "10.\n" +
                            "Hur ofta händer det att du förlägger eller har svårt att hitta saker hemma eller\n" +
                            "på arbetet?\n",

                    "11.\n" +
                            "Hur ofta händer det att du distraheras av händelser eller ljud i din omgivning?\n",

                    "12.\n" +
                            "Hur ofta händer det att du lämnar din plats under möten eller i andra\n" +
                            "situationer där du förväntas sitta kvar?\n",

                    "13.\n" +
                            "Hur ofta händer det att du känner dig rastlös eller har svårt att vara stilla?\n",

                    "14.\n" +
                            "Hur ofta händer det att du har svårt att gå ner i varv och koppla av när du har\n" +
                            "en stund över?\n",

                    "15.\n" +
                            "Hur ofta händer det att du kommer på dig med att prata för mycket i sociala\n" +
                            "sammanhang?\n",


                    "16.\n" +
                            "Hur ofta händer det att du avslutar meningar åt dem du talar med, innan de\n" +
                            "själva hinner avsluta dem?\n",

                    "17.\n" +
                            "Hur ofta händer det att du har svårt att vänta på din tur i situationer då det\n" +
                            "krävs?\n",
                    "18.\n" +
                            "Hur ofta händer det att du avbryter/stör andra när de är upptagna?\n",

            };
    List listQuestions = Arrays.asList(questionArrays);

    public HashMap<Long, Integer> answersGroup1;


    private HashMap<PTSDEntity, RadioGroup<Integer>> questionsGroup1;


    public Integer[] radiovalue1 = new Integer[18];

    public HashMap<Long, Integer> getAnswersGroup1()
    {

        return answersGroup1;
    }


    public LitePanel(String id) {
        super(id);

        final WebMarkupContainer wmc = new WebMarkupContainer("wmc");
        wmc.setOutputMarkupId(true);
        getSession().setAttribute("ASRStotal", 0);
        questionsGroup1 = new HashMap<PTSDEntity, RadioGroup<Integer>>();
        answersGroup1 = new HashMap<Long, Integer>();

        Form form = new Form("form");
        form.add(new AjaxSubmitLink("save") {
            @Override
            public void onSubmit(AjaxRequestTarget target, Form<?> form) {
                getSession().setAttribute("ASRStotal", 0);
                getSession().setAttribute("POSInstrument", (Integer) getSession().getAttribute("POSInstrument") + 1);

                Set<Map.Entry<PTSDEntity, RadioGroup<Integer>>> set = questionsGroup1.entrySet();
                for (Map.Entry<PTSDEntity, RadioGroup<Integer>> entry : set) {
                    if (entry.getValue().getModelObject() != null) {
                        getSession().setAttribute("ASRStotal", (Integer) getSession().getAttribute("ASRStotal") + entry.getValue().getModelObject()-1);
                        answersGroup1.put(++i1, entry.getValue().getModelObject());
                        getSession().setAttribute("ASRSanswer1", answersGroup1);
                        if (k1 >= 17)
                            k1 = 0;
                        radiovalue1[k1++] = entry.getValue().getModelObject();

                       /* if (entry.getValue().getModelObject() != null) {
                            String groups;
                            if (entry.getValue().getModelObject() == 1)
                                groups = "Aldrig";
                            else if (entry.getValue().getModelObject() == 2)
                                groups = "Sällan";
                            else if (entry.getValue().getModelObject() == 3)
                                groups = "Ibland";
                            else if (entry.getValue().getModelObject() == 4)
                                groups = "Ofta";
                            else
                                groups = "Mycket ofta";

                            getSession().setAttribute("ASRSreport", getSession().getAttribute("ASRSreport").toString() + "Q:" +
                                    entry.getKey().toString().replaceAll("1.", "").replaceAll("2.", "") + "?" +
                                    "..Ans:" + groups + "#");
                        }*/
                    }
                    getSession().setAttribute("ASRSradiovalue1", radiovalue1);

                }

                getSession().setAttribute("ASRScreened", 1);
                wmc.replace(new Label("total", "ASRS total score:" + getSession().getAttribute("ASRStotal")));
                target.add(wmc);


            }
        });
        add(form);
        wmc.add(new Label("total", "ASRS total score: 0"));
        form.add(wmc);

        /*form.add(new AjaxSubmitLink("send") {
            @Override
            protected void onSubmit(AjaxRequestTarget target, Form form) {
                 System.out.println(getSession().getAttribute("ASRStotal"));
            }
        });*/






        ListView<PTSDEntity> persons1 = new ListView<PTSDEntity>("interviews1", listQuestions.subList(0, 18)) {
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
        add(tillbaka);

    }
}
