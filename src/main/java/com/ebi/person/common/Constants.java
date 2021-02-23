package com.ebi.person.common;

/**
 * Constants for audience insight classes.
 */
public final class Constants {

    /**
     * Private constructor.
     */
    private Constants() {
        // Prohibit instantiation.
    }

    /**
     * Bean name constants.
     */
    public class BeanName {

        /**
         * S3 export service.
         */
        public static final String S3_EXPORT_SERVICE = "s3ExportService";

        /**
         * BlueKai export service.
         */
        public static final String BLUEKAI_EXPORT_SERVICE = "bluekaiExportService";

        /**
         * Private constructor.
         */
        private BeanName() {
            // Prohibit instantiation.
        }
    }

    /**
     * Common constants.
     */
    public class Common {

        /**
         * Default UTC timezone.
         */
        public static final String DEFAULT_UTC_TIMEZONE = "UTC";

        /**
         * Comma delimiter.
         */
        public static final String DELIM_COMMA = ",";

        /**
         * Colon delimiter.
         */
        public static final String DELIM_COLON = ":";

        /**
         * Private constructor.
         */
        private Common() {
            // Prohibit instantiation.
        }
    }

    /**
     * Model support constants.
     */
    public class ModelSupport {

        /**
         * Page parameters.
         */
        public static final String PAGE_PARAMETERS = "pageParameters";

        /**
         * Sort parameters.
         */
        public static final String SORT_PARAMETERS = "sortParameters";

        /**
         * Search parameters.
         */
        public static final String SEARCH_PARAMETERS = "searchParameters";

        /**
         * Private constructor.
         */
        private ModelSupport() {
            // Prohibit instantiation.
        }
    }

    /**
     * Http metric names.
     */
    public class HttpMetricName {

        /**
         * HTTP status 400.
         */
        public static final String HTTP_400_METRIC_NAME = "http.audienceinsight.requests.400";

        /**
         * HTTP status 200.
         */
        public static final String HTTP_405_METRIC_NAME = "http.audienceinsight.requests.405";

        /**
         * HTTP status 500.
         */
        public static final String HTTP_500_METRIC_NAME = "http.audienceinsight.requests.500";

        /**
         * HTTP status 200.
         */
        public static final String HTTP_200_SEGMENT_METRIC_NAME = "http.audienceinsight.segment.requests.200";

        /**
         * HTTP status 201.
         */
        public static final String HTTP_201_SEGMENT_METRIC_NAME = "http.audienceinsight.segment.requests.201";

        /**
         * HTTP status 204.
         */
        public static final String HTTP_204_SEGMENT_METRIC_NAME = "http.audienceinsight.segment.requests.204";

        /**
         * HTTP status 400.
         */
        public static final String HTTP_400_SEGMENT_METRIC_NAME = "http.audienceinsight.segment.requests.400";

        /**
         * HTTP status 404.
         */
        public static final String HTTP_404_SEGMENT_METRIC_NAME = "http.audienceinsight.segment.requests.404";

        /**
         * HTTP status 409.
         */
        public static final String HTTP_409_SEGMENT_METRIC_NAME = "http.audienceinsight.segment.requests.409";

        /**
         * HTTP status 200.
         */
        public static final String HTTP_200_SEGMENT_EXPORT_HISTORY_METRIC_NAME = "http.audienceinsight.segment.export.history.requests.200";

        /**
         * HTTP status 201.
         */
        public static final String HTTP_201_SEGMENT_EXPORT_HISTORY_METRIC_NAME = "http.audienceinsight.segment.export.history.requests.201";

        /**
         * HTTP status 400.
         */
        public static final String HTTP_400_SEGMENT_EXPORT_HISTORY_METRIC_NAME = "http.audienceinsight.segment.export.history.requests.400";

        /**
         * HTTP status 409.
         */
        public static final String HTTP_409_SEGMENT_EXPORT_HISTORY_METRIC_NAME = "http.audienceinsight.segment.export.history.requests.409";
     
        /**
         * HTTP status 200.
         */
        public static final String HTTP_200_VALID_DATE_METRIC_NAME = "http.audienceinsight.valid_date.requests.200";

        /**
         * HTTP status 201.
         */
        public static final String HTTP_201_VALID_DATE_METRIC_NAME = "http.audienceinsight.valid_date.requests.201";

        /**
         * HTTP status 204.
         */
        public static final String HTTP_204_VALID_DATE_METRIC_NAME = "http.audienceinsight.valid_date.requests.204";

        /**
         * HTTP status 400.
         */
        public static final String HTTP_400_VALID_DATE_METRIC_NAME = "http.audienceinsight.valid_date.requests.400";

        /**
         * HTTP status 404.
         */
        public static final String HTTP_404_VALID_DATE_METRIC_NAME = "http.audienceinsight.valid_date.requests.404";

        /**
         * HTTP status 409.
         */
        public static final String HTTP_409_VALID_DATE_METRIC_NAME = "http.audienceinsight.valid_date.requests.409";

        /**
         * Private constructor.
         */
        private HttpMetricName() {
            // Prohibit instantiation.
        }
    }

    /**
     * Field constants.
     */
    public class Field {

        /**
         * Column "label".
         */
        public static final String LABEL = "label";

        /**
         * Column "max_value".
         */
        public static final String VALUE = "value";

        public static final String MAPPING = "mapping";


        /**
         * Private constructor.
         */
        private Field() {
            // Prohibit instantiation.
        }

    }

    /**
     * Segment constants.
     */
    public class Segment {

        /**
         * Comma delimiter.
         */
        public static final String DELIM_COMMA = ",";

        /**
         * The 'createdBy' field.
         */
        public static final String CREATED_BY = "createdBy";

