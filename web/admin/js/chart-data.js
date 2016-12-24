var randomScalingFactor = function () {
    return Math.round(Math.random() * 1000)
};

var lineChartData = {
    labels: ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"],
    datasets: [
        {
            label: "Doanh số (triệu đồng)",
            fill: false,
            lineTension: 0.1,
            backgroundColor: "rgba(220,50,50,0.2)",
            borderColor: "rgba(220,50,50,1)",
            borderCapStyle: 'butt',
            borderDash: [],
            borderDashOffset: 0.0,
            borderJoinStyle: 'miter',
            pointBorderColor: "#fff",
            pointBackgroundColor: "rgba(75,192,192,1)",
            pointBorderWidth: 1,
            pointHoverRadius: 5,
            pointHoverBackgroundColor: "rgba(220,220,220,1)",
            pointHoverBorderColor: "rgba(75,192,192,1)",
            pointHoverBorderWidth: 2,
            pointRadius: 5,
            pointHitRadius: 10,
            spanGaps: false,
            data: [randomScalingFactor(), randomScalingFactor(), randomScalingFactor(), randomScalingFactor(), randomScalingFactor(), randomScalingFactor(), randomScalingFactor(), randomScalingFactor(), randomScalingFactor(), randomScalingFactor(), randomScalingFactor(), randomScalingFactor()]
        },
        {
            label: "Số lượng đơn hàng",
            fill: false,
            lineTension: 0.1,
            backgroundColor: "rgba(48, 164, 255, 0.2)",
            borderColor: "rgba(48, 164, 255, 1)",
            borderCapStyle: 'butt',
            borderDash: [],
            borderDashOffset: 0.0,
            borderJoinStyle: 'miter',
            pointBorderColor: "rgba(48, 164, 255, 1)",
            pointBackgroundColor: "rgba(48, 164, 255, 1)",
            pointBorderWidth: 1,
            pointHoverRadius: 5,
            pointHoverBackgroundColor: "#fff",
            pointHoverBorderColor: "rgba(48, 164, 255, 1)",
            pointHoverBorderWidth: 2,
            pointRadius: 5,
            pointHitRadius: 10,
            spanGaps: false,
            data: [randomScalingFactor(), randomScalingFactor(), randomScalingFactor(), randomScalingFactor(), randomScalingFactor(), randomScalingFactor(), randomScalingFactor()]
        }
    ]

}

window.onload = function () {

    var chart1 = document.getElementById("line-chart").getContext("2d");
    window.myLine = new Chart.Line(chart1, {
        data: lineChartData,
        options: {
            responsive: true
        }
    });
    setInterval(
            function () {
                $.post("/WebBanHang/ManagerBillServlet", {"command": "statistic"}, function (data) {
                    console.log('data: ' + data.sales);
                    window.myLine.data.datasets[0].data = data.sales;
                    window.myLine.data.datasets[1].data = data.numBills;
                    window.myLine.update();
                    console.log("Day la phan test get du lieu thong ke");
                });
            }, 2000);
//    var chart2 = document.getElementById("bar-chart").getContext("2d");
//    window.myBar = new Chart(chart2).Bar(barChartData, {
//        responsive: true
//    });
//    var chart3 = document.getElementById("doughnut-chart").getContext("2d");
//    window.myDoughnut = new Chart(chart3).Doughnut(doughnutData, {responsive: true
//    });
//    var chart4 = document.getElementById("pie-chart").getContext("2d");
//    window.myPie = new Chart(chart4).Pie(pieData, {responsive: true
//    });

};


//
//var barChartData = {
//    labels: ["January", "February", "March", "April", "May", "June", "July"],
//    datasets: [
//        {
//            fillColor: "rgba(220,220,220,0.5)",
//            strokeColor: "rgba(220,220,220,0.8)",
//            highlightFill: "rgba(220,220,220,0.75)",
//            highlightStroke: "rgba(220,220,220,1)",
//            data: [randomScalingFactor(), randomScalingFactor(), randomScalingFactor(), randomScalingFactor(), randomScalingFactor(), randomScalingFactor(), randomScalingFactor()]
//        },
//        {
//            fillColor: "rgba(48, 164, 255, 0.2)",
//            strokeColor: "rgba(48, 164, 255, 0.8)",
//            highlightFill: "rgba(48, 164, 255, 0.75)",
//            highlightStroke: "rgba(48, 164, 255, 1)",
//            data: [randomScalingFactor(), randomScalingFactor(), randomScalingFactor(), randomScalingFactor(), randomScalingFactor(), randomScalingFactor(), randomScalingFactor()]
//        }
//    ]
//
//}
//
//var pieData = [
//    {
//        value: 300,
//        color: "#30a5ff",
//        highlight: "#62b9fb",
//        label: "Blue"
//    },
//    {
//        value: 50,
//        color: "#ffb53e",
//        highlight: "#fac878",
//        label: "Orange"
//    },
//    {
//        value: 100,
//        color: "#1ebfae",
//        highlight: "#3cdfce",
//        label: "Teal"
//    },
//    {
//        value: 120,
//        color: "#f9243f",
//        highlight: "#f6495f",
//        label: "Red"
//    }
//
//];
//
//var doughnutData = [
//    {
//        value: 300,
//        color: "#30a5ff",
//        highlight: "#62b9fb",
//        label: "Blue"
//    },
//    {
//        value: 50,
//        color: "#ffb53e",
//        highlight: "#fac878",
//        label: "Orange"
//    },
//    {
//        value: 100,
//        color: "#1ebfae",
//        highlight: "#3cdfce",
//        label: "Teal"
//    },
//    {
//        value: 120,
//        color: "#f9243f",
//        highlight: "#f6495f",
//        label: "Red"
//    }
//
//];