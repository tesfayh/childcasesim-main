package se.su.dsv.bivsim.data.Case.dataobjects;

import javax.persistence.*;
import java.io.Serializable;


@Table(name = "FollowUp", schema = "", catalog = "bivsim")
@Entity
public class FollowUpEntity extends DomainObject implements Serializable {

    @Column(name = "FollowUp_ID")
    @Id
    private long followUpId;

    @Column(name = "ExpertOpinion")
    private String expertOpinion;

    @Column(name = "groupId")
    private Integer groupId;

    public long getFollowUpId() {
        return followUpId;
    }

    public void setFollowUpId(int followUpId) {
        this.followUpId = followUpId;
    }


    public String getExpertOpinion() {
        return expertOpinion;
    }

    public void setExpertOpinion(String expertOpinion) {
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

        FollowUpEntity that = (FollowUpEntity) o;

        if (followUpId != that.followUpId) return false;
        if (expertOpinion != null ? !expertOpinion.equals(that.expertOpinion) : that.expertOpinion != null)
            return false;
        if (groupId != null ? !groupId.equals(that.groupId) : that.groupId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) followUpId;
        result = 31 * result + (expertOpinion != null ? expertOpinion.hashCode() : 0);
        result = 31 * result + (groupId != null ? groupId.hashCode() : 0);
        return result;
    }
}
