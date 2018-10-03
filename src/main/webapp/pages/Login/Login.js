Application.$controller("LoginPageController", ["$scope",
    function($scope) {
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

        $scope.loginButtonTap = function($event, $isolateScope) {
            debugger;
            //Creating  authentication data object
            var authenticationData = {
                Username: $scope.Widgets.usernametext.datavalue,
                Password: $scope.Widgets.passwordtext.datavalue
            };
            // Creating the aws cognito autheticationDetails with the authetication object
            var authenticationDetails = new AWSCognito.CognitoIdentityServiceProvider.AuthenticationDetails(authenticationData);
            var poolData = {
                UserPoolId: 'ap-southeast-2_PQlC2fDyB',
                ClientId: '2sc25122k2mpe20s6fuuvqp116'
            };
            //creating user pool object
            var userPool = new AWSCognito.CognitoIdentityServiceProvider.CognitoUserPool(poolData);
            var userData = {
                Username: $scope.Widgets.usernametext.datavalue,
                Pool: userPool
            };
            var cognitoUser = new AWSCognito.CognitoIdentityServiceProvider.CognitoUser(userData);

            //handle the new password 
            function newPasswordRequired() {
                //Write logic here
                alert("New Password Required");
                AWS.config.region = 'ap-southeast-2';
                AWS.config.credentials = new AWS.CognitoIdentityCredentials({
                    IdentityPoolId: 'ap-southeast-2:0bf0ab2c-c013-4617-be40-e587d29a1c49'
                });
            }

            //Calling aws to authenticate the user passing the details             
            cognitoUser.authenticateUser(authenticationDetails, {
                onSuccess: function(result) {
                    console.log('access token + ' + result.getAccessToken().getJwtToken());
                    /*Use the idToken for Logins Map when Federating User Pools with Cognito Identity or when passing through an Authorization Header to an API Gateway Authorizer*/
                    console.log('idToken + ' + result.idToken.jwtToken);
                    $scope.Variables.cognitoLogin.dataBinding.username = result.getAccessToken().getJwtToken();
                    $scope.Variables.cognitoLogin.dataBinding.password = result.idToken.jwtToken;
                    $scope.Variables.cognitoLogin.login();
                    $scope.Variables.goToPage_pgList.invoke();
                },

                onFailure: function(err) {
                    //Handle for Invalid User/Register User
                    debugger;
                    alert(err);
                    $scope.Variables.goToPage_Login.invoke();
                },
                newPasswordRequired: function() {
                    //Handle for New Password Required
                }

            });
        };
    }
]);

Application.$controller("loginFormController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);