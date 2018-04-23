/**
 * Created by 我是博文你是谁 on 2018/4/2.
 */
//渲染下拉列表
$(function () {
    initSelect();
    $('#finalSex').bind( 'input select propertychange',function () {
        $.ajax({
            type:"get",
            url:"../static/vendors/sports.json",
            dataType:'JSON',
            success:function (res) {
                $('#final').empty();
                if($('#finalSex').val()=='男'){
                    for(var i=0;i<res.boy.length;i++){
                        $('#final').append("<option value='"+res.boy[i].code+"'>"+res.boy[i].name+"</option>")
                    }
                }else if($('#finalSex').val()=='女'){
                    for(var i=0;i<res.girl.length;i++){
                        $('#final').append("<option value='"+res.girl[i].code+"'>"+res.girl[i].name+"</option>")
                    }
                }

            },
            error:function (res) {

            }
        })
    })
    $('#proSex').bind('input select propertychange',function () {
        $.ajax({
            type:"get",
            url:"../static/vendors/sports.json",
            dataType:'JSON',
            success:function (res) {
                $('#prePro').empty();
                if($('#proSex').val()=='男'){
                    for(var i=0;i<res.boy.length;i++){
                        $('#prePro').append("<option value='"+res.boy[i].code+"'>"+res.boy[i].name+"</option>")
                    }
                }else if($('#proSex').val()=='女'){
                    for(var i=0;i<res.girl.length;i++){
                        $('#prePro').append("<option value='"+res.girl[i].code+"'>"+res.girl[i].name+"</option>")
                    }
                }

            },
            error:function (res) {

            }
        })
    })
})
function initSelect() {
    $.ajax({
        type:"get",
        url:"../static/vendors/sports.json",
        dataType:'JSON',
        success:function (res) {
            console.log(res);
            $('#final').empty();
            for(var i=0;i<res.boy.length;i++){
                $('#final').append("<option value='"+res.boy[i].code+"'>"+res.boy[i].name+"</option>")
            }
            $('#prePro').empty();
            for(var i=0;i<res.boy.length;i++){
                $('#prePro').append("<option value='"+res.boy[i].code+"'>"+res.boy[i].name+"</option>")
            }

            $('#teamPro').empty();
            for(var i=0;i<res.group.length;i++){
                $('#teamPro').append("<option value='"+res.group[i].code+"'>"+res.group[i].name+"</option>")
            }
        },
        error:function (res) {

        }
    })
}
