"use strict";(self.webpackChunkwebpack_test=self.webpackChunkwebpack_test||[]).push([[4324],{4324:function(t,e,n){n.r(e),n.d(e,{pageControl:function(){return h}});var i=n(9122),s=n(1160),o=n(5841),r=n(8754),a=n(5316),h=function(t,e,n){a.s.call(this,t,e,n)};i.x.extend(h.prototype,a.s.prototype),h.prototype.defaultOptions={pluginType:"uiplugin.pageControl",pluginName:"pageControl",userEvents:["onchange","onviewchange"],pagingType:"1",rotation:"false",detectionRange:10,pageCount:10},h.prototype.initialize=function(t){try{this.pageCount=this.options.pageCount,this.displayIndex=1,this.selectedIndex=1,this.moveEventLayerX=null,this.startEventLayerX=null,this.isSliding=!1}catch(t){s.w.printStackTrace(t,null,this)}},h.prototype.toHTML=function(){var t=[],e=""==this.options.style?"":"style='"+this.options.style+"'",n=WebSquare.language.getMessage("Pagelist_next_page")||"다음 페이지",i=WebSquare.language.getMessage("Pagelist_next")||"다음",s=WebSquare.language.getMessage("Pagelist_previous_page")||"이전 페이지",o=WebSquare.language.getMessage("Pagelist_previous")||"이전",r=this.options.tabIndex?"tabIndex='"+this.options.tabIndex+"'":"";return t.push("<div id='"+this.id+"' "+e+" class='w2pageControl "+this.options.className+"'>"),t.push("<span id='"+this.id+"_left' class='w2pageControl_left'>"),"1"==this.options.pagingType&&(t.push("<button id='"+this.id+"_left_button' class='w2pageControl_left_button w2pageControl_button_background'  "+r+" title='"+s+"'>"),t.push("<span id='"+this.id+"_left_icon' class='w2pageControl_left_icon'>"),t.push(o),t.push("</span>"),t.push("</button>")),t.push("</span>"),t.push("<span id='"+this.id+"_center' class='w2pageControl_center'>"),t.push("<table id='"+this.id+"_center_table' class='w2pageControl_center_table'>"),t.push("<tr style='height:100%;'>"),t.push("<td id='"+this.id+"_center_td' class='w2pageControl_center_td"),"1"!=this.options.pagingType?t.push(" w2pageControl_center_image'>"):(t.push("'>"),t.push(this.displayIndex+"/"+this.pageCount)),t.push("</td>"),t.push("</tr>"),t.push("</table>"),t.push("</span>"),t.push("<span id='"+this.id+"_right' class='w2pageControl_right'>"),"1"==this.options.pagingType&&(t.push("<button id='"+this.id+"_right_button' class='w2pageControl_right_button w2pageControl_button_background' "+r+" title='"+n+"'>"),t.push("<span id='"+this.id+"_right_icon' class='w2pageControl_right_icon'>"),t.push(i),t.push("</span>"),t.push("</button>")),t.push("</span>"),t.push("</div>"),t.join("")},h.prototype.setAction=function(){this.isMobile=r.D.isMobile(),this.isWebKit=/webkit/.test(navigator.userAgent.toLowerCase()),this.dom.table=document.getElementById(this.id+"_center_table"),"1"!=this.options.pagingType?this.isMobile?(this.event.addListener(this.render,"ontouchstart",this.event.bindAsEventListener(this,this.handleTouchStart)),this.event.addListener(this.render,"ontouchmove",this.event.bindAsEventListener(this,this.handleTouchMove)),this.event.addListener(this.render,"ontouchend",this.event.bindAsEventListener(this,this.handleTouchEnd))):(this.event.addListener(this.render,"onmousedown",this.event.bindAsEventListener(this,this.handleTouchStart)),this.event.addListener(this.render,"onmouseout",this.event.bindAsEventListener(this,this.handleMouseOut)),this.event.addListener(this.render,"onmousemove",this.event.bindAsEventListener(this,this.handleTouchMove)),this.event.addListener(this.render,"onmouseup",this.event.bindAsEventListener(this,this.handleTouchEnd))):(this.dom.iconLeft=this.getElementById(this.id+"_left_button"),this.dom.iconRight=this.getElementById(this.id+"_right_button"),this.event.addListener(this.render,"onclick",this.event.bindAsEventListener(this,this.handleClickEvent)),this.event.addListener(this.render,"onmouseover",this.event.bindAsEventListener(this,this.handleMouseOverEvent)),this.event.addListener(this.render,"onmouseout",this.event.bindAsEventListener(this,this.handleMouseOutEvent))),
this.event.addListener(this.render,"onselectstart",this.event.bindAsEventListener(this,(function(t){o.B.preventDefault(t)})))},h.prototype.refreshItemset=function(){},h.prototype.refresh=function(){},h.prototype.setCount=function(t){try{this.pageCount=t,this.redraw(),this.setSelectedIndex(1)}catch(t){s.w.printStackTrace(t,null,this)}},h.prototype.setSelectedIndex=function(t,e){try{if(0==this.pageCount)return;if(r.D.isNull(t))return;if((t=t.toString())<1||t>this.pageCount)return void $l("range exception for "+this.id);var n=this.selectedIndex;if(this.setDisplayIndex(t),this.selectedIndex=parseInt(t),"1"!=this.options.pagingType){var i=document.getElementById(this.id+"_center_td");this.removeClass(i,"w2pageControl_center_image"),this.removeClass(i,"w2pageControl_center_image_prev"),this.removeClass(i,"w2pageControl_center_image_next"),"previous"===e?this.addClass(i,"w2pageControl_center_image_prev"):"next"===e?this.addClass(i,"w2pageControl_center_image_next"):n>this.selectedIndex?this.addClass(i,"w2pageControl_center_image_prev"):this.addClass(i,"w2pageControl_center_image_next"),this.pageImage=setTimeout(this.event.bindAsEventListener(this,(function(){this.removeClass(i,"w2pageControl_center_image"),this.removeClass(i,"w2pageControl_center_image_prev"),this.removeClass(i,"w2pageControl_center_image_next"),this.addClass(i,"w2pageControl_center_image")})),500)}var a=null;this.selectedIndex>n?a="next":this.selectedIndex<n&&(a="previous"),r.D.getBoolean(this.options.rotation)&&(1===this.selectedIndex&&n===this.pageCount?a="next":this.selectedIndex===this.pageCount&&1===n&&(a="previous")),-1!=n&&n!=this.selectedIndex&&o.B.fireEvent(this,"onchange",this.selectedIndex,n,a)}catch(t){s.w.printStackTrace(t,null,this)}},h.prototype.getSelectedIndex=function(){try{return this.selectedIndex}catch(t){s.w.printStackTrace(t,null,this)}},h.prototype.moveToLeft=function(t){try{r.D.getBoolean(this.options.rotation)&&this.selectedIndex<=1?this.setSelectedIndex(this.pageCount,t):this.setSelectedIndex(this.selectedIndex-1,t)}catch(t){s.w.printStackTrace(t,null,this)}},h.prototype.moveToRight=function(t){try{r.D.getBoolean(this.options.rotation)&&this.selectedIndex>=this.pageCount?this.setSelectedIndex(1,t):this.setSelectedIndex(this.selectedIndex+1,t)}catch(t){s.w.printStackTrace(t,null,this)}},h.prototype.setDisplayIndex=function(t){try{if(0==this.pageCount)return;var e=t=parseInt(t);if(e<1&&(e=1),e>this.pageCount&&(e=this.pageCount),this.displayIndex==e)return;if(this.displayIndex=e,"1"==this.options.pagingType){var n=document.getElementById(this.id+"_center_td");n&&(n.innerHTML=this.displayIndex+"/"+this.pageCount)}}catch(t){s.w.printStackTrace(t,null,this)}},h.prototype.handleClickEvent=function(t){try{for(var e=this.event.getTargetIterator(t,this.render),n=this.getSelectedIndex();e.next();)e.match("w2pageControl_left_button")?this.moveToLeft("previous"):e.match("w2pageControl_right_button")&&this.moveToRight("next");e=null;var i=this.getSelectedIndex();if(n!=i){var r={oldSelectedIndex:n,newSelectedIndex:i};o.B.fireEvent(this,"onviewchange",r)}}catch(t){s.w.printStackTrace(t,null,this)}},h.prototype.handleTouchStart=function(t){this.isSliding=!0,this.startEventLayerX=o.B.getMouseX(t),o.B.stopEvent(t)},h.prototype.handleTouchEnd=function(t){try{if(null==this.startEventLayerX||null==this.moveEventLayerX)return;var e=this.moveEventLayerX-this.startEventLayerX;e<-1*this.options.detectionRange?this.moveToRight("next"):e>this.options.detectionRange&&this.moveToLeft("previous"),this.isSliding=!1,this.moveEventLayerX=null,this.startEventLayerX=null,o.B.stopEvent(t)}catch(t){s.w.printStackTrace(t,null,this)}},h.prototype.handleMouseOverEvent=function(t){try{o.B.stopEvent(t);for(var e=this.event.getTargetIterator(t,this.render);e.next();){if(e.match("w2pageControl_right_button")){this.addClass(this.dom.iconRight,"w2pageControl_button_background_over");break}if(e.match("w2pageControl_left_button")){
this.addClass(this.dom.iconLeft,"w2pageControl_button_background_over");break}}e=null}catch(t){s.w.printStackTrace(t,null,this)}},h.prototype.handleMouseOutEvent=function(t){try{o.B.stopEvent(t);for(var e=this.event.getTargetIterator(t,this.render);e.next();){if(e.match("w2pageControl_right_button")){this.removeClass(this.dom.iconRight,"w2pageControl_button_background_over");break}if(e.match("w2pageControl_left_button")){this.removeClass(this.dom.iconLeft,"w2pageControl_button_background_over");break}}e=null}catch(t){s.w.printStackTrace(t,null,this)}},h.prototype.handleTouchMove=function(t){this.isSliding&&(this.moveEventLayerX=o.B.getMouseX(t),this.isMobile&&o.B.preventDefault(t))},h.prototype.handleMouseOut=function(t){try{if(!o.B.getRelatedTarget(t))return;this.isSliding&&(o.B.getRelatedTarget(t).getAttribute("id")?o.B.getRelatedTarget(t).getAttribute("id").indexOf(this.id)<0&&this.handleTouchEnd(t):o.B.getRelatedTarget(t).getAttribute("id")||this.handleTouchEnd(t))}catch(t){s.w.printStackTrace(t,null,this)}},h.prototype.setStyle=function(t,e){try{if(!this.render)return;if(WebSquare.style.setStyle(this.render,t,e),"font-size"==t)for(var n=this.dom.table.childNodes[0].firstChild;null!=n;n=n.nextSibling){n.firstChild.style[t]=e}}catch(t){s.w.printStackTrace(t)}}}}]);