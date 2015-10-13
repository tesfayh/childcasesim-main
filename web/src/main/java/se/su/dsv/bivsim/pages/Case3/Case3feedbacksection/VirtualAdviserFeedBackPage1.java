package se.su.dsv.bivsim.pages.Case3.Case3feedbacksection;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.spring.injection.annot.SpringBean;
import se.su.dsv.bivsim.data.Case.dao.interfaces.VirtualAdviserEntityDao;
import se.su.dsv.bivsim.data.Case.dataobjects.VirtualAdviserEntity;
import se.su.dsv.bivsim.pages.Case3.Case3feedbacksection.BaseClasses.BaseFeedbackPageCase3;

import java.util.List;

public class VirtualAdviserFeedBackPage1 extends BaseFeedbackPageCase3 {
    @SpringBean
    VirtualAdviserEntityDao virtualAdviserEntityDao;
    String[] adviser_feedback_selected = new String[40];
    String show_feedback;
    int[] feedback_value = new int[23];
    int i = 0;
    int j = 0;
    int k = 0;
    private int totalTrustValue = 0;

    public VirtualAdviserFeedBackPage1() {


        List<VirtualAdviserEntity> adviser_list = virtualAdviserEntityDao.findAllByGroupId(3);

        for (VirtualAdviserEntity adviser : adviser_list) {
            adviser_feedback_selected[i++] = adviser.getFeedbackDetail();
            feedback_value[k++] = adviser.getFeedbackValue();
            // System.out.println(adviser.getFeedbackDetail());
        }

        totalTrustValue =
                (Integer) getSession().getAttribute("exSpegling") +
                        (Integer) getSession().getAttribute("exÖppnafrågor") +
                        (Integer) getSession().getAttribute("exEgenbedömning") +
                        (Integer) getSession().getAttribute("exSocialt") +
                        (Integer) getSession().getAttribute("exFunktionsnivå") +
                        (Integer) getSession().getAttribute("exBarn") +
                        (Integer) getSession().getAttribute("exMotivation") +
                        (Integer) getSession().getAttribute("exPhysical") +
                        (Integer) getSession().getAttribute("exLab") +
                        (Integer) getSession().getAttribute("exInstrument") +
                        (Integer) getSession().getAttribute("exTillit") +
                        (Integer) getSession().getAttribute("exRelevans") +
                        (Integer) getSession().getAttribute("exEmpati") +
                        (Integer) getSession().getAttribute("ex3F") +
                        (Integer) getSession().getAttribute("exRespekt");


        if ((Integer) getSession().getAttribute("positiveTrustValue") != null || (Integer) getSession().getAttribute("negativeTrustValue") != null) {

            if (totalTrustValue > 0) {
                show_feedback = "Du verkar ha en god kompetens i att hantera denna typ av fall. Generellt sett gjorde du ett bra arbete. Det sätt som du genomförde samtalet med patienten var bra och effektivt. ";
                add(new Label("adviser", show_feedback));
            } else if (totalTrustValue == 0) {
                show_feedback = "Du verkar ha en relativt bra förståelse för denna typ av fall. Generellt sett gjorde du ett någorlunda bra arbete, men vissa saker behöver förbättras. \n\n";
                add(new Label("adviser", show_feedback));
            } else {
                show_feedback = "Mötet med dig kändes inte alls bra";
                add(new Label("adviser", show_feedback));
            }
        } else {
            show_feedback = "Du verkar tyvärr ha en relativt dålig kompetens i att hantera denna typ av fall. Generellt sett gjorde du inte så bra arbete. Det sätt som du genomförde samtalet med patienten var inte heller så bra. ";
            add(new Label("adviser", show_feedback));

        }


        String Anamnesen = "";
        if ((Integer) getSession().getAttribute("exSpegling") != null) {

            if ((Integer) getSession().getAttribute("exSpegling") >= -2)
                Anamnesen = Anamnesen + adviser_feedback_selected[0] + " ";
            if ((Integer) getSession().getAttribute("exSpegling") < -2)
                Anamnesen = Anamnesen + adviser_feedback_selected[11] + " ";
        }

        if ((Integer) getSession().getAttribute("exÖppnafrågor") != null) {
            if ((Integer) getSession().getAttribute("exÖppnafrågor") >= 2)
                Anamnesen = Anamnesen + adviser_feedback_selected[1] + " ";
            if ((Integer) getSession().getAttribute("exÖppnafrågor") < 2)
                Anamnesen = Anamnesen + adviser_feedback_selected[12] + " ";
        }
        if ((Integer) getSession().getAttribute("exEgenbedömning") != null) {
            if ((Integer) getSession().getAttribute("exEgenbedömning") >= 0)
                Anamnesen = Anamnesen + adviser_feedback_selected[2] + " ";
            if ((Integer) getSession().getAttribute("exEgenbedömning") < -3)
                Anamnesen = Anamnesen + adviser_feedback_selected[13] + " ";
        }
        add(new Label("Anamnesen", Anamnesen));

        String Socialt = "";

        if ((Integer) getSession().getAttribute("exSocialt") != null) {

            if ((Integer) getSession().getAttribute("exSocialt") >= 5)
                Socialt = Socialt + adviser_feedback_selected[3] + " ";
            if ((Integer) getSession().getAttribute("exSocialt") < 5)
                Socialt = Socialt + adviser_feedback_selected[14] + " ";
        }
        add(new Label("Socialt", Socialt));










        Link next = new AjaxFallbackLink("next") {
            @Override
            public void onClick(AjaxRequestTarget target) {

                setResponsePage(VirtualAdviserFeedBackPage2.class);
            }
        };
        this.add(next);


        Link tillbaka = new AjaxFallbackLink("tillbaka") {
            @Override
            public void onClick(AjaxRequestTarget target) {

                ;
                setResponsePage(CategoryInterviewFeedbakPage.class);
            }
        };
        this.add(tillbaka);


    }
}