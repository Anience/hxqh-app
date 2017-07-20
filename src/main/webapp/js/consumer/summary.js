$(function(){
	init();
	function init(){
		$.ajax({
			url: _ctx+"/ano/voiceData",
			method: "get",
			dataType: "json",
			success: function (data) {

			},
			error: function () {

			}
		});
	}
});