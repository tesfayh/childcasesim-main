package se.su.dsv.bivsim.pages.CommonAllCases.feedbacksection;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import se.su.dsv.childcasesim.data.Case.dao.interfaces.ExpertAssessmentEntityDao;


/**
 * Created by kib on 3/9/15.
 */
public class PreliminärBedömning extends Panel {
    @SpringBean
    ExpertAssessmentEntityDao expertAssessmentEntityDao;

    public PreliminärBedömning( String id, Integer groupId) {
        super(id);



        add(new Label("urFysBED", getSession().getAttribute("urFysBED")));
        add(new Label("urFysATG", getSession().getAttribute("urFysATG")));
        add(new Label("exFysBED", expertAssessmentEntityDao.findObject(groupId).getPysBedo()));
        add(new Label("exFysATG", expertAssessmentEntityDao.findObject(groupId).getPysAtg()));


        add(new Label("urFsyBED", getSession().getAttribute("urFsyBED")));
        add(new Label("urFsyATG", getSession().getAttribute("urFsyATG")));
        add(new Label("exFsyBED", expertAssessmentEntityDao.findObject(groupId).getPsyBedo()));
        add(new Label("exFsyATG", expertAssessmentEntityDao.findObject(groupId).getPsyAtg()));

        add(new Label("urSocialBED", getSession().getAttribute("urSocialBED")));
        add(new Label("urSocialATG", getSession().getAttribute("urSocialATG")));
        add(new Label("exSocialBED", expertAssessmentEntityDao.findObject(groupId).getSocialBedo()));
        add(new Label("exSocialATG", expertAssessmentEntityDao.findObject(groupId).getSocialAtg()));


      /*  L*//*ink nextfeedbak = new AjaxFallbackLink("back") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                setResponsePage(CategoryFeedBackPage.class);

            }
        };
        this.add(nextfeedbak);*/


    }
}