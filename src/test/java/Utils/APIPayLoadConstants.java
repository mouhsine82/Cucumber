package Utils;

import org.json.JSONObject;

public class APIPayLoadConstants {

    // we will pass the body in multiple formats, for this we have created this class

    public static String createEmployeePayload() {
        String createEmployeePayload = "{\n" +
                "  \"emp_firstname\": \"Donald\",\n" +
                "  \"emp_lastname\": \"Biden\",\n" +
                "  \"emp_middle_name\": \"Ds\",\n" +
                "  \"emp_gender\": \"M\",\n" +
                "  \"emp_birthday\": \"1943-05-09\",\n" +
                "  \"emp_status\": \"Confirmed\",\n" +
                "  \"emp_job_title\": \"Homeless\"\n" +
                "}";

        return createEmployeePayload;
    }

    public static String createEmployeePayloadJson() {
        JSONObject obj = new JSONObject();
        obj.put("emp_firstname", "Donald");
        obj.put("emp_lastname", "Biden");
        obj.put("emp_middle_name", "Ds");
        obj.put("emp_gender", "M");
        obj.put("emp_birthday", "1943-05-09");
        obj.put("emp_status", "Confirmed");
        obj.put("emp_job_title", "Homeless");

        return obj.toString();
    }


    public static String createEmployeePayloadDynamic
            (String emp_firstname, String emp_lastname,
             String emp_middle_name, String emp_gender,
             String emp_birthday, String emp_status, String emp_job_title) {

        JSONObject obj = new JSONObject();
        obj.put("emp_firstname", emp_firstname);
        obj.put("emp_lastname", emp_lastname);
        obj.put("emp_middle_name", emp_middle_name);
        obj.put("emp_gender", emp_gender);
        obj.put("emp_birthday", emp_birthday);
        obj.put("emp_status", emp_status);
        obj.put("emp_job_title", emp_job_title);

        return obj.toString();

    }

    public static String updateEmployeePayloadJson() {
        JSONObject obj = new JSONObject();
        obj.put("employee_id", "57739A");
        obj.put("emp_firstname", "MOMO");
        obj.put("emp_lastname", "BOBO");
        obj.put("emp_middle_name", "ms");
        obj.put("emp_gender", "M");
        obj.put("emp_birthday", "2015-05-20");
        obj.put("emp_status", "Probation");
        obj.put("emp_job_title", "QA");

        return obj.toString();
    }
}
