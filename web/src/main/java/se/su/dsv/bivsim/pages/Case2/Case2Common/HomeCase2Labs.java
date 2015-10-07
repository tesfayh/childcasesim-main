package se.su.dsv.bivsim.pages.Case2.Case2Common;

import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import se.su.dsv.bivsim.pages.Case2.Case2Common.BaseClasses.BaseLabsCase2Page;

/**
 * Created by kib on 12/31/14.
 */
public class HomeCase2Labs extends BaseLabsCase2Page {
    WebMarkupContainer contentWmc;

    public WebMarkupContainer getContentWmc() {

        return contentWmc;
    }

    public HomeCase2Labs() {
        contentWmc = new WebMarkupContainer("contentWmc");
        contentWmc.setOutputMarkupId(true);

        contentWmc.add(new Label("content", "<p style=\" padding: 0em 1em;\">\n" +
                "                      <img src=\"/img/KarinCase2.jpg\"  style=\" width: 320px; height: 240px; float:center; margin:0 5px 0 0;\" />\n" +
                "\n" +
                "                       .\n" +
                "                    </p>\n").setEscapeModelStrings(false));

        add(contentWmc);


    }
}
