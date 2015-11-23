package se.su.dsv.bivsim.pages.CommonAllCases.feedbacksection;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.EmptyPanel;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.request.resource.ResourceReference;
import org.apache.wicket.spring.injection.annot.SpringBean;
import se.su.dsv.bivsim.data.Case.dao.interfaces.FeedbackEntityDao;
import se.su.dsv.bivsim.data.Case.dataobjects.FeedbackEntity;
import se.su.dsv.bivsim.pages.CommonAllCases.General.VideoFeedbackPanel;

import java.util.List;

/**
 * Created by kib on 2/14/15.
 */
public class ParentVirtualPatientPanel extends Panel {


    @SpringBean
    FeedbackEntityDao feedbackEntityDao;
    String[] feedbackarray = new String[40];
    String feedback_video[] = new String[40];
    String[] feedback_selected = new String[40];
    String[] video_selected = new String[40];
    int i = 0;
    int j = 0;
    int k = 0;
    int y = 0;
    int l = 0;
    int x = 0;
    int rows;

    public ParentVirtualPatientPanel(String id, Integer groupId, final ResourceReference videoResourceReference) {
        super(id);


        int totalTrustValue = 0;
        totalTrustValue =
                (Integer)getSession().getAttribute("Öppningsfras") +
                        (Integer) getSession().getAttribute("Respekt")+
                        (Integer) getSession().getAttribute("Öppnafrågor") +
                        (Integer) getSession().getAttribute("Spegling") +
                        (Integer) getSession().getAttribute("3F") +
                        (Integer) getSession().getAttribute("Empati") +
                        (Integer) getSession().getAttribute("Relevans") +
                        (Integer) getSession().getAttribute("Tillit") +
                        (Integer) getSession().getAttribute("Relevans");


        List<FeedbackEntity> feedbackEntityList = feedbackEntityDao.findAllByGroupId(groupId);

        for (FeedbackEntity Entitylist : feedbackEntityList) {
            feedbackarray[i] = Entitylist.getPatientFeedback();
            i++;
            feedback_video[y] = Entitylist.getClipId();
            y++;
        }
        if (totalTrustValue > 0) {
            feedback_selected[j++] = "Negative Jag upplevde mötet med dig som positivt";
            video_selected[l++] = "AFbk20";
        } else if (totalTrustValue == 0) {
            feedback_selected[j++] = "Negative Jag upplevde mötet med dig som ganska bra";
            video_selected[l++] = "AFbk21";
        } else {
            feedback_selected[j++] ="Negative Mötet med dig kändes inte alls bra";;
            video_selected[l++] = "AFbk22";;
        }


        if ((Integer) getSession().getAttribute("Öppningsfras") != null) {
            if ((Integer) getSession().getAttribute("Öppningsfras") >= 2) {
                feedback_selected[j++] = feedbackarray[0];
                video_selected[l++] = feedback_video[0];
            }
        }
        if ((Integer) getSession().getAttribute("Öppningsfras") != null) {
            if ((Integer) getSession().getAttribute("Öppningsfras") <= -2) {
                feedback_selected[j++] = feedbackarray[9];
                video_selected[l++] = feedback_video[9];
            }
        }

        if ((Integer) getSession().getAttribute("Respekt") != null) {
            if ((Integer) getSession().getAttribute("Respekt") >= 7) {
                feedback_selected[j++] = feedbackarray[1];
                video_selected[l++] = feedback_video[1];
            }

        }
        if ((Integer) getSession().getAttribute("Respekt") != null) {
            if ((Integer) getSession().getAttribute("Respekt") < -7) {
                feedback_selected[j++] = feedbackarray[10];
                video_selected[l++] = feedback_video[10];
            }
        }
        if ((Integer) getSession().getAttribute("Öppnafrågor") != null) {
            if ((Integer) getSession().getAttribute("Öppnafrågor") >= 3) {
                feedback_selected[j++] = feedbackarray[2];
                video_selected[l++] = feedback_video[2];
            }

        }
        if ((Integer) getSession().getAttribute("Öppnafrågor") != null) {
            if ((Integer) getSession().getAttribute("Öppnafrågor") < 3) {
                feedback_selected[j++] = feedbackarray[11];
                video_selected[l++] = feedback_video[11];
            }
        }


        if ((Integer) getSession().getAttribute("3F") != null) {
            if ((Integer) getSession().getAttribute("3F") >= 7) {
                feedback_selected[j++] = feedbackarray[3];
                video_selected[l++] = feedback_video[3];
            }
        }
        if ((Integer) getSession().getAttribute("3F") != null) {
            if ((Integer) getSession().getAttribute("3F") <7) {
                feedback_selected[j++] = feedbackarray[12];
                video_selected[l++] = feedback_video[12];
                System.out.println("This is should be printed");
            }
        }


        if ((Integer) getSession().getAttribute("Spegling") != null) {
            if ((Integer) getSession().getAttribute("Spegling") >= 4) {
                feedback_selected[j++] = feedbackarray[4];
                video_selected[l++] = feedback_video[4];
            }
        }
        if ((Integer) getSession().getAttribute("Spegling") != null) {
            if ((Integer) getSession().getAttribute("Spegling") <3) {
                feedback_selected[j++] = feedbackarray[13];
                video_selected[l++] = feedback_video[13];
            }
        }

        if ((Integer) (Integer) getSession().getAttribute("Empati") != null) {
            if ((Integer) getSession().getAttribute("Empati") >= - 9) {
                feedback_selected[j++] = feedbackarray[5];
                video_selected[l++] = feedback_video[5];
            }
        }
        if ((Integer) getSession().getAttribute("Empati") != null) {
            if ((Integer) getSession().getAttribute("Empati") < -9 ) {
                feedback_selected[j++] = feedbackarray[14];
                video_selected[l++] = feedback_video[14];
            }
        }


        if ((Integer) getSession().getAttribute("Relevans") != null) {
            if ((Integer) getSession().getAttribute("Relevans") >= -2) {
                feedback_selected[j++] = feedbackarray[6];
                video_selected[l++] = feedback_video[6];
            }
        }
        if ((Integer) getSession().getAttribute("Relevans") != null) {
            if ((Integer) getSession().getAttribute("Relevans")< -3) {
                feedback_selected[j++] = feedbackarray[15];
                video_selected[l++] = feedback_video[15];
            }
        }


        if ((Integer) getSession().getAttribute("Tillit") != null) {
            if ((Integer) getSession().getAttribute("Tillit") >= 0) {
                feedback_selected[j++] = feedbackarray[7];
                video_selected[l++] = feedback_video[7];
            }
        }
        if ((Integer) getSession().getAttribute("Tillit") != null) {
            if ((Integer) getSession().getAttribute("Tillit") <  0) {
                feedback_selected[j++] = feedbackarray[16];
                video_selected[l++] = feedback_video[16];
            }
        }

        if ((Integer) getSession().getAttribute("Antalfrågor") != null) {
            if ((Integer) getSession().getAttribute("Antalfrågor") <= 45) {
                feedback_selected[j++] = feedbackarray[8];
                video_selected[l++] = feedback_video[8];
            }
        }
        if ((Integer) getSession().getAttribute("Antalfrågor") != null) {
            if ((Integer) getSession().getAttribute("Antalfrågor") > 45) {
                feedback_selected[j++] = feedbackarray[17];
                video_selected[l++] = feedback_video[17];
            }
        }



        final WebMarkupContainer wmc = new WebMarkupContainer("wmc");
        wmc.setOutputMarkupId(true);
        add(wmc);
        final WebMarkupContainer wmc2 = new WebMarkupContainer("wmc2");
        wmc2.setOutputMarkupId(true);
        add(wmc2);


        if (feedback_selected[k] != null && feedback_selected[k + 1] != null) {

            wmc.add(new Label("test", ""));

            wmc2.add(new VideoFeedbackPanel("content", "", video_selected[k + 1], videoResourceReference));

        } else {
            wmc.add(new Label("test", "INGEN feedback, eftersom du inte har gjort intervjun sektionen"));
            wmc2.add(new EmptyPanel("content"));
        }
        int count = 0;
        for (int c = 0; c < 40; c++)
            if (feedback_selected[c] != null) {
                count++;

            }


       /* if (feedback_selected[k] != null && feedback_selected[k + 1] != null) */
        if (feedback_selected[k] != null && feedback_selected[k + 1] != null) {
            Link link = new AjaxFallbackLink("linkNext") {
                @Override
                public void onClick(AjaxRequestTarget target) {
                    if (feedback_selected[k] != null && feedback_selected[k + 1] != null) {
                        /*wmc.replace(new Label("test", feedback_selected[k + 1]));
                        k++;*/
                        wmc2.replace(new VideoFeedbackPanel("content","", video_selected[k + 1], videoResourceReference));
                        k++;
                        target.add(wmc);
                        target.add(wmc2);
                    }

                }

            };
            wmc.add(link);
            wmc2.add(link);
            add(link);


            final Link linkback = new AjaxFallbackLink("linkback") {
                @Override
                public void onClick(AjaxRequestTarget target) {
                    /*if (k > 0) {
                        wmc.replace(new Label("test", feedback_selected[--k]));
                        target.add(wmc);
                    }*/

                    if (k > 0) {
                        wmc2.replace(new VideoFeedbackPanel("content","", video_selected[--k], videoResourceReference));

                        target.add(wmc2);
                    }

                }
            };
            add(linkback);
        } else {
            add(new EmptyPanel("linkNext"));
            add(new EmptyPanel("linkback"));
        }


        /*final Link tillbaka = new AjaxFallbackLink("tillbaka") {
            @Override
            public void onClick(AjaxRequestTarget target) {

*//*
                setResponsePage(CategoryInterviewFeedbakPanel.class);
*//*
            }
        };
        add(tillbaka);*/


    }
}