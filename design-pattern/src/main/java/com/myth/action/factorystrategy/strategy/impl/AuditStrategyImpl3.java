package com.myth.action.factorystrategy.strategy.impl;

import com.myth.action.factorystrategy.po.LeaveForm;
import com.myth.action.factorystrategy.strategy.AuditStrategy;
import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

public class AuditStrategyImpl3 implements AuditStrategy {
    private final Logger logger = getLogger(AuditStrategyImpl3.class);
    @Override
    public boolean isSupport(LeaveForm form) {
        return form.getEmployee().getLevel() == 9;
    }

    @Override
    public void audit(LeaveForm leaveForm) {
        System.out.println("leaveForm:"+leaveForm);
        System.out.println("总经理请假无需审批自动通过");
    }

    @Override
    public int getPriority() {
        return 999;
    }

    @Override
    public String getName() {
        return "三天一下婚丧假无需审批规则";
    }
}
