package LLD.API;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TransactionLogAnalayser {
    //https://leetcode.com/discuss/interview-question/1975461/twilio-l3-oa-reject

    static int page = -1;
    static int perPage = -1;
    static int total = -1;
    static int totalPages = -1;
    static List<String> dataItems = new ArrayList<>();
    static String baseURL= "https://jsonmock.hackerrank.com/api/transactions/search?userId=";
    public static void main(String[] args) throws IOException {
        int i=0;
        do{
            getHttpData(1,"debit","20/01/2020",i++);
        }while (page!=totalPages);
        System.out.println("size of list: "+dataItems.size());
    }
    public static void getHttpData(int uid, String txnType, String monthYear,int page) throws IOException {
        URL url=new URL(baseURL+uid+"&page="+page);
        HttpURLConnection connection=(HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        int responseCode=connection.getResponseCode();
        if(responseCode==HttpURLConnection.HTTP_OK){
            BufferedReader br=new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            parsePageDetails(response.toString());
            parseResponseData(response,dataItems);
            br.close();
        }
        connection.disconnect();
    }
    private static void parsePageDetails(String json){
                json = json.substring(1, json.length() - 1);
                String[] keyValuePairs = json.split(",");
                for (String pair : keyValuePairs) {
                    String[] keyValue = pair.split(":");
                    if (keyValue.length != 2) {
                        continue; // Skip invalid pairs
                    }

                    String key = keyValue[0].trim().replace("\"", "");
                    String value = keyValue[1].trim();
                    if ("page".equals(key)) {
                        page = Integer.parseInt(value);
                    } else if ("per_page".equals(key)) {
                        perPage = Integer.parseInt(value);
                    } else if ("total".equals(key)) {
                        total = Integer.parseInt(value);
                    } else if ("total_pages".equals(key)) {
                        totalPages = Integer.parseInt(value);
                    }
                }
                System.out.println("page: " + page);
                System.out.println("per_page: " + perPage);
                System.out.println("total: " + total);
                System.out.println("total_pages: " + totalPages);
        System.out.println("------------------------");
    }
    private static void parseResponseData(StringBuilder response, List<String> dataItems) {
        String json = response.toString();
        Matcher dataMatcher = Pattern.compile("\"data\":\\[(.*?)\\]").matcher(json);
        String dataJson = null;
        if (dataMatcher.find()) {
            dataJson = "{" + dataMatcher.group(1) + "}";
        }

        if (dataJson != null) {
            Matcher dataItemMatcher = Pattern.compile("\\{.*?\\}").matcher(dataJson);

            while (dataItemMatcher.find()) {
                String dataItem = dataItemMatcher.group();
                dataItems.add(dataItem);
            }
            for (String item : dataItems) {
                String id = extractFieldValue(item, "\"id\":(\\d+)");
                String userId = extractFieldValue(item, "\"userId\":(\\d+)");
                String userName = extractFieldValue(item, "\"userName\":\"(.*?)\"");
                String timestamp = extractFieldValue(item, "\"timestamp\":(\\d+)");
                String txnType = extractFieldValue(item, "\"txnType\":\"(.*?)\"");
                String amount = extractFieldValue(item, "\"amount\":\"(.*?)\"");
                String locationId = extractNestedFieldValue(item, "location", "\"id\":(\\d+)");
                String locationAddress = extractNestedFieldValue(item, "location", "\"address\":\"(.*?)\"");
                String locationCity = extractNestedFieldValue(item, "location", "\"city\":\"(.*?)\"");
                String locationZipCode = extractNestedFieldValue(item, "location", "\"zipCode\":(\\d+)");
                String ip = extractFieldValue(item, "\"ip\":\"(.*?)\"");
                String formattedDateTime = new java.text.SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new java.util.Date(Long.parseLong(timestamp)));
                // Print or process the extracted fields
                System.out.println("id: " + id+", userId: "+userId+", userName: "+userName+", timestamp: "+formattedDateTime+", txnType:"+txnType+", amount:"+amount);
/*                System.out.println("locationId: " + locationId);
                System.out.println("locationAddress: " + locationAddress);
                System.out.println("locationCity: " + locationCity);
                System.out.println("locationZipCode: " + locationZipCode);
                System.out.println("ip: " + ip);*/
            }
        }
    }
        private static String extractFieldValue (String item, String fieldRegex){
            Pattern pattern = Pattern.compile(fieldRegex);
            Matcher matcher = pattern.matcher(item);
            if (matcher.find()) {
                return matcher.group(1);
            }
            return null;
        }
        private static String extractNestedFieldValue (String item, String nestedObject, String fieldRegex){
            Pattern nestedObjectPattern = Pattern.compile("\"" + nestedObject + "\":\\{[^}]*?\\}");
            Matcher nestedObjectMatcher = nestedObjectPattern.matcher(item);
            if (nestedObjectMatcher.find()) {
                String nestedItem = nestedObjectMatcher.group();
                return extractFieldValue(nestedItem, fieldRegex);
            }
            return null;
        }

}

