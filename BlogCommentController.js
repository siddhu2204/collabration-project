app.controller("BlogCommentController",function($scope,$location,$http,$rootScope)
{
	
	$scope.blog={"blogid":0,"blogname":"","blogcontent":"","username":"","status":"","createDate":"","likes":0,"dislikes":0};
	$scope.blogcomment;
	$scope.comment={"commentid":0,"blogid":0,"commenttext":"","commentDate":"","username":""};
	
	function loadBlog()
	{
		$http.get('http://localhost:9601/middleend/getBlog/'+$rootScope.blogid)
		.then(function(response)
		{
		$scope.blog=response.data;	
		});
		
	}
	function loadblogcomments()
	{
		$http.get('http://localhost:9601/middleend/showAllBlogComment/'+$rootScope.blogid)
		.then(function(response)
		{
		$scope.blogcomment=response.data;	
		});
	}
	
	$scope.addBlogComment=function()
	{
		
		console.log(' i am in add comment');
		$scope.comment.blogid=$scope.blog.blogid;
		$scope.comment.username=$rootScope.user1.username;
		$http.post('http://localhost:9601/middleend/addBlogComment',$scope.comment)
		.then(function(response)
		{
		loadblogcomments();
		alert('comment added');
		},
		function(errorresponse)
		{
			alert(errorresponse);	
		});
	}
	loadBlog();
	loadblogcomments();
});