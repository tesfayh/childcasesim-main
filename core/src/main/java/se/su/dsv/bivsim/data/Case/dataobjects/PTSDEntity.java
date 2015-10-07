package se.su.dsv.bivsim.data.Case.dataobjects;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: kebede
 * Date: 02/10/13
 * Time: 11:45
 * To change this template use File | Settings | File Templates.
 */
@Table(name = "PTSD", schema = "", catalog = "bivsim")
@Entity
public class PTSDEntity extends DomainObject implements Serializable {


    @Column(name = "PTSD_ID")
    @Id
    private long ptsdId;


    @Column(name = "Question")
    private String question;

    @Column(name = "ExpertOpinion")
    private Integer expertOpinion;

    @Column(name = "groupId")
    private Integer groupId;

    public long getPtsdId() {
        return ptsdId;
    }

    public void setPtsdId(int ptsdId) {
        this.ptsdId = ptsdId;
    }


    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
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

        PTSDEntity that = (PTSDEntity) o;

        if (ptsdId != that.ptsdId) return false;
        if (expertOpinion != null ? !expertOpinion.equals(that.expertOpinion) : that.expertOpinion != null)
            return false;
        if (groupId != null ? !groupId.equals(that.groupId) : that.groupId != null) return false;
        if (question != null ? !question.equals(that.question) : that.question != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) ptsdId;
        result = 31 * result + (question != null ? question.hashCode() : 0);
        result = 31 * result + (expertOpinion != null ? expertOpinion.hashCode() : 0);
        result = 31 * result + (groupId != null ? groupId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return getQuestion();
    }
}
