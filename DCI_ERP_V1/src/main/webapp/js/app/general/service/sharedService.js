'use strict';
app.service('sharedProperties', function() {

    var objectValue = {};

    var errorObjectValue = {};

    return {
        getObject : function() {
            return objectValue;
        },

        setObject : function(value) {
            objectValue = value;
        },

        getErrorObject : function() {
            return errorObjectValue;
        },

        setErrorObject : function(value) {
            errorObjectValue = value;
        },

        clearObject : function() {
            for ( var member in errorObjectValue) {
                delete errorObjectValue[member];
            }
        }
    };

});


app.service('VesselArrivalSearchService', function() {
    var objectValue = {};

    return {
        getObject : function() {
            return objectValue;
        },

        setObject : function(value) {
            objectValue = value;
        }
    };

});

app.service('VesselDepatureSearchService', function() {
    var objectValue = {};

    return {
        getObject : function() {
            return objectValue;
        },

        setObject : function(value) {
            objectValue = value;
        }
    };

});

app.service('AGFService', function() {
    var objectValue = {};

    return {
        getObject : function() {
            return objectValue;
        },

        setObject : function(value) {
            objectValue = value;
        }
    };

});

app.service('QuotationService', function() {
    var objectValue = {};

    return {
        getObject : function() {
            return objectValue;
        },

        setObject : function(value) {
            objectValue = value;
        }
    };

});
app.service('TransQuotService', function() {
    var objectValue = {};

    return {
        getObject : function() {
            return objectValue;
        },

        setObject : function(value) {
            objectValue = value;
        }
    };

});
app.service('disbursementService', function() {
    var objectValue = {};

    return {
        getObject : function() {
            return objectValue;
        },

        setObject : function(value) {
            objectValue = value;
        }
    };

});

app.service('getProperties', function() {
    var objectValue = {};

    return {
        getObject : function() {
            return objectValue;
        },

        setObject : function(value) {
            objectValue = value;
        }
    };

});
app.service('LoadingSummaryErrorService', function() {
    this.errorName = function(errorCode) {
        switch (errorCode) {
        case 'ETDdateexpired':
            return "It has been more than 7 days from ETD for this port. Hence, please get assisted by Operations Manager";
            break;
        case 'voyageclose':
            return "This voyage is closed in closing Accounts.";
            break;
        case 'portrights':
            return "You have no rights to view the record";
            break;
        case 'aprvedaft48hrs':
            return "Either loading approved OR Invoice generated for this pol, check with finance dept";
            break;
        case 'notModify':
            return "Record cannot be modified, it is already approved";
            break;
        case 'notDel':
            return "Record cannot be deleted, it is already approved";
            break;
        case 'listEmpty':
            return "No Booking Request Matches for the corresponding Details";
            break;
        case 'listEmpty1':
            return "Loading has been finalized for the corresponding Details ";
            break;
        case 'checkLoadingno':
            return "Please add the bookings to loadings for this POL and Voyage then try approving the same.";
            break;
        case 'SalingDateExpired':
            return "It has been more than 30 days from Sailing date for this port. Hence, please get assisted by Operations Manager.";
            break;
        case 'CheckApprove':
            return "Approve date should be after the Sailing date";
            break;
        case 'access.denied.message2':
            return "Access Denied. You are not authorized to view this page. Please contact your system administrator";
            break;
        case 'RecordsEmpty':
            return "No Records Found";
            break;
        case 'ErroronDelete':
            return "Data Not Deleted,Contact Administrator!";
            break;
        case 'data.arrivalrpt':
            return "There is no arrival report for this pol";
            break;
        case 'data.departurerpt':
            return "There is no departure report for this pol";
            break;
        case 'charterHire':
            return "There is no valid charter hire for the period mentioned as Sailing Date";
            break;
        case 'data.UnlockedDateAlert':
            return "It has been more than 24 hours from Unlocked date for this port. Hence, please get assisted by Operations Manager.";
            break;
        default:
            return errorCode;
            break;
        }
    };

    this.errorCodes = function(errorList) {
        var errorCode = "";
        angular.forEach(errorList, function(value, key) {
            errorCode = value;
        });
        return errorCode;
    }
});

app.factory('flsPolPodObject', function() {
    var polPodObjectValue = {};

    return {
        getPortObject : function() {
            return polPodObjectValue;
        },

        setPortObject : function(value) {
            polPodObjectValue = value;
        }
    };

});
