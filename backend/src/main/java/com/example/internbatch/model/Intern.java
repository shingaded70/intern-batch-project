package com.example.internbatch.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Intern {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String internId;

    private String name;
    private String email;
    private String mobileNumber;
    private String idCardType;
    private LocalDate dateOfJoining;

    @ManyToOne
    @JoinColumn(name = "batch_id")
    private Batch batch;

    // Getters and Setters

    public Long getId() { 
        return id; 
    }

    public void setId(Long id) { 
        this.id = id; 
    }

    public String getInternId() { 
        return internId; 
    }

    public void setInternId(String internId) { 
        this.internId = internId; 
    }

    public String getName() { 
        return name; 
    }

    public void setName(String name) { 
        this.name = name; 
    }

    public String getEmail() { 
        return email; 
    }

    public void setEmail(String email) { 
        this.email = email; 
    }

    public String getMobileNumber() { 
        return mobileNumber; 
    }

    public void setMobileNumber(String mobileNumber) { 
        this.mobileNumber = mobileNumber; 
    }

    public String getIdCardType() { 
        return idCardType; 
    }

    public void setIdCardType(String idCardType) { 
        this.idCardType = idCardType; 
    }

    public LocalDate getDateOfJoining() { 
        return dateOfJoining; 
    }

    public void setDateOfJoining(LocalDate dateOfJoining) { 
        this.dateOfJoining = dateOfJoining; 
    }

    public Batch getBatch() { 
        return batch; 
    }

    public void setBatch(Batch batch) { 
        this.batch = batch; 
    }
}