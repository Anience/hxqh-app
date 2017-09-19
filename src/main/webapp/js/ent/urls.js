$(function(){
    var urls = [
        'http://10.62.170.169/taufan/index_dashboard_REG_1.php',
        'http://10.62.170.169/taufan/index_dashboard_REG_2.php',
        'http://10.62.170.169/taufan/index_dashboard_REG_3.php',
        'http://10.62.170.169/taufan/index_dashboard_REG_4.php',
        'http://10.62.170.169/taufan/index_dashboard_REG_5.php',
        'http://10.62.170.169/taufan/index_dashboard_REG_6.php',
        'http://10.62.170.169/taufan/index_dashboard_REG_7.php'
    ];
    var i = 0;
    setInterval(function(){
        i++;
        if(i>6){
            i=0;
        }
        $("#menuFrame").attr("src",urls[i]);
        console.log(urls[i]);
    },5000);
});