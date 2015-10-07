package se.su.dsv.bivsim.data.Case.dataobjects;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by kib on 3/12/15.
 */
@Entity
@Table(name = "ExpertAssessment", schema = "", catalog = "bivsim")
public class ExpertAssessmentEntity extends DomainObject implements Serializable {
    private long id;
    private String pysBedo;
    private String pysAtg;
    private String psyBedo;
    private String psyAtg;
    private String socialBedo;
    private String socialAtg;

    @Id
    @Column(name = "Id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "pys_Bedo")
    public String getPysBedo() {
        return pysBedo;
    }

    public void setPysBedo(String pysBedo) {
        this.pysBedo = pysBedo;
    }

    @Basic
    @Column(name = "pys_ATG")
    public String getPysAtg() {
        return pysAtg;
    }

    public void setPysAtg(String pysAtg) {
        this.pysAtg = pysAtg;
    }

    @Basic
    @Column(name = "psy_Bedo")
    public String getPsyBedo() {
        return psyBedo;
    }

    public void setPsyBedo(String psyBedo) {
        this.psyBedo = psyBedo;
    }

    @Basic
    @Column(name = "psy_ATG")
    public String getPsyAtg() {
        return psyAtg;
    }

    public void setPsyAtg(String psyAtg) {
        this.psyAtg = psyAtg;
    }

    @Basic
    @Column(name = "Social_Bedo")
    public String getSocialBedo() {
        return socialBedo;
    }

    public void setSocialBedo(String socialBedo) {
        this.socialBedo = socialBedo;
    }

    @Basic
    @Column(name = "Social_ATG")
    public String getSocialAtg() {
        return socialAtg;
    }

    public void setSocialAtg(String socialAtg) {
        this.socialAtg = socialAtg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExpertAssessmentEntity that = (ExpertAssessmentEntity) o;

        if (id != that.id) return false;
        if (psyAtg != null ? !psyAtg.equals(that.psyAtg) : that.psyAtg != null) return false;
        if (psyBedo != null ? !psyBedo.equals(that.psyBedo) : that.psyBedo != null) return false;
        if (pysAtg != null ? !pysAtg.equals(that.pysAtg) : that.pysAtg != null) return false;
        if (pysBedo != null ? !pysBedo.equals(that.pysBedo) : that.pysBedo != null) return false;
        if (socialAtg != null ? !socialAtg.equals(that.socialAtg) : that.socialAtg != null) return false;
        if (socialBedo != null ? !socialBedo.equals(that.socialBedo) : that.socialBedo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) id;
        result = 31 * result + (pysBedo != null ? pysBedo.hashCode() : 0);
        result = 31 * result + (pysAtg != null ? pysAtg.hashCode() : 0);
        result = 31 * result + (psyBedo != null ? psyBedo.hashCode() : 0);
        result = 31 * result + (psyAtg != null ? psyAtg.hashCode() : 0);
        result = 31 * result + (socialBedo != null ? socialBedo.hashCode() : 0);
        result = 31 * result + (socialAtg != null ? socialAtg.hashCode() : 0);
        return result;
    }
}
