package com.casestudy.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jmc.casestudy.model.enums.BusTypeEnum;
import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "bus")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bus {
  @Id
  private Long id;

  @Column(name = "reg_num", unique = true)
  private String regNum;

  @Column(name = "type")
  private BusTypeEnum type;
}
