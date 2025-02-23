package stohirov.dev.task_application.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import stohirov.dev.task_application.models.enums.Priority;
import stohirov.dev.task_application.models.enums.Status;
import stohirov.dev.task_application.models.template.SoftDeletableEntity;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "tasks")
@Table(indexes = {
        @Index(name = "idx_task_status", columnList = "status"),
        @Index(name = "idx_task_priority", columnList = "priority")
})
public class Task extends SoftDeletableEntity {

    @Column(nullable = false)
    private String title;

    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assignee_id")
    private User assignee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "creator_id", nullable = false, updatable = false)
    private User creator;

    @Column(updatable = false, nullable = false)
    private LocalDateTime startsAt;

    private LocalDateTime expiresAt;

    private LocalDateTime completedAt;

    private boolean isExpired = false;

}
