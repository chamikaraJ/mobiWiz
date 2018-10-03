Application.$controller("pgListPageController", ["$scope", function($scope) {
    "use strict";

    /* perform any action on widgets/variables within this block */
    $scope.onPageReady = function() {
        /*
         * variables can be accessed through '$scope.Variables' property here
         * e.g. to get dataSet in a staticVariable named 'loggedInUser' use following script
         * $scope.Variables.loggedInUser.getData()
         *
         * widgets can be accessed through '$scope.Widgets' property here
         * e.g. to get value of text widget named 'username' use following script
         * '$scope.Widgets.username.datavalue'
         */
        alert('start');
        // $scope.Widgets.liveform1.new()
        alert('done');

    };

    ;

    $scope.HealthyOpsThingsToDoDataonResult = function(variable, data, options) {
        alert('in result');

        if (data.length == 1) {
            alert('ready');
            debugger;
            alert('Add new');
            // $scope.Variables.HealthyOpsThingsToDoData.createRecord();



        }

    };


    $scope.btnAddTap = function($event, $isolateScope) {
        $scope.$root.$emit('wm-event', 'ThingsToDoList1', 'create');
    };

}]);


Application.$controller("liveform1Controller", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);