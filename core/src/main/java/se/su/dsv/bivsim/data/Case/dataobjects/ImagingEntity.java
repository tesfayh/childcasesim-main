package se.su.dsv.bivsim.data.Case.dataobjects;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Table(name = "Imaging", schema = "", catalog = "bivsim")
@Entity
public class ImagingEntity extends DomainObject implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "imaging_ID")
    @Id
    private long imagingId;
    @Column(name = "name")
    private String name;
    @Column(name = "pic_ID")
    private String picId;
    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "parent_ID")
    private ImagingEntity parent;

    @OneToMany(mappedBy = "parent", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private List<ImagingEntity> imagingEntities = new ArrayList<ImagingEntity>();

    @Column(name = "groupId")
    public Integer groupId;

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }


    @Column(name = "cate_ID")
    public Integer cate_ID;


    public Integer getCate_ID() {
        return cate_ID;
    }

    public void setCate_ID(Integer cate_ID) {
        this.cate_ID = cate_ID;
    }

    public ImagingEntity() {

    }

    public ImagingEntity getParent() {
        return parent;
    }

    public void setParent(ImagingEntity parent) {
        this.parent = parent;
    }

    public List<ImagingEntity> getImagingEntities() {
        return imagingEntities;
    }

    public void setImagingEntities(List<ImagingEntity> imagingEntities) {
        this.imagingEntities = imagingEntities;
    }

    public long getImagingId() {
        return imagingId;
    }

    public void setImagingId(int imagingId) {
        this.imagingId = imagingId;
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

        ImagingEntity that = (ImagingEntity) o;

        if (imagingId != that.imagingId) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (picId != null ? !picId.equals(that.picId) : that.picId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) imagingId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (picId != null ? picId.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return getName();
    }
}
