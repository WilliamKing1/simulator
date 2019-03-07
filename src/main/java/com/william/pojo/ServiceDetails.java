package com.william.pojo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel
public class ServiceDetails {
    private String parentId;
    private String serviceName;
    private String version;
    private String description;
    private String type;
    private String messageId;
    private String requestSchema;
    private String responseSchema;


}
