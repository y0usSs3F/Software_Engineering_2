package com.Secuirty.secuirtyproject.Services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Secuirty.secuirtyproject.Repository.warehouseRepository;
import com.Secuirty.secuirtyproject.Entities.warehouse;
@Service
public class WarehouseService {
    @Autowired
    private warehouseRepository warehouse;
    public List<com.Secuirty.secuirtyproject.Entities.warehouse> getWarehouses(){
        List<com.Secuirty.secuirtyproject.Entities.warehouse> result = new ArrayList<com.Secuirty.secuirtyproject.Entities.warehouse>();
        warehouse.findAll().forEach(result::add);
        return result;
    }

    //method to add warehouse
    public com.Secuirty.secuirtyproject.Entities.warehouse addWarehouse(com.Secuirty.secuirtyproject.Entities.warehouse warehouseObj){
        warehouse.save(warehouseObj);
        return warehouseObj;
    }

    //method to delete warehouse
    public boolean deleteWarehouse(Integer id){
        warehouse.deleteById(id);

        return true;
    }

    //method to  update category
    public com.Secuirty.secuirtyproject.Entities.warehouse updateWarehouse(com.Secuirty.secuirtyproject.Entities.warehouse warehouseObj){
        return warehouse.save(warehouseObj);
    }

    //method to get all category

    public List <warehouse> getsupervisors(){
        List<warehouse> result = new ArrayList<warehouse>();
        warehouse.findAll().forEach(result::add);
        return result;
    }
}
