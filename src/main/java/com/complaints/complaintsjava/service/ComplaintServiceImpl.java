package com.complaints.complaintsjava.service;



import com.complaints.complaintsjava.dto.ComplaintDTO;
import com.complaints.complaintsjava.entity.Complaint;
import com.complaints.complaintsjava.repository.ComplaintRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ComplaintServiceImpl implements ComplaintService {

    @Autowired
    private ComplaintRepository complaintRepository;

    @Override
    public ComplaintDTO createComplaint(ComplaintDTO complaintDTO) {
        Complaint complaint = new Complaint();
        BeanUtils.copyProperties(complaintDTO, complaint,  "status","createdAt", "updatedAt");
        complaint = complaintRepository.save(complaint);
        return convertToDTO(complaint);
    }

    @Override
    public List<ComplaintDTO> getAllComplaints() {
        return complaintRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ComplaintDTO getComplaintById(Long id) {
        return complaintRepository.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    @Override
    public ComplaintDTO updateComplaintStatus(Long id, String status) {
        Complaint complaint = complaintRepository.findById(id).orElse(null);
        if (complaint != null) {
            complaint.setStatus(status);
            complaint = complaintRepository.save(complaint);
            return convertToDTO(complaint);
        }
        return null;
    }

    @Override
    public void deleteComplaint(Long id) {
        complaintRepository.deleteById(id);
    }

    private ComplaintDTO convertToDTO(Complaint complaint) {
        ComplaintDTO complaintDTO = new ComplaintDTO();
        BeanUtils.copyProperties(complaint, complaintDTO);
        return complaintDTO;
    }
}

