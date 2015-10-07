package se.su.dsv.bivsim.pages.Case1.EditingPages.Common.BaseClasses;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.IModel;
import se.su.dsv.bivsim.pages.Case1.EditingPages.Common.EditingSideHeaderPanel1;
import se.su.dsv.bivsim.pages.CommonAllCases.AuthenticatedWebPage;
import se.su.dsv.bivsim.pages.CommonAllCases.Edit.EditExisitingCases;
import se.su.dsv.bivsim.pages.CommonAllCases.SignOut;

public class EditingMainPage1 extends WebPage implements AuthenticatedWebPage {

    public EditingMainPage1() {
        this(null);
        this.add(new EditingSideHeaderPanel1("mainNavigation"));
        Link signOut = new AjaxFallbackLink("signOut") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                setResponsePage(SignOut.class);

            }


        };
        signOut.add(new Label("username", "kibrom"));
        add(signOut);

        Link tillbaka = new AjaxFallbackLink("tillbaka") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                setResponsePage(EditExisitingCases.class);

            }


        };
        add(tillbaka);


    }

    public EditingMainPage1(IModel model) {
        super(model);
    }
}
