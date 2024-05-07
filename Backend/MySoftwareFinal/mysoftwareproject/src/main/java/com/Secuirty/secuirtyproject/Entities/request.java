// code 2

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
@Table(name="requests")
public class request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="request_id")
    Integer requestId;
    @Column(name="request_date")
    String requestDate;
    @Column(name="request_status")
    String requestStatus;
    @Column(name="supervisor_name")
    String SupervisorName;
    @Column(name="supervisor_id")
    Integer supervisorId;
    @Column(name="product_id")
    Integer productId;

    public request( String requestDate,String requestStatus,String SupervisorName,Integer supervisorId,Integer productId){
        this.requestDate= requestDate;
        this.requestStatus =requestStatus;
        this.SupervisorName =SupervisorName;
        this.supervisorId = supervisorId;
        this.productId= productId;
    }

}













// code 1
//package com.Secuirty.secuirtyproject.Entities;
//
//
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//
//
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity
//@Table(name="requests")
//public class request {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name="request_id")
//    Integer requestId;
//    @Column(name="request_date")
//    String requestDate;
//    @Column(name="request_status")
//    String requestStatus;
//    @Column(name="supervisor_name")
//    String  SupervisorName;
//    @Column(name="supervisor_id")
//    Integer supervisorId;
//    @Column(name="product_id")
//    Integer productId;
//
//    public request( String requestDate,String requestStatus,String SupervisorName,Integer supervisorId,Integer productId){
//        this.requestDate= requestDate;
//        this.requestStatus =requestStatus;
//        this.SupervisorName =SupervisorName;
//        this.supervisorId = supervisorId;
//        this.productId= productId;
//    }
//
//}
