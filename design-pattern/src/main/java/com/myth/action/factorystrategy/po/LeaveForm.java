package com.myth.action.factorystrategy.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeaveForm {
    /**
     * 员工
     */
    private Employee employee;
    /**
     * 请假原因
     */
    private String reason;
    /**
     * 天数
     */
    private int days;
    /**
     * 类型：0-病假 1-婚丧假 2-年假
     */
    private int type;
}
