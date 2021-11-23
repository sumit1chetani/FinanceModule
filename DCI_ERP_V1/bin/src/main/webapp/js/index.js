//angular.module('app', [ 'tc.chartjs' ]);


// bar charts
app.controller('BarController', function($scope) {
	$scope.chartData = {
		labels : [ "January", "February", "March", "April", "May", "June",
				"July" ],
		datasets : [ {
			label : "My First Dataset",
			backgroundColor : [ 'rgba(255, 99, 132, 0.5)',
					'rgba(54, 162, 235, 0.5)', 'rgba(255, 206, 86, 0.5)',
					'rgba(75, 192, 192, 0.5)', 'rgba(153, 102, 255, 0.5)',
					'rgba(255, 159, 64, 0.5)', 'rgba(255, 99, 132, 0.5)', ],
			borderColor : [ 'rgba(255,99,132,1)', 'rgba(54, 162, 235, 1)',
					'rgba(255, 206, 86, 1)', 'rgba(75, 192, 192, 1)',
					'rgba(153, 102, 255, 1)', 'rgba(255, 159, 64, 1)',
					'rgba(255,99,132,1)', ],
			borderWidth : 1,
			data : [ 55, 57, 54, 55, 59, 53, 56 ],
		} , {
			backgroundColor : [ 'rgba(255, 99, 172, 0.5)',
					'rgba(54, 162, 235, 0.5)', 'rgba(255, 206,66, 0.5)',
					'rgba(75, 192, 192, 0.5)', 'rgba(153, 102, 255, 0.5)',
					'rgba(255, 159, 64, 0.5)', 'rgba(255, 99, 132, 0.5)', ],
			borderColor : [ 'rgba(255,99,132,1)', 'rgba(54, 162, 235, 1)',
					'rgba(255, 206, 86, 1)', 'rgba(75, 192, 192, 1)',
					'rgba(153, 102, 255, 1)', 'rgba(255, 159, 64, 1)',
					'rgba(255,99,132,1)', ],
			borderWidth : 1,
			data : [ 58, 57, 54, 55, 59, 53, 56 ],
		}, {
			backgroundColor : [ 'rgba(255, 99, 142, 0.5)',
					'rgba(54, 162, 235, 0.5)', 'rgba(255, 206,64, 0.5)',
					'rgba(75, 192, 192, 0.5)', 'rgba(153, 142, 255, 0.5)',
					'rgba(255, 159, 64, 0.5)', 'rgba(255, 99, 132, 0.5)', ],
			borderColor : [ 'rgba(255,99,132,1)', 'rgba(54, 162, 235, 1)',
					'rgba(255, 206, 86, 1)', 'rgba(75, 192, 192, 1)',
					'rgba(153, 102, 255, 1)', 'rgba(255, 159, 64, 1)',
					'rgba(255,99,132,1)', ],
			borderWidth : 1,
			data : [ 59, 57, 54, 55, 59, 53, 56 ],
		}
		]
	};

	$scope.chartOptions = {};

	$scope.onChartClick = function(event) {
		console.log('BarController', 'onChartClick', event);
	}
});

