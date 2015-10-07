package se.su.dsv.bivsim.data.Case.dataobjects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "ProbableDiagonosis", schema = "", catalog = "bivsim")
@Entity
public class ProbableDiagonosisEntity {

    @Column(name = "PDId")
    @Id
    private long pdId;


    @Column(name = "DD4")
    private String dd4;

    @Column(name = "PD")
    private String pd;

    @Column(name = "PDM")
    private String pdm;


    @Column(name = "DD1")
    private String dd1;

    @Column(name = "DD1M")
    private String dd1M;


    @Column(name = "DD2")
    private String dd2;

    @Column(name = "DD2M")
    private String dd2M;


    @Column(name = "DD3")
    private String dd3;


    @Column(name = "DD3M")
    private String dd3M;

    @Column(name = "DD4M")
    private String dd4M;


    public long getPdId() {
        return pdId;
    }

    public void setPdId(long pdId) {
        this.pdId = pdId;
    }


    public String getPd() {
        return pd;
    }

    public void setPd(String pd) {
        this.pd = pd;
    }


    public String getPdm() {
        return pdm;
    }

    public void setPdm(String pdm) {
        this.pdm = pdm;
    }


    public String getDd1() {
        return dd1;
    }

    public void setDd1(String dd1) {
        this.dd1 = dd1;
    }


    public String getDd1M() {
        return dd1M;
    }

    public void setDd1M(String dd1M) {
        this.dd1M = dd1M;
    }


    public String getDd2() {
        return dd2;
    }

    public void setDd2(String dd2) {
        this.dd2 = dd2;
    }


    public String getDd2M() {
        return dd2M;
    }

    public void setDd2M(String dd2M) {
        this.dd2M = dd2M;
    }


    public String getDd3() {
        return dd3;
    }

    public void setDd3(String dd3) {
        this.dd3 = dd3;
    }


    public String getDd3M() {
        return dd3M;
    }

    public void setDd3M(String dd3M) {
        this.dd3M = dd3M;
    }


    public String getDd4() {
        return dd4;
    }

    public void setDd4(String dd4) {
        this.dd4 = dd4;
    }


    public String getDd4M() {
        return dd4M;
    }

    public void setDd4M(String dd4M) {
        this.dd4M = dd4M;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProbableDiagonosisEntity that = (ProbableDiagonosisEntity) o;

        if (pdId != that.pdId) return false;
        if (dd1 != null ? !dd1.equals(that.dd1) : that.dd1 != null) return false;
        if (dd1M != null ? !dd1M.equals(that.dd1M) : that.dd1M != null) return false;
        if (dd2 != null ? !dd2.equals(that.dd2) : that.dd2 != null) return false;
        if (dd2M != null ? !dd2M.equals(that.dd2M) : that.dd2M != null) return false;
        if (dd3 != null ? !dd3.equals(that.dd3) : that.dd3 != null) return false;
        if (dd3M != null ? !dd3M.equals(that.dd3M) : that.dd3M != null) return false;
        if (dd4 != null ? !dd4.equals(that.dd4) : that.dd4 != null) return false;
        if (dd4M != null ? !dd4M.equals(that.dd4M) : that.dd4M != null) return false;
        if (pd != null ? !pd.equals(that.pd) : that.pd != null) return false;
        if (pdm != null ? !pdm.equals(that.pdm) : that.pdm != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) pdId;
        result = 31 * result + (pd != null ? pd.hashCode() : 0);
        result = 31 * result + (pdm != null ? pdm.hashCode() : 0);
        result = 31 * result + (dd1 != null ? dd1.hashCode() : 0);
        result = 31 * result + (dd1M != null ? dd1M.hashCode() : 0);
        result = 31 * result + (dd2 != null ? dd2.hashCode() : 0);
        result = 31 * result + (dd2M != null ? dd2M.hashCode() : 0);
        result = 31 * result + (dd3 != null ? dd3.hashCode() : 0);
        result = 31 * result + (dd3M != null ? dd3M.hashCode() : 0);
        result = 31 * result + (dd4 != null ? dd4.hashCode() : 0);
        result = 31 * result + (dd4M != null ? dd4M.hashCode() : 0);
        return result;
    }
}
