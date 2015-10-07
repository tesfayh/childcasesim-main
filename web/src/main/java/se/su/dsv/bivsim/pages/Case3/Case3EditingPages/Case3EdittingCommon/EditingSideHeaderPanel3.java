package se.su.dsv.bivsim.pages.Case3.Case3EditingPages.Case3EdittingCommon;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;
import se.su.dsv.bivsim.pages.Case3.Case3EditingPages.Case3EditAssessment.EditFollowUpPage;
import se.su.dsv.bivsim.pages.Case3.Case3EditingPages.Case3EditAssessment.EditPrelimninaryAsssmentpage;
import se.su.dsv.bivsim.pages.Case3.Case3EditingPages.Case3EditFeedBack.VirtualAdviserEntityEditingPageCase3;
import se.su.dsv.bivsim.pages.Case3.Case3EditingPages.Case3EditFeedBack.VirtualPatientEditingPageCase3;
import se.su.dsv.bivsim.pages.Case3.Case3EditingPages.Case3EditInterview.EditInterviewDropDownChoicePageCase3;
import se.su.dsv.bivsim.pages.Case3.Case3EditingPages.Case3Editphyiscalexam.PhysicalExamDropDownChoicePageCase3;
import se.su.dsv.bivsim.pages.Case3.Case3EditingPages.Case3LabsAndImaging.LabAndImageDropDownChoicePageCase3;

public class EditingSideHeaderPanel3 extends Panel {

    public EditingSideHeaderPanel3(String id) {

        super(id);

        Link edit_Questions = new AjaxFallbackLink("questions") {
            @Override
            public void onClick(AjaxRequestTarget target) {
                this.setResponsePage(EditInterviewDropDownChoicePageCase3.class);
            }
        };
        this.add(edit_Questions);


        Link edit_physicalexam = new AjaxFallbackLink("edit_physicalExam") {
            @Override
            public void onClick(AjaxRequestTarget target) {
                this.setResponsePage(PhysicalExamDropDownChoicePageCase3.class);
            }
        };
        add(edit_physicalexam);
        Link edit_labsAndImaging = new AjaxFallbackLink("edit_labsAndImaging") {
            @Override
            public void onClick(AjaxRequestTarget target) {
                this.setResponsePage(LabAndImageDropDownChoicePageCase3.class);
            }
        };
        add(edit_labsAndImaging);

 /*       Link edit_screeningInstruments = new AjaxFallbackLink("edit_screeningInstruments") {
            @Override
            public void onClick(AjaxRequestTarget target) {

*//*
                this.setResponsePage(ListofScreeningInstruments.class);
*//*

            }
        };
        add(edit_screeningInstruments);*/
        Link edit_patient = new AjaxFallbackLink("patient") {
            @Override
            public void onClick(AjaxRequestTarget target) {
                this.setResponsePage(VirtualPatientEditingPageCase3.class);
            }
        };
        this.add(edit_patient);

        Link edit_virtual = new AjaxFallbackLink("virtual") {
            @Override
            public void onClick(AjaxRequestTarget target) {
                this.setResponsePage(VirtualAdviserEntityEditingPageCase3.class);

            }
        };
        this.add(edit_virtual);

        Link Preliminary = new AjaxFallbackLink("Preliminary") {
            @Override
            public void onClick(AjaxRequestTarget target) {
                this.setResponsePage(EditPrelimninaryAsssmentpage.class);

            }
        };
        this.add(Preliminary);

        Link FollowUp = new AjaxFallbackLink("FollowUp") {
            @Override
            public void onClick(AjaxRequestTarget target) {
                this.setResponsePage(EditFollowUpPage.class);
            }
        };
        this.add(FollowUp);

/*
        Link history = new AjaxFallbackLink("History") {
            @Override
            public void onClick(AjaxRequestTarget target) {
                this.setResponsePage(HistoryView1.class);

            }
        };
        this.add(history);*/

       /* Link back = new AjaxFallbackLink("Back") {
            @Override
            public void onClick(AjaxRequestTarget target) {
                this.setResponsePage(CommonEditingPage.class);

            }
        };
        this.add(back);*/

      /*  Link download = new AjaxFallbackLink("download") {
            @Override
            public void onClick(AjaxRequestTarget target) {
                this.setResponsePage(DownloadlogFile.class);

            }
        };
        this.add(download);
        Link report = new AjaxFallbackLink("report") {
            @Override
            public void onClick(AjaxRequestTarget target) {
                this.setResponsePage(ReportChange.class);
            }
        };
        this.add(report);*/


    }
}
