package se.su.dsv.bivsim.pages.CommonAllCases.SaveLog;

import org.apache.wicket.markup.html.WebPage;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by kib on 9/17/15.
 */
public class SaveLogCase extends WebPage {
    String AllFileContents;
    FileOutputStream fop;
    private String followUpReport = "";
    private String PreliminaryReport = "";

    public SaveLogCase(String Caselog) {

        // this is extra code to save sample data to log file.

        if(getSession().getAttribute("referral")!=null)
        followUpReport= getSession().getAttribute("referral").toString();

        if(getSession().getAttribute("Bedömning")!=null)
            PreliminaryReport= getSession().getAttribute("Bedömning").toString();

        String[] interviewSplits;
        if (getSession().getAttribute("Interview") != null)
            interviewSplits = getSession().getAttribute("Interview").toString().split("#");
        else
            interviewSplits = new String[]{""};
        String tempoInterview = "";
        int i = 0;
        for (i = 0; i < interviewSplits.length; i++)
            tempoInterview = tempoInterview + interviewSplits[i] + "\n";


        String[] ASRSSplits;
        if (getSession().getAttribute("ASRSreport") != null)
            ASRSSplits = getSession().getAttribute("ASRSreport").toString().split("#");
        else
            ASRSSplits = new String[]{""};
        String tempoASRS = "";
        int j;
        for (j = 0; j < ASRSSplits.length; j++)
            tempoASRS = tempoASRS + ASRSSplits[j] + "\n";


        String[] Phq9Splits;
        if (getSession().getAttribute("PHQ9report") != null)
            Phq9Splits = getSession().getAttribute("PHQ9report").toString().split("#");
        else
            Phq9Splits = new String[]{""};
        String tempoPhq9 = "";
        int k;
        for (k = 0; k < Phq9Splits.length; k++)
            tempoPhq9 = tempoPhq9 + Phq9Splits[k] + "\n";


        String[] Audit;
        if (getSession().getAttribute("Auditreport") != null)
            Audit = getSession().getAttribute("Auditreport").toString().split("#");
        else
            Audit = new String[]{""};
        String tempoAudit = "";
        int l;
        for (l = 0; l < Audit.length; l++)
            tempoAudit = tempoAudit + Audit[l] + "\n";


        String[] Ptsd;
        if (getSession().getAttribute("Ptsdreport") != null)
            Ptsd = getSession().getAttribute("Ptsdreport").toString().split("#");
        else
            Ptsd = new String[]{""};
        String tempoPtsd = "";
        int m;
        for (m = 0; m < Ptsd.length; m++)
            tempoPtsd = tempoPtsd + Ptsd[m] + "\n";


        String[] Dudit;
        if (getSession().getAttribute("Duditreport") != null)
            Dudit = getSession().getAttribute("Duditreport").toString().split("#");
        else
            Dudit = new String[]{""};
        String tempoDudit = "";
        int n;
        for (n = 0; n < Dudit.length; n++)
            tempoDudit = tempoDudit + Dudit[n] + "\n";


        String[] IES;
        if (getSession().getAttribute("IESreport") != null)
            IES = getSession().getAttribute("IESreport").toString().split("#");
        else
            IES = new String[]{""};
        String tempoIES = "";
        int r;
        for (r = 0; r < IES.length; r++)
            tempoIES = tempoIES + IES[r] + "\n";


        String[] MADRS;
        if (getSession().getAttribute("MADRSreport") != null)
            MADRS = getSession().getAttribute("MADRSreport").toString().split("#");
        else
            MADRS = new String[]{""};
        String tempoMADRS = "";
        int f;
        for (f = 0; f < MADRS.length; f++)
            tempoMADRS = tempoMADRS + MADRS[f] + "\n";




        String[] followup;
        if (followUpReport != null)
            followup = followUpReport.split("#");
        else
            followup = new String[]{""};
        String tempoFollowup = "";
        int w;
        for (w = 0; w < followup.length; w++)
            tempoFollowup = tempoFollowup + followup[w] + "\n";





        String[] preliminary;
        if (PreliminaryReport != null)
            preliminary = PreliminaryReport.split("#");
        else
            preliminary = new String[]{""};
        String tempopreliminary = "";
        int h;
        for (h = 0; h < preliminary.length; h++)
            tempopreliminary = tempopreliminary + preliminary[h] + "\n";

        String[] physical;
        if (getSession().getAttribute("Physical") != null)
            physical = getSession().getAttribute("Physical").toString().split("#");
        else
            physical = new String[]{""};
        String tempphysical = "";
        int p;
        for (p = 0; p < physical.length; p++)
            tempphysical = tempphysical + physical[p] + "\n";


        String[] Imaging;
        if (getSession().getAttribute("Imaging") != null)
            Imaging = getSession().getAttribute("Imaging").toString().split("#");
        else
            Imaging = new String[]{""};
        String tempoImaging = "";
        int y;
        for (y = 0; y < Imaging.length; y++)
            tempoImaging = tempoImaging + Imaging[y] + "\n";


        AllFileContents = "Anamnes: \n" + tempoInterview + "\n" + "\n" + "Status: \n" + tempphysical + "\n" + "\n" + "Lab/Bild: \n" + tempoImaging + "\n" + "\n" + "ASRS: \n" + tempoASRS + "\n" + "PHQ9: \n" + tempoPhq9 + "\n" + "Dudit: \n" + tempoDudit + "\n" +
                "IES-R: \n" + tempoIES+ "\n" + "PTSD: \n" + tempoPtsd + "\n" + "MADRS: \n" + tempoMADRS
                + "\n" + "Audit: \n" + tempoAudit + "\n" + "Remiss: \n" + tempoFollowup + "\n" + "Preliminär Bedömning; \n" + tempopreliminary;


        try {

            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
            File file = new File("/var/childcasesim/" + Caselog + "/" + "username" + "(" + dateFormat.format(date) + ")" + ".txt");
            BufferedWriter out = new BufferedWriter(new FileWriter(file));
            out.write(AllFileContents);
            out.close();


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fop != null) {
                    fop.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}