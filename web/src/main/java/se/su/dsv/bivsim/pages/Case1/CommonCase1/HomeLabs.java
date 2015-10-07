package se.su.dsv.bivsim.pages.Case1.CommonCase1;

import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import se.su.dsv.bivsim.pages.Case1.CommonCase1.BaseClasses.BaseLabsPage;

/**
 * Created by kib on 12/31/14.
 */
public class HomeLabs extends BaseLabsPage {
    WebMarkupContainer contentWmc;

    public WebMarkupContainer getContentWmc() {

        return contentWmc;
    }

    public HomeLabs() {
        contentWmc = new WebMarkupContainer("contentWmc");
        contentWmc.setOutputMarkupId(true);

        contentWmc.add(new Label("content", "<p style=\" padding: 0em 1em;\">\n" +
                "                      <img src=\"/img/KarinCase1.jpg\"  style=\" width: 320px; height: 240px; float:center; margin:0 5px 0 0;\" />\n" +
                "\n" +
                "                       .\n" +
                "                    </p>\n").setEscapeModelStrings(false));

        add(contentWmc);


    }
}
