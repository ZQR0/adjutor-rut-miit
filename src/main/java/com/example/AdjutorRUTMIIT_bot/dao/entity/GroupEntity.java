package com.example.AdjutorRUTMIIT_bot.dao.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "group_entity")
@Table(name = "groups_table", schema = "adjutor_schema")
@NoArgsConstructor
@Setter
public class GroupEntity extends AbstractEntity<Integer> {

    private int id;
    private String groupName;
    private String groupDescription;
    private String joinLink;
    private LocalDateTime creationDateTime;
    private LocalDateTime updatingDateTime;
    private UserEntity creator;
    private Integer creatorId;
    private Set<Integer> membersIds;

    public GroupEntity(
            String groupName,
            String groupDescription,
            String joinLink,
            LocalDateTime creationDateTime,
            LocalDateTime updatingDateTime,
            UserEntity creator,
            Integer creatorId
    )
    {
        this.groupName = groupName;
        this.groupDescription = groupDescription;
        this.joinLink = joinLink;
        this.creationDateTime = creationDateTime;
        this.updatingDateTime = updatingDateTime;
        this.creator = creator;
        this.creatorId = creatorId;
        this.membersIds = new HashSet<>();
        membersIds.add(creatorId);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_id", nullable = false)
    @Override
    public Integer getId() {
        return id;
    }

    @Column(name = "group_name", nullable = false, unique = true, length = 100)
    public String getGroupName() {
        return groupName;
    }

    @Column(name = "group_description", nullable = false, length = 100)
    public String getGroupDescription() {
        return groupDescription;
    }

    @Column(name = "join_link", nullable = false, length = 500)
    public String getJoinLink() {
        return joinLink;
    }

    @CreationTimestamp
    @Column(name = "creation_date_time", nullable = false)
    public LocalDateTime getCreationDateTime() {
        return creationDateTime;
    }

    @UpdateTimestamp
    @Column(name = "updating_date_time", nullable = false)
    public LocalDateTime getUpdatingDateTime() {
        return updatingDateTime;
    }

    @ManyToOne
    @JoinColumn(name = "creator_id", referencedColumnName = "user_id", foreignKey = @ForeignKey(name = "creator_id"))
    public UserEntity getCreator() {
        return creator;
    }


    @Column(name = "members_ids", columnDefinition = "integer[]", nullable = false)
    public Set<Integer> getMembersIds() {
        return membersIds;
    }

    public static GroupEntityBuilder builder() {
        return new GroupEntityBuilder();
    }

    public static final class GroupEntityBuilder {
        private String groupName;
        private String groupDescription;
        private String joinLink;
        private LocalDateTime creationDateTime;
        private LocalDateTime updatingDateTime;
        private UserEntity creator;
        private Integer creatorId;

        public GroupEntityBuilder groupName(String groupName) {
            this.groupName = groupName;
            return this;
        }

        public GroupEntityBuilder groupDescription(String groupDescription) {
            this.groupDescription = groupDescription;
            return this;
        }

        public GroupEntityBuilder joinLink(String joinLink) {
            this.joinLink = joinLink;
            return this;
        }

        public GroupEntityBuilder creationDateTime(LocalDateTime creationDateTime) {
            this.creationDateTime = creationDateTime;
            return this;
        }

        public GroupEntityBuilder updatingDateTime(LocalDateTime updatingDateTime) {
            this.updatingDateTime = updatingDateTime;
            return this;
        }

        public GroupEntityBuilder creator(UserEntity creator) {
            this.creator = creator;
            return this;
        }

        public GroupEntityBuilder creatorId(Integer id) {
            this.creatorId = id;
            return this;
        }

        public GroupEntity build() {
            return new GroupEntity(
                    groupName,
                    groupDescription,
                    joinLink,
                    creationDateTime,
                    updatingDateTime,
                    creator,
                    creatorId
            );
        }
    }

}
