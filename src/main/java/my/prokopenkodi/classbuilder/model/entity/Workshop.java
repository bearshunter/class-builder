package my.prokopenkodi.classbuilder.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "workshop")
@NoArgsConstructor
public class Workshop {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private WorkshopStatus status = WorkshopStatus.PRIVATE;

    @Column(nullable = false)
    private long creationDate;

    @Column(nullable = false)
    private long modificationDate;

    @Column
    private String text;


    @OneToOne(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, optional = false)
    private Student creator;
}
