package za.co.kmotsepe.tasuku.domain.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PersistenceUnit;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 *
 * @author Kingsley Motsepe
 */
@PersistenceUnit(unitName="portalrest")
//@SuppressWarnings("PersistenceUnitPresent")
@Entity(name = "task")
@Table(name  = "task")
@Data
@Builder
@ToString
@AllArgsConstructor
public class TaskEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    
    @Column(name = "name")
    String name;
    
    @Column(name = "description")
    String description;
}
