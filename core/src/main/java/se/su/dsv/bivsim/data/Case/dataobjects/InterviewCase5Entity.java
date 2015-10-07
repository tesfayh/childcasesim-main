package se.su.dsv.bivsim.data.Case.dataobjects;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: kebede
 * Date: 03/09/13
 * Time: 10:48
 * To change this template use File | Settings | File Templates.
 */
@Table(name = "InterviewCase5", schema = "", catalog = "bivsim")
@Entity
public class InterviewCase5Entity extends DomainObject implements Serializable {

    public InterviewCase5Entity() {

    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "interview_ID")
    @Id
    private Long id;

    @Column(name = "trust_value")
    private Integer trustValue;


    @Column(name = "required")
    private Boolean required;

    @Column(name = "feedback_Input")
    private String feedbackInput;

    @Column(name = "clip_ID")
    private String clipId;

    @ManyToOne
    @JoinColumn(name = "parent_ID")
    private InterviewCase5Entity parent;

    @OneToMany(mappedBy = "parent", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private List<InterviewCase5Entity> interviews = new ArrayList<InterviewCase5Entity>();

    @Column(name = "Name")
    public String name;

    @Column(name = "Patient_Answer")
    private String patientAnswer;

    @Column(name = "groupId")
    public Integer groupId;

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getPatientAnswer() {
        return patientAnswer;
    }

    public void setPatientAnswer(String patientAnswer) {
        this.patientAnswer = patientAnswer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Integer getTrustValue() {
        return trustValue;
    }

    public void setTrustValue(Integer trustValue) {
        this.trustValue = trustValue;
    }


    public Boolean getRequired() {
        return required;
    }

    public void setRequired(Boolean required) {
        this.required = required;
    }


    public String getFeedbackInput() {
        return feedbackInput;
    }

    public void setFeedbackInput(String feedbackInput) {
        this.feedbackInput = feedbackInput;
    }


    public String getClipId() {
        return clipId;
    }

    public void setClipId(String clipId) {
        this.clipId = clipId;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public InterviewCase5Entity getParent() {
        return parent;
    }

    public void setParent(InterviewCase5Entity parent) {
        this.parent = parent;
        // parent.getInterviews().add(this);
    }

    public List<InterviewCase5Entity> getInterviews() {
        return interviews;
    }

    public void setInterviews(List<InterviewCase5Entity> interviews) {
        this.interviews = interviews;
    }

    public List<InterviewCase5Entity> getInterviewEntity() {
        return Collections.unmodifiableList(interviews);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InterviewCase5Entity that = (InterviewCase5Entity) o;

        if (id != that.id) return false;
        if (clipId != null ? !clipId.equals(that.clipId) : that.clipId != null) return false;
        if (feedbackInput != null ? !feedbackInput.equals(that.feedbackInput) : that.feedbackInput != null)
            return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (required != null ? !required.equals(that.required) : that.required != null) return false;
        if (trustValue != null ? !trustValue.equals(that.trustValue) : that.trustValue != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.intValue();
        result = 31 * result + (trustValue != null ? trustValue.hashCode() : 0);
        result = 31 * result + (required != null ? required.hashCode() : 0);
        result = 31 * result + (feedbackInput != null ? feedbackInput.hashCode() : 0);
        result = 31 * result + (clipId != null ? clipId.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }


    @Override
    public String toString() {
        return getName();
    }

}
