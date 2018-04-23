<!DOCTYPE HTML>
<html>
<head>
	<meta charset="utf-8">
    <title>四川农业大学第39届运动会</title>
    <link rel="shortcut icon" href="../static/images/logo.ico">
<!--<link rel="icon" href="https://static.jianshukeji.com/highcharts/images/favicon.ico">-->
	<link rel="stylesheet" href="${request.contextPath}/static/css/css.css" type="text/css"/>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<script src="https://img.hcharts.cn/jquery/jquery-1.8.3.min.js"></script>
	<script src="https://img.hcharts.cn/highcharts/highcharts.js"></script>
	<script src="https://img.hcharts.cn/highcharts/modules/exporting.js"></script>
	<script src="https://img.hcharts.cn/highcharts/modules/data.js"></script>
	<script src="https://img.hcharts.cn/highcharts/modules/drilldown.js"></script>
	<script src="https://img.hcharts.cn/highcharts-plugins/highcharts-zh_CN.js"></script>
	<script src="https://img.hcharts.cn/highcharts/themes/sand-signika.js"></script>
    <script src="/static/js/echarts.min.js"></script>
    <style>
        /*单人查询样式代码*/
        #personalInfo{
            display: block;
            width:60%;
            margin:20px auto;
            background: none;
            outline: none;
            height:30px;
            border-radius: 5px;
            border:1px solid black;
            font-size:10px;
            font-weight: 600;
            text-indent: 3px;
        }
        ．connn{
            width:90%;
            margin:0 auto;

        }
        .connn h4{
            width:100%;
            text-align: center;
            font-size:20px;
            color:rgb(130,62,76);
        }

        /*留言模块样式*/
        * {
            padding: 0;
            margin: 0;
        }

        body {
            /*background: rgb(235, 235, 235);*/
            background: url(/static/images/bg.png) repeat;
        }

        .con {
            width: 90%;
            margin: 0 auto;
            /*background: red;*/
            /*height: 1200px;*/
            padding-bottom: 50px;
        }

        .head {
            width: 100%;
            height: 5px;
            /*background: url(/static/images/head.jpg);*/
            background:rgb(41, 140, 212) ;
        }

        .leaveBtn {
            margin-top: 20px;
            width: 100%;
            overflow: hidden;
        }
        .icon {
            width: 70px;
            height: 70px;
            display: block;
            float: left;
            margin-right: 20px;
        }

        .leaveText {
            float: left;
            height: 100px;
            line-height: 130px;
            font-weight: 700;
            font-family: "arial rounded mt bold";
            font-size: 30px;
            color: rgb(41, 140, 212);
        }

        .leaveBox {
            width: 100%;
            height: 200px;
            background: white;
            margin-top: 20px;
            border-radius: 5px;
            overflow: hidden;
        }
        .leaveBox input {
            background: none;
            border: 1px solid rgb(235, 235, 235);
            border-radius: 5px;
            outline: none;
            width: 96%;
            height: 40px;
            margin: 0px auto;
            display: block;
            margin-top: 10px;
            text-indent: 10px;
            font-size: 15px;
        }

        .leaveBox textarea {
            background: none;
            border: 1px solid rgb(235, 235, 235);
            border-radius: 5px;
            outline: none;
            width: 96%;
            height: 60px;
            margin: 0px auto;
            display: block;
            margin-top: 10px;
            text-indent: 10px;
            font-size: 15px;
        }
        .subBtn {
            background: rgb(41, 140, 212);
            border-radius: 5px;
            width: 96%;
            height: 50px;
            margin: 0px auto;
            margin-top: 10px;
            text-align: center;
            line-height: 50px;
            font-weight: 700;
            font-size: 15px;
            color: white;
            font-family: "寰蒋闆呴粦";
            letter-spacing: 7px;
            cursor: pointer;
        }

        .leaveItem {
            width: 100%;
            background: white;
            margin-top: 10px;
            border-radius: 5px;
            overflow: hidden;
        }

        .nickName {
            width: 100%;
            color: rgb(41, 140, 212);
            font-size: 15px;
            font-family: "寰蒋闆呴粦";
            letter-spacing: 3px;
            font-weight: 700;
            text-indent: 5px;
        }
        .time {
            width: 100%;
            color: rgb(41, 140, 212);
            font-size: 13px;
            font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
            font-weight: 700;
            text-indent: 5px;
        }

        .content {
            width: 95%;
            margin: 0 auto;
            color: rgb(41, 140, 212);
            font-size: 15px;
            font-family: "寰蒋闆呴粦";
            letter-spacing: 1px;
            font-weight: 500;
            border: 1px solid rgb(235, 235, 235);
            text-indent: 5px;
            margin-bottom: 10px;
        }
        .logoPic{
            width:280px;
            height:60px;
            margin-top:5px;
            margin-left:5px;
        }
        #picH4{
            margin:0 auto;
        }
        /*http://sicau.s1.natapp.cc/getPreliminary*/

        .ttzf{
            display: block;
            width:100%;
            /*height:100px;*/
            margin-top:40px;
        }
        #header{
            width:90%;
            margin:10px auto;
            overflow: hidden;
            margin-top:30px;

        }
        #leftIcon{
            float:left;
            width:15%;
        }
        #leftIcon_icon{
            width:100%;
        }
        #rightText{
            float:right;
            width:84%;
            font-size:16px;
            /*background: red;*/
            margin-left:1%;
            margin-top:5%;
        }
    </style>

