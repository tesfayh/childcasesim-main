package se.su.dsv.bivsim.pages.Case1.interview;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.extensions.markup.html.repeater.tree.DefaultNestedTree;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import se.su.dsv.childcasesim.data.Case.dao.interfaces.InterviewEntityDao;
import se.su.dsv.childcasesim.data.Case.dataobjects.InterviewEntity;
import se.su.dsv.childcasesim.pages.Case1.CommonCase1.HomePage;
import se.su.dsv.childcasesim.pages.CommonAllCases.General.*;
import se.su.dsv.childcasesim.pages.CommonAllCases.Interv.AbstractTreePanel;
import se.su.dsv.childcasesim.pages.CommonAllCases.Interv.InterviewFolder;
import se.su.dsv.childcasesim.pages.CommonAllCases.Interv.SearchInterviewProvider;

public class SearchInterveiwTreePanel extends AbstractTreePanel {
    @SpringBean
    InterviewEntityDao interviewEntityDao;


    private static final long serialVersionUID = 1L;

    public void setContent(Panel panel, AjaxRequestTarget target) {
        ((HomePage) getPage()).getContentWmc().replace(panel);
        target.add(((HomePage) getPage()).getContentWmc());
    }

    public SearchInterveiwTreePanel(String id, final String Search) {
        super(id);


        add(new DefaultNestedTree<InterviewEntity>("tree", new SearchInterviewProvider(interviewEntityDao, Search)) {
            @Override
            public Component newContentComponent(String id, final IModel<InterviewEntity> model) {
                if (getProvider().hasChildren(model.getObject()))

                    return new InterviewFolder(id, this, model) {

                        @Override
                        public void clicked(AjaxRequestTarget target) {

                            ContentPanel panel;
                            if (model.getObject().getClipId() != null && model.getObject().getPatientAnswer() != null && !model.getObject().getClipId().contains("pic")) {
                                panel = new VideoPanel("content", model.getObject().getPatientAnswer(), model.getObject().getClipId(), new VideoResourceReference());
                                getSession().setAttribute("Antalfrågor", (Integer) getSession().getAttribute("Antalfrågor") + 1);

                                getSession().setAttribute("Interview", getSession().getAttribute("Interview") + "Q:" + model.getObject().getName() + "\n" + "--Ans:" + model.getObject().getPatientAnswer() + "#");

                            } else if (model.getObject().getClipId() != null && model.getObject().getPatientAnswer() != null && model.getObject().getClipId().contains("pic"))
                                panel = new InterviewPicturePanel("content", model.getObject().getPatientAnswer(), model.getObject().getClipId(), new VideoResourceReference2());

                                //panel = new ContentPanel("content", "Please select a Question!");
                            else
                                panel = new ContentPanel("content", "Please select a Question!");
                            setContent(panel, target);

                            if (model.getObject().getFeedbackInput() != null) {
                                if (model.getObject().getFeedbackInput().contains("Öppningsfras")) {
                                    if (model.getObject().getFeedbackInput().contains("Öppningsfras+1"))
                                        getSession().setAttribute("Öppningsfras", (Integer) getSession().getAttribute("Öppningsfras") + 1);
                                    else if (model.getObject().getFeedbackInput().contains("Öppningsfras+2"))
                                        getSession().setAttribute("Öppningsfras", (Integer) getSession().getAttribute("Öppningsfras") + 2);
                                    else if (model.getObject().getFeedbackInput().contains("Öppningsfras-1"))
                                        getSession().setAttribute("Öppningsfras", (Integer) getSession().getAttribute("Öppningsfras") - 1);
                                    else
                                        getSession().setAttribute("Öppningsfras", (Integer) getSession().getAttribute("Öppningsfras") - 2);
                                }
                                if (model.getObject().getFeedbackInput().contains("Respekt")) {

                                    if (model.getObject().getFeedbackInput().contains("Respekt+1"))
                                        getSession().setAttribute("Respekt", (Integer) getSession().getAttribute("Respekt") + 1);
                                    else if (model.getObject().getFeedbackInput().contains("Respekt+2"))
                                        getSession().setAttribute("Respekt", (Integer) getSession().getAttribute("Respekt") + 2);
                                    else if (model.getObject().getFeedbackInput().contains("Respekt-1"))
                                        getSession().setAttribute("Respekt", (Integer) getSession().getAttribute("Respekt") - 1);
                                    else
                                        getSession().setAttribute("Respekt", (Integer) getSession().getAttribute("Respekt") - 2);
                                }
                                if (model.getObject().getFeedbackInput().contains("Öppnafrågor")) {

                                    if (model.getObject().getFeedbackInput().contains("Öppnafrågor+1"))
                                        getSession().setAttribute("Öppnafrågor", (Integer) getSession().getAttribute("Öppnafrågor") + 1);
                                    else if (model.getObject().getFeedbackInput().contains("Öppnafrågor+2"))
                                        getSession().setAttribute("Öppnafrågor", (Integer) getSession().getAttribute("Öppnafrågor") + 2);
                                    else if (model.getObject().getFeedbackInput().contains("Öppnafrågor-1"))
                                        getSession().setAttribute("Öppnafrågor", (Integer) getSession().getAttribute("Öppnafrågor") - 1);
                                    else
                                        getSession().setAttribute("Öppnafrågor", (Integer) getSession().getAttribute("Öppnafrågor") - 2);

                                }

                                if (model.getObject().getFeedbackInput().contains("3F")) {

                                    if (model.getObject().getFeedbackInput().contains("3F+1"))
                                        getSession().setAttribute("3F", (Integer) getSession().getAttribute("3F") + 1);
                                    else if (model.getObject().getFeedbackInput().contains("3F+2"))
                                        getSession().setAttribute("3F", (Integer) getSession().getAttribute("3F") + 2);
                                    else if (model.getObject().getFeedbackInput().contains("3F-1"))
                                        getSession().setAttribute("3F", (Integer) getSession().getAttribute("3F") - 1);
                                    else
                                        getSession().setAttribute("3F", (Integer) getSession().getAttribute("3F") - 2);


                                }
                                if (model.getObject().getFeedbackInput().contains("Spegling")) {
                                    if (model.getObject().getFeedbackInput().contains("Spegling+1"))
                                        getSession().setAttribute("Spegling", (Integer) getSession().getAttribute("Spegling") + 1);
                                    else if (model.getObject().getFeedbackInput().contains("Spegling+2"))
                                        getSession().setAttribute("Spegling", (Integer) getSession().getAttribute("Spegling") + 2);
                                    else if (model.getObject().getFeedbackInput().contains("Spegling-1"))
                                        getSession().setAttribute("Spegling", (Integer) getSession().getAttribute("Spegling") - 1);
                                    else
                                        getSession().setAttribute("Spegling", (Integer) getSession().getAttribute("Spegling") - 2);


                                }
                                if (model.getObject().getFeedbackInput().contains("Empati")) {
                                    if (model.getObject().getFeedbackInput().contains("Empati+1"))
                                        getSession().setAttribute("Empati", (Integer) getSession().getAttribute("Empati") + 1);
                                    else if (model.getObject().getFeedbackInput().contains("Empati+2"))
                                        getSession().setAttribute("Empati", (Integer) getSession().getAttribute("Empati") + 2);
                                    else if (model.getObject().getFeedbackInput().contains("Empati-1"))
                                        getSession().setAttribute("Empati", (Integer) getSession().getAttribute("Empati") - 1);
                                    else
                                        getSession().setAttribute("Empati", (Integer) getSession().getAttribute("Empati") - 2);


                                }
                                if (model.getObject().getFeedbackInput().contains("Relevans")) {
                                    if (model.getObject().getFeedbackInput().contains("Relevans+1"))
                                        getSession().setAttribute("Relevans", (Integer) getSession().getAttribute("Relevans") + 1);
                                    else if (model.getObject().getFeedbackInput().contains("Relevans+2"))
                                        getSession().setAttribute("Relevans", (Integer) getSession().getAttribute("Relevans") + 2);
                                    else if (model.getObject().getFeedbackInput().contains("Relevans-1"))
                                        getSession().setAttribute("Relevans", (Integer) getSession().getAttribute("Relevans") - 1);
                                    else
                                        getSession().setAttribute("Relevans", (Integer) getSession().getAttribute("Relevans") - 2);


                                }
                                if (model.getObject().getFeedbackInput().contains("Tillit")) {
                                    if (model.getObject().getFeedbackInput().contains("Tillit+1"))
                                        getSession().setAttribute("Tillit", (Integer) getSession().getAttribute("Tillit") + 1);
                                    else if (model.getObject().getFeedbackInput().contains("Tillit+2"))
                                        getSession().setAttribute("Tillit", (Integer) getSession().getAttribute("Tillit") + 2);
                                    else if (model.getObject().getFeedbackInput().contains("Tillit-1"))
                                        getSession().setAttribute("Tillit", (Integer) getSession().getAttribute("Tillit") - 1);
                                    else
                                        getSession().setAttribute("Tillit", (Integer) getSession().getAttribute("Tillit") - 2);

                                }



                            }


                            // feedback logic

                            if (model.getObject().getExp_feedbackInput() != null) {

                                if (model.getObject().getExp_feedbackInput().contains("Spegling")) {

                                    if (model.getObject().getExp_feedbackInput().contains("Spegling+1"))
                                        getSession().setAttribute("exSpegling", (Integer) getSession().getAttribute("exSpegling") + 1);


                                    else if (model.getObject().getExp_feedbackInput().contains("Spegling+2"))
                                        getSession().setAttribute("exSpegling", (Integer) getSession().getAttribute("exSpegling") + 2);
                                    else if (model.getObject().getExp_feedbackInput().contains("Spegling-1"))
                                        getSession().setAttribute("exSpegling", (Integer) getSession().getAttribute("exSpegling") - 1);
                                    else
                                        getSession().setAttribute("exSpegling", (Integer) getSession().getAttribute("exSpegling") - 2);


                                }

                                if (model.getObject().getExp_feedbackInput().contains("Öppnafrågor")) {

                                    if (model.getObject().getFeedbackInput().contains("Öppnafrågor+1"))
                                        getSession().setAttribute("exÖppnafrågor", (Integer) getSession().getAttribute("exÖppnafrågor") + 1);
                                    else if (model.getObject().getFeedbackInput().contains("Öppnafrågor+2"))
                                        getSession().setAttribute("exÖppnafrågor", (Integer) getSession().getAttribute("exÖppnafrågor") + 2);
                                    else if (model.getObject().getFeedbackInput().contains("Öppnafrågor-1"))
                                        getSession().setAttribute("exÖppnafrågor", (Integer) getSession().getAttribute("exÖppnafrågor") - 1);
                                    else
                                        getSession().setAttribute("Öppnafrågor", (Integer) getSession().getAttribute("exÖppnafrågor") - 2);

                                }
                                if (model.getObject().getExp_feedbackInput().contains("Egenbedömning")) {

                                    if (model.getObject().getExp_feedbackInput().contains("Egenbedömning+1"))
                                        getSession().setAttribute("exEgenbedömning", (Integer) getSession().getAttribute("exEgenbedömning") + 1);
                                    else if (model.getObject().getExp_feedbackInput().contains("Egenbedömning+2"))
                                        getSession().setAttribute("exEgenbedömning", (Integer) getSession().getAttribute("exEgenbedömning") + 2);
                                    else if (model.getObject().getExp_feedbackInput().contains("Egenbedömning-1"))
                                        getSession().setAttribute("exEgenbedömning", (Integer) getSession().getAttribute("exEgenbedömning") - 1);
                                    else
                                        getSession().setAttribute("exEgenbedömning", (Integer) getSession().getAttribute("exEgenbedömning") - 2);


                                }

                                if (model.getObject().getExp_feedbackInput().contains("Socialt")) {

                                    if (model.getObject().getExp_feedbackInput().contains("Socialt+1"))
                                        getSession().setAttribute("exSocialt", (Integer) getSession().getAttribute("exSocialt") + 1);
                                    else if (model.getObject().getExp_feedbackInput().contains("Socialt+2"))
                                        getSession().setAttribute("exSocialt", (Integer) getSession().getAttribute("exSocialt") + 2);
                                    else if (model.getObject().getExp_feedbackInput().contains("Socialt-1"))
                                        getSession().setAttribute("exSocialt", (Integer) getSession().getAttribute("exSocialt") - 1);
                                    else
                                        getSession().setAttribute("exSocialt", (Integer) getSession().getAttribute("exSocialt") - 2);


                                }


                                if (model.getObject().getExp_feedbackInput().contains("Funktionsnivå")) {

                                    if (model.getObject().getFeedbackInput().contains("Funktionsnivå+1"))
                                        getSession().setAttribute("exFunktionsnivå", (Integer) getSession().getAttribute("exFunktionsnivå") + 1);
                                    else if (model.getObject().getFeedbackInput().contains("Funktionsnivå+2"))
                                        getSession().setAttribute("exFunktionsnivå", (Integer) getSession().getAttribute("exFunktionsnivå") + 2);
                                    else if (model.getObject().getFeedbackInput().contains("Funktionsnivå-1"))
                                        getSession().setAttribute("exFunktionsnivå", (Integer) getSession().getAttribute("exFunktionsnivå") - 1);
                                    else
                                        getSession().setAttribute("exFunktionsnivå", (Integer) getSession().getAttribute("exFunktionsnivå") - 2);

                                }



                                if (model.getObject().getExp_feedbackInput().contains("Barn")) {

                                    if (model.getObject().getExp_feedbackInput().contains("Barn+1"))
                                        getSession().setAttribute("exBarn", (Integer) getSession().getAttribute("exBarn") + 1);
                                    else if (model.getObject().getExp_feedbackInput().contains("Barn+2"))
                                        getSession().setAttribute("exBarn", (Integer) getSession().getAttribute("exBarn") + 2);
                                    else if (model.getObject().getExp_feedbackInput().contains("Barn-1"))
                                        getSession().setAttribute("exBarn", (Integer) getSession().getAttribute("exBarn") - 1);
                                    else
                                        getSession().setAttribute("exBarn", (Integer) getSession().getAttribute("exBarn") - 2);


                                }
                                if (model.getObject().getExp_feedbackInput().contains("Motivation")) {

                                    if (model.getObject().getExp_feedbackInput().contains("Motivation+1"))
                                        getSession().setAttribute("exMotivation", (Integer) getSession().getAttribute("exMotivation") + 1);
                                    else if (model.getObject().getExp_feedbackInput().contains("Motivation+2"))
                                        getSession().setAttribute("exMotivation", (Integer) getSession().getAttribute("exMotivation") + 2);
                                    else if (model.getObject().getExp_feedbackInput().contains("Motivation-1"))
                                        getSession().setAttribute("exMotivation", (Integer) getSession().getAttribute("exMotivation") - 1);
                                    else
                                        getSession().setAttribute("exMotivation", (Integer) getSession().getAttribute("exMotivation") - 2);


                                }


                            }




                        }

                    };
                return new InterviewSimplePanel(id, model) {
                    @Override
                    public void clicked(AjaxRequestTarget target) {

                        ContentPanel panel;
                        if (model.getObject().getClipId() != null && model.getObject().getPatientAnswer() != null && !model.getObject().getClipId().contains("pic")) {
                            panel = new VideoPanel("content", model.getObject().getPatientAnswer(), model.getObject().getClipId(), new VideoResourceReference());
                            getSession().setAttribute("Antalfrågor", (Integer) getSession().getAttribute("Antalfrågor") + 1);
                            //getSession().setAttribute("Number_of_questions_asked", (Integer) getSession().getAttribute("Number_of_questions_asked") + 1);

//                            getSession().setAttribute("Sub_questions", (Integer) getSession().getAttribute("Sub_questions") + 1);
                            getSession().setAttribute("Interview", getSession().getAttribute("Interview") + "Q:" + model.getObject().getName() + "\n" + "--Ans:" + model.getObject().getPatientAnswer() + "#");

                        } else if (model.getObject().getClipId() != null && model.getObject().getPatientAnswer() != null && model.getObject().getClipId().contains("pic"))
                            //panel = new ContentPanel("content", "Please select a Question!");
                            panel = new InterviewPicturePanel("content", model.getObject().getPatientAnswer(), model.getObject().getClipId(), new VideoResourceReference());
                        else
                            panel = new ContentPanel("content", "Please select a Question!");
                        setContent(panel, target);
                        if (model.getObject().getFeedbackInput() != null) {
                            if (model.getObject().getFeedbackInput().contains("Öppningsfras")) {
                                if (model.getObject().getFeedbackInput().contains("Öppningsfras+1"))
                                    getSession().setAttribute("Öppningsfras", (Integer) getSession().getAttribute("Öppningsfras") + 1);
                                else if (model.getObject().getFeedbackInput().contains("Öppningsfras+2"))
                                    getSession().setAttribute("Öppningsfras", (Integer) getSession().getAttribute("Öppningsfras") + 2);
                                else if (model.getObject().getFeedbackInput().contains("Öppningsfras-1"))
                                    getSession().setAttribute("Öppningsfras", (Integer) getSession().getAttribute("Öppningsfras") - 1);
                                else
                                    getSession().setAttribute("Öppningsfras", (Integer) getSession().getAttribute("Öppningsfras") - 2);
                            }
                            if (model.getObject().getFeedbackInput().contains("Respekt")) {

                                if (model.getObject().getFeedbackInput().contains("Respekt+1"))
                                    getSession().setAttribute("Respekt", (Integer) getSession().getAttribute("Respekt") + 1);
                                else if (model.getObject().getFeedbackInput().contains("Respekt+2"))
                                    getSession().setAttribute("Respekt", (Integer) getSession().getAttribute("Respekt") + 2);
                                else if (model.getObject().getFeedbackInput().contains("Respekt-1"))
                                    getSession().setAttribute("Respekt", (Integer) getSession().getAttribute("Respekt") - 1);
                                else
                                    getSession().setAttribute("Respekt", (Integer) getSession().getAttribute("Respekt") - 2);
                            }
                            if (model.getObject().getFeedbackInput().contains("Öppnafrågor")) {

                                if (model.getObject().getFeedbackInput().contains("Öppnafrågor+1"))
                                    getSession().setAttribute("Öppnafrågor", (Integer) getSession().getAttribute("Öppnafrågor") + 1);
                                else if (model.getObject().getFeedbackInput().contains("Öppnafrågor+2"))
                                    getSession().setAttribute("Öppnafrågor", (Integer) getSession().getAttribute("Öppnafrågor") + 2);
                                else if (model.getObject().getFeedbackInput().contains("Öppnafrågor-1"))
                                    getSession().setAttribute("Öppnafrågor", (Integer) getSession().getAttribute("Öppnafrågor") - 1);
                                else
                                    getSession().setAttribute("Öppnafrågor", (Integer) getSession().getAttribute("Öppnafrågor") - 2);

                            }

                            if (model.getObject().getFeedbackInput().contains("3F")) {

                                if (model.getObject().getFeedbackInput().contains("3F+1"))
                                    getSession().setAttribute("3F", (Integer) getSession().getAttribute("3F") + 1);
                                else if (model.getObject().getFeedbackInput().contains("3F+2"))
                                    getSession().setAttribute("3F", (Integer) getSession().getAttribute("3F") + 2);
                                else if (model.getObject().getFeedbackInput().contains("3F-1"))
                                    getSession().setAttribute("3F", (Integer) getSession().getAttribute("3F") - 1);
                                else
                                    getSession().setAttribute("3F", (Integer) getSession().getAttribute("3F") - 2);


                            }
                            if (model.getObject().getFeedbackInput().contains("Spegling")) {
                                if (model.getObject().getFeedbackInput().contains("Spegling+1"))
                                    getSession().setAttribute("Spegling", (Integer) getSession().getAttribute("Spegling") + 1);
                                else if (model.getObject().getFeedbackInput().contains("Spegling+2"))
                                    getSession().setAttribute("Spegling", (Integer) getSession().getAttribute("Spegling") + 2);
                                else if (model.getObject().getFeedbackInput().contains("Spegling-1"))
                                    getSession().setAttribute("Spegling", (Integer) getSession().getAttribute("Spegling") - 1);
                                else
                                    getSession().setAttribute("Spegling", (Integer) getSession().getAttribute("Spegling") - 2);


                            }
                            if (model.getObject().getFeedbackInput().contains("Empati")) {
                                if (model.getObject().getFeedbackInput().contains("Empati+1"))
                                    getSession().setAttribute("Empati", (Integer) getSession().getAttribute("Empati") + 1);
                                else if (model.getObject().getFeedbackInput().contains("Empati+2"))
                                    getSession().setAttribute("Empati", (Integer) getSession().getAttribute("Empati") + 2);
                                else if (model.getObject().getFeedbackInput().contains("Empati-1"))
                                    getSession().setAttribute("Empati", (Integer) getSession().getAttribute("Empati") - 1);
                                else
                                    getSession().setAttribute("Empati", (Integer) getSession().getAttribute("Empati") - 2);


                            }
                            if (model.getObject().getFeedbackInput().contains("Relevans")) {
                                if (model.getObject().getFeedbackInput().contains("Relevans+1"))
                                    getSession().setAttribute("Relevans", (Integer) getSession().getAttribute("Relevans") + 1);
                                else if (model.getObject().getFeedbackInput().contains("Relevans+2"))
                                    getSession().setAttribute("Relevans", (Integer) getSession().getAttribute("Relevans") + 2);
                                else if (model.getObject().getFeedbackInput().contains("Relevans-1"))
                                    getSession().setAttribute("Relevans", (Integer) getSession().getAttribute("Relevans") - 1);
                                else
                                    getSession().setAttribute("Relevans", (Integer) getSession().getAttribute("Relevans") - 2);


                            }
                            if (model.getObject().getFeedbackInput().contains("Tillit")) {
                                if (model.getObject().getFeedbackInput().contains("Tillit+1"))
                                    getSession().setAttribute("Tillit", (Integer) getSession().getAttribute("Tillit") + 1);
                                else if (model.getObject().getFeedbackInput().contains("Tillit+2"))
                                    getSession().setAttribute("Tillit", (Integer) getSession().getAttribute("Tillit") + 2);
                                else if (model.getObject().getFeedbackInput().contains("Tillit-1"))
                                    getSession().setAttribute("Tillit", (Integer) getSession().getAttribute("Tillit") - 1);
                                else
                                    getSession().setAttribute("Tillit", (Integer) getSession().getAttribute("Tillit") - 2);

                            }



                        }


                        // feedback logic

                        if (model.getObject().getExp_feedbackInput() != null) {

                            if (model.getObject().getExp_feedbackInput().contains("Spegling")) {

                                if (model.getObject().getExp_feedbackInput().contains("Spegling+1"))
                                    getSession().setAttribute("exSpegling", (Integer) getSession().getAttribute("exSpegling") + 1);


                                else if (model.getObject().getExp_feedbackInput().contains("Spegling+2"))
                                    getSession().setAttribute("exSpegling", (Integer) getSession().getAttribute("exSpegling") + 2);
                                else if (model.getObject().getExp_feedbackInput().contains("Spegling-1"))
                                    getSession().setAttribute("exSpegling", (Integer) getSession().getAttribute("exSpegling") - 1);
                                else
                                    getSession().setAttribute("exSpegling", (Integer) getSession().getAttribute("exSpegling") - 2);


                            }

                            if (model.getObject().getExp_feedbackInput().contains("Öppnafrågor")) {

                                if (model.getObject().getFeedbackInput().contains("Öppnafrågor+1"))
                                    getSession().setAttribute("exÖppnafrågor", (Integer) getSession().getAttribute("exÖppnafrågor") + 1);
                                else if (model.getObject().getFeedbackInput().contains("Öppnafrågor+2"))
                                    getSession().setAttribute("exÖppnafrågor", (Integer) getSession().getAttribute("exÖppnafrågor") + 2);
                                else if (model.getObject().getFeedbackInput().contains("Öppnafrågor-1"))
                                    getSession().setAttribute("exÖppnafrågor", (Integer) getSession().getAttribute("exÖppnafrågor") - 1);
                                else
                                    getSession().setAttribute("Öppnafrågor", (Integer) getSession().getAttribute("exÖppnafrågor") - 2);

                            }
                            if (model.getObject().getExp_feedbackInput().contains("Egenbedömning")) {

                                if (model.getObject().getExp_feedbackInput().contains("Egenbedömning+1"))
                                    getSession().setAttribute("exEgenbedömning", (Integer) getSession().getAttribute("exEgenbedömning") + 1);
                                else if (model.getObject().getExp_feedbackInput().contains("Egenbedömning+2"))
                                    getSession().setAttribute("exEgenbedömning", (Integer) getSession().getAttribute("exEgenbedömning") + 2);
                                else if (model.getObject().getExp_feedbackInput().contains("Egenbedömning-1"))
                                    getSession().setAttribute("exEgenbedömning", (Integer) getSession().getAttribute("exEgenbedömning") - 1);
                                else
                                    getSession().setAttribute("exEgenbedömning", (Integer) getSession().getAttribute("exEgenbedömning") - 2);


                            }

                            if (model.getObject().getExp_feedbackInput().contains("Socialt")) {

                                if (model.getObject().getExp_feedbackInput().contains("Socialt+1"))
                                    getSession().setAttribute("exSocialt", (Integer) getSession().getAttribute("exSocialt") + 1);
                                else if (model.getObject().getExp_feedbackInput().contains("Socialt+2"))
                                    getSession().setAttribute("exSocialt", (Integer) getSession().getAttribute("exSocialt") + 2);
                                else if (model.getObject().getExp_feedbackInput().contains("Socialt-1"))
                                    getSession().setAttribute("exSocialt", (Integer) getSession().getAttribute("exSocialt") - 1);
                                else
                                    getSession().setAttribute("exSocialt", (Integer) getSession().getAttribute("exSocialt") - 2);


                            }


                            if (model.getObject().getExp_feedbackInput().contains("Funktionsnivå")) {

                                if (model.getObject().getFeedbackInput().contains("Funktionsnivå+1"))
                                    getSession().setAttribute("exFunktionsnivå", (Integer) getSession().getAttribute("exFunktionsnivå") + 1);
                                else if (model.getObject().getFeedbackInput().contains("Funktionsnivå+2"))
                                    getSession().setAttribute("exFunktionsnivå", (Integer) getSession().getAttribute("exFunktionsnivå") + 2);
                                else if (model.getObject().getFeedbackInput().contains("Funktionsnivå-1"))
                                    getSession().setAttribute("exFunktionsnivå", (Integer) getSession().getAttribute("exFunktionsnivå") - 1);
                                else
                                    getSession().setAttribute("exFunktionsnivå", (Integer) getSession().getAttribute("exFunktionsnivå") - 2);

                            }



                            if (model.getObject().getExp_feedbackInput().contains("Barn")) {

                                if (model.getObject().getExp_feedbackInput().contains("Barn+1"))
                                    getSession().setAttribute("exBarn", (Integer) getSession().getAttribute("exBarn") + 1);
                                else if (model.getObject().getExp_feedbackInput().contains("Barn+2"))
                                    getSession().setAttribute("exBarn", (Integer) getSession().getAttribute("exBarn") + 2);
                                else if (model.getObject().getExp_feedbackInput().contains("Barn-1"))
                                    getSession().setAttribute("exBarn", (Integer) getSession().getAttribute("exBarn") - 1);
                                else
                                    getSession().setAttribute("exBarn", (Integer) getSession().getAttribute("exBarn") - 2);


                            }
                            if (model.getObject().getExp_feedbackInput().contains("Motivation")) {

                                if (model.getObject().getExp_feedbackInput().contains("Motivation+1"))
                                    getSession().setAttribute("exMotivation", (Integer) getSession().getAttribute("exMotivation") + 1);
                                else if (model.getObject().getExp_feedbackInput().contains("Motivation+2"))
                                    getSession().setAttribute("exMotivation", (Integer) getSession().getAttribute("exMotivation") + 2);
                                else if (model.getObject().getExp_feedbackInput().contains("Motivation-1"))
                                    getSession().setAttribute("exMotivation", (Integer) getSession().getAttribute("exMotivation") - 1);
                                else
                                    getSession().setAttribute("exMotivation", (Integer) getSession().getAttribute("exMotivation") - 2);


                            }


                        }



                    }


                };
            }


        });

    }

}