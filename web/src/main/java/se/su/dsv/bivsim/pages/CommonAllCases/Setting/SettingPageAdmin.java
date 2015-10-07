package se.su.dsv.bivsim.pages.CommonAllCases.Setting;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.validation.EqualPasswordInputValidator;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import se.su.dsv.bivsim.data.Case.dao.interfaces.AdminsEntityDao;
import se.su.dsv.bivsim.data.Case.dataobjects.AdminsEntity;
import se.su.dsv.bivsim.pages.CommonAllCases.ChooseCase;
import se.su.dsv.bivsim.pages.CommonAllCases.Edit.BaseClasses.CommonEditingPage;
import se.su.dsv.bivsim.pages.CommonAllCases.SignOut;

import java.util.List;

/**
 * Created by kib on 7/9/15.
 */
public class SettingPageAdmin extends WebPage {
    @SpringBean
    AdminsEntityDao adminsEntityDoa;
    private String userId;
    private String password;
    private String confirmPassword;
    private static int exist;

    public SettingPageAdmin(){
        FeedbackPanel feedback = new FeedbackPanel("feedback");
        Form form = new CreateAccountForm("createAccountForm");
        PasswordTextField password = (PasswordTextField) new PasswordTextField("password", new PropertyModel<String>(this, "password"));
        password.setResetPassword(false);
        form.add(password);
        PasswordTextField confirmPassword = (PasswordTextField) new PasswordTextField("confirmPassword", new PropertyModel(this, "confirmPassword")).setRequired(true);
        confirmPassword.setResetPassword(false);
        form.add(confirmPassword);
        form.add(new EqualPasswordInputValidator(password, confirmPassword));
        add(form);
        add(feedback);
        Link tillbaka = new AjaxFallbackLink("tillbaka") {

            @Override
            public void onClick(AjaxRequestTarget target) {


                setResponsePage(ChooseCase.class);


            }


        };
        form.add(tillbaka);


        Link signOut = new AjaxFallbackLink("signOut") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                setResponsePage(SignOut.class);

            }


        };
        add(signOut);
        signOut.add(new Label("username", getSession().getAttribute("username").toString()));


        Link setting = new AjaxFallbackLink("setting") {

            @Override
            public void onClick(AjaxRequestTarget target) {


                setResponsePage(SettingPageAdmin.class);


            }


        };
        add(setting);


        Link admin = new AjaxFallbackLink("admin") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                setResponsePage(CommonEditingPage.class);


            }


        };
        add(admin);
    }

    class CreateAccountForm extends Form {
        public CreateAccountForm(String id) {
            super(id);

        }

        @Override
        public void onSubmit() {

            List<AdminsEntity> checks = adminsEntityDoa.findAll();
            for (AdminsEntity check : checks) {
                if (check.getemail().equals(getSession().getAttribute("username").toString())) {
                    AdminsEntity entity = adminsEntityDoa.load(check.getAminId());
                    entity.setPassword(password);
                    adminsEntityDoa.save(entity);
                    setResponsePage(SettingAdminMessage.class);
                }

            }


        }
    }




    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

       public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
