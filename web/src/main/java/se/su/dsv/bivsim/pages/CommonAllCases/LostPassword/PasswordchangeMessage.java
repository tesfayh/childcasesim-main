package se.su.dsv.bivsim.pages.CommonAllCases.LostPassword;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.html.link.Link;
import se.su.dsv.bivsim.pages.CommonAllCases.LostPassword.BaseClasses.BasePasswordPage;
import se.su.dsv.bivsim.pages.CommonAllCases.SignIn;

public class PasswordchangeMessage extends BasePasswordPage {

    public PasswordchangeMessage() {

        Link login = new AjaxFallbackLink("login") {
            @Override
            public void onClick(AjaxRequestTarget target) {
                setResponsePage(SignIn.class);

            }
        };
        add(login);


    }




}



