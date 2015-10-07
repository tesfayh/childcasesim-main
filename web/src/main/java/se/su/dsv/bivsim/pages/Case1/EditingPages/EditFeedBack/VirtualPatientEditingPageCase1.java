package se.su.dsv.bivsim.pages.Case1.EditingPages.EditFeedBack;


import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.spring.injection.annot.SpringBean;
import se.su.dsv.bivsim.data.Case.dao.interfaces.FeedbackEntityDao;
import se.su.dsv.bivsim.pages.Case1.EditingPages.Common.BaseClasses.EditingMainPage1;

public class VirtualPatientEditingPageCase1 extends EditingMainPage1 {
    ModalWindow modal;
    @SpringBean
    FeedbackEntityDao feedbackEntityDao;

    public VirtualPatientEditingPageCase1() {
        modal = new ModalWindow("dialog");
        add(modal);
        modal.setInitialHeight(400);
        modal.setInitialWidth(800);

        add(new Label("Öppningsfras", " Öppningsfras  >= " + feedbackEntityDao.findObject(1).getFeedbackValue1()));
        add(new AjaxLink<String>("edit_link") {
            @Override
            public void onClick(AjaxRequestTarget target) {
                target.prependJavaScript("Wicket.Window.unloadConfirmation = false;");
                modal.setContent(new VirtualPatientEntityPanel1("content", feedbackEntityDao.findObject(1), "Öppningsfras  >="));
                modal.show(target);
            }
        });

        add(new Label("Respekt", " Respekt > = " + feedbackEntityDao.findObject(2).getFeedbackValue1()));
        add(new AjaxLink<String>("edit_link1") {
            @Override
            public void onClick(AjaxRequestTarget target) {
                target.prependJavaScript("Wicket.Window.unloadConfirmation = false;");
                modal.setContent(new VirtualPatientEntityPanel1("content", feedbackEntityDao.findObject(2), "Respekt > ="));
                modal.show(target);
            }
        });

        add(new Label("Öppnafrågor", "Öppna frågor >= " + feedbackEntityDao.findObject(3).getFeedbackValue1()));
        add(new AjaxLink<String>("edit_link2") {
            @Override
            public void onClick(AjaxRequestTarget target) {
                target.prependJavaScript("Wicket.Window.unloadConfirmation = false;");
                modal.setContent(new VirtualPatientEntityPanel1("content", feedbackEntityDao.findObject(3), "Öppna frågor >="));
                modal.show(target);
            }
        });

        add(new Label("3F", "3F >= " + feedbackEntityDao.findObject(4).getFeedbackValue1()));
        add(new AjaxLink<String>("edit_link3") {
            @Override
            public void onClick(AjaxRequestTarget target) {
                target.prependJavaScript("Wicket.Window.unloadConfirmation = false;");
                modal.setContent(new VirtualPatientEntityPanel1("content", feedbackEntityDao.findObject(4), "3F >="));
                modal.show(target);
            }
        });

        add(new Label("Spegling", "Spegling > = " + feedbackEntityDao.findObject(5).getFeedbackValue1()));
        add(new AjaxLink<String>("edit_link4") {
            @Override
            public void onClick(AjaxRequestTarget target) {
                target.prependJavaScript("Wicket.Window.unloadConfirmation = false;");
                modal.setContent(new VirtualPatientEntityPanel1("content", feedbackEntityDao.findObject(5), "Spegling > ="));
                modal.show(target);
            }
        });

        add(new Label("Empati", "Empati > =  " + feedbackEntityDao.findObject(6).getFeedbackValue1()));
        add(new AjaxLink<String>("edit_link5") {
            @Override
            public void onClick(AjaxRequestTarget target) {
                target.prependJavaScript("Wicket.Window.unloadConfirmation = false;");
                modal.setContent(new VirtualPatientEntityPanel1("content", feedbackEntityDao.findObject(6), "Empati > = "));
                modal.show(target);
            }
        });


        add(new Label("Relevans", "Relevans >=  " + feedbackEntityDao.findObject(7).getFeedbackValue1()));
        add(new AjaxLink<String>("edit_link6") {
            @Override
            public void onClick(AjaxRequestTarget target) {
                target.prependJavaScript("Wicket.Window.unloadConfirmation = false;");
                modal.setContent(new VirtualPatientEntityPanel1("content", feedbackEntityDao.findObject(7), "Relevans >= "));
                modal.show(target);
            }
        });

        add(new Label("Tillit", "Tillit > = " + feedbackEntityDao.findObject(8).getFeedbackValue1()));
        add(new AjaxLink<String>("edit_link7") {
            @Override
            public void onClick(AjaxRequestTarget target) {
                target.prependJavaScript("Wicket.Window.unloadConfirmation = false;");
                modal.setContent(new VirtualPatientEntityPanel1("content", feedbackEntityDao.findObject(8), "Tillit > ="));
                modal.show(target);
            }
        });


        add(new Label("Antalfrågor", "Antal frågor < " + feedbackEntityDao.findObject(9).getFeedbackValue1() ));
        add(new AjaxLink<String>("edit_link8") {
            @Override
            public void onClick(AjaxRequestTarget target) {
                target.prependJavaScript("Wicket.Window.unloadConfirmation = false;");
                modal.setContent(new VirtualPatientEntityPanel1("content", feedbackEntityDao.findObject(9), "Antal frågor < "));
                modal.show(target);
            }
        });


       /* add(new Label("trustrespect", " trust value < " + feedbackEntityDao.findObject(10).getFeedbackValue1() + " OR respect < " + feedbackEntityDao.findObject(10).getFeedbackValue2()));
        add(new AjaxLink<String>("edit_link9") {
            @Override
            public void onClick(AjaxRequestTarget target) {
                target.prependJavaScript("Wicket.Window.unloadConfirmation = false;");
                modal.setContent(new VirtualPatientEntityPanel2("content", feedbackEntityDao.findObject(10), " trust value <  ", " OR respect <"));
                modal.show(target);
            }
        });


        add(new Label("subqMirror", " Sub-questions < " + feedbackEntityDao.findObject(11).getFeedbackValue1() + " ΑND mirror < " + feedbackEntityDao.findObject(11).getFeedbackValue2()));
        add(new AjaxLink<String>("edit_link10") {
            @Override
            public void onClick(AjaxRequestTarget target) {
                target.prependJavaScript("Wicket.Window.unloadConfirmation = false;");
                modal.setContent(new VirtualPatientEntityPanel2("content", feedbackEntityDao.findObject(11), " Sub-questions < ", " ΑND mirror < "));
                modal.show(target);
            }
        });

        add(new Label("Trustvalue", "Trust value < " + feedbackEntityDao.findObject(12).getFeedbackValue1()));
        add(new AjaxLink<String>("edit_link11") {
            @Override
            public void onClick(AjaxRequestTarget target) {
                target.prependJavaScript("Wicket.Window.unloadConfirmation = false;");
                modal.setContent(new VirtualPatientEntityPanel1("content", feedbackEntityDao.findObject(12), " Trust value < "));
                modal.show(target);
            }
        });

        add(new Label("trustrespectAnd", " trust value < " + feedbackEntityDao.findObject(13).getFeedbackValue1() + " AND respect < " + feedbackEntityDao.findObject(13).getFeedbackValue2()));
        add(new AjaxLink<String>("edit_link12") {
            @Override
            public void onClick(AjaxRequestTarget target) {
                target.prependJavaScript("Wicket.Window.unloadConfirmation = false;");
                modal.setContent(new VirtualPatientEntityPanel2("content", feedbackEntityDao.findObject(13), " trust value < ", " AND respect < "));
                modal.show(target);
            }
        });*/


// Postive feedback editing code


        add(new Label("nÖppningsfras", " Öppningsfras < =  " + feedbackEntityDao.findObject(10).getFeedbackValue1()));
        add(new AjaxLink<String>("nedit_link") {
            @Override
            public void onClick(AjaxRequestTarget target) {
                target.prependJavaScript("Wicket.Window.unloadConfirmation = false;");
                modal.setContent(new VirtualPatientEntityPanel1("content", feedbackEntityDao.findObject(10), " Öppningsfras < = "));
                modal.show(target);
            }
        });

        add(new Label("nRespekt", " Respekt <   " + feedbackEntityDao.findObject(11).getFeedbackValue1()));
        add(new AjaxLink<String>("nedit_link1") {
            @Override
            public void onClick(AjaxRequestTarget target) {
                target.prependJavaScript("Wicket.Window.unloadConfirmation = false;");
                modal.setContent(new VirtualPatientEntityPanel1("content", feedbackEntityDao.findObject(11), "Respekt < "));
                modal.show(target);
            }
        });

        add(new Label("nÖppnafrågor", "Öppna frågor < " + feedbackEntityDao.findObject(12).getFeedbackValue1()));
        add(new AjaxLink<String>("nedit_link2") {
            @Override
            public void onClick(AjaxRequestTarget target) {
                target.prependJavaScript("Wicket.Window.unloadConfirmation = false;");
                modal.setContent(new VirtualPatientEntityPanel1("content", feedbackEntityDao.findObject(12), "Öppna frågor < "));
                modal.show(target);
            }
        });

        add(new Label("n3F", "3F <" + feedbackEntityDao.findObject(13).getFeedbackValue1()));
        add(new AjaxLink<String>("nedit_link3") {
            @Override
            public void onClick(AjaxRequestTarget target) {
                target.prependJavaScript("Wicket.Window.unloadConfirmation = false;");
                modal.setContent(new VirtualPatientEntityPanel1("content", feedbackEntityDao.findObject(13), "3F <"));
                modal.show(target);
            }
        });

        add(new Label("nSpegling", "Spegling <" + feedbackEntityDao.findObject(14).getFeedbackValue1()));
        add(new AjaxLink<String>("nedit_link4") {
            @Override
            public void onClick(AjaxRequestTarget target) {
                target.prependJavaScript("Wicket.Window.unloadConfirmation = false;");
                modal.setContent(new VirtualPatientEntityPanel1("content", feedbackEntityDao.findObject(14), "Spegling <"));
                modal.show(target);
            }
        });

        add(new Label("nEmpati", "Empati < " + feedbackEntityDao.findObject(15).getFeedbackValue1()));
        add(new AjaxLink<String>("nedit_link5") {
            @Override
            public void onClick(AjaxRequestTarget target) {
                target.prependJavaScript("Wicket.Window.unloadConfirmation = false;");
                modal.setContent(new VirtualPatientEntityPanel1("content", feedbackEntityDao.findObject(15), "Empati < "));
                modal.show(target);
            }
        });

        add(new Label("nRelevans", "Relevans  < " + feedbackEntityDao.findObject(16).getFeedbackValue1()));
        add(new AjaxLink<String>("nedit_link5r") {
            @Override
            public void onClick(AjaxRequestTarget target) {
                target.prependJavaScript("Wicket.Window.unloadConfirmation = false;");
                modal.setContent(new VirtualPatientEntityPanel1("content", feedbackEntityDao.findObject(16), "Relevans  <"));
                modal.show(target);
            }
        });


        add(new Label("nTillit", "Tillit  < =" + feedbackEntityDao.findObject(17).getFeedbackValue1()));
        add(new AjaxLink<String>("nedit_link6") {
            @Override
            public void onClick(AjaxRequestTarget target) {
                target.prependJavaScript("Wicket.Window.unloadConfirmation = false;");
                modal.setContent(new VirtualPatientEntityPanel1("content", feedbackEntityDao.findObject(17), "Tillit  < ="));
                modal.show(target);
            }
        });

        add(new Label("nAntalfrågor", "Antal frågor > " + feedbackEntityDao.findObject(18).getFeedbackValue1()));
        add(new AjaxLink<String>("nedit_link7") {
            @Override
            public void onClick(AjaxRequestTarget target) {
                target.prependJavaScript("Wicket.Window.unloadConfirmation = false;");
                modal.setContent(new VirtualPatientEntityPanel1("content", feedbackEntityDao.findObject(18), "Antal frågor >"));
                modal.show(target);
            }
        });

/*

        add(new Label("nTrustsubmirror", " trust value = " + feedbackEntityDao.findObject(23).getFeedbackValue1() + " AND ( sub-questions > " + feedbackEntityDao.findObject(23).getFeedbackValue2() + "OR  mirror >" + feedbackEntityDao.findObject(23).getFeedbackValue3()));
        add(new AjaxLink<String>("nedit_link8") {
            @Override
            public void onClick(AjaxRequestTarget target) {
                target.prependJavaScript("Wicket.Window.unloadConfirmation = false;");
                modal.setContent(new VirtualPatientEntityPanel3("content", feedbackEntityDao.findObject(23), "trust value = ", " AND ( sub-questions > ", "ΟR  mirror >"));
                modal.show(target);
            }
        });
*/


       /* add(new Label("ntrustrespect", " trust value =" + feedbackEntityDao.findObject(24).getFeedbackValue1() + " OR respect >= " + feedbackEntityDao.findObject(24).getFeedbackValue2()));
        add(new AjaxLink<String>("nedit_link9") {
            @Override
            public void onClick(AjaxRequestTarget target) {
                target.prependJavaScript("Wicket.Window.unloadConfirmation = false;");
                modal.setContent(new VirtualPatientEntityPanel2("content", feedbackEntityDao.findObject(24), " trust value =  ", " OR respect >="));
                modal.show(target);
            }
        });


        add(new Label("nsubqMirror", " Sub-questions >=" + feedbackEntityDao.findObject(25).getFeedbackValue1() + " OR mirror >= " + feedbackEntityDao.findObject(25).getFeedbackValue2()));
        add(new AjaxLink<String>("nedit_link10") {
            @Override
            public void onClick(AjaxRequestTarget target) {
                target.prependJavaScript("Wicket.Window.unloadConfirmation = false;");
                modal.setContent(new VirtualPatientEntityPanel2("content", feedbackEntityDao.findObject(25), " Sub-questions < ", " OR mirror >="));
                modal.show(target);
            }
        });

        add(new Label("nTrustvalue", "Trust value = " + feedbackEntityDao.findObject(27).getFeedbackValue1()));
        add(new AjaxLink<String>("nedit_link11") {
            @Override
            public void onClick(AjaxRequestTarget target) {
                target.prependJavaScript("Wicket.Window.unloadConfirmation = false;");
                modal.setContent(new VirtualPatientEntityPanel1("content", feedbackEntityDao.findObject(27), " Trust value = "));
                modal.show(target);
            }
        });

        add(new Label("ntrustrespectAnd", " trust value = " + feedbackEntityDao.findObject(28).getFeedbackValue1() + " AND respect >= " + feedbackEntityDao.findObject(28).getFeedbackValue2()));
        add(new AjaxLink<String>("nedit_link12") {
            @Override
            public void onClick(AjaxRequestTarget target) {
                target.prependJavaScript("Wicket.Window.unloadConfirmation = false;");
                modal.setContent(new VirtualPatientEntityPanel2("content", feedbackEntityDao.findObject(28), " trust value = ", " AND respect >= "));
                modal.show(target);
            }
        });*/

    }
}