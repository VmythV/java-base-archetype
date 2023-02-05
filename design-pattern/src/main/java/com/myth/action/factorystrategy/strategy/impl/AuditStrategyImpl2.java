package com.myth.action.factorystrategy.strategy.impl;

import com.myth.action.factorystrategy.po.LeaveForm;
import com.myth.action.factorystrategy.strategy.AuditStrategy;
import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

public class AuditStrategyImpl2 implements AuditStrategy {
    private final Logger logger = getLogger(AuditStrategyImpl2.class);
    @Override
    public boolean isSupport(LeaveForm form) {
        return form.getDays() > 3 && form.getType() == 1;
    }

    @Override
    public void audit(LeaveForm leaveForm) {
        System.out.println("leaveForm:"+leaveForm);
        System.out.println("三天以上婚丧假，进入上级审批流程");
    }

    @Override
    public int getPriority() {
        return 2;
    }

    @Override
    public String getName() {
        return "三天以上婚丧假审批规则";
    }
}
