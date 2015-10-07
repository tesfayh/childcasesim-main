package se.su.dsv.bivsim.pages.Case3.Case3Common;

import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import se.su.dsv.bivsim.pages.Case3.Case3Common.BaseClasses.BaseCase3Pagephysical;

public class HomeCase3Pagephysical extends BaseCase3Pagephysical {
    WebMarkupContainer contentWmc;

    public WebMarkupContainer getContentWmc() {

        return contentWmc;
    }

    public HomeCase3Pagephysical() {
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
/* contentWmc.add(new Label("content", "\n" +
                "REFERRAL NOTE:\n" +
                "\n" +
                "Mrs. K. is a 40 year old widowed woman living in Lynn, a suburb of Boston. She was born in Bosnia Herzegovina. Mrs. K. is a short, slightly obese, middle-aged woman who looks much older than her stated age. Although she is very alert she is restless and does not immediately respond to instruction. She appears to be easily distracted by her thoughts. She is wearing old clothing but her hair is neat and her clothes are immaculate. She talks freely but appears to be frightened. \n" +
                "\n" +
                "Referral: Referred from the refugee case workers. \n" +
                " "));

        add(contentWmc) */