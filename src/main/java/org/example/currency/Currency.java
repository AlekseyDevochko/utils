package org.example.currency;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class Currency {

    private String numCode;
    private String charCode;
    private int scale;
    private String name;
    private double rateBuy;
    private double rateSell;

    Currency(String numCode, String charCode, String scale, String name, String rate){
        this.numCode = numCode;
        this.charCode = charCode;
        this.scale = Integer.parseInt(scale);
        this.name = name;
        this.rateBuy = Double.valueOf(rate);
        this.rateSell = this.rateBuy * 1.05;


    }


}
