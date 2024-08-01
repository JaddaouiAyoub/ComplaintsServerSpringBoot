package com.complaints.complaintsjava.service;


import com.complaints.complaintsjava.dto.ComplaintDTO;

import java.util.List;

public interface ComplaintService {
    ComplaintDTO createComplaint(ComplaintDTO complaintDTO);

    List<ComplaintDTO> getAllComplaints();

    ComplaintDTO getComplaintById(Long id);

    ComplaintDTO updateComplaintStatus(Long id, String status);

    void deleteComplaint(Long id);
}
