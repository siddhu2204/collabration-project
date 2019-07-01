app.controller("ChatController",function($scope,$location,$http,$rootScope,chatService)
{
console.log("starting chat controller");

$scope.messages=[];
$scope.message="";
$scope.max=140;
$scope.addMessage=function()
{
	console.log("Adding messge Method");
	chatService.send($rootScope.user1.username+":"+$scope.message);
	$scope.message="";
}
 
chatService.receive().then(null,null,function(message){
	console.log('Receive Method');
	$scope.messages.push(message);

});	
});
