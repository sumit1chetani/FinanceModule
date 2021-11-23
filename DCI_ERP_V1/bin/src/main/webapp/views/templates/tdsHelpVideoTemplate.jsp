<style>
.ngdialog-content{
width: 81% !important;
  bottom: 160px !important;
  margin: 0 auto !important;
  margin-top: 2% !important;
}

</style>

<div class="modal-header">{{headerName}}</div>
<div class="row">
<div class="width_97 m-n-auto">
   
 <video width="1024" height="500" controls=""  autoplay> 
       <source ng-src="{{helpVideoPath}}"  type="video/mp4" >{{helpVideoPath}}
 </video>

</div>
</div>
<div class="modal-footer">
	<button class="btn btn-danger" ng-click="closeHelpDialog()">Close</button>
</div>