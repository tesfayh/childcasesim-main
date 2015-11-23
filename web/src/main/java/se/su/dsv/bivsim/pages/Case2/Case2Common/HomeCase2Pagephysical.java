package se.su.dsv.bivsim.pages.Case2.Case2Common;

import org.apache.wicket.markup.html.WebMarkupContainer;
import se.su.dsv.childcasesim.pages.Case2.Case2Common.BaseClasses.BaseCase2Pagephysical;

public class HomeCase2Pagephysical extends BaseCase2Pagephysical {
    WebMarkupContainer contentWmc;

    public WebMarkupContainer getContentWmc() {

        return contentWmc;
    }

    public HomeCase2Pagephysical() {
        contentWmc = new WebMarkupContainer("contentWmc");
        contentWmc.setOutputMarkupId(true);
        contentWmc.add(new PaticnetPictuerPanel2("content"));
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