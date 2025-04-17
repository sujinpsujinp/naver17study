package bit.day0417.data;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * 엔티티?
 * JPA에서 엔티티는 테이블에서 대응하는 하나의 클래스라고 생각하면 된다
 * Spring-boot-stater-data-jpa 의존성을 추가하고 @entity 어노테이션을 붙이면 테으블과 자바 클래스가 매핑이 됩니다.
 */
@Entity
@Table(name="jpamycar") //db에 jpamycar라는 테이블이 생성된다
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MycarDto {
	
	@Id //각엔티티를 구별할 수 있도록 식별 아이디를 갖도록 설계
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long num;
	
	//@Column(name="dbcarname") //변수명과 달리 db에서 dbcarname으로 생성한다
	@Column(length=30)//name은 생략 시 변수명과 같은 이름으로 컬러명이 생성된다
	private String carname;
	
	private int carprice; //name은 같은 이름으로 생성할거라 필요없고 나머지 설정도 필요 없다면 @Column 생략가능 int는 길이도 필요없으니까	
	
	@Column(length=40)
	private String carcolor;
	
	@Column(length=20)
	private String carimage;
	
	@Column(length=20)
	private String carguip;
	
	//writeday는 자동으로 현재시간으로 추가되어야하고 수정시에는 제외되어야함
	@CreationTimestamp 
	@Column(updatable=false)
	private Timestamp writeday;
	
	//테이블에서 안만들어지게 하고싶음
	@Transient
	private String message;
	
	@Transient
	private int commentcount;
}
