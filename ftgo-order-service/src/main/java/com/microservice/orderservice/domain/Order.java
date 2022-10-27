package com.microservice.orderservice.domain;

import com.microservice.orderservice.domain.enumeration.OrderStateEnum;
import com.microservice.orderserviceapi.messaging.common.OrderDetails;
import com.microservice.orderserviceapi.messaging.common.enums.RejectionReason;

import javax.persistence.*;

@Entity
@Table(name = "orders")
@Access(AccessType.FIELD)
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;


	@Enumerated(EnumType.STRING)
	private OrderStateEnum state;

	
	@Embedded
	private OrderDetails orderDetails;
	
	@Enumerated(EnumType.STRING)
	private RejectionReason rejectionReason;
	
	@Version
	private Long version;
	
}
