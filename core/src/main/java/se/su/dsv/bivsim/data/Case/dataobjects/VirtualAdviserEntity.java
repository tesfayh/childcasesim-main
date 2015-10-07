package se.su.dsv.bivsim.data.Case.dataobjects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "virtual_Advisor", schema = "", catalog = "bivsim")
@Entity
public class VirtualAdviserEntity extends DomainObject implements Serializable {

    @Column(name = "feedback_ID")
    @Id
    private long feedbackId;

    @Column(name = "feedback_Value")
    private Integer feedbackValue;

    @Column(name = "feedback_group")
    private String feedbackGroup;

    @Column(name = "Feedback_detail")
    private String feedbackDetail;

    @Column(name = "groupId")
    public Integer groupId;

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public long getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(long feedbackId) {
        this.feedbackId = feedbackId;
    }


    public Integer getFeedbackValue() {
        return feedbackValue;
    }

    public void setFeedbackValue(Integer feedbackValue) {
        this.feedbackValue = feedbackValue;
    }


    public String getFeedbackGroup() {
        return feedbackGroup;
    }

    public void setFeedbackGroup(String feedbackGroup) {
        this.feedbackGroup = feedbackGroup;
    }


    public String getFeedbackDetail() {
        return feedbackDetail;
    }

    public void setFeedbackDetail(String feedbackDetail) {
        this.feedbackDetail = feedbackDetail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VirtualAdviserEntity that = (VirtualAdviserEntity) o;

        if (feedbackId != that.feedbackId) return false;
        if (feedbackDetail != null ? !feedbackDetail.equals(that.feedbackDetail) : that.feedbackDetail != null)
            return false;
        if (feedbackGroup != null ? !feedbackGroup.equals(that.feedbackGroup) : that.feedbackGroup != null)
            return false;
        if (feedbackValue != null ? !feedbackValue.equals(that.feedbackValue) : that.feedbackValue != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) feedbackId;
        result = 31 * result + (feedbackValue != null ? feedbackValue.hashCode() : 0);
        result = 31 * result + (feedbackGroup != null ? feedbackGroup.hashCode() : 0);
        result = 31 * result + (feedbackDetail != null ? feedbackDetail.hashCode() : 0);
        return result;
    }

}
