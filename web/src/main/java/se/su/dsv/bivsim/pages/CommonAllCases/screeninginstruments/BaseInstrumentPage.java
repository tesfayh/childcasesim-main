package se.su.dsv.bivsim.pages.CommonAllCases.screeninginstruments;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import se.su.dsv.childcasesim.pages.CommonAllCases.General.SignOut;
import se.su.dsv.childcasesim.pages.CommonAllCases.HeaderPanel.Case1HeaderPanel;
import se.su.dsv.childcasesim.pages.CommonAllCases.HeaderPanel.Case2HeaderPanel;
import se.su.dsv.childcasesim.pages.CommonAllCases.HeaderPanel.Case3HeaderPanel;

/**
 * Created by kib on 12/1/14.
 */
public class BaseInstrumentPage extends WebPage {
    WebMarkupContainer instrument;

    public WebMarkupContainer getContentW() {

        return instrument;
    }

    int panelindex = 0;

    public BaseInstrumentPage(final PageParameters parameters) {


        Link signOut = new AjaxFallbackLink("signOut") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                setResponsePage(SignOut.class);

            }


        };
        add(signOut);
        add(new Label("username", "Inloggad:" + getSession().getAttribute("username").toString()));


        instrument = new WebMarkupContainer("instrumentmarkup");
        instrument.setOutputMarkupId(true);
        add(instrument);

        panelindex = parameters.get("A").toInt();


        if (panelindex == 2){
            instrument.add(new PHQ9Panel("instrument"));
            getSession().setAttribute("instrumentValue", getSession().getAttribute("instrumentValue") +  "PHQ9,  " );

        }
        else if (panelindex == 3){
            instrument.add(new IESRPanel("instrument"));
            getSession().setAttribute("instrumentValue", getSession().getAttribute("instrumentValue") + "IESR,  " );

        }
        else if (panelindex == 4){
            instrument.add(new AUDITPanel("instrument"));
            getSession().setAttribute("instrumentValue", getSession().getAttribute("instrumentValue") + "AUDIT,  " );

        }
        else if (panelindex == 5){
            instrument.add(new PTSDPanel("instrument"));
            getSession().setAttribute("instrumentValue", getSession().getAttribute("instrumentValue") + "PTSD,  " );


        }
        else if (panelindex == 6){
            instrument.add(new DUDITPanel("instrument"));
            getSession().setAttribute("instrumentValue", getSession().getAttribute("instrumentValue") + "DUDIT,  " );

        }
        else if (panelindex == 7){
            instrument.add(new MADRSPanel("instrument"));
            getSession().setAttribute("instrumentValue", getSession().getAttribute("instrumentValue") + "MADRS,  " );

        }
        else if (panelindex == 8){
            instrument.add(new ASRSPanel("instrument"));
            getSession().setAttribute("instrumentValue", getSession().getAttribute("instrumentValue") + "ASRS,  " );

        }
        else if(panelindex==9){
            instrument.add(new PTSDPanel("instrument"));
            getSession().setAttribute("instrumentValue", getSession().getAttribute("instrumentValue") + "PTSD,  " );

        }

        else if(panelindex==10){
            instrument.add(new SocialPanel("instrument"));
            getSession().setAttribute("instrumentValue", getSession().getAttribute("instrumentValue") + "Social,  " );

        }



       // Header files;

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
