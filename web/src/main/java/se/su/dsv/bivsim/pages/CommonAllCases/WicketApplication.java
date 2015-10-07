package se.su.dsv.bivsim.pages.CommonAllCases;

import org.apache.wicket.Component;
import org.apache.wicket.RestartResponseAtInterceptPageException;
import org.apache.wicket.Session;
import org.apache.wicket.authorization.Action;
import org.apache.wicket.authorization.IAuthorizationStrategy;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Response;
import org.apache.wicket.request.component.IRequestableComponent;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;

public class WicketApplication extends WebApplication {

    public WicketApplication() {
    }

    protected SpringComponentInjector getSpringInjector() {
        return new SpringComponentInjector(this);
    }


    @Override
    public Session newSession(Request request, Response response) {
        return new SignInSession(request);
    }


    @Override
    protected void init() {
        super.init();

        getComponentInstantiationListeners().add(getSpringInjector());

        getSecuritySettings().setAuthorizationStrategy(new IAuthorizationStrategy() {
            public boolean isActionAuthorized(Component component, Action action) {
                // authorize everything
                return true;
            }

            public <T extends IRequestableComponent> boolean isInstantiationAuthorized(
                    Class<T> componentClass) {
                // Check if the new Page requires authentication (implements the marker interface)
                if (AuthenticatedWebPage.class.isAssignableFrom(componentClass)) {
                    // Is user signed in?
                    if (((SignInSession) Session.get()).isSignedIn()) {
                        // okay to proceed
                        return true;
                    }

                    // Intercept the request, but remember the target for later.
                    // Invoke Component.continueToOriginalDestination() after successful logon to
                    // continue with the target remembered.

                    throw new RestartResponseAtInterceptPageException(SignIn.class);
                }

                // okay to proceed
                return true;
            }
        });
    }


    public Class<? extends WebPage> getHomePage() {
        return SignIn.class;
    }

}
