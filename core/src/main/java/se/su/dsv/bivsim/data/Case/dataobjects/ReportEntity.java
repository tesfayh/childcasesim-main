package se.su.dsv.bivsim.data.Case.dataobjects;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "report", schema = "", catalog = "bivsim")
@Entity
public class ReportEntity extends DomainObject implements Serializable {

    @Column(name = "report_ID")
    @Id
    private long reportId;

    @Column(name = "name")
    private String name;

    @Column(name = "comment")
    private String comment;

    @Column(name = "groupId")
    private Integer groupId;

    public long getReportId() {
        return reportId;
    }

    public void setReportId(long reportId) {
        this.reportId = reportId;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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

        ReportEntity that = (ReportEntity) o;

        if (reportId != that.reportId) return false;
        if (comment != null ? !comment.equals(that.comment) : that.comment != null) return false;
        if (groupId != null ? !groupId.equals(that.groupId) : that.groupId != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) reportId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (groupId != null ? groupId.hashCode() : 0);
        return result;
    }
}
