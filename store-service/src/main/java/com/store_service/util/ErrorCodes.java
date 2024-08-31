package com.store_service.util;

public enum ErrorCodes {
    ERROR_CODE_1("ERR1001", "No data found with id {}"),
	ERROR_CODE_2("ERR1002", "Unsupported media type. Please provide a valid media type for the request"),
	ERROR_CODE_3("ERR1003", "Invalid request body. Please provide valid JSON"),
	ERROR_CODE_4("ERR1004", "Unsupported HTTP method : {}"),
	ERROR_CODE_5("ERR1005", "Failed to write response body"),
    ERROR_CODE_6("ERR1006", "Invalid Status Must be 'A' or 'D'"),
	ERROR_CODE_7("ERR1007", "Failed to send push notification to device"),
    ERROR_CODE_8("ERR1008", "platformEndpointArn is null"),
	ERROR_CODE_9("ERR1009", "Please enter valid Email or proceed for user registration"),
	ERROR_CODE_10("ERR1010", "Invalid Brand ID: {}"),
	ERROR_CODE_11("ERR1011", "Invalid Service ID: {}"),
	ERROR_CODE_12("ERR1012", "Invalid Slot ID: {}"),
	ERROR_CODE_13("ERR1013", "Invalid Store ID: {}"),
	ERROR_CODE_CONSUMER_NOT_FOUND("ERR1014", "The consumer with ID {} does not exist."),
	ERROR_CODE_DEALER_NOT_FOUND("ERR1015", "The dealer with ID {} does not exist."),
	ERROR_CODE_CONSUMER_SERVICE_REQ_NOT_FOUND("ERR1016", "The consumer service request with ID {} does not exist."),
	ERROR_CODE_STORE_NOT_FOUND("ERR1017", "The store with ID {} does not exist."),
	ERROR_CODE_SERVICE_NOT_FOUND("ERR1018", "The service with ID {} does not exist."),
	ERROR_CODE_BRAND_NOT_FOUND("ERR1019", "The brand with ID {} does not exist."),
	ERROR_CODE_SLOT_NOT_FOUND("ERR1020", "The slot with ID {} does not exist."),
	ERROR_CODE_CONSUMER_SERVICE_REQ_NOT_EXIST("ERR1021", "The consumer service request does not exist."),
	ERROR_CODE_DEALER_EXISTS("ERR1022", "The dealer is already exist with the email id."),
	ERROR_CODE_CONSUMER_EXISTS("ERR1023", "The consumer is already exist with the email id."),
	ERROR_CODE_STORE_ID_ALREADY_ASSIGNED_TO_DEALER("ERR1024", "Store with id {}  is already assigned to this dealer."),
	ERROR_CODE_USER_NOT_FOUND("ERR1025", "The Consumer or Dealer with ID {} does not exist."),
	ERROR_CODE_SERVICE_ID_ALREADY_ASSIGNED_TO_DEALER("ERR1026", "Service with ID {}  is already assigned to this Dealer."),
	ERROR_CODE_SERVICE_ID_ALREADY_ASSIGNED_TO_CONSUMER("ERR1027", "Service with ID {}  is already assigned to this Consumer."),
	ERROR_CODE_DEALER_EMAIL_NOT_FOUND("ERR1028", "The dealer with Email does not exist. "),
	ERROR_CODE_INVALID_DEVICE_TOKEN("ERR1029", "Invalid device token"),
	ERROR_CODE_PLATFORM_APPL_ENDPNT_ARN_CREATION_FAILURE("ERR1030", "Failed to create platform endpoint for device token"),
	ERROR_CODE_SNS_SUBSCRIPTION_FAILURE("ERR1031", "Failed to subscribe to SNS topic"),
	ERROR_CODE_SNS_PUBLISH_FAILURE("ERR1032", "Failed to publish notification to device"),
	ERROR_CODE_SNS_TOPIC_CREATION_FAILURE("ERR1033", "Failed to create SNS topic"),
	ERROR_CODE_DEALER_NOT_FOUND_WITH_CRITERIA("ERR1034", "No dealers found for the provided criteria"),
	ERROR_CODE_CONSUMER_BRAND_NOT_FOUND("ERR1035", "The requested brand is not associated with the consumer"),
	ERROR_CODE_NO_DEALERS_FOUND_FOR_BRAND("ERR1036", "No dealers found for the provided Brand"),
	ERROR_CODE_CONSUMER_SRV_REQ_NOT_FOUND("ERR1037", "No service requests found for you"),
	ERROR_CODE_DEALER_SRV_REQ_NOT_FOUND("ERR1038", "No service requests found for you"),
	ERROR_CODE_IOS_PAYLOAD("ERR1039", "Failed to build iOS payload"),
	ERROR_CODE_ANDROID_PAYLOAD("ERR1040", "Failed to build Android payload"),
	ERROR_CODE_CONSUMER_NOT_EXISTS("ERR1041", "The consumer does not exists with this email. "),
	ERROR_CODE_DEALER_NOT_EXISTS("ERR1042", "The dealer does not exists with this email. "),
	ERROR_CODE_CONSUMER_SERVICE_REQ_ALREADY_ACCEPTED("ERR1043", "This request has already been accepted by another dealer.");

	
	private String errorId;
    private String errorMessage;

    ErrorCodes(String errorId, String errorMessage) {
        this.errorId = errorId;
        this.errorMessage = errorMessage;
    }

    public String getErrorId() {
        return errorId;
    }

    public String getErrorMessage(String fieldName) {
        return errorMessage.replace("{}", fieldName);
    }
    public String getErrorMessage() {
        return errorMessage;
    }
    public String getErrorMessage(String fieldName1, String fieldName2) {
    	 return errorMessage.replaceFirst("\\{\\}", fieldName1).replaceFirst("\\{\\}", fieldName2);
    }
    
    public static String getErrorIdByErrorMessage(String errorMessage, String fieldName) {
    	
        for (ErrorCodes errorCode : ErrorCodes.values()) {
            if (errorMessage.equals(errorCode.getErrorMessage(fieldName))) {
                return errorCode.getErrorId();
            }
        }
        return "";
    }
}

