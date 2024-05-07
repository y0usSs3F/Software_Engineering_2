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
@Table(name="warehouse")
public class warehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="warehouse_id")
    Integer warehouseId ;
    @Column(name="warehouse_name")
    String warehouseName;

    public warehouse( String warehouseName){
        this.warehouseName= warehouseName;


    }
}
