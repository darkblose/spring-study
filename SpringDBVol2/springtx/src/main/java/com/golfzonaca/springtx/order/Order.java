package com.golfzonaca.springtx.order;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order {
     
    @Id
    @GeneratedValue
    private Long id;

    private String username; //정상, 예외, 잔고부족 ※ 원래라면 Enum 타입 사용.
    private String payStatus; //대기, 완료
}
