Application.$controller("MainPageController", ["$scope", function($scope) {
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
    };


    $scope.button1Tap = function($event, $isolateScope) {
        if ($scope.Widgets.text1.datavalue && $scope.Widgets.text2.datavalue) {
            $scope.Widgets.text3.datavalue = parseFloat($scope.Widgets.text1.datavalue) + parseFloat($scope.Widgets.text2.datavalue);
        }
    };


    $scope.button4Tap = function($event, $isolateScope) {

    };


    $scope.label3Tap = function($event, $isolateScope) {
        alert('Add new ?')
        debugger;
        $scope.Widgets.liveform3.new();
        alert('Added ? ')
        debugger;
    };

}]);





Application.$controller("liveform3Controller", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);