        /**
         * The 'updatedBy' field.
         */
        public static final String UPDATED_BY = "updatedBy";

        /**
         * The 'updatedBy' field.
         */
        public static final String CREATION_INSTANT = "creationInstant";

        /**
         * The 'expirationInstant' field.
         */
        public static final String EXPIRATION_INSTANT = "expirationInstant";

        /**
         * The 'name' field.
         */
        public static final String NAME = "name";

        /**
         * The 'exportName' field.
         */
        public static final String EXPORT_NAME = "exportName";

        /**
         * The 'exportStatusSendTo' field.
         */
        public static final String EXPORT_STATUS_SEND_TO = "exportStatusSendTo";

        /**
         * The 'id' field.
         */
        public static final String ID = "id";

        /**
         * The 'apiQuery' field.
         */
        public static final String API_QUERY = "apiQuery";

        /**
         * The 'cron' field.
         */
        public static final String CRON = "cron";

        /**
         * The 'timeZone' field.
         */
        public static final String TIMEZONE = "timeZone";

        /**
         * The 'schedule.destination' field.
         */
        public static final String SCHEDULE_DESTINATION = "schedule.destination";

        /**
         * The 'schedule.cron' field.
         */
        public static final String SCHEDULE_CRON = "schedule.cron";

        /**
         * The 'schedule.timeZone' field.
         */
        public static final String SCHEDULE_TIMEZONE = "schedule.timeZone";

        /**
         * Group name under which segments jobs are scheduled.
         */
        public static final String SEGMENT_JOB_GROUP_NAME = "audienceinsight-segment-jobs";
        
        /**
         * Group name under which delay segments jobs are scheduled.
         */
        public static final String DELAY_SEGMENT_JOB_GROUP_NAME = "audienceinsight-delay-segment-jobs";
        
        /**
         * Group name under which delay segments jobs are scheduled.
         */
        public static final String IMMEDIATE_DELAY_SEGMENT_JOB_GROUP_NAME = "audienceinsight-immediate-delay-segment-jobs";

        /**
         * Segment expiry notification job name.
         */
        public static final String SEGMENT_EXPIRY_NOTIFICATION_JOB = "segment-expiry-notification";

        /**
         * Segment expiry email subject format.
         */
        public static final String SEGMENT_EXPIRY_EMAIL_SUBJECT_FORMAT = "segmentExpiryEmailSubjectFormat";

        /**
         * Segment expiry email subject format.
         */
        public static final String SEGMENT_EXPIRY_EMAIL_BODY_FORMAT = "segmentExpiryEmailBodyFormat";

        /**
         * Segment extend url.
         */
        public static final String SEGMENT_EXTEND_EXPIRY_URL_FORMAT = "segmentExtendExpiryUrlFormat";

        /**
         * Audience insight UI Url.
         */
        public static final String AUDIENCE_INSIGHTS_UI_URL = "audienceInsightUIUrl";

        /**
         * Segment expiration instant advance hours.
         */
        public static final String SEGMENT_EXPIRATION_NOTIFICATION_ADVANCE_HOURS = "segmentExpiryNotificationAdvanceHours";

        /**
         * Segment expiration job run interval in seconds.
         */
        public static final String SEGMENT_EXPIRY_NOTIFICATION_INTERVAL_IN_SECONDS = "segmentExpiryNotificationIntervalInSeconds";

        /**
         * Segment ID.
         */
        public static final String SEGMENT_ID = "segmentId";
        
        /**
         * Export Attributes.
         */
        public static final String EXPORT_ATTRIBUTES = "exportAttributes";
        
        /**
         * Export Attribute Type.
         */
        public static final String EXPORT_ATTRIBUTE_TYPE = "exportAttributeType";

        /**
         * Segment exported instant.
         */
        public static final String EXPORTED_INSTANT = "exportedInstant";

        /**
         * The 'includeUrl' field.
         */
        public static final String INCLUDE_URL = "includeUrl";

        /**
         * Segment run time.
         */
        public static final String FILTERS = "filters";

        /**
         * Count of exported user ID's.
         */
        public static final String EXPORTED_USER_COUNT = "exportedUserCount";

        /**
         * Export type.
         */
        public static final String EXPORT_DESTINATION = "exportDestination";
        
        
        /**
         * Schedule type.
         */
        public static final String SCHEDULE_TYPE = "scheduleType";

        /**
         * Export action.
         */
        public static final String EXPORT_ACTION = "exportAction";

        /**
         * Status.
         */
        public static final String STATUS = "status";

        /**
         * Error.
         */
        public static final String ERROR = "error";

        /**
         * Search parameter 'createdBy'.
         */
        public static final String CREATED_BY_PARAM = "createdBy";

        /**
         * Search parameter 'name'.
         */
        public static final String NAME_PARAM = "name";

        /**
         * Search parameter 'segmentName'.
         */
        public static final String SEGMENT_NAME_PARAM = "segmentName";

        /**
         * The 'category' field.
         */
        public static final String CATEGORY_NAME = "categoryName";

        /**
         * The 'rules' field.
         */
        public static final String RULES = "rules";

        /**
         * The 'bluekaiSiteId' field.
         */
        public static final String BLUEKAI_SITE_ID = "bluekaiSiteId";

        /**
         * The 'destination' field.
         */
        public static final String DESTINATION = "destination";
        
        /**
         * Start Date field
         */
        public static final String STARTDATE = "startDate";
        
        /**
         * End Date field
         */
        public static final String ENDDATE = "endDate";
        
        /**
         * The swid field 
         */
        public static final String SWID = "swid";
        
        /**
         * The device_id field
         */
        public static final String DEVICE_ID = "device_id";
        


        /**
         * Private constructor.
         */
        private Segment() {
            // Prohibit instantiation.
        }

    }

}
