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
    <script>
        var _ctx = "${ctx}";
    </script>
</head>
<body>
<div class="digital">
    <div class="dig-layout" style="padding-top: 40px;">
        <table class="dig-13" id="digital-data">
            <thead>
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
            <tbody></tbody>
        </table>
    </div>
</div>
</body>
</html>
