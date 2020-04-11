package com.sky.cloud2020.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//import org.springframework.data.annotation.Id;

//import javax.persistence.GeneratedValue;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {
//    @Id
//    @GeneratedValue
    private Long id;

    private String serial;
}
