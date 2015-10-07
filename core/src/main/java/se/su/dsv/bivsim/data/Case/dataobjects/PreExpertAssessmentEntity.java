package se.su.dsv.bivsim.data.Case.dataobjects;


import javax.persistence.*;
import java.io.Serializable;

@Table(name = "PreExpertAssessment", schema = "", catalog = "bivsim")
@Entity
public class PreExpertAssessmentEntity extends DomainObject implements Serializable {


    @Column(name = "assessmentId")
    @Id
    private long assessmentId;


    @Column(name = "medical")
    private String medical;

    @Column(name = "medicaltodolist")
    private String medicaltodolist;


    @Column(name = "mental")
    private String mental;


    @Column(name = "mentaltodolist")
    private String mentaltodolist;

    @Column(name = "living")
    private String living;


    @Column(name = "livingtodolist")
    private String livingtodolist;


    @Column(name = "spiritual")
    private String spiritual;

    @Column(name = "spiritualtodolist")
    private String spiritualtodolist;

    @Column(name = "groupId")
    private Integer groupId;

    public long getAssessmentId() {
        return assessmentId;
    }

    public void setAssessmentId(long assessmentId) {
        this.assessmentId = assessmentId;
    }

    public String getMedical() {
        return medical;
    }

    public void setMedical(String medical) {
        this.medical = medical;
    }

    public String getMedicaltodolist() {
        return medicaltodolist;
    }

    public void setMedicaltodolist(String medicaltodolist) {
        this.medicaltodolist = medicaltodolist;
    }


    public String getMental() {
        return mental;
    }

    public void setMental(String mental) {
        this.mental = mental;
    }

    public String getMentaltodolist() {
        return mentaltodolist;
    }

    public void setMentaltodolist(String mentaltodolist) {
        this.mentaltodolist = mentaltodolist;
    }


    public String getLiving() {
        return living;
    }

    public void setLiving(String living) {
        this.living = living;
    }


    public String getLivingtodolist() {
        return livingtodolist;
    }

    public void setLivingtodolist(String livingtodolist) {
        this.livingtodolist = livingtodolist;
    }


    public String getSpiritual() {
        return spiritual;
    }

    public void setSpiritual(String spiritual) {
        this.spiritual = spiritual;
    }

    public String getSpiritualtodolist() {
        return spiritualtodolist;
    }

    public void setSpiritualtodolist(String spiritualtodolist) {
        this.spiritualtodolist = spiritualtodolist;
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

        PreExpertAssessmentEntity that = (PreExpertAssessmentEntity) o;

        if (assessmentId != that.assessmentId) return false;
        if (living != null ? !living.equals(that.living) : that.living != null) return false;
        if (livingtodolist != null ? !livingtodolist.equals(that.livingtodolist) : that.livingtodolist != null)
            return false;
        if (medical != null ? !medical.equals(that.medical) : that.medical != null) return false;
        if (medicaltodolist != null ? !medicaltodolist.equals(that.medicaltodolist) : that.medicaltodolist != null)
            return false;
        if (mental != null ? !mental.equals(that.mental) : that.mental != null) return false;
        if (mentaltodolist != null ? !mentaltodolist.equals(that.mentaltodolist) : that.mentaltodolist != null)
            return false;
        if (spiritual != null ? !spiritual.equals(that.spiritual) : that.spiritual != null) return false;
        if (spiritualtodolist != null ? !spiritualtodolist.equals(that.spiritualtodolist) : that.spiritualtodolist != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) assessmentId;
        result = 31 * result + (medical != null ? medical.hashCode() : 0);
        result = 31 * result + (medicaltodolist != null ? medicaltodolist.hashCode() : 0);
        result = 31 * result + (mental != null ? mental.hashCode() : 0);
        result = 31 * result + (mentaltodolist != null ? mentaltodolist.hashCode() : 0);
        result = 31 * result + (living != null ? living.hashCode() : 0);
        result = 31 * result + (livingtodolist != null ? livingtodolist.hashCode() : 0);
        result = 31 * result + (spiritual != null ? spiritual.hashCode() : 0);
        result = 31 * result + (spiritualtodolist != null ? spiritualtodolist.hashCode() : 0);
        return result;
    }
}
