package se.su.dsv.bivsim.data.Case.dataobjects;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "History", schema = "", catalog = "bivsim")
@Entity
public class HistoryEntity extends DomainObject implements Serializable {

    @Column(name = "history_ID")
    @Id
    private long historyId;

    public long getHistoryId() {
        return historyId;
    }

    public void setHistoryId(int historyId) {
        this.historyId = historyId;
    }

    @Column(name = "groupId")
    private Integer groupId;

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    @Column(name = "interview")
    private String interview;


    public String getInterview() {
        return interview;
    }

    public void setInterview(String interview) {
        this.interview = interview;
    }

    @Column(name = "physical_exam")
    private String physicalExam;


    public String getPhysicalExam() {
        return physicalExam;
    }

    public void setPhysicalExam(String physicalExam) {
        this.physicalExam = physicalExam;
    }

    @Column(name = "Imaging")
    private String imaging;


    public String getImaging() {
        return imaging;
    }

    public void setImaging(String imaging) {
        this.imaging = imaging;
    }

    @Column(name = "PHQ2")
    private String phq2;


    public String getPhq2() {
        return phq2;
    }

    public void setPhq2(String phq2) {
        this.phq2 = phq2;
    }

    @Column(name = "PHQ9")
    private String phq9;


    public String getPhq9() {
        return phq9;
    }

    public void setPhq9(String phq9) {
        this.phq9 = phq9;
    }

    @Column(name = "GeneralHealth")
    private String generalHealth;


    public String getGeneralHealth() {
        return generalHealth;
    }

    public void setGeneralHealth(String generalHealth) {
        this.generalHealth = generalHealth;
    }

    @Column(name = "hscl")
    private String hscl;


    public String getHscl() {
        return hscl;
    }

    public void setHscl(String hscl) {
        this.hscl = hscl;
    }

    @Column(name = "ptsd")
    private String ptsd;


    public String getPtsd() {
        return ptsd;
    }

    public void setPtsd(String ptsd) {
        this.ptsd = ptsd;
    }

    @Column(name = "htq")
    private String htq;


    public String getHtq() {
        return htq;
    }

    public void setHtq(String htq) {
        this.htq = htq;
    }

    @Column(name = "follow_up")
    private String followUp;


    public String getFollowUp() {
        return followUp;
    }

    public void setFollowUp(String followUp) {
        this.followUp = followUp;
    }

    @Column(name = "domain_assessment")
    private String domainAssessment;


    public String getDomainAssessment() {
        return domainAssessment;
    }

    public void setDomainAssessment(String domainAssessment) {
        this.domainAssessment = domainAssessment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HistoryEntity that = (HistoryEntity) o;

        if (historyId != that.historyId) return false;
        if (domainAssessment != null ? !domainAssessment.equals(that.domainAssessment) : that.domainAssessment != null)
            return false;
        if (followUp != null ? !followUp.equals(that.followUp) : that.followUp != null) return false;
        if (generalHealth != null ? !generalHealth.equals(that.generalHealth) : that.generalHealth != null)
            return false;
        if (hscl != null ? !hscl.equals(that.hscl) : that.hscl != null) return false;
        if (htq != null ? !htq.equals(that.htq) : that.htq != null) return false;
        if (imaging != null ? !imaging.equals(that.imaging) : that.imaging != null) return false;
        if (interview != null ? !interview.equals(that.interview) : that.interview != null) return false;
        if (phq2 != null ? !phq2.equals(that.phq2) : that.phq2 != null) return false;
        if (phq9 != null ? !phq9.equals(that.phq9) : that.phq9 != null) return false;
        if (physicalExam != null ? !physicalExam.equals(that.physicalExam) : that.physicalExam != null) return false;
        if (ptsd != null ? !ptsd.equals(that.ptsd) : that.ptsd != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) historyId;
        result = 31 * result + (interview != null ? interview.hashCode() : 0);
        result = 31 * result + (physicalExam != null ? physicalExam.hashCode() : 0);
        result = 31 * result + (imaging != null ? imaging.hashCode() : 0);
        result = 31 * result + (phq2 != null ? phq2.hashCode() : 0);
        result = 31 * result + (phq9 != null ? phq9.hashCode() : 0);
        result = 31 * result + (generalHealth != null ? generalHealth.hashCode() : 0);
        result = 31 * result + (hscl != null ? hscl.hashCode() : 0);
        result = 31 * result + (ptsd != null ? ptsd.hashCode() : 0);
        result = 31 * result + (htq != null ? htq.hashCode() : 0);
        result = 31 * result + (followUp != null ? followUp.hashCode() : 0);
        result = 31 * result + (domainAssessment != null ? domainAssessment.hashCode() : 0);
        return result;
    }
}
