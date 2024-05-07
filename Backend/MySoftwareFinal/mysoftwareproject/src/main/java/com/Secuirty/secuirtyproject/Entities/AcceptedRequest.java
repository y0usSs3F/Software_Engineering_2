package com.Secuirty.secuirtyproject.Entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="accepted_requests")
public class AcceptedRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="request_id")
    Integer requestId;
    @Column(name="request_date")
    String requestDate;
    @Column(name="SupervisorName")
    String SupervisorName;
    @Column(name="supervisor_id")
    Integer supervisorId;
    @Column(name="product_id")
    Integer productId;
}
