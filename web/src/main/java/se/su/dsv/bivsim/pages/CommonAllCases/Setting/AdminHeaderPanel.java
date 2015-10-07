package se.su.dsv.bivsim.pages.CommonAllCases.Setting;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;
import se.su.dsv.bivsim.pages.CommonAllCases.Edit.BaseClasses.CommonEditingPage;
import se.su.dsv.bivsim.pages.CommonAllCases.SignOut;

public class AdminHeaderPanel extends Panel{

    public AdminHeaderPanel(String id) {
        super(id);


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

        Link downloadheader = new AjaxFallbackLink("downloadheader") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                setResponsePage(DownLoadPage.class);

            }

        };
        add(downloadheader);

    }

}