app.controller("FriendController",function($scope,$location,$http,$rootScope)
{
	
$scope.friend={"friendid":0,"username":"","friendusername":"","status":""};

$scope.friendlist;
$scope.pendingfriendlist;
$scope.suggestedfriendlist;
function showfriendlist()
{
console.log('I am in showing friend list');
$http.get('http://localhost:9601/middleend/showFriendList/'+$rootScope.user1.username)
.then(function(response)
		{
	
	$scope.friendlist=response.data;
		},
		function(errorresponse)
		{
			alert("error occured while showing friendlist");
		});
}
function showpendingfriendlist()
{
console.log("I am in showing pending friendlist");
$http.get('http://localhost:9601/middleend/showPendingList/'+$rootScope.user1.username)
.then(function(response)
		{
	console.log('data')
	$scope.pendingfriendlist=response.data;
	console.log(response.data)
		},
		function(errorresponse)
		{
			console.log("Error occured ");
		});
}
function showsuggestedfriendlist()
{
	console.log("i am in suggested friendlist");
	$http.get('http://localhost:9601/middleend/showSuggestedFriend/'+$rootScope.user1.username)
	.then(function(response)
	{
		$scope.suggestedfriendlist=response.data;
	},
	function(errorresponse)
	{
		alert('Error occured while showing');
	});
}
$scope.send=function(username)
{
	$scope.friend.username=$rootScope.user1.username;
	$scope.friend.friendusername=username;
	$scope.friend.status="A";
	console.log("sending request: "+ $scope.friend);
	$http.post('http://localhost:9601/middleend/sendFriendRequest',$scope.friend)
	.then(function(response)
	{
	alert("friend request sent");	
	},
	function(errorresponse)
	{
		alert("error occured while sending request");
	});
}

$scope.accept=function(friendid)
{
	
	console.log('accepting friend');
	$http.put('http://localhost:9601/middleend/acceptFriendRequest/' +friendid)
	.then(function(response)
	{
	alert("friend request accepted");	
	},
	function(errorresponse)
	{
		alert("error occured while accepting request");
	});
}
$scope.reject=function(friendid)
{
	$http.delete('http://localhost:9601/middleend/deleteFriendRequest/'+friendid)
	.then(function(response)
	{
	alert("friend request deleted");	
	},
	function(errorresponse)
	{
		alert("error occured while deleting request");
	});
}


showfriendlist();
showpendingfriendlist();
showsuggestedfriendlist();

});
