package se.su.dsv.bivsim.pages.CommonAllCases.Setting;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.spring.injection.annot.SpringBean;
import se.su.dsv.bivsim.data.Case.dao.interfaces.AdminsEntityDao;
import se.su.dsv.bivsim.pages.CommonAllCases.ChooseCase;
import se.su.dsv.bivsim.pages.CommonAllCases.Edit.BaseClasses.CommonEditingPage;
import se.su.dsv.bivsim.pages.CommonAllCases.SignOut;

/**
 * Created by kib on 7/9/15.
 */
public class SettingAdminMessage extends WebPage {
    @SpringBean
    AdminsEntityDao adminsEntityDoa;
    private String userId;
    private String password;
    private String confirmPassword;
    private static int exist;

    public SettingAdminMessage(){

        Link tillbaka = new AjaxFallbackLink("tillbaka") {

            @Override
            public void onClick(AjaxRequestTarget target) {


                setResponsePage(ChooseCase.class);


            }


        };
        add(tillbaka);


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






}
