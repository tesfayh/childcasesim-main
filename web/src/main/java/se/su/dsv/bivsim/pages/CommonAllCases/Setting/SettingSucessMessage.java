package se.su.dsv.bivsim.pages.CommonAllCases.Setting;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxSubmitLink;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.spring.injection.annot.SpringBean;
import se.su.dsv.childcasesim.data.Case.dao.interfaces.AdminsEntityDao;
import se.su.dsv.childcasesim.pages.CommonAllCases.General.ChooseCase;

/**
 * Created by kib on 7/9/15.
 */
public class SettingSucessMessage extends WebPage {
    @SpringBean
    AdminsEntityDao adminsEntityDoa;
    private String userId;
    private String password;
    private String confirmPassword;
    private static int exist;

    public SettingSucessMessage(){


        Form form = new Form("loginForm");
        add(form);


        form.add(new AjaxSubmitLink("tillbaka") {
            @Override
            protected void onSubmit(AjaxRequestTarget target, Form form) {
                setResponsePage(ChooseCase.class);

            }
        });


    }



}
