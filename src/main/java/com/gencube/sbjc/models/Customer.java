package com.gencube.sbjc.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import static com.gencube.sbjc.models.ModelsInfo.UUID;
import static com.gencube.sbjc.models.ModelsInfo.UUID_STRATEGY;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author gencube
 */
@Data
@NoArgsConstructor
@Entity(name = "customer")
@Table(name = "customer")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Customer implements Serializable {

    @Id
    @GeneratedValue(generator = UUID, strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = UUID, strategy = UUID_STRATEGY)
    @Column(name = "ID", updatable = false, nullable = false)
    private String id;    
    
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String nickName;

    @Column
    private String email;

    @Column(nullable = false)
    private boolean gender;

    @Column(nullable = false)
    private String mobile;

}
