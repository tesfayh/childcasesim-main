package se.su.dsv.bivsim.pages.CommonAllCases;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.ajax.markup.html.form.AjaxSubmitLink;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.PropertyModel;
import se.su.dsv.childcasesim.pages.CommonAllCases.General.WelcomePage;
import se.su.dsv.childcasesim.pages.CommonAllCases.LostPassword.LostPassword;

public class SignIn extends WebPage {

    /*public int[] ARRY = new int[]{1, 2, 3};
    public int[] ARRY2;*/

    private String email;
    private String password;

    public SignIn() {

        FeedbackPanel feedback = new FeedbackPanel("feedback");
        add(feedback);
        TextField userIdField = new TextField("email", new PropertyModel(this, "email"));
        PasswordTextField passField = new PasswordTextField("password", new PropertyModel(this, "password"));
        Form form = new LoginForm("loginForm");
        form.add(userIdField);
        form.add(passField);
        add(form);

        form.add(new AjaxSubmitLink("save") {
            @Override
            protected void onSubmit(AjaxRequestTarget target, Form form) {

            }
        });

        Link lostpwd = new AjaxFallbackLink("lostPwd") {
            @Override
            public void onClick(AjaxRequestTarget target) {
            setResponsePage(LostPassword.class);

            }
        };
        form.add(lostpwd);

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

            SignInSession session = getMySession();

            if (session.signIn(getUserId(), getPassword().toString())) {
                continueToOriginalDestination();
                setResponsePage(WelcomePage.class);
                getSession().setAttribute("username", getUserId());


            } else {
                info("unable to sign in");
            }


              }

        public String getUserId()
        {
            return email;
        }

        public String getPassword() {

            return password;
        }

        private SignInSession getMySession() {
            return (SignInSession) getSession();
        }

    }


}



