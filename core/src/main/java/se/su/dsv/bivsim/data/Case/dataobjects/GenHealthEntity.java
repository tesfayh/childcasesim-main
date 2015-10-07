package se.su.dsv.bivsim.data.Case.dataobjects;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "GenHealth", schema = "", catalog = "bivsim")
@Entity
public class GenHealthEntity extends DomainObject implements Serializable {


    @Column(name = "GenHealth_ID")
    @Id
    private long genHealthId;

    @Column(name = "Question")
    private String question;

    @Column(name = "Answer")
    private String answer;

    @Column(name = "ExpertOpinion")
    private Integer expertOpinion;

    @Column(name = "groupId")
    private Integer groupId;

    public long getGenHealthId() {
        return genHealthId;
    }

    public void setGenHealthId(int genHealthId) {
        this.genHealthId = genHealthId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }


    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }


    public Integer getExpertOpinion() {
        return expertOpinion;
    }

    public void setExpertOpinion(Integer expertOpinion) {
        this.expertOpinion = expertOpinion;
    }


    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GenHealthEntity that = (GenHealthEntity) o;

        if (genHealthId != that.genHealthId) return false;
        if (answer != null ? !answer.equals(that.answer) : that.answer != null) return false;
        if (expertOpinion != null ? !expertOpinion.equals(that.expertOpinion) : that.expertOpinion != null)
            return false;
        if (groupId != null ? !groupId.equals(that.groupId) : that.groupId != null) return false;
        if (question != null ? !question.equals(that.question) : that.question != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) genHealthId;
        result = 31 * result + (question != null ? question.hashCode() : 0);
        result = 31 * result + (answer != null ? answer.hashCode() : 0);
        result = 31 * result + (expertOpinion != null ? expertOpinion.hashCode() : 0);
        result = 31 * result + (groupId != null ? groupId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return getQuestion();
    }
}
