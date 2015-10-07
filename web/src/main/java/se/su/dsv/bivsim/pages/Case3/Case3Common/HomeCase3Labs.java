package se.su.dsv.bivsim.pages.Case3.Case3Common;

import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import se.su.dsv.bivsim.pages.Case3.Case3Common.BaseClasses.BaseLabsCase3Page;

/**
 * Created by kib on 12/31/14.
 */
public class HomeCase3Labs extends BaseLabsCase3Page {
    WebMarkupContainer contentWmc;

    public WebMarkupContainer getContentWmc() {

        return contentWmc;
    }

    public HomeCase3Labs() {
        contentWmc = new WebMarkupContainer("contentWmc");
        contentWmc.setOutputMarkupId(true);

        contentWmc.add(new Label("content", "<p style=\" padding: 0em 1em;\">\n" +
                "                      <img src=\"/img/Ahmed.png\"  style=\" width: 320px; height: 220px; float:center; margin:0 5px 0 0;\" />\n" +
                "\n" +
                "                       .\n" +
                "                    </p>\n").setEscapeModelStrings(false));

        add(contentWmc);


    }
}
