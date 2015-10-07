package se.su.dsv.bivsim.pages.Case2.Case2EditingPages.Case2EdittingCommon;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;
import se.su.dsv.bivsim.pages.Case2.Case2EditingPages.Case2EditAssessment.EditFollowUpPage;
import se.su.dsv.bivsim.pages.Case2.Case2EditingPages.Case2EditAssessment.EditPrelimninaryAsssmentpage;
import se.su.dsv.bivsim.pages.Case2.Case2EditingPages.Case2EditFeedBack.VirtualAdviserEntityEditingPageCase2;
import se.su.dsv.bivsim.pages.Case2.Case2EditingPages.Case2EditFeedBack.VirtualPatientEditingPageCase2;
import se.su.dsv.bivsim.pages.Case2.Case2EditingPages.Case2EditInterview.EditInterviewDropDownChoicePageCase2;
import se.su.dsv.bivsim.pages.Case2.Case2EditingPages.Case2Editphyiscalexam.PhysicalExamDropDownChoicePageCase2;
import se.su.dsv.bivsim.pages.Case2.Case2EditingPages.Case2LabsAndImaging.LabAndImageDropDownChoicePageCase2;

public class EditingSideHeaderPanel2 extends Panel {

    public EditingSideHeaderPanel2(String id) {

        super(id);

        Link edit_Questions = new AjaxFallbackLink("questions") {
            @Override
            public void onClick(AjaxRequestTarget target) {
                this.setResponsePage(EditInterviewDropDownChoicePageCase2.class);
            }
        };
        this.add(edit_Questions);


        Link edit_physicalexam = new AjaxFallbackLink("edit_physicalExam") {
            @Override
            public void onClick(AjaxRequestTarget target) {
                this.setResponsePage(PhysicalExamDropDownChoicePageCase2.class);
            }
        };
        add(edit_physicalexam);
        Link edit_labsAndImaging = new AjaxFallbackLink("edit_labsAndImaging") {
            @Override
            public void onClick(AjaxRequestTarget target) {
                this.setResponsePage(LabAndImageDropDownChoicePageCase2.class);
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
                this.setResponsePage(VirtualPatientEditingPageCase2.class);
            }
        };
        this.add(edit_patient);

        Link edit_virtual = new AjaxFallbackLink("virtual") {
            @Override
            public void onClick(AjaxRequestTarget target) {
                this.setResponsePage(new VirtualAdviserEntityEditingPageCase2(2));

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
