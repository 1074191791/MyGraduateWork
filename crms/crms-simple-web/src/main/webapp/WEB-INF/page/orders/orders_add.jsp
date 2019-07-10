<%--
  Created by IntelliJ IDEA.
  User: zhou
  Date: 2019/3/24
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <!--主要字段：订单id, 订单号, 发起人， 时间，服务类型， 服务地点， 定金， 备注详情， 接收状态, 接收人id -->

  <form id="orders_add_form"
        method="post">
      <input type="hidden" value="${login.uid}" name="cid">
      <input type="hidden" name="status" value="false">
      <input type="hidden" name="pid" value="0">

      <table>

          <thead>
          <tr>
              <td colspan="4">
                  <b>订单提交 </b>
              </td>
          </tr>
          </thead>
          <tbody>
          <tr>
              <td>
                  提交人姓名
              </td>
              <td>
                  <input name="cname" type="text" value="${login.username}"/>
              </td>
              <td>
                  预约时间
              </td>
              <td>
                  <input class="easyui-datetimebox" name="startTime" id="orders_add_startTime"
                         data-options="required:true,showSeconds:true" value="3/4/2010 2:3" style="width:150px">
              </td>
          </tr>
          <tr>
              <td>
                  地址
              </td>
              <td>
                  <input name="serviceAddress" type="text"/>

              </td>
              <td>
                  服务类型
              </td>
              <td>
                  <select class="easyui-combobox" name="serviceType" style="width:200px;">
                      <option value="computerMaintain">电脑维修</option>
                      <option value="softInstall">安装系统软件</option>
                  </select>

              </td>
          </tr>
          <tr>
              <td>
                  赏金
              </td>
              <td>
                  <input name="payment" required="required" type="text" id="orders_add_payment"/>
              </td>
              <td>
                  联系电话
              </td>
              <td>
                  <input type="text"  class="easyui-numberbox" id="orders_add_phone" name="cphone"  data-options="prompt:'请输入正确的手机号码' , validType:'telNum'"  style="width:200px; height:24px;">
              </td>
          </tr>
          <tr>
              <td width="15%">
                  备注
              </td>
              <td width="500" colspan="3" height="">
                  <textarea name="remark" style="width: 95%" rows="4" cols="5"></textarea>
              </td>
          </tr>
          </tbody>
          <tfoot>
          <tr>
              <td>
                  &nbsp;
              </td>
              <td colspan="3">
                  <input id="orders_add_submit" type="button"
                         value="保存"/>
                  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  <input type="reset" value="取消"/>
              </td>
          </tr>
          </tfoot>
      </table>
  </form>
<script type="text/javascript">

    $(document).ready(function () {

        //做电话正则:如果说输入的电话号码不正确则给出提示,正确则不显示提示(添加，修改)
        $.extend($.fn.validatebox.defaults.rules, {
            telNum:{ //既验证手机号，又验证座机号
                validator: function(value, param){
                    return /(^(0[0-9]{2,3}\-)?([2-9][0-9]{6,7})+(\-[0-9]{1,4})?$)|(^((\d3)|(\d{3}\-))?(1[358]\d{9})$)/.test(value);
                },
                message: '请输入正确的电话号码'
            }
        });



        $("#orders_add_submit").click(function () {

            $('#orders_add_form').form('submit', {
                url:"${pageContext.request.contextPath}/orders/ordersAdd",
                onSubmit: function(){
                    // do some check
                    if(isNaN($("#orders_add_payment").val())){
                        $.messager.alert("系统信息","金额输入为浮点型")
                        return false;
                    }
                },
                success:function(data){
                    if(data==1) {
                        $.messager.alert("系统消息",'添加成功');
                    } else {
                        $.messager.alert("系统信息","添加失败,请重新添加");
                    }
                }
            });
        })
    })


</script>

</body>
</html>
