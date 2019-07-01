app.controller("ForumCommentController",function($scope,$location,$http,$rootScope)
{
	
	$scope.forum={"forumid":0,"forumname":"","forumcontent":"","username":"","status":"","createDate":"","likes":0,"dislikes":0};
	$scope.forumcomment;
	$scope.comment={"commentid":0,"forumid":0,"commenttext":"","commentDate":"","username":""};
	
	function loadForum()
	{
		$http.get('http://localhost:9601/middleend/getForum/'+$rootScope.forumid)
		.then(function(response)
		{
		$scope.forum=response.data;	
		});
		
	}
	function loadforumcomments()
	{
		$http.get('http://localhost:9601/middleend/showAllForumComment/'+$rootScope.forumid)
		.then(function(response)
		{
		$scope.forumcomment=response.data;	
		});
	}
	
	$scope.addForumComment=function()
	{
		
		console.log(' i am in add comment');
		$scope.comment.forumid=$scope.forum.forumid;
		$scope.comment.username=$rootScope.user1.username;
		$http.post('http://localhost:9601/middleend/addForumComment',$scope.comment)
		.then(function(response)
		{
		loadforumcomments();
		alert('comment added');
		},
		function(errorresponse)
		{
			alert(errorresponse);	
		});
	}
	loadForum();
	loadforumcomments();
});