package com.gdutdb.carsales.po.dto;

import com.gdutdb.carsales.po.poja.Option;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OptionData {
    private Option option;

    //1表示被选择,0表示未被选择
    private Integer choose;
}
