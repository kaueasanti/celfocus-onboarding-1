package com.training.springbootbuyitem.entity.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Proxy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;

@Proxy(lazy = false)
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Item extends Auditable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long itemUid;
	@Column(unique = true)
	private String name;
	private String state;
	private String description;
	private String market;
	private BigInteger stock;
	private BigDecimal priceTag;
	private BigInteger reservedStock;

	@ManyToOne
	@JoinColumn(name="userUID")
	private User user;

	public Item(String name){
		this.name = name;
	}

}
