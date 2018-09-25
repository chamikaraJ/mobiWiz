Application.$controller("RegistrationPageController", ["$scope", function($scope) {
    "use strict";

    /* perform any action on widgets within this block */
    $scope.onPageReady = function() {
        /*
         * widgets can be accessed through '$scope.Widgets' property here
         * e.g. to get value of text widget named 'username' use following script
         * '$scope.Widgets.username.datavalue'
         */
    };


    $scope.button6Tap = function($event, $isolateScope) {
        debugger;
        AWSCognito.config.region = 'us-east-1'; //This is required to derive the endpoint

        var poolData = {
            UserPoolId: 'ap-southeast-2_PQlC2fDyB',
            ClientId: '2sc25122k2mpe20s6fuuvqp116'
        };
        var userPool = new AWSCognito.CognitoIdentityServiceProvider.CognitoUserPool(poolData);

        var attributeList = [];

        var dataEmail = {
            Name: 'email',
            Value: $scope.Widgets.txtEmail.datavalue
        };
        var dataPhoneNumber = {
            Name: 'phone_number',
            Value: $scope.Widgets.txtPhoneNumber.datavalue
        };
        var attributeEmail = new AWSCognito.CognitoIdentityServiceProvider.CognitoUserAttribute(dataEmail);
        var attributePhoneNumber = new AWSCognito.CognitoIdentityServiceProvider.CognitoUserAttribute(dataPhoneNumber);

        attributeList.push(attributeEmail);
        attributeList.push(attributePhoneNumber);
        userPool.signUp($scope.Widgets.txtUserName.datavalue, $scope.Widgets.pswPassword.datavalue, attributeList, null, function(err, result) {
            if (err) {
                alert(err);
                return;
            }
            var userData = {
                Username: "chamiJay",
                Pool: userPool
            };
            var cognitoUser = new AWSCognito.CognitoIdentityServiceProvider.CognitoUser(userData);
            cognitoUser = result.user;
            //Handle for On success of Signup - Navigation to Page/Verify user Page
            console.log('user name is ' + cognitoUser.getUsername());
            alert('User Created ' + cognitoUser.getUsername());
            $scope.Variables.goToPage_Login.navigate();
        });
    };

}]);