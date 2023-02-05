package com.myth.action.factorystrategy.strategy;

import com.myth.action.factorystrategy.po.LeaveForm;
import com.myth.action.factorystrategy.strategy.impl.*;

import java.util.ArrayList;
import java.util.List;

public class AuditStrategyFactory {

    private static final AuditStrategyFactory FACTORY = new AuditStrategyFactory();

    private List<AuditStrategy> auditStrategyList = new ArrayList<>();

    private AuditStrategyFactory() {
        auditStrategyList.add(new AuditStrategyImpl1());
        auditStrategyList.add(new AuditStrategyImpl2());
        auditStrategyList.add(new AuditStrategyImpl3());
        auditStrategyList.add(new AuditStrategyImpl4());
        auditStrategyList.add(new AuditStrategyImpl5());
    }

    public static AuditStrategyFactory getInstance() {
        return FACTORY;
    }

    public AuditStrategy getAuditStrategy(LeaveForm leaveForm) {
        AuditStrategy auditStrategy = null;
        for (AuditStrategy strategy : auditStrategyList) {
            // 找到匹配的规则
            if (strategy.isSupport(leaveForm)) {
                // 如果没有匹配的审批规则时，找到匹配的直接赋值
                if (auditStrategy == null) {
                    auditStrategy = strategy;
                } else {
                    // 如果发现优先级相同的其他规则，直接报错
                    if (strategy.getPriority() == auditStrategy.getPriority()) {
                        throw new RuntimeException("[" + auditStrategy.getName() + "]:[" + strategy.getName() + "]规则冲突，请尽快解决");
                    } else if (strategy.getPriority() > auditStrategy.getPriority()) {
                        // 如果发现高优先级的规则，替代现有规则
                        // 如：总经理请假5天，总经理请假审批规则（999） > 一天以上病假审批规则（0）
                        auditStrategy = strategy;
                    } else {
                        // doNothing
                    }
                }
            }
        }
        if (auditStrategy == null){
            throw new RuntimeException("没有匹配的请假审核规则");
        }else {
            return auditStrategy;
        }
    }
}
