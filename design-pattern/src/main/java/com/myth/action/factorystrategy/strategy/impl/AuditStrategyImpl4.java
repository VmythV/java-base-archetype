package com.myth.action.factorystrategy.strategy.impl;

import com.myth.action.factorystrategy.po.LeaveForm;
import com.myth.action.factorystrategy.strategy.AuditStrategy;
import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

public class AuditStrategyImpl4 implements AuditStrategy {
    private final Logger logger = getLogger(AuditStrategyImpl4.class);
    @Override
    public boolean isSupport(LeaveForm form) {
        return form.getDays() == 1 && form.getType() == 0;
    }

    @Override
    public void audit(LeaveForm leaveForm) {
        System.out.println("leaveForm:"+leaveForm);
        System.out.println("一天病假无需审批自动通过");
    }

    @Override
    public int getPriority() {
        return 4;
    }

    @Override
    public String getName() {
        return "一天病假审批规则";
    }
}
