package se.su.dsv.bivsim.data.Case.dataobjects;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "AllCases", schema = "", catalog = "bivsim")
@Entity
public class AllCasesEntity extends DomainObject implements Serializable {

    @Column(name = "CaseId")
    @Id
    private long caseId;

    @Column(name = "name")
    private String name;


    @Column(name = "Cases")
    private String cases;


    public String getCases() {
        return cases;
    }

    public void setCases(String cases) {
        this.cases = cases;
    }


    public long getCaseId() {
        return caseId;
    }

    public void setCaseId(int caseId) {
        this.caseId = caseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AllCasesEntity that = (AllCasesEntity) o;

        if (caseId != that.caseId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (cases != null ? !cases.equals(that.cases) : that.cases != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) caseId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return getName();
    }
}
