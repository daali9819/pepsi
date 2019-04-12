<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'empdata.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
  </head>
  
  <body>
    <div id = "ok" style = "height:400px;"></div>
    
    <script type="text/javascript" src = "sys/js/echarts-all.js"></script>
    
  	<script type="text/javascript">
    	var myChart = echarts.init(document.getElementById('ok')); 
    	var option = {
    		    tooltip : {
    		        trigger: 'axis',
    		        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
    		            type : 'shadow'     // 默认为直线，可选为：'line' | 'shadow'
    		        }
    		    },
    		    legend: {
    		        data:['博士','硕士','本科','专科']
    		    },
    		    toolbox: {
    		        show : true,
    		        orient: 'vertical',
    		        x: 'right',
    		        y: 'center',
    		        feature : {
    		            mark : {show: true},
    		            dataView : {show: true, readOnly: false},
    		            magicType : {show: true, type: ['line', 'bar', 'stack', 'tiled']},
    		            restore : {show: true},
    		            saveAsImage : {show: true}
    		        }
    		    },
    		    calculable : true,
    		    xAxis : [
    		        {
    		            type : 'category',
    		            data : ['2012','2013','2014','2015','2016']
    		        }
    		    ],
    		    yAxis : [
    		        {
    		            type : 'value'
    		        }
    		    ],
    		    series : [
    		        {
    		            name:'博士',
    		            type:'bar',
    		            data:[320, 332, 301, 334, 390]
    		        },
    		        {
    		            name:'硕士',
    		            type:'bar',
    		            stack: '广告',
    		            data:[120, 132, 101, 134, 90]
    		        },
    		        {
    		            name:'本科',
    		            type:'bar',
    		            stack: '广告',
    		            data:[220, 182, 191, 234, 290]
    		        },{
    		            name:'专科',
    		            type:'bar',
    		            data:[862, 1018, 964, 1026, 1679],
    		            markLine : {
    		                itemStyle:{
    		                    normal:{
    		                        lineStyle:{
    		                            type: 'dashed'
    		                        }
    		                    }
    		                },
    		                data : [
    		                    [{type : 'min'}, {type : 'max'}]
    		                ]
    		            }
    		        }
    		    ]
    		};
        myChart.setOption(option); 
    </script>
  </body>
</html>















