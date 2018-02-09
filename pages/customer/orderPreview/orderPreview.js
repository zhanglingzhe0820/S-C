var app = getApp();
Page({
  data: {
    openId: "",
    uncompleteOrder: [
      {
        id: 2018020300001,
        hour: 11,
        minute: 20,
        total: 100,
        comment: "",
        food: [
          {
            position: "xxx-xxx",
            name: "包子",
            num: 5,
            price: 10
          },
          {
            position: "xxx-xxx",
            name: "狗粮",
            num: 5,
            price: 10
          }
        ],
      }
    ],
    completeOrder: [
      {
        id: 2018020300001,
        total: 100,
        comment: "",
        food: [
          {
            position: "xxx-xxx",
            name: "包子",
            num: 5,
            price: 10
          },
          {
            position: "xxx-xxx",
            name: "狗粮",
            num: 5,
            price: 10
          }
        ]
      }
    ]
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    //获得openid
    wx.login({
      success: function (res) {
        var appId = app.globalData.appID;
        var appSecret = app.globalData.appSecret;
        var js_code = res.code;
        wx.request({
          url: 'https://api.weixin.qq.com/sns/jscode2session?appid=' + appId + '&secret=' + appSecret + '&js_code=' + js_code + '&grant_type=authorization_code',
          data: {},
          method: 'GET',
          success: function (res) {
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

  completeOrder: function () {
    wx.showToast({
      title: '取餐成功',
      icon: 'success',
      duration: 3000
    });
  }
})