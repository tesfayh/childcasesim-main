package se.su.dsv.bivsim.pages.CommonAllCases;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.mapper.parameter.PageParameters;

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
        setResponsePage(SignIn.class);
    }
}
