package se.su.dsv.bivsim.pages.CommonAllCases.Setting;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;
import se.su.dsv.childcasesim.pages.CommonAllCases.General.SignOut;

/**
 * Created by kib on 7/18/15.
 */
public class StudentHeaderPanel extends Panel{

    public StudentHeaderPanel(String id) {
        super(id);


        Link signOut = new AjaxFallbackLink("signOut") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                setResponsePage(SignOut.class);

            }


        };
        add(signOut);

        Link setting = new AjaxFallbackLink("setting") {

            @Override
            public void onClick(AjaxRequestTarget target) {




                setResponsePage(SettingStudent.class);




            }


        };
        add(setting);


          }

}