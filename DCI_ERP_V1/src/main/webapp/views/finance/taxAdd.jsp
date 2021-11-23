<div id="content">
 <div class="row">
  <article>
   <hot-table settings="{rowHeaders: false,  contextMenu: ['row_above', 'row_below', 'remove_row'], afterChange: afterChange}" colHeaders="true" datarows="db.items"
    columns="db.dynamicColumns" height="300" width="700"></hot-table>
  </article>
  <button ng-click="addData()" >add</button>
 </div>
</div>