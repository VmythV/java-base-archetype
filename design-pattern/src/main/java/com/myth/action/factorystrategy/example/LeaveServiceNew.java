package com.myth.action.factorystrategy.example;

import com.myth.action.factorystrategy.po.Employee;
import com.myth.action.factorystrategy.po.LeaveForm;
import com.myth.action.factorystrategy.strategy.AuditStrategy;
import com.myth.action.factorystrategy.strategy.AuditStrategyFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LeaveServiceNew {
    private final Logger logger = LoggerFactory.getLogger(LeaveServiceNew.class);
    public void audit(LeaveForm leaveForm){
        AuditStrategyFactory factory = AuditStrategyFactory.getInstance();
        AuditStrategy auditStrategy = factory.getAuditStrategy(leaveForm);
        logger.info("符合规则：{}",auditStrategy.getName()+"("+auditStrategy.getClass().getSimpleName()+")");
        auditStrategy.audit(leaveForm);
    }

    public static void main(String[] args) {
        LeaveServiceNew leaveServiceNew = new LeaveServiceNew();
        LeaveForm leaveForm = new LeaveForm(new Employee("zhangsan", 6), "回家有事", 5, 1);
        leaveServiceNew.audit(leaveForm);
    }
}
