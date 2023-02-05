package com.myth.action.factorystrategy.strategy.impl;

import com.myth.action.factorystrategy.po.LeaveForm;
import com.myth.action.factorystrategy.strategy.AuditStrategy;
import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

public class AuditStrategyImpl5 implements AuditStrategy {
    private final Logger logger = getLogger(AuditStrategyImpl5.class);
    @Override
    public boolean isSupport(LeaveForm form) {
        return form.getDays() > 1 && form.getType() == 0;
    }

    @Override
    public void audit(LeaveForm leaveForm) {
        System.out.println("leaveForm:"+leaveForm);
        System.out.println("三天一下婚丧假无需审批自动通过");
    }

    @Override
    public int getPriority() {
        return 5;
    }

    @Override
    public String getName() {
        return "一天以上病假审批规则";
    }
}
