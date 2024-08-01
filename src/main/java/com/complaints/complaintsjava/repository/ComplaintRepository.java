package com.complaints.complaintsjava.repository;


import com.complaints.complaintsjava.entity.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComplaintRepository extends JpaRepository<Complaint, Long> {
}