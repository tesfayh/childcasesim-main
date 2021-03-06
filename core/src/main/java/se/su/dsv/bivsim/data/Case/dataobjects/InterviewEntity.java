package se.su.dsv.bivsim.data.Case.dataobjects;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Table(name = "Interview", schema = "", catalog = "bivsim")
@Entity
public class InterviewEntity extends DomainObject implements Serializable {

    public InterviewEntity() {

    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "interview_ID")
    @Id
    private Long id;


    @Column(name = "type_person")
    private String person;



    @Column(name = "feedback_Input")
    private String feedbackInput;

    @Column(name = "exp_feedback_Input")
    private String exp_feedbackInput;

    @Column(name = "clip_ID")
    private String clipId;

    @ManyToOne
    @JoinColumn(name = "parent_ID")
    private InterviewEntity parent;

    @OneToMany(mappedBy = "parent", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private List<InterviewEntity> interviews = new ArrayList<InterviewEntity>();

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


    public String getPerson()
    {
        return person;
    }

    public void setPerson(String person)
    {
        this.person = person;
    }




    public String getFeedbackInput() {
        return feedbackInput;
    }

    public void setFeedbackInput(String feedbackInput) {
        this.feedbackInput = feedbackInput;
    }


    public String getExp_feedbackInput() {
        return exp_feedbackInput;
    }

    public void setExp_feedbackInput(String exp_feedbackInput) {
        this.exp_feedbackInput = exp_feedbackInput;
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


    public InterviewEntity getParent() {
        return parent;
    }

    public void setParent(InterviewEntity parent) {
        this.parent = parent;
        // parent.getInterviews().add(this);
    }

    public List<InterviewEntity> getInterviews() {
        return interviews;
    }

    public void setInterviews(List<InterviewEntity> interviews) {
        this.interviews = interviews;
    }

    public List<InterviewEntity> getInterviewEntity() {
        return Collections.unmodifiableList(interviews);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InterviewEntity that = (InterviewEntity) o;

        if (id != that.id) return false;
        if (clipId != null ? !clipId.equals(that.clipId) : that.clipId != null) return false;
        if (feedbackInput != null ? !feedbackInput.equals(that.feedbackInput) : that.feedbackInput != null)
            return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.intValue();
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
