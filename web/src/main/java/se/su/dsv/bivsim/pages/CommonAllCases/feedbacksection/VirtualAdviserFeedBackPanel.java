package se.su.dsv.bivsim.pages.CommonAllCases.feedbacksection;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import se.su.dsv.childcasesim.data.Case.dao.interfaces.VirtualAdviserEntityDao;
import se.su.dsv.childcasesim.data.Case.dataobjects.VirtualAdviserEntity;

import java.util.List;

public class VirtualAdviserFeedBackPanel extends Panel {
    @SpringBean
    VirtualAdviserEntityDao virtualAdviserEntityDao;
    String[] adviser_feedback_selected = new String[40];
    String show_feedback;
    int[] feedback_value = new int[23];
    int i = 0;
    int j = 0;
    int k = 0;
    private int totalTrustValue = 0;

    public VirtualAdviserFeedBackPanel( String id, Integer groupId) {
        super(id);

        List<VirtualAdviserEntity> adviser_list = virtualAdviserEntityDao.findAllByGroupId(groupId);

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
                        (Integer) getSession().getAttribute("exLab");



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


        String Fysiskundersökning = "";
        if ((Integer) getSession().getAttribute("exPhysical") != null) {

            if ((Integer) getSession().getAttribute("exPhysical") >= 2)
                Fysiskundersökning = Fysiskundersökning + adviser_feedback_selected[8] + " ";
            if ((Integer) getSession().getAttribute("exPhysical") < 1)
                Fysiskundersökning = Fysiskundersökning + adviser_feedback_selected[19] + " ";
        }

        add(new Label("Fysiskundersökning", Fysiskundersökning));

        String Lab = "";
        if ((Integer) getSession().getAttribute("exLab") != null) {
            if ((Integer) getSession().getAttribute("exLab") < 1)
                Lab = Lab + adviser_feedback_selected[9] + " ";
            if ((Integer) getSession().getAttribute("exLab") >= 1)
                Lab = Lab + adviser_feedback_selected[20] + " ";
        }
        add(new Label("Lab", Lab));

        System.out.println(Lab);


        String Instrument = "";
        if ((Integer) getSession().getAttribute("POSInstrument") != null) {
            if ((Integer) getSession().getAttribute("POSInstrument") >= 0)
                Instrument = Instrument + adviser_feedback_selected[10] + " ";
            if ((Integer) getSession().getAttribute("POSInstrument") < 0)
                Instrument = Instrument + adviser_feedback_selected[21] + " ";
        }
        add(new Label("Instrument", Instrument));


        String Funktion = "";
        if ((Integer) getSession().getAttribute("exFunktionsnivå") != null) {

            if ((Integer) getSession().getAttribute("exFunktionsnivå") >= 2)
                Funktion = Funktion + adviser_feedback_selected[4] + " ";
            if ((Integer) getSession().getAttribute("exFunktionsnivå") < 1)
                Funktion = Funktion + adviser_feedback_selected[15] + " ";
        }

        if ((Integer) getSession().getAttribute("exBarn") != null) {
            if ((Integer) getSession().getAttribute("exBarn") >= 5)
                Funktion = Funktion + adviser_feedback_selected[5] + " ";
            if ((Integer) getSession().getAttribute("exBarn") < 3)
                Funktion = Funktion + adviser_feedback_selected[16] + " ";
        }
        add(new Label("Funktion", Funktion));

        String Motivation = "";
        if ((Integer) getSession().getAttribute("exMotivation") != null) {

            if ((Integer) getSession().getAttribute("exMotivation") >= 0)
                Motivation = Motivation + adviser_feedback_selected[6] + " ";
            if ((Integer) getSession().getAttribute("exMotivation") < 0)
                Motivation = Motivation + adviser_feedback_selected[17] + " ";
        }
        add(new Label("Motivation", Motivation));


        String Antalfrågor = "";
        if ((Integer) getSession().getAttribute("Antalfrågor") != null) {

            if ((Integer) getSession().getAttribute("Antalfrågor") < 45)
                Antalfrågor = Antalfrågor + adviser_feedback_selected[7] + " ";
            if ((Integer) getSession().getAttribute("Antalfrågor") > 45)
                Antalfrågor = Antalfrågor + adviser_feedback_selected[18] + " ";
        }
        add(new Label("Antalfrågor", Antalfrågor));

    }
}