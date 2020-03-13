package ru.lanittercom.santa.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "booking")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
public class Order extends BaseEntity {
    private String name;
    private String type_souvenir;
}
