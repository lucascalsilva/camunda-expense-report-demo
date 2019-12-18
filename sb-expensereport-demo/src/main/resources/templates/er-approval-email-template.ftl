<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<head>
    <title>Expense Report Status E-mail</title>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
</head>
<style>
    table {
      border-collapse: collapse;
      width: 100%;
    }

    td, th {
      border: 1px solid #dddddd;
      text-align: left;
      padding: 8px;
    }

    tr:nth-child(even) {
      background-color: #dddddd;
    }
</style>
<body>

    <p>Dear ${expenseReport.requester.name},</p>
    <p>Your expense report ${expenseReport.number} status is: <b>${expenseReport.lastApproval.description}.</b></p>

    <#if expenseReport.lastApproval == "REQUEST_CHANGES">
    <p>Here are the changes requested in the approval process: <b>${expenseReport.changesDescription}.</b></p>

    <#elseif expenseReport.lastApproval == "PAYMENT_ISSUES">
    <p>The report presented some payment issues. Please contact the accounts payables team for more information.</p>
    </#if>

    <p>Creation Date: ${expenseReport.creationDate?string["dd/MM/yyyy"]}</p>
    <p>Reason: ${expenseReport.reason.description}</p>
    <p>Justification: ${expenseReport.justification}</p>

    <p>Expense Items:</p>

    <#list expenseReport.expenses>
    <table>
        <tr>
            <th>Amount</th>
            <th>Description</th>
            <th>Expense Date</th>
        </tr>
        <#items as expense>
        <tr>
            <td>${expense.amount}</td>
            <td>${expense.description}</td>
            <td>${expense.expenseDate?string["dd/MM/yyyy"]}</td>
        </tr>
    </#items>
    </table>
    </#list>

    <p>Regards.</p>
    <p>Expense Reimbursement Team</p>
</body>