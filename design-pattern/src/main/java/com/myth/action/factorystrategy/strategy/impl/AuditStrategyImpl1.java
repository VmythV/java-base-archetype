package com.myth.action.factorystrategy.strategy.impl;

import com.myth.action.factorystrategy.po.LeaveForm;
import com.myth.action.factorystrategy.strategy.AuditStrategy;

public class AuditStrategyImpl1 implements AuditStrategy {
    @Override
    public boolean isSupport(LeaveForm form) {
        return form.getDays() <= 3 && form.getType() == 1;
    }

    @Override
    public void audit(LeaveForm leaveForm) {
        System.out.println("leaveForm:"+leaveForm);
        System.out.println("三天一下婚丧假无需审批自动通过");
    }

    @Override
    public int getPriority() {
        return 1;
    }

    @Override
    public String getName() {
        return "三天一下婚丧假无需审批规则";
    }
}
