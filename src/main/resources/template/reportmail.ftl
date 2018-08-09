<html>
<head>
    <style type="text/css">
        table, td {
            border: 1px solid black;
            border-collapse: collapse;
        }

        td {
            font-size: 14px;
            font-family: "Microsoft YaHei UI";
            padding: 2px 20px;
            text-align: center;
            vertical-align: center;
            height: 20px;
        }
    </style>
</head>
<div>
    <table>
        <tr>
            <td>日期</td>
            <td colspan="3">${reportmail.tddate}</td>
        </tr>
        <tr>
            <td>
                姓名
            </td>
            <td>${reportmail.name}</td>
            <td>部门</td>
            <td>${reportmail.department}</td>
        </tr>
        <tr>
            <td>时间</td>
            <td>培训内容</td>
            <td>培训方式</td>
            <td>培训讲师</td>
        </tr>
        <tr>
            <td>${reportmail.timeam}</td>
            <td>${reportmail.workcontentam}</td>
            <td>${reportmail.wayam}</td>
            <td>${reportmail.telleram}</td>
        </tr>
        <tr>
            <td>${reportmail.timepm}</td>
            <td>${reportmail.workcontentpm}</td>
            <td>${reportmail.waypm}</td>
            <td>${reportmail.tellerpm}</td>
        </tr>
        <tr>
            <td>学习心得</td>
            <td colspan="3">${reportmail.experience}</td>
        </tr>
        <tr>
            <td>问题建议</td>
            <td colspan="3">${reportmail.suggestion}</td>
        </tr>
    </table>
</div>
</html>
