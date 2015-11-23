package se.su.dsv.bivsim.pages.CommonAllCases.General;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.spring.injection.annot.SpringBean;
import se.su.dsv.childcasesim.data.Case.dao.interfaces.AdminsEntityDao;
import se.su.dsv.childcasesim.data.Case.dao.interfaces.AllCasesEntityDao;
import se.su.dsv.childcasesim.data.Case.dataobjects.AdminsEntity;
import se.su.dsv.childcasesim.data.Case.dataobjects.AllCasesEntity;
import se.su.dsv.childcasesim.pages.Case1.CommonCase1.BaseClasses.InfoPage;
import se.su.dsv.childcasesim.pages.Case2.Case2Common.BaseClasses.InfoCase2Page;
import se.su.dsv.childcasesim.pages.Case3.Case3Common.BaseClasses.InfoCase3Page;
import se.su.dsv.childcasesim.pages.CommonAllCases.Setting.AdminHeaderPanel;
import se.su.dsv.childcasesim.pages.CommonAllCases.Setting.StudentHeaderPanel;

import java.util.List;

public class ChooseCase extends WebPage {
    private String selected = "Case1(Mrs K)";
    private static final long serialVersionUID = 1L;
    @SpringBean
    private AllCasesEntityDao allCasesEntityDao;
    @SpringBean
    AdminsEntityDao adminsEntityDao;
    private String[] AllTypes = new String[5];
    private List<AllCasesEntity> Types;
    private String role="Student";

    private int i = 0;

    public ChooseCase() {

        //positive feedback from patient  Karin case 1 and 2
        getSession().setAttribute("Öppningsfras", 0);
        getSession().setAttribute("Respekt", 0);
        getSession().setAttribute("Öppnafrågor", 0);
        getSession().setAttribute("3F", 0);
        getSession().setAttribute("Spegling", 0);
        getSession().setAttribute("Empati", 0);
        getSession().setAttribute("Relevans", 0);
        getSession().setAttribute("Tillit", 0);




        //Variables  for expert feedback  karin case 1 and 2.
        getSession().setAttribute("exSpegling", 0);
        getSession().setAttribute("exÖppnafrågor", 0);
        getSession().setAttribute("exEgenbedömning", 0);
        getSession().setAttribute("exSocialt", 0);
        getSession().setAttribute("exFunktionsnivå", 0);
        getSession().setAttribute("exBarn", 0);
        getSession().setAttribute("exMotivation", 0);
        getSession().setAttribute("exPhysical", 0);
        getSession().setAttribute("exLab", 0);



        //common to advisor and patient
        getSession().setAttribute("Antalfrågor", 0);


        //logFiles

        getSession().setAttribute("Interview","");
        getSession().setAttribute("Physical", "");
        getSession().setAttribute("Imaging", "");
        getSession().setAttribute("PHQ9report", "");
        getSession().setAttribute("ASRSreport", "");
        getSession().setAttribute("Auditreport","");
        getSession().setAttribute("Ptsdreport", "");
        getSession().setAttribute("Duditreport", "");
        getSession().setAttribute("MADRSreport", "");
        getSession().setAttribute("IESreport", "");
        getSession().setAttribute("followUpReport", "");
        getSession().setAttribute("PreliminaryReport", "");
        getSession().setAttribute("instrumentValue", "");




        getSession().setAttribute("feedbackInstrumentcollapse", 0);


        getSession().setAttribute("POSInstrument", 0);
        getSession().setAttribute("NEGInstrument", 0);

/*    getSession().setAttribute("extrustValue", 0);
        getSession().setAttribute("exTrustValue", 0);*/
        getSession().setAttribute("followupvalue", 0);
        getSession().setAttribute("referralValue", "");

        getSession().setAttribute("Bedömning", "");


        // assessment values
            getSession().setAttribute("urFysBED", "");
            getSession().setAttribute("urFysATG", "");

            getSession().setAttribute("urFsyBED", "");
            getSession().setAttribute("urFsyATG", "");

            getSession().setAttribute("urSocialBED", "");
            getSession().setAttribute("urSocialATG", "");

            // to know which case selected:
        getSession().setAttribute("case",1);

        add(new Label("username", "Inloggad:" + getSession().getAttribute("username").toString()));

        Link case1 = new AjaxFallbackLink("case1") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                // setResponsePage(CommonEditingPage.class);
                setResponsePage(InfoPage.class);

            }

        };

        this.add(case1);


        Link case2 = new AjaxFallbackLink("case2") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                // setResponsePage(CommonEditingPage.class);

                setResponsePage(InfoCase2Page.class);
                getSession().setAttribute("case",2 );




            }

        };
        this.add(case2);

        Link case3= new AjaxFallbackLink("case3") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                // setResponsePage(CommonEditingPage.class);


                setResponsePage(InfoCase3Page.class);
                getSession().setAttribute("case", 3 );




            }

        };
        this.add(case3);

        List<AdminsEntity> logins = adminsEntityDao.findAll();
        for (AdminsEntity login : logins) {
            if (login.getemail().equals(getSession().getAttribute("username")))
                role = login.getrole();

        }
         if(role.equals("Lärare"))
          this.add(new AdminHeaderPanel("adminHeader"));

        else
        this.add(new StudentHeaderPanel("adminHeader"));

     /*   Types = allCasesEntityDao.findAll();
        for (AllCasesEntity caselist : Types)
            if (!caselist.getName().equals("Free")) {
                AllTypes[i++] = caselist.getName();
            }
        DropDownChoice<String> cases = new DropDownChoice<String>("cases", new PropertyModel<String>(this, "selected"),
                Arrays.asList(AllTypes).subList(0, i));

        Form<?> form = new Form("CaseForm") {
            @Override
            public void onSubmit() {
                String Cases = "";
                for (AllCasesEntity caselist2 : Types)
                    if (caselist2.getName().equals(selected))
                        Cases = caselist2.getCases();

                if (Cases.equals("HomePage1"))
                    setResponsePage(HomePage.class);
                else if (Cases.contains("HomePage2"))
                    setResponsePage(HomePagecase2.class);
                else if (Cases.contains("HomePage3"))
                    setResponsePage(HomePagecase3.class);
                else if (Cases.contains("HomePage4"))
                    setResponsePage(HomePagecase4.class);
            }

        };
        add(form);
        form.add(cases);


        */

    }
}
