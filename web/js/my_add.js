function sign_up_deteciton() {
    var name = document.getElementById("username");
    var tel = document.getElementById('tel');
    var pass = document.getElementById('password');
    var rpass = document.getElementById('re-password');
    var nameval = name.value.replace(/(^\s*)|(\s*$)/g, '');
    var telval = tel.value.replace(/(^\s*)|(\s*$)/g, '');
    var passval = pass.value.replace(/(^\s*)|(\s*$)/g, '');
    var repassval = rpass.value.replace(/(^\s*)|(\s*$)/g, '');
    var myreg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
    if(nameval.length==0||telval.length==0||passval==0){
        alert("输入不能为空！");
        return false;
    }else if(!myreg.test(telval)){
        alert("请输入正确的手机号码！");
        return false;
}
    else if (passval.length<4 || passval.length>16){
        alert("密码的长度必须在4-16个字符");
        pass.select();
        return false;
    }else if(passval!=repassval){
        alert("两次密码输入不一致");
        rpass.select();
        return false;
    } else {
        show = document.getElementsByClassName('alert');
        show[0].style.display = "block";
        return true;
    }
}
function show_price(event) {
    var tr1 = event.parentNode;
    rowIndex = tr1.rowIndex;
    var table = document.getElementById("tableSort");
    var row = table.getElementsByTagName("tr")[rowIndex+1];
    // alert(child.rowIndex)
    if (row != null) {
        if (row.style.display == (document.all ? "block" : "table-row")) {
            row.style.display = "none";
        }
        else {
            row.style.display = (document.all ? "block" : "table-row");
        }
    }
}
function sortAble(th, tableId, iCol, dataType) {
//排序 tableId: 表的id,iCol:第几列 ；dataType：iCol对应的列显示数据的数据类型
    var ascChar = "▲";
    var descChar = "▼";
    var table = document.getElementById(tableId);
    var tbody = table.tBodies[0];
    var colRows = tbody.rows;
    var aTrs = new Array;
    //将得到的行放入数组，备用
    for (var i = 0; i < colRows.length; i++) {
        aTrs.push(colRows[i]);
    }
    //判断上一次排列的列和现在需要排列的是否同一个。
    var thCol = $(table.tHead.rows[0].cells[iCol]);
    if (table.sortCol == iCol) {
        aTrs.reverse();
    } else {
        //如果不是同一列，使用数组的sort方法，传进排序函数
        aTrs.sort(compareEle(iCol, dataType));
    }

    var oFragment = document.createDocumentFragment();
    for (var i = 0; i < aTrs.length; i++) {
        oFragment.appendChild(aTrs[i]);
    }
    tbody.appendChild(oFragment);

    //记录最后一次排序的列索引
    table.sortCol = iCol;

    //给排序标题加“升序、降序” 小图标显示
    var th = $(table.tHead.rows[0].cells[iCol]);
    if (th.html().indexOf(ascChar) == -1 && th.html().indexOf(descChar) == -1) {
        th.html(th.html() + ascChar);
    }
    else if (th.html().indexOf(ascChar) != -1) {
        th.html(th.html().replace(ascChar, descChar));
    }
    else if (th.html().indexOf(descChar) != -1) {
        th.html(th.html().replace(descChar, ascChar));
    }

    //重新整理分组
    var subRows = $("#" + tableId + " tr[parent]");
    for (var t = subRows.length - 1; t >= 0 ; t--) {
        var parent = $("#" + tableId + " tr[group='" + $(subRows[t]).attr("parent") + "']");
        parent.after($(subRows[t]));6             }
}

//将列的类型转化成相应的可以排列的数据类型
function convert(sValue, dataType) {
    switch (dataType) {
        case "int":
            return parseInt(sValue, 10);
        case "float":
            return parseFloat(sValue);
        case "date":
            return new Date(Date.parse(sValue));
        case "string":
        default:
            return sValue.toString();
    }
}

//排序函数，iCol表示列索引，dataType表示该列的数据类型
function compareEle(iCol, dataType) {
    return function (oTR1, oTR2) {

        var vValue1 = convert(removeHtmlTag($(oTR1.cells[iCol]).html()), dataType);
        var vValue2 = convert(removeHtmlTag($(oTR2.cells[iCol]).html()), dataType);
        if (vValue1 < vValue2) {
            return -1;
        }
        else {
            return 1;
        }

    };
}

//去掉html标签
function removeHtmlTag(html) {
    return html.replace(/<[^>]+>/g, "");
}



