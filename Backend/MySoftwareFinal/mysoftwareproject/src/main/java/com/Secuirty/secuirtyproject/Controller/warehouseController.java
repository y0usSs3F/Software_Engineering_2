package com.Secuirty.secuirtyproject.Controller;
import java.util.List;
import java.util.Map;

import com.Secuirty.secuirtyproject.Entities.warehouse;
import com.Secuirty.secuirtyproject.Services.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Secuirty.secuirtyproject.Entities.warehouse;

@RestController
@RequestMapping("/warehouse")
public class warehouseController {
    @Autowired
    private WarehouseService warehouseService;

    // create warehouse
    @PostMapping("/createWarehouse")
    // localhost:8080/warehouse/createwarehouse
    public String saveWarehouse(@RequestBody Map<String, String> request) {
        try {


            if (request.get("warehouseName") == null || request.get("warehouseName").trim().isEmpty() ) {
                return "Error:  empty required fields. Please ensure 'warehouseName' are provided.";
            }

            String warehouseName = request.get("warehouseName").trim();

            warehouse warehouse = new warehouse(warehouseName);
            warehouseService.addWarehouse(warehouse);

            return "warehouse added successfully";
        } catch (Exception e) {
            return "Error: An unexpected error occurred.";
        }
    }

    // delete warehouse
    @DeleteMapping("{id}/delete")
    // localhost:8080/warehouse/id/delete
    public String deleteWarehouse(@PathVariable Integer id) {
        warehouseService.deleteWarehouse(id);
        return "Deleted successfully";
    }

    // update warehouse
    @PutMapping("/{id}/update")
    // localhost:8080/warehouse/id/update
    public warehouse updateWarehouse(@PathVariable Integer id, @RequestBody Map<String, String> request) {
        String warehouseName = request.get("warehouseName");

        warehouse warehouse = new warehouse(warehouseName);
        warehouse result = warehouseService.updateWarehouse(warehouse);
        return result;
    }
    // read (view) warehouse

    @GetMapping("/read")
    // localhost:8080/warehouse/read
    public List<warehouse> getWarehouse() {
        return warehouseService.getWarehouses();
    }
}