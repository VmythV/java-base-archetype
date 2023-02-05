package com.myth.action.factorystrategy.strategy;

import com.myth.action.factorystrategy.po.LeaveForm;

/**
 * 审批策略类
 *
 * @author may
 */
public interface AuditStrategy {

    /**
     * 判断条件是否匹配
     *
     * @param form the form
     * @return the boolean
     */
    public boolean isSupport(LeaveForm form);

    /**
     * 审计业务逻辑
     *
     * @param leaveForm the leave form
     */
    public void audit(LeaveForm leaveForm);

    /**
     * 规则冲突时的优先级
     *
     * @return the priority
     */
    public int getPriority();

    /**
     * 规则名称
     *
     * @return the name
     */
    public String getName();
}
