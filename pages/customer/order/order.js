// pages/customer/order/order.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    userInfo: "",
    commodityPrice: 9.50,
    orderPrice: 0.5,
    hour: 11,
    minute: 20
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    wx.getUserInfo({
      success: function (res) {
        var userInfo = res.userInfo;
        that.setData({
          userInfo: userInfo
        });
      }
    })

    wx.getStorageInfo({
      success: function (res) {
        var totalPrice = 0;
        for (var i = 0; i < res.keys.length; i++) {
          if (res.keys[i].indexOf("selected") == 0) {
            wx.getStorage({
              key: res.keys[i],
              success: function (subRes) {
                totalPrice += subRes.data.num * subRes.data.price;
                that.setData({
                  commodityPrice: totalPrice
                })
              }
            })
          }
        }
      },
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

  /**
   * 选择时间
   */
  chooseTime: function (e) {
    var hour = e.detail.value.split(":")[0];
    var minute = e.detail.value.split(":")[1];
    this.setData({
      hour: hour,
      minute: minute
    })
  },

  /**
   * 提交订单(mock)
   */
  submitOrder: function (e) {

  },

  /**
   * 返回主界面
   */
  backToIndex: function (e) {
    wx.switchTab({
      url: "../index/index",
    })
  }
})