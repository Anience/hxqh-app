var  entUtil = function(){

};
entUtil.prototype={
    constructor: entUtil,
    dealData:  function(data){
        var dealedData = {};
        //处理后台传回的数据为空的状态
        if(data.rightnowList.length==0){
            dealedData.leftTop = {
                closenums: undefined,
                opennums: undefined
            };
        }else{
            dealedData.leftTop = data.rightnowList[0];
        };
        if(data.proactiveList.length==0){
            dealedData.leftBottom = {
                closenums: undefined,
                opennums: undefined
            };
        }else{
            dealedData.leftBottom = data.proactiveList[0];
        }
        dealedData.middleTop = data.rightnowTicketM;
        dealedData.middleTopName = data.nameList;
        dealedData. middleBottom = data.proactiveTicketM;
        dealedData.middleBottomName = data.nameList;
        dealedData.rightTop = data.enterpriseRegionMap;
        dealedData.rightTopName = data.regionNameList;
        dealedData.rightBottom = data.enterpriseProductMap;
        dealedData.rightBName = data.productNameList;
        return dealedData;
    },
    headerInit:function(data,domName){
        var self = this;
        //页面用户名展示
        $(".ent-header h4").text(data.name);
        //sla数据展示
        self.ShowSla(data.threeColor,domName);
        //event
        self.showEvent(data.eventList,domName);
        //图标展示
        self.showLogo(data.iconList,domName);
    },
    ShowSla: function (data,domName){
        var colorData1 = data;
        var eq = colorData1.eq ==null?'0':colorData1.eq;
        var gt = colorData1.gt ==null?'0':colorData1.gt;
        var lt = colorData1.lt ==null?'0':colorData1.lt;
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
                imgUrl = _ctx+'/imgs/blue/'+logoList[i].lay+'.png';
            }else{
                imgUrl = _ctx+'/imgs/red/'+logoList[i].lay+'.png';
            }
            $(className).show();
            $(className).attr('src',imgUrl);
        }
    }
}