package se.su.dsv.bivsim.pages.Case3.Case3feedbacksection;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.EmptyPanel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import se.su.dsv.bivsim.data.Case.dao.interfaces.FeedbackEntityDao;
import se.su.dsv.bivsim.data.Case.dataobjects.FeedbackEntity;
import se.su.dsv.bivsim.pages.Case3.Case3feedbacksection.BaseClasses.BaseFeedbackPageCase3;

import java.util.List;

/**
 * Created by kib on 2/14/15.
 */
public class VirtualPatientFeedBackPage extends BaseFeedbackPageCase3 {

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

    public VirtualPatientFeedBackPage() {

        List<FeedbackEntity> feedbackEntityList = feedbackEntityDao.findAllByGroupId(3);

        for (FeedbackEntity Entitylist : feedbackEntityList) {
            feedbackarray[i] = Entitylist.getPatientFeedback();
            i++;
            feedback_video[y] = Entitylist.getClipId();
            y++;
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
            if ((Integer) getSession().getAttribute("Respekt") >= -3) {
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
            if ((Integer) getSession().getAttribute("3F") > 7) {
                feedback_selected[j++] = feedbackarray[3];
                video_selected[l++] = feedback_video[3];
            }
        }
        if ((Integer) getSession().getAttribute("3F") != null) {
            if ((Integer) getSession().getAttribute("3F") < 2) {
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
            if ((Integer) getSession().getAttribute("Spegling") < 3) {
                feedback_selected[j++] = feedbackarray[13];
                video_selected[l++] = feedback_video[13];
            }
        }

        if ((Integer) (Integer) getSession().getAttribute("Empati") != null) {
            if ((Integer) getSession().getAttribute("Empati") >= -9) {
                feedback_selected[j++] = feedbackarray[5];
                video_selected[l++] = feedback_video[5];
            }
        }
        if ((Integer) getSession().getAttribute("Empati") != null) {
            if ((Integer) getSession().getAttribute("Empati") < -9) {
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
            if ((Integer) getSession().getAttribute("Relevans") < -3) {
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
            if ((Integer) getSession().getAttribute("Tillit") < 0) {
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

            wmc2.add(new VideoPanel("video", video_selected[0]));
        } else {
            wmc.add(new Label("test", "INGEN feedback, eftersom du inte har gjort intervjun sektionen"));
            wmc2.add(new EmptyPanel("video"));
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
                        wmc2.replace(new VideoPanel("video", video_selected[k + 1]));
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
                        wmc2.replace(new VideoPanel("video", video_selected[--k]));
                        target.add(wmc2);
                    }

                }
            };
            add(linkback);
        } else {
            add(new EmptyPanel("linkNext"));
            add(new EmptyPanel("linkback"));
        }


        final Link tillbaka = new AjaxFallbackLink("tillbaka") {
            @Override
            public void onClick(AjaxRequestTarget target) {

                setResponsePage(CategoryInterviewFeedbakPage.class);
            }
        };
        add(tillbaka);


    }
}