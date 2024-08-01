package com.complaints.complaintsjava.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "complaints")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Complaint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "product_matricule", nullable = false)
    private String productMatricule;

    @Column(name = "product_id", nullable = false)
    private String productId;

    @Column(name = "product_address", nullable = false)
    private String productAddress;

    @Column(nullable = false)
    private String description;

    @ElementCollection
    @Column(name = "image_urls")
    private List<String> imageUrls;

    @Column(nullable = false)
    private String status = "Pending";

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", updatable = false)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = new Date();
        updatedAt = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = new Date();
    }
}