<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/commons/taglibs.jsp" %>
<%@ include file="/WEB-INF/jsp/commons/meta.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<head>
    <meta charset='utf-8'>
    <title></title>
    <meta name="keywords" content="">
    <link rel="stylesheet" href="${ctx}/css/reset.css">
    <link rel="stylesheet" href="${ctx}/css/digital.css">
    <script src="${ctx}/script/jquery-3.2.1.min.js"></script>
    <script src="${ctx}/script/vue.js"></script>
    <script src="${ctx}/js/peformance/internal.js"></script>
    <script>
        var _ctx = "${ctx}";
    </script>
</head>
<body>
<div class="digital">
    <div class="dig-layout">
        <table class="dig-13" id="internal-data">
            <thead>
            <tr>
                <td colspan="14" class="mytitle">SLA - NITS</td>
            </tr>
                <tr>
                    <td rowspan="3">OPERATIONAL</td>
                    <td rowspan="3">UNIT</td>
                    <td colspan="5"></td>
                    <td rowspan="3">MOM</td>
                    <td colspan="5">YtD</td>
                    <td rowspan="3">YOY</td>
                </tr>
                <tr>
                    <td rowspan="2">TARGET</td>
                    <td colspan="2">MtD</td>
                    <td colspan="2">OUTLOOK</td>
                    <td rowspan="2">TARGET</td>
                    <td rowspan="2">REAL</td>
                    <td rowspan="2">ACH</td>
                    <td colspan="2">OUTLOOK</td>
                </tr>
                <tr>
                    <td>REAL</td>
                    <td>ACH</td>
                    <td>AMOUNT</td>
                    <td>ACH</td>
                    <td>REAL</td>
                    <td>ACH</td>
                </tr>
            </thead>
            <tbody>
                <tr v-for="item in dataList">
                    <td>{{item.type2}}</td>
                    <td>{{item.unit}}</td>
                    <td>{{item.target1}}</td>
                    <td>{{item.real1}}</td>
                    <td>{{item.ach1}}</td>
                    <td>{{item.amountOutlook1}}</td>
                    <td>{{item.achOutlook1}}</td>
                    <td>{{item.mom}}</td>
                    <td>{{item.target2}}</td>
                    <td>{{item.real2}}</td>
                    <td>{{item.ach2}}</td>
                    <td>{{item.amountOutlook2}}</td>
                    <td>{{item.achOutlook2}}</td>
                    <td>{{item.yoy}}</td>
                </tr>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
