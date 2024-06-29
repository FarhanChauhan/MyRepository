package in.ineuron.bo;

import java.io.Serializable;
import java.time.*;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class MarraigeSeeker implements Serializable{

	public static final int maxContentSize = 2097152;
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY	)
	private Integer id;
	@NonNull
	private String name;
	@NonNull
	private String addresss;
	@NonNull
	private LocalDateTime dob;
	@NonNull
	private Boolean Indian;
	
	@Lob
	@NonNull
	private char[] bioData;
	
	@Lob
	@NonNull
	@Column(length=maxContentSize)
	private byte[] photo;
	
}
