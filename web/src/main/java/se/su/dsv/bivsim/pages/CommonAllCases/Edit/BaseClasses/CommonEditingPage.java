package se.su.dsv.bivsim.pages.CommonAllCases.Edit.BaseClasses;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.EmptyPanel;
import se.su.dsv.childcasesim.pages.CommonAllCases.General.ChooseCase;
import se.su.dsv.childcasesim.pages.CommonAllCases.Setting.AdminHeaderPanel;


public class CommonEditingPage extends WebPage {
    WebMarkupContainer MainContainer;
    public WebMarkupContainer getContentMainContainer() {

        return MainContainer;
    }

    WebMarkupContainer MainContainer2;
    public WebMarkupContainer getContentMainContainer2() {

        return MainContainer2;
    }

    public CommonEditingPage() {
       /* MainContainer = new WebMarkupContainer("Container1");
        MainContainer.setOutputMarkupId(true);
        add(MainContainer);
        MainContainer.add(new CommonEditingSideHeaderPanel("mainNavigation"));

*/
        MainContainer2 = new WebMarkupContainer("Container2");
        MainContainer2.setOutputMarkupId(true);
        MainContainer2.add(new EmptyPanel("mainNavigation2"));
        add(MainContainer2);




        add(new AdminHeaderPanel("Header"));


        add(new Label("username", "Inloggad:" + getSession().getAttribute("username").toString()));
        Link tillbaka = new AjaxFallbackLink("tillbaka") {
            @Override
            public void onClick(AjaxRequestTarget target) {

                setResponsePage(ChooseCase.class);





            }


        };
        add(tillbaka);

        Link Admisnistrator = new AjaxFallbackLink("Admisnistrator") {
            @Override
            public void onClick(AjaxRequestTarget target) {


                ((CommonEditingPage) getPage()).getContentMainContainer2().replace(new se.su.dsv.bivsim.pages.CommonAllCases.Edit.CreateUser("mainNavigation2"));
                target.add(((CommonEditingPage) getPage()).getContentMainContainer2());

            }
        };
        this.add(Admisnistrator);

        Link editAdmisnistrator = new AjaxFallbackLink("editAdmisnistrator") {
            @Override
            public void onClick(AjaxRequestTarget target) {

/*
                this.setResponsePage(EditAdministrator.class);
*/
            }
        };
        this.add(editAdmisnistrator);

        Link Editexistingcases = new AjaxFallbackLink("editExistingCases") {
            @Override
            public void onClick(AjaxRequestTarget target) {


/*
                this.setResponsePage(EditExisitingCases.class);
*/

            }
        };
        add(Editexistingcases);


    }


}
