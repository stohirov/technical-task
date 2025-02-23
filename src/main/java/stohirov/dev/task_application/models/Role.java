package stohirov.dev.task_application.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import stohirov.dev.task_application.models.enums.Permission;
import stohirov.dev.task_application.models.enums.RoleType;
import stohirov.dev.task_application.models.template.SoftDeletableEntity;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "role")
public class Role extends SoftDeletableEntity {

    @Column(unique = true, nullable = false)
    @Enumerated(value = EnumType.STRING)
    private RoleType name;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(value = EnumType.STRING)
    private Set<Permission> permissions;

}
