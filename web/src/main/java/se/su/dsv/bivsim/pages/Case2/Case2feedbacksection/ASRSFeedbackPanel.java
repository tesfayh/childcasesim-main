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

public class ASRSFeedbackPanel extends Panel {


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


    public Integer[] ASRSradiovalue1 = new Integer[18];
    public Integer[] AUDITradiovalue2 = new Integer[13];
    public Integer[] AUDITradiovalue3 = new Integer[13];
    public Integer[] AUDITradiovalue4 = new Integer[13];
    public Integer[] AUDITradiovalue5 = new Integer[13];
    public Integer[] AUDIT = new Integer[18];


    public HashMap<Long, Integer> tempoanswers1;
    public HashMap<Long, Integer> tempoanswers2;
    public HashMap<Long, Integer> tempoanswers3;
    public HashMap<Long, Integer> tempoanswers4;
    public HashMap<Long, Integer> tempoanswers5;
    public HashMap<Long, Integer> tempo;


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

    int[] expertAnswers = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    int expertOpinion = 0;

    List listExpertAnswers = Arrays.asList(expertAnswers);

    public ASRSFeedbackPanel(String id) {

        super(id);

        tempoanswers1 = (HashMap<Long, Integer>) getSession().getAttribute("IESRanswer1");
        /*tempoanswers2 = (HashMap<Long, Integer>) getSession().getAttribute("AUDITanswer2");
        tempoanswers3 = (HashMap<Long, Integer>) getSession().getAttribute("AUDITanswer3");
        tempoanswers4 = (HashMap<Long, Integer>) getSession().getAttribute("AUDITanswer4");
        tempoanswers5 = (HashMap<Long, Integer>) getSession().getAttribute("AUDITanswer5");
*/
        ASRSradiovalue1 = (Integer[]) getSession().getAttribute("ASRSradiovalue1");
        /*AUDITradiovalue2 = (Integer[]) getSession().getAttribute("AUDITradiovalue2");
        AUDITradiovalue3 = (Integer[]) getSession().getAttribute("AUDITradiovalue3");
        AUDITradiovalue4 = (Integer[]) getSession().getAttribute("AUDITradiovalue4");
        AUDITradiovalue5 = (Integer[]) getSession().getAttribute("AUDITradiovalue5");


*/


        Form<?> form = new Form<Void>("form") {
            @Override
            public void onSubmit() {

            }
        };
        add(form);

        if (tempoanswers1 == null) {
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
                    RadioGroup<Integer> group1b = new RadioGroup<Integer>("radioGroup1", new Model<Integer>((ASRSradiovalue1[k1++])));
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

                setResponsePage(CategoryFeedbackInstrumentPage.class);

            }


        };
        form.add(tillbaka);


    }

}

