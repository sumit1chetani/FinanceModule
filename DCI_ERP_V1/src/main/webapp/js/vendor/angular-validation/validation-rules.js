/**
 * angular-validation-rules (ghiscoding)
 * https://github.com/ghiscoding/angular-validation
 * 
 * @author: Ghislain B.
 * @desc: angular-validation rules definition Each rule objects must have 3
 *        properties {pattern, message, type} and in some cases you could also
 *        define a 4th properties {params} to pass extras, for example: max_len
 *        will know his maximum length by this extra {params} Rule.type can be
 *        {autoDetect, conditionalDate, conditionalNumber, match, regex}
 * 
 * WARNING: Rule patterns are defined as String type so don't forget to escape
 * your characters: \\
 */
angular.module('ghiscoding.validation').factory('validationRules', [ function() {
    // return the service object
    var service = {
        getElementValidators : getElementValidators
    };
    return service;

    // ----
    // Functions declaration
    // ----------------------------------

    /**
     * Get the element active validators and store it inside an array which will
     * be returned
     * 
     * @param object
     *            args: all attributes
     */
    function getElementValidators(args) {
        // grab all passed attributes
        var alternateText = (typeof args.altText !== "undefined") ? args.altText.replace("alt=", "") : null;
        var customUserRegEx = (args.hasOwnProperty('customRegEx')) ? args.customRegEx : null;
        var rule = (args.hasOwnProperty('rule')) ? args.rule : null;
        var ruleParams = (args.hasOwnProperty('ruleParams')) ? args.ruleParams : null;

        // validators on the current DOM element, an element can have 1+
        // validators
        var validator = {};

        switch (rule) {
        case "accepted":
            validator = {
                pattern : /^(yes|on|1|true)$/i,
                message : "INVALID_ACCEPTED",
                type : "regex"
            };
            break;
        case "alpha":
            validator = {
                pattern : /^([a-zа-яàáâãäåæçèéêëœìíïîðòóôõöøùúûñüýÿßÞďđ])+$/i,
                message : "INVALID_ALPHA",
                type : "regex"
            };
            break;
        case "alphaSpaces":
        case "alpha_spaces":
            validator = {
                pattern : /^([a-zа-яàáâãäåæçèéêëœìíïîðòóôõöøùúûñüýÿßÞďđ\s])+$/i,
                message : "INVALID_ALPHA_SPACE",
                type : "regex"
            };
            break;
        case "alphaNum":
        case "alpha_num":
            validator = {
                pattern : /^([a-zа-яàáâãäåæçèéêëœìíïîðòóôõöøùúûñüýÿßÞďđ0-9])+$/i,
                message : "INVALID_ALPHA_NUM",
                type : "regex"
            };
            break;
        case "alphaNumSpaces":
        case "alpha_num_spaces":
            validator = {
                pattern : /^([a-zа-яàáâãäåæçèéêëœìíïîðòóôõöøùúûñüýÿßÞďđ0-9\s])+$/i,
                message : "INVALID_ALPHA_NUM_SPACE",
                type : "regex"
            };
            break;
        case "alphaDash":
        case "alpha_dash":
            validator = {
                pattern : /^([a-zа-яàáâãäåæçèéêëœìíïîðòóôõöøùúûñüýÿßÞďđ0-9_-])+$/i,
                message : "INVALID_ALPHA_DASH",
                type : "regex"
            };
            break;
        case "alphaDashSpaces":
        case "alpha_dash_spaces":
            validator = {
                pattern : /^([a-zа-яàáâãäåæçèéêëœìíïîðòóôõöøùúûñüýÿßÞďđ0-9\s_-])+$/i,
                message : "INVALID_ALPHA_DASH_SPACE",
                type : "regex"
            };
            break;
        case "between":
            var ranges = ruleParams.split(',');
            if (ranges.length !== 2) {
                throw "This validation must include exactly 2 params separated by a comma (,) ex.: between:1,5";
            }
            validator = {
                patternLength : "^(.|[\\r\\n]){" + ranges[0] + "," + ranges[1] + "}$",
                messageLength : "INVALID_BETWEEN_CHAR",
                conditionNum : [ ">=", "<=" ],
                messageNum : "INVALID_BETWEEN_NUM",
                params : [ ranges[0], ranges[1] ],
                type : "autoDetect"
            };
            break;
        case "betweenLen":
        case "between_len":
            var ranges = ruleParams.split(',');
            if (ranges.length !== 2) {
                throw "This validation must include exactly 2 params separated by a comma (,) ex.: between_len:1,5";
            }
            validator = {
                pattern : "^(.|[\\r\\n]){" + ranges[0] + "," + ranges[1] + "}$",
                message : "INVALID_BETWEEN_CHAR",
                params : [ ranges[0], ranges[1] ],
                type : "regex"
            };
            break;
        case "betweenNum":
        case "between_num":
            var ranges = ruleParams.split(',');
            if (ranges.length !== 2) {
                throw "This validation must include exactly 2 params separated by a comma (,) ex.: between_num:1,5";
            }
            validator = {
                condition : [ ">=", "<=" ],
                message : "INVALID_BETWEEN_NUM",
                params : [ ranges[0], ranges[1] ],
                type : "conditionalNumber"
            };
            break;
        case "boolean":
            validator = {
                pattern : /^(true|false|0|1)$/i,
                message : "INVALID_BOOLEAN",
                type : "regex"
            };
            break;
        case "checked":
            validator = {
                pattern : /^true$/i,
                message : "INVALID_CHECKBOX_SELECTED",
                type : "regex"
            };
            break;
        case "creditCard":
        case "credit_card":
            validator = {
                pattern : /^(?:4[0-9]{12}(?:[0-9]{3})?|5[1-5][0-9]{14}|3[47][0-9]{13}|3(?:0[0-5]|[68][0-9])[0-9]{11}|6(?:011|5[0-9]{2})[0-9]{12}|(?:2131|1800|35\d{3})\d{11})$/,
                message : "INVALID_CREDIT_CARD",
                type : "regex"
            };
            break;
        case "dateEuroLong":
        case "date_euro_long":
            validator = {
                pattern : /^(0[1-9]|[12][0-9]|3[01])[-\/\.](0[1-9]|1[012])[-\/\.](19|20)\d\d$/,
                message : "INVALID_DATE_EURO_LONG",
                type : "regex"
            };
            break;
        case "dateEuroLongBetween":
        case "date_euro_long_between":
        case "betweenDateEuroLong":
        case "between_date_euro_long":
            var ranges = ruleParams.split(',');
            if (ranges.length !== 2) {
                throw "This validation must include exactly 2 params separated by a comma (,) ex.: between_date_euro_long:01-01-1990,31-12-2015";
            }
            validator = {
                condition : [ ">=", "<=" ],
                dateType : "EURO_LONG",
                params : [ ranges[0], ranges[1] ],
                pattern : /^(0[1-9]|[12][0-9]|3[01])[-\/\.](0[1-9]|1[012])[-\/\.](19|20)\d\d$/,
                message : "INVALID_DATE_EURO_LONG_BETWEEN",
                type : "conditionalDate"
            };
            break;
        case "dateEuroLongMax":
        case "date_euro_long_max":
        case "maxDateEuroLong":
        case "max_date_euro_long":
            validator = {
                condition : "<=",
                dateType : "EURO_LONG",
                params : [ ruleParams ],
                pattern : /^(0[1-9]|[12][0-9]|3[01])[-\/\.](0[1-9]|1[012])[-\/\.](19|20)\d\d$/,
                message : "INVALID_DATE_EURO_LONG_MAX",
                type : "conditionalDate"
            };
            break;
        case "dateEuroLongMin":
        case "date_euro_long_min":
        case "minDateEuroLong":
        case "min_date_euro_long":
            validator = {
                condition : ">=",
                dateType : "EURO_LONG",
                params : [ ruleParams ],
                pattern : /^(0[1-9]|[12][0-9]|3[01])[-\/\.](0[1-9]|1[012])[-\/\.](19|20)\d\d$/,
                message : "INVALID_DATE_EURO_LONG_MIN",
                type : "conditionalDate"
            };
            break;
        case "dateEuroShort":
        case "date_euro_short":
            validator = {
                pattern : /^(0[1-9]|[12][0-9]|3[01])[-\/\.](0[1-9]|1[012])[-\/\.]\d\d$/,
                message : "INVALID_DATE_EURO_SHORT",
                type : "regex"
            };
            break;
        case "dateEuroShortBetween":
        case "date_euro_short_between":
        case "betweenDateEuroShort":
        case "between_date_euro_short":
            var ranges = ruleParams.split(',');
            if (ranges.length !== 2) {
                throw "This validation must include exactly 2 params separated by a comma (,) ex.: between_date_euro_short:01-01-90,31-12-15";
            }
            validator = {
                condition : [ ">=", "<=" ],
                dateType : "EURO_SHORT",
                params : [ ranges[0], ranges[1] ],
                pattern : /^(0[1-9]|[12][0-9]|3[01])[-\/\.](0[1-9]|1[012])[-\/\.]\d\d$/,
                message : "INVALID_DATE_EURO_SHORT_BETWEEN",
                type : "conditionalDate"
            };
            break;
        case "dateEuroShortMax":
        case "date_euro_short_max":
        case "maxDateEuroShort":
        case "max_date_euro_short":
            validator = {
                condition : "<=",
                dateType : "EURO_SHORT",
                params : [ ruleParams ],
                pattern : /^(0[1-9]|[12][0-9]|3[01])[-\/\.](0[1-9]|1[012])[-\/\.]\d\d$/,
                message : "INVALID_DATE_EURO_SHORT_MAX",
                type : "conditionalDate"
            };
            break;
        case "dateEuroShortMin":
        case "date_euro_short_min":
        case "minDateEuroShort":
        case "min_date_euro_short":
            validator = {
                condition : ">=",
                dateType : "EURO_SHORT",
                params : [ ruleParams ],
                pattern : /^(0[1-9]|[12][0-9]|3[01])[-\/\.](0[1-9]|1[012])[-\/\.]\d\d$/,
                message : "INVALID_DATE_EURO_SHORT_MIN",
                type : "conditionalDate"
            };
            break;
        case "dateIso":
        case "date_iso":
            validator = {
                pattern : /^(19|20)\d\d([-])(0[1-9]|1[012])\2(0[1-9]|[12][0-9]|3[01])$/,
                message : "INVALID_DATE_ISO",
                type : "regex"
            };
            break;
        case "dateIsoBetween":
        case "date_iso_between":
        case "betweenDateIso":
        case "between_date_iso":
            var ranges = ruleParams.split(',');
            if (ranges.length !== 2) {
                throw "This validation must include exactly 2 params separated by a comma (,) ex.: between_date_iso:1990-01-01,2000-12-31";
            }
            validator = {
                condition : [ ">=", "<=" ],
                dateType : "ISO",
                params : [ ranges[0], ranges[1] ],
                pattern : /^(19|20)\d\d([-])(0[1-9]|1[012])\2(0[1-9]|[12][0-9]|3[01])$/,
                message : "INVALID_DATE_ISO_BETWEEN",
                type : "conditionalDate"
            };
            break;
        case "dateIsoMax":
        case "date_iso_max":
        case "maxDateIso":
        case "max_date_iso":
            validator = {
                condition : "<=",
                dateType : "ISO",
                params : [ ruleParams ],
                pattern : /^(19|20)\d\d([-])(0[1-9]|1[012])\2(0[1-9]|[12][0-9]|3[01])$/,
                message : "INVALID_DATE_ISO_MAX",
                type : "conditionalDate"
            };
            break;
        case "dateIsoMin":
        case "date_iso_min":
        case "minDateIso":
        case "min_date_iso":
            validator = {
                condition : ">=",
                dateType : "ISO",
                params : [ ruleParams ],
                pattern : /^(19|20)\d\d([-])(0[1-9]|1[012])\2(0[1-9]|[12][0-9]|3[01])$/,
                message : "INVALID_DATE_ISO_MIN",
                type : "conditionalDate"
            };
            break;
        case "dateUsLong":
        case "date_us_long":
            validator = {
                pattern : /^(0[1-9]|1[012])[-\/\.](0[1-9]|[12][0-9]|3[01])[-\/\.](19|20)\d\d$/,
                message : "INVALID_DATE_US_LONG",
                type : "regex"
            };
            break;
        case "dateUsLongBetween":
        case "date_us_long_between":
        case "betweenDateUsLong":
        case "between_date_us_long":
            var ranges = ruleParams.split(',');
            if (ranges.length !== 2) {
                throw "This validation must include exactly 2 params separated by a comma (,) ex.: between_date_us_long:01/01/1990,12/31/2015";
            }
            validator = {
                condition : [ ">=", "<=" ],
                dateType : "US_LONG",
                params : [ ranges[0], ranges[1] ],
                pattern : /^(0[1-9]|1[012])[-\/\.](0[1-9]|[12][0-9]|3[01])[-\/\.](19|20)\d\d$/,
                message : "INVALID_DATE_US_LONG_BETWEEN",
                type : "conditionalDate"
            };
            break;
        case "dateUsLongMax":
        case "date_us_long_max":
        case "maxDateUsLong":
        case "max_date_us_long":
            validator = {
                condition : "<=",
                dateType : "US_LONG",
                params : [ ruleParams ],
                pattern : /^(0[1-9]|1[012])[-\/\.](0[1-9]|[12][0-9]|3[01])[-\/\.](19|20)\d\d$/,
                message : "INVALID_DATE_US_LONG_MAX",
                type : "conditionalDate"
            };
            break;
        case "dateUsLongMin":
        case "date_us_long_min":
        case "minDateUsLong":
        case "min_date_us_long":
            validator = {
                condition : ">=",
                dateType : "US_LONG",
                params : [ ruleParams ],
                pattern : /^(0[1-9]|1[012])[-\/\.](0[1-9]|[12][0-9]|3[01])[-\/\.](19|20)\d\d$/,
                message : "INVALID_DATE_US_LONG_MIN",
                type : "conditionalDate"
            };
            break;
        case "dateUsShort":
        case "date_us_short":
            validator = {
                pattern : /^(0[1-9]|1[012])[-\/\.](0[1-9]|[12][0-9]|3[01])[-\/\.]\d\d$/,
                message : "INVALID_DATE_US_SHORT",
                type : "regex"
            };
            break;
        case "dateUsShortBetween":
        case "date_us_short_between":
        case "betweenDateUsShort":
        case "between_date_us_short":
            var ranges = ruleParams.split(',');
            if (ranges.length !== 2) {
                throw "This validation must include exactly 2 params separated by a comma (,) ex.: between_date_us_short:01/01/90,12/31/15";
            }
            validator = {
                condition : [ ">=", "<=" ],
                dateType : "US_SHORT",
                params : [ ranges[0], ranges[1] ],
                pattern : /^(0[1-9]|1[012])[-\/\.](0[1-9]|[12][0-9]|3[01])[-\/\.]\d\d$/,
                message : "INVALID_DATE_US_SHORT_BETWEEN",
                type : "conditionalDate"
            };
            break;
        case "dateUsShortMax":
        case "date_us_short_max":
        case "maxDateUsShort":
        case "max_date_us_short":
            validator = {
                condition : "<=",
                dateType : "US_SHORT",
                params : [ ruleParams ],
                pattern : /^(0[1-9]|1[012])[-\/\.](0[1-9]|[12][0-9]|3[01])[-\/\.]\d\d$/,
                message : "INVALID_DATE_US_SHORT_MAX",
                type : "conditionalDate"
            };
            break;
        case "dateUsShortMin":
        case "date_us_short_min":
        case "minDateUsShort":
        case "min_date_us_short":
            validator = {
                condition : ">=",
                dateType : "US_SHORT",
                params : [ ruleParams ],
                pattern : /^(0[1-9]|1[012])[-\/\.](0[1-9]|[12][0-9]|3[01])[-\/\.]\d\d$/,
                message : "INVALID_DATE_US_SHORT_MIN",
                type : "conditionalDate"
            };
            break;
        case "different":
        case "differentInput":
        case "different_input":
            var args = ruleParams.split(',');
            validator = {
                condition : "!=",
                message : "INVALID_INPUT_DIFFERENT",
                params : args,
                type : "matching"
            };
            break;
        case "digits":
            validator = {
                pattern : "^\\d{" + ruleParams + "}$",
                message : "INVALID_DIGITS",
                params : [ ruleParams ],
                type : "regex"
            };
            break;
        case "digitsBetween":
        case "digits_between":
            var ranges = ruleParams.split(',');
            if (ranges.length !== 2) {
                throw "This validation must include exactly 2 params separated by a comma (,) ex.: digits_between:1,5";
            }
            validator = {
                pattern : "^\\d{" + ranges[0] + "," + ranges[1] + "}$",
                message : "INVALID_DIGITS_BETWEEN",
                params : [ ranges[0], ranges[1] ],
                type : "regex"
            };
            break;
        case "email":
            validator = {
                // Email RFC 5322, pattern pulled from
                // http://www.regular-expressions.info/email.html
                // but removed necessity of a TLD (Top Level Domain) which makes
                // this email valid: admin@mailserver1
                pattern : /^[-\wа-яàáâãäåæçèéêëœìíïîðòóôõöøùúûñüýÿßÞďđ0-9#~!$%^&*_=+\/`\|}{\'?]+(\.[-\wа-яàáâãäåæçèéêëœìíïîðòóôõöøùúûñüýÿßÞďđ0-9#~!$%^&*_=+\/`\|}{\'?]+)*@([\wа-яàáâãäåæçèéêëœìíïîðòóôõöøùúûñüýÿßÞďđ0-9_][-\wа-яàáâãäåæçèéêëœìíïîðòóôõöøùúûñüýÿßÞďđ0-9_]*(\.[-\wа-яàáâãäåæçèéêëœìíïîðòóôõöøùúûñüýÿßÞďđ0-9_]+)*([\wа-яàáâãäåæçèéêëœìíïîðòóôõöøùúûñüýÿßÞďđ]+)|(\.[\wа-яàáâãäåæçèéêëœìíïîðòóôõöøùúûñüýÿßÞďđ]{2,6})|([0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}))(:[0-9]{1,5})?$/i,
                message : "INVALID_EMAIL",
                type : "regex"
            };
            break;
        case "exactLen":
        case "exact_len":
            validator = {
                pattern : "^(.|[\\r\\n]){" + ruleParams + "}$",
                message : "INVALID_EXACT_LEN",
                params : [ ruleParams ],
                type : "regex"
            };
            break;
        case "float":
            validator = {
                pattern : /^\d*\.{1}\d+$/,
                message : "INVALID_FLOAT",
                type : "regex"
            };
            break;
        case "twodecimalnumber":
            validator = {
                pattern : /^\d+\.\d{2}$/,
                message : "INVALID_TWO_DECIMAL",
                type : "regex"
            };
            break;
        case "threedecimalnumber":
            validator = {
                pattern : /^\d+\.\d{3}$/,
                message : "INVALID_THREE_DECIMAL",
                type : "regex"
            };
            break;

        case "floatSigned":
        case "float_signed":
            validator = {
                pattern : /^[-+]?\d*\.{1}\d+$/,
                message : "INVALID_FLOAT_SIGNED",
                type : "regex"
            };
            break;
        case "iban":
            validator = {
                pattern : /^[a-zA-Z]{2}\d{2}\s?([0-9a-zA-Z]{4}\s?){4}[0-9a-zA-Z]{2}$/i,
                message : "INVALID_IBAN",
                type : "regex"
            };
            break;
        case "in":
        case "inList":
        case "in_list":
            var list = ruleParams.replace(/,/g, '|'); // replace ',' by '|'
            validator = {
                pattern : "^(\\b(" + list + ")\\b)$",
                message : "INVALID_IN_LIST",
                params : [ ruleParams ],
                type : "regex"
            };
            break;
        case "int":
        case "integer":
            validator = {
                pattern : /^\d+$/,
                message : "INVALID_INTEGER",
                type : "regex"
            };
            break;
        case "intSigned":
        case "integerSigned":
        case "int_signed":
        case "integer_signed":
            validator = {
                pattern : /^[+-]?\d+$/,
                message : "INVALID_INTEGER_SIGNED",
                type : "regex"
            };
            break;
        case "ip":
        case "ipv4":
            validator = {
                pattern : /^(25[0-5]|2[0-4]\d|[0-1]?\d?\d)(\.(25[0-5]|2[0-4]\d|[0-1]?\d?\d)){3}$/,
                message : "INVALID_IPV4",
                type : "regex"
            };
            break;
        case "ipv6":
            validator = {
                pattern : /^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$/i,
                message : "INVALID_IPV6",
                type : "regex"
            };
            break;
        case "match":
        case "matchInput":
        case "match_input":
        case "same":
            var args = ruleParams.split(',');
            validator = {
                condition : "===",
                message : "INVALID_INPUT_MATCH",
                params : args,
                type : "matching"
            };
            break;
        case "max":
            validator = {
                patternLength : "^(.|[\\r\\n]){0," + ruleParams + "}$",
                messageLength : "INVALID_MAX_CHAR",
                conditionNum : "<=",
                messageNum : "INVALID_MAX_NUM",
                params : [ ruleParams ],
                type : "autoDetect"
            };
            break;
        case "maxLen":
        case "max_len":
            validator = {
                pattern : "^(.|[\\r\\n]){0," + ruleParams + "}$",
                message : "INVALID_MAX_CHAR",
                params : [ ruleParams ],
                type : "regex"
            };
            break;
        case "maxNum":
        case "max_num":
            validator = {
                condition : "<=",
                message : "INVALID_MAX_NUM",
                params : [ ruleParams ],
                type : "conditionalNumber"
            };
            break;
        case "min":
            validator = {
                patternLength : "^(.|[\\r\\n]){" + ruleParams + ",}$",
                messageLength : "INVALID_MIN_CHAR",
                conditionNum : ">=",
                messageNum : "INVALID_MIN_NUM",
                params : [ ruleParams ],
                type : "autoDetect"
            };
            break;
        case "minLen":
        case "min_len":
            validator = {
                pattern : "^(.|[\\r\\n]){" + ruleParams + ",}$",
                message : "INVALID_MIN_CHAR",
                params : [ ruleParams ],
                type : "regex"
            };
            break;
        case "minNum":
        case "min_num":
            validator = {
                condition : ">=",
                message : "INVALID_MIN_NUM",
                params : [ ruleParams ],
                type : "conditionalNumber"
            };
            break;
        case "notIn":
        case "not_in":
        case "notInList":
        case "not_in_list":
            var list = ruleParams.replace(/,/g, '|'); // replace ',' by '|'
            validator = {
                pattern : "^((?!\\b(" + list + ")\\b).)+$",
                message : "INVALID_NOT_IN_LIST",
                params : [ ruleParams ],
                type : "regex"
            };
            break;
        case "numeric":
            validator = {
                pattern : /^\d*\.?\d+$/,
                message : "INVALID_NUMERIC",
                type : "regex"
            };
            break;
        case "numericSigned":
        case "numeric_signed":
            validator = {
                pattern : /^[-+]?\d*\.?\d+$/,
                message : "INVALID_NUMERIC_SIGNED",
                type : "regex"
            };
            break;
        case "pattern":
        case "regex":
            // Custom User Regex is a special case, the properties (message,
            // pattern) were created and dealt separately prior to the for loop
            validator = {
                pattern : customUserRegEx.pattern,
                message : "INVALID_PATTERN",
                params : [ customUserRegEx.message ],
                type : "regex"
            };
            break;
        case "remote":
            validator = {
                message : '', // there is no error message defined on this one
                // since user will provide his own error message
                // via remote response or `alt=`
                params : [ ruleParams ],
                type : "remote"
            };
            break;
        case "required":
            validator = {
                pattern : /\S+/,
                message : "INVALID_REQUIRED",
                type : "regex"
            };
            break;
        case "size":
            validator = {
                patternLength : "^(.|[\\r\\n]){" + ruleParams + "}$",
                messageLength : "INVALID_EXACT_LEN",
                conditionNum : "==",
                messageNum : "INVALID_EXACT_NUM",
                params : [ ruleParams ],
                type : "autoDetect"
            };
            break;
        case "url":
            validator = {
                pattern : /^(http|ftp|https):\/\/[\w\-_]+(\.[\w\-_]+)+([\w\-\.,@?^=%&amp;:\/~\+#]*[\w\-\@?^=%&amp;\/~\+#])?/i,
                message : "INVALID_URL",
                type : "regex"
            };
            break;
        case "time":
            validator = {
                pattern : /^([01]?[0-9]|2[0-3]):[0-5][0-9](:[0-5][0-9])?$/,
                message : "INVALID_TIME",
                type : "regex"
            };
            break;
        case "date_picker":
            validator = {
                pattern : /^(0[1-9]|[12][0-9]|3[01])[-\/\.](0[1-9]|1[012])[-\/\.](19|20)\d\d$/,
                message : "INVALID_DATE_EURO_LONG",
                type : "regex"
            };
            break;
        } // switch()

        // add the possible alternate text user might have provided
        validator.altText = alternateText;

        return validator;
    } // getElementValidators()
} ]);