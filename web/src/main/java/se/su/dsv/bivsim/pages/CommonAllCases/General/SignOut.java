package se.su.dsv.bivsim.pages.CommonAllCases.General;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import se.su.dsv.childcasesim.pages.CommonAllCases.General.CreditPage;

/**
 * Created with IntelliJ IDEA.
 * User: kebede
 * Date: 24/10/13
 * Time: 10:42
 * To change this template use File | Settings | File Templates.
 */
public class SignOut extends WebPage {

    public SignOut(final PageParameters parameters) {
        getSession().invalidate();
        setResponsePage(CreditPage.class);
    }
}
