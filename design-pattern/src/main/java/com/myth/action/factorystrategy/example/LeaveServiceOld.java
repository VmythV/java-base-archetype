package com.myth.action.factorystrategy.example;

import com.myth.action.factorystrategy.po.LeaveForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LeaveServiceOld {
    private final Logger logger = LoggerFactory.getLogger(LeaveServiceOld.class);
    public void audit(LeaveForm leaveForm){
        if (leaveForm.getDays() <= 3 && leaveForm.getType() == 1){
            logger.info("三天一下婚丧假无需审批自动通过");
        }
        if (leaveForm.getDays() > 3 && leaveForm.getType() == 1){
            logger.info("三天以上婚丧假，进入上级审批流程");
        }
        if (leaveForm.getEmployee().getLevel() == 9){
            logger.info("总经理请假无需审批自定通过");
        }
        if (leaveForm.getDays() == 1 && leaveForm.getType() == 0){
            logger.info("一天病假无需审批自动通过");
        }
        if (leaveForm.getDays() > 1 && leaveForm.getType() == 0){
            logger.info("一天以上病假，进入上级审批流程");
        }
    }
}
