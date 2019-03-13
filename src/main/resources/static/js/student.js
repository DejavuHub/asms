var id;
var $stucontent;
var rows;
var nowpage;
var totalpage;
$(function(){
    id=$(".id").val();
    $stucontent=$(".studentcontent");
    rows=5;
    nowpage=1;
    totalpage=0;
   var $stubody=$(".studentbody");
   $stubody.find("li").eq(0).click(function(){
       studentindex(this);
   });
    $stubody.find("li").eq(1).click(function(){
        $stubody.find("li").css({
            "background-color":"rgb(247,127,51)"
        });
        $(this).css({
            "background-color":"rgb(231,119,47)"
        });
        others();
        $stucontent.append("<label style='color:grey;margin-bottom:5px;'>我的科研项目&gt;科研项目列表</label><hr/><br/><hr/>");
        $stucontent.append("<button type='button' class='stuproready selectbutton'>已报名</button><button type='button' class='stuproapply noborder selectbutton'>未报名</button>");
        $stucontent.append("<div class='stuproconditions'></div><hr style='height:5px;background-color:rgb(249,213,163);'/><div class='stuprocontent'></div>")
        $(".selectbutton").click(function(){
            if($(this).hasClass("noborder")){
                $(".selectbutton").addClass("noborder");
                $(this).removeClass("noborder");
                if($(this).text()=="已报名"){
                    stuproready();
                }
                if($(this).text()=="未报名"){
                    stuproapply();
                }
            }
        });
        stuproready();
    });
    $stubody.find("li").eq(2).click(function(){
        $stubody.find("li").css({
            "background-color":"rgb(247,127,51)"
        });
        $(this).css({
            "background-color":"rgb(231,119,47)"
        });
        others();
    });
    $stubody.find("li").eq(3).click(function(){
        $stubody.find("li").css({
            "background-color":"rgb(247,127,51)"
        });
        $(this).css({
            "background-color":"rgb(231,119,47)"
        });
        others();
    });
    $stubody.find("li").eq(4).click(function(){
        $stubody.find("li").css({
            "background-color":"rgb(247,127,51)"
        });
        $(this).css({
            "background-color":"rgb(231,119,47)"
        });
        others();
    });
    $stubody.find("li").eq(5).click(function(){
        $stubody.find("li").css({
            "background-color":"rgb(247,127,51)"
        });
        $(this).css({
            "background-color":"rgb(231,119,47)"
        });
        others();
    });
    $stubody.find("li").eq(6).click(function(){
        $stubody.find("li").css({
            "background-color":"rgb(247,127,51)"
        });
        $(this).css({
            "background-color":"rgb(231,119,47)"
        });
        others();
    });
    studentindex($stubody.find("li").eq(0));
});
function studentindex(self){
    $(".studentbody").find("li").css({
        "background-color":"rgb(247,127,51)"
    });
    $(self).css({
        "background-color":"rgb(231,119,47)"
    });
    $stucontent.html("");
    $stucontent.css({
            "color":"white"
        });
    $.ajax({
       url:"/studentIndex",
       type:"post",
       dataType:"json",
        data:{
          "studentid": id
        },
        success:function(data){
            $stucontent.append("<div class=\"symbol1\"><img src=\"/img/queren.jpg\" width=\"100px\" height=\"100px\"/><p>可报名的科研项目：<label>"+data.apply+"</label></p></div>");
            $stucontent.append("<div class=\"symbol2\"><img src=\"/img/queren.jpg\" width=\"100px\" height=\"100px\"/><p>需提交材料的科研项目：<label>"+data.material+"</label></p></div>");
            $stucontent.append("<div class=\"symbol3\"><img src=\"/img/queren.jpg\" width=\"100px\" height=\"100px\"/><p>需修改毕设材料：<label>"+data.design+"</label></p></div>");
            $stucontent.append("<div class=\"symbol4\"><img src=\"/img/queren.jpg\" width=\"100px\" height=\"100px\"/><p>即将结束报名的科研项目：<label>"+data.deadline+"</label></p></div>");
        },
        error:function(data){
           alert(data.responseText);
        }
    });
}
function updatepwd(){
    others();
}
function logout(){
    location.href="/index.html";
}
function others(){
    $stucontent.html("<img src='/img/home.png' style='margin:0;'/><img src='/img/menu-inmh.png' width='24px' height='24px' style='background-color:grey;margin:0 5px;'/>");
    $stucontent.css({
        "color":"black"
    });
}
function stuproready(){
    var $cd=$(".stuproconditions");
    $cd.html("");
    $cd.append("<label>项目名称：</label><input type='text' class='grey stuproname' value='请输入项目名称'/>");
    $(".stuproname").focus(function(){
        if($(this).hasClass("grey")){
            $(this).removeClass("grey");
            $(this).val("");
        }
    });
    $(".stuproname").blur(function(){
        if($(this).val()==""){
            $(this).addClass("grey");
            $(this).val("请输入项目名称");
        }
    });
    $cd.append("<label>项目类型：</label><select><option value='0'>-请选择-</option></select>");
    $cd.append("<label>项目阶段：</label><select><option value='0'>-请选择-</option></select>");
    $cd.append("<label>我的状态：</label><select><option value='0'>-请选择-</option></select>");
    $cd.append("<button type='button' onclick='stuprosearch()' style='background-color:rgb(249,125,52);border-radius:5px;'>查询</button><button type='button' onclick='clearspconditions()'>清空</button>");
    ajaxforconditions("myProject");
}
function stuproapply(){
    ajaxforconditions("project");
}
function ajaxforconditions(symbol){
    $.ajax({
        url:"/"+symbol+"Conditions",
        type:"post",
        dataType:"json",
        success:function(data){
            var $conditions=$(".stuproconditions");
            var projectTypes=data.projectTypes;
            var projectStages=data.projectStages;
            for(var i=0;i<projectTypes.length;i++){
                var projectType=projectTypes[i];
                $conditions.find("select").eq(0).append("<option value='"+projectType.id+"'>"+projectType.name+"</option>");
            }
            for(var i=0;i<projectStages.length;i++){
                var projectStage=projectStages[i];
                $conditions.find("select").eq(1).append("<option value='"+projectStage.id+"'>"+projectStage.name+"</option>");
            }
            var projectStatus;
            if(typeof(data.projectStatus)=="undefined"){
                projectStatus=data.studentProjectStatus;
            }else{
                projectStatus=data.projectStatus;
            }
            for(var i=0;i<projectStatus.length;i++){
                var status=projectStatus[i];
                $conditions.find("select").eq(2).append("<option value='"+status.id+"'>"+status.name+"</option>");
            }
        },
        error:function(data){
            alert(data.responseText);
        }
    });
}
function clearspconditions(){
    var $conditions=$(".stuproconditions");
    $conditions.find("input").addClass("grey").val("请输入项目名称");
    $conditions.find("select").val(0);
}
function stuprosearch(){
    var $conditions=$(".stuproconditions");
    var $content=$(".stuprocontent");
    var projectname=$conditions.find("input").val();
    if(projectname=="请输入项目名称"){
        projectname="";
    }
    $content.html("");
    $.ajax({
        url:"/searchForProjects",
        type:"post",
        dataType:"json",
        data:{
            "studentid":id,
            "mystatus":$conditions.find("select").eq(2).val(),
            "projecttype":$conditions.find("select").eq(0).val(),
            "projectstage":$conditions.find("select").eq(1).val(),
            "projectname":projectname,
            "nowpage":nowpage,
            "rows":rows
        },
        success:function(data){
            var count=data.resultcount;
            if(count==0){
                alert("无符合查询条件的结果");
                return;
            }
            $content.append("<button type='button' style='background-color:rgb(249,125,52);border-radius:5px;width:100px;position:relative;left:800px;'>+&nbsp;项目申请</button>");
            $content.append("<table style='margin:10px;border-collapse:collapse;border:none;'></table>");
            var $table=$content.find("table");
            $table.append("<tr style='background-color:#eee;'></tr>");
            var $toptr=$table.find("tr");
            $toptr.append("<td>序号</td>");
            $toptr.append("<td>项目名称</td>");
            $toptr.append("<td>项目类型</td>");
            $toptr.append("<td>项目阶段</td>");
            $toptr.append("<td>项目状态</td>");
            $toptr.append("<td>我的状态</td>");
            $toptr.append("<td>指导教师</td>");
            $toptr.append("<td>操作</td>");
            var list=data.result;
            for(var i=0;i<list.length;i++){
                var project=list[i];
                $table.append("<tr></tr>");
                var $tr=$table.find("tr:last");
                $tr.append("<td>"+(i+1)+"</td>");
                $tr.append("<td>"+project.projectname+"</td>");
                $tr.append("<td>"+project.projecttypename+"</td>");
                $tr.append("<td>"+project.projectstagename+"</td>");
                $tr.append("<td>"+project.projectstatusname+"</td>");
                $tr.append("<td>"+project.mystatusname+"</td>");
                $tr.append("<td>"+project.teachername+"</td>");
                $tr.append("<td></td>");
            }
        },
        error:function(data){
            alert(data.responseText);
        }
    });
}