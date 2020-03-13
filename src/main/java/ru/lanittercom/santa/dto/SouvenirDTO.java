package ru.lanittercom.santa.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class SouvenirDTO extends BaseDTO {
    private String type;
    private long count;
}