</head>
<body>

<img src="/static/images/header.png" class="ttzf"/>

<div style="width:100%;height:30px"></div>
<#--<h4 id="picH4">各学院团体总分柱状图</h4>-->
	<div id="container1" class="box" style="height: 500px; margin: 0 auto;"></div>
	<!--总分排名-->

    <div class="connn">
	<table class="table" style="margin-top:10px;font-size:13px">
        <h4 style="font-size:15px;margin-bottom:10px">各学院团体总成绩排名</h4>
		<tr class="tHead">
			<td style="background: rgb(185,55,47);">排名</td>
			<td style="background: rgb(185,55,47);">学院</td>
			<td style="background: rgb(185,55,47);">当前总分</td>
		</tr>
        <#--<#if classes??&&(classes?size>0)>
        <#list classes as classes>
		<tr>
			<td>${classes.rank}</td>
			<td>${classes.classes}</td>
			<td>${classes.grade}</td>
		</tr>
        </#list>
        </#if>-->
        <tr>
            <td>1</td>
            <td>农学院</td>
            <td>551.5</td>
        </tr>
        <tr>
            <td>2</td>
            <td>商学院</td>
            <td>366.5</td>
        </tr>
        <tr>
            <td>3</td>
            <td>水利水电</td>
            <td>355</td>
        </tr>
        <tr>
            <td>4</td>
            <td>建城院</td>
            <td>336</td>
        </tr>
        <tr>
            <td>5</td>
            <td>动科院</td>
            <td>324</td>
        </tr>
        <tr>
            <td>6</td>
            <td>旅游学院</td>
            <td>320</td>
        </tr>
        <tr>
            <td>7</td>
            <td>生科院</td>
            <td>318.5</td>
        </tr>
        <tr>
            <td>8</td>
            <td>土木学院</td>
            <td>280.5</td>
        </tr>
        <tr>
            <td>9</td>
            <td>经济学院</td>
            <td>277.5</td>
        </tr>
        <tr>
            <td>10</td>
            <td>资源学院</td>
            <td>247</td>
        </tr>
        <tr>
            <td>11</td>
            <td>动医院</td>
            <td>242</td>
        </tr>
        <tr>
            <td>12</td>
            <td>机电院</td>
            <td>234</td>
        </tr>
        <tr>
            <td>13</td>
            <td>信工院</td>
            <td>222</td>
        </tr>
        <tr>
            <td>14</td>
            <td>研究生院</td>
            <td>221</td>
        </tr>
        <tr>
            <td>15</td>
            <td>食品院</td>
            <td>209</td>
        </tr>
        <tr>
            <td>16</td>
            <td>理学院</td>
            <td>202.5</td>
        </tr>
        <tr>
            <td>17</td>
            <td>环境学院</td>
            <td>197.5</td>
        </tr>
        <tr>
            <td>18</td>
            <td>管理学院</td>
            <td>176</td>
        </tr>
        <tr>
            <td>19</td>
            <td>法学院</td>
            <td>170.5</td>
        </tr>

        <tr>
            <td>20</td>
            <td>人文院</td>
            <td>163</td>
        </tr>
        <tr>
            <td>21</td>
            <td>艺传院</td>
            <td>162</td>
        </tr>
        <tr>
            <td>22</td>
            <td>园艺学院</td>
            <td>152</td>
        </tr>
        <tr>
            <td>23</td>
            <td>林学院</td>
            <td>118</td>
        </tr>
        <tr>
            <td>24</td>
            <td>风景园林</td>
            <td>114</td>
        </tr>
	</table>
	<!--破校级录 -->
        <img src="/static/images/cjjl.png" class="ttzf"/>
        <h4 style="margin-top:30px;width:100%;text-align: center;font-size: 15px;color: rgb(41, 140, 222)">破校纪录名单</h4>

        <table class="table" style="font-size:13px">
        <tr class="tHead">
         <#--   <td>校区</td>-->
             <td>项目</td>
             <td>姓名</td>
             <td>性别</td>
             <td>成绩</td>
             <td>学院</td>
            <#-- <td>年级专业</td>-->

        </tr>
      <#--  <#if record??&&(record?size>0)>
        <#list record as record>
        <tr>

            <td>${record.project}</td>
            <td>${record.name}</td>
            <td>${record.sex}</td>
            <td>${record.score}</td>
            <td>${record.classes}</td>
        &lt;#&ndash;    <td>${record.profession}</td>&ndash;&gt;

        </tr>
        </#list>
        <#else>
        <tr>
            <td></td>
            <td></td>
         &lt;#&ndash;   <td></td>&ndash;&gt;
          &lt;#&ndash;  <td></td>&ndash;&gt;
            <td style="color: #b92c28">无数据</td>
       &lt;#&ndash;     <td></td>&ndash;&gt;
            <td></td>
            <td></td>

        </tr>
        </#if>-->
            <tr>
                <td>铅球(7.26kg)</td>
                <td>李汉森</td>
                <td>男</td>
                <td>12.09米</td>
                <td>研究生院</td>
            </tr>
            <tr>
                <td>200米</td>
                <td>陶刘</td>
                <td>男</td>
                <td>00:22.7</td>
                <td>体育学院</td>
            </tr>
            <tr>
                <td>4*400接力</td>
                <td>体育学院</td>
                <td>女</td>
                <td>04:32.6</td>
                <td>体育学院</td>
            </tr>

    </table>
	<!--达到二级运动员标准-->
        <h4 style="margin-top:30px;width:100%;text-align: center;font-size: 15px;color: rgb(41, 140, 222)">达到二级运动员标准名单</h4>
    <table class="table" style="font-size:13px">

        <tr class="tHead">
            <td>项目</td>
            <td>姓名</td>
            <td>性别</td>
            <td>成绩</td>
            <td>学院</td>
            <#--<td>年级专业</td>-->

        </tr>
        <#if twoLevel??&&(twoLevel?size>0)>
        <#list twoLevel as twoLevel>
        <tr>
            <td>${twoLevel.project}</td>
            <td>${twoLevel.name}</td>
            <td>${twoLevel.sex}</td>
            <td>${twoLevel.score}</td>
            <td>${twoLevel.classes}</td>
         <#--   <td>${twoLevel.profession}</td>-->

        </tr>
        </#list>
        <#else>
            <tr>
                <td></td>
                <td></td>
               <#-- <td></td>-->
                <td style="color: #b92c28">无数据</td>
                <td></td>
                <td></td>
            </tr>
        </#if>
    </table>
    </div>
        <img src="/static/images/jtcx.png" class="ttzf"/>
	<!--决赛成绩查询列表-->
