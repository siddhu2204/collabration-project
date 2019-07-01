app.controller("ForumController",function($scope,$location,$http,$rootScope)
{
	$scope.forumdata;
	$rootScope.forumid;

$scope.forum={"forumid":0,"forumname":"","forumcontent":"","username":"","status":"","createDate":"","likes":0,"dislikes":0};


function forumList()
{
console.log('list forum method');
$http.get('http://localhost:9601/middleend/showAllForum')
.then(function(response)
{
console.log('showing all forums');
$scope.forumdata=response.data;

},
function(errorresponse)
{
console.log('error occured');	
});
}

$scope.incrementlikes=function(forumid)
{
console.log('incrementing likes');
$http.get('http://localhost:9601/middleend/incrementlikes/'+forumid)
.then(function(response)
{
forumList();
$location.path("/showForum");
});
}
$scope.incrementdislikes=function(forumid)
{
console.log('incrementing dislikes');
$http.get('http://localhost:9601/middleend/incrementdislikes/'+forumid)
.then(function(response)
{
forumList();
$location.path("/showForum");
});
}
$scope.addForum=function()
{
$scope.forum.username=$rootScope.user1.username;
$http.post('http://localhost:9601/middleend/addForum',$scope.forum)
.then(function(response)
{
	console.log('Added the forum');
	alert('forumadded');
	$location.path("/addForum");
},
function(errorresponse)
{	
console.log('Error occured while adding the forum');
alert('Error');
$location.path("/addForum");
});
}

$scope.approveforum=function(forumid)
{
	
console.log('Approve forum');
$http.get('http://localhost:9601/middleend/approveForum/'+forumid)
.then(function(response)
{
forumList();
alert('forum approved');
$location.path("/adminForum");
},
function(errorresponse)
{
	
	console.log('error occured');
	alert('forum not approved');
});	
}

$scope.rejectforum=function(forumid)
{
	
console.log('Reject forum');
$http.get('http://localhost:9601/middleend/rejectForum/'+forumid)
.then(function(response)
{
forumList();
alert('forum rejected');
$location.path("/adminForum");
},
function(errorresponse)
{
	
	console.log('error occured');
	alert('forum not rejected');
});	
}


$scope.deleteforum=function(forumid)
{
console.log('deleting the forum');
$http.delete('http://localhost:9601/middleend/deleteForum/'+forumid)
.then(function(response)
{
forumList();
alert('forum deleted');
$location.path("/showForum");
},
function(errorresponse)
{
	console.log('error occured while deleting');
	alert('error occured');
});
}


$scope.editForum=function(forumid)
{
console.log('editing the forum');
$rootScope.forumid=forumid;
console.log('Rootscope forumid' +$rootScope.forumid);
$location.path("/updateForum");
}
function getForum()
{
	$http.get('http://localhost:9601/middleend/getForum/'+$rootScope.forumid)
	.then(function(response)
	{
	$scope.forum=response.data;	
	});

}
$scope.updateForum=function()
{
console.log('i am in update forum');
$http.put('http://localhost:9601/middleend/updateForum/',$scope.forum)
.then(function(response)
{
	alert('forum is updated');
},
function(errorresponse)
{
	alert('error occured');
});		
}

$scope.showcomment=function(forumid)
{
console.log('i am in show comment');
$rootScope.forumid=forumid;
$location.path("/showForumComment");
}
getForum();
forumList();

});