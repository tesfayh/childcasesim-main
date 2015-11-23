package se.su.dsv.bivsim.pages.CommonAllCases.Edit.BaseClasses;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import se.su.dsv.childcasesim.pages.CommonAllCases.General.AuthenticatedWebPage;
import se.su.dsv.childcasesim.pages.CommonAllCases.General.ChooseCase;
import se.su.dsv.childcasesim.pages.CommonAllCases.Edit.CommonEditingSideHeaderPanel;
import se.su.dsv.childcasesim.pages.CommonAllCases.Setting.AdminHeaderPanel;


public class CommonEditingPage extends WebPage implements AuthenticatedWebPage {

    public CommonEditingPage() {
        add(new CommonEditingSideHeaderPanel("mainNavigation"));

        add(new AdminHeaderPanel("Header"));
        add(new Label("username", "Inloggad:" + getSession().getAttribute("username").toString()));



        Link tillbaka = new AjaxFallbackLink("tillbaka") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                setResponsePage(ChooseCase.class);

            }


        };
        add(tillbaka);


    }


}
