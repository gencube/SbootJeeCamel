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
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author gencube
 */
@Data
@NoArgsConstructor
@Entity(name = "orderItems")
@Table(name = "orderItems")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderItems implements Serializable {

    @Id
    @GeneratedValue(generator = UUID, strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = UUID, strategy = UUID_STRATEGY)
    @Column(name = "ITM_ID", updatable = false, nullable = false)
    private String id;

    @ManyToOne
    @JoinColumn(name = "ORD_ITM_ID")
    @Column(nullable = false)
    private String orderId;

    @ManyToOne
    @JoinColumn(name = "CSR_ITM_ID")
    @Column(nullable = false)
    private String customerId;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String currency;

    @Column(nullable = false)
    private double itemPrice;

    @Column(nullable = false)
    private double itemQuantity;

    @Column(nullable = false)
    private double itemTotal;

}
