package se.su.dsv.bivsim.pages.Case1.CommonCase1;

import org.apache.wicket.markup.html.WebMarkupContainer;
import se.su.dsv.childcasesim.pages.Case1.CommonCase1.BaseClasses.BasePage;

/**
 * Created by kib on 12/31/14.
 */
public class HomePage extends BasePage {
    WebMarkupContainer contentWmc;

    public WebMarkupContainer getContentWmc() {

        return contentWmc;
    }

    public HomePage() {
        contentWmc = new WebMarkupContainer("contentWmc");
        contentWmc.setOutputMarkupId(true);
        contentWmc.add(new PaticnetPictuerPanel("content"));
        add(contentWmc);


    }
}
