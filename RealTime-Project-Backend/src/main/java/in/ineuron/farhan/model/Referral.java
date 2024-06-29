package in.ineuron.farhan.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "referrals")
public class Referral {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "full_name")
    private String fullName;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "referral_date")
    private LocalDateTime referralDate;
    
    private Long contactNo;
    
    private String status;
    
    private String department;
    
    private String password;
    
    @Column(name = "organization_details")
    private String organizationDetails;
    
    @ManyToOne
    @JoinColumn(name = "reffered_code")
    private User referralCode;
    
}
