package se.su.dsv.bivsim.data.Case.dataobjects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "HTQ", schema = "", catalog = "bivsim")
@Entity
public class HtqEntity extends DomainObject implements Serializable {

    @Column(name = "HTQ_ID")
    @Id
    private long htqId;

    @Column(name = "Question")
    private String question;

    @Column(name = "Answer")
    private String answer;


    @Column(name = "ExpertOpinion")
    private Integer expertOpinion;

    @Column(name = "groupId")
    public Integer groupId;

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public long getHtqId() {
        return htqId;
    }

    public void setHtqId(int htqId) {
        this.htqId = htqId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HtqEntity htqEntity = (HtqEntity) o;

        if (htqId != htqEntity.htqId) return false;
        if (answer != null ? !answer.equals(htqEntity.answer) : htqEntity.answer != null) return false;
        if (expertOpinion != null ? !expertOpinion.equals(htqEntity.expertOpinion) : htqEntity.expertOpinion != null)
            return false;
        if (question != null ? !question.equals(htqEntity.question) : htqEntity.question != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) htqId;
        result = 31 * result + (question != null ? question.hashCode() : 0);
        result = 31 * result + (answer != null ? answer.hashCode() : 0);
        result = 31 * result + (expertOpinion != null ? expertOpinion.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return getQuestion();
    }
}
