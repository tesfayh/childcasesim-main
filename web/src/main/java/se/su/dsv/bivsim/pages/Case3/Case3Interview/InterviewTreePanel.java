package se.su.dsv.bivsim.pages.Case3.Case3Interview;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.extensions.markup.html.repeater.tree.DefaultNestedTree;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import se.su.dsv.bivsim.data.Case.dao.interfaces.InterviewEntityDao;
import se.su.dsv.bivsim.data.Case.dataobjects.InterviewEntity;
import se.su.dsv.bivsim.pages.Case3.Case3Common.HomeCase3Page;

public class InterviewTreePanel extends AbstractTreePanel {
    @SpringBean
    InterviewEntityDao interviewEntityDao;


    private static final long serialVersionUID = 1L;

    public void setContent(Panel panel, AjaxRequestTarget target) {
        ((HomeCase3Page) getPage()).getContentWmc().replace(panel);
        target.add(((HomeCase3Page) getPage()).getContentWmc());
    }

    public InterviewTreePanel(String id, final Integer groupId, String type) {
        super(id);


        add(new DefaultNestedTree<InterviewEntity>("tree", new InterviewEntityProvider(interviewEntityDao, groupId, type)) {
            @Override
            public Component newContentComponent(String id, final IModel<InterviewEntity> model) {
                if (getProvider().hasChildren(model.getObject()))

                    return new InterviewFolder(id, this, model) {

                        @Override
                        public void clicked(AjaxRequestTarget target) {

                            ContentPanel panel;
                            if (model.getObject().getClipId() != null && !model.getObject().getClipId().contains("pic")) {
                                panel = new VideoPanel("content", model.getObject().getPatientAnswer(), model.getObject().getClipId());
                                getSession().setAttribute("Antalfrågor", (Integer) getSession().getAttribute("Antalfrågor") + 1);

                                //  getSession().setAttribute("Number_of_questions_asked", (Integer) getSession().getAttribute("Number_of_questions_asked") + 1);
                                getSession().setAttribute("Interview", getSession().getAttribute("Interview") + "Q:" + model.getObject().getName() + "--Ans:" + model.getObject().getPatientAnswer() + "#");

                            } else if (model.getObject().getClipId() != null && model.getObject().getPatientAnswer() != null && model.getObject().getClipId().contains("pic"))
                                panel = new InterviewPicturePanel("content", model.getObject().getPatientAnswer(), model.getObject().getClipId());

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


                                if (model.getObject().getFeedbackInput().contains("Funktionsnivå")) {

                                    if (model.getObject().getFeedbackInput().contains("Funktionsnivå+1"))
                                        getSession().setAttribute("Funktionsnivå", (Integer) getSession().getAttribute("Funktionsnivå") + 1);
                                    else if (model.getObject().getFeedbackInput().contains("Funktionsnivå+2"))
                                        getSession().setAttribute("Funktionsnivå", (Integer) getSession().getAttribute("Funktionsnivå") + 2);
                                    else if (model.getObject().getFeedbackInput().contains("Funktionsnivå-1"))
                                        getSession().setAttribute("Funktionsnivå", (Integer) getSession().getAttribute("Funktionsnivå") - 1);
                                    else
                                        getSession().setAttribute("Funktionsnivå", (Integer) getSession().getAttribute("Funktionsnivå") - 2);

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

                                if (model.getObject().getFeedbackInput().contains("Egenbedömning")) {
                                    getSession().setAttribute("Egenbedömning", (Integer) getSession().getAttribute("Egenbedömning") + 1);

                                }
                                if (model.getObject().getFeedbackInput().contains("Socialt")) {
                                    if (model.getObject().getFeedbackInput().contains("Socialt+1"))
                                        getSession().setAttribute("Socialt", (Integer) getSession().getAttribute("Tillit") + 1);
                                    else if (model.getObject().getFeedbackInput().contains("Socialt+2"))
                                        getSession().setAttribute("Socialt", (Integer) getSession().getAttribute("Socialt") + 2);
                                    else if (model.getObject().getFeedbackInput().contains("Socialt-1"))
                                        getSession().setAttribute("Socialt", (Integer) getSession().getAttribute("Socialt") - 1);
                                    else
                                        getSession().setAttribute("Socialt", (Integer) getSession().getAttribute("Socialt") - 2);


                                }
                                if (model.getObject().getFeedbackInput().contains("Barn")) {
                                    if (model.getObject().getFeedbackInput().contains("Barn+1"))
                                        getSession().setAttribute("Barn", (Integer) getSession().getAttribute("Barn") + 1);
                                    else if (model.getObject().getFeedbackInput().contains("Barn+2"))
                                        getSession().setAttribute("Barn", (Integer) getSession().getAttribute("Barn") + 2);
                                    else if (model.getObject().getFeedbackInput().contains("Barn-1"))
                                        getSession().setAttribute("Barn", (Integer) getSession().getAttribute("Barn") - 1);
                                    else
                                        getSession().setAttribute("Barn", (Integer) getSession().getAttribute("Barn") - 2);


                                }
                                if (model.getObject().getFeedbackInput().contains("Motivation")) {
                                    if (model.getObject().getFeedbackInput().contains("Motivation+1"))
                                        getSession().setAttribute("Motivation", (Integer) getSession().getAttribute("Motivation") + 1);
                                    else if (model.getObject().getFeedbackInput().contains("Motivation+2"))
                                        getSession().setAttribute("Motivation", (Integer) getSession().getAttribute("Motivation") + 2);
                                    else if (model.getObject().getFeedbackInput().contains("Motivation-1"))
                                        getSession().setAttribute("Motivation", (Integer) getSession().getAttribute("Motivation") - 1);
                                    else
                                        getSession().setAttribute("Motivation", (Integer) getSession().getAttribute("Motivation") - 2);


                                }
                            }


                            // feedback logic

                            if (model.getObject().getExp_feedbackInput() != null) {
                                if (model.getObject().getExp_feedbackInput().contains("Öppningsfras")) {
                                    if (model.getObject().getExp_feedbackInput().contains("Öppningsfras+1"))
                                        getSession().setAttribute("exÖppningsfras", (Integer) getSession().getAttribute("exÖppningsfras") + 1);
                                    else if (model.getObject().getExp_feedbackInput().contains("Öppningsfras+2"))
                                        getSession().setAttribute("exÖppningsfras", (Integer) getSession().getAttribute("exÖppningsfras") + 2);
                                    else if (model.getObject().getExp_feedbackInput().contains("Öppningsfras-1"))
                                        getSession().setAttribute("exÖppningsfras", (Integer) getSession().getAttribute("exÖppningsfras") - 1);
                                    else
                                        getSession().setAttribute("exÖppningsfras", (Integer) getSession().getAttribute("exÖppningsfras") - 2);


                                }
                                if (model.getObject().getExp_feedbackInput().contains("Respekt")) {
                                    if (model.getObject().getExp_feedbackInput().contains("Respekt+1"))
                                        getSession().setAttribute("exRespekt", (Integer) getSession().getAttribute("exRespekt") + 1);
                                    else if (model.getObject().getExp_feedbackInput().contains("Respekt+2"))
                                        getSession().setAttribute("exRespekt", (Integer) getSession().getAttribute("exRespekt") + 2);
                                    else if (model.getObject().getExp_feedbackInput().contains("Respekt-1"))
                                        getSession().setAttribute("exRespekt", (Integer) getSession().getAttribute("exRespekt") - 1);
                                    else
                                        getSession().setAttribute("exRespekt", (Integer) getSession().getAttribute("exRespekt") - 2);


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

                                if (model.getObject().getExp_feedbackInput().contains("3F")) {

                                    if (model.getObject().getExp_feedbackInput().contains("3F+1"))
                                        getSession().setAttribute("ex3F", (Integer) getSession().getAttribute("ex3F") + 1);
                                    else if (model.getObject().getExp_feedbackInput().contains("3F+2"))
                                        getSession().setAttribute("ex3F", (Integer) getSession().getAttribute("ex3F") + 2);
                                    else if (model.getObject().getExp_feedbackInput().contains("3F-1"))
                                        getSession().setAttribute("ex3F", (Integer) getSession().getAttribute("ex3F") - 1);
                                    else
                                        getSession().setAttribute("ex3F", (Integer) getSession().getAttribute("ex3F") - 2);


                                }
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
                                if (model.getObject().getExp_feedbackInput().contains("Empati")) {

                                    if (model.getObject().getExp_feedbackInput().contains("Empati+1"))
                                        getSession().setAttribute("exEmpati", (Integer) getSession().getAttribute("exEmpati") + 1);
                                    else if (model.getObject().getExp_feedbackInput().contains("Empati+2"))
                                        getSession().setAttribute("exEmpati", (Integer) getSession().getAttribute("exEmpati") + 2);
                                    else if (model.getObject().getExp_feedbackInput().contains("Empati-1"))
                                        getSession().setAttribute("exEmpati", (Integer) getSession().getAttribute("exEmpati") - 1);
                                    else
                                        getSession().setAttribute("exEmpati", (Integer) getSession().getAttribute("exEmpati") - 2);


                                }
                                if (model.getObject().getExp_feedbackInput().contains("Relevans")) {

                                    if (model.getObject().getExp_feedbackInput().contains("Relevans+1"))
                                        getSession().setAttribute("exRelevans", (Integer) getSession().getAttribute("exRelevans") + 1);
                                    else if (model.getObject().getExp_feedbackInput().contains("Relevans+2"))
                                        getSession().setAttribute("exRelevans", (Integer) getSession().getAttribute("exRelevans") + 2);
                                    else if (model.getObject().getExp_feedbackInput().contains("Relevans-1"))
                                        getSession().setAttribute("exRelevans", (Integer) getSession().getAttribute("exRelevans") - 1);
                                    else
                                        getSession().setAttribute("exRelevans", (Integer) getSession().getAttribute("exRelevans") - 2);


                                }
                                if (model.getObject().getExp_feedbackInput().contains("Tillit")) {

                                    if (model.getObject().getExp_feedbackInput().contains("Tillit+1"))
                                        getSession().setAttribute("exTillit", (Integer) getSession().getAttribute("exTillit") + 1);
                                    else if (model.getObject().getExp_feedbackInput().contains("Tillit+2"))
                                        getSession().setAttribute("exTillit", (Integer) getSession().getAttribute("exTillit") + 2);
                                    else if (model.getObject().getExp_feedbackInput().contains("Tillit-1"))
                                        getSession().setAttribute("exTillit", (Integer) getSession().getAttribute("exTillit") - 1);
                                    else
                                        getSession().setAttribute("exTillit", (Integer) getSession().getAttribute("exTillit") - 2);


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

                            if (model.getObject().getTrustValue() != null) {
                                getSession().setAttribute("trustValue", (Integer) getSession().getAttribute("trustValue") + model.getObject().getTrustValue());
                                if (model.getObject().getTrustValue() < 0)

                                    getSession().setAttribute("negativeTrustValue", (Integer) getSession().getAttribute("negativeTrustValue") + model.getObject().getTrustValue());
                                else if (model.getObject().getTrustValue() > 0)
                                    getSession().setAttribute("positiveTrustValue", (Integer) getSession().getAttribute("positiveTrustValue") + model.getObject().getTrustValue());

                            }


                        }

                    };
                return new SimplePanel(id, model) {
                    @Override
                    public void clicked(AjaxRequestTarget target) {

                        ContentPanel panel;
                        if (model.getObject().getClipId() != null && !model.getObject().getClipId().contains("pic")) {
                            panel = new VideoPanel("content", model.getObject().getPatientAnswer(), model.getObject().getClipId());
                            getSession().setAttribute("Antalfrågor", (Integer) getSession().getAttribute("Antalfrågor") + 1);
                            //getSession().setAttribute("Number_of_questions_asked", (Integer) getSession().getAttribute("Number_of_questions_asked") + 1);

                            getSession().setAttribute("Sub_questions", (Integer) getSession().getAttribute("Sub_questions") + 1);
                            getSession().setAttribute("Interview", getSession().getAttribute("Interview") + "Q:" + model.getObject().getName() + "--Ans:" + model.getObject().getPatientAnswer() + "#");

                        } else if (model.getObject().getClipId() != null && model.getObject().getPatientAnswer() != null && model.getObject().getClipId().contains("pic"))
                            //panel = new ContentPanel("content", "Please select a Question!");
                            panel = new InterviewPicturePanel("content", model.getObject().getPatientAnswer(), model.getObject().getClipId());
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


                            if (model.getObject().getFeedbackInput().contains("Funktionsnivå")) {

                                if (model.getObject().getFeedbackInput().contains("Funktionsnivå+1"))
                                    getSession().setAttribute("Funktionsnivå", (Integer) getSession().getAttribute("Funktionsnivå") + 1);
                                else if (model.getObject().getFeedbackInput().contains("Funktionsnivå+2"))
                                    getSession().setAttribute("Funktionsnivå", (Integer) getSession().getAttribute("Funktionsnivå") + 2);
                                else if (model.getObject().getFeedbackInput().contains("Funktionsnivå-1"))
                                    getSession().setAttribute("Funktionsnivå", (Integer) getSession().getAttribute("Funktionsnivå") - 1);
                                else
                                    getSession().setAttribute("Funktionsnivå", (Integer) getSession().getAttribute("Funktionsnivå") - 2);

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

                            if (model.getObject().getFeedbackInput().contains("Egenbedömning")) {
                                getSession().setAttribute("Egenbedömning", (Integer) getSession().getAttribute("Egenbedömning") + 1);

                            }
                            if (model.getObject().getFeedbackInput().contains("Socialt")) {
                                if (model.getObject().getFeedbackInput().contains("Socialt+1"))
                                    getSession().setAttribute("Socialt", (Integer) getSession().getAttribute("Tillit") + 1);
                                else if (model.getObject().getFeedbackInput().contains("Socialt+2"))
                                    getSession().setAttribute("Socialt", (Integer) getSession().getAttribute("Socialt") + 2);
                                else if (model.getObject().getFeedbackInput().contains("Socialt-1"))
                                    getSession().setAttribute("Socialt", (Integer) getSession().getAttribute("Socialt") - 1);
                                else
                                    getSession().setAttribute("Socialt", (Integer) getSession().getAttribute("Socialt") - 2);


                            }
                            if (model.getObject().getFeedbackInput().contains("Barn")) {
                                if (model.getObject().getFeedbackInput().contains("Barn+1"))
                                    getSession().setAttribute("Barn", (Integer) getSession().getAttribute("Barn") + 1);
                                else if (model.getObject().getFeedbackInput().contains("Barn+2"))
                                    getSession().setAttribute("Barn", (Integer) getSession().getAttribute("Barn") + 2);
                                else if (model.getObject().getFeedbackInput().contains("Barn-1"))
                                    getSession().setAttribute("Barn", (Integer) getSession().getAttribute("Barn") - 1);
                                else
                                    getSession().setAttribute("Barn", (Integer) getSession().getAttribute("Barn") - 2);


                            }
                            if (model.getObject().getFeedbackInput().contains("Motivation")) {
                                if (model.getObject().getFeedbackInput().contains("Motivation+1"))
                                    getSession().setAttribute("Motivation", (Integer) getSession().getAttribute("Motivation") + 1);
                                else if (model.getObject().getFeedbackInput().contains("Motivation+2"))
                                    getSession().setAttribute("Motivation", (Integer) getSession().getAttribute("Motivation") + 2);
                                else if (model.getObject().getFeedbackInput().contains("Motivation-1"))
                                    getSession().setAttribute("Motivation", (Integer) getSession().getAttribute("Motivation") - 1);
                                else
                                    getSession().setAttribute("Motivation", (Integer) getSession().getAttribute("Motivation") - 2);


                            }
                        }


                        // feedback logic

                        if (model.getObject().getExp_feedbackInput() != null) {
                            if (model.getObject().getExp_feedbackInput().contains("Öppningsfras")) {
                                if (model.getObject().getExp_feedbackInput().contains("Öppningsfras+1"))
                                    getSession().setAttribute("exÖppningsfras", (Integer) getSession().getAttribute("exÖppningsfras") + 1);
                                else if (model.getObject().getExp_feedbackInput().contains("Öppningsfras+2"))
                                    getSession().setAttribute("exÖppningsfras", (Integer) getSession().getAttribute("exÖppningsfras") + 2);
                                else if (model.getObject().getExp_feedbackInput().contains("Öppningsfras-1"))
                                    getSession().setAttribute("exÖppningsfras", (Integer) getSession().getAttribute("exÖppningsfras") - 1);
                                else
                                    getSession().setAttribute("exÖppningsfras", (Integer) getSession().getAttribute("exÖppningsfras") - 2);


                            }
                            if (model.getObject().getExp_feedbackInput().contains("Respekt")) {
                                if (model.getObject().getExp_feedbackInput().contains("Respekt+1"))
                                    getSession().setAttribute("exRespekt", (Integer) getSession().getAttribute("exRespekt") + 1);
                                else if (model.getObject().getExp_feedbackInput().contains("Respekt+2"))
                                    getSession().setAttribute("exRespekt", (Integer) getSession().getAttribute("exRespekt") + 2);
                                else if (model.getObject().getExp_feedbackInput().contains("Respekt-1"))
                                    getSession().setAttribute("exRespekt", (Integer) getSession().getAttribute("exRespekt") - 1);
                                else
                                    getSession().setAttribute("exRespekt", (Integer) getSession().getAttribute("exRespekt") - 2);


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

                            if (model.getObject().getExp_feedbackInput().contains("3F")) {

                                if (model.getObject().getExp_feedbackInput().contains("3F+1"))
                                    getSession().setAttribute("ex3F", (Integer) getSession().getAttribute("ex3F") + 1);
                                else if (model.getObject().getExp_feedbackInput().contains("3F+2"))
                                    getSession().setAttribute("ex3F", (Integer) getSession().getAttribute("ex3F") + 2);
                                else if (model.getObject().getExp_feedbackInput().contains("3F-1"))
                                    getSession().setAttribute("ex3F", (Integer) getSession().getAttribute("ex3F") - 1);
                                else
                                    getSession().setAttribute("ex3F", (Integer) getSession().getAttribute("ex3F") - 2);


                            }
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
                            if (model.getObject().getExp_feedbackInput().contains("Empati")) {

                                if (model.getObject().getExp_feedbackInput().contains("Empati+1"))
                                    getSession().setAttribute("exEmpati", (Integer) getSession().getAttribute("exEmpati") + 1);
                                else if (model.getObject().getExp_feedbackInput().contains("Empati+2"))
                                    getSession().setAttribute("exEmpati", (Integer) getSession().getAttribute("exEmpati") + 2);
                                else if (model.getObject().getExp_feedbackInput().contains("Empati-1"))
                                    getSession().setAttribute("exEmpati", (Integer) getSession().getAttribute("exEmpati") - 1);
                                else
                                    getSession().setAttribute("exEmpati", (Integer) getSession().getAttribute("exEmpati") - 2);


                            }
                            if (model.getObject().getExp_feedbackInput().contains("Relevans")) {

                                if (model.getObject().getExp_feedbackInput().contains("Relevans+1"))
                                    getSession().setAttribute("exRelevans", (Integer) getSession().getAttribute("exRelevans") + 1);
                                else if (model.getObject().getExp_feedbackInput().contains("Relevans+2"))
                                    getSession().setAttribute("exRelevans", (Integer) getSession().getAttribute("exRelevans") + 2);
                                else if (model.getObject().getExp_feedbackInput().contains("Relevans-1"))
                                    getSession().setAttribute("exRelevans", (Integer) getSession().getAttribute("exRelevans") - 1);
                                else
                                    getSession().setAttribute("exRelevans", (Integer) getSession().getAttribute("exRelevans") - 2);


                            }
                            if (model.getObject().getExp_feedbackInput().contains("Tillit")) {

                                if (model.getObject().getExp_feedbackInput().contains("Tillit+1"))
                                    getSession().setAttribute("exTillit", (Integer) getSession().getAttribute("exTillit") + 1);
                                else if (model.getObject().getExp_feedbackInput().contains("Tillit+2"))
                                    getSession().setAttribute("exTillit", (Integer) getSession().getAttribute("exTillit") + 2);
                                else if (model.getObject().getExp_feedbackInput().contains("Tillit-1"))
                                    getSession().setAttribute("exTillit", (Integer) getSession().getAttribute("exTillit") - 1);
                                else
                                    getSession().setAttribute("exTillit", (Integer) getSession().getAttribute("exTillit") - 2);


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

                        if (model.getObject().getTrustValue() != null) {
                            getSession().setAttribute("trustValue", (Integer) getSession().getAttribute("trustValue") + model.getObject().getTrustValue());
                            if (model.getObject().getTrustValue() < 0)

                                getSession().setAttribute("negativeTrustValue", (Integer) getSession().getAttribute("negativeTrustValue") + model.getObject().getTrustValue());
                            else if (model.getObject().getTrustValue() > 0)
                                getSession().setAttribute("positiveTrustValue", (Integer) getSession().getAttribute("positiveTrustValue") + model.getObject().getTrustValue());

                        }


                    }


                };

            }


        });

    }

}