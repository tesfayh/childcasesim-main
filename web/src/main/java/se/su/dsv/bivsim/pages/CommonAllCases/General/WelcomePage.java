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
import se.su.dsv.childcasesim.pages.CommonAllCases.General.ChooseCase;
import se.su.dsv.childcasesim.pages.CommonAllCases.Setting.AdminHeaderPanel;
import se.su.dsv.childcasesim.pages.CommonAllCases.Setting.StudentHeaderPanel;

import java.util.List;

public class WelcomePage extends WebPage {
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

    public WelcomePage() {

        add(new Label("username", "Inloggad:" + getSession().getAttribute("username").toString()));



        Link info= new AjaxFallbackLink("start") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                setResponsePage(ChooseCase.class);





            }

        };
        this.add(info);

        List<AdminsEntity> logins = adminsEntityDao.findAll();
        for (AdminsEntity login : logins) {
            if (login.getemail().equals(getSession().getAttribute("username")))
                role = login.getrole();

        }
        if(role.equals("Lärare"))
            this.add(new AdminHeaderPanel("adminHeader"));

        else
            this.add(new StudentHeaderPanel("adminHeader"));


    }
}
