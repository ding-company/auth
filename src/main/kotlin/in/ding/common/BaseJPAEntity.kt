package `in`.ding.common

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime
import java.util.*

@MappedSuperclass
abstract class BaseJPAEntity {
    @Id
    @Column(updatable = false)
    open var id: UUID = UUID.randomUUID()

    @CreationTimestamp
    @CreatedDate
    @Column(updatable = false)
    open var createdAt: LocalDateTime = LocalDateTime.now()

    @UpdateTimestamp
    @LastModifiedDate
    open var updatedAt: LocalDateTime = LocalDateTime.now()
}