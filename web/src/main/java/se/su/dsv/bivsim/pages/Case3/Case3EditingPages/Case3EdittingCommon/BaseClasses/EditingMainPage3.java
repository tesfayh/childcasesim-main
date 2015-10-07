package se.su.dsv.bivsim.pages.Case3.Case3EditingPages.Case3EdittingCommon.BaseClasses;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.IModel;
import se.su.dsv.bivsim.pages.Case3.Case3EditingPages.Case3EdittingCommon.EditingSideHeaderPanel3;
import se.su.dsv.bivsim.pages.CommonAllCases.AuthenticatedWebPage;
import se.su.dsv.bivsim.pages.CommonAllCases.Edit.EditExisitingCases;
import se.su.dsv.bivsim.pages.CommonAllCases.SignOut;

public class EditingMainPage3 extends WebPage implements AuthenticatedWebPage {

    public EditingMainPage3() {
        this(null);
        this.add(new EditingSideHeaderPanel3("mainNavigation"));
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

    public EditingMainPage3(IModel model) {
        super(model);
    }
}
