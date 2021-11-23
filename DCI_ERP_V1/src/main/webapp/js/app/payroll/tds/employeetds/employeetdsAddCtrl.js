define([ 'payroll/tds/tds'], function(module) {

    'use strict';
    
    module.registerController('employeetdsAddCtrl', function($scope,$state,$http) {
        var tpl = ['Tax Computation'];
        var tpl1 = ['Gross Salary'];
        var tpl2 = ['Professional Tax'];
        var tpl3 = ['Exemptions under section 10 & 17'];
        var tpl4 = ['Accommodation & Car Perquisites'];
        var tpl5 = ['Income chargeable under head House/Property'];
        var tpl6 = ['Income chargeable under head Capital Gains at nominal rate'];
        var tpl7 = ['Income chargeable under head Capital Gains at nominal rate'];
        var tpl8 = ['Income chargeable under head Other Sources'];
        var tpl9 = ['Gross Total Income'];
        var tpl10 = ['Deductions under chapter VI-A'];
        var tpl11 = ['Deductions under sec 80C'];
        var tpl12 = ['Net taxable income'];
        
        //Excemption
        var Excemption = [' Exemptions under section 10 & 17 '];     
        var Excemption1 = [' HRA Exemption (sec 10 (13A))  '];               
        var Excemption2 = [' Transport Exemption (sec 10(14))  '];                      
        var Excemption3 = [' Other exemptions under sec 10 (10) (gratuity, etc.)'];              
        var Excemption4 = ['  Medical Bills Exemption (sec 17(2))   '];             
        var Excemption5= ['  Children Education Allowance Exemption (sec 10 (14)) '];  
        var Excemption6 = [' LTA exemption (sec 10(5))    '];            
        var Excemption7 = ['  Uniform expenses (sec 10(14))  '];                
        var Excemption8 = [' Total Exempted Allowances    '];   
        var Excemption9 = [' Produced '];  
        var Excemption10 = ['Limited'];  
        var income5 = [' Produced '];  
        var income6 = ['Limited'];  
         var income =  ['Other income Produced Limited'];
         var income1 = ['House/property income or loss (enter loss as negative) '];             
         var income2 = ['Interest on housing loan (for tax exemption) '];                
         var income3 = [' Savings Bank interest   '];    
         var income4 = ['Other income (interest, etc. excluding. SB int)  '];     
         var Deductions = ['Deductions under Chapter VI-A  Produced Limited'];  
         var Deductions1 = [' Medical Insurance Premium / health check (sec 80D) '];                  
          var Deductions2 = ['Medical Insurance Premium for parents (sec 80D)  '];              
           var Deductions3 = ['Medical for handicapped dependents (sec 80DD)  '];                  
            var Deductions4 = ['Medical for specified diseases (sec 80DDB)  '];                 
            var Deductions5= ['Higher Education Loan Interest Repayment (sec 80E)  '];               
           var Deductions6= ['Donation to approved fund and charities (sec 80G)   '];                  
          var Deductions7 = [' Rent deduction (sec 80GG) only if HRA not received  '];  
            var Deductions8 = ['  Savings Bank interest exemption (sec 80TTA)    '];                   
              var Deductions9 = [' Deduction for permanent disability (sec 80U)    '];                     
              var Deductions10 = ['  Any other deductions (incl. donations u/s 35AC/80GGA)   '];                 
              var Deductions11= [' Total Deductibles '];   
              var Deductions12= ['Produced '];   
              var Deductions13= ['Limited '];  
              var chapSix = [' Deductions under Chapter VI (sec 80C)  '];             
              var chapSix1 = [' National Pension scheme (sec 80CCD)    '];             
              var chapSix2 = ['Pension scheme (sec 80C)    '];              
              var chapSix3 = [' NSC (sec 80C)      '];         
              var chapSix4 = ['Public Provident Fund (sec 80C)    '];         
              var chapSix5 = [' Employees Provident Fund & Voluntary PF (sec 80C)  '];                 
              var chapSix6 = [' Childrens Education Tuition Fees (sec 80C)   '];          
              var chapSix7 = [' Housing loan principal repayment, regn/stamp duty (sec 80C)   '];           
              var chapSix8 = [' Insurance premium & others (MF, ULIP, FD, SS, etc.) (sec 80C)    '];      
              var chapSix9 = [' Rajiv Gandhi Equity Savings Scheme (sec 80CCG) '];           
              var chapSix10 = ['Total Investments   '];    
              var chapSix11 = ['Produced'];  
              var chapSix12 = ['Limited'];  
                                  
              var taxHeading1 = ['Tax Slabs'];
              var taxHeading2 = ['Tax Rate'];
              var taxHeading3 = ['Appl Amt'];
              var taxHeading4 = ['Balance'];
              var taxHeading5 = ['Tax'];

                                             
              var tax1 = [' 00000'];           
              var tax2 = ['250001 '];           
              var tax3 = ['500001 '];              
              var tax4 = [' > 1000000      '];        
              var tax5 = ['Tax credit (Sec 87A) '];  
              var hyphen1 = ['-'];
              var hyphen2 = ['-'];
              var hyphen3 = ['-'];
              var tax16 = [' 250000 '];    
              var tax17 = [' 250000 '];    
              var tax18 = [' 250000 '];    
              
              var tax6= ['Tax on Income'];                
              var tax7 = ['Capital Gains Tax (from Stocks & MFs) '];                     
              var tax8 = [' Capital Gains Tax (from Property)'];                      
              var tax9 = ['Surcharge on Income Tax     '];                    
              var tax10 = ['Education Cess       '];               
              var tax11 = ['Total Tax Liability   '];                   
              var tax12 = ['Total Income tax paid from salary  '];              
              var tax13 = ['Tax paid outside of salary    '];                  
              var tax14 = ['Income tax due                '];         
              var tax15 = ['Remaining months in year     '];    

        var tdsHandson = new Handsontable(document.getElementById('employeeTDS'), {
            startRows: 80,
            startCols: 16,  
           mergeCells: [
                         {row: 40, col:0, rowspan:1, colspan:5},
                         {row: 41, col:0, rowspan:1, colspan:5},
                         {row: 42, col:0, rowspan:1, colspan:5},
                         {row: 43, col:0, rowspan:1, colspan:5},
                         {row: 44, col:0, rowspan:1, colspan:5},
                         {row: 45, col:0, rowspan:1, colspan:5},
                         {row: 46, col:0, rowspan:1, colspan:5},
                         {row: 47, col:0, rowspan:1, colspan:5},
                         {row: 48, col:0, rowspan:1, colspan:5},
                         {row: 49, col:0, rowspan:1, colspan:5},
                         {row: 50, col:0, rowspan:1, colspan:5},
                         {row: 51, col:0, rowspan:1, colspan:5},
                         {row: 40, col:8, rowspan:1, colspan:6},
                         {row: 41, col:8, rowspan:1, colspan:6},
                         {row: 42, col:8, rowspan:1, colspan:6},
                         {row: 43, col:8, rowspan:1, colspan:6},
                         {row: 44, col:8, rowspan:1, colspan:6},
                         {row: 45, col:8, rowspan:1, colspan:6},
                         {row: 46, col:8, rowspan:1, colspan:6},
                         {row: 47, col:8, rowspan:1, colspan:6},
                         {row: 48, col:8, rowspan:1, colspan:6},
                         {row: 49, col:8, rowspan:1, colspan:6},
                         {row: 50, col:8, rowspan:1, colspan:6},
                         {row: 51, col:8, rowspan:1, colspan:6},
                         {row: 52, col:8, rowspan:1, colspan:6},
                         {row: 53, col:8, rowspan:1, colspan:6},
                         {row: 54, col:8, rowspan:1, colspan:6},
                         {row: 55, col:8, rowspan:1, colspan:6},
                         {row: 56, col:8, rowspan:1, colspan:6},
                         {row: 57, col:8, rowspan:1, colspan:6},
                         {row: 58, col:8, rowspan:1, colspan:6},
                         {row: 59, col:8, rowspan:1, colspan:6},
                         {row: 60, col:8, rowspan:1, colspan:6},
                         {row: 61, col:8, rowspan:1, colspan:6},
                         {row: 62, col:8, rowspan:1, colspan:6},
                         {row: 63, col:8, rowspan:1, colspan:6},
                         {row: 64, col:8, rowspan:1, colspan:6},
                         {row: 65, col:8, rowspan:1, colspan:6},
                         {row: 66, col:8, rowspan:1, colspan:6},
                         {row: 67, col:8, rowspan:1, colspan:6},
                         {row: 70, col:8, rowspan:1, colspan:6},
                         {row: 71, col:8, rowspan:1, colspan:6},
                         {row: 72, col:8, rowspan:1, colspan:6},
                         {row: 73, col:8, rowspan:1, colspan:6},
                         {row: 74, col:8, rowspan:1, colspan:6},
                         {row: 75, col:8, rowspan:1, colspan:6},
                         {row: 76, col:8, rowspan:1, colspan:6},
                         {row: 77, col:8, rowspan:1, colspan:6},
                         {row: 78, col:8, rowspan:1, colspan:6},
                         {row: 79, col:8, rowspan:1, colspan:6},
                         {row: 80, col:8, rowspan:1, colspan:6},
                         {row: 52, col:8, rowspan:1, colspan:6},
                         {row: 53, col:8, rowspan:1, colspan:6},
                         {row: 61, col:0, rowspan:1, colspan:6},
                         {row: 62, col:0, rowspan:1, colspan:6},
                         {row: 63, col:0, rowspan:1, colspan:6},
                         {row: 64, col:0, rowspan:1, colspan:6},
                         {row: 65, col:0, rowspan:1, colspan:6},
                         {row: 59, col:0, rowspan:1, colspan:2},
                         {row: 53, col:0, rowspan:1, colspan:2},
                         {row: 60, col:0, rowspan:1, colspan:6},
                         {row: 66, col:0, rowspan:1, colspan:6},
                         {row: 67, col:0, rowspan:1, colspan:6},
                         {row: 68, col:0, rowspan:1, colspan:6},
                         {row: 69, col:0, rowspan:1, colspan:6},
                         
                       ],
            stretchH : 'all',
            contextMenu : true,
            colWidths : [ 60,40, 40, 40,40,40, 40, 40, 40, 40, 40, 40, 40, 40,40],
            colHeaders : ['Incl PF?','Apr','May','Jun','Jul','Aug','Sep','Oct','Nov','Dec','Jan','Feb','Mar','Total','Perks','Bonus'],
         //  rowHeaders : ['Basic', 'DA', 'Convey','HRA', 'Ch. Educ', 'Medical', 'LTA', 'Uniform All', 'Misc', 'Misc', 'Misc', 'Misc', 'Misc', 'Misc', 'Misc', 'Misc', 'Misc', 'Misc','Total','Prof Tax','PF','VPF','IT','Rent','Life Insurance','Oth Ded','Oth Ded','Oth Ded','Oth Ded','Oth Ded','Oth Ded','Oth Ded','Oth Ded','Oth Ded','Tot Ded','Net','Loan/Wdwl','OB','Int','CB'],
           columns : [
                      {
               data : 'Inclpf',
               type : 'numeric'
           }, {
               data : 'Apr',
               type : 'numeric'
           }, {
               data : 'May',
               type : 'numeric'
           },
           {
               data : 'Jun',
               type : 'numeric'
           },
           {
               data : 'Jul',
               type : 'numeric'
           }, {
               data : 'Aug',
               type : 'numeric'
           }, {
               data : 'Sep',
               type : 'numeric'
           }, {
               data : 'Oct',
               type : 'numeric'
           }, {
               data : 'Nov',
               type : 'numeric'
           }, {
               data : 'Dec',
               type : 'numeric'
           }, {
               data : 'JanR',
               type : 'numeric'
           }, {
               data : 'FebR',
               type : 'numeric'
           }, {
               data : 'MarR',
               type : 'numeric'
           }, {
               data : 'Total',
               type : 'numeric'
           }, {
               data : 'Perks',
               type : 'numeric'
           }, {
               data : 'Bonus',
               type : 'numeric'
           },
         ],  
         row : [
                    {
             data : 'pf',
             type : 'numeric'
         }], 
      afterChange : function(change, source) {
             
             if (source === 'loadData') {
                 return;
             } else {
          
                 var rownum = change[0][0];      
                 var rlen = tdsHandson.countRows();
        
                var colIndex=rownum;
               
                if( change[0][1] == 'Inclpf'|| change[0][1] == 'Apr'|| change[0][1] == 'May'|| change[0][1] == 'Jun'|| change[0][1] == 'Jul'|| change[0][1] == 'Aug'|| change[0][1] == 'Sep'|| change[0][1] == 'Oct'|| change[0][1] == 'Nov'|| change[0][1] == 'Dec'|| change[0][1] == 'JanR'|| change[0][1] == 'FebR' || change[0][1] == 'MarR')
                   {
                 //   for ( var i = 0; i < rlen; i++) {
                     var a = 0;
                     var pf = (tdsHandson.getDataAtRowProp(colIndex, 'pf') == null) ? 0 : tdsHandson.getDataAtRowProp(colIndex, 'pf');
                     var apl = (tdsHandson.getDataAtRowProp(colIndex, 'Apr') == null) ? 0 : tdsHandson.getDataAtRowProp(colIndex, 'Apr');
                     var may = (tdsHandson.getDataAtRowProp(colIndex, 'May') == null) ? 0 : tdsHandson.getDataAtRowProp(colIndex, 'May');
                     var jun = (tdsHandson.getDataAtRowProp(colIndex, 'Jun') == null) ? 0 : tdsHandson.getDataAtRowProp(colIndex, 'Jun');
                     var july = (tdsHandson.getDataAtRowProp(colIndex, 'Jul') == null) ? 0 : tdsHandson.getDataAtRowProp(colIndex, 'Jul');
                     var aug = (tdsHandson.getDataAtRowProp(colIndex, 'Aug') == null) ? 0 : tdsHandson.getDataAtRowProp(colIndex, 'Aug');
                     var sep = (tdsHandson.getDataAtRowProp(colIndex, 'Sep') == null) ? 0 : tdsHandson.getDataAtRowProp(colIndex, 'Sep');
                     var oct = (tdsHandson.getDataAtRowProp(colIndex, 'Oct') == null) ? 0 : tdsHandson.getDataAtRowProp(colIndex, 'Oct');
                     var nov = (tdsHandson.getDataAtRowProp(colIndex, 'Nov') == null) ? 0 : tdsHandson.getDataAtRowProp(colIndex, 'Nov');
                     var dec = (tdsHandson.getDataAtRowProp(colIndex, 'Dec') == null) ? 0 : tdsHandson.getDataAtRowProp(colIndex, 'Dec');
                     var janR = (tdsHandson.getDataAtRowProp(colIndex, 'JanR') == null) ? 0 : tdsHandson.getDataAtRowProp(colIndex, 'JanR');
                     var febR = (tdsHandson.getDataAtRowProp(colIndex, 'FebR') == null) ? 0 : tdsHandson.getDataAtRowProp(colIndex, 'FebR');
                     var marchR = (tdsHandson.getDataAtRowProp(colIndex, 'MarR') == null) ? 0 : tdsHandson.getDataAtRowProp(colIndex, 'MarR');
                     var total = (tdsHandson.getDataAtRowProp(colIndex, 'Total') == null) ? 0 : tdsHandson.getDataAtRowProp(colIndex, 'Total');
                     if (rownum ==colIndex) {
                          a = (isNaN(parseInt(apl)) ? 0 : parseInt(apl)) +  (isNaN(parseInt(may)) ? 0 : parseInt(may)) +  (isNaN(parseInt(jun)) ? 0 : parseInt(jun)) + (isNaN(parseInt(july)) ? 0 : parseInt(july)) + (isNaN(parseInt(aug)) ? 0 : parseInt(aug)) + (isNaN(parseInt(sep)) ? 0 : parseInt(sep)) + (isNaN(parseInt(oct)) ? 0 : parseInt(oct)) + (isNaN(parseInt(nov)) ? 0 : parseInt(nov)) + (isNaN(parseInt(dec)) ? 0 : parseInt(dec)) + (isNaN(parseInt(janR)) ? 0 : parseInt(janR)) +  (isNaN(parseInt(febR)) ? 0 : parseInt(febR)+ (isNaN(parseInt(marchR)) ? 0 : parseInt(marchR)));
                         tdsHandson.setDataAtRowProp(rownum, 'Total',a);
                 }
                        a  = (isNaN(parseInt(apl)) ? 0 : parseInt(apl)) +  (isNaN(parseInt(may)) ? 0 : parseInt(may)) +  (isNaN(parseInt(jun)) ? 0 : parseInt(jun)) + (isNaN(parseInt(july)) ? 0 : parseInt(july)) + (isNaN(parseInt(aug)) ? 0 : parseInt(aug)) + (isNaN(parseInt(sep)) ? 0 : parseInt(sep)) + (isNaN(parseInt(oct)) ? 0 : parseInt(oct)) + (isNaN(parseInt(nov)) ? 0 : parseInt(nov)) + (isNaN(parseInt(dec)) ? 0 : parseInt(dec)) + (isNaN(parseInt(janR)) ? 0 : parseInt(janR)) +  (isNaN(parseInt(febR)) ? 0 : parseInt(febR)+ (isNaN(parseInt(marchR)) ? 0 : parseInt(marchR)));
                   //  tdsHandson.setDataAtRowProp(rownum, 'Total',a);
                     console.log("full total");
                     console.log( a);
                  //  }
             
                   }
                
          } 
         },
           cells: function (row, col, prop) {
               var cellProperties = {};
            cellProperties.renderer = defaultValueRenderer;
/*          if (row == 18 && col == 13) {
                return { type: { renderer: SumRowRenderer,readOnly: true}};
             } */

               return cellProperties;
             },
            
  customBorders: [
{
    range: {
      from: {
        row: 40,
        col: 8
      },
      to: {
        row: 41,
        col: 15
      }
    },

    left: {
      width: 2,
      color: 'black'
    },
    right: {
      width: 2,
      color: 'black'
    },
    top: {
        width: 2,
        color: 'black'
      },
      bottom: {
          width: 2,
          color: 'black'
        }
  },
  {
      range: {
        from: {
          row: 53,
          col: 0
        },
        to: {
          row: 57,
          col: 6
        }
      },

      left: {
        width: 2,
        color: 'black'
      },
      right: {
        width: 2,
        color: 'black'
      },
      top: {
          width: 2,
          color: 'black'
        },
        bottom: {
            width: 2,
            color: 'black'
          }
    },
  {
      range: {
        from: {
          row: 56,
          col: 8
        },
        to: {
          row: 57,
          col: 15
        }
      },

      left: {
        width: 2,
        color: 'black'
      },
      right: {
        width: 2,
        color: 'black'
      },
      top: {
          width: 2,
          color: 'black'
        },
        bottom: {
            width: 2,
            color: 'black'
          }
    },
{
    range: {
      from: {
        row: 40,
        col: 0
      },
      to: {
        row: 41,
        col: 6
      }
    },

    left: {
      width: 2,
      color: 'black'
    },
    right: {
      width: 2,
      color: 'black'
    },
    top: {
        width: 2,
        color: 'black'
      }
  },      {
                               range: {
                                 from: {
                                   row: 41,
                                   col: 0
                                 },
                                 to: {
                                   row: 51,
                                   col: 6
                                 }
                               },
                               top: {
                                 width: 2,
                                 color: 'black'
                               },
                               left: {
                                 width: 2,
                                 color: 'black'
                               },
                               bottom: {
                                 width: 2,
                                 color: 'black'
                               },
                               right: {
                                 width: 2,
                                 color: 'black'
                               }
                             },
                             {
                                 range: {
                                   from: {
                                     row: 41,
                                     col: 8
                                   },
                                   to: {
                                     row: 48,
                                     col: 15
                                   }
                                 },
                                 top: {
                                   width: 2,
                                   color: 'black'
                                 },
                                 left: {
                                   width: 2,
                                   color: 'black'
                                 },
                                 bottom: {
                                   width: 2,
                                   color: 'black'
                                 },
                                 right: {
                                   width: 2,
                                   color: 'black'
                                 }
                               },
                               {
                                   range: {
                                     from: {
                                       row: 50,
                                       col: 8
                                     },
                                     to: {
                                       row: 54,
                                       col: 15
                                     }
                                   },
                                   top: {
                                     width: 2,
                                     color: 'black'
                                   },
                                   left: {
                                     width: 2,
                                     color: 'black'
                                   },
                                   bottom: {
                                     width: 2,
                                     color: 'black'
                                   },
                                   right: {
                                     width: 2,
                                     color: 'black'
                                   }
                                 },
                                 {
                                     range: {
                                       from: {
                                         row: 57,
                                         col: 8
                                       },
                                       to: {
                                         row: 68,
                                         col: 15
                                       }
                                     },
                                     top: {
                                       width: 2,
                                       color: 'black'
                                     },
                                     left: {
                                       width: 2,
                                       color: 'black'
                                     },
                                     bottom: {
                                       width: 2,
                                       color: 'black'
                                     },
                                     right: {
                                       width: 2,
                                       color: 'black'
                                     }
                                   },
                                   {
                                       range: {
                                         from: {
                                           row: 71,
                                           col: 8
                                         },
                                         to: {
                                           row: 80,
                                           col: 15
                                         }
                                       },
                                       top: {
                                         width: 2,
                                         color: 'black'
                                       },
                                       left: {
                                         width: 2,
                                         color: 'black'
                                       },
                                       bottom: {
                                         width: 2,
                                         color: 'black'
                                       },
                                       right: {
                                         width: 2,
                                         color: 'black'
                                       }
                                     },
                                     {
                                         range: {
                                           from: {
                                             row: 54,
                                             col: 0
                                           },
                                           to: {
                                             row: 55,
                                             col: 6
                                           }
                                         },
                                         top: {
                                             width: 2,
                                             color: 'black'
                                           },
                                           left: {
                                             width: 2,
                                             color: 'black'
                                           },
                                           right: {
                                             width: 2,
                                             color: 'black'
                                           }
                                         
                                       },
                                       {
                                           range: {
                                             from: {
                                               row: 60,
                                               col: 0
                                             },
                                             to: {
                                               row: 69,
                                               col: 6
                                             }
                                           },
                                           top: {
                                               width: 2,
                                               color: 'black'
                                             },
                                             left: {
                                               width: 2,
                                               color: 'black'
                                             },
                                             right: {
                                               width: 2,
                                               color: 'black'
                                             },
                                             bottom: {
                                                 width: 2,
                                                 color: 'black'
                                               },
                                         },
                             ]
            })
        
        
        function SumRowRenderer(instance, td, row, col, prop, value, cellProperties) {
           // instance.setdataAtCell(row,col,price * count);
          //  var total = instance.getDataAtCell(1, 13) + instance.getDataAtCell(1, 14);
         //   var total = $("#tdsHandson").handsontable('getCell', 0, 13);
            console.log("total");
            var total = instance.getDataAtCell(1, 13);
            var total2 = instance.getDataAtCell(2, 13);
             var fulltotal = total + total2;
            console.log(fulltotal)
   
        }
        
        function defaultValueRenderer(instance, td, row, col, prop, value, cellProperties) {
            var args = arguments;
            
            if (args[2] == 0 && args[3] == 1)  {
                args[5] = tax7[0];
                td.style.color = '#222';
              }

            if (args[2] == 40) {
              args[5] = tpl[col];
              td.style.color = '#3a3a3a';
            }
            if (args[2] == 41) {
                args[5] = tpl1[col];
                td.style.color = '#222';
              }
            if (args[2] == 42) {
                args[5] = tpl2[col];
                td.style.color = '#222';
              }
            if (args[2] == 43) {
                args[5] = tpl3[col];
                td.style.color = '#222';
              }
            if (args[2] == 44) {
                args[5] = tpl4[col];
                td.style.color = '#222';
              }
            if (args[2] == 45) {
                args[5] = tpl5[col];
                td.style.color = '#222';
              }
            if (args[2] == 46) {
                args[5] = tpl6[col];
                td.style.color = '#222';
              }
            if (args[2] == 47) {
                args[5] = tpl7[col];
                td.style.color = '#222';
              }
            if (args[2] == 48) {
                args[5] = tpl8[col];
                td.style.color = '#222';
              }
            if (args[2] == 49) {
                args[5] = tpl9[col];
                td.style.color = '#222';
              } 
            if (args[2] == 50) {
                args[5] = tpl10[col];
                td.style.color = '#222';
              }
            if (args[2] == 51) {
                args[5] = tpl11[col];
                td.style.color = '#222';
              }
       
          if (args[2] == 40 && args[3] == 8)  {
                args[5] = Excemption[0];
                td.style.color = '#333';
              }
           if (args[2] == 41 && args[3] == 8)  {
              args[5] = Excemption1[0];
              td.style.color = '#222';
            }
               if (args[2] == 42 && args[3] == 8)  {
              args[5] = Excemption2[0];
              td.style.color = '#222';
            }
             if (args[2] == 43 && args[3] == 8)  {
              args[5] = Excemption3[0];
              td.style.color = '#222';
            }
           if (args[2] == 44 && args[3] == 8)  {
              args[5] = Excemption4[0];
              td.style.color = '#222';
             }
         if (args[2] == 45 && args[3] == 8)  {
              args[5] = Excemption5[0];
              td.style.color = '#222';
            }
          
         if (args[2] == 46 && args[3] == 8)  {
              args[5] = Excemption6[0];
              td.style.color = '#222';
            }
         if (args[2] == 47 && args[3] == 8)  {
              args[5] = Excemption7[0];
              td.style.color = '#222';
            }
         if (args[2] == 48 && args[3] == 8)  {
              args[5] = Excemption8[0];
              td.style.color = '#222';
            }
         if (args[2] == 40 && args[3] == 14)  {
             args[5] = Excemption9[0];
             td.style.color = '#222';
           }
         if (args[2] == 40 && args[3] == 15)  {
             args[5] = Excemption10[0];
             td.style.color = '#222';
           }
         if (args[2] == 49 && args[3] == 8)  {
             args[5] = income[0];
             td.style.color = '#222';
           }
         if (args[2] == 50 && args[3] == 8)  {
             args[5] = income1[0];
             td.style.color = '#222';
           }
         if (args[2] == 51 && args[3] == 8)  {
             args[5] = income2[0];
             td.style.color = '#222';
           }
         if (args[2] == 52 && args[3] == 8)  {
             args[5] = income3[0];
             td.style.color = '#222';
           }
         if (args[2] == 53 && args[3] == 8)  {
             args[5] = income4[0];
             td.style.color = '#222';
           }
         if (args[2] == 50 && args[3] == 14)  {
             args[5] = income5[0];
             td.style.color = '#222';
           }
         if (args[2] == 50 && args[3] == 15)  {
             args[5] = income6[0];
             td.style.color = '#222';
           }
         if (args[2] == 56 && args[3] == 8)  {
             args[5] = Deductions[0];
             td.style.color = '#222';
           }
         if (args[2] == 57 && args[3] == 8)  {
             args[5] = Deductions1[0];
             td.style.color = '#222';
           }
         //de
         if (args[2] == 58 && args[3] == 8)  {
             args[5] = Deductions2[0];
             td.style.color = '#222';
           }
         if (args[2] == 59 && args[3] == 8)  {
             args[5] = Deductions3[0];
             td.style.color = '#222';
           }
         if (args[2] == 60 && args[3] == 8)  {
             args[5] = Deductions4[0];
             td.style.color = '#222';
           }
         if (args[2] == 61 && args[3] == 8)  {
             args[5] = Deductions5[0];
             td.style.color = '#222';
           }
         if (args[2] == 62 && args[3] == 8)  {
             args[5] = Deductions6[0];
             td.style.color = '#222';
           }
         if (args[2] == 63 && args[3] == 8)  {
             args[5] = Deductions7[0];
             td.style.color = '#222';
           }
         if (args[2] == 64 && args[3] == 8)  {
             args[5] = Deductions8[0];
             td.style.color = '#222';
           }
         if (args[2] == 65 && args[3] == 8)  {
             args[5] = Deductions9[0];
             td.style.color = '#222';
           }
         if (args[2] == 66 && args[3] == 8)  {
             args[5] = Deductions10[0];
             td.style.color = '#222';
           }
         if (args[2] == 67 && args[3] == 8)  {
             args[5] = Deductions11[0];
             td.style.color = '#222';
           }
         if (args[2] == 56 && args[3] == 14)  {
             args[5] = Deductions12[0];
             td.style.color = '#222';
           }
         if (args[2] == 56 && args[3] == 15)  {
             args[5] = Deductions13[0];
             td.style.color = '#222';
           }
//insix
         if (args[2] == 70 && args[3] == 8)  {
             args[5] = chapSix[0];
             td.style.color = '#222';
           }

         if (args[2] == 71 && args[3] == 8)  {
             args[5] = chapSix1[0];
             td.style.color = '#222';
           }

         if (args[2] == 72 && args[3] == 8)  {
             args[5] = chapSix2[0];
             td.style.color = '#222';
           }

         if (args[2] == 73 && args[3] == 8)  {
             args[5] = chapSix3[0];
             td.style.color = '#222';
           }

         if (args[2] == 74 && args[3] == 8)  {
             args[5] = chapSix4[0];
             td.style.color = '#222';
           }

         if (args[2] == 75 && args[3] == 8)  {
             args[5] = chapSix5[0];
             td.style.color = '#222';
           }

         if (args[2] == 76 && args[3] == 8)  {
             args[5] = chapSix6[0];
             td.style.color = '#222';
           }

         if (args[2] == 77 && args[3] == 8)  {
             args[5] = chapSix7[0];
             td.style.color = '#222';
           }

         if (args[2] == 78 && args[3] == 8)  {
             args[5] = chapSix8[0];
             td.style.color = '#222';
           }

         if (args[2] == 79 && args[3] == 8)  {
             args[5] = chapSix9[0];
             td.style.color = '#222';
           }

         if (args[2] == 80 && args[3] == 8)  {
             args[5] = chapSix10[0];
             td.style.color = '#222';
           }
         
         if (args[2] == 54 && args[3] == 0)  {
             args[5] = tax1[0];
             td.style.color = '#222';
           }
          if (args[2] == 54 && args[3] == 1)  {
             args[5] = hyphen1[0];
             td.style.color = '#222';
           } 
          if (args[2] == 54 && args[3] == 2)  {
             args[5] = tax16[0];
             td.style.color = '#222';
           }
       
         if (args[2] == 55 && args[3] == 0)  {
             args[5] = tax2[0];
             td.style.color = '#222';
           }
      if (args[2] == 55 && args[3] == 1)  {
             args[5] = hyphen2[0];
             td.style.color = '#222';
           }
           if (args[2] == 55 && args[3] == 2)  {
             args[5] = tax17[0];
             td.style.color = '#222';
           }
         if (args[2] == 56 && args[3] == 0)  {
             args[5] = tax3[0];
             td.style.color = '#222';
           }
       if (args[2] == 56 && args[3] == 1)  {
             args[5] = hyphen3[0];
             td.style.color = '#222';
           }
       if (args[2] == 56 && args[3] == 2)  {
             args[5] = tax18[0];
             td.style.color = '#222';
           }
         if (args[2] == 57 && args[3] == 0)  {
             args[5] = tax4[0];
             td.style.color = '#222';
           }
         if (args[2] == 53 && args[3] == 0)  {
             args[5] = taxHeading1[0];
             td.style.color = '#222';
           }
         if (args[2] == 53 && args[3] == 3)  {
             args[5] = taxHeading2[0];
             td.style.color = '#222';
           }
         if (args[2] == 53 && args[3] == 4)  {
             args[5] = taxHeading3[0];
             td.style.color = '#222';
           }
         if (args[2] == 53 && args[3] == 5)  {
             args[5] = taxHeading4[0];
             td.style.color = '#222';
           }
         if (args[2] == 53 && args[3] == 6)  {
             args[5] = taxHeading5[0];
             td.style.color = '#222';
           }
         
         if (args[2] == 60 && args[3] == 0)  {
             args[5] = tax6[0];
             td.style.color = '#222';
           }
         if (args[2] == 61 && args[3] == 0)  {
             args[5] = tax7[0];
             td.style.color = '#222';
           }

         if (args[2] == 62 && args[3] == 0)  {
             args[5] = tax8[0];
             td.style.color = '#222';
           }

         if (args[2] == 63 && args[3] == 0)  {
             args[5] = tax9[0];
             td.style.color = '#222';
           }

         if (args[2] == 64 && args[3] == 0)  {
             args[5] = tax10[0];
             td.style.color = '#222';
           }

         if (args[2] == 65 && args[3] == 0)  {
             args[5] = tax11[0];
             td.style.color = '#222';
           }

         if (args[2] == 66 && args[3] == 0)  {
             args[5] = tax12[0];
             td.style.color = '#222';
           }

         if (args[2] == 67 && args[3] == 0)  {
             args[5] = tax13[0];
             td.style.color = '#222';
           }

         if (args[2] == 68 && args[3] == 0)  {
             args[5] = tax14[0];
             td.style.color = '#222';
           }

         if (args[2] == 69 && args[3] == 0)  {
             args[5] = tax15[0];
             td.style.color = '#222';
           }

/*         if (args[2] == 18 && args[3] == 13)  {         
             args[5] = ["Hi"];
         }
*/
            Handsontable.renderers.TextRenderer.apply(this, args);
          }
        
        
        
      
        
    })
});

