package se.su.dsv.bivsim.data.Case.dataobjects;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Table(name = "PhysicalExam", schema = "", catalog = "bivsim")
@Entity
public class PhysicalExamEntity extends DomainObject implements Serializable {

    public PhysicalExamEntity() {

    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "physicalExam_ID")
    @Id
    private Long physicalExamId;

    @Column(name = "name")
    private String name;

    @Column(name = "pic_ID")
    private String picId;

    @Column(name = "description")
    private String description;

    @Column(name = "expertOpinion")
    private Integer expertOpinion;

    @ManyToOne
    @JoinColumn(name = "parent_ID")
    private PhysicalExamEntity parent;

    @OneToMany(mappedBy = "parent", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private List<PhysicalExamEntity> PhysicalExamEntities = new ArrayList<PhysicalExamEntity>();

    @Column(name = "cate_ID")
    public Integer cate_ID;

    public Integer getCate_ID() {
        return cate_ID;
    }

    public void setCate_ID(Integer cate_ID) {

        this.cate_ID = cate_ID;
    }

    @Column(name = "groupId")
    public Integer groupId;

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public List<PhysicalExamEntity> getPhysicalExamEntities() {
        return PhysicalExamEntities;
    }

    public void setPhysicalExamEntities(List<PhysicalExamEntity> physicalExamEntities) {
        PhysicalExamEntities = physicalExamEntities;
    }

    public Integer getExpertOpinion() {
        return expertOpinion;
    }

    public void setExpertOpinion(Integer expertOpinion) {
        this.expertOpinion = expertOpinion;
    }

    public PhysicalExamEntity getParent() {
        return parent;
    }

    public void setParent(PhysicalExamEntity parent) {
        this.parent = parent;
    }


    public long getPhysicalExamId() {
        return physicalExamId;
    }

    public void setPhysicalExamId(long physicalExamId) {
        this.physicalExamId = physicalExamId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getPicId() {
        return picId;
    }

    public void setPicId(String picId) {
        this.picId = picId;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PhysicalExamEntity that = (PhysicalExamEntity) o;

        if (physicalExamId != that.physicalExamId) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (picId != null ? !picId.equals(that.picId) : that.picId != null) return false;
        if (cate_ID != null ? !cate_ID.equals(that.cate_ID) : that.cate_ID != null) return false;


        return true;
    }

    @Override
    public int hashCode() {
        int result = physicalExamId.intValue();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (picId != null ? picId.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (cate_ID != null ? cate_ID.hashCode() : 0);

        return result;
    }

    @Override
    public String toString() {
        return getName();
    }
}
