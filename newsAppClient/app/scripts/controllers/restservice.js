'use strict';

var path="";

angular.module('RESTService', [])
  .controller('CommentController', function ($scope, $routeParams, NewsModel) {
    var comm = this;
    var date= new Date().toLocaleDateString();
    var newsId = $routeParams.id;

    $scope.createComm = function (comment) {
      NewsModel.createComment(angular.extend({},{date:date,newsId:newsId},comment)).then(function (result) {
        initCreateComm();
        $scope.getComments();
      })
    }

    function initCreateComm() {
      comm.newComm = {comment: '',author:''};
    }

    $scope.getComments = function () {
      NewsModel.getNewsById().then(function (result) {
        $scope.comments = result.data;
      })
    }


    path = "/getCommentsByNewsId/"+newsId;
    NewsModel.getCommentsByNewsId().then(function (result) {
      $scope.comments = result.data;
      console.log($scope.comments);
    })
    $scope.getComments();
  })
  .controller('newsCrtl', function($scope, NewsModel){
    var newsDashBoard = this;
    var comm=this;
    path='/getNews';

    function getNews() {
      NewsModel.all().then(function (result) {
        newsDashBoard.news = result.data;
      })
    }

    function createNews(news) {
      var date= new Date().toLocaleDateString();
      NewsModel.create(angular.extend({},{data:date},news)).then(function (result) {

        initCreateForm();
        newsDashBoard.news=result.data;
        $scope.resultMessage = result.data;
        if (newsDashBoard.news.message == "Error"){
          $scope.showData = true;
        }else {
          $scope.showData = false;
          $scope.showOk = true;
        }
      })
    }

    function initCreateForm() {
      comm.newComm = {title:'',text:'', author:''};
    }

    newsDashBoard.news=[];
    newsDashBoard.createNews =createNews;
    getNews();
  })
  .controller('newsDisplayCtrl',function ($scope, $routeParams,NewsModel) {
  var newsId= $routeParams.id;
  path="/getNewsById/"+newsId;
  NewsModel.getNewsById().then(function (result) {
    $scope.news=result.data;
    console.log($scope.news);
  });
})
  .constant('ENDPOINT_URI', 'http://localhost:8080/api/news')
  .service('NewsModel',function ($http,ENDPOINT_URI) {

    var service = this;
    function getUrl() {
      console.log(ENDPOINT_URI+path);
      return ENDPOINT_URI+path;
    }

    service.all =function () {
      return $http.get(getUrl());
    }

    service.getNewsById = function () {
      return $http.get(getUrl());
    }

    service.getCommentsByNewsId = function () {
      return $http.get(getUrl());
    }

    service.createComment = function (comment) {
      return $http.post(getUrl(),comment);
    }

    service.create = function (news) {
      return $http.post(getUrl(),news);
    }
  })
;
