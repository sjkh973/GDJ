package domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // @Getter, @Setter, @ToString 등
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContactDTO {

	private int contact_no;
	private String name;
	private String tel;
	private String email;
	private Date reg_date;
	
	
}
