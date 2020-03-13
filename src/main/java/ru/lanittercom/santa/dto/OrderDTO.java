package ru.lanittercom.santa.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class OrderDTO extends BaseDTO {
    private String name;
    private String type_souvenir;
}