<div class="connn">
	<div id="solo" style="margin-top:30px;">
		<h4 style="font-size:15px;margin-bottom:10px">点击下拉框选择查看决赛项目</h4>
        <select class="selectGender" id="finalSex" style="height:30px">
            <option value ="男">男</option>
            <option value ="女">女</option>
        </select>
		<select class="selectBox" id="final"  style="height:30px"></select>
	</div>
	<div class="get" id="get1"  style="background: rgb(185,55,47);">查询</div>
	<table class="table" id="finalcomp"  style="font-size:13px">
		<#if finalSolo?? && (finalSolo?size>0)>
            <tr class="tHead" class="get1-0">
                <td  style="background: rgb(185,55,47);">名次</td>
                <td style="background: rgb(185,55,47);">学院</td>
                <td style="background: rgb(185,55,47);">姓名</td>
                <td style="background: rgb(185,55,47);">成绩</td>
                <#--<td style="background: rgb(185,55,47);">年级专业</td>-->
            </tr>
		 <#list finalSolo as finalSolo>

    <tr class="get1-0">
        <td>${finalSolo.rank!}</td>
        <td>${finalSolo.classes!}</td>
        <td>${finalSolo.stuName!}</td>
        <td>${finalSolo.score!}</td>
     <#--   <td>${finalSolo.profession!}</td>-->

    </tr>
		 </#list>
		<#else>
		<tr class="get1-1">
			<td></td>
			<td></td>
			<td style="color: #b92c28">无数据</td>
			<td></td>
		<#--	<td></td>-->
		</tr>
		</#if>
	</table>
	<!--//预赛成绩查询-->
	<div id="unit" style="margin-top:30px;">
		<h4 style="font-size:15px;margin-bottom:10px">点击下拉框选择查看预选赛项目</h4>
		<select class="selectCampus" id="preCampus" style="height:30px">
            <option value ="001">雅安校区</option>
            <option value ="002">成都校区</option>
            <option value="003">都江堰校区</option>
		</select>
        <select class="selectGender" id="proSex"  style="height:30px">
            <option value ="男">男</option>
            <option value ="女">女</option>
        </select>
		<select class="selectBox"id="prePro" style="height:30px"></select>
	</div>
	<div class="getUnit" id="get2"  style="background: rgb(185,55,47);">查询</div>
	<table class="table" id="yusai"  style="font-size:13px">
		<#if solo?? &&(solo?size>0)>
            <tr class="tHead get2-0">
                <td style="background: rgb(185,55,47);">名次</td>
                <td style="background: rgb(185,55,47);">学院</td>
                <td style="background: rgb(185,55,47);">姓名</td>
                <td style="background: rgb(185,55,47);">成绩</td>
               <#-- <td style="background: rgb(185,55,47);">年级专业</td>-->

            </tr>
			<#list solo as solo>

		<tr class="get2-0">
			<td>${solo.rank!}</td>
			<td>${solo.classes!}</td>
            <td>${solo.studentName!}</td>
            <td>${solo.score!}</td>
			<#--<td>${solo.profession!}</td>-->

		</tr>
			</#list>
		<#else>
            <tr class="get2-1">
                <td></td>
                <td></td>
                <td style="color: #b92c28">无数据</td>
                <td></td>
              <#--  <td></td>-->
            </tr>
		</#if>
	</table>
    <!--集体项目成绩查询列表-->
    <div id="unitPro" style="margin-top:30px;">
        <h4 style="font-size:15px;margin-bottom:10px">点击下拉框中选择查看集体项目</h4>
        <select  class="selectBox" id="cam" style="height:30px">
            <option value ="001">雅安校区</option>
            <option value ="002">成都校区</option>
            <option value="003">都江堰校区</option>
        </select>

        <select class="selectGender" id="teamPro" style="height:30px">
        </select>
    </div>
    <div class="get" id="get3"  style="background: rgb(185,55,47);">查询</div>
    <table class="table" id="jiti" style="font-size:13px">
        <#--<tr ></tr>-->
		<#if team?? &&(team?size>0)>
            <tr class="tHead get3-0">
                <td style="background: rgb(185,55,47);">名次</td>
                <td style="background: rgb(185,55,47);">校区</td>
                <td style="background: rgb(185,55,47);">学院</td>
               <td style="background: rgb(185,55,47);">奖项</td>
            </tr>
		  <#list team as team>

        <tr class="get3-0">
            <td>${team.id!}</td>
            <td>${team.teamcampus!}</td>
            <td>${team.teamclass!}</td>
           <td>${team.price!}</td>
        </tr>
	     </#list>
		<#else>
		<tr class="get3-1">
			<td></td>
            <td></td>
            <td>无数据</td>
            <td></td>

		</tr>
		</#if>
		</table>
    <!--单人查询html代码-->
    <h4 style="width:100%;text-align: center;font-size: 15px;color: rgb(130,62,76);margin-top:30px;">可根据学号查询参赛队员的项目成绩</h4>
    <div class="getPersonalInfo">
        <input type="text" value="" placeholder="请输入需要查询的学号" id="personalInfo" style="height:30px"/>
    </div>
    <div class="getUnit" id="get4" style="background: rgb(185,55,47);">查询</div>
    <table class="table" id="yy"  style="font-size:13px">
        <tr class="tHead">
            <td style="background: rgb(185,55,47);">名次</td>
            <td style="background: rgb(185,55,47);">姓名</td>
            <td style="background: rgb(185,55,47);">学院</td>
            <td style="background: rgb(185,55,47);">项目</td>
            <td style="background: rgb(185,55,47);">成绩</td>
            <td style="background: rgb(185,55,47);">赛制</td>
        </tr>

    </table>
    </div>
