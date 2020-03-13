package ru.lanittercom.santa.entity;

import lombok.*;

import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
public class Souvenir extends BaseEntity {
    private String type;
    private long count;
}
