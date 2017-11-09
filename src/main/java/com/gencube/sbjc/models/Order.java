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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author gencube
 */
@Data
@NoArgsConstructor
@Entity(name = "order")
@Table(name = "order")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Order implements Serializable {

    @Id
    @GeneratedValue(generator = UUID, strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = UUID, strategy = UUID_STRATEGY)
    @Column(name = "ORD_ID", updatable = false, nullable = false)
    private String orderId;

    @ManyToOne
    @JoinColumn(name = "CSR_ORD_ID")
    @Column
    private String customerId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ORD_TIME", nullable = true)
    private int orderTime;

    @Column
    private int itemCounts;

    @Column
    private String currency;

    @Column
    private double orderTotal;

}