　 <div style="width: 100%;height: 50px"></div>
<#--<div class="head"></div>-->
<img src="/static/images/ly.png" class="ttzf"/>
<div class="con" id="con">
    <#--<div class="leaveBtn">-->
        <#--<img src="/static/images/icon.png" class="icon" />-->
        <#--<div class="leaveText">留言墙</div>-->
    <#--</div>-->

    <div class="leaveBox">
        <input type="text" id="nick" name="nickname" value="" placeholder="输入昵称" />
        <textarea type="text" id="message" name="message" value="" placeholder="请输入留言"></textarea>
        <div class="subBtn" id='subBtn' onclick="sendMessage()">提交留言</div>
    </div>
</div>

    <!--单人查询代码-->
	<script>
        window.onload = function(){
            getAllMessages();
            var screenWidth = document.body.clientWidth;
            var headerFontWIdth = screenWidth/100*94/100*84/22+"px";
            document.getElementById('rightText').style.fontSize = headerFontWIdth;
            document.getElementById('container').setAttribute('min-width',screenWidth);
        };
//        留言板块js
        //发送留言
        function sendMessage() {
            var time = getNowDate();
            var nickValue = document.getElementById('nick').value;
            var messageValue = document.getElementById('message').value;
            var regEn = /[`~!@#$%^&*()_+<>?:"{},.\/;'[\]]/im;
            var regCn = /[·！#￥（——）：；|《。》？【】[\]]/im;
            if(regEn.test(nickValue) || regCn.test(nickValue) || regEn.test(messageValue) || regCn.test(messageValue)) {
                alert("不能包含特殊字符.");
                return;
            }
            if(nickValue.length > 10){
                alert("昵称最多为10个字符");
                return;
            }
            if(nickValue.length > 50){
                alert("留言最多为10个字符");
                return;
            }
            if(nickValue != "" && messageValue != "") {
                var str = nickValue + "&" + messageValue + "&" + time;
                var xmlhttp;
                if(window.XMLHttpRequest) {
                    //  IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
                    xmlhttp = new XMLHttpRequest();
                } else {
                    // IE6, IE5 浏览器执行代码
                    xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
                }
                xmlhttp.onreadystatechange = function() {
                    if(xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                        if(xmlhttp.responseText == 'name error') {
                            alert("请规范输入昵称");
                        } else if(xmlhttp.responseText == 'message error') {
                            alert("请规范输入留言");
                        } else {
                            alert("留言成功,待管理员审核通过");
                            document.getElementById('nick').value = "";
                            document.getElementById('message').value = "";
                        }
                    }
                }
                xmlhttp.open("POST", "http://118.24.121.246:7080/sendMessage", true);
                xmlhttp.send(str);
            } else {
                alert('输入不能为空');
            }
        }

        //获取当前时间戳
        function getNowDate() {
            Date.prototype.Format = function(fmt) { // author: meizz
                var o = {
                    "M+": this.getMonth() + 1, // 月份
                    "d+": this.getDate(), // 日
                    "h+": this.getHours(), // 小时
                    "m+": this.getMinutes(), // 分
                    "s+": this.getSeconds(), // 秒
                    "q+": Math.floor((this.getMonth() + 3) / 3), // 季度
                    "S": this.getMilliseconds() // 毫秒
                };
                if(/(y+)/.test(fmt))
                    fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
                for(var k in o)
                    if(new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
                return fmt;
            }
            return new Date().Format("yyyy-MM-dd hh:mm:ss");
        }
        //获取所有留言
        function getAllMessages() {
            var xmlhttp;
            if(window.XMLHttpRequest) {
                //  IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
                xmlhttp = new XMLHttpRequest();
            } else {
                // IE6, IE5 浏览器执行代码
                xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
            }
            xmlhttp.onreadystatechange = function() {
                if(xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                    var str = xmlhttp.responseText;
                    var messageArr = str.split("$");
                    var nickname = [];
                    var time = [];
                    var content = [];
                    for(var i = 0; i < messageArr.length; i++) {
                        nickname.push(messageArr[i].split("#")[1]);
                        time.push(messageArr[i].split("#")[3]);
                        content.push(messageArr[i].split("#")[2]);
                    }
                    for(var j = 0; j < nickname.length; j++) {
                        var fatherDiv = document.createElement('div');
                        fatherDiv.setAttribute('class', 'leaveItem');

                        var nameDiv = document.createElement('div');
                        nameDiv.setAttribute('class', 'nickName');
                        var nameText = document.createTextNode(nickname[j]);
                        nameDiv.appendChild(nameText);
                        fatherDiv.appendChild(nameDiv);
                        var contentDiv = document.createElement('div');
                        contentDiv.setAttribute('class', 'content');
                        var contentText = document.createTextNode(content[j]);
                        contentDiv.appendChild(contentText);
                        fatherDiv.appendChild(contentDiv);

                        document.getElementById('con').appendChild(fatherDiv);

                    }
                }
            }
            xmlhttp.open("GET", "http://118.24.121.246:7080/getAllMessages", true);
            xmlhttp.send();
        }

        // 基于准备好的dom，初始化echarts实例
        var app = echarts.init(document.getElementById('container1'));

        app.title = '四川农业大学第39届校运动会各学院团体总分图';

        option = {
            title: {
                text: '',
                subtext: '',
                "textStyle": {
                　　　　"color": "#444",
                　　　　"text-align": "center",
                　　　　"margin-top":"0px"
         　　}
            },
            tooltip: {
                trigger: 'axis',
                axisPointer: {
                    type: 'shadow'
                }
            },
            legend: {
                data: ['2018年']
            },
            grid: {
                left: '3%',
                right: '4%',
                bottom: '3%',
                top:"10px",
                containLabel: true
            },
            xAxis: {
                type: 'value',
                boundaryGap: [0, 0.01]
            },
            yAxis: {
                type: 'category',
                data: [
                <#--<#if vo??&&(vo?size>0)>
                    <#list vo as vo>
                        '${vo.classes!}',
                    </#list>
                </#if>-->
                    '理学院',
                    '生科院',
                    '机电学院',
                    '食品学院',
                    '信工院',
                    '水利水电',
                    '人文院',
                    '法学院',
                    '艺传院',
                    '农学院',
                    '动科院',
                    '动医院',
                    '林学院',
                    '园艺学院',
                    '资源学院',
                    '环境学院',
                    '经济学院',
                    '管理学院',
                    '风景园林',
                    '研究生院',
                    '建城学院',
                    '土木工程',
                    '旅游学院',
                    '商学院',
                ]
            },
            series: [
                {
                    name: '',
                    type: 'bar',
                    data: [
                    <#--<#if vo??&&(vo?size>0)>
                        <#list vo as vo>
                            '${vo.grade!}',
                        </#list>
                    </#if>-->
                        '202.5',
                        '318.5',
                        '234',
                        '209',
                        '222',
                        '355',
                        '163',
                        '170.5',
                        '162',
                        '551.5',
                        '324',
                        '242',
                        '118',
                        '152',
                        '247',
                        '197.5',
                        '277.5',
                        '176',
                        '114',
                        '221',
                        '336',
                        '280.5',
                        '320',
                        '366.5',
                    ]
                }
            ]
        };

        // 使用刚指定的配置项和数据显示图表。
        app.setOption(option);
        //团体总分柱状图

	</script>
    <script src="/static/js/js.js"></script>
    <script>
    $("#get1").click(function(){
        var project = $("#final").val();
        var sex = $("#finalSex").val();
        $.ajax({
            type: "post",
            url: "${request.contextPath}/getQuery",
            dataType: "json",
            data: {finalproject: project, stusex: sex},
            success: function (result) {
                var thehtml='';
                var data=result.finalSolo;
                var nonetxt='暂无数据';
                if(data.length==0){
                    thehtml='<tr><td></td><td></td><td>'+nonetxt+'</td><td></td></tr>';

                }else{
                    for(var i in data){
                        thehtml+='<tr>'+'<td>'+data[i].rank+'</td>'+'<td>'+data[i].classes+'</td><td>'+data[i].stuName+'</td><td>'+data[i].score+'</td></tr>';
                    }

                }
               thehtml= '<tr class="tHead"> <td style="background: rgb(185,55,47);">名次</td> <td style="background: rgb(185,55,47);">学院</td> <td style="background: rgb(185,55,47);">姓名</td>  <td style="background: rgb(185,55,47);">成绩</td> </tr>'+thehtml;
                $("#finalcomp").html(thehtml);
                $(".get1-0").html('');
                $(".get1-1").html('');

            }
        })
    })

    $("#get2").click(function(){
        var preCampus = $("#preCampus").val();
        var proSex = $("#proSex").val();
        var prePro = $("#prePro").val();
        var nonetxt='暂无数据';
        $.ajax({
            type: "post",
            url: "${request.contextPath}/getQuery1",
            dataType: "json",
            data: {campus: preCampus, usersex: proSex, project: prePro},
            success: function (result) {
                var thehtml='';
                var data=result.solo;
                if(data.length==0){
                    thehtml='<tr><td></td><td></td><td>'+nonetxt+'</td><td></td></tr>';
                }else{
                    for(var i in data){
                        thehtml+='<tr>'+'<td>'+data[i].rank+'</td>'+'<td>'+data[i].classes+'</td>'+'<td>'+data[i].studentName+'</td>'+'</td><td>'+data[i].score+'</td></tr>';
                    }
                }

                thehtml='<tr class="tHead"> <td style="background: rgb(185,55,47);">名次</td> <td style="background: rgb(185,55,47);">学院</td> <td style="background: rgb(185,55,47);">姓名</td>  <td style="background: rgb(185,55,47);">成绩</td> </tr>'+thehtml;
                $("#yusai").html(thehtml);
                $(".get2-0").html('');
                $(".get2-1").html('');

            }
        })
    })


    $("#get3").click(function(){
        var cam =$("#cam").val();
        var teamPro =$("#teamPro").val();
        var nonetxt='暂无数据';
        $.ajax({
            type: "post",
            url: "${request.contextPath}/getQuery2",
            dataType: "json",
            data: {teamcampus: cam, teamproject: teamPro},
            success: function (result) {
                var thehtml='';
                var data=result.team;
                if(data.length==0){
                    thehtml='<tr><td></td><td>'+nonetxt+'</td><td></td></tr>';
                }else{
                    for(var i in data){
                        thehtml+='<tr><td>'+data[i].id+'</td>'+'<td>'+data[i].teamcampus+'</td><td>'+data[i].teamclass+'</td><td>'+data[i].price+'</td></tr>';
                    }
                }
                thehtml='<tr class="tHead"> <td style="background: rgb(185,55,47);">名次</td> <td style="background: rgb(185,55,47);">校区</td> <td style="background: rgb(185,55,47);">学院</td>  <td style="background: rgb(185,55,47);">奖项</td></tr>'+thehtml;
                $("#jiti").html(thehtml);
                $(".get3-0").html('');
                $(".get3-1").html('');

            }
        })
    })

        $("#get4").click(function () {
            var stuNumber=$("#personalInfo").val()
            $.ajax({
                type: "post",
                url: "${request.contextPath}/getQuery3",
                dataType: "json",
                data:{stuNumber:stuNumber},
                success:function (result) {
                    if (result.status == 500) {
                        alert(result.message);
                    } else {
                        var theHtml = '';
                        var data = result.soloVO;
                        /*alert(data.length)*/
                        if (data.length == 0) {
                            theHtml = '<tr><td></td><td></td><td></td><td>'+'无'+'</td><td></td><td></td><td></td></tr>'
                        }else {
                            for (var i in data){
                                theHtml+='<tr><td>'+data[i].rank+'</td><td>'+data[i].studentName+'</td><td>'+data[i].classes+'</td><td>'+data[i].project+'</td><td>'+data[i].score+'</td><td>'+data[i].formate+'</td></tr>';
                            }
                        }
                        theHtml='<tr class="tHead"><td style="background: rgb(185,55,47);">名次</td><td style="background: rgb(185,55,47);">姓名</td><td style="background: rgb(185,55,47);">学院</td><td style="background: rgb(185,55,47);">项目</td><td style="background: rgb(185,55,47);">成绩</td style="background: rgb(185,55,47);"><td style="background: rgb(185,55,47);">赛制</td></tr>'+theHtml;
                        $("#yy").html(theHtml);
                    }
                }
            })

        })

</script>
</body>
</html>