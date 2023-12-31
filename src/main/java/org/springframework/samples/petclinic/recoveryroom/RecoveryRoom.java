package org.springframework.samples.petclinic.recoveryroom;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.samples.petclinic.model.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class RecoveryRoom extends BaseEntity{
    @NotNull
    @Size(min = 3, max = 50)
    @NotBlank
    String name;

    @NotNull
    @DecimalMin("0.0")
    double size;

    @NotNull
    boolean secure;
    
    @ManyToOne(optional = false)
    RecoveryRoomType roomType;
}
