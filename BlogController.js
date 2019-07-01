app.controller("BlogController",function($scope,$location,$http,$rootScope)
{
	$scope.blogdata;
	$rootScope.blogid;

$scope.blog={"blogid":0,"blogname":"","blogcontent":"","username":"","status":"","createDate":"","likes":0,"dislikes":0};


$scope.addBlog=function()
{
$scope.blog.username=$rootScope.user1.username;
$http.post('http://localhost:9601/middleend/addBlog',$scope.blog)
.then(function(response)
{
	console.log('Added the blog');
	alert('blogadded');
	$location.path("/addBlog");
},
function(errorresponse)
{	
console.log('Error occured while adding the blog');
alert('Error');
$location.path("/addBlog");
});
}
function blogList()
{
console.log('list blog method');
$http.get('http://localhost:9601/middleend/showAllBlogs/')
.then(function(response)
{
console.log('showing all blogs');
$scope.blogdata=response.data;

},
function(errorresponse)
{
console.log('error occured');	
});
}
$scope.incrementlikes=function(blogid)
{
console.log('incrementing likes');
$http.get('http://localhost:9601/middleend/incrementLikes/'+blogid)
.then(function(response)
{
blogList();
$location.path("/showBlog");
});
}
$scope.incrementdislikes=function(blogid)
{
console.log('incrementing dislikes');
$http.get('http://localhost:9601/middleend/incrementdisLikes/'+blogid)
.then(function(response)
{
blogList();
$location.path("/showBlog");
});
}
$scope.deleteblog=function(blogid)
{
console.log('deleting the blog');
$http.delete('http://localhost:9601/middleend/deleteBlog/'+blogid)
.then(function(response)
{
blogList();
alert('blog deleted');
$location.path("/showBlog");
},
function(errorresponse)
{
	console.log('error occured while deleting');
	alert('error occured');
});
}
$scope.approveblog=function(blogid)
{
	
console.log('Approve blog');
$http.get('http://localhost:9601/middleend/approveBlog/'+blogid)
.then(function(response)
{
blogList();
alert('blog approved');
$location.path("/adminBlog");
},
function(errorresponse)
{
	
	console.log('error occured');
	alert('blog not approved');
});	
}
$scope.rejectblog=function(blogid)
{
	
console.log('Reject blog');
$http.get('http://localhost:9601/middleend/rejectBlog/'+blogid)
.then(function(response)
{
blogList();
alert('blog rejectes');
$location.path("/adminBlog");
},
function(errorresponse)
{
	
	console.log('error occured');
	alert('blog not rejected');
});	
}




$scope.editBlog=function(blogid)
{
console.log('editing the blog');
$rootScope.blogid=blogid;
console.log('Rootscope blogid' +$rootScope.blogid);
$location.path("/updateBlog");
}
function getBlog()
{
	$http.get('http://localhost:9601/middleend/getBlog/'+$rootScope.blogid)
	.then(function(response)
	{
	$scope.blog=response.data;	
	});

}
$scope.updateBlog=function()
{
console.log('i am in update blog');
$http.put('http://localhost:9601/middleend/updateBlog/',$scope.blog)
.then(function(response)
{
	alert('blog is updated');
},
function(errorresponse)
{
	alert('error occured');
});		
}

$scope.showcomment=function(blogid)
{
console.log('i am in show comment');
$rootScope.blogid=blogid;
$location.path("/showBlogComment");
}
getBlog();
blogList();

});