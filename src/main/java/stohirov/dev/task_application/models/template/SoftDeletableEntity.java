package stohirov.dev.task_application.models.template;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@MappedSuperclass
@SQLRestriction("is_deleted=false")
@SQLDelete(sql = "update {h-schema} set is_deleted=true where id = ?")
public abstract class SoftDeletableEntity extends AbsEntity {

    @Column(nullable = false, name = "is_deleted")
    private boolean isDeleted = false;

}
