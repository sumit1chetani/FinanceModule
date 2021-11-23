(function(window, angular, undefined) {
  'use strict';
  angular.module('ngListSelect', [])
    .run(['$templateCache',
      function($templateCache) {
        var addRemoveHtml =
          "<div class='ngListSelect container' style='margin-left: 0;' ng-style='containerStyle'>" +
          "<div style='float:left; width:40%'>" +
          "<div ng-style='panelCssStyle' ng-class='panelClass' class='panel'>" +
          "<div class='panel-heading' ng-style='panelCssStyle' ng-class='panelClass'><div class='form-group'><div class='col-md-6'><strong><span ng-bind='availableText'></span></strong></div><div class='col-md-6 bar' style='padding:0px;bottom:6px;'><input class='input-sm' type='text' ng-model='searchAvailableText' placeholder='Search' style='height:28px;'/></div></div></div>" +
          "<select size='9' ng-style='dropdownStyle' style='width: 100%; vertical-align: top; color: black;' ng-model='leftMouseSelectedItems' ng-options='{{leftSelectNgOption}}' ng-dblclick='addItemsToRight()' multiple></select>" +
          "</div>" +
          "</div>" +
          "<div style='display: inline-block; width: 20%; text-align: center'>" +
          "<br/>" +
          "<button ng-click='addItemsToRight()' ng-class='buttonClass' ng-style='buttonCssStyle' class='btn' style='width:60px; height: 34px; line-height: 17px; vertical-align:middle;outline:none !important;margin-bottom:7px'><span style='font-size:25px;'>&#8594;</span>" +
          "</button>" +
          "<br/>" +
          "<button ng-click='addItemsToLeft()' ng-class='buttonClass' ng-style='buttonCssStyle' class='btn' style='width:60px; height: 34px; line-height: 17px; vertical-align:middle;outline:none !important;margin-bottom:7px'><span style='font-size:25px;'>&#8592;</span>" +
          "</button>" +
          "<br/>" +
          "<button ng-click='addAllItemsToRight()' ng-class='buttonClass' ng-style='buttonCssStyle' class='btn' style='width:60px; height: 34px; line-height: 17px; vertical-align:middle;outline:none !important;margin-bottom:7px'><span style='font-size:30px;'>&#8649;</span>" +
          "</button>" +
          "<br/>" +
          "<button ng-click='addAllItemsToLeft()' ng-class='buttonClass' ng-style='buttonCssStyle' class='btn' style='width:60px; height: 34px; line-height: 17px; vertical-align:middle;outline:none !important;margin-bottom:7px'><span style='font-size:30px;'>&#8647;</span>" +
          "</button>" +
          "<br/>" + 
          "</div>" +
          "<div style='float: right; width: 40%'>" +
          "<div ng-style='panelCssStyle' ng-class='panelClass' class='panel'>" +
          "<div class='panel-heading' ng-style='panelCssStyle' ng-class='panelClass'><div class='form-group'><div class='col-md-6'><strong><span ng-bind='selectedText'></span></strong></div><div class='col-md-6 bar' style='padding:0px;bottom:6px;'><input class='input-sm' type='text' ng-model='searchSelectedText' placeholder='Search' style='height:28px;'/></div></div></div>" +
          "<select size='9' ng-style='dropdownStyle' style='width: 100%; vertical-align: top; color: black;' id='selectedlist' ng-model='rightMouseSelectedItems' ng-options='{{rightSelectNgOption}}' ng-dblclick='addItemsToLeft()' multiple></select>" +
          "</div>" +
          "<div style='float: left; margin-left:13%;'>" + 
          "<button ng-disabled='isSelectedOptionDisabled' ng-click='addItemsToTop()' ng-class='buttonClass' ng-style='buttonCssStyle' class='btn' style='width:60px; height: 34px; line-height: 17px; outline:none !important;margin-bottom:7px;'><span style='font-size:25px;'>&#8593;</span>" +
          "</button>" +
          "</div>" +
          "<div style='float: left; margin-left:5%;'>" + 
          "<button ng-disabled='isSelectedOptionDisabled' ng-click='addItemsToDown()' ng-class='buttonClass' ng-style='buttonCssStyle' class='btn' style='width:60px; height: 34px; line-height: 17px; outline:none !important;margin-bottom:7px;'><span style='font-size:25px;'>&#8595;</span>" +
          "</button>" +
          "</div>" +
          "<div style='float: left; margin-left:5%;'>" +
          "<button ng-disabled='isSelectedOptionDisabled' title='Ascending/ Descending' ng-click='setAscendingDescendingOrder()' ng-class='buttonClass' ng-style='buttonCssStyle' class='btn' style='padding-top: 0px; border-top-width: 1px; padding-bottom: 8px; width:100%; height: 34px; line-height: 17px; outline:none !important;margin-bottom:7px;'><div ng-style='letterStyle.mainContainer' style='position:relative'><div ng-style='letterStyle.letterDarkblue' style='position:absolute;top: -3px;'>{{topLetter}}</div><div ng-style='letterStyle.letterCrimson' style='position:absolute;padding-top: 10px; padding-bottom: 0px;'>{{bottomLetter}}</div><div ng-style='letterStyle.arrow' style='padding-left: 7px;'>&#8595;</div></div>" +
          "</button>" +
          "</div>" +
          "</div>" +
          "</div>";
        $templateCache.put("ngListSelect.html", addRemoveHtml);
      }
    ])

  .directive('ngListSelect', ['$filter',
    function($filter) {
      return {
        restrict: 'E',
        replace: true,
        scope: {
          selectedListItems: "=selectedList",
          availableListItems: "=availableList",
          key: "@key",
          buttonStyle: "@buttonStyle",
          panelStyle: "@panelStyle",
          height: "@height",
          width: "@width",
          availableLabel: "@availableLabel",
          selectedLabel: "@selectedLabel"
        },
        templateUrl: 'ngListSelect.html',
        compile: function(tElem, tAttrs) {
          return {
            pre: function(scope, iElem, iAttrs) {
              scope.availableText = angular.isUndefined(scope.availableLabel) ? 'Available' : scope.availableLabel;
              scope.selectedText = angular.isUndefined(scope.selectedLabel) ? 'Selected' : scope.selectedLabel;
              scope.height = angular.isUndefined(scope.height) ? '144px' : scope.height;
              scope.width = angular.isUndefined(scope.width) ? '640px' : scope.width;
              scope.buttonStyle = angular.isUndefined(scope.buttonStyle) ? 'alpha' : scope.buttonStyle;
              scope.buttonClass = getColor(scope.buttonStyle, 'button');
              scope.panelStyle = angular.isUndefined(scope.panelStyle) ? 'alpha' : scope.panelStyle;
              scope.panelClass = getColor(scope.panelStyle, 'panel');
              scope.leftMouseSelectedItems = [];
              scope.rightMouseSelectedItems = [];
              scope.dropdownStyle = {
                height: scope.height
              };
              scope.containerStyle = {
                width: scope.width
              };
              scope.ascendingOrderFlag = true;
              scope.topLetter = 'A';
              scope.bottomLetter = 'Z';
              scope.letterStyle = {
                mainContainer:{"width":"10px","line-height":"9px"},
                letter:{"font-size":"10px","float":"left","font-weight":"600","font-family":"sans-serif"},
                letterCrimson:{"font-size":"10px","float":"left","font-weight":"600","font-family":"sans-serif", "color":"crimson"},
                letterDarkblue:{"font-size":"10px","float":"left","font-weight":"600","font-family":"sans-serif", "color":"darkblue"}, 
                arrow:{"font-size":"25px"}
              }; 

              if (scope.availableListItems[0] instanceof Object) {
            	  debugger
                scope.leftSelectNgOption = "item as item." + scope.key + " for item in availableListItems | orderBy:'" + scope.key + "' | ngListSelectFor:searchAvailableText";
                scope.rightSelectNgOption = "item as item." + scope.key + " for item  in selectedListItems | ngListSelectFor:searchSelectedText";
                scope.availableListItems = getUnique(scope.availableListItems, scope.key);
              } 
              else {
            	  debugger
                scope.leftSelectNgOption = "item as item for item in availableListItems | orderBy:'toString()' | ngListSelectFor:searchAvailableText";
                scope.rightSelectNgOption = "item as item for item in selectedListItems | ngListSelectFor:searchSelectedText";
                scope.availableListItems = getUnique(scope.availableListItems);
              }

              function getColor(colorClass, type) {
                var data = {}, color = {};
                switch (colorClass) {
                    case 'pearl':
                        type === 'button' ? (data['btn-default'] = true) : (data['panel-default'] = true);
                        break;
                    case 'blue':
                        type === 'button' ? (data['btn-primary'] = true) : (data['panel-primary'] = true);
                        break;
                    case 'alpha':
                        color = {};
                        color['background-color'] = 'hsl(193, 32%, 49%) !important';color['background-repeat'] = 'repeat-x';color['filter'] = 'progid:DXImageTransform.Microsoft.gradient(startColorstr="#b8d3da", endColorstr="#5493a4")';color['background-image'] = '-khtml-gradient(linear, left top, left bottom, from(#b8d3da), to(#5493a4))';color['background-image'] = '-moz-linear-gradient(top, #b8d3da, #5493a4)';color['background-image'] = '-ms-linear-gradient(top, #b8d3da, #5493a4)';color['background-image'] = '-webkit-gradient(linear, left top, left bottom, color-stop(0%, #b8d3da), color-stop(100%, #5493a4))';color['background-image'] = '-webkit-linear-gradient(top, #b8d3da, #5493a4)';color['background-image'] = '-o-linear-gradient(top, #b8d3da, #5493a4)';color['background-image'] = 'linear-gradient(#b8d3da, #5493a4)';color['border-color'] = '#5493a4 #5493a4 hsl(193, 32%, 41.5%)';color['color'] = '#333 !important';color['text-shadow'] = '0 1px 1px rgba(255, 255, 255, 0.49)';color['-webkit-font-smoothing'] = 'antialiased';
                        type === 'button' ? (scope.buttonCssStyle = color) : (scope.panelCssStyle = color);
                        break;
                    case 'sand':
                        color = {};
                        color['background-color'] = 'hsl(33, 32%, 49%) !important';color['background-repeat'] = 'repeat-x';color['filter'] = 'progid:DXImageTransform.Microsoft.gradient(startColorstr="#dacbb8", endColorstr="#a48054")';color['background-image'] = '-khtml-gradient(linear, left top, left bottom, from(#dacbb8), to(#a48054))';color['background-image'] = '-moz-linear-gradient(top, #dacbb8, #a48054)';color['background-image'] = '-ms-linear-gradient(top, #dacbb8, #a48054)';color['background-image'] = '-webkit-gradient(linear, left top, left bottom, color-stop(0%, #dacbb8), color-stop(100%, #a48054))';color['background-image'] = '-webkit-linear-gradient(top, #dacbb8, #a48054)';color['background-image'] = '-o-linear-gradient(top, #dacbb8, #a48054)';color['background-image'] = 'linear-gradient(#dacbb8, #a48054)';color['border-color'] = '#a48054 #a48054 hsl(33, 32%, 41.5%)';color['color'] = '#333 !important';color['text-shadow'] = '0 1px 1px rgba(255, 255, 255, 0.49)';color['-webkit-font-smoothing'] = 'antialiased';
                        type === 'button' ? (scope.buttonCssStyle = color) : (scope.panelCssStyle = color);
                        break;                                    
                    case 'olive':
                        color = {};
                        color['background-color'] = 'hsl(89, 32%, 49%) !important';color['background-repeat'] = 'repeat-x';color['filter'] = 'progid:DXImageTransform.Microsoft.gradient(startColorstr="#cadab8", endColorstr="#7ea454")';color['background-image'] = '-khtml-gradient(linear, left top, left bottom, from(#cadab8), to(#7ea454))';color['background-image'] = '-moz-linear-gradient(top, #cadab8, #7ea454)';color['background-image'] = '-ms-linear-gradient(top, #cadab8, #7ea454)';color['background-image'] = '-webkit-gradient(linear, left top, left bottom, color-stop(0%, #cadab8), color-stop(100%, #7ea454))';color['background-image'] = '-webkit-linear-gradient(top, #cadab8, #7ea454)';color['background-image'] = '-o-linear-gradient(top, #cadab8, #7ea454)';color['background-image'] = 'linear-gradient(#cadab8, #7ea454)';color['border-color'] = '#7ea454 #7ea454 hsl(89, 32%, 41.5%)';color['color'] = '#333 !important';color['text-shadow'] = '0 1px 1px rgba(255, 255, 255, 0.49)';color['-webkit-font-smoothing'] = 'antialiased';
                        type === 'button' ? (scope.buttonCssStyle = color) : (scope.panelCssStyle = color);
                        break;
                    default:
                        data[colorClass] = true;
                }
                return data;
              }

              function getUnique(array, key) {
                if (array[0] instanceof Object) {
                  var object = {};
                  for (var i = 0; i < array.length; i++){
                    object[array[i][key]] = array[i];
                  }
                  array = [];
                  for (var objKey in object) {
                    array.push(object[objKey]);
                  }
                  return array;
                } else {
                  return array.sort().filter(function(item, pos, ary) {
                    return !pos || item != ary[pos - 1];
                  });
                }
              }

              function orderSelections() {
                if (scope.selectedListItems[0] instanceof Object) {
                  scope.selectedListItems = $filter('orderBy')(scope.selectedListItems, scope.key);
                } 
                else {
                  scope.selectedListItems = $filter('orderBy')(scope.selectedListItems, 'toString()');
                }
              } 

              scope.setAscendingDescendingOrder = function() {
                if(scope.ascendingOrderFlag) {
                  scope.topLetter = 'Z';
                  scope.bottomLetter = 'A';
                  scope.ascendingOrderFlag = false;
                  if (scope.selectedListItems[0] instanceof Object) {
                    scope.selectedListItems = setOrdering(scope.key, true);
                  }
                  else { 
                    scope.selectedListItems = setOrdering('toString()', true);
                  }
                }
                else { 
                  scope.topLetter = 'A';
                  scope.bottomLetter = 'Z';
                  scope.ascendingOrderFlag = true;
                  if (scope.selectedListItems[0] instanceof Object) {
                    scope.selectedListItems = setOrdering(scope.key, false);
                  }
                  else { 
                    scope.selectedListItems = setOrdering('toString()', false);
                  }
                }
              };
              
              function setOrdering(orderVariable, reverse) {
                return $filter('orderBy')(scope.selectedListItems, orderVariable, reverse);
              }

              scope.addItemsToRight = function() {
                angular.forEach(scope.leftMouseSelectedItems, function(leftMouseSelectedItem, key) {
                  scope.selectedListItems.push(leftMouseSelectedItem);
                  angular.forEach(scope.availableListItems, function(availableListItem, index) {
                    if (scope.availableListItems[0] instanceof Object) {
                      if (availableListItem[scope.key] === leftMouseSelectedItem[scope.key]) {
                        scope.availableListItems.splice(index, 1);
                      }
                    } else {
                      if (availableListItem === leftMouseSelectedItem) {
                        scope.availableListItems.splice(index, 1);
                      }
                    }
                  });
                });
                scope.leftMouseSelectedItems = [];
                orderSelections();
                setSelectedOptionDisabledEnabled();
              };

              scope.addAllItemsToRight = function() {
                angular.forEach(scope.availableListItems, function(availableListItem, key) {
                  scope.selectedListItems.push(availableListItem);
                });
                scope.availableListItems = [];
                scope.leftMouseSelectedItems = [];
                orderSelections();
                setSelectedOptionDisabledEnabled();
              };

              scope.addItemsToLeft = function() {
                angular.forEach(scope.rightMouseSelectedItems, function(rightMouseSelectedItem, key) {
                  scope.availableListItems.push(rightMouseSelectedItem);
                  angular.forEach(scope.selectedListItems, function(selectedListItem, index) {
                    if (scope.availableListItems[0] instanceof Object) {
                      if (selectedListItem[scope.key] === rightMouseSelectedItem[scope.key]) {
                        scope.selectedListItems.splice(index, 1);
                      }
                    } else {
                      if (selectedListItem === rightMouseSelectedItem) {
                        scope.selectedListItems.splice(index, 1);
                      }
                    }
                  });
                });
                scope.rightMouseSelectedItems = [];
                setSelectedOptionDisabledEnabled();
              };

              scope.addAllItemsToLeft = function() {
                angular.forEach(scope.selectedListItems, function(selectedListItem, key) {
                  scope.availableListItems.push(selectedListItem);
                });
                scope.selectedListItems = [];
                scope.rightMouseSelectedItems = [];
                setSelectedOptionDisabledEnabled();
              };
              
              function setSelectedOptionDisabledEnabled() {
                scope.isSelectedOptionDisabled = scope.selectedListItems.length<=0;
              }

              scope.addItemsToTop = function() {
                var prevIndex = -1;
                angular.forEach(scope.rightMouseSelectedItems, function(rightMouseSelectedItem, key) {
                  var itemIndex = scope.selectedListItems.indexOf(rightMouseSelectedItem);
                  if (itemIndex - 1 === prevIndex) {
                    prevIndex = itemIndex;
                  } else if (itemIndex > 0) {
                    var itemToMove = scope.selectedListItems.splice(itemIndex, 1);
                    scope.selectedListItems.splice(itemIndex - 1, 0, itemToMove[0]);
                  }
                });
              };

              scope.addItemsToDown = function() {
                var prevIndex = scope.selectedListItems.length;
                angular.forEach(scope.rightMouseSelectedItems.concat().reverse(), function(rightMouseSelectedItem, key) {
                  var itemIndex = scope.selectedListItems.indexOf(rightMouseSelectedItem);
                  if (itemIndex + 1 === prevIndex) {
                    prevIndex = itemIndex;
                  } else if (itemIndex < scope.selectedListItems.length - 1) {
                    var itemToMove = scope.selectedListItems.splice(itemIndex, 1);
                    scope.selectedListItems.splice(itemIndex + 1, 0, itemToMove[0]);
                  }
                });
              };
              setSelectedOptionDisabledEnabled();
            }
          };
        }
      };
    }
  ]);
})(window, window.angular);