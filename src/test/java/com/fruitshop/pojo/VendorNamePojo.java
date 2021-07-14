package com.fruitshop.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

//lombok annotation
@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true) // meaning ignore any variable except instance field in this class
public class VendorNamePojo {

    private String name ;  // declare the instance
//    private String vendor_url;


}
