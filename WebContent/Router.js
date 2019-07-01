var app=angular.module("MyApp",["ngRoute","ngCookies"]);
app.config(function($routeProvider)
{
$routeProvider.when("/login",{templateUrl:"user/Login.html"})
$routeProvider.when("/register",{templateUrl:"user/Register.html"})
$routeProvider.when("/userHome",{templateUrl:"Home/UserHome.html"})
//$routeProvider.when("/myCarousel",{templateUrl:"Home/UserHome.html"})
$routeProvider.when("/aboutus",{templateUrl:"Home/AboutUs.html"})
$routeProvider.when("/profileUpdate",{templateUrl:"user/ProfileUpload.html"})
$routeProvider.when("/addBlog", {templateUrl:"c_blog/AddBlog.html"})
$routeProvider.when("/showBlog",{templateUrl:"c_blog/ShowBlog.html"})
$routeProvider.when("/ManageBlog",{templateUrl:"c_blog/ManageBlog.html"})
$routeProvider.when("/updateBlog",{templateUrl:"c_blog/UpdateBlog.html"})
$routeProvider.when("/showBlogComment",{templateUrl:"c_blog/BlogComment.html"})
$routeProvider.when("/addForum", {templateUrl:"Forum/AddForum.html"})
$routeProvider.when("/showForum",{templateUrl:"Forum/ShowForum.html"})
$routeProvider.when("/ManageForum",{templateUrl:"Forum/ManageForum.html"})
$routeProvider.when("/updateForum",{templateUrl:"Forum/UpdateForum.html"})
$routeProvider.when("/showForumComment",{templateUrl:"Forum/ForumComment.html"})
$routeProvider.when("/friend",{templateUrl:"friend/Friend.html"})
$routeProvider.when("/chat",{templateUrl:"chat/Chat1.html"})
$routeProvider.when("/ManageJob",{templateUrl:"job/ManageJob.html"})
$routeProvider.when("/showJob",{templateUrl:"job/ShowJob.html"});
});

app.run(function($rootScope,$cookieStore)
{
console.log('I am in run function');
if($rootScope.user1==undefined)
	{
	$rootScope.user1=$cookieStore.get('UserDetail');
	}
});