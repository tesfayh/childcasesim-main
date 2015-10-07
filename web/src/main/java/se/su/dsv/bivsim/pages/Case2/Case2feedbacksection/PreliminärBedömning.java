package se.su.dsv.bivsim.pages.Case2.Case2feedbacksection;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.spring.injection.annot.SpringBean;
import se.su.dsv.bivsim.data.Case.dao.interfaces.ExpertAssessmentEntityDao;
import se.su.dsv.bivsim.pages.Case2.Case2feedbacksection.BaseClasses.BaseFeedbackPageCase2;

/**
 * Created by kib on 3/9/15.
 */
public class PreliminärBedömning extends BaseFeedbackPageCase2 {
    @SpringBean
    ExpertAssessmentEntityDao expertAssessmentEntityDao;

    public PreliminärBedömning() {



        add(new Label("urFysBED", getSession().getAttribute("urFysBED")));
        add(new Label("urFysATG", getSession().getAttribute("urFysATG")));
        add(new Label("exFysBED", expertAssessmentEntityDao.findObject(1).getPysBedo()));
        add(new Label("exFysATG", expertAssessmentEntityDao.findObject(1).getPysAtg()));


        add(new Label("urFsyBED", getSession().getAttribute("urFsyBED")));
        add(new Label("urFsyATG", getSession().getAttribute("urFsyATG")));
        add(new Label("exFsyBED", expertAssessmentEntityDao.findObject(1).getPsyBedo()));
        add(new Label("exFsyATG", expertAssessmentEntityDao.findObject(1).getPsyAtg()));

        add(new Label("urSocialBED", getSession().getAttribute("urSocialBED")));
        add(new Label("urSocialATG", getSession().getAttribute("urSocialATG")));
        add(new Label("exSocialBED", expertAssessmentEntityDao.findObject(1).getSocialBedo()));
        add(new Label("exSocialATG", expertAssessmentEntityDao.findObject(1).getSocialAtg()));


        Link nextfeedbak = new AjaxFallbackLink("back") {

            @Override
            public void onClick(AjaxRequestTarget target) {

                setResponsePage(CategoryFeedBackPage.class);

            }
        };
        this.add(nextfeedbak);


    }
}