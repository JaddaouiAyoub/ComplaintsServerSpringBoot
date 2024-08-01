package com.complaints.complaintsjava.controller;



import com.complaints.complaintsjava.dto.ComplaintDTO;
import com.complaints.complaintsjava.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/complaints")
public class ComplaintController {

    @Autowired
    private ComplaintService complaintService;

    @PostMapping
    public ResponseEntity<ComplaintDTO> createComplaint(@RequestBody ComplaintDTO complaintDTO) {
        return ResponseEntity.ok(complaintService.createComplaint(complaintDTO));
    }

    @GetMapping
    public ResponseEntity<List<ComplaintDTO>> getAllComplaints() {
        return ResponseEntity.ok(complaintService.getAllComplaints());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ComplaintDTO> getComplaintById(@PathVariable Long id) {
        ComplaintDTO complaintDTO = complaintService.getComplaintById(id);
        return complaintDTO != null ? ResponseEntity.ok(complaintDTO) : ResponseEntity.notFound().build();
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<ComplaintDTO> updateComplaintStatus(@PathVariable Long id, @RequestBody String status) {
        // Retirer les guillemets potentiels autour du status
        String cleanedStatus = status.replaceAll("^\"|\"$", "").trim();

        ComplaintDTO complaintDTO = complaintService.updateComplaintStatus(id, cleanedStatus);
        return complaintDTO != null ? ResponseEntity.ok(complaintDTO) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComplaint(@PathVariable Long id) {
        complaintService.deleteComplaint(id);
        return ResponseEntity.ok().build();
    }
}
