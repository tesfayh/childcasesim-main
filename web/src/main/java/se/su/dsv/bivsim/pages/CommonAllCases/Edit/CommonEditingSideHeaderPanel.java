package se.su.dsv.bivsim.pages.CommonAllCases.Edit;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;

public class CommonEditingSideHeaderPanel extends Panel {
    public CommonEditingSideHeaderPanel(String id) {
        super(id);

        Link Admisnistrator = new AjaxFallbackLink("Admisnistrator") {
            @Override
            public void onClick(AjaxRequestTarget target) {

                this.setResponsePage(CreateUser.class);
            }
        };
        this.add(Admisnistrator);

        Link editAdmisnistrator = new AjaxFallbackLink("editAdmisnistrator") {
            @Override
            public void onClick(AjaxRequestTarget target) {

                this.setResponsePage(EditAdministrator.class);
            }
        };
        this.add(editAdmisnistrator);

        Link Editexistingcases = new AjaxFallbackLink("editExistingCases") {
            @Override
            public void onClick(AjaxRequestTarget target) {


                this.setResponsePage(EditExisitingCases.class);

            }
        };
        add(Editexistingcases);

      /*  Link CreatNewCases = new AjaxFallbackLink("creatnewcases") {
            @Override
            public void onClick(AjaxRequestTarget target) {

                this.setResponsePage(CreateNewCase.class);
            }
        };
        add(CreatNewCases);*/

       /* Link welcomeupload = new Link("welcomeUpload") {
            @Override
            public void onClick() {

                this.setResponsePage(WelcomeAndHomeDropwn.class);
            }
        };
        this.add(welcomeupload);*/
    }
}
