package se.su.dsv.bivsim.data.Case.dataobjects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@Table(name = "feedback", schema = "", catalog = "bivsim")
@Entity
public class FeedbackEntity extends DomainObject implements Serializable {

    @Column(name = "feedback_ID")
    @Id
    public long feedbackId;
    @Column(name = "feedback_Value1")
    public String feedbackValue1;

    @Column(name = "patient_Feedback")
    public String patientFeedback;


    @Column(name = "clip_ID")
    public String clipId;

    @Column(name = "person")
    public String person;

    @Column(name = "groupId")
    public Integer groupId;


    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getClipId() {
        return clipId;

    }

    public void setClipID(String clipID) {
        this.clipId = clipID;
    }

    public long getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(int feedbackId) {
        this.feedbackId = feedbackId;
    }


    public String getFeedbackValue1() {
        return feedbackValue1;
    }

    public void setFeedbackValue1(String feedbackValue1) {
        this.feedbackValue1 = feedbackValue1;
    }


    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }


    public String getPatientFeedback() {
        return patientFeedback;
    }

    public void setPatientFeedback(String patientFeedback) {
        this.patientFeedback = patientFeedback;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FeedbackEntity that = (FeedbackEntity) o;

        if (feedbackId != that.feedbackId) return false;
        if (feedbackValue1 != null ? !feedbackValue1.equals(that.feedbackValue1) : that.feedbackValue1 != null)

        if (patientFeedback != null ? !patientFeedback.equals(that.patientFeedback) : that.patientFeedback != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) feedbackId;
        result = 31 * result + (feedbackValue1 != null ? feedbackValue1.hashCode() : 0);
        result = 31 * result + (patientFeedback != null ? patientFeedback.hashCode() : 0);

        return result;
    }
}