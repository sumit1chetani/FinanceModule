	var windowFocus = true;
	var username;
	var chatHeartbeatCount = 0;
	var minChatHeartbeat = 3000;
	var maxChatHeartbeat = 33000;
	var chatHeartbeatTime = minChatHeartbeat;
	var originalTitle;
	var blinkOrder = 0;
	
	
function chatWith(chatuser, currentuser,chatboxtitle) {
	   
	    startChatSession(currentuser, chatuser);
	    createChatBox(chatuser, currentuser, 0, chatboxtitle);
	    jQuery("#chatbox_" + chatuser + " .chatboxtextarea").focus();
	}


	function checkChatBoxInputKey(event, chatboxtextarea, chatboxtitle, username) {
		

		    if (event.keyCode == 13 && event.shiftKey == 0) {
			        message = jQuery(chatboxtextarea).val();
			        message = message.replace(/^\s+|\s+jQuery/g, "");

			        jQuery(chatboxtextarea).val('');
			        jQuery(chatboxtextarea).focus();
			        jQuery(chatboxtextarea).css('height', '44px');
			        //username='appu';
			       
			        /*var seeds_auth = jQuery("#seeds_auth").val();*/
			        if (message != '') {						

			        	
			            
			        	jQuery.post('unicon/app/dashboard/savechatEmployee?sender_id='+username+'&receiver_id='+chatboxtitle+'&msg='+message+'&chat_type=2')
			    		.success(function(data) {
			    			
			    		}).error(function(data) {
			    			logger.logError("Error Please Try Again");
			    		});
			            
			            
			           
			            
			            
			            message = message.replace(/</g, "&lt;").replace(/>/g, "&gt;").replace(/\"/g, "&quot;");
			            jQuery("#chatbox_" + chatboxtitle + " .chatboxcontent").append('<div class="chatboxmessage seedsuser"><!--<span class="chatboxmessagefrom">' + username + ':&nbsp;&nbsp;</span>--><span class="chatboxmessagecontent">' + message + '</span></div>');
			           jQuery("#chatbox_" + chatboxtitle + " .chatboxcontent").scrollTop(jQuery("#chatbox_" + chatboxtitle + " .chatboxcontent")[0].scrollHeight);
			        }
			        chatHeartbeatTime = minChatHeartbeat;
			        chatHeartbeatCount = 1;

			        return false;
			    }
			 var adjustedHeight = chatboxtextarea.clientHeight;
			    var maxHeight = 94;

			    if (maxHeight > adjustedHeight) {
			        adjustedHeight = Math.max(chatboxtextarea.scrollHeight, adjustedHeight);
			        if (maxHeight)
			            adjustedHeight = Math.min(maxHeight, adjustedHeight);
			        if (adjustedHeight > chatboxtextarea.clientHeight)
			            jQuery(chatboxtextarea).css('height', adjustedHeight + 8 + 'px');
			    } else {
			        jQuery(chatboxtextarea).css('overflow', 'auto');
			    }
			     //

			
	}
	
	
	
	
	
	
	
	
	
	/*Waste*/
	function restructureChatBoxes() {
	    align = 0;
	    if (chatBoxes.length > 0) {
	        //for (x in chatBoxes) {chatboxtitle
	        for (x = 0; x < chatBoxes.length; x++) {
	            chatboxtitle = chatBoxes[x];

	            if (jQuery("#chatbox_" + chatboxtitle).css('display') != 'none') {
	                if (align == 0) {
	                    jQuery("#chatbox_" + chatboxtitle).css('right', '20px', 'width', ' 25%');
	                } else {
	                    //  width = (align) * (225 + 7) + 20;
	                    width = (align) * (350 + 7) + 20;
	                    jQuery("#chatbox_" + chatboxtitle).css('right', width + 'px');
	                }
	                align++;
	            }
	        }
	    }
	}
	
	var chatboxFocus = new Array();
	var newMessages = new Array();
	var newMessagesWin = new Array();
	var chatBoxes = new Array();

	jQuery(document).ready(function() {
	    originalTitle = document.title;
	    username = jQuery("#currentuser").val();
	    attachment_img = jQuery("#attachment_img").val();
	    smiley_img = jQuery("#smiley_img").val();
	    
	 jQuery([window, document]).blur(function() {
	        windowFocus = false;
	    }).focus(function() {
	        windowFocus = true;
	        document.title = originalTitle;
	    });


	});

	function openLoadingModal() {
	    var modal_loading = document.getElementById('loading-indicator');
	    modal_loading.style.display = "block";
	}
	function closeLoadingModal() {
	    var modal_loading = document.getElementById('loading-indicator');
	    modal_loading.style.display = "none";
	}

	function closeLoadingIndicator(){
	  closeLoadingModal();
	  
	}
	
	function toggleChatBoxGrowth(chatboxtitle) {
	    if (jQuery('#chatbox_' + chatboxtitle + ' .chatboxcontent').css('display') == 'none') {

	        var minimizedChatBoxes = new Array();

	        if (jQuery.cookie('chatbox_minimized')) {
	            minimizedChatBoxes = jQuery.cookie('chatbox_minimized').split(/\|/);
	        }

	        var newCookie = '';

	        for (i = 0; i < minimizedChatBoxes.length; i++) {
	            if (minimizedChatBoxes[i] != chatboxtitle) {
	                newCookie += chatboxtitle + '|';
	            }
	        }

	        newCookie = newCookie.slice(0, -1)


	        jQuery.cookie('chatbox_minimized', newCookie);
	        jQuery('#chatbox_' + chatboxtitle + ' .chatboxcontent').css('display', 'block');
	        jQuery('#chatbox_' + chatboxtitle + ' .chatboxinput').css('display', 'block');
	        jQuery("#chatbox_" + chatboxtitle + " .chatboxcontent").scrollTop(jQuery("#chatbox_" + chatboxtitle + " .chatboxcontent")[0].scrollHeight);
	    } else {

	        var newCookie = chatboxtitle;

	        if (jQuery.cookie('chatbox_minimized')) {
	            newCookie += '|' + jQuery.cookie('chatbox_minimized');
	        }


	        jQuery.cookie('chatbox_minimized', newCookie);
	        jQuery('#chatbox_' + chatboxtitle + ' .chatboxcontent').css('display', 'none');
	        jQuery('#chatbox_' + chatboxtitle + ' .chatboxinput').css('display', 'none');
	    }

	}
	
	function closeChatBox(chatboxtitle) {
	    jQuery('#chatbox_' + chatboxtitle).css('display', 'none');
	    restructureChatBoxes();    

	}
	
	