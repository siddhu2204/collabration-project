app.controller("UserController",function($scope,$location,$http,$rootScope,$cookieStore)
		{
	
	
	$scope.UserDetail={"username":"","password":"","memberName":"","emailid":"","role":"","status":"","isonline":""};
	$rootScope.user1;
	$scope.checkUser=function()
	{
		$http.post('http://localhost:9601/middleend/checkUser',JSON.stringify($scope.UserDetail))
		.then(function(response)
				{
				console.log('logged in');
				console.log(response.data);
				$rootScope.user1=response.data;
				console.log($rootScope.user1);
				$cookieStore.put('UserDetail', response.data);
				$location.path("/userHome");
				},
				function response()
				{
					console.log('error');
					$scope.error="Login Credential does not match";
					$location.path("/login");
					
				});

	}
	$scope.register=function(){
		$scope.UserDetail.role="user";
		$scope.UserDetail.status="Y";
		$scope.UserDetail.isonline="N";
		console.log($scope.UserDetail);
	
		$http.post('http://localhost:9601/middleend/registerUser',JSON.stringify($scope.UserDetail)).then(function(response){
			console.log('user registered');
			console.log(response.data);
				
		},
		function(errresponse)
		{
			console.log('error occured during registration');
			$scope.error="error occured while registering";
			//$location.path("/register");
			
			
		}
		);
	
	}
	
	$scope.logout=function()
	{
		console.log('Logging out');
		delete $rootScope.user1;
		$cookieStore.remove('user1');
		alert("Logged Out");
		$location.path("/login");
	}
			});	
		

		
	