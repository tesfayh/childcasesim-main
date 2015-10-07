package se.su.dsv.bivsim.pages.Case2.Case2EditingPages.Case2EdittingCommon;

import org.apache.wicket.markup.html.basic.MultiLineLabel;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigator;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.ListDataProvider;
import org.apache.wicket.spring.injection.annot.SpringBean;
import se.su.dsv.bivsim.data.Case.dao.interfaces.HistoryEntityDao;
import se.su.dsv.bivsim.data.Case.dataobjects.HistoryEntity;
import se.su.dsv.bivsim.pages.Case2.Case2EditingPages.Case2EdittingCommon.BaseClasses.EditingMainPage2;

import java.io.FileOutputStream;
import java.util.List;


public class HistoryView2 extends EditingMainPage2 {

    @SpringBean
    HistoryEntityDao historyEntityDao;
    FileOutputStream fop;
    int i = 0;


    public HistoryView2() {

        List<HistoryEntity> list = historyEntityDao.findAllByGroupId(1);
        final DataView dataView = new DataView("simple", new ListDataProvider(
                list)) {
            public void populateItem(final Item item) {
                final HistoryEntity history = (HistoryEntity) item.getModelObject();

                String[] interviewSplits;
                if (history.getInterview() != null)
                    interviewSplits = history.getInterview().split("#");
                else
                    interviewSplits = new String[]{""};
                String tempoInterview = "";
                int i = 0;
                for (i = 0; i < interviewSplits.length; i++)
                    tempoInterview = tempoInterview + interviewSplits[i] + "\n";


                String[] Phq2Splits;
                if (history.getPhq2() != null)
                    Phq2Splits = history.getPhq2().split("#");
                else
                    Phq2Splits = new String[]{""};
                String tempoPhq2 = "";
                int j;
                for (j = 0; j < Phq2Splits.length; j++)
                    tempoPhq2 = tempoPhq2 + Phq2Splits[j] + "\n";


                String[] Phq9Splits;
                if (history.getPhq9() != null)
                    Phq9Splits = history.getPhq9().split("#");
                else
                    Phq9Splits = new String[]{""};
                String tempoPhq9 = "";
                int k;
                for (k = 0; k < Phq9Splits.length; k++)
                    tempoPhq9 = tempoPhq9 + Phq9Splits[k] + "\n";


                String[] Htq;
                if (history.getHtq() != null)
                    Htq = history.getHtq().split("#");
                else
                    Htq = new String[]{""};
                String tempoHtq = "";
                int l;
                for (l = 0; l < Htq.length; l++)
                    tempoHtq = tempoHtq + Htq[l] + "\n";


                String[] Ptsd;
                if (history.getPtsd() != null)
                    Ptsd = history.getPtsd().split("#");
                else
                    Ptsd = new String[]{""};
                String tempoPtsd = "";
                int m;
                for (m = 0; m < Ptsd.length; m++)
                    tempoPtsd = tempoPtsd + Ptsd[m] + "\n";


                String[] Hscl;
                if (history.getHscl() != null)
                    Hscl = history.getHscl().split("#");
                else
                    Hscl = new String[]{""};
                String tempoHscl = "";
                int n;
                for (n = 0; n < Hscl.length; n++)
                    tempoHscl = tempoHscl + Hscl[n] + "\n";


                String[] GenHealth;
                if (history.getGeneralHealth() != null)
                    GenHealth = history.getGeneralHealth().split("#");
                else
                    GenHealth = new String[]{""};
                String tempoGenHealth = "";
                int r;
                for (r = 0; r < GenHealth.length; r++)
                    tempoGenHealth = tempoGenHealth + GenHealth[r] + "\n";


                String[] followup;
                if (history.getFollowUp() != null)
                    followup = history.getFollowUp().split("#");
                else
                    followup = new String[]{""};
                String tempoFollowup = "";
                int w;
                for (w = 0; w < followup.length; w++)
                    tempoFollowup = tempoFollowup + followup[w] + "\n";

                String[] preliminary;
                if (history.getDomainAssessment() != null)
                    preliminary = history.getDomainAssessment().split("#");
                else
                    preliminary = new String[]{""};
                String tempopreliminary = "";
                int h;
                for (h = 0; h < preliminary.length; h++)
                    tempopreliminary = tempopreliminary + preliminary[h] + "\n";


                String[] physical;
                if (history.getPhysicalExam() != null)
                    physical = history.getPhysicalExam().split("#");
                else
                    physical = new String[]{""};
                String tempphysical = "";
                int p;
                for (p = 0; p < physical.length; p++)
                    tempphysical = tempphysical + physical[p] + "\n";


                String[] Imaging;
                if (history.getImaging() != null)
                    Imaging = history.getImaging().split("#");
                else
                    Imaging = new String[]{""};
                String tempoImaging = "";
                int y;
                for (y = 0; y < Imaging.length; y++)
                    tempoImaging = tempoImaging + Imaging[y] + "\n";


                item.add(new MultiLineLabel("Interview", "<strong>Interview Questions</strong>" + "\n" + tempoInterview).setEscapeModelStrings(false));
                item.add(new MultiLineLabel("Physical", "<strong>Physical Exam</strong>" + "\n" + tempphysical).setEscapeModelStrings(false));
                item.add(new MultiLineLabel("Imaging", "<strong> Labs and Imaging</strong>" + "\n" + tempoImaging).setEscapeModelStrings(false));
                item.add(new MultiLineLabel("phq2", "<strong>Screening Instruments</strong>" + "\n" + "<i>PHQ2:..</i>" + "\n" + tempoPhq2).setEscapeModelStrings(false));
                item.add(new MultiLineLabel("phq9", "<i>PHQ9:..</i>" + "\n" + tempoPhq9).setEscapeModelStrings(false));
                item.add(new MultiLineLabel("Htq", "<i>HTQ:..</i>" + "\n" + tempoHtq).setEscapeModelStrings(false));
                item.add(new MultiLineLabel("Ptsd", "<i>PTSD:..</i>" + "\n" + tempoPtsd).setEscapeModelStrings(false));
                item.add(new MultiLineLabel("Hscl", "<i>HSCL:..</i>" + "\n" + tempoHscl).setEscapeModelStrings(false));
                item.add(new MultiLineLabel("genHealth", "<i>General Health:..</i>" + "\n" + tempoGenHealth).setEscapeModelStrings(false));
                item.add(new MultiLineLabel("followup", "<strong> Follow Up</strong>" + "\n" + tempoFollowup).setEscapeModelStrings(false));
                item.add(new MultiLineLabel("preliminary", "<strong> Assessment</strong>" + "\n" + tempopreliminary).setEscapeModelStrings(false));


            }
        };

        dataView.setItemsPerPage(1);

        add(dataView);

        add(new PagingNavigator("navigator", dataView));


    }
}
