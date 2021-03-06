$.extend($.fn.validatebox.defaults.rules, {
    past: {
        validator: function(a, b) {
            return compareDay(a) <= 0
        },
        message: "日期不能大于今天！"
    }
});
$.extend($.fn.validatebox.defaults.rules, {
    def: {
        validator: function(a, b) {
            if (typeof($.fn.validatebox.defaults.rules.unique[b[0]]) == "undefined") {
                return true
            }
            if ($.fn.validatebox.defaults.rules.unique[b[0]] == true) {
                return true
            } else {
                $.fn.validatebox.defaults.rules.def.message = $.fn.validatebox.defaults.rules.unique[b[0] + "msg"];
                return false
            }
        },
        message: ""
    }
});
$.extend($.fn.validatebox.defaults.rules, {
    unique: {
        validator: function(b, c) {
            var a = {};
            $.ajax({
                url: c[0],
                data: {
                    value: b
                },
                type: "GET",
                async: false,
                dataType: "json",
                success: function(d) {
                    a = d
                }
            });
            if (a.result == true) {
                $.fn.validatebox.defaults.rules.unique[c[1]] = true;
                return true
            } else {
                $.fn.validatebox.defaults.rules.unique[c[1]] = false;
                if (a.msg) {
                    $.fn.validatebox.defaults.rules.unique.message = a.msg;
                    $.fn.validatebox.defaults.rules.unique[c[1] + "msg"] = a.msg
                }
                return false
            }
        }
    }
});
$.extend($.fn.validatebox.defaults.rules, {
    minLength: {
        validator: function(a, b) {
            return a.length >= b[0]
        },
        message: "Please enter at least {0} characters."
    }
});
$.extend($.fn.validatebox.defaults.rules, {
    maxLength: {
        validator: function(a, b) {
            return a.length <= b[0]
        },
        message: "Please enter at least {0} characters."
    }
});
$.extend($.fn.datagrid.defaults.editors, {
    datebox: {
        init: function(a, c) {
            var b = $("<input />").appendTo(a);
            b.datebox(c);
            return b
        },
        destroy: function(a) {
            $(a).datebox("destroy")
        },
        getValue: function(a) {
            return $(a).datebox("getValue")
        },
        setValue: function(b, a) {
            $(b).datebox("setValue", formatDatebox(a))
        },
        resize: function(b, a) {
            $(b).datebox("resize", a)
        }
    }
});
$.extend($.fn.datagrid.defaults.editors, {
    datetimebox: {
        init: function(a, c) {
            var b = $("<input />").appendTo(a);
            b.datetimebox(c);
            return b.datetimebox({
                formatter: function(d) {
                    return new Date(d).format("yyyy-MM-dd hh:mm:ss")
                }
            })
        },
        getValue: function(a) {
            return $(a).parent().find("input.combo-value").val()
        },
        setValue: function(b, a) {
            $(b).datetimebox("setValue", formatDateTimebox(a))
        },
        resize: function(b, a) {
            $(b).datetimebox("resize", a)
        }
    }
});
$.extend($.fn.layout.paneldefaults, {
    onCollapse: function() {
        var f = $(this).parents("div.layout");
        var e = $(this).panel("options");
        var d = "expand" + e.region.substring(0, 1).toUpperCase() + e.region.substring(1);
        if (f.data("layout")) {
            var a = f.data("layout").panels[d];
            if (e.region == "west" || e.region == "east") {
                var c = [];
                for (var b = 0; b < e.title.length; b++) {
                    c.push(e.title.substring(b, b + 1))
                }
                a.panel("body").addClass("panel-title").css("text-align", "center").html(c.join("<br>"))
            } else {
                a.panel("setTitle", "&nbsp;&nbsp;&nbsp;&nbsp;" + e.title + '<div class="panel-icon ' + e.iconCls + '"/>')
            }
        }
    }
});
function formatDatebox(b) {
    if (b == null || b == "") {
        return ""
    }
    var a;
    if (b instanceof Date) {
        a = b
    } else {
        if (!isNaN(b)) {
            a = new Date(b)
        } else {
            a = new Date(Date.parse(b.replace(/-/g, "/")))
        }
    }
    return a.format("yyyy-MM-dd")
}
function formatDateTimebox(b) {
    if (b == null || b == "") {
        return ""
    }
    var a;
    if (b instanceof Date) {
        a = b
    } else {
        if (!isNaN(b)) {
            a = new Date(b)
        } else {
            a = new Date(Date.parse(b.replace(/-/g, "/")))
        }
    }
    return a.format("yyyy-MM-dd hh:mm:ss")
}
Date.prototype.pattern = function(a) {
    var d = {
        "M+": this.getMonth() + 1,
        "d+": this.getDate(),
        "h+": this.getHours() % 12 == 0 ? 12 : this.getHours() % 12,
        "H+": this.getHours(),
        "m+": this.getMinutes(),
        "s+": this.getSeconds(),
        "q+": Math.floor((this.getMonth() + 3) / 3),
        S: this.getMilliseconds()
    };
    var c = {
        "0": "\u65e5",
        "1": "\u4e00",
        "2": "\u4e8c",
        "3": "\u4e09",
        "4": "\u56db",
        "5": "\u4e94",
        "6": "\u516d"
    };
    if (/(y+)/.test(a)) {
        a = a.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length))
    }
    if (/(E+)/.test(a)) {
        a = a.replace(RegExp.$1, ((RegExp.$1.length > 1) ? (RegExp.$1.length > 2 ? "\u661f\u671f": "\u5468") : "") + c[this.getDay() + ""])
    }
    for (var b in d) {
        if (new RegExp("(" + b + ")").test(a)) {
            a = a.replace(RegExp.$1, (RegExp.$1.length == 1) ? (d[b]) : (("00" + d[b]).substr(("" + d[b]).length)))
        }
    }
    return a
};
$.extend($.fn.datagrid.methods, {
    addEditor: function(c, b) {
        if (b instanceof Array) {
            $.each(b,
            function(d, f) {
                var g = $(c).datagrid("getColumnOption", f.field);
                g.editor = f.editor
            })
        } else {
            var a = $(c).datagrid("getColumnOption", b.field);
            a.editor = b.editor
        }
    },
    removeEditor: function(c, b) {
        if (b instanceof Array) {
            $.each(b,
            function(d, f) {
                var g = $(c).datagrid("getColumnOption", f);
                g.editor = {}
            })
        } else {
            var a = $(c).datagrid("getColumnOption", b);
            a.editor = {}
        }
    }
});
function compareDay(b, d) {
    var c;
    if (!d) {
        c = new Date()
    } else {
        c = new Date(Date.parse(b.replace(/-/g, "/")))
    }
    var a = new Date(Date.parse(b.replace(/-/g, "/")));
    return a.getTime() - c.getTime()
}
function loadScript(b, d) {
    var c = document;
    var a = c.createElement("script");
    a.type = "text/javascript";
    if (a.readyState) {
        a.onreadystatechange = function() {
            if (a.readyState == "loaded" || a.readyState == "complete") {
                a.onreadystatechange = null;
                d()
            }
        }
    } else {
        a.onload = function() {
            d()
        }
    }
    a.src = b;
    c.getElementsByTagName("head")[0].appendChild(a)
}
Array.prototype.remove = function(a) {
    if (isNaN(a) || a > this.length) {
        return false
    }
    for (var b = 0,
    c = 0; b < this.length; b++) {
        if (this[b] != this[a]) {
            this[c++] = this[b]
        }
    }
    this.length -= 1
};
function bindRowsEvent(c) {
    var a = myDatagrid.datagrid("getPanel");
    var b = a.find("tr[datagrid-row-index]");
    b.unbind("click").bind("click",
    function(d) {
        return false
    });
    b.find("div.datagrid-cell-check input[type=checkbox]").unbind().bind("click",
    function(g) {
        var d = $(this).parent().parent().parent().attr("datagrid-row-index");
        if ($(this).attr("checked")) {
            myDatagrid.datagrid("selectRow", d);
            if (c instanceof Array) {
                var h = myDatagrid.datagrid("getRows")[d];
                c.push(h)
            }
        } else {
            myDatagrid.datagrid("unselectRow", d);
            if (c instanceof Array) {
                var h = myDatagrid.datagrid("getRows")[d];
                if (c.length > 0) {
                    for (var f = 0; f < c.length; f++) {
                        if (c[f]["id"] == h.id) {
                            c.remove(f)
                        }
                    }
                }
            }
        }
        g.stopPropagation()
    })
}
function hiddenCheckBox(c) {
    var b = $("div .datagrid-cell-check");
    $("div .datagrid-cell-check").children("input[name='id']").each(function() {
        var a = this.value;
        if (a == c) {
            $(this).attr("disabled", "disabled");
            $(this).css("display", "none")
        }
    })
}
$.extend($.fn.datagrid.methods, {
    doCellTip: function(c, b) {
        function a(f, i, h, g) {
            if ($(i).text() == "") {
                return
            }
            b = b || {};
            var d = g.data("datagrid");
            f.content = '<div class="tipcontent">' + f.content + "</div>";
            $(i).tooltip({
                content: f.content,
                trackMouse: true,
                position: b.position,
                onHide: function() {
                    $(this).tooltip("destroy")
                },
                onShow: function() {
                    var e = $(this).tooltip("tip");
                    if (f.tipStyler) {
                        e.css(f.tipStyler)
                    }
                    if (f.contentStyler) {
                        e.find("div.tipcontent").css(f.contentStyler)
                    }
                }
            }).tooltip("show")
        }
        return c.each(function() {
            var f = $(this);
            var e = $(this).data("datagrid");
            if (!e.tooltip) {
                var d = f.datagrid("getPanel").panel("panel");
                d.find(".datagrid-body").each(function() {
                    var g = $(this).find("> div.datagrid-body-inner").length ? $(this).find("> div.datagrid-body-inner")[0] : this;
                    $(g).undelegate("td", "mouseover").undelegate("td", "mouseout").undelegate("td", "mousemove").delegate("td[field]", {
                        mouseover: function(l) {
                            var k = this;
                            var m = null;
                            if (b.specialShowFields && b.specialShowFields.sort) {
                                for (var h = 0; h < b.specialShowFields.length; h++) {
                                    if (b.specialShowFields[h].field == $(this).attr("field")) {
                                        m = b.specialShowFields[h]
                                    }
                                }
                            }
                            if (m == null) {
                                e.factContent = $(this).find(">div").clone().css({
                                    "margin-left": "-5000px",
                                    width: "auto",
                                    display: "inline",
                                    position: "absolute"
                                }).appendTo("body");
                                var j = e.factContent.width();
                                b.content = $(this).text();
                                if (b.onlyShowInterrupt) {
                                    if (j > $(this).width()) {
                                        a(b, this, l, f)
                                    }
                                } else {
                                    a(b, this, l, f)
                                }
                            } else {
                                d.find(".datagrid-body").each(function() {
                                    var i = $(this).find('tr[datagrid-row-index="' + $(k).parent().attr("datagrid-row-index") + '"]');
                                    i.each(function() {
                                        var n = $(this).find('> td[field="' + m.showField + '"]');
                                        if (n.length) {
                                            b.content = n.text()
                                        }
                                    })
                                });
                                a(b, this, l, f)
                            }
                        },
                        mouseout: function(h) {
                            if (e.factContent) {
                                e.factContent.remove();
                                e.factContent = null
                            }
                        }
                    })
                })
            }
        })
    },
    cancelCellTip: function(a) {
        return a.each(function() {
            var c = $(this).data("datagrid");
            if (c.factContent) {
                c.factContent.remove();
                c.factContent = null
            }
            var b = $(this).datagrid("getPanel").panel("panel");
            b.find(".datagrid-body").undelegate("td", "mouseover").undelegate("td", "mouseout").undelegate("td", "mousemove")
        })
    }
});