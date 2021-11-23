app.directive('stateBreadcrumbs', function($rootScope, $state) {
    return {
        restrict : 'E',
        replace : true,
        template : '<ol class="breadcrumb inline-block padding-left-0"></ol>',
        link : function(scope, element) {

            function setBreadcrumbs(breadcrumbs) {
                var html = '';
                angular.forEach(breadcrumbs, function(crumb) {
                    html += '<li>' + crumb + '</li>'
                });
                element.html(html)
            }

            function fetchBreadcrumbs(stateName, breadcrunbs) {

                var state = $state.get(stateName);

                if (state && state.data && state.data.title && breadcrunbs.indexOf(state.data.title) == -1) {
                    var urlValue = '<a1>' + state.data.title + '</a1>';
                    if (state.url !== undefined) {
                        urlValue = '<a1 href="#' + state.url + '">' + state.data.title + '</a1>';
                    }

                    breadcrunbs.unshift(urlValue)
                }

                var parentName = stateName.replace(/.?\w+$/, '');
                if (parentName) {
                    return fetchBreadcrumbs(parentName, breadcrunbs);
                } else {
                    return breadcrunbs;
                }
            }

            function processState(state) {

                var breadcrumbs;
                if (state.data && state.data.breadcrumbs) {
                    breadcrumbs = state.data.breadcrumbs;
                } else {

                    breadcrumbs = fetchBreadcrumbs(state.name, []);
                }
                setBreadcrumbs(breadcrumbs);
            }

            processState($state.current);

            $rootScope.$on('$stateChangeStart', function(event, state) {
                processState(state);
            })
        }
    }
});