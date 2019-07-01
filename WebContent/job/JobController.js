app.controller("JobController",function($scope,$location,$http,$rootScope)
{
$scope.job={"jobid":0,"jobdesignation":"","ctc":0,"companyname":"","location":"","lastdatetoapply":"","skills":""};
$scope.jobs;

$scope.publishJob=function()
{
console.log('I am in publish job');
console.log($scope.job);
$http.post('http://localhost:9601/middleend/publishJob',$scope.job)
.then(function(response)
{
	alert("job is published");
},
function(errorresponse)
{

	alert("error in publishing job");
	
});
}
function showJobs()
{
$http.get('http://localhost:9601/middleend/showAllJobs')
.then(function(response)
{
	$scope.jobs=response.data;
	console.log($scope.jobs);
},
function(errorresponse)
{
	alert('Error occured while showing jobs')
});
}
showJobs();
});