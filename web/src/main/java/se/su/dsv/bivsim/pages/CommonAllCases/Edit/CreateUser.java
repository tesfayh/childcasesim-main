package se.su.dsv.bivsim.pages.CommonAllCases.Edit;

import org.apache.wicket.markup.html.form.*;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import se.su.dsv.bivsim.data.Case.dao.interfaces.AdminsEntityDao;
import se.su.dsv.bivsim.data.Case.dataobjects.AdminsEntity;
import se.su.dsv.bivsim.pages.Case1.EditingPages.Common.MailClient;
import se.su.dsv.bivsim.pages.CommonAllCases.Edit.BaseClasses.CommonEditingPage;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class CreateUser extends CommonEditingPage {
    @SpringBean
    AdminsEntityDao adminsEntityDoa;
    private String password;
    private String orgName;
    private String role;
    private String email;
    private String Name;
    private static int exist;
    private String pw = "";
    private String selectedRole;
    private int grp;


    private static final Random RANDOM = new SecureRandom();
    public static final int PASSWORD_LENGTH = 8;
    String letters = "abcdefghjkmnpqrstuvwxyzABCDEFGHJKMNPQRSTUVWXYZ23456789+@";
    private static List<String> GENDER =null;
    private String selected="Student";

    public CreateUser() {

        for (int i=0; i<PASSWORD_LENGTH; i++)
        {
            int index = (int)(RANDOM.nextDouble()*letters.length());
            pw += letters.substring(index, index+1);
        }

        FeedbackPanel feedback = new FeedbackPanel("feedback");
        Form form = new CreateAccountForm("createAccountForm");
        form.add(new TextField("email", new PropertyModel(this, "email")).setRequired(true));
        form.add(new TextField("Name", new PropertyModel(this, "Name")).setRequired(true));
        form.add(new TextField("orgName", new PropertyModel(this, "orgName")).setRequired(true));
        GENDER = Arrays.asList("Student", "Lärare");
        form.add( new RadioChoice<String>("radioButton", new PropertyModel<String>(this, "selected" ),GENDER ).setSuffix(""));

        add(form);
        add(feedback);


    }

    class CreateAccountForm extends Form {
        public CreateAccountForm(String id) {
            super(id);

        }

        @Override
        public void onSubmit() {

            try
            {
                MailClient client = new MailClient();
                String server="smtp.su.se";
                String from="noreply@dsv.su.se";
                String to = getemail();
                String subject="BSAsim Användarnamn och lösenord";
                String message="Hej, här är ditt lösenord och användarnamn för att logga in på BSAsim System" +"\n"+
                        "användarnamn:" +getemail() +"\n"+ "lösenord:"+ pw +"\n"+ "Om du vill ändra ditt lösenord när du loggat in kan du göra det i\n" +
                        "                        inställningsmenyn"  +"\n"+ "\"Webbadressen till BSAsim är:  https://childcasesim-test.dsv.su.se\" " ;
                client.sendMail(server,from,to,subject,message);
            }
            catch(Exception e)
            {
                e.printStackTrace(System.out);
            }


            List<AdminsEntity> checks = adminsEntityDoa.findAll();
            for (AdminsEntity check : checks) {
                if (check.getemail().equals(email)) {
                    exist = 1;
                }



            }

            if (exist == 1)
                info("The email is already exist");
            else {

                AdminsEntity ad = new AdminsEntity();
                ad.setemail(getemail());
                ad.setName(getName());
                ad.setorgName(getOrgName());
                ad.setPassword(pw);
                ad.setrole(selected);
                adminsEntityDoa.save(ad);
/*
                info(" You have added a new user successfully");
*/
                orgName = null;
                role = null;
                email = null;
                Name = null;

                setResponsePage(AndraAddPage.class);


            }
        exist=0;

        }
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


//    public String getName() {
//        return orgName;
//    }
//
//    public void setName(String orgName) {
//        this.orgName = orgName;
//    }

       public String getrole() {
        return role;
    }

    public void setrole(String role) {
        this.role = role;
    }

    public String getemail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

}