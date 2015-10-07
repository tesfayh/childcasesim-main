package se.su.dsv.bivsim.pages.CommonAllCases.Edit.BaseClasses;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.IModel;
import se.su.dsv.bivsim.pages.CommonAllCases.AuthenticatedWebPage;
import se.su.dsv.bivsim.pages.CommonAllCases.ChooseCase;
import se.su.dsv.bivsim.pages.CommonAllCases.Edit.CommonEditingSideHeaderPanel;
import se.su.dsv.bivsim.pages.CommonAllCases.SignOut;


public class CommonEditingPage extends WebPage implements AuthenticatedWebPage {

    public CommonEditingPage() {
        this(null);
        this.add(new CommonEditingSideHeaderPanel("mainNavigation"));

        Link signOut = new AjaxFallbackLink("signOut") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                setResponsePage(SignOut.class);

            }


        };
        signOut.add(new Label("username", getSession().getAttribute("username").toString()));
        add(signOut);


        Link tillbaka = new AjaxFallbackLink("tillbaka") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                setResponsePage(ChooseCase.class);

            }


        };
        add(tillbaka);


    }


    public CommonEditingPage(IModel model) {
        super(model);
    }
}
