var ie = (function() {
	var c, a = 3, d = document.createElement("div"), b = d
			.getElementsByTagName("i");
	while (d.innerHTML = "<!--[if gt IE " + (++a) + "]><i></i><![endif]-->",
			b[0]) {
	}
	return a > 4 ? a : c
}());
var easyuiPanelOnResize = function(c, a) {
	if (!$.data(this, "window") && !$.data(this, "dialog")) {
		return
	}
	c = parseFloat(c);
	a = parseFloat(a);
	if (ie === 8) {
		var e = $.data(this, "window") || $.data(this, "dialog");
		if (e.pmask) {
			var b = e.window.nextAll(".window-proxy-mask");
			if (b.length > 1) {
				$(b[1]).remove();
				b[1] = null
			}
		}
	}
	if ($(this).panel("options").maximized == true) {
		$(this).panel("options").fit = false
	}
	$(this).panel("options").reSizing = true;
	if (!$(this).panel("options").reSizeNum) {
		$(this).panel("options").reSizeNum = 1
	} else {
		$(this).panel("options").reSizeNum++
	}
	var d = $(this).panel("panel").parent();
	var h = $(this).panel("panel").position().left;
	var g = $(this).panel("panel").position().top;
	if ($(this).panel("panel").offset().left < 0) {
		$(this).panel("move", {
			left : 0
		})
	}
	if ($(this).panel("panel").offset().top < 0) {
		$(this).panel("move", {
			top : 0
		})
	}
	if (h < 0) {
		$(this).panel("move", {
			left : 0
		}).panel("resize", {
			width : c + h
		})
	}
	if (g < 0) {
		$(this).panel("move", {
			top : 0
		}).panel("resize", {
			height : a + g
		})
	}
	if (d.css("overflow") == "hidden") {
		var f = $.data(this, "window").options.inline;
		if (f == false) {
			d = $(window)
		}
		if ((c + h > d.width()) && $(this).panel("options").reSizeNum > 1) {
			$(this).panel("resize", {
				width : d.width() - h
			})
		}
		if ((a + g > d.height()) && $(this).panel("options").reSizeNum > 1) {
			$(this).panel("resize", {
				height : d.height() - g
			})
		}
	}
	$(this).panel("options").reSizing = false
};
var easyuiPanelOnMove = function(f, e) {
	if ($(this).panel("options").reSizing) {
		return
	}
	var c = $(this).panel("panel").parent();
	var b = $(this).panel("options").width;
	var a = $(this).panel("options").height;
	if (f < 0) {
		$(this).panel("move", {
			left : 0
		})
	}
	if (e < 0) {
		$(this).panel("move", {
			top : 0
		})
	}
	if (c.css("overflow") == "hidden") {
		if (typeof ($.data(this, "window")) != "undefined") {
			var d = $.data(this, "window").options.inline;
			if (d == false) {
				c = $(window)
			}
			if (f > c.width() - b) {
				if (f <= 0) {
					$(this).panel({
						width : c.width()
					})
				} else {
					$(this).panel("move", {
						left : c.width() - b
					})
				}
			}
			if (e > c.height() - a) {
				if (e <= 0) {
					$(this).panel({
						height : c.height()
					})
				} else {
					$(this).panel("move", {
						top : c.height() - a
					})
				}
			}
		}
	}
};
$.fn.panel.defaults.onResize = easyuiPanelOnResize;
$.fn.window.defaults.onResize = easyuiPanelOnResize;
$.fn.dialog.defaults.onResize = easyuiPanelOnResize;
$.fn.window.defaults.onMove = easyuiPanelOnMove;
$.fn.panel.defaults.onMove = easyuiPanelOnMove;
$.fn.dialog.defaults.onMove = easyuiPanelOnMove;
CommonDialog = function(id, width, height, content, title, closable, modal,
		useDefaultButton, appendIframe, isMaximized, maximizable) {
	id = id || "_comframe_id_" + (Math.random() + "").split(".")[1];
	var iframeId = "_iframe_" + id;
	width = width || "500";
	height = height || "500";
	title = title || "选人窗口";
	var _destroy = true;
	if (typeof (closable) == "undefined" || closable == null) {
		closable = true
	}
	if (typeof (modal) == "undefined" || modal == null) {
		modal = true
	}
	if (typeof (useDefaultButton) == "undefined" || useDefaultButton == null) {
		useDefaultButton = true
	}
	if (typeof (appendIframe) == "undefined" || appendIframe == null) {
		appendIframe = false
	}
	if (typeof (isMaximized) == "undefined" || isMaximized == null) {
		isMaximized = false
	}
	if (typeof (maximizable) == "undefined" || maximizable == null) {
		maximizable = true
	}
	this.setDestroy = function(b) {
		_destroy = b
	};
	this.createDom = function() {
		if (jQuery("#" + id).length > 0) {
			jQuery("#" + id).dialog("destroy")
		}
		if (jQuery("#" + id).length == 0) {
			if (content.indexOf("<") == -1) {
				if (content.indexOf("?") == -1) {
					content + "?j=" + Math.random()
				} else {
					content + "&j=" + Math.random()
				}
				var iframe = jQuery("#" + id + " iframe");
				if (typeof (iframe.attr("id")) == "undefined") {
					jQuery(document.body)
							.append(
									"<div id='"
											+ id
											+ "' style='overflow: hidden'><iframe frameborder='0' scrolling='no'></iframe></div>");
					iframe = jQuery("#" + id + " iframe");
					iframe.attr("id", iframeId);
					iframe.attr("height", "100%");
					iframe.attr("width", "100%");
					iframe.attr("frameborder", "0");
					iframe.attr("scrolling", "auto")
				} else {
				}
			} else {
				jQuery(document.body).append(
						"<div id='" + id + "'>" + content + "</div>")
			}
		} else {
		}
	};
	this.createDialog = function() {
		if (useDefaultButton) {
			var closeButtons = [ {
				text : "返回",
				id : "closeButton",
				handler : function() {
					jQuery("#" + id).dialog("destroy")
				}
			} ];
			jQuery("#" + id).dialog({
				closable : closable,
				title : title,
				resizable : true,
				width : width,
				height : height,
				modal : modal,
				maximizable : maximizable,
				minimizable : false,
				maximized : isMaximized,
				collapsible : true,
				inline : true,
				shadow : false,
				buttons : closeButtons,
				onClose : function() {
					if (_destroy) {
						var iframe = jQuery("#" + iframeId);
						if (iframe) {
							try {
								iframe.attr("src", "about:blank");
								iframe.contentWindow.document.write("");
								iframe.contentWindow.document.clear()
							} catch (e) {
							}
						}
						jQuery("#" + id).remove()
					}
				}
			})
		} else {
			jQuery("#" + id).dialog({
				closed : true,
				title : title,
				resizable : true,
				width : width,
				height : height,
				modal : modal,
				maximizable : true,
				resizable : true,
				minimizable : false,
				maximized : isMaximized,
				collapsible : true,
				inline : true,
				shadow : false,
				onClose : function() {
					try {
					} catch (e) {
					}
					if (_destroy) {
						var iframe = jQuery("#" + iframeId);
						if (iframe) {
							try {
								iframe.attr("src", "about:blank");
								iframe.contentWindow.document.write("");
								iframe.contentWindow.document.clear()
							} catch (e) {
							}
						}
						jQuery("#" + id).dialog("destroy")
					}
				}
			})
		}
	};
	this.createButtonsInDialog = function(buttons) {
		var items = buttons;
		var buttonbar = jQuery("#" + id).children("div.dialog-button");
		for ( var i = 0; i < items.length; i++) {
			var item = items[i];
			var btn = jQuery('<a href="javascript:void(0)"></a>');
			btn[0].onclick = eval(item.handler || function() {
			});
			jQuery(btn).prependTo(buttonbar).linkbutton(
					jQuery.extend({}, item, {
						plain : false
					}))
		}
		buttonbar = null
	};
	this.createButtonsInDialogNew = function(buttons) {
		var items = buttons;
		var buttonbar = jQuery("#" + id).children("div.dialog-button");
		buttonbar.addClass("foot-formopera");
		for ( var i = 0; i < items.length; i++) {
			var item = items[i];
			var btn;
			if (item.isPrimary) {
				btn = jQuery("<a href=\"javascript:void(0)\" class='primary-btn'></a>")
			} else {
				btn = jQuery('<a href="javascript:void(0)"></a>')
			}
			btn[0].onclick = eval(item.handler || function() {
			});
			jQuery(btn).prependTo(buttonbar).linkbutton(
					jQuery.extend({}, item, {
						plain : false
					}))
		}
		var opt = jQuery("#" + id).dialog("options");
		jQuery("#" + id).dialog("resize", {
			width : opt.width,
			height : opt.height
		});
		buttonbar = null
	};
	this.close = function() {
		jQuery("#" + id).dialog("destroy")
	};
	this.createDom();
	this.createDialog();
	this.show = function() {
		jQuery("#" + id).dialog("open");
		var iframe = jQuery("#" + id + " iframe");
		if (!iframe.attr("src") || _destroy) {
			iframe.attr("src", content)
		}
	}
};