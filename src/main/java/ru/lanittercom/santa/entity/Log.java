package ru.lanittercom.santa.entity;

import lombok.*;
import org.hibernate.procedure.spi.ParameterRegistrationImplementor;

import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
public class Log extends BaseEntity {
    private String peopleName;
    private String message;
}
