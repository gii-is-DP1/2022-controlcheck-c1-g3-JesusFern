package org.springframework.samples.petclinic.recoveryroom;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.samples.petclinic.model.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class RecoveryRoomType extends BaseEntity{
    @NotNull
    @Size(min = 5, max = 50)
    @NotBlank
    String name;
}
