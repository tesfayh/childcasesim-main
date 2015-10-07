package se.su.dsv.bivsim.data.Case.dataobjects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "Admins", schema = "", catalog = "bivsim")
@Entity
public class AdminsEntity extends DomainObject implements Serializable {

    @Column(name = "Amin_ID")
    @Id
    private long aminId;

    @Column(name = "name")
    private String name;

    @Column(name = "fullName")
    private String fullName;

    @Column(name = "email")
    private String email;

    @Column(name = "orgName")
    private String orgName;


    @Column(name = "role")
    private String role;

    @Column(name = "password")
    private String password;

    public long getAminId() {
        return aminId;
    }

    public void setAminId(int aminId) {
        this.aminId = aminId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getfullName() {
        return fullName;
    }

    public void setfullName(String fullName) {
        this.fullName = fullName;
    }



    public String getorgName() {
        return orgName;
    }

    public void setorgName(String orgName) {
        this.orgName = orgName;
    }


    public String getemail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }



    public String getrole() {
        return role;
    }

    public void setrole(String role) {
        this.role = role;
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdminsEntity that = (AdminsEntity) o;

        if (aminId != that.aminId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) aminId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
