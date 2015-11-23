package se.su.dsv.bivsim.pages.CommonAllCases.LostPassword;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxSubmitLink;
import org.apache.wicket.markup.html.form.Form;
import se.su.dsv.childcasesim.pages.CommonAllCases.LostPassword.BaseClasses.BasePasswordPage;
import se.su.dsv.childcasesim.pages.CommonAllCases.SignIn;

public class PasswordchangeMessage extends BasePasswordPage {

    public PasswordchangeMessage() {


        Form form = new Form("loginForm");

        add(form);


        form.add(new AjaxSubmitLink("login") {
            @Override
            protected void onSubmit(AjaxRequestTarget target, Form form) {

                setResponsePage(SignIn.class);
            }
        });












    }




}



