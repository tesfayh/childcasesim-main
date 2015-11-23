package se.su.dsv.bivsim.pages.CommonAllCases;

import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.injection.Injector;
import org.apache.wicket.request.Request;
import org.apache.wicket.spring.injection.annot.SpringBean;
import se.su.dsv.childcasesim.data.Case.dao.interfaces.AdminsEntityDao;
import se.su.dsv.childcasesim.data.Case.dataobjects.AdminsEntity;

import java.util.List;

public final class SignInSession extends AuthenticatedWebSession {
    @SpringBean
    AdminsEntityDao adminsEntityDao;

    private Boolean authenticated = false;

    protected SignInSession(Request request) {
        super(request);
        Injector.get().inject(this);
    }

    @Override
    public final boolean authenticate(final String email, final String pass) {

        List<AdminsEntity> logins = adminsEntityDao.findAll();
        for (AdminsEntity login : logins) {
            if (login.getemail().equals(email) && login.getPassword().equals(pass)){
                authenticated = true;
            }


        }
        return authenticated;
    }


    @Override
    public Roles getRoles() {
        return null;
    }
}