<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

</head>
<body ng-app="springDemo">
<div class="container" style="margin-top: 30px" ng-controller="stackOverflowController">
    <div class="row">
        <div class="col-md-12">
            <div class="panel panel-default">
                <div class="panel-heading">Sites on stackoverflow</div>
                <div class="panel-body">
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th>icon</th>
                            <th>id</th>
                            <th>website</th>
                            <th>title</th>
                            <th>description</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr ng-repeat="site in websites">
                            <td>dsf </td>
                            <td>{{site.id}}</td>
                            <td>{{site.website}}</td>
                            <td>{{site.title}}</td>
                            <td>{{site.description}}</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>

</div>

<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script>
<script src="../js/main.js"></script>
</body>
</html>