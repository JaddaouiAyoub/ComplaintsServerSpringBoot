package com.complaints.complaintsjava.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;
@Data

public class ComplaintDTO {

    private Long id;
    private String productName;
    private String productMatricule;
    private String productId;
    private String productAddress;
    private String description;
    private List<String> imageUrls;
    private String status;
    private Date createdAt;
    private Date updatedAt;

    // Getters and Setters
}

