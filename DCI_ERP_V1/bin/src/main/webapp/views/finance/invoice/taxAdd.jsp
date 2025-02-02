<div id="content">
 <div class="row">
  <article>
  <hot-table
       settings="{colHeaders: colHeaders, contextMenu: ['row_above', 'row_below', 'remove_row'], afterChange: afterChange }"
       rowHeaders="false"
       minSpareRows="minSpareRows"
       datarows="db.items"
       height="300"
       width="700">
       <hot-column data="id"                  title="'ID'"></hot-column>
       <hot-column data="name.first"          title="'First Name'"  type="grayedOut"  readOnly></hot-column>
       <hot-column data="name.last"           title="'Last Name'"   type="grayedOut"  readOnly></hot-column>
       <hot-column data="address"             title="'Address'" width="150"></hot-column>
       <hot-column data="product.description" title="'Favorite food'" type="'autocomplete'">
        <hot-autocomplete datarows="description in product.options"></hot-autocomplete>
       </hot-column>
       <hot-column data="price"               title="'Price'"     type="'numeric'"  width="80"  format="'$ 0,0.00'" ></hot-column>
       <hot-column data="isActive"            title="'Is active'" type="'checkbox'" width="65"  checkedTemplate="'Yes'" uncheckedTemplate="'No'"></hot-column>
      </hot-table>
   </article>
 </div>
</div>
