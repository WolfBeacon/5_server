package io.wolfbeacon.server.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Aaron on 03/06/2016.
 */
@Entity
@Table(name = "users")
public class User implements DomainModel<Long> {
    @GenericGenerator(name = "generator", strategy = "foreign",
            parameters = @Parameter(name = "property", value = "account"))
    @Id
    @GeneratedValue(generator = "generator")
    private Long id;
    @OneToOne
    @JoinColumn(name = "id")
    private Account account;
    private Timestamp createdAt;
    private Timestamp lastUpdatedAt;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id.user")
    private Set<AttendingStatus> attendingStatuses = new HashSet<>();

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getLastUpdatedAt() {
        return lastUpdatedAt;
    }

    public void setLastUpdatedAt(Timestamp lastUpdatedAt) {
        this.lastUpdatedAt = lastUpdatedAt;
    }

    public Set<AttendingStatus> getAttendingStatuses() {
        return attendingStatuses;
    }

    public void setAttendingStatuses(Set<AttendingStatus> attendingStatuses) {
        this.attendingStatuses = attendingStatuses;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", account=" + account +
                ", createdAt=" + createdAt +
                ", lastUpdatedAt=" + lastUpdatedAt +
                ", attendingStatuses=" + attendingStatuses +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (getId() != null ? !getId().equals(user.getId()) : user.getId() != null) return false;
        if (getAccount() != null ? !getAccount().equals(user.getAccount()) : user.getAccount() != null) return false;
        if (getCreatedAt() != null ? !getCreatedAt().equals(user.getCreatedAt()) : user.getCreatedAt() != null)
            return false;
        if (getLastUpdatedAt() != null ? !getLastUpdatedAt().equals(user.getLastUpdatedAt()) : user.getLastUpdatedAt() != null)
            return false;
        return getAttendingStatuses() != null ? getAttendingStatuses().equals(user.getAttendingStatuses()) : user.getAttendingStatuses() == null;

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getAccount() != null ? getAccount().hashCode() : 0);
        result = 31 * result + (getCreatedAt() != null ? getCreatedAt().hashCode() : 0);
        result = 31 * result + (getLastUpdatedAt() != null ? getLastUpdatedAt().hashCode() : 0);
        result = 31 * result + (getAttendingStatuses() != null ? getAttendingStatuses().hashCode() : 0);
        return result;
    }
}
