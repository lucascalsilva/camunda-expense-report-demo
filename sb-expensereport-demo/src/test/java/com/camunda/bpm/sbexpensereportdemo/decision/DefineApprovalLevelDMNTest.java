package com.camunda.bpm.sbexpensereportdemo.decision;

import com.camunda.bpm.model.expenses.ExpenseReport;
import org.camunda.bpm.dmn.engine.DmnDecisionTableResult;
import org.camunda.bpm.engine.test.Deployment;
import org.camunda.bpm.engine.test.ProcessEngineRule;
import org.junit.Rule;
import org.junit.Test;

import java.util.HashMap;

import static com.camunda.bpm.sbexpensereportdemo.util.TestUtils.createRandomExpenseReport;
import static org.assertj.core.api.Assertions.assertThat;

public class DefineApprovalLevelDMNTest {

    private static final String DECISION_DEFINITION_KEY = "define-approval-level-er";

    @Rule
    public ProcessEngineRule rule = new ProcessEngineRule();

    @Test
    @Deployment(resources = {"define-approval-level-er.dmn"})
    public void testApprovalLevelRule(){
        /*ExpenseReport expenseReport = createRandomExpenseReport();
        HashMap<String, Object> variables = new HashMap<>();
        variables.put("amount", expenseReport.getTotalAmount());

        DmnDecisionTableResult decisionResult = rule.getDecisionService()
                .evaluateDecisionTableByKey(DECISION_DEFINITION_KEY)
                .variables(variables).evaluate();
        assertThat(decisionResult.getFirstResult()).containsEntry("approvalLevel", 3L);*/
    }
}
