package se.su.dsv.bivsim.pages.CommonAllCases.SaveLog;

import org.apache.wicket.markup.html.WebPage;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by kib on 9/17/15.
 */
public class SaveLogCase3 extends WebPage {
    String AllFileContents;
    FileOutputStream fop;
    private String followUpReport = "";
    private String PreliminaryReport = "";

    public SaveLogCase3(String Caselog) {

        // this is extra code to save sample data to log file.

        if(getSession().getAttribute("referralValue")!=null)
            followUpReport= getSession().getAttribute("referralValue").toString();

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

        String InstrumentTemp=getSession().getAttribute("instrumentValue").toString();

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


        AllFileContents = "############################################################" + "\n" +
                "Anamnes: \n" + "\n"  + tempoInterview + "\n"  +
                "\n" + "############################################################"+ "\n" + "Status: \n" + "\n"  +  tempphysical + "\n" + "\n" + "############################################################" + "\n" +
                "Lab/Bild: \n" + "\n" +  tempoImaging + "\n" + "\n" +  "############################################################"
                + "\n" +
                "Instrument: \n" + "\n" +  InstrumentTemp + "\n"  +  "\n"+"############################################################"+  "\n" +"Remiss: \n" + "\n" + tempoFollowup + "\n" + "############################################################" + "\n"+  "Preliminär Bedömning; \n" +  "\n" + tempopreliminary;


        try {

            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
            File file = new File("/var/childcasesim/" + "Case3log/" + getSession().getAttribute("username").toString() + "(" + dateFormat.format(date) + ")" + ".txt");
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