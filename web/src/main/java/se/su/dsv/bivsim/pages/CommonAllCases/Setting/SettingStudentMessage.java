package se.su.dsv.bivsim.pages.CommonAllCases.Setting;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import se.su.dsv.bivsim.pages.CommonAllCases.ChooseCase;
import se.su.dsv.bivsim.pages.CommonAllCases.SignOut;


public class SettingStudentMessage extends WebPage {


    public SettingStudentMessage(){

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


                setResponsePage(SettingPageStudent.class);


            }


        };
        add(setting);



    }





}
