package com.myth.action.factorystrategy.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    /**
     * 员工名称
     */
    private String name;
    /**
     * 员工等级
     */
    private int level;
}
