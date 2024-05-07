package com.Secuirty.secuirtyproject.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Secuirty.secuirtyproject.Entities.request;
import com.Secuirty.secuirtyproject.Services.requestService;

@RestController
@RequestMapping("/request")
public class requestController {

    @Autowired
    private requestService requestService;

    // POST mapping to create a new request with specific parameters
    @PostMapping("/createRequest")
    // localhost:8080/request/createRequest
    public String saveRequest(@RequestBody Map<String, String> request) {
        String requestDate = request.get("requestDate");
        String requestStatus = request.get("requestStatus");
        String SupervisorName = request.get("supervisor_name");
        Integer supervisorId = Integer.parseInt(request.get("supervisorId"));
        Integer productId = Integer.parseInt(request.get("productId"));

        request requests = new request(requestDate, requestStatus, SupervisorName, supervisorId, productId);
        requestService.addRequest(requests);

        return "done";
    }

    // return all requests
    @GetMapping("/read")
    // localhost:8080/request/read
    public List<request> getRequests() {
        return requestService.getrequests();
    }

    // accept a request
    @PostMapping("/accept")
    public String acceptRequest(@RequestParam Integer requestId) {
        boolean accepted = requestService.acceptRequest(requestId);
        if (accepted) {
            return "Request accepted successfully";
        } else {
            return "Failed to accept request";
        }
    }

    // decline a request
    @PostMapping("/decline")
    public String declineRequest(@RequestParam Integer requestId) {
        boolean declined = requestService.declineRequest(requestId);
        if (declined) {
            return "Request declined successfully";
        } else {
            return "Failed to decline request";
        }
    }

}















// my code
//
//
//package com.Secuirty.secuirtyproject.Controller;
//
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//import org.springframework.web.bind.annotation.GetMapping;
//
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.Secuirty.secuirtyproject.Entities.request;
//import com.Secuirty.secuirtyproject.Services.requestService;
//
//@RestController
//@RequestMapping("/request")
//public class requestController {
//
//    @Autowired
//    private requestService requestService;
//
//    // POST mapping to create a new request with specific parameters
//    @PostMapping("/createRequest")
//    // localhost:8080/request/createRequest
//    public String saveRequest(@RequestBody Map<String, String> request) {
//        String requestDate = request.get("requestDate");
//        String requestStatus = request.get("requestStatus");
//        String notifiedSupervisor = request.get("notifiedSupervisor");
//        Integer supervisorId = Integer.parseInt(request.get("supervisorId"));
//        Integer productId = Integer.parseInt(request.get("productId"));
//        request requests = new request(requestDate, requestStatus, notifiedSupervisor, supervisorId, productId);
//        requestService.addRequest(requests);
//
//        return "done";
//    }
//
//    // return all requests
//    @GetMapping("/read")
//    // localhost:8080/request/read
//    public List<request> getRequests() {
//        return requestService.getrequests();
//    }
//
//    // accept a request
//    @PostMapping("/accept")
//    public String acceptRequest(@RequestParam Integer requestId) {
//        boolean accepted = requestService.acceptRequest(requestId);
//        if (accepted) {
//            return "Request accepted successfully";
//        } else {
//            return "Failed to accept request";
//        }
//    }
//
//    // decline a request
//    @PostMapping("/decline")
//    public String declineRequest(@RequestParam Integer requestId) {
//        boolean declined = requestService.declineRequest(requestId);
//        if (declined) {
//            return "Request declined successfully";
//        } else {
//            return "Failed to decline request";
//        }
//    }
//
//}
