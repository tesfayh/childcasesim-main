package se.su.dsv.bivsim.pages.CommonAllCases.General;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.Model;
import se.su.dsv.childcasesim.pages.CommonAllCases.SignIn;

public class CreditPage extends WebPage {
    public CreditPage(){

        Link loginAgain = new AjaxFallbackLink("loginAgain") {
            @Override
            public void onClick(AjaxRequestTarget target) {
                setResponsePage(SignIn.class);
            }
        };
        add(loginAgain);
        final TextArea<String> body = new TextArea<String>("body", Model.of(""));
        body.setRequired(true);
       /* Form<?> form = new Form<Void>("submitForm") {
            @Override
            protected void onSubmit() {

                PageParameters pageParameters = new PageParameters();
                pageParameters.add("body", body.getModelObject());
*//*
                setResponsePage(SuccessPage.class, pageParameters);
*//*
*//*
                if (body.getModelObject()!=null) {
                    // just display first message for now
                    markupLabel[0] =  new Label("success-messages",body.getModelObject().toString());
                } else {
                    markupLabel[0] =  new Label("success-messages","");
                }*//*
            }
        };

        add(form);
        form.add(body);*/
    }
}
