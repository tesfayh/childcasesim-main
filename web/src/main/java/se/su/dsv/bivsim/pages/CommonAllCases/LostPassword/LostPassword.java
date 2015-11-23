package se.su.dsv.bivsim.pages.CommonAllCases.LostPassword;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxSubmitLink;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import se.su.dsv.childcasesim.data.Case.dao.interfaces.AdminsEntityDao;
import se.su.dsv.childcasesim.data.Case.dataobjects.AdminsEntity;
import se.su.dsv.childcasesim.pages.Case1.EditingPages.Common.MailClient;
import se.su.dsv.childcasesim.pages.CommonAllCases.LostPassword.BaseClasses.BasePasswordPage;

import java.security.SecureRandom;
import java.util.List;
import java.util.Random;

public class LostPassword extends BasePasswordPage {
    @SpringBean
    AdminsEntityDao adminsEntityDoa;
    private static final Random RANDOM = new SecureRandom();
    public static final int PASSWORD_LENGTH = 8;
    String letters = "abcdefghjkmnpqrstuvwxyzABCDEFGHJKMNPQRSTUVWXYZ23456789+@";
    private String pw = "";

    /*public int[] ARRY = new int[]{1, 2, 3};
    public int[] ARRY2;*/

    private String email;

    public LostPassword() {

        for (int i=0; i<PASSWORD_LENGTH; i++)
        {
            int index = (int)(RANDOM.nextDouble()*letters.length());
            pw += letters.substring(index, index+1);
        }

/*
        FeedbackPanel feedback = new FeedbackPanel("feedback");
*/
        TextField userIdField = new TextField("email", new PropertyModel(this, "email"));
        Form form = new LoginForm("loginForm");
        form.add(userIdField);
/*
        form.add(feedback);
*/
        add(form);


        form.add(new AjaxSubmitLink("Lost") {
            @Override
            protected void onSubmit(AjaxRequestTarget target, Form form) {

            }
        });

         /*

        Form<?> signUp = new Form("SignUp") {
            @Override
            public void onSubmit() {

            }

        };
        add(signUp);
*/


    }

    class LoginForm extends Form {
        public LoginForm(String id) {
            super(id);
        }

        @Override
        public void onSubmit() {




            List<AdminsEntity> checks = adminsEntityDoa.findAll();
            for (AdminsEntity check : checks) {
                if (check.getemail().equals(email)) {
                    AdminsEntity entity = adminsEntityDoa.load(check.getAminId());
                    entity.setPassword(pw);
                    adminsEntityDoa.save(entity);

                    try
                    {
                        MailClient client = new MailClient();
                        String server="smtp.su.se";
                        String from="noreply@su.se";
                        String to = email;
                        String subject="BSAsim lösenordsändring";
                        String message="Hej, du har begärt ett nytt lösenord. Ditt nya lösenord är: "+ pw +"\n"+
                                "Om du vill ändra ditt lösenord när du loggat in kan du göra det i\n" +
                                "                                 inställningsmenyn" +
                                 "\n"+ "Webbadressen till BSAsim är:  https://bsasim.dsv.su.se" ;
                        client.sendMail(server,from,to,subject,message);

                    }
                    catch(Exception e)
                    {
                        e.printStackTrace(System.out);
                    }

                }



            }

         setResponsePage(PasswordchangeMessage.class);
        }





        public String getUserId()
        {
            return email;
        }




    }


}



