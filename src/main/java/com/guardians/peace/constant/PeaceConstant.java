package com.guardians.peace.constant;

public class PeaceConstant {

    private PeaceConstant() {
    }

    private static final String FILTER_COLUMN_NAMES = "&fields=id,key,summary,description";
    public static final String OPEN_DEFECT_QUERY = "project = \"iB Payments\" AND \"Target Production Release\" = \"TARGET_PRODUCTION_VALUE\" AND status NOT IN (closed,\"SIT Deployment\",Completed,\"E2E / UAT\",\"ready for tat deployment\",\"deployed to tat\",\"Deployed to Prod\",\"TAT retest\",\"TAT Testing\",\"SIT retest\",\"Ready for SIT Deployment\",\"Ready for Prod Deployment\",Cancelled,\"Ready for INT deployment\",\"INT retest\",\"QA\") AND type=Defect" + FILTER_COLUMN_NAMES;
    public static final String TICKETS_NOT_UPDATED_QUERY = "project = \"iB Payments\" AND created >= \"-7d\" AND NOT status changed AND comment !~ \"FIND_ISSUES_WITH_COMMENTS\"" + FILTER_COLUMN_NAMES;
    public static final String ASSIGNED_DEFECT_QUERY = "assignee='rahul.ranjan@cybg.com'" + FILTER_COLUMN_NAMES;
    public static final String SORRY_MESSAGE_RESPONSE = "Sorry! I could not get the requested data for you.";
}
