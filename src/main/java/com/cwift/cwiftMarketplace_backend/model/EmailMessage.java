package com.cwift.cwiftMarketplace_backend.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("Email")
public class EmailMessage {
    @ApiModelProperty("Email Destination")
    private String to;

    @ApiModelProperty("Email Subject")
    private String subject;

    @ApiModelProperty("Email Body")
    private String message;
}
