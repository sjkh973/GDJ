package domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class Member {

	private int memberNo;
	private String id, name, gender, grade, address;
	
}
