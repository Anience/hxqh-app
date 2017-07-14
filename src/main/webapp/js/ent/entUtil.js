$(function(window){
    var EntUtil = function(){

    }
    EntUtil.fn = entUtil.prototype={
        constructor: EntUtil,
        ShowSla: function(data,domName){
                var colorData1 = data;
                var cust = colorData1.cust ==null?'':colorData1.cust;
                var eq = colorData1.eq ==null?'0':colorData1.eq;
                var gt = colorData1.gt ==null?'0':colorData1.gt;
                var lt = colorData1.lt ==null?'0':colorData1.lt;
                $(domName+" "+".span-layout .sla").text(cust);
                $(domName+" "+".span-layout .red").text(eq);
                $(domName+" "+".span-layout .yellow").text(gt);
                $(domName+" "+".span-layout .green").text(lt);
        },
        showEvent: function(data,domName){
                var events = data;
                var trHtml ="";
                for(var i =0,len=events.length;i<len;i++){
                    var event = events[i].affevent;
                    var time = event.split(" ")[0];
                    var other = event.split("/")[3];
                    trHtml+="<tr><td>"+time+"/"+other+"</td></tr>";
                    $(domName+" "+".top1-event table").show();
               }
            $(domName+" "+".top1-event table tbody").html(trHtml);
        },
        showLogo: function(data,domName){
            var logoList = data;
            for(var i=0,len=logoList.length;i<len;i++){
                var className = domName+' '+'.'+logoList[i].lay;
                var imgUrl = '';
                if(logoList[i].status=='0'){
                    imgUrl = _ctx+'/imgs/red/'+logoList[i].lay+'.png';
                }else{
                    imgUrl = _ctx+'/imgs/blue/'+logoList[i].lay+'.png';
                }
                $(className).show();
                $(className).attr('src',imgUrl);
            }
        }

    }
    window.entUtill = new EntUtil();
});