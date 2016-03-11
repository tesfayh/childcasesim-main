package se.su.dsv.bivsim.pages.CommonAllCases.Edit;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.html.link.Link;
import se.su.dsv.bivsim.pages.CommonAllCases.Edit.BaseClasses.CommonEditingPage;

public class AndraAddPage extends CommonEditingPage {



    public AndraAddPage() {



        Link add = new AjaxFallbackLink("AndraAdd") {

            @Override
            public void onClick(AjaxRequestTarget target) {


                setResponsePage(CommonEditingPage.class);


            }


        };
        add(add);




    }




}