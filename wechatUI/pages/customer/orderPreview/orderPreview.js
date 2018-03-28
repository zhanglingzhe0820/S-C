var app = getApp();
Page({
  data: {
    openId: "",
    uncompleteOrder: [],
    completeOrder: []
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    //获得openid
    wx.login({
      success: function (res) {
        var js_code = res.code;
        wx.request({
          url: app.globalData.backendUrl + "getOpenId",
          header: {
            'content-type': 'application/x-www-form-urlencoded'
          },
          data: {
            "jsCode": js_code
          },
          method: 'POST',
          success: function (res) {
            //获得从后端获取认证信息
            if (res.data.length != 0) {
              that.setData({
                openId: res.data.openid
              })
              //从数据库获得所有订单
              wx.request({
                url: app.globalData.backendUrl + "getOrderByUser",
                method: "POST",
                header: {
                  'content-type': 'application/x-www-form-urlencoded'
                },
                data: {
                  wechatId: that.data.openId
                },
                success: function (res) {
                  var completeOrder = [];
                  var uncompleteOrder = [];
                  for (var i = 0; i < res.data.length; i++) {
                    var order = {
                      id: res.data[i].id,
                      hour: res.data[i].pickHour,
                      minute: res.data[i].pickMinute,
                      total: res.data[i].commodityTotal,
                      comment: res.data[i].comment,
                      food: res.data[i].foodList
                    };
                    if (res.data[i].confirmed == false) {
                      uncompleteOrder.push(order);
                    } else {
                      completeOrder.push(order);
                    }
                  }
                  that.setData({
                    uncompleteOrder: uncompleteOrder,
                    completeOrder: completeOrder
                  });
                }
              })
            }
          }
        })
      }
    })
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  },

  completeOrder: function (e) {
    var that = this;
    wx.request({
      url: app.globalData.backendUrl + "confirmOrder",
      method: "POST",
      header: {
        'content-type': 'application/x-www-form-urlencoded'
      },
      data: {
        orderId: e.target.id
      },
      success: function (res) {
        if (res.data == "Success") {
          wx.showToast({
            title: '取餐成功',
            icon: 'success',
            duration: 1000
          });
          that.onLoad();
        } else {
          wx.showToast({
            title: '系统繁忙',
            icon: 'warn',
            duration: 1000
          });
        }
      }
    })
  },

  deleteOrder: function (e) {
    var that = this;
    wx.request({
      url: app.globalData.backendUrl + "deleteOrder",
      method: "POST",
      header: {
        'content-type': 'application/x-www-form-urlencoded'
      },
      data: {
        orderId: e.target.id
      },
      success: function (res) {
        if (res.data == "Success") {
          wx.showToast({
            title: '删除成功',
            icon: 'success',
            duration: 1000
          });
          that.onLoad();
        } else {
          wx.showToast({
            title: '系统繁忙',
            icon: 'warn',
            duration: 1000
          });
        }
      }
    })
  }
})