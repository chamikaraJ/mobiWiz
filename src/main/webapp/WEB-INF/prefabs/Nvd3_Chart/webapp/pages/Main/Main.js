Application.$controller("Nvd3_ChartController", ["$scope", function($scope) {
    "use strict";

    /*
     * This function will be invoked when any of this prefab's property is changed
     * @key: property name
     * @newVal: new value of the property
     * @oldVal: old value of the property
     */

    var data = [];

    function propertyChangeHandler(key, newVal, oldVal) {
        /*
        switch (key) {
        	case "prop1":
        		// do something with newVal for property 'prop1'
        		break;
        	case "prop2":
        		// do something with newVal for property 'prop2'
        		break;
        }
        */

        switch (key) {
            case "dataset":
                var year = 2000;
                _.each(newVal.data, function(obj) {
                    data.push({
                        "sale": obj.budget / 10000,
                        "year": year
                    });
                    year += 1;
                });
                break;
            case "prop2":
                // do something with newVal for property 'prop2'
                break;
        }
    }
    /* register the property change handler */
    $scope.propertyManager.add($scope.propertyManager.ACTIONS.CHANGE, propertyChangeHandler);

    $scope.onInitPrefab = function() {
        // this method will be triggered post initialization of the prefab.
        var vis = d3.select("#visualisation"),
            WIDTH = 1000,
            HEIGHT = 1000,
            MARGINS = {
                top: 20,
                right: 20,
                bottom: 20,
                left: 50
            },
            xScale = d3.scale.linear().range([MARGINS.left, WIDTH - MARGINS.right]).domain([2000, 2004]),
            yScale = d3.scale.linear().range([HEIGHT - MARGINS.top, MARGINS.bottom]).domain([0, 350]),
            xAxis = d3.svg.axis()
            .scale(xScale),
            yAxis = d3.svg.axis()
        vis.append("svg:g")
            .attr("transform", "translate(0," + (HEIGHT - MARGINS.bottom) + ")")
            .call(xAxis);
        yAxis = d3.svg.axis()
            .scale(yScale)
            .orient("left");
        vis.append("svg:g")
            .attr("transform", "translate(" + (MARGINS.left) + ",0)")
            .call(yAxis);
        var lineGen = d3.svg.line()
            .x(function(d) {
                return xScale(d.year);
            })
            .y(function(d) {
                return yScale(d.sale);
            });
        vis.append('svg:path')
            .attr('d', lineGen(data))
            .attr('stroke', 'green')
            .attr('stroke-width', 2)
            .attr('fill', 'none');
    };
}]);