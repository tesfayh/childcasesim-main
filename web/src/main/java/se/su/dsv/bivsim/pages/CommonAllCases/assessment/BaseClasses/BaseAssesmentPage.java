package se.su.dsv.bivsim.pages.CommonAllCases.assessment.BaseClasses;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import se.su.dsv.childcasesim.pages.CommonAllCases.HeaderPanel.Case1HeaderPanel;
import se.su.dsv.childcasesim.pages.CommonAllCases.HeaderPanel.Case2HeaderPanel;
import se.su.dsv.childcasesim.pages.CommonAllCases.HeaderPanel.Case3HeaderPanel;
import se.su.dsv.childcasesim.pages.CommonAllCases.General.SignOut;

/**
 * Created by kib on 2/15/15.
 */
public class BaseAssesmentPage extends WebPage {
    public BaseAssesmentPage() {


        Link signOut = new AjaxFallbackLink("signOut") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                setResponsePage(SignOut.class);

            }


        };
        add(signOut);
        add(new Label("username", "Inloggad:" + getSession().getAttribute("username").toString()));

        if((Integer)getSession().getAttribute("case")==1){
            add(new Case1HeaderPanel("caseHeader"));
        }


        else if((Integer)getSession().getAttribute("case")==2){
            add(new Case2HeaderPanel("caseHeader"));

        }


        else if((Integer)getSession().getAttribute("case")==3){
            add(new Case3HeaderPanel("caseHeader"));

        }





    }
}